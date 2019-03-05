package com.iadmin.ui.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import com.iadmin.ui.model.BaseData;
import com.iadmin.ui.model.FormProjection;
import com.iadmin.ui.model.ListProjection;
import com.iadmin.ui.model.Presentation;
import com.iadmin.ui.service.RegistryAccessor;
import com.iadmin.ui.service.ValueReadersProvider;
import org.junit.Before;
import org.junit.Test;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class DefaultRegistryAccessorTest {

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
    public void getUIRegistries() throws Exception {
        Map<String, List<BaseData>> data = defaultValueReaderService.getReadersMap(Lists.newArrayList(adminResources));
        RegistryAccessor accessor = new DefaultRegistryAccessor(provider, data);
        Presentation pressentation = accessor.getPresentations().get(0);
        FormProjection formProjection = accessor.getFormProjections(pressentation).get(0);
        ListProjection listProjection = accessor.getListProjections(pressentation).get(0);
        assertNotNull(formProjection);
        assertNotNull(pressentation);
        assertNotNull(listProjection);
        assertEquals(1, accessor.getUIRegistries().size());
        assertEquals(1, accessor.getUIRegistrySettings().size());
        assertEquals(1, accessor.getPresentations().size());
        assertEquals(1, accessor.getActions(pressentation).size());
        assertEquals(1, accessor.getActions(listProjection).size());
        assertEquals(1, accessor.getFormFields(formProjection).size());
        assertEquals(1, accessor.getListFields(listProjection).size());
    }
}
