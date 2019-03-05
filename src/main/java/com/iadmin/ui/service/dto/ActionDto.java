package com.iadmin.ui.service.dto;

public class ActionDto {

    /**
     * Код
     */
    private String code;

    /**
     * Включена/выключена
     */
   private boolean toggle;

    /**
     * Стиль визуального элемента
     */
    private String style;


    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean isToggle() {
        return toggle;
    }

    public void setToggle(boolean toggle) {
        this.toggle = toggle;
    }
}
