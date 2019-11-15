package com.iadmin.ui.model;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * Описание всевозможных видом представления сущности
 */
public class Presentation extends ChildData {
    /**
     * Открываемя по умолчанию проекция
     */
    private String defaultProjection;

    /**
     * Список доступных проекций для представления сущности в виде списка
     */
    private List<ListProjection> projections = Lists.newArrayList();

    private List<Action> actions = Lists.newArrayList();

    /**
     * Список доступных проекций для представления сущности в виде формы.
     */
    private List<FormProjection> formProjections = Lists.newArrayList();

    /**
     * Список проекций для "Окно Данные"
     */
    private List<DataProjection> dataProjections = Lists.newArrayList();

    /**
     * Настройки представления сущности
     */
    private PresentationSettings settings;

    public List<DataProjection> getDataProjections() {
        return dataProjections;
    }

    public void setDataProjections(List<DataProjection> dataProjections) {
        this.dataProjections = dataProjections;
    }

    public List<Action> getActions() {
        return actions;
    }

    public void setActions(List<Action> actions) {
        this.actions = actions;
    }

    public String getDefaultProjection() {
        return defaultProjection;
    }

    public void setDefaultProjection(String defaultProjection) {
        this.defaultProjection = defaultProjection;
    }

    public PresentationSettings getSettings() {
        return settings;
    }

    public void setSettings(PresentationSettings settings) {
        this.settings = settings;
    }

    public List<ListProjection> getProjections() {
        return projections;
    }

    public void setProjections(List<ListProjection> projections) {
        this.projections = projections;
    }

    public List<FormProjection> getFormProjections() {
        return formProjections;
    }

    public void setFormProjections(List<FormProjection> formProjections) {
        this.formProjections = formProjections;
    }

    @Override
    public String toString() {
        return "Presentation{" +
            "defaultProjection='" + defaultProjection + '\'' +
            ", projections=" + projections +
            ", actions=" + actions +
            ", formProjections=" + formProjections +
            ", settings=" + settings +
            '}';
    }
}
