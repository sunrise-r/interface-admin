package com.iadmin.ui.service.reader.action;

import com.iadmin.ui.model.Action;
import com.iadmin.ui.model.ListProjection;
import com.iadmin.ui.service.ReaderServiceData;
import com.iadmin.ui.service.reader.base.OwnedListReader;
import com.iadmin.ui.service.reader.base.UIReader;

import java.util.List;

public class ActionsReader extends OwnedListReader<Action, ListProjection> {

    public ActionsReader(ReaderServiceData readerServiceData, ListProjection listProjection) {
        super(readerServiceData, listProjection);
    }

    @Override
    protected UIReader<Action> getSingleReader(Action source) {
        return registryReaderFactory.createActionReader(source);
    }

    @Override
    protected List<Action> find() {
        return  registryAccessor.getActions(owner);
    }
}
