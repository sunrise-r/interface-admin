package com.iadmin.ui.service;

/**
 * Данные для создания объектов чтения данных(reader)
 * Инкапсулирует в себе нужные сервисы
 */
public interface ReaderServiceData {

    /**
     * Фабрика по созданию объектов чтения данных из ресурсов
     *
     * @return Фабрика объектов чтения данных
     */
    RegistryReaderFactory getRegistryReaderFactory();

    /**
     * Сервис объединеия данных. Испольузется что бы объедениять множесственные данные в одно
     *
     * @return сервис объединения данных
     */
    RegistryMergeService getRegistryMergeService();

    /**
     * Объект доступа к ресурсам
     * @return Объект который обеспеивает доступ к ресурсам
     */
    RegistryAccessor getRegistryAccessor();

}
