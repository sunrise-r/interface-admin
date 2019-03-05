package com.iadmin.ui.service.reader.base;

import com.iadmin.ui.service.ReaderServiceData;

public abstract class SingleReader<T> extends UIReader<T> {

    protected final T source;

    public SingleReader(ReaderServiceData readerServiceData, T source) {
        super(readerServiceData);
        this.source = source;
    }
}
