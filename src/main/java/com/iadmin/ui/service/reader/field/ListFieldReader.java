package com.iadmin.ui.service.reader.field;

import com.iadmin.ui.model.ListField;
import com.iadmin.ui.service.ReaderServiceData;
import com.iadmin.ui.service.reader.base.SingleReader;

public class ListFieldReader extends SingleReader<ListField> {

    public ListFieldReader(ReaderServiceData readerServiceData, ListField source) {
        super(readerServiceData, source);
    }

    @Override
    public ListField read() {
        return source;
    }
}
