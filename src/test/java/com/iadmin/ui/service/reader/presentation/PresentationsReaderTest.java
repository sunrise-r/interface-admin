package com.iadmin.ui.service.reader.presentation;

import com.google.common.collect.Lists;
import com.iadmin.ui.exception.MergeException;
import com.iadmin.ui.model.Presentation;
import com.iadmin.ui.service.reader.BaseReaderTest;
import com.iadmin.ui.service.reader.base.UIReader;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PresentationsReaderTest extends BaseReaderTest {

    @Test
    public void parse() throws IOException, MergeException {
        Presentation source = new Presentation();
        UIReader<Presentation> singleReader = mock(UIReader.class);
        when(singleReader.read()).thenReturn(source);
        when(registryReaderFactory.createPresentationReader(source)).thenReturn(singleReader);
        List<Presentation> presentations = Lists.newArrayList(source);
        when(registryAccessor.getPresentations()).thenReturn(presentations);
        when(registryMergeService.mergeByCode(presentations)).thenReturn(presentations);
        PresentationsReader reader = new PresentationsReader(readerServiceData);
        List<Presentation> result = reader.read();
        assertNotNull(result);
        assertTrue(result.size() == 1);
        assertEquals(source, result.get(0));
    }

}
