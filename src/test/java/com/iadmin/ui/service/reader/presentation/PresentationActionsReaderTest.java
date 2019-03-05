package com.iadmin.ui.service.reader.presentation;

import com.google.common.collect.Lists;
import com.iadmin.ui.exception.MergeException;
import com.iadmin.ui.model.Action;
import com.iadmin.ui.model.Presentation;
import com.iadmin.ui.service.reader.BaseReaderTest;
import com.iadmin.ui.service.reader.base.UIReader;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PresentationActionsReaderTest extends BaseReaderTest {

    @Test
    public void parse() throws IOException, MergeException {
        Presentation owner = new Presentation();
        Action source = new Action();
        UIReader<Action> singleReader = mock(UIReader.class);
        when(singleReader.read()).thenReturn(source);
        when(registryReaderFactory.createActionReader(source)).thenReturn(singleReader);
        List<Action> actions = Lists.newArrayList(source);
        when(registryAccessor.getActions(owner)).thenReturn(actions);
        when(registryMergeService.mergeByCode(actions)).thenReturn(actions);
        PresentationActionsReader presentationActionsReader = new PresentationActionsReader(readerServiceData, owner);
        List<Action> result = presentationActionsReader.read();
        assertNotNull(result);
        assertTrue(result.size() == 1);
        assertEquals(source, result.get(0));
    }
}
