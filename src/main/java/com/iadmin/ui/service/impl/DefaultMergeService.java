package com.iadmin.ui.service.impl;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.iadmin.ui.exception.MergeException;
import com.iadmin.ui.model.BaseData;
import com.iadmin.ui.service.MergeHelper;
import com.iadmin.ui.service.MergeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Реализация сервиса слияния по умолчанию.
 */
@Service
public class DefaultMergeService implements MergeService {

    private final Logger log = LoggerFactory.getLogger(DefaultMergeService.class);

    private final MergeHelper mergeHelper;

    @Autowired
    public DefaultMergeService(MergeHelper mergeHelper) {
        this.mergeHelper = mergeHelper;
    }

    @Override
    public <K> K merge(K obj1, K obj2) throws MergeException {
        return mergeHelper.mergeObjects(obj1, obj2);
    }

    @Override
    public <K> K merge(List<K> entities) throws MergeException {
        if (entities.size() == 0) {
            log.error("Failed to merge empty list of objects, null will be returned");
            return null;
        }
        K current = entities.get(0);
        for (int i = 1; i < entities.size(); i++) {
            current = mergeHelper.mergeObjects(current, entities.get(i));
        }
        return current;
    }

    @Override
    public <K extends BaseData> Map<String, List<K>> groupByCode(List<K> models) {
        Map<String, List<K>> groupByCode = Maps.newHashMap();
        if(models == null){
            log.debug("no models was found");
            return groupByCode;
        }
        for (K b : models) {
            if (!groupByCode.containsKey(b.getCode())) {
                groupByCode.put(b.getCode(), Lists.newArrayList());
            }
            groupByCode.get(b.getCode()).add(b);
        }
        return groupByCode;
    }
}
