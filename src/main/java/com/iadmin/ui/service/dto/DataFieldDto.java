package com.iadmin.ui.service.dto;

public class DataFieldDto extends PropertiesFieldDto {

    private String label;

    private String code;

    /**
     * Формат отображения данных
     */
    private String formatter;

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

}
