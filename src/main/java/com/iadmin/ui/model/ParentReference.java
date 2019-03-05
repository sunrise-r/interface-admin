package com.iadmin.ui.model;

/**
 * Ссылка на родительский объект
 */
public class ParentReference {

    private String presentationCode;

    private String projectionCode;


    public String getPresentationCode() {
        return presentationCode;
    }

    public void setPresentationCode(String presentationCode) {
        this.presentationCode = presentationCode;
    }

    public String getProjectionCode() {
        return projectionCode;
    }

    public void setProjectionCode(String projectionCode) {
        this.projectionCode = projectionCode;
    }
}
