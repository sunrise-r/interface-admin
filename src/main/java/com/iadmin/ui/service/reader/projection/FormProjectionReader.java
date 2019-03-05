package com.iadmin.ui.service.reader.projection;

import com.iadmin.ui.exception.MergeException;
import com.iadmin.ui.model.FormField;
import com.iadmin.ui.model.FormProjection;
import com.iadmin.ui.service.ReaderServiceData;
import com.iadmin.ui.service.reader.base.ListReader;
import com.iadmin.ui.service.reader.base.SingleReader;

import java.io.IOException;
import java.util.List;

public class FormProjectionReader extends SingleReader<FormProjection> {

    private final ListReader<FormField> formFieldsParser;

    public FormProjectionReader(ReaderServiceData readerServiceData, FormProjection source) {
        super(readerServiceData, source);
        formFieldsParser = registryReaderFactory.createFormFieldsReader(source);
    }

    @Override
    public FormProjection read() throws IOException, MergeException {
        source.setFields(registryMergeService.merge(source.getFields(), findFields()));
        return source;
    }

    private List<FormField> findFields() throws IOException, MergeException {
        return formFieldsParser.read();
    }
}
