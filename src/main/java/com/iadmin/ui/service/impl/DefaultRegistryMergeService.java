package com.iadmin.ui.service.impl;

import com.google.common.collect.Lists;
import com.iadmin.ui.exception.MergeException;
import com.iadmin.ui.model.BaseData;
import com.iadmin.ui.service.MergeService;
import com.iadmin.ui.service.RegistryMergeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DefaultRegistryMergeService implements RegistryMergeService {

    private final Logger log = LoggerFactory.getLogger(DefaultRegistryMergeService.class);

    private final MergeService mergeService;

    @Autowired
    public DefaultRegistryMergeService(MergeService mergeService) {
        this.mergeService = mergeService;
    }

    @Override
    public <K> K merge(K obj1, K obj2) throws MergeException {
        return mergeService.merge(obj1, obj2);
    }

    @Override
    public <K> K merge(List<K> entities) throws MergeException {
        return mergeService.merge(entities);
    }

    @Override
    public <K> K merge(K obj1, List<K> obj2) throws MergeException {
        List<K> temp = Lists.newArrayList(obj2);
        temp.add(obj1);
        return mergeService.merge(temp);
    }

    @Override
    public <T extends BaseData> List<T> mergeByCode(List<T> models) throws MergeException {
        List<T> result = Lists.newArrayList();
        Map<String, List<T>> groupByCode = mergeService.groupByCode(models);
        for (String code : groupByCode.keySet()) {
            result.add(mergeService.merge(groupByCode.get(code)));
        }
        return result;
    }
}
