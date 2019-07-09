package com.iadmin.ui.service;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.iadmin.ui.model.Registry;
import com.iadmin.ui.service.impl.DefaultResourceService;
import com.iadmin.ui.service.inheritance.ExtendService;
import com.iadmin.ui.service.reader.ReferenceService;
import com.iadmin.ui.service.reader.base.UIReader;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.core.io.Resource;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class DefaultResourceServiceTest {

    @Mock
    ResourceReader resourceLoader;

    @Mock
    private ExtendService extendService;

    @Mock
    private ResourceRepository resourceRepository;

    @Mock
    private RegistryMergeService registryMergeService;

    @Mock
    private ReferenceService referenceService;

    @InjectMocks
    private DefaultResourceService defaultResourceService;

    @Captor
    private ArgumentCaptor<List<Registry>> registryListCaptor;

    public static List<Resource> createResources(int count) {

        List<Resource> resources = Lists.newArrayListWithCapacity(count);
        for (int i = 0; i < count; i++) {
            Resource r = mock(Resource.class);
            resources.add(r);
        }
        return resources;
    }

    @Test
    public void getScanPath() {
        List<String> scanPaths = defaultResourceService.getScanPath();
        assertEquals("classpath:iad/**/*.json", scanPaths.get(0));
    }

    @Test
    public void read() throws Exception {
        List<Resource> resources = createResources(10);
        List<Resource> resources1 = createResources(10);
        List<Resource> resources2 = createResources(10);
        Map<String, List<Resource>> map = Maps.newHashMap();
        map.put("key1", resources1);
        map.put("key2", resources2);
        when(resourceRepository.groupByRootPath(resources)).thenReturn(map);
        RegistryReaderFactory factory = mock(RegistryReaderFactory.class);
        UIReader<List<Registry>> registriesReader = mock(UIReader.class);
        Registry registry = new Registry();
        registry.setCode("code");
        List<Registry> registries = Lists.newArrayList(registry);
        when(registriesReader.read()).thenReturn(registries);
        when(factory.createUIRegistriesReader()).thenReturn(registriesReader);
        when(resourceRepository.createRegistryReaderFactory(registryMergeService, resources1)).thenReturn(factory);
        when(resourceRepository.createRegistryReaderFactory(registryMergeService, resources2)).thenReturn(factory);
        when(extendService.applyInheritance(anyList())).thenAnswer(f -> f.getArguments()[0]);
        List<Registry> result = defaultResourceService.read(resources);
        verify(extendService, times(1)).applyInheritance(registryListCaptor.capture());
        Assert.assertEquals(2, result.size());
        Assert.assertEquals(registry, result.get(0));
        Assert.assertEquals(registry, result.get(1));
    }

}
