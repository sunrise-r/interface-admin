package com.iadmin.ui.service.dto;

import java.util.HashMap;
import java.util.List;

public class FormProjectionDto implements Serializable {

    private List<FormFieldDto> fields;

    private String title;

    private String className;

    private String code;

    private HashMap<String,Object> properties;

    public HashMap<String, Object> getProperties() {
        return properties;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public List<FormFieldDto> getFields() {
        return fields;
    }

    public void setFields(List<FormFieldDto> fields) {
        this.fields = fields;
    }

    public void setProperties(HashMap<String, Object> properties) {
        this.properties = properties;
    }
}
