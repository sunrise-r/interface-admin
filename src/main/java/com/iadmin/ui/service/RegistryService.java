package com.iadmin.ui.service;

import com.iadmin.ui.exception.MergeException;
import com.iadmin.ui.model.Registry;

import java.io.IOException;
import java.util.List;

/**
 * Сервис управления реестром интерфейсов
 */
public interface RegistryService {



    /**
     * Генерирует тестовый файл описания реестра интрфейсов.
     * Нужно что бы смотреть текущие возможности. Можно загрузить на сайте
     * @return Тестовый пример с описанием интерфейса
     */
    Registry createSampleUiRegistry();

    /**
     * Загрузить доступные реестры интерфейсов
     * На основании этих данных будет строиться пользовательскйи интерфейс
     * @return Список доступных реестров интерфейсов
     * @throws IOException Возникает при ошибке чтения ресусров
     * @throws MergeException Возникает при ошибке слияния объектов
     */
    List<Registry> loadRegistries() throws IOException, MergeException;


}
