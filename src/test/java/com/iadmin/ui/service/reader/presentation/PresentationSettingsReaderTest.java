package com.iadmin.ui.service.reader.presentation;

import com.iadmin.ui.model.PresentationSettings;
import com.iadmin.ui.service.reader.BaseReaderTest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PresentationSettingsReaderTest extends BaseReaderTest {

    @Test
    public void parse() {
        PresentationSettings source = new PresentationSettings();
        PresentationSettingsReader presentationSettingsReader = new PresentationSettingsReader(readerServiceData, source);
        PresentationSettings result = presentationSettingsReader.read();
        assertEquals(source, result);
    }

}
