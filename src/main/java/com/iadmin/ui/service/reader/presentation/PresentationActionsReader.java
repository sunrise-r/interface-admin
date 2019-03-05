package com.iadmin.ui.service.reader.presentation;

import com.iadmin.ui.model.Action;
import com.iadmin.ui.model.Presentation;
import com.iadmin.ui.service.ReaderServiceData;
import com.iadmin.ui.service.reader.base.OwnedListReader;
import com.iadmin.ui.service.reader.base.UIReader;

import java.util.List;

public class PresentationActionsReader extends OwnedListReader<Action, Presentation> {

    public PresentationActionsReader(ReaderServiceData readerServiceData, Presentation presentation) {
        super(readerServiceData, presentation);
    }

    @Override
    protected UIReader<Action> getSingleReader(Action source) {
        return registryReaderFactory.createActionReader(source);
    }

    @Override
    protected List<Action> find() {
        return registryAccessor.getActions(owner);
    }
}
