package com.iadmin.ui.service;

import com.iadmin.ui.exception.MergeException;
import com.iadmin.ui.model.Registry;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.List;

/**
 * Сервис работы с ресурсами реестра интерфейсов
 */
public interface ResourceService {

    /**
     * Получить список доступных ресурсов для реестра интерфейсов
     * @param scanPaths Пути по которым следует искать описание реестров интерфейсов
     * @return Список доступных ресурсов для чтения информации о реестре интерфейсова
     * @throws IOException В случае ошибки чтения ресурса
     */
    List<Resource> getResources(List<String> scanPaths) throws IOException;

    /**
     * Получить доступные для сканирования пути для поиска информации о реестре интерфейсов
     * @return Список доступных путей для сканирования
     */
    List<String> getScanPath();

    /**
     * Загрузить список доступных реестров интерфейсов
     * @param resources Ресурсы из которых загружается реестр интерфейсов
     * @return Список доступных реестров интерфейсов
     * @throws IOException В случае ошибки чтения ресурса
     * @throws MergeException В случае ошибки слияния ресусров.
     */
    List<Registry> read(List<Resource> resources) throws IOException, MergeException;
}
