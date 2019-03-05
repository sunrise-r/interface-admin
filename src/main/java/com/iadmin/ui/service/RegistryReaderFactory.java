package com.iadmin.ui.service;

import com.iadmin.ui.model.*;
import com.iadmin.ui.service.reader.base.ListReader;
import com.iadmin.ui.service.reader.base.UIReader;

import java.util.List;

/**
 * Интерфейс фабрики по созаднию  объектов для чтения ресурсов об интерфейсе.
 */
public interface RegistryReaderFactory {

    /**
     * Создать экземпляр читателя данных об  Рестрах интерфейсов iad
     *
     * @return Экземпляр читателя данных о реестре интерфейсов.
     */
    UIReader<List<Registry>> createUIRegistriesReader();

    /**
     * Создать экземпляр читателя данных о полях формы (fields.json)
     *
     * @param resources Ресурсы в которых следует искать файлы
     * @param source    Исходные данные на прямую полученные из файла.
     * @return Экземпляр читателя данных полей формы
     */
    ListReader<FormField> createFormFieldsReader(FormProjection source);

    ListReader<DataField> createDataFieldsReader(DataProjection source);

    /**
     * Создать экземпляр читателя данных о проекциях формы сущности
     *
     * @param source Исходные данные на прямую полученные из файла.
     * @return экземпляр читателя данных о проекциях формы
     */
    UIReader<FormProjection> createFormProjectionReader(FormProjection source);

    UIReader<DataProjection> createDataProjectionReader(DataProjection source);

    /**
     * Создать читатель полей для проекции списка
     *
     * @param resources Ресурсы в которых следует искать поля проекции списка
     * @param owner     Родителькая проекция
     * @return экземпляр читателя данных
     */
    ListReader<ListField> createListFieldsReader(ListProjection owner);

    /**
     * Создать читателя для поиска действих для проекции списка
     *
     * @param resources Ресурсы в которых следует искать действия проекции списка
     * @param owner     Родителькая проекция
     * @return экземпляр читателя данных
     */
    ListReader<Action> createActionsReader(ListProjection owner);

    /**
     * Создать экземпляр читателя проекций списков для представления
     *
     * @param resources Список ресурсов в которых искать описания проекций
     * @param source    Исходные данные
     * @return экземпляр читателя данных
     */
    UIReader<ListProjection> createListProjectionReader(ListProjection source);

    /**
     * Создать экземпляр читателе Настроек представления
     *
     * @param source Исходные данные
     * @return экземпляр читателя данных
     */
    UIReader<PresentationSettings> createPresentationSettingsReader(PresentationSettings source);

    /**
     * Создать экземпляр читателя списка настроек представления
     *
     * @param resources    Ресурсы из которых нужно будет читать
     * @param presentation Родительское представление
     * @return экземпляр читателя данных
     */
    ListReader<PresentationSettings> createPresentationSettingsListReader(Presentation presentation);

    /**
     * Создать экземпляр читателя списка доступных листовых проекций
     *
     * @param presentation Родительское представление
     * @return экземпляр читателя данных
     */
    ListReader<ListProjection> createListProjectionsReader(Presentation presentation);

    /**
     * Создать экземпляр читателя списка доступных проекций для формы ввода
     *
     * @param presentation Родительское представление
     * @return экземпляр читателя данных
     */
    ListReader<FormProjection> createFormProjectionsReader(Presentation presentation);

    ListReader<DataProjection> createDataProjectionsReader(Presentation presentation);

    /**
     * Создать экземпляр читателя доступных действий
     *
     * @param source Исходные данные
     * @return экземпляр читателя данных
     */
    UIReader<Action> createActionReader(Action source);


    /**
     * Создать экземпляр читателя доступных действий для представления
     *
     * @param resources    Ресурсы из которых нужно будет читать
     * @param presentation Родительское представление
     * @return экземпляр читателя данных
     */
    UIReader<List<Action>> createPresentationActionsReader(Presentation presentation);

    /**
     * Создать экземпляр читателя доступных представлений
     *
     * @param source Исходные данные
     * @return экземпляр читателя данных
     */
    UIReader<Presentation> createPresentationReader(Presentation source);

    /**
     * Создать экземпляр читателя доступных реестров интерфейса
     *
     * @param source Исходные данные
     * @return экземпляр читателя данных
     */
    UIReader<Registry> createUIRegistryReader(Registry source);

    /**
     * Создать экземпляр читателя представлений
     *
     * @return экземпляр читателя данных
     */
    ListReader<Presentation> createPresentationsReader();

    /**
     * Создать экземпляр читателя списка настроек представлений
     *
     * @return экземпляр читателя данных
     */
    ListReader<RegistrySettings> createUIRegistrySettingsListReader();

    /**
     * Создать экземпляр читателя списка настроек реестра
     *
     * @param source Исходные данные
     * @return экземпляр читателя данных
     */
    UIReader<RegistrySettings> createUIRegistrySettingsReader(RegistrySettings source);

    /**
     * Создать экземпляр читателя для поля списка
     *
     * @param source Исходные данные
     * @return экземпляр читателя данных
     */
    UIReader<ListField> createListFieldReader(ListField source);

    /**
     * Создать экземпляр читателя для поля формы
     *
     * @param source Исходные данные
     * @return экземпляр читателя данных
     */
    UIReader<FormField> createFormFieldReader(FormField source);

    UIReader<DataField> createDataFieldReader(DataField source);
}
