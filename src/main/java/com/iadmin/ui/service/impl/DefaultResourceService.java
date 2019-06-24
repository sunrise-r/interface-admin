package com.iadmin.ui.service.impl;

import com.google.common.collect.Lists;
import com.iadmin.ui.exception.MergeException;
import com.iadmin.ui.model.Registry;
import com.iadmin.ui.service.*;
import com.iadmin.ui.service.inheritance.ExtendService;
import com.iadmin.ui.service.reader.ReferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Сервис по работе с ресурсами. Содержит методы которые позвляют организовать разбор данных об интерфейсе
 */
@Service
public class DefaultResourceService implements ResourceService {

    private static final String DEFAULT_SCAN_PATH = "classpath:iad/**/*.json";

    private final ResourcePatternResolver patternResolver;

    private final ResourceRepository resourceRepository;

    private final RegistryMergeService registryMergeService;

    private final ExtendService extendService;

    private final ReferenceService referenceService;

    @Autowired
    public DefaultResourceService(ResourceRepository resourceRepository,
                                  RegistryMergeService registryMergeService,
                                  ResourcePatternResolver patternResolver,
                                  ExtendService extendService,
                                  ReferenceService referenceService) {
        this.resourceRepository = resourceRepository;
        this.registryMergeService = registryMergeService;
        this.patternResolver = patternResolver;
        this.extendService = extendService;
        this.referenceService = referenceService;
    }

    /**
     * Найти все ресурсы которые описывают интерфейс
     *
     * @param scanPaths Пути сканирования ресурсов
     * @return Список ресурсов доступных для формирования описания пользовательского интерфейса
     * @throws IOException
     */
    @Override
    public List<Resource> getResources(List<String> scanPaths) throws IOException {
        List<Resource> resources = Lists.newArrayList();
        for (String path : scanPaths) {
            resources.addAll(Arrays.asList(patternResolver.getResources(path)));
        }
        return resources;
    }

    /**
     * Определить все пути по которым нужно производить сканирование.
     * Метод используется для определения путей по которым необходимо провести сканирование ресурсов, которые содержат описание ui интерфейса
     *
     * @return Список путей по которым лежат файлы json с описанием интерфейса.
     */
    @Override
    public List<String> getScanPath() {
        return Lists.newArrayList(DEFAULT_SCAN_PATH);
    }

    //TODO : this method needs integration tests
    /**
     * Прочитать из ресурсов информацию об Реестрах интерфейса
     *
     * @param resources реусры содержащие информацию об реестрах интерфейса
     * @return Список найденных в ресурсах реестров интерфейсов.
     */
    @Override
    public List<Registry> read(List<Resource> resources) throws IOException, MergeException {
        Map<String, List<Resource>> grouped = resourceRepository.groupByRootPath(resources);
        List<Registry> result = Lists.newArrayList();
        for (String key : grouped.keySet()) {
            RegistryReaderFactory registryReaderFactory = resourceRepository.createRegistryReaderFactory(registryMergeService, grouped.get(key));
            result.addAll(registryReaderFactory.createUIRegistriesReader().read());
        }
        List<Registry> registries = extendService.applyInheritance(result);
        registries.stream().filter(referenceService::containReferences).forEach(r -> {
            r.getPresentationReferences().stream()
                    .map(ref -> referenceService.getReference(ref, registries))
                    .filter(p -> p.isPresent())
                    .forEach(p -> r.getPresentations().add(p.get()));
        });
        return registries;
    }
}
