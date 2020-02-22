package com.iadmin.ui.service.reader.field;

import com.iadmin.ui.model.DataField;
import com.iadmin.ui.service.ReaderServiceData;
import com.iadmin.ui.service.reader.base.SingleReader;

public class DataFieldReader extends SingleReader<DataField> {

    public DataFieldReader(ReaderServiceData readerServiceData, DataField source) {
        super(readerServiceData, source);
    }

    @Override
    public DataField read() {
        return source;
    }
}
