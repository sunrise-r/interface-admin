package com.iadmin.ui.service.reader.projection;

import com.iadmin.ui.model.DataProjection;
import com.iadmin.ui.model.Presentation;
import com.iadmin.ui.service.ReaderServiceData;
import com.iadmin.ui.service.reader.base.OwnedListReader;
import com.iadmin.ui.service.reader.base.UIReader;

import java.util.List;

public class DataProjectionsReader extends OwnedListReader<DataProjection, Presentation> {

    public DataProjectionsReader(ReaderServiceData readerServiceData, Presentation owner) {
        super(readerServiceData, owner);
    }

    @Override
    protected UIReader<DataProjection> getSingleReader(DataProjection p) {
        return registryReaderFactory.createDataProjectionReader(p);
    }

    @Override
    protected List<DataProjection> find() {
        return registryAccessor.getDataProjections(owner);
    }
}
