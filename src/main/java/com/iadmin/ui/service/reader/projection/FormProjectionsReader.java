package com.iadmin.ui.service.reader.projection;

import com.iadmin.ui.model.FormProjection;
import com.iadmin.ui.model.Presentation;
import com.iadmin.ui.service.ReaderServiceData;
import com.iadmin.ui.service.reader.base.OwnedListReader;
import com.iadmin.ui.service.reader.base.UIReader;

import java.util.List;

public class FormProjectionsReader extends OwnedListReader<FormProjection, Presentation> {

    public FormProjectionsReader(ReaderServiceData readerServiceData, Presentation owner) {
        super(readerServiceData, owner);
    }

    @Override
    protected UIReader<FormProjection> getSingleReader(FormProjection p) {
        return registryReaderFactory.createFormProjectionReader(p);
    }

    @Override
    protected List<FormProjection> find() {
        return registryAccessor.getFormProjections(owner);
    }
}
