package com.iadmin.ui.service.reader.projection;

import com.google.common.collect.Lists;
import com.iadmin.ui.exception.MergeException;
import com.iadmin.ui.model.FormProjection;
import com.iadmin.ui.model.Presentation;
import com.iadmin.ui.service.reader.BaseReaderTest;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FormProjectionsReaderTest extends BaseReaderTest {

    @Test
    public void parse() throws IOException, MergeException {
        Presentation owner = new Presentation();
        FormProjection formProjection = new FormProjection();
        List<FormProjection> entities = Lists.newArrayList(formProjection);
        FormProjectionReader formProjectionReader = mock(FormProjectionReader.class);
        when(formProjectionReader.read()).thenReturn(formProjection);
        when(registryReaderFactory.createFormProjectionReader(formProjection)).thenReturn(formProjectionReader);
        when(registryAccessor.getFormProjections(owner)).thenReturn(entities);
        when(registryMergeService.mergeByCode(entities)).thenReturn(entities);
        FormProjectionsReader formProjectionsReader = new FormProjectionsReader(readerServiceData, owner);
        List<FormProjection> result = formProjectionsReader.read();
        assertEquals(formProjection, result.get(0));
    }
}
