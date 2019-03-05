package com.iadmin.ui.service.dto;

import java.io.Serializable;
import java.util.List;

public class PresentationDto implements Serializable {

    /**
     * Код
     */
    private String code;

    /**
     * Список доступных проекций
     */
    private List<ListProjectionDto> projections;

    /**
     * Список форм проекций
     */
    private List<FormProjectionDto> formProjections;

    /**
     * Список проекций для "Окно Данные"
     */
    private List<DataProjectionDto> dataProjections;

    /**
     * Путь к переводу названия
     */
    private String label;

    public List<DataProjectionDto> getDataProjections() {
        return dataProjections;
    }

    public void setDataProjections(List<DataProjectionDto> dataProjections) {
        this.dataProjections = dataProjections;
    }

    public List<FormProjectionDto> getFormProjections() {
        return formProjections;
    }

    public void setFormProjections(List<FormProjectionDto> formProjections) {
        this.formProjections = formProjections;
    }

    public String getCode() {
        return code;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<ListProjectionDto> getProjections() {
        return projections;
    }

    public void setProjections(List<ListProjectionDto> projections) {
        this.projections = projections;
    }

}
