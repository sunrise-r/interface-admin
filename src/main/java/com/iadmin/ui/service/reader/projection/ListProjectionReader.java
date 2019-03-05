package com.iadmin.ui.service.reader.projection;

import com.iadmin.ui.exception.MergeException;
import com.iadmin.ui.model.Action;
import com.iadmin.ui.model.ListField;
import com.iadmin.ui.model.ListProjection;
import com.iadmin.ui.service.ReaderServiceData;
import com.iadmin.ui.service.reader.base.ListReader;
import com.iadmin.ui.service.reader.base.UIReader;

import java.io.IOException;
import java.util.List;

public class ListProjectionReader extends UIReader<ListProjection> {

    private final ListProjection source;

    private final ListReader<ListField> listFieldsParser;

    private final ListReader<Action> actionsParser;

    public ListProjectionReader(ReaderServiceData readerServiceData, ListProjection source) {
        super(readerServiceData);
        listFieldsParser = registryReaderFactory.createListFieldsReader(source);
        actionsParser = registryReaderFactory.createActionsReader(source);
        this.source = source;
    }

    @Override
    public ListProjection read() throws IOException, MergeException {
        source.setFields(registryMergeService.merge(source.getFields(), getFields()));
        source.setActions(registryMergeService.merge(source.getActions(), getActions()));
        return source;
    }

    private List<Action> getActions() throws IOException, MergeException {
        return actionsParser.read();
    }

    private List<ListField> getFields() throws IOException, MergeException {
        return listFieldsParser.read();
    }
}
