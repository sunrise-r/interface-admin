package com.iadmin.ui.service.impl;

import com.google.common.collect.Lists;
import com.iadmin.ui.exception.MergeException;
import com.iadmin.ui.service.MergeHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

@Service
public class DefaultMergeHelper implements MergeHelper {

    private final Logger log = LoggerFactory.getLogger(DefaultMergeHelper.class);

    @Override
    public <K> K mergeObjects(K obj1, K obj2) throws MergeException {
        if (obj1 == null && obj2 != null) {
            log.debug("one of the objects in merge are null(obj1) returnin obj2");
            return obj2;
        }
        if (obj1 != null && obj2 == null) {
            log.debug("one of the objects in merge are null(obj2) returnin obj1");
            return obj1;
        }
        if (obj1 == null && obj2 == null) {
            log.debug("All object are null, unable to merge null will be returned");
            return null;
        }
        Class<K> clazz = (Class<K>) obj1.getClass();
        K resultObj;
        try {
            resultObj = clazz.newInstance();
        } catch (Exception e) {
            log.error("Failed to merge objects");
            throw new MergeException(obj1, obj1, e);
        }
        if (!obj1.equals(obj2)) {
            log.info("Mering not equals classes {} and {}", obj1, obj2);
            if (List.class.isInstance(obj1) && List.class.isInstance(obj2)) {
                ((ArrayList) resultObj).addAll((List) obj1);
                ((ArrayList) resultObj).addAll((List) obj2);
                return resultObj;
            }
        }
        ReflectionUtils.doWithFields(obj1.getClass(), field -> {

            if (!(Modifier.isStatic(field.getModifiers()) && Modifier.isFinal(field.getModifiers()))) {
                ReflectionUtils.makeAccessible(field);
                Object val1 = field.get(obj1);
                Object val2 = field.get(obj2);
                Object result = null;
                if (val1 == null && val2 != null) {
                    result = val2;
                } else if (val1 != null && val2 == null) {
                    result = val1;
                } else if (val1 != null && val2 != null && !val1.equals(val2)) {
                    if (List.class.isInstance(val1) && List.class.isInstance(val2)) {
                        result = Lists.newArrayList();
                        ((ArrayList) result).addAll((List) val1);
                        ((ArrayList) result).addAll((List) val2);
                    }
                    log.error("Merge type on not equals object not suppoerted yet {} on {} and {} while merging {} with values val1={} and val2={}", obj1, obj2, field.getName(), val1, val2);
                } else if (val1 != null && val2 != null && val1.equals(val2)) {
                    result = val1;
                }
                ReflectionUtils.setField(field, resultObj, result);
            }
        });
        return resultObj;
    }
}
