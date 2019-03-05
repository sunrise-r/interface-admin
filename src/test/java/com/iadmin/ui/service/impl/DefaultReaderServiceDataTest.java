package com.iadmin.ui.service.impl;

import com.google.common.collect.Lists;
import com.iadmin.ui.service.RegistryAccessor;
import com.iadmin.ui.service.RegistryMergeService;
import com.iadmin.ui.service.RegistryReaderFactory;
import com.iadmin.ui.service.ResourceRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DefaultReaderServiceDataTest {

    private DefaultReaderServiceData defaultReaderServiceData;

    @Mock
    private RegistryReaderFactory factory;

    @Mock
    private RegistryMergeService mergeService;

    @Mock
    private ResourceRepository resourceRepository;

    @Mock
    private RegistryAccessor registryAccessor;

    private List<Resource> resources = Lists.newArrayList();

    @Before
    public void initialize() throws IOException {
        when(resourceRepository.createRegistryAccessor(resources)).thenReturn(registryAccessor);
        defaultReaderServiceData = new DefaultReaderServiceData(factory, mergeService, resources, resourceRepository);
    }

    @Test
    public void getRegistryReaderFactory() {
        assertEquals(factory, defaultReaderServiceData.getRegistryReaderFactory());
    }

    @Test
    public void getRegistryMergeService() {
        assertEquals(mergeService, defaultReaderServiceData.getRegistryMergeService());
    }

    @Test
    public void getRegistryAccessor() {
        assertEquals(registryAccessor, defaultReaderServiceData.getRegistryAccessor());
    }

}
