package com.iadmin.ui.service.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DataProjectionDto implements Serializable {

    private String label;

    private List<DataFieldDto> fields;

    private String documentPhoto;

    public String getDocumentPhoto() {
        return documentPhoto;
    }

    public void setDocumentPhoto(String documentPhoto) {
        this.documentPhoto = documentPhoto;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<DataFieldDto> getFields() {
        return fields;
    }

    public void setFields(List<DataFieldDto> fields) {
        this.fields = fields;
    }
}
