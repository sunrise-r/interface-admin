package com.iadmin.ui.service.reader.base;

import com.iadmin.ui.model.BaseData;
import com.iadmin.ui.service.ReaderServiceData;

public abstract class OwnedListReader<T extends BaseData, OWNER> extends ListReader<T> {

    protected final OWNER owner;

    public OwnedListReader(ReaderServiceData readerServiceData, OWNER owner) {
        super(readerServiceData);
        this.owner = owner;
    }

}
