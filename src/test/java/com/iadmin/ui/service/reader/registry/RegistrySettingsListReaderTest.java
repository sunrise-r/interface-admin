package com.iadmin.ui.service.reader.registry;

import com.google.common.collect.Lists;
import com.iadmin.ui.exception.MergeException;
import com.iadmin.ui.model.RegistrySettings;
import com.iadmin.ui.service.reader.BaseReaderTest;
import com.iadmin.ui.service.reader.base.UIReader;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RegistrySettingsListReaderTest extends BaseReaderTest {

    @Test
    public void parse() throws IOException, MergeException {
        RegistrySettings source = new RegistrySettings();
        UIReader<RegistrySettings> singleReader = mock(UIReader.class);
        when(singleReader.read()).thenReturn(source);
        when(registryReaderFactory.createUIRegistrySettingsReader(source)).thenReturn(singleReader);
        List<RegistrySettings> settings = Lists.newArrayList(source);
        when(registryAccessor.getUIRegistrySettings()).thenReturn(settings);
        when(registryMergeService.mergeByCode(settings)).thenReturn(settings);
        UIRegistrySettingsListReader listReader = new UIRegistrySettingsListReader(readerServiceData);
        List<RegistrySettings> result = listReader.read();
        assertNotNull(result);
        assertTrue(result.size() == 1);
        assertEquals(source, result.get(0));
    }

}
