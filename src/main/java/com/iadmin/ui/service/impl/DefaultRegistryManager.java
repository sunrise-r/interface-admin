package com.iadmin.ui.service.impl;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.iadmin.ui.exception.MergeException;
import com.iadmin.ui.model.Registry;
import com.iadmin.ui.service.RegistryManager;
import com.iadmin.ui.service.RegistryService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
public class DefaultRegistryManager implements RegistryManager {

    private final RegistryService registryService;
    private final Map<String, Registry> registryMap;

    private boolean initialized;

    public DefaultRegistryManager(RegistryService registryService) {
        this.registryService = registryService;
        initialized = false;
        registryMap = Maps.newHashMap();
    }

    @Override
    public int reload() throws IOException, MergeException {
        return loadData(false);
    }

    @Override
    public Registry findOne(String code) throws IOException, MergeException {
        loadData(initialized);
        return this.registryMap.get(code);
    }

    @Override
    public List<Registry> getRegistries() throws IOException, MergeException {
        loadData(initialized);
        return Lists.newArrayList(registryMap.values());
    }
    /**
     * Загрузить все реестры интерфейсов в память.
     * @param initialized Текущее состояние загрузки(инициализировано или нет) Если истина то загрузка происходитьл не будет, иначе ресурсы будут перезагружены
     * @return Колличество загруженных в память реестров
     */
    private int loadData(boolean initialized) throws IOException, MergeException {
        if (initialized) return 0;
        registryMap.clear();
        List<Registry> registries = registryService.loadRegistries();
        for (Registry registry : registries) {
            registryMap.put(registry.getCode(), registry);
        }
        this.initialized = true;
        return this.registryMap.size();
    }
}
