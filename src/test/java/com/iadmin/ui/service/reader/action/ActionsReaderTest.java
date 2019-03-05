package com.iadmin.ui.service.reader.action;

import com.google.common.collect.Lists;
import com.iadmin.ui.model.Action;
import com.iadmin.ui.model.ListProjection;
import com.iadmin.ui.service.reader.BaseReaderTest;
import com.iadmin.ui.service.reader.base.UIReader;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ActionsReaderTest extends BaseReaderTest {

    @Test
    public void parse() throws Exception {
        Action source = new Action();
        List<Action> searchResult = Lists.newArrayList(source);
        ListProjection listProjection = new ListProjection();
        when(registryAccessor.getActions(listProjection)).thenReturn(searchResult);
        UIReader<Action> actionReader = mock(UIReader.class);
        when(actionReader.read()).thenReturn(source);
        when(registryReaderFactory.createActionReader(source)).thenReturn(actionReader);
        when(registryMergeService.mergeByCode(searchResult)).thenReturn(searchResult);
        ActionsReader actionsReader = new ActionsReader(readerServiceData, listProjection);
        List<Action> result = actionsReader.read();
        assertEquals(source, result.get(0));
    }

}
