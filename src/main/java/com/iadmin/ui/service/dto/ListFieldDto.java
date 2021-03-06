package com.iadmin.ui.service.dto;

import java.io.Serializable;

public class ListFieldDto extends PropertiesFieldDto implements Serializable {

    /**
     * Код поля
     */
    private String field;

    /**
     * Название колонки.
     * Это разделенный точками путь к строке перевода
     * или если перевод не требует то название колонки
     */
    private String header;

    /**
     * Формат отображения данных
     */
    private String formatter;

    /**
     * Формат отображения данных
     */
    private String displayFormat;

    /**
     * Показывать колонку?
     */
    private boolean visible;

    /**
     * Истина если перевод следует делать на стороне клиента
     */
    private boolean translate;

    /**
     * True if filter can be used with field
     */
    private boolean searching;

    /**
     * Поле используется для задания стиля колонки, который будет применен на фронтенде
     */
    private String style;

    /**
     * Возможна ли сортировка?
     */
    private Boolean sorting;

    /**
     * Определяет позицию колонки в таблице
     */
    private String position;

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getFormatter() {
        return formatter;
    }

    public void setFormatter(String formatter) {
        this.formatter = formatter;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public boolean isTranslate() {
        return translate;
    }

    public void setTranslate(boolean translate) {
        this.translate = translate;
    }

    public boolean isSearching() {
        return searching;
    }

    public void setSearching(boolean searching) {
        this.searching = searching;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDisplayFormat() {
        return displayFormat;
    }

    public void setDisplayFormat(String displayFormat) {
        this.displayFormat = displayFormat;
    }

    public Boolean getSorting() {
        return sorting;
    }

    public void setSorting(Boolean sorting) {
        this.sorting = sorting;
    }
}
