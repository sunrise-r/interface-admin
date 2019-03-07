package com.iadmin.ui.service.mapper;


import com.google.common.collect.Lists;
import com.iadmin.ui.model.*;
import com.iadmin.ui.service.dto.*;
import org.atteo.evo.inflector.English;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", uses = {ListFieldMapper.class})
public interface PresentationMapper {

    @Mapping(target = "projections", expression = "java(entity.getProjections().stream().sorted((x,y) -> x.getOrder() - y.getOrder()).map(this::toDto).collect(java.util.stream.Collectors.toList()))")
    @Mapping(target = "label", source = "label")
    PresentationDto toDto(Presentation entity);

    List<PresentationDto> toDto(List<Presentation> entityList);

    List<ActionDto> actionsToActionDtos(List<Action> action);

    @Mapping(source = "fields", target = "columns")
    @Mapping(source = "actions", target = "actions", qualifiedByName = "groupedActionDtos")
    ListProjectionDto toDto(ListProjection projection);

    ProjectionFilterDto toDto(ProjectionFilter filter);

    DataProjectionDto toDto(DataProjectionDto entity);

    DataFieldDto toDto(DataField entity);

    FormProjectionDto toDto(FormProjection entity);

    @Mapping(source = "fieldName", target = "name")
    @Mapping(source = "fieldType", target = "type")
    @Mapping(source = "fieldLabel", target = "label")
    @Mapping(expression = "java(presentationCode(field))", target = "presentationCode")
    @Mapping(expression = "java(validationTypes(field))", target = "validationTypes")
    @Mapping(target = "column", expression = "java(field.getColumn() == null ? 0 : field.getColumn())")
    FormFieldDto toDto(FormField field);

    /**
     * Метод группирует Action по полю group в отдельные списки и преобразует их в ДТО. Возвращает список списков ДТО,
     * сгруппированных по группам.
     *
     * @param actions - объекты для преобразования в ДТО
     * @return - список списков ДТО, сгруппированных по группе
     */
    @Named("groupedActionDtos")
    default List<List<ActionDto>> actionsToGroupedActionDtos(List<Action> actions) {
        List<List<ActionDto>> result = new ArrayList<>();
        if (actions == null) return result;
        Map<String, List<Action>> groupedActions = actions.stream()
                .collect(Collectors.groupingBy(Action::getGroup, Collectors.toList()));
        actions.stream()
                .map(Action::getGroup)
                .distinct()
                .forEach(x -> result.add(actionsToActionDtos(groupedActions.get(x))));
        return result;
    }

    @Named("generatePresentationCode")
    default String presentationCode(FormField field) {
        if (field.getPresentationCode() != null) {
            return field.getPresentationCode();
        }
        String fieldType = field.getFieldType();
        if (field.getFieldName().equals("additionalDocuments")) return "common";
        return fieldType.equals("Entity") || fieldType.equals("List") ? English.plural(field.getFieldName()) : null;
    }

    default ValidationDto validationTypes(FormField field) {
        if (field.getValidationTypes() != null) {
            return field.getValidationTypes();
        }
        ValidationDto validation = new ValidationDto();
        if (!field.getFieldLength().equals("")) {
            validation.setMaxLength(field.getFieldLength());
        }
        validation.setRequired(field.isRequired());
        return validation;
    }
}
