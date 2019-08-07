package com.iadmin.ui.service.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashMap;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class FormFieldDto extends PropertiesFieldDto {

    /**
     * Типы валидации которые дожны быть применены для поля при редактирование
     */
    private ValidationDto validationTypes;

    /**
     * Указатель на поле из sourceListProjection, которое должно быть подставлено в форму
     */
    private String valueField;

    private String presentationCode;

    private String type;

    private String name;

    private String label;

    private String defaultValue;

    /**
     * Тип поля: Text, String, ZonedDateTime etc.
     */
    private String fieldInputType;

    /**
     * Form fields may be allocated in different <td></td> or <div class="col-{{colums.length / n}}"></div> columns
     */
    private Integer column;

    /**
     * Make no sense. Marked as hidden input should be hidden. But we use fieldInputType: Hidden on frontend side
     */
    private boolean hidden;

    /**
     * Closely related to "partner" project. "View" part of grid-like lookups
     */
    private String lookupViewProjectionCode;

    /**
     * Closely related to "partner" project. "Source" part of grid-like lookups
     */
    private String lookupSourceProjectionCode;

    /**
     * Allows frontend to include external form projections as nested form group or as additional fields kit for current form
     */
    private String referenceProjectionCode;

    /**
     * Add Input mask for String inputs
     */
    private String inputMask;

    /**
     * Dot separated path to any data source, that will be passed to form on frontend side
     */
    private String datasourcePath;

    /**
     * Flag to configure if the label of current form field should be translated
     * on frontend side or it should be displayed as is
     */
    private boolean translate;

    /**
     * Isn't it the same as opposite for hidden flag?  (hidden = false)
     */
    private boolean visible;

    /**
     * Компонент отображения данных
     */
    private String formatter;

    /**
     * Формат отображения данных
     */
    private String displayFormat;

    public String getValueField() {
        return valueField;
    }

    public void setValueField(String valueField) {
        this.valueField = valueField;
    }

    public String getInputMask() {
        return inputMask;
    }

    public void setInputMask(String inputMask) {
        this.inputMask = inputMask;
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

    public String getPresentationCode() {
        return presentationCode;
    }

    public void setPresentationCode(String presentationCode) {
        this.presentationCode = presentationCode;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public String getFieldInputType() {
        return fieldInputType;
    }

    public void setFieldInputType(String fieldInputType) {
        this.fieldInputType = fieldInputType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public ValidationDto getValidationTypes() {
        return validationTypes;
    }

    public void setValidationTypes(ValidationDto validationTypes) {
        this.validationTypes = validationTypes;
    }

    public Integer getColumn() {
        return column;
    }

    public void setColumn(Integer column) {
        this.column = column;
    }

    public String getReferenceProjectionCode() {
        return referenceProjectionCode;
    }

    public void setReferenceProjectionCode(String referenceProjectionCode) {
        this.referenceProjectionCode = referenceProjectionCode;
    }

    public String getDatasourcePath() {
        return datasourcePath;
    }

    public void setDatasourcePath(String datasourcePath) {
        this.datasourcePath = datasourcePath;
    }

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

    public String getFormatter() {
        return formatter;
    }

    public void setFormatter(String formatter) {
        this.formatter = formatter;
    }

    public String getDisplayFormat() {
        return displayFormat;
    }

    public void setDisplayFormat(String displayFormat) {
        this.displayFormat = displayFormat;
    }
}
