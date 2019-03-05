package com.iadmin.ui.service;

import com.iadmin.ui.exception.MergeException;
import com.iadmin.ui.model.Registry;

import java.io.IOException;
import java.util.List;

/**
 * Управление, доступ, загрузка в память описаниев реестров.
 */
public interface RegistryManager {

    /**
     * Перезагрузить все доступные реестры интерфейсов
     * @return  Колличество перезагруженных реестров интерфейсов
     */
    int reload() throws IOException, MergeException;

    /**
     * Получить информаци по реестру интерфейсов с кодом @id
     * @param code Код реестра интерфейса
     * @return Информация по реестру интерфейса.
     */
    Registry findOne(String code) throws IOException, MergeException;

    /**
     * Получить все доступные описания интерфейсов
     * Эти данные должны быть использованы для построения пользовательского интерфейса
     * @return Список доступных реестров интерфейсов
     * @throws IOException Возникает при ошибке чтения ресусров
     * @throws MergeException Возникает при ошибке слияния объектов
     */
    List<Registry> getRegistries() throws IOException, MergeException;
}
