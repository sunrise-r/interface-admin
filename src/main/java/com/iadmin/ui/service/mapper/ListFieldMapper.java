package com.iadmin.ui.service.mapper;

import com.iadmin.ui.model.ListField;
import com.iadmin.ui.service.dto.ListFieldDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public abstract class ListFieldMapper {

    @Mapping(source = "code", target = "field")
    @Mapping(source = ".", target = "header", qualifiedByName = "toHeader")
    @Mapping(source = ".", target = "displayFormat", qualifiedByName = "toDisplayFormat")
    @Mapping(source = "translationCode", target = "translate", qualifiedByName = "doTranslate")
    @Mapping(expression = "java(true)", target = "visible")
    public abstract ListFieldDto toDto(ListField source);

    @Named("toHeader")
    public String toHeader(ListField listField) {
        if (listField == null) {
            return null;
        }
        if (listField.getTranslationCode() != null && listField.getTranslationCode().length() > 0) {
            return listField.getTranslationCode();
        } else {
            return listField.getLabel();
        }
    }

    @Named("toDisplayFormat")
    public String toDisplayFormat(ListField listField) {
        if (listField == null) {
            return null;
        }
        return listField.getDisplayFormat() == null ? "Entity" : listField.getDisplayFormat();
    }

    @Named("doTranslate")
    public Boolean doTranslate(String translationCode) {
        return translationCode != null && translationCode.length() > 0;
    }


}
