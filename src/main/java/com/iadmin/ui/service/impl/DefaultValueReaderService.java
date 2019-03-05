package com.iadmin.ui.service.impl;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.iadmin.ui.model.BaseData;
import com.iadmin.ui.service.RegistryAccessor;
import com.iadmin.ui.service.ValueReadersProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Сервис для обеспечения работы ValueReader
 */
@Service
public class DefaultValueReaderService {

    private static final Logger log = LoggerFactory.getLogger(DefaultValueReaderService.class);
    private final ValueReadersProvider provider;


    public DefaultValueReaderService(ValueReadersProvider provider) {
        this.provider = provider;
    }

    public RegistryAccessor createRegistryAccessor(Map<String, List<BaseData>> groupedData) {
        return new DefaultRegistryAccessor(provider, groupedData);
    }

    /**
     * Сгруппировать ресурсы по типу сущности которые они описывают
     *
     * @param resources Входные ресурсы
     * @return Сгруппированные ресусрсы в виде Map, где ключем является ключ сущности(Название класса).
     * @throws IOException В случае если не удалось прочитать ресурс
     */
    public Map<String, List<BaseData>> getReadersMap(List<Resource> resources) throws IOException {
        Map<String, List<BaseData>> groupedData;
        groupedData = Maps.newHashMap();
        List<ValueReader<? extends BaseData>> valueReaders = provider.createReaders();
        for (ValueReader valueReader : valueReaders) {
            groupedData.put(valueReader.getEntityKey(), Lists.newArrayList());
        }
        for (Resource r : resources) {
            boolean added = false;

            for (ValueReader<? extends BaseData> valueReader : valueReaders) {
                BaseData result = valueReader.read(r.getURL().getFile(),r.getInputStream());
                if (result != null) {
                    groupedData.get(valueReader.getEntityKey()).add(result);
                    added = true;
                    break;
                }
            }
            if (!added) {
                log.warn("Failed to read reasource. Resource={}", r);
            }
        }
        return groupedData;
    }
}
