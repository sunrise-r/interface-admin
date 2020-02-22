package com.iadmin.ui.model;

import com.google.common.base.Objects;

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

    public ParentReference presentationCode(String code) {
        this.presentationCode = code;
        return this;
    }

    public ParentReference projectionCode(String code) {
        this.projectionCode = code;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParentReference that = (ParentReference) o;
        return Objects.equal(presentationCode, that.presentationCode) &&
                Objects.equal(projectionCode, that.projectionCode);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(presentationCode, projectionCode);
    }
}
