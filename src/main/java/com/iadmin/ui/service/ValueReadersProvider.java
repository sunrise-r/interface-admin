package com.iadmin.ui.service;

import com.iadmin.ui.model.BaseData;
import com.iadmin.ui.service.impl.ValueReader;

import java.util.List;

/**
 * Предоставляет доступ к информации доступных Экземплярах ValueReader и их кодах
 * Используются во время чтения данных из ресусров.
 * Коды считывателей так же используется для группировки данных
 */
public interface ValueReadersProvider {

    /**
     * Создать список доступных ValueReader
     * @return Список доступных считывателей ресусров
     */
    List<ValueReader<? extends BaseData>> createReaders();

    /**
     *
     * @return Код считывателя данных для Ригистров интерфейса
     */
    String getRegistry();

    /**
     *
     * @return Код считывателя данных настроек регистра инетрфейса.
     */
    String getRegistrySettings();

    /**
     *
     * @return Код считывателея доступных дейсвтий
     */
    String getAction();

    /**
     *
     * @return Код считывателя доступных полей форм
     */
    String getFormField() ;

    /**
     *
     * @return Код считывателя доступных проекций
     */
    String getFormProjection();

    /**
     *
     * @return код считывателя достпных полей списка
     */
    String getListField() ;

    /**
     *
     * @return Код считывателя достпных проекций списков
     */
    String getListProjection();

    /**
     *
     * @return Код считывателя достпных Представлений
     */
    String getPresentation();

    /**
     *
     * @return Код считывателя доступных настроек представлений.
     */
    String getPresentationSetting();

    String getDataProjection();

    String getDataField();
}
