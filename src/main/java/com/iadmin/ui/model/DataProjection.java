package com.iadmin.ui.model;

import java.util.List;

public class DataProjection extends BaseProjection {

    private List<DataField> fields;

    private String documentPhoto;

    public String getDocumentPhoto() {
        return documentPhoto;
    }

    public void setDocumentPhoto(String documentPhoto) {
        this.documentPhoto = documentPhoto;
    }

    public List<DataField> getFields() {
        return fields;
    }

    public void setFields(List<DataField> fields) {
        this.fields = fields;
    }
}
