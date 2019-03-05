package com.iadmin.ui.service.reader.field;

import com.iadmin.ui.model.FormField;
import com.iadmin.ui.service.ReaderServiceData;
import com.iadmin.ui.service.reader.base.SingleReader;

public class FormFieldReader extends SingleReader<FormField> {

    public FormFieldReader(ReaderServiceData readerServiceData, FormField source) {
        super(readerServiceData, source);
    }

    @Override
    public FormField read() {
        return source;
    }
}
