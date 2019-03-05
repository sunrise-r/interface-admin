package com.iadmin.ui.service.reader.registry;

import com.iadmin.ui.model.RegistrySettings;
import com.iadmin.ui.service.reader.BaseReaderTest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RegistrySettingsReaderTest extends BaseReaderTest {

    @Test
    public void parse() {
        RegistrySettings source = new RegistrySettings();
        UIRegistrySettingsReader reader = new UIRegistrySettingsReader(readerServiceData, source);
        RegistrySettings result = reader.read();
        assertEquals(source, result);
    }
}
