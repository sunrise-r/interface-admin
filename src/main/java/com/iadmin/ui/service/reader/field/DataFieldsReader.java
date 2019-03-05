package com.iadmin.ui.service.reader.field;

import com.iadmin.ui.model.DataField;
import com.iadmin.ui.model.DataProjection;
import com.iadmin.ui.model.FormField;
import com.iadmin.ui.model.FormProjection;
import com.iadmin.ui.service.ReaderServiceData;
import com.iadmin.ui.service.reader.base.OwnedListReader;
import com.iadmin.ui.service.reader.base.UIReader;

import java.util.List;

public class DataFieldsReader extends OwnedListReader<DataField, DataProjection> {


    public DataFieldsReader(ReaderServiceData readerServiceData, DataProjection owner) {
        super(readerServiceData, owner);
    }

    @Override
    protected UIReader<DataField> getSingleReader(DataField source) {
        return registryReaderFactory.createDataFieldReader(source);
    }

    @Override
    protected List<DataField> find() {
        return registryAccessor.getDataFields(owner);
    }
}
