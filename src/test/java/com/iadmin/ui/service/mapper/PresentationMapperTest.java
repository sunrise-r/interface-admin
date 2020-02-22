package com.iadmin.ui.service.mapper;


import com.iadmin.ui.model.*;
import com.iadmin.ui.service.dto.FormFieldDto;
import com.iadmin.ui.service.dto.ListFieldDto;
import com.iadmin.ui.service.dto.PresentationDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@ContextConfiguration
public class PresentationMapperTest {

    @Autowired
    private PresentationMapper presentationMapper;

    @Autowired
    private ListFieldMapper listFieldMapper;

    @Test
    public void convertPresentationToPresentationDto() {

        Presentation presentation = new Presentation();
        presentation.setCode("It's best code!");
        presentation.setDefaultProjection("It's the best projection!");

        ListProjection listProjection1 = new ListProjection();
        ListProjection listProjection2 = new ListProjection();
        listProjection1.setCode("Projection1");
        listProjection2.setCode("Projection2");

        List<Action> actions1 = new ArrayList<>();
        List<Action> actions2 = new ArrayList<>();
        List<ListField> listFields1 = new ArrayList<>();
        List<ListField> listFields2 = new ArrayList<>();

        ProjectionFilter filter1 = new ProjectionFilter();
        ProjectionFilter filter2 = new ProjectionFilter();
        ProjectionFilter filter3 = new ProjectionFilter();
        filter1.setField("feels");
        filter2.setField("field");
        filter3.setField("man");
        filter1.setValues(Arrays.asList("12", "123"));
        filter2.setValues(Collections.singletonList("51"));
        filter3.setValues(Arrays.asList("99", "fence"));
        List<ProjectionFilter> filters1 = Collections.singletonList(filter1);
        List<ProjectionFilter> filters2 = Arrays.asList(filter2, filter3);

        ListField listField1;
        ListField listField2;
        Action action1;
        Action action2;

        for (int i = 0; i < 10; i++) {
            action1 = new Action();
            action2 = new Action();
            listField1 = new ListField();
            listField2 = new ListField();


            action1.setStyle("Style 1." + i);
            action2.setStyle("Style 2." + i);
            if (i < 3) {
                action1.setGroup("AAAAA");
                action2.setGroup("EEEEE");
            } else if (i < 6) {
                action1.setGroup("BBBBB");
                action2.setGroup("FFFFF");
            } else {
                action1.setGroup("CCCCC");
                action2.setGroup("GGGGG");
            }
            actions1.add(action1);
            actions2.add(action2);
            listFields1.add(listField1);
            listFields2.add(listField2);
        }

        listProjection1.setActions(actions1);
        listProjection1.setOrder(1);
        listProjection2.setActions(actions2);
        listProjection2.setOrder(2);
        listProjection1.setFields(listFields1);
        listProjection2.setFields(listFields2);
        listProjection1.setFilters(filters1);
        listProjection2.setFilters(filters2);

        presentation.setProjections(Arrays.asList(listProjection1, listProjection2));

        PresentationDto presentationDto = presentationMapper.toDto(presentation);

        assertEquals(presentation.getCode(), presentationDto.getCode());
        assertEquals(2, presentationDto.getProjections().size());
        assertEquals(listProjection1.getCode(), presentationDto.getProjections().get(0).getCode());
        assertEquals(listProjection2.getCode(), presentationDto.getProjections().get(1).getCode());
        assertEquals(3, presentationDto.getProjections().get(0).getActions().size());
        assertEquals(3, presentationDto.getProjections().get(0).getActions().get(0).size());
        assertEquals("Style 1.3", presentationDto.getProjections().get(0).getActions().get(1).get(0).getStyle());
        assertEquals(3, presentationDto.getProjections().get(1).getActions().size());
        assertEquals(3, presentationDto.getProjections().get(1).getActions().get(0).size());
        assertEquals("Style 2.0", presentationDto.getProjections().get(1).getActions().get(0).get(0).getStyle());
        assertEquals(10, presentationDto.getProjections().get(0).getColumns().size());
        assertEquals(10, presentationDto.getProjections().get(1).getColumns().size());

        assertEquals(1, presentationDto.getProjections().get(0).getFilters().size());
        assertEquals(2, presentationDto.getProjections().get(1).getFilters().size());
        assertEquals("feels", presentationDto.getProjections().get(0).getFilters().get(0).getField());
        assertEquals("man", presentationDto.getProjections().get(1).getFilters().get(1).getField());
        assertEquals(2, presentationDto.getProjections().get(1).getFilters().get(1).getValues().size());
        assertEquals("99", presentationDto.getProjections().get(1).getFilters().get(1).getValues().get(0));
        assertEquals("fence", presentationDto.getProjections().get(1).getFilters().get(1).getValues().get(1));
    }

    @Test
    public void formFieldToDTO() {
        FormField field = new FormField();
        fillBaseField(field);
        field.setRequired(true);
        field.setHidden(false);
        field.setFieldLength("1");
        field.setDefaultValue("2");
        field.setFieldInputType("3");
        field.setFieldLabel("4");
        field.setFieldName("5");
        field.setPresentationCode("6");
        field.setFieldType("7");
        field.setLookupViewProjectionCode("8");
        field.setLookupSourceProjectionCode("9");
        field.setTranslate(true);

        FormFieldDto formFieldDto = presentationMapper.toDto(field);

        assertEquals(field.getPresentationCode(), formFieldDto.getPresentationCode());
        assertEquals(field.getFieldType(), formFieldDto.getType());
        assertEquals(field.getFieldName(), formFieldDto.getName());
        assertEquals(field.getFieldLabel(), formFieldDto.getLabel());
        assertEquals(field.getDefaultValue(), formFieldDto.getDefaultValue());
        assertEquals(field.getFieldInputType(), formFieldDto.getFieldInputType());
        assertEquals(field.isHidden(), formFieldDto.isHidden());
        assertEquals(field.getLookupViewProjectionCode(), formFieldDto.getLookupViewProjectionCode());
        assertEquals(field.getLookupSourceProjectionCode(), formFieldDto.getLookupSourceProjectionCode());
        assertEquals(field.getProperties(), formFieldDto.getProperties());
        assertEquals(field.getFieldLength(), formFieldDto.getValidationTypes().getMaxLength());
        assertEquals(field.isRequired(), formFieldDto.getValidationTypes().isRequired());
        assertEquals(field.isTranslate(), formFieldDto.isTranslate());
        assertEquals(field.isVisible(), formFieldDto.isVisible());
    }

    @Test
    public void listFieldToDto() {
        ListField listField = new ListField();
        fillBaseField(listField);
        listField.setTranslationCode("1");
        listField.setSorting(true);
        listField.setFormatter("2");
        listField.setSearching(true);
        ListFieldDto listFieldDto = listFieldMapper.toDto(listField);
        assertEquals(listField.getCode(), listFieldDto.getField());
        assertEquals(listField.getTranslationCode(), listFieldDto.getHeader());
        assertTrue(listFieldDto.isVisible());

        listField.setDisplayFormat(null);
        listFieldDto = listFieldMapper.toDto(listField);
        assertEquals("Entity", listFieldDto.getDisplayFormat());
    }

    private void fillBaseField(BaseField field) {
        field.setCode("101");
        field.setParentCode("102");
        field.setLabel("103");
        field.setDisplayFormat("104");
        field.setProperties(new HashMap<>());
    }

    @Configuration
    @ComponentScan("com.iadmin.ui.service.mapper")
    public static class TestConfiguration {

    }
}
