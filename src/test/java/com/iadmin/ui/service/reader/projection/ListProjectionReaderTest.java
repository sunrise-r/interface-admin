package com.iadmin.ui.service.reader.projection;

import com.google.common.collect.Lists;
import com.iadmin.ui.model.Action;
import com.iadmin.ui.model.ListField;
import com.iadmin.ui.model.ListProjection;
import com.iadmin.ui.service.reader.BaseReaderTest;
import com.iadmin.ui.service.reader.action.ActionsReader;
import com.iadmin.ui.service.reader.field.ListFieldsReader;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ListProjectionReaderTest extends BaseReaderTest {

    @Test
    public void parse() throws Exception {
        ListProjection source = new ListProjection();
        ListFieldsReader listFieldsReader = mock(ListFieldsReader.class);
        List<ListField> listFields = Lists.newArrayList();
        when(listFieldsReader.read()).thenReturn(listFields);
        when(registryReaderFactory.createListFieldsReader(source)).thenReturn(listFieldsReader);
        ActionsReader actionsReader = mock(ActionsReader.class);
        List<Action> actions = Lists.newArrayList();
        when(actionsReader.read()).thenReturn(actions);
        when(registryReaderFactory.createActionsReader(source)).thenReturn(actionsReader);
        when(registryMergeService.merge(source.getFields(), listFields)).thenReturn(listFields);
        when(registryMergeService.merge(source.getActions(), actions)).thenReturn(actions);
        ListProjectionReader listProjectionReader = new ListProjectionReader(readerServiceData, source);
        ListProjection result = listProjectionReader.read();
        assertNotNull(result);
        assertEquals(listFields, result.getFields());
        assertEquals(actions, result.getActions());
    }

}
