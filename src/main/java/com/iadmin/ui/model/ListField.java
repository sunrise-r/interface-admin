package com.iadmin.ui.model;

/**
 * Описание поля проекции. Какой компонент использовать, валидация, специальные атрибуты
 */
public class ListField extends BaseField {

    /**
     * Формат отображения данных
     */
    private String formatter;

    /**
     * Доступна сортировка или нет
     */
    private boolean sorting;

    /**
     * Доступен ли поиск по полю
     */
    private boolean searching;

    /**
     * Код перевода
     */
    private String translationCode;

    /**
     * Поле используется для задания стиля колонки, который будет применен на фронтенде
     */
    private String style;

    /**
     * Определяет позицию колонки в таблице
     */
    private String position;


    public String getTranslationCode() {
        return translationCode;
    }

    public void setTranslationCode(String translationCode) {
        this.translationCode = translationCode;
    }

    public String getFormatter() {
        return formatter;
    }

    public void setFormatter(String formatter) {
        this.formatter = formatter;
    }

    public boolean isSorting() {
        return sorting;
    }

    public void setSorting(boolean sorting) {
        this.sorting = sorting;
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
}
