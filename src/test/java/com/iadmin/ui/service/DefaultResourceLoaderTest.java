package com.iadmin.ui.service;

import com.google.common.collect.Lists;
import com.iadmin.ui.service.dto.DefaultResourceReader;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DefaultResourceLoaderTest {

    @Mock
    private ResourcePatternResolver patternResolver;

    @InjectMocks
    private DefaultResourceReader defaultResourceLoader;


    @Test
    public void getResources() throws Exception {
        List<String> paths = Lists.newArrayList("path1", "path2");
        Resource[] resource1 = DefaultResourceServiceTest.createResources(10).toArray(new Resource[0]);
        for (String s : paths) {
            when(patternResolver.getResources(eq(s))).thenReturn(resource1);
        }
        List<Resource> result = defaultResourceLoader.getResources(paths);
        assertEquals(20, result.size());
        verify(patternResolver, atLeastOnce()).getResources(paths.get(0));
        verify(patternResolver, atLeastOnce()).getResources(paths.get(1));
    }
}
