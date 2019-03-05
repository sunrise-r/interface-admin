package com.iadmin.ui.service.reader.field;

import com.iadmin.ui.model.ListField;
import com.iadmin.ui.model.ListProjection;
import com.iadmin.ui.service.ReaderServiceData;
import com.iadmin.ui.service.reader.base.OwnedListReader;
import com.iadmin.ui.service.reader.base.UIReader;

import java.util.List;

public class ListFieldsReader extends OwnedListReader<ListField, ListProjection> {

    public ListFieldsReader(ReaderServiceData readerServiceData, ListProjection listProjection) {
        super(readerServiceData, listProjection);
    }

    @Override
    protected UIReader<ListField> getSingleReader(ListField source) {
        return registryReaderFactory.createListFieldReader(source);
    }

    @Override
    protected List<ListField> find() {
        return registryAccessor.getListFields(owner);
    }
}
