package com.iadmin.ui.service.dto;

public class DataFieldDto extends PropertiesFieldDto {

    private String label;

    private String code;

    /**
     * Компонент отображения данных
     */
    private String formatter;

    /**
     * Формат отображения данных
     */
    private String displayFormat;

    /**
     * Dot separated path to any data source, that will be passed to form on frontend side
     */
    private String datasourcePath;

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
}
