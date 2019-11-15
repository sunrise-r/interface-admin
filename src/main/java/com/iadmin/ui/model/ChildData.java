package com.iadmin.ui.model;

import com.google.common.base.Objects;

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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ChildData childData = (ChildData) o;
        return Objects.equal(parentCode, childData.parentCode);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(super.hashCode(), parentCode);
    }
}
