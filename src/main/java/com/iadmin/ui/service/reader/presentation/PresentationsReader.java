package com.iadmin.ui.service.reader.presentation;

import com.iadmin.ui.model.Presentation;
import com.iadmin.ui.service.ReaderServiceData;
import com.iadmin.ui.service.reader.base.ListReader;
import com.iadmin.ui.service.reader.base.UIReader;

import java.util.List;

public class PresentationsReader extends ListReader<Presentation> {

    public PresentationsReader(ReaderServiceData readerServiceData) {
        super(readerServiceData);
    }

    @Override
    protected UIReader<Presentation> getSingleReader(Presentation p) {
        return registryReaderFactory.createPresentationReader(p);
    }

    @Override
    protected List<Presentation> find() {
        return registryAccessor.getPresentations();
    }

}
