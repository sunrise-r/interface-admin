package com.iadmin.ui.service.dto;

import com.google.common.collect.Lists;
import com.iadmin.ui.service.ResourceReader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Service
public class DefaultResourceReader implements ResourceReader, Serializable{

    private final ResourcePatternResolver patternResolver;

    public DefaultResourceReader(ResourcePatternResolver patternResolver) {
        this.patternResolver = patternResolver;
    }

    @Override
    public List<Resource> getResources(List<String> scanPaths) throws IOException {
        List<Resource> resources = Lists.newArrayList();
        for (String path : scanPaths) {
            resources.addAll(Arrays.asList(patternResolver.getResources(path)));
        }
        return resources;
    }
}
