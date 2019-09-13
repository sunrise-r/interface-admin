package com.iadmin.ui.model;

public class DataField extends BaseField {
    /**
     * Источник данных для поля. Используется для заполнения поля данными при отрисовке компонента.
     * Бывает так что название поля в компоненте не совпадают по названию с источником данных. Это поле используется что бы
     * решить эту проблемму. Если оно указанно, то движок должен попытаться получить данные по указанному пути.
     */
    private String datasourcePath;

    public String getDatasourcePath() {
        return datasourcePath;
    }

    public void setDatasourcePath(String datasourcePath) {
        this.datasourcePath = datasourcePath;
    }
}
