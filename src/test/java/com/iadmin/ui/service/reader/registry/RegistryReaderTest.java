package com.iadmin.ui.service.reader.registry;

import com.google.common.collect.Lists;
import com.iadmin.ui.model.Presentation;
import com.iadmin.ui.model.Registry;
import com.iadmin.ui.model.RegistrySettings;
import com.iadmin.ui.service.reader.BaseReaderTest;
import com.iadmin.ui.service.reader.base.ListReader;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RegistryReaderTest extends BaseReaderTest {

    @Test
    public void parse() throws Exception {

        Registry source = new Registry();
        ListReader<Presentation> presentationsReader = mock(ListReader.class);
        List<Presentation> presentations = Lists.newArrayList();
        when(presentationsReader.read()).thenReturn(presentations);
        when(registryReaderFactory.createPresentationsReader()).thenReturn(presentationsReader);
        ListReader<RegistrySettings> registrySettingsReader = mock(ListReader.class);
        RegistrySettings setting = new RegistrySettings();
        List<RegistrySettings> registrySettings = Lists.newArrayList(setting);
        when(registrySettingsReader.read()).thenReturn(registrySettings);
        when(registryReaderFactory.createUIRegistrySettingsListReader()).thenReturn(registrySettingsReader);
        when(registryMergeService.merge(source.getPresentations(), presentations)).thenReturn(presentations);
        when(registryMergeService.merge(source.getSettings(), registrySettings)).thenReturn(setting);
        UIRegistryReader uiRegistryReader = new UIRegistryReader(readerServiceData, source);
        Registry registry = uiRegistryReader.read();
        assertEquals(presentations, registry.getPresentations());
        assertEquals(registry.getSettings(), setting);
    }

}
