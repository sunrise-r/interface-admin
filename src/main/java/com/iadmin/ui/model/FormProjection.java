package com.iadmin.ui.model;

import java.util.List;

public class FormProjection extends BaseProjection {

    /**
     * Описание полей проекции
     */

    private List<FormField> fields;

    private String label;

    private String title;

    private String className;

    private String code;

    /**
     * URL, на который будет отправлена форма. Может быть в виде шаблона underscore
     */
    private String actionUrl;

    /**
     * Тип формы для возможности фильтрации на frontend
     */
    private String formType;

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public void setCode(String code) {
        this.code = code;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public List<FormField> getFields() {
        return fields;
    }

    public void setFields(List<FormField> fields) {
        this.fields = fields;
    }

    public String getActionUrl() {
        return actionUrl;
    }

    public void setActionUrl(String actionUrl) {
        this.actionUrl = actionUrl;
    }

    public String getFormType() {
        return formType;
    }

    public void setFormType(String formType) {
        this.formType = formType;
    }
}
