package com.iadmin.ui.model;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Описание проекции сущности
 * Информация из проекции служит основой для генерации элементов интерфейса.
 */
public class ListProjection extends BaseProjection {

    /**
     * Путь до ресурса
     */
    private String searchUrl;

    /**
     * Порядок сортировки
     */
    private int order;

    /**
     * Доступные для представления действия
     */
    private List<Action> actions;

    /**
     * Название группы пользовательских настроек
     */
    private String settingsGroupName;

    /**
     * Адрес для запроса данных в elastic
     */
    private String resourceSearchUrl;

    /**
     * Разделенный точками путь к строке перевода
     */
    private String label;

    /**
     * Описание полей проекции
     */
    private List<ListField> fields;

    /**
     * Список фильтров
     */
    private List<ProjectionFilter> filters;

    /**
     * Загружать ли актуальную информацию при клике на запись в таблице
     */
    private Boolean loadActualInfo;

    /**
     * Ссылка на родительскую проекцию
     */
    @JsonProperty("extends")
    private ParentReference parentReference;

    public List<ProjectionFilter> getFilters() {
        return filters;
    }

    public void setFilters(List<ProjectionFilter> filters) {
        this.filters = filters;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public ParentReference getParentReference() {
        return parentReference;
    }

    public void setParentReference(ParentReference parentReference) {
        this.parentReference = parentReference;
    }

    public String getSettingsGroupName() {
        return settingsGroupName;
    }

    public void setSettingsGroupName(String settingsGroupName) {
        this.settingsGroupName = settingsGroupName;
    }

    public String getResourceSearchUrl() {
        return resourceSearchUrl;
    }

    public void setResourceSearchUrl(String resourceSearchUrl) {
        this.resourceSearchUrl = resourceSearchUrl;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<Action> getActions() {
        return actions;
    }

    public void setActions(List<Action> actions) {
        this.actions = actions;
    }

    public List<ListField> getFields() {
        return fields;
    }

    public void setFields(List<ListField> fields) {
        this.fields = fields;
    }

    public String getSearchUrl() {
        return searchUrl;
    }

    public void setSearchUrl(String searchUrl) {
        this.searchUrl = searchUrl;
    }

    public Boolean getLoadActualInfo() {
        return loadActualInfo;
    }

    public void setLoadActualInfo(Boolean loadActualInfo) {
        this.loadActualInfo = loadActualInfo;
    }
}
