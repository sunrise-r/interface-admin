package com.iadmin.ui.service.reader.projection;

import com.iadmin.ui.exception.MergeException;
import com.iadmin.ui.model.DataField;
import com.iadmin.ui.model.DataProjection;
import com.iadmin.ui.service.ReaderServiceData;
import com.iadmin.ui.service.reader.base.ListReader;
import com.iadmin.ui.service.reader.base.SingleReader;

import java.io.IOException;
import java.util.List;

public class DataProjectionReader extends SingleReader<DataProjection> {

    private final ListReader<DataField> dataFieldsParser;

    public DataProjectionReader(ReaderServiceData readerServiceData, DataProjection source) {
        super(readerServiceData, source);
        dataFieldsParser = registryReaderFactory.createDataFieldsReader(source);
    }

    @Override
    public DataProjection read() throws IOException, MergeException {
        source.setFields(registryMergeService.merge(source.getFields(), findFields()));
        return source;
    }

    private List<DataField> findFields() throws IOException, MergeException {
        return dataFieldsParser.read();
    }
}
