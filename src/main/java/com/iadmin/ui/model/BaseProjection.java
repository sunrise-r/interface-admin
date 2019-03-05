package com.iadmin.ui.model;

/**
 * Общуие данные для проекций формы и списка
 */
class BaseProjection extends ChildData {

    /**
     * Описание проекции. Для чего предназначена, зачем создана
     */
    private String description;

    /**
     * Тип проекции. В зависимости от типа проекции, она может быть отриоована разными способами(например список или таблица)
     */
    private String displayType;

    public String getDisplayType() {
        return displayType;
    }

    public void setDisplayType(String displayType) {
        this.displayType = displayType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
