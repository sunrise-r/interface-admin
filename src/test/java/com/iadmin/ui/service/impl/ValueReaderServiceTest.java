package com.iadmin.ui.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import com.iadmin.ui.model.*;
import com.iadmin.ui.service.RegistryAccessor;
import com.iadmin.ui.service.ValueReadersProvider;
import org.junit.Before;
import org.junit.Test;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class ValueReaderServiceTest {

    PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
    DefaultValueReaderService defaultValueReaderService;
    ValueReadersProvider provider = new DefaultValuesReaderProvider(new ObjectMapper());
    private Resource[] adminResources;

    @Before
    public void before() throws IOException {
        defaultValueReaderService = new DefaultValueReaderService(provider);
        adminResources = resolver.getResources("classpath:iad/valuereadertest/**/*.json");
    }

    @Test
    public void getReaderMap() throws IOException {
        Map<String, List<BaseData>> result = defaultValueReaderService.getReadersMap(Lists.newArrayList(adminResources));
        assertEquals(11, result.size());

        assertTrue(result.containsKey(Registry.class.getSimpleName()));
        assertEquals(1, result.get(Registry.class.getSimpleName()).size());

        assertTrue(result.containsKey(RegistrySettings.class.getSimpleName()));
        assertEquals(1, result.get(RegistrySettings.class.getSimpleName()).size());

        assertTrue(result.containsKey(Presentation.class.getSimpleName()));
        assertEquals(1, result.get(Presentation.class.getSimpleName()).size());

        assertTrue(result.containsKey(PresentationSettings.class.getSimpleName()));
        assertEquals(1, result.get(PresentationSettings.class.getSimpleName()).size());

        assertTrue(result.containsKey(Action.class.getSimpleName()));
        assertEquals(2, result.get(Action.class.getSimpleName()).size());

        assertTrue(result.containsKey(FormProjection.class.getSimpleName()));
        assertEquals(1, result.get(FormProjection.class.getSimpleName()).size());

        assertTrue(result.containsKey(ListProjection.class.getSimpleName()));
        assertEquals(1, result.get(ListProjection.class.getSimpleName()).size());

        assertTrue(result.containsKey(FormField.class.getSimpleName()));
        assertEquals(1, result.get(FormField.class.getSimpleName()).size());

        assertTrue(result.containsKey(ListField.class.getSimpleName()));
        assertEquals(1, result.get(ListField.class.getSimpleName()).size());

        assertEquals(2, result.get(Action.class.getSimpleName()).size());
    }

    @Test
    public void createRegistryAccessor() throws IOException {
        Map<String, List<BaseData>> data = defaultValueReaderService.getReadersMap(Lists.newArrayList(adminResources));
        RegistryAccessor accessor = defaultValueReaderService.createRegistryAccessor(data);
        assertNotNull(accessor);
    }
}
