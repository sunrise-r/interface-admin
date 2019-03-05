package com.iadmin.ui.service.reader.field;

import com.iadmin.ui.model.FormField;
import com.iadmin.ui.service.reader.BaseReaderTest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FormFieldReaderTest extends BaseReaderTest {

    @Test
    public void parse() {
        FormField formField = new FormField();
        FormFieldReader formFieldReader = new FormFieldReader(readerServiceData, formField);
        FormField result = formFieldReader.read();
        assertEquals(formField, result);
    }

}
