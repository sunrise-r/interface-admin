package com.iadmin.ui.service.reader.field;

import com.iadmin.ui.model.ListField;
import com.iadmin.ui.service.reader.BaseReaderTest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ListFieldReaderTest extends BaseReaderTest {

    @Test
    public void parse() {
        ListField source = new ListField();
        ListFieldReader listFieldReader = new ListFieldReader(readerServiceData, source);
        ListField result = listFieldReader.read();
        assertEquals(source, result);
    }

}
