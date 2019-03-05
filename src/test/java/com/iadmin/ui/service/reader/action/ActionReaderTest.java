package com.iadmin.ui.service.reader.action;

import com.iadmin.ui.model.Action;
import com.iadmin.ui.service.reader.BaseReaderTest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ActionReaderTest extends BaseReaderTest {

    ActionReader actionReader;

    @Test
    public void parse() {
        Action source = new Action();
        actionReader = new ActionReader(readerServiceData, source);
        Action result = actionReader.read();
        assertEquals(source, result);
    }

}
