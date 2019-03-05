package com.iadmin.ui.service;

import com.google.common.collect.Lists;
import com.iadmin.ui.model.*;
import com.iadmin.ui.service.impl.DefaultRegistryService;
import com.iadmin.ui.service.impl.DefaultResourceService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.core.io.Resource;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DefaultRegistryServiceTest {

    @InjectMocks
    private DefaultRegistryService defaultRegistryService;
    @Mock
    private DefaultResourceService defaultResourceService;

    @Test
    public void loadUIRegistries() throws Exception {
        Registry registry = new Registry();
        List<Registry> expectedResult = Lists.newArrayList(registry);
        Resource data = mock(Resource.class);
        List<Resource> resources = Lists.newArrayList(data);
        String path = "path";
        List<String> scanPaths = Lists.newArrayList(path);
        when(defaultResourceService.read(resources)).thenReturn(expectedResult);
        when(defaultResourceService.getResources(scanPaths)).thenReturn(resources);
        when(defaultResourceService.getScanPath()).thenReturn(scanPaths);
        List<Registry> result = defaultRegistryService.loadRegistries();
        assertEquals(expectedResult, result);
    }

    @Test
    public void createSampleUiRegistry() {
        Registry registry = defaultRegistryService.createSampleUiRegistry();
        assertNotNull(registry.getPresentations());
        assertNotNull(registry.getSettings());
        assertTrue(registry.getSettings().isEnabled());
        assertNotNull(registry.getCode());
        assertNotNull(registry.getLabel());
        assertTrue(registry.getPresentations().size() > 0);
        checkPresentations(registry);
    }

    private void checkPresentations(Registry registry) {
        for (Presentation p : registry.getPresentations()) {
            assertNotNull(p.getActions());
            assertNotNull(p.getFormProjections());
            assertNotNull(p.getProjections());
            assertNotNull(p.getSettings());
            assertTrue(p.getSettings().isEnabled());
            assertNotNull(p.getCode());
            assertNotNull(p.getLabel());
            assertTrue(p.getActions().size() > 0);
            for (Action a : p.getActions()) {
                assertNotNull(a.getDisplayType());
                assertNotNull(a.getCode());
                assertNotNull(a.getLabel());
            }
            assertTrue(p.getFormProjections().size() > 0);
            for (FormProjection formProjection : p.getFormProjections()) {
                assertNotNull(formProjection.getFields());
                assertNotNull(formProjection.getCode());
                assertNotNull(formProjection.getDescription());
                assertNotNull(formProjection.getDisplayType());
                assertNotNull(formProjection.getLabel());
                assertTrue(formProjection.getFields().size() > 0);
                for (FormField fm : formProjection.getFields()) {
                    assertNotNull(fm.getCode());
                    assertNotNull(fm.getDisplayFormat());
                    assertNotNull(fm.getLabel());
                }
            }
            assertTrue(p.getProjections().size() > 0);
            for (ListProjection lp : p.getProjections()) {
                assertNotNull(lp.getCode());
                assertNotNull(lp.getDescription());
                assertNotNull(lp.getDisplayType());
                assertNotNull(lp.getLabel());
                assertNotNull(lp.getFields());
                for (ListField lf : lp.getFields()) {
                    assertNotNull(lf.getCode());
                    assertNotNull(lf.getDisplayFormat());
                    assertNotNull(lf.getLabel());
                }
            }

        }
    }


}
