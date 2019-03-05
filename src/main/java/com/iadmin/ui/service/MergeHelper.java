package com.iadmin.ui.service;

import com.iadmin.ui.exception.MergeException;

/**
 * Утилиты для слияния объектов
 */
public interface MergeHelper {

    /**
     * Доступные правила:
     * 1. Если приоритет одинаковый или отсутствует действует правило notNull > null;
     * <p>
     * Произвести слияния двух объектов.
     *
     * @param obj1 Объект слияния один
     * @param obj2 Объект слияния два
     * @param <K>  Тип объектов которые обудут объеденены
     * @return Результат слиния объектов @obj1 и obj2, проведенного согласно правилам слияния
     * @throws MergeException
     */
    <K> K mergeObjects(K obj1, K obj2) throws MergeException;
}
