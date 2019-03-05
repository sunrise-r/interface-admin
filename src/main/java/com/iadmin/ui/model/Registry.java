package com.iadmin.ui.model;

import java.util.List;

/**
 * Данные для представления пользовательского интерфейса
 */
public class Registry extends BaseData {

    /**
     * Настройки регистра визуального интерфейса
     */
    private RegistrySettings settings;

    /**
     * Список доступных представлений сущности для интерфейса
     */
    private List<Presentation> presentations;

    public RegistrySettings getSettings() {
        return settings;
    }

    public void setSettings(RegistrySettings settings) {
        this.settings = settings;
    }

    public List<Presentation> getPresentations() {
        return presentations;
    }

    public void setPresentations(List<Presentation> presentations) {
        this.presentations = presentations;
    }
}
