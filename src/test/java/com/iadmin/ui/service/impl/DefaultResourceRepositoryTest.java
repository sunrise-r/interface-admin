package com.iadmin.ui.service.impl;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.iadmin.ui.model.BaseData;
import com.iadmin.ui.service.RegistryAccessor;
import com.iadmin.ui.service.RegistryMergeService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DefaultResourceRepositoryTest {

    Resource[] resources = null;
    Resource[] adminResources = null;
    PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();

    @InjectMocks
    private DefaultResourceRepository defaultRegistryRepository;

    @Mock
    private DefaultValueReaderService defaultValueReaderService;

    @Mock
    private RegistryAccessor reader;

    @Before
    public void initialize() throws IOException {
        resources = resolver.getResources("classpath:iad/**/*.json");
        adminResources = resolver.getResources("classpath:iad/admin/**/*.json");
    }

    @Test
    public void groupByRootPath() throws IOException {
        Map<String, List<Resource>> result = defaultRegistryRepository.groupByRootPath(Lists.newArrayList(resources));
        assertTrue(result.containsKey("admin"));
        assertTrue(result.containsKey("valuereadertest"));
        assertTrue(result.get("admin").size() == 3);
        assertTrue(result.get("valuereadertest").size() == 10);
    }

    @Test
    public void createRegistryAccessor() throws IOException {
        List<Resource> resources = Lists.newArrayList(adminResources);
        Map<String, List<BaseData>> groupedMap = Maps.newHashMap();
        when(defaultValueReaderService.getReadersMap(resources)).thenReturn(groupedMap);
        when(defaultValueReaderService.createRegistryAccessor(groupedMap)).thenReturn(reader);
        RegistryAccessor registryAccessor = defaultRegistryRepository.createRegistryAccessor(resources);
        assertEquals(reader, registryAccessor);
    }

    @Test
    public void createRegistryReaderFactory() throws IOException {
        RegistryMergeService mergeService = null;
        assertNotNull(defaultRegistryRepository.createRegistryReaderFactory(mergeService, Lists.newArrayList(resources)));
    }

}

