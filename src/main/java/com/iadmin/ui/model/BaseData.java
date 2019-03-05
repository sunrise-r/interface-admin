package com.iadmin.ui.model;

import java.util.HashMap;
import java.util.Objects;

public class BaseData {
    /**
     * Название проекции
     */
    private String label;
    /**
     * Код проекции
     */
    private String code;

    private HashMap<String, Object> properties;

    public HashMap<String, Object> getProperties() {
        return properties;
    }

    public void setProperties(HashMap<String, Object> properties) {
        this.properties = properties;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BaseData)) return false;
        BaseData baseData = (BaseData) o;
        return Objects.equals(getCode(), baseData.getCode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCode());
    }

    @Override
    public String toString() {
        return "BaseData{" +
            "label='" + label + '\'' +
            ", code='" + code + '\'' +
            '}';
    }
}
