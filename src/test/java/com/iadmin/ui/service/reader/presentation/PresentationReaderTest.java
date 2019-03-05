package com.iadmin.ui.service.reader.presentation;

import com.google.common.collect.Lists;
import com.iadmin.ui.model.*;
import com.iadmin.ui.service.reader.BaseReaderTest;
import com.iadmin.ui.service.reader.base.ListReader;
import com.iadmin.ui.service.reader.base.UIReader;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PresentationReaderTest extends BaseReaderTest {

    @Test
    public void parse() throws Exception {
        Presentation source = new Presentation();
        UIReader<List<Action>> presentationActionsReader = mock(PresentationActionsReader.class);
        Action action = new Action();
        List<Action> actions = Lists.newArrayList(action);
        when(presentationActionsReader.read()).thenReturn(actions);
        when(registryReaderFactory.createPresentationActionsReader(source)).thenReturn(presentationActionsReader);
        when(registryMergeService.merge(source.getActions(), actions)).thenReturn(actions);

        ListReader<FormProjection> formProjectionsReader = mock(ListReader.class);
        FormProjection formProjection = new FormProjection();
        List<FormProjection> formProjections = Lists.newArrayList(formProjection);
        when(formProjectionsReader.read()).thenReturn(formProjections);
        when(registryReaderFactory.createFormProjectionsReader(source)).thenReturn(formProjectionsReader);
        when(registryMergeService.merge(source.getFormProjections(), formProjections)).thenReturn(formProjections);

        ListReader<ListProjection> listProjectionsReader = mock(ListReader.class);
        ListProjection listProjection = new ListProjection();
        List<ListProjection> listProjections = Lists.newArrayList(listProjection);
        when(listProjectionsReader.read()).thenReturn(listProjections);
        when(registryReaderFactory.createListProjectionsReader(source)).thenReturn(listProjectionsReader);
        when(registryMergeService.merge(source.getProjections(), listProjections)).thenReturn(listProjections);

        ListReader<PresentationSettings> presentationSettingsListReader = mock(ListReader.class);
        PresentationSettings ps = new PresentationSettings();
        List<PresentationSettings> presentationSettings = Lists.newArrayList(ps);
        when(presentationSettingsListReader.read()).thenReturn(presentationSettings);
        when(registryMergeService.merge(presentationSettings)).thenReturn(ps);
        when(registryMergeService.merge(source.getSettings(), ps)).thenReturn(ps);
        when(registryReaderFactory.createPresentationSettingsListReader(source)).thenReturn(presentationSettingsListReader);

        ListReader<DataProjection> dataProjectionsReader = mock(ListReader.class);
        DataProjection dataProjection = new DataProjection();
        List<DataProjection> dataProjections = Lists.newArrayList(dataProjection);
        when(dataProjectionsReader.read()).thenReturn(dataProjections);
        when(registryReaderFactory.createDataProjectionsReader(source)).thenReturn(dataProjectionsReader);
        when(registryMergeService.merge(source.getDataProjections(), dataProjections)).thenReturn(dataProjections);

        PresentationReader resourceReader = new PresentationReader(readerServiceData, source);
        Presentation presentation = resourceReader.read();
        assertEquals(actions, presentation.getActions());
        assertEquals(formProjections, presentation.getFormProjections());
        assertEquals(listProjections, presentation.getProjections());
        assertEquals(ps, presentation.getSettings());
    }

}
