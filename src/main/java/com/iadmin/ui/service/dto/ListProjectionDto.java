package com.iadmin.ui.service.dto;

import java.util.HashMap;
import java.util.List;

public class ListProjectionDto {

    /**
     * Код
     */
    private String code;

    /**
     * Проекция активна?
     */
    private boolean active;

    /**
     * Url ресурса для поиска данных
     */
    private String searchUrl;

    /**
     * Url to retrieve information for particular record in list
     */
    private String infoUrl;

    /**
     * Доступные для представления действия
     */
    private List<List<ActionDto>> actions;

    /**
     * Список доступных проекции колонок, сгрупированных по группам
     */
    private List<ListFieldDto> columns;

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
     * Список фильтров
     */
    private List<ProjectionFilterDto> filters;

    /**
     * Дополнительные настройки проекции
     */
    private HashMap<String,Object> properties;

    /**
     * Загружать ли актуальную информацию при клике на запись в таблице
     */
    private Boolean loadActualInfo;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<List<ActionDto>> getActions() {
        return actions;
    }

    public void setActions(List<List<ActionDto>> actions) {
        this.actions = actions;
    }

    public List<ListFieldDto> getColumns() {
        return columns;
    }

    public void setColumns(List<ListFieldDto> columns) {
        this.columns = columns;
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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<ProjectionFilterDto> getFilters() {
        return filters;
    }

    public void setFilters(List<ProjectionFilterDto> filters) {
        this.filters = filters;
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

    public HashMap<String, Object> getProperties() {
        return properties;
    }

    public void setProperties(HashMap<String, Object> properties) {
        this.properties = properties;
    }

    public String getInfoUrl() {
        return infoUrl;
    }

    public void setInfoUrl(String infoUrl) {
        this.infoUrl = infoUrl;
    }
}
