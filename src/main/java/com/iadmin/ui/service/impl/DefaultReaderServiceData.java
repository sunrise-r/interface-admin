package com.iadmin.ui.service.impl;

import com.iadmin.ui.service.*;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.List;

public class DefaultReaderServiceData implements ReaderServiceData {

    protected final RegistryReaderFactory registryReaderFactory;

    protected final RegistryMergeService registryMergeService;

    private final RegistryAccessor registryAccessor;

    public DefaultReaderServiceData(RegistryReaderFactory registryReaderFactory, RegistryMergeService registryMergeService, List<Resource> resources, ResourceRepository resourceRepository) throws IOException {

        this.registryReaderFactory = registryReaderFactory;
        this.registryMergeService = registryMergeService;
        this.registryAccessor = resourceRepository.createRegistryAccessor(resources);

    }

    @Override
    public RegistryReaderFactory getRegistryReaderFactory() {
        return registryReaderFactory;
    }

    @Override
    public RegistryMergeService getRegistryMergeService() {
        return registryMergeService;
    }

    @Override
    public RegistryAccessor getRegistryAccessor() {
        return registryAccessor;
    }


}
