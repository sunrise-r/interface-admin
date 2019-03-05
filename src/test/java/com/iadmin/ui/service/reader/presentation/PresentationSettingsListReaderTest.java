package com.iadmin.ui.service.reader.presentation;

import com.google.common.collect.Lists;
import com.iadmin.ui.exception.MergeException;
import com.iadmin.ui.model.Presentation;
import com.iadmin.ui.model.PresentationSettings;
import com.iadmin.ui.service.reader.BaseReaderTest;
import com.iadmin.ui.service.reader.base.SingleReader;
import com.iadmin.ui.service.reader.base.UIReader;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PresentationSettingsListReaderTest extends BaseReaderTest {

    @Test
    public void parse() throws IOException, MergeException {
        Presentation owner = new Presentation();
        PresentationSettings source = new PresentationSettings();
        UIReader<PresentationSettings> singleReader = mock(SingleReader.class);
        when(registryReaderFactory.createPresentationSettingsReader(source)).thenReturn(singleReader);
        when(singleReader.read()).thenReturn(source);
        List<PresentationSettings> list = Lists.newArrayList(source);
        when(registryAccessor.getPresentationSettings(owner)).thenReturn(list);
        when(registryMergeService.mergeByCode(list)).thenReturn(list);
        PresentationSettingsListReader reader = new PresentationSettingsListReader(readerServiceData, owner);
        List<PresentationSettings> result = reader.read();
        assertNotNull(result);
        assertTrue(result.size() == 1);
        assertEquals(source, result.get(0));
    }
}
