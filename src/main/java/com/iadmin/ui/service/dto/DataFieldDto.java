package com.iadmin.ui.service.dto;

import java.io.Serializable;

public class DataFieldDto extends PropertiesFieldDto implements Serializable {

    private String code;

    /**
     * Компонент отображения данных
     */
    private String formatter;

    /**
     * Dot separated path to any data source, that will be passed to form on frontend side
     */
    private String datasourcePath;

    private String defaultValue;

    /**
     * Формат отображения данных
     */
    private String displayFormat;

    private String label;

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

    public String getFormatter() {
        return formatter;
    }

    public void setFormatter(String formatter) {
        this.formatter = formatter;
    }

    public String getDisplayFormat() {
        return displayFormat;
    }

    public void setDisplayFormat(String displayFormat) {
        this.displayFormat = displayFormat;
    }

    public String getDatasourcePath() {
        return datasourcePath;
    }

    public void setDatasourcePath(String datasourcePath) {
        this.datasourcePath = datasourcePath;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }
}
