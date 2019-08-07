package com.iadmin.ui.model;

public class BaseField extends ChildData {

    /**
     * Компонент отображения данных
     */
    private String formatter;

    /**
     * Формат отображения поля в компоненте
     */
    private String displayFormat;

    public String getDisplayFormat() {
        return displayFormat;
    }

    public void setDisplayFormat(String displayFormat) {
        this.displayFormat = displayFormat;
    }

    public String getFormatter() {
        return formatter;
    }

    public void setFormatter(String formatter) {
        this.formatter = formatter;
    }
}
