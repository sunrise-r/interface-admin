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
