package com.iadmin.ui.service;

import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.List;

public interface ResourceReader {

    /**
     * Получить список доступных ресурсов по указанным путям
     * @param scanPaths Пути по которым следует искать ресурсы
     * @return Список доступных найденных ресурсов
     * @throws IOException В случае ошибки чтения ресурса
     */
    List<Resource> getResources(List<String> scanPaths) throws IOException;
}
