package com.iadmin.ui.service.reader.presentation;

import com.iadmin.ui.model.Presentation;
import com.iadmin.ui.model.PresentationSettings;
import com.iadmin.ui.service.ReaderServiceData;
import com.iadmin.ui.service.reader.base.OwnedListReader;
import com.iadmin.ui.service.reader.base.UIReader;

import java.util.List;

public class PresentationSettingsListReader extends OwnedListReader<PresentationSettings, Presentation> {

    public PresentationSettingsListReader(ReaderServiceData readerServiceData, Presentation presentation) {
        super(readerServiceData, presentation);
    }

    @Override
    protected UIReader<PresentationSettings> getSingleReader(PresentationSettings source) {
        return registryReaderFactory.createPresentationSettingsReader(source);
    }

    @Override
    protected List<PresentationSettings> find() {
        return registryAccessor.getPresentationSettings(owner);
    }
}
