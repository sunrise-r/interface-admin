package com.iadmin.ui.service.reader.projection;

import com.iadmin.ui.model.ListProjection;
import com.iadmin.ui.model.Presentation;
import com.iadmin.ui.service.ReaderServiceData;
import com.iadmin.ui.service.reader.base.OwnedListReader;
import com.iadmin.ui.service.reader.base.UIReader;

import java.util.List;

public class ListProjectionsReader extends OwnedListReader<ListProjection, Presentation> {

    public ListProjectionsReader(ReaderServiceData readerServiceData, Presentation owner) {
        super(readerServiceData, owner);
    }

    @Override
    protected UIReader<ListProjection> getSingleReader(ListProjection source) {
        return registryReaderFactory.createListProjectionReader(source);
    }

    @Override
    protected List<ListProjection> find() {
        return registryAccessor.getListProjections(owner);
    }
}
