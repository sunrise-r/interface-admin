package com.iadmin.ui.service.reader.field;

import com.google.common.collect.Lists;
import com.iadmin.ui.exception.MergeException;
import com.iadmin.ui.model.ListField;
import com.iadmin.ui.model.ListProjection;
import com.iadmin.ui.service.reader.BaseReaderTest;
import com.iadmin.ui.service.reader.base.UIReader;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ListFieldsReaderTest extends BaseReaderTest {

    @Test
    public void parse() throws IOException, MergeException {
        ListProjection owner = new ListProjection();
        ListField source = new ListField();
        List<ListField> entities = Lists.newArrayList(source);
        when(registryAccessor.getListFields(owner)).thenReturn(entities);
        UIReader<ListField> listFieldReader = mock(UIReader.class);
        when(listFieldReader.read()).thenReturn(source);
        when(registryReaderFactory.createListFieldReader(source)).thenReturn(listFieldReader);
        when(registryMergeService.mergeByCode(entities)).thenReturn(entities);
        ListFieldsReader listFieldsReader = new ListFieldsReader(readerServiceData, owner);
        List<ListField> result = listFieldsReader.read();
        assertEquals(source, result.get(0));
    }

}
