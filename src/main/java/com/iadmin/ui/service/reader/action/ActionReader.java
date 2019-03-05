package com.iadmin.ui.service.reader.action;

import com.iadmin.ui.model.Action;
import com.iadmin.ui.service.ReaderServiceData;
import com.iadmin.ui.service.reader.base.SingleReader;

public class ActionReader extends SingleReader<Action> {

    public ActionReader(ReaderServiceData readerServiceData, Action source) {
        super(readerServiceData, source);
    }

    @Override
    public Action read() {
        return source;
    }
}
