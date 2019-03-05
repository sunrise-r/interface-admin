package com.iadmin.ui.service;

import com.iadmin.ui.model.*;

import java.util.List;

/**
 * Сервис доступа до данных реестра интерфейсов
 */
public interface RegistryAccessor {

    /**
     * Получить список доступных данных об Реестре инфрейса
     * @return список доступных описаний реестра интерфйейса
     */
    List<Registry> getUIRegistries();

    /**
     * Получить все доступные описания RegistrySettings.
     *
     * @return Список достпных RegistrySettings
     */
    List<RegistrySettings> getUIRegistrySettings();

    /**
     * Получить список доступных представлений
     *
     * @return Список доступных представлений
     */
    List<Presentation> getPresentations();

    /**
     * Получить доступные настройки для презентации @presentation
     *
     * @param presentation Перезентация для которой запрашиваются настройки.
     * @return Список доступных настроек презентации.
     */
    List<PresentationSettings> getPresentationSettings(Presentation presentation);

    /**
     * Получить список доступных ListProjection для презентации
     *
     * @param presentation презнтация сущности для которой нужно получить список презентаций
     * @return Список доступных ListProjection для презентации @presentation
     */
    List<ListProjection> getListProjections(Presentation presentation);


    /**
     * Получить список доступных полей форм для проекции @formProjection
     *
     * @param formProjection проекция формы для который формируется псписок полей.
     * @return Список полей проекци @formProjection
     */
    List<FormField> getFormFields(FormProjection formProjection);

    List<DataField> getDataFields(DataProjection dataProjection);

    /**
     * Получить список проекций для форм
     *
     * @param presentation Перезентация для которой запрашивается список проекций.
     * @return Список прокеций для презентации @presentation
     */
    List<FormProjection> getFormProjections(Presentation presentation);

    List<DataProjection> getDataProjections(Presentation presentation);

    /**
     * Получить список полей для отображения проекции
     *
     * @param listProjection Проекция для которой запрашивается список полей.
     * @return Список полей для проекции @listProjection
     */
    List<ListField> getListFields(ListProjection listProjection);

    /**
     * Получить список действий
     *
     * @param parentData Родительская сущность
     * @return Список доступных действий для проекции
     */
    List<Action> getActions(BaseData parentData);
}
