package com.iadmin.ui.service;

import com.iadmin.ui.exception.MergeException;
import com.iadmin.ui.model.BaseData;

import java.util.List;

/**
 * Интерфейс сервиса слияния объектов
 */
public interface RegistryMergeService {

    /**
     * Объеденяет два объекта согласно правилам слияния. Правила смотреть на wiki
     * @param obj1 Объект слияния
     * @param obj2 Объект слияния
     * @param <K> Тип объединяемых объектов
     * @return Результат объединения объектов.(Экземпляр класса создается заново)
     * @throws MergeException В случае ошибки слияния.(Не предвиденное правило e.t.c)
     */
    <K> K merge(K obj1, K obj2) throws MergeException;

    /**
     * Объеденить список объектов в один. Правила те же, что и для объединения двух объектов
     * @param entities Список объектов
     * @param <K> тип объектов
     * @return Результат объединения объектов
     * @throws MergeException В случае ошибки слияния.(Не предвиденное правило e.t.c)
     */
    <K> K merge(List<K> entities) throws MergeException;

    /**
     * Объединяет список с объектом. Работают те же правила, что и для списк
     * @param obj1 Объект для объединения
     * @param obj2 Список для объединения
     * @param <K> тип объединяемых объектов
     * @return Результат объединения списка и объекта
     * @throws MergeException В случае ошибки слияния.(Не предвиденное правило e.t.c)
     */
    <K> K merge(K obj1, List<K> obj2) throws MergeException;

    /**
     * Объединяет все реусрсы внутри списка с одинаковыми кодами в один ресурс
     * @param resources Список ресурсов
     * @param <T> Тип ресурсов
     * @return Список ресурсов объедененных согласно их коду.
     * @throws MergeException В случае ошибки слияния.(Не предвиденное правило e.t.c)
     */
    <T extends BaseData> List<T> mergeByCode(List<T> resources) throws MergeException;
}
