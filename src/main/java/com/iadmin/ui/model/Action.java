package com.iadmin.ui.model;

public class Action extends ChildData {

    /**
     * Способ отображения Действия. Например: кнопка, ссылка
     */
    private String displayType;

    /**
     * Группа действий. может быть использована для группировки
     */
    private String group;

    /**
     * Стиль визуального элемента
     */
    private String style;

    /**
     * Включена/выключена
     */
    private boolean toggle;

    public boolean isToggle() {
        return toggle;
    }

    public void setToggle(boolean toggle) {
        this.toggle = toggle;
    }

    public String getDisplayType() {
        return displayType;
    }

    public void setDisplayType(String displayType) {
        this.displayType = displayType;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

}
