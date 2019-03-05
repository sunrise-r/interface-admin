package com.iadmin.ui.service.impl;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.iadmin.ui.model.BaseData;
import com.iadmin.ui.service.RegistryAccessor;
import com.iadmin.ui.service.RegistryMergeService;
import com.iadmin.ui.service.RegistryReaderFactory;
import com.iadmin.ui.service.ResourceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
public class DefaultResourceRepository implements ResourceRepository {

    private final Logger log = LoggerFactory.getLogger(DefaultResourceRepository.class);

    private final DefaultValueReaderService defaultValueReaderService;

    public DefaultResourceRepository(DefaultValueReaderService defaultValueReaderService) {
        this.defaultValueReaderService = defaultValueReaderService;
    }

    @Override
    public Map<String, List<Resource>> groupByRootPath(List<Resource> resources) {
        Map<String, List<Resource>> result = Maps.newHashMap();
        for (Resource resource : resources) {
            String name = null;
            String resPath = this.getPath(resource);
            if (resPath != null) {
                Integer index = resPath.indexOf("iad");
                if (index > 0) {
                    String path = resPath.substring(index + 4);
                    int hasMore = path.indexOf("/");
                    if (hasMore > 0) {
                        name = path.substring(0, hasMore);
                    } else {
                        name = path;
                    }
                }
                if (name == null) {
                    log.warn("Failed to get root name of UIRegistry for resource with uri={}", resPath);
                    continue;
                }

                if (!result.containsKey(name)) {
                    result.put(name, Lists.newArrayList());
                }
                result.get(name).add(resource);
            } else {
                log.warn("Failed to resolve path to resource={}", resource);
            }
        }
        return result;
    }

    private String getPath(Resource resource) {
        String result;
        try {
            result = resource.getURL().getPath();
            if (result == null) {
                result = resource.getURI().getPath();
            }
        } catch (Exception ex) {
            return null;
        }
        return result;
    }

    /**
     * Создать объект доступа к ресурсам Registry
     *
     * @param resources Список доступных исходных ресурсов для обработки
     * @return Объект доступа к ресурсам
     * @throws IOException В случаее ошибки чтения ресураса.
     */
    @Override
    public RegistryAccessor createRegistryAccessor(List<Resource> resources) throws IOException {
        final Map<String, List<BaseData>> groupedData;
        groupedData = defaultValueReaderService.getReadersMap(resources);
        return defaultValueReaderService.createRegistryAccessor(groupedData);
    }

    @Override
    public RegistryReaderFactory createRegistryReaderFactory(RegistryMergeService registryMergeService, List<Resource> resources) throws IOException {
        return new DefaultRegistryReaderFactory(this, registryMergeService, resources);
    }


}
