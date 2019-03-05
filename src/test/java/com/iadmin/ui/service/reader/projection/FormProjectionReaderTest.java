package com.iadmin.ui.service.reader.projection;

import com.google.common.collect.Lists;
import com.iadmin.ui.model.FormField;
import com.iadmin.ui.model.FormProjection;
import com.iadmin.ui.service.reader.BaseReaderTest;
import com.iadmin.ui.service.reader.field.FormFieldsReader;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FormProjectionReaderTest extends BaseReaderTest {

    @Test
    public void parse() throws Exception {
        FormProjection source = new FormProjection();
        FormFieldsReader formFieldsReader = mock(FormFieldsReader.class);
        List<FormField> formFields = Lists.newArrayList();
        when(formFieldsReader.read()).thenReturn(formFields);
        when(registryMergeService.merge(source.getFields(), formFields)).thenReturn(formFields);
        when(registryReaderFactory.createFormFieldsReader(source)).thenReturn(formFieldsReader);
        FormProjectionReader formProjectionReader = new FormProjectionReader(readerServiceData, source);
        FormProjection formProjection = formProjectionReader.read();
        assertEquals(formFields, formProjection.getFields());
    }

}
