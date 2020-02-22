package com.iadmin.ui.model;

import com.google.common.base.Objects;
import com.iadmin.ui.service.dto.ValidationDto;

/**
 * Описание поля, используется для построения формы редактирования.
 */
public class FormField extends DataField {

    private String fieldType;

    private String valueField;

    private String fieldName;

    private String fieldLabel;

    private boolean required;

    private String fieldLength;

    private String fieldInputType;

    private Integer column;

    private boolean hidden;

    private String lookupViewProjectionCode;

    private String lookupSourceProjectionCode;

    private String referenceProjectionCode;

    private String presentationCode;

    private String inputMask;

    private ValidationDto validationTypes;

    private boolean translate;

    private boolean visible = true;

    public String getValueField() {
        return valueField;
    }

    public void setValueField(String valueField) {
        this.valueField = valueField;
    }

    public String getPresentationCode() {
        return presentationCode;
    }

    public void setPresentationCode(String presentationCode) {
        this.presentationCode = presentationCode;
    }

    public String getLookupViewProjectionCode() {
        return lookupViewProjectionCode;
    }

    public void setLookupViewProjectionCode(String lookupViewProjectionCode) {
        this.lookupViewProjectionCode = lookupViewProjectionCode;
    }

    public String getLookupSourceProjectionCode() {
        return lookupSourceProjectionCode;
    }

    public void setLookupSourceProjectionCode(String lookupSourceProjectionCode) {
        this.lookupSourceProjectionCode = lookupSourceProjectionCode;
    }

    public boolean isHidden() {
        return hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    public String getFieldInputType() {
        return fieldInputType;
    }

    public void setFieldInputType(String fieldInputType) {
        this.fieldInputType = fieldInputType;
    }

    public boolean isRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }

    public String getFieldLength() {
        return fieldLength;
    }

    public void setFieldLength(String fieldLength) {
        this.fieldLength = fieldLength;
    }

    public String getFieldType() {
        return fieldType;
    }

    public void setFieldType(String fieldType) {
        this.fieldType = fieldType;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldLabel() {
        return fieldLabel;
    }

    public void setFieldLabel(String fieldLabel) {
        this.fieldLabel = fieldLabel;
    }

    public Integer getColumn() {
        return column;
    }

    public void setColumn(Integer column) {
        this.column = column;
    }

    public String getReferenceProjectionCode() { return referenceProjectionCode; }

    public void setReferenceProjectionCode(String referenceProjectionCode) {
        this.referenceProjectionCode = referenceProjectionCode;
    }

    public String getInputMask() {
        return inputMask;
    }

    public void setInputMask(String inputMask) {
        this.inputMask = inputMask;
    }

    public ValidationDto getValidationTypes() { return validationTypes; }

    public void setValidationTypes(ValidationDto validation) { this.validationTypes = validation; }

    public boolean isTranslate() {
        return translate;
    }

    public void setTranslate(boolean translate) {
        this.translate = translate;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        FormField formField = (FormField) o;
        return Objects.equal(fieldName, formField.fieldName);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(super.hashCode(), fieldName);
    }
}
