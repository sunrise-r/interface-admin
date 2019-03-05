package com.iadmin.ui.service.reader.field;

import com.google.common.collect.Lists;
import com.iadmin.ui.exception.MergeException;
import com.iadmin.ui.model.FormField;
import com.iadmin.ui.model.FormProjection;
import com.iadmin.ui.service.reader.BaseReaderTest;
import com.iadmin.ui.service.reader.base.UIReader;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FormFieldsReaderTest extends BaseReaderTest {

    @Test
    public void parse() throws IOException, MergeException {
        FormProjection owner = new FormProjection();
        FormField source = new FormField();
        List<FormField> entities = Lists.newArrayList(source);
        when(registryAccessor.getFormFields(owner)).thenReturn(entities);
        UIReader<FormField> formFieldReader = mock(UIReader.class);
        when(formFieldReader.read()).thenReturn(source);
        when(registryReaderFactory.createFormFieldReader(source)).thenReturn(formFieldReader);
        when(registryMergeService.mergeByCode(entities)).thenReturn(entities);
        FormFieldsReader formFieldsReader = new FormFieldsReader(readerServiceData, owner);
        List<FormField> formFieldList = formFieldsReader.read();
        assertEquals(source, formFieldList.get(0));
    }

}
