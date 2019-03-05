package com.iadmin.ui.service.reader.presentation;

import com.iadmin.ui.exception.MergeException;
import com.iadmin.ui.model.*;
import com.iadmin.ui.service.ReaderServiceData;
import com.iadmin.ui.service.reader.base.UIReader;

import java.io.IOException;
import java.util.List;

public class PresentationReader extends UIReader<Presentation> {

    private final Presentation presentation;

    public PresentationReader(ReaderServiceData readerServiceData, Presentation presentation) {
        super(readerServiceData);
        this.presentation = presentation;
    }

    @Override
    public Presentation read() throws IOException, MergeException {
        presentation.setActions(registryMergeService.merge(presentation.getActions(), getActions()));
        presentation.setFormProjections(registryMergeService.merge(presentation.getFormProjections(), getFormProjection()));
        presentation.setDataProjections(registryMergeService.merge(presentation.getDataProjections(), getDataProjection()));
        presentation.setProjections(registryMergeService.merge(presentation.getProjections(), getListProjection()));
        presentation.setSettings(registryMergeService.merge(presentation.getSettings(), getPresentationSettings()));
        return presentation;
    }

    private PresentationSettings getPresentationSettings() throws IOException, MergeException {
        return registryMergeService.merge(registryReaderFactory.createPresentationSettingsListReader(presentation).read());
    }

    private List<ListProjection> getListProjection() throws IOException, MergeException {
        return registryReaderFactory.createListProjectionsReader(presentation).read();
    }

    private List<FormProjection> getFormProjection() throws IOException, MergeException {
        return registryReaderFactory.createFormProjectionsReader(presentation).read();
    }

    private List<Action> getActions() throws IOException, MergeException {
        return registryReaderFactory.createPresentationActionsReader(presentation).read();
    }

    private List<DataProjection> getDataProjection() throws IOException, MergeException {
        return registryReaderFactory.createDataProjectionsReader(presentation).read();
    }


}
