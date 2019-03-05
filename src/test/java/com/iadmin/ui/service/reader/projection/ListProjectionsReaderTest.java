package com.iadmin.ui.service.reader.projection;

import com.google.common.collect.Lists;
import com.iadmin.ui.exception.MergeException;
import com.iadmin.ui.model.ListProjection;
import com.iadmin.ui.model.Presentation;
import com.iadmin.ui.service.reader.BaseReaderTest;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ListProjectionsReaderTest extends BaseReaderTest {

    @Test
    public void parse() throws IOException, MergeException {
        Presentation owner = new Presentation();
        ListProjection listProjection = new ListProjection();
        List<ListProjection> listProjections = Lists.newArrayList(listProjection);
        when(registryAccessor.getListProjections(owner)).thenReturn(listProjections);
        ListProjectionReader listProjectionReader = mock(ListProjectionReader.class);
        when(listProjectionReader.read()).thenReturn(listProjection);
        when(registryReaderFactory.createListProjectionReader(listProjection)).thenReturn(listProjectionReader);
        when(registryMergeService.mergeByCode(listProjections)).thenReturn(listProjections);
        ListProjectionsReader listProjectionsReader = new ListProjectionsReader(readerServiceData, owner);
        List<ListProjection> result = listProjectionsReader.read();
        assertNotNull(result);
        assertEquals(listProjection, result.get(0));
    }

}
