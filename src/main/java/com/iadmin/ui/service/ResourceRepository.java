package com.iadmin.ui.service;

import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Репозиторий для рабты с ресурсами описани интерфейса
 */
public interface ResourceRepository {

    /**
     * Сортировать ресусры по название рутовой директории(после дериктории iad).
     *
     * @param resources Список ресурсов который нужно распределеить
     * @return Список ресурсов сгруппированных по директории Registry
     */
    Map<String, List<Resource>> groupByRootPath(List<Resource> resources) throws IOException;

    /**
     * Создать экземпляр объекта обеспечивающего доступ к ресусрам
     * @param resources Список доступных ресурсов
     * @return Объект доступа до ресурсов
     * @throws IOException Возникает если возникла ошибка при чтении данных из ресурсов
     */
    RegistryAccessor createRegistryAccessor(List<Resource> resources) throws IOException;

    /**
     * Создать фабрику по созданию читалей ресусров реестра интефрейсов
     * @param registryMergeService Сервис слияния данных реестра интерфейсов
     * @param resources Ресурсы реестра интерфейсов
     * @return Фабрика по созданию читателей реестров интерфейсов
     */
    RegistryReaderFactory createRegistryReaderFactory(RegistryMergeService registryMergeService, List<Resource> resources) throws IOException;
}
