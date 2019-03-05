package com.iadmin.ui.service.reader.field;

import com.iadmin.ui.model.FormField;
import com.iadmin.ui.model.FormProjection;
import com.iadmin.ui.service.ReaderServiceData;
import com.iadmin.ui.service.reader.base.OwnedListReader;
import com.iadmin.ui.service.reader.base.UIReader;

import java.util.List;

public class FormFieldsReader extends OwnedListReader<FormField, FormProjection> {


    public FormFieldsReader(ReaderServiceData readerServiceData, FormProjection owner) {
        super(readerServiceData, owner);
    }

    @Override
    protected UIReader<FormField> getSingleReader(FormField source) {
        return registryReaderFactory.createFormFieldReader(source);
    }

    @Override
    protected List<FormField> find() {
        return registryAccessor.getFormFields(owner);
    }
}
