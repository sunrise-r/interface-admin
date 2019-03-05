package com.iadmin.ui.model;

import java.util.List;

/**
 * Параметры фильтра для проекции
 */
public class ProjectionFilter {

    /**
     * Название фильтра
     */
    private String field;

    /**
     * Значения фильтров
     */
    private List<String> values;

    /**
     * Оператор для значений фильтра
     */
    private String operator;

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public List<String> getValues() {
        return values;
    }

    public void setValues(List<String> values) {
        this.values = values;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }
}
