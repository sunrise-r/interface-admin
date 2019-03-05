package com.iadmin.ui.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Базовый абстрактный класс для сущностей у которых есть родительский объект
 */
public abstract class ChildData extends BaseData {

    /**
     * Код родительской записи. Эта инфомрация будет использована при итоговом постороении дерева интерфейсов.
     */
    private String parentCode;

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    @Override
    public String toString() {
        return "ChildData{" +
            "parentCode='" + parentCode + '\'' +
            '}';
    }
}
