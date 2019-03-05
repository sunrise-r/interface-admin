package com.iadmin.ui.service;

import com.iadmin.ui.exception.MergeException;
import com.iadmin.ui.model.BaseData;

import java.util.List;
import java.util.Map;

/**
 * Сервис объединения объектов.
 */
public interface MergeService {

    /**
     * Выполнить слияние двух объектов. Правила слияния зависят от реализации
     * @param obj1 Первый объект для слияния
     * @param obj2 Второй объект для слияния
     * @param <K> Тип объединяемых объектов
     * @return Результат слияния объектов
     * @throws MergeException В случае невозможности произвести слияние объектов.
     */
    <K> K merge(K obj1, K obj2) throws MergeException;


    /**
     * Происзвести слияние всех объектов  в списке. Правила слияния зависят от реализации
     * @param entities Список сущностей для слияния
     * @param <K> Тип объектов для объединения
     * @return Результат объединения списк объектов.
     * @throws MergeException В случае невозможности произвести объединение
     */
    <K> K merge(List<K> entities) throws MergeException;

    /**
     * Группирует данные по значению их кода.
     * @param models Данные для группировки
     * @param <K> Группируемые объекты должны наследоваться от BaseData
     * @return Мэп объектов сгруппированных по коду
     */
    <K extends BaseData> Map<String,List<K>> groupByCode(List<K> models);
}
