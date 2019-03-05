package com.iadmin.ui.service.reader.registry;

import com.google.common.collect.Lists;
import com.iadmin.ui.model.Registry;
import com.iadmin.ui.service.ReaderServiceData;
import com.iadmin.ui.service.RegistryAccessor;
import com.iadmin.ui.service.RegistryMergeService;
import com.iadmin.ui.service.RegistryReaderFactory;
import com.iadmin.ui.service.reader.BaseReaderTest;
import com.iadmin.ui.service.reader.base.UIReader;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.Silent.class)
public class UIRegistriesReaderTest {

    @Mock
    protected RegistryReaderFactory registryReaderFactory;

    @Mock
    protected RegistryAccessor registryAccessor;

    @Mock
    protected RegistryMergeService registryMergeService;

    @Mock
    protected ReaderServiceData readerServiceData;

    @Test
    public void read() throws Exception {
        Registry registry = new Registry();
        List<Registry> registries = Lists.newArrayList(registry);
        when(registryAccessor.getUIRegistries()).thenReturn(registries);
        UIReader<Registry> singleReader = mock(UIReader.class);
        when(singleReader.read()).thenReturn(registry);
        when(registryReaderFactory.createUIRegistryReader(registry)).thenReturn(singleReader);
        when(registryMergeService.mergeByCode(registries)).thenReturn(registries);

        when(readerServiceData.getRegistryAccessor()).thenReturn(registryAccessor);
        when(readerServiceData.getRegistryMergeService()).thenReturn(registryMergeService);
        when(readerServiceData.getRegistryReaderFactory()).thenReturn(registryReaderFactory);

        UIRegistriesReader registriesReader = new UIRegistriesReader(readerServiceData);
        List<Registry> result = registriesReader.read();
        assertNotNull(result);
        assertTrue(result.size() == 1);
        assertEquals(registry, result.get(0));
    }

}
