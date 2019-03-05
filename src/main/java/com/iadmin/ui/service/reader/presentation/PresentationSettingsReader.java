package com.iadmin.ui.service.reader.presentation;

import com.iadmin.ui.model.PresentationSettings;
import com.iadmin.ui.service.ReaderServiceData;
import com.iadmin.ui.service.reader.base.SingleReader;

public class PresentationSettingsReader extends SingleReader<PresentationSettings> {

    public PresentationSettingsReader(ReaderServiceData readerServiceData, PresentationSettings source) {
        super(readerServiceData, source);
    }

    @Override
    public PresentationSettings read() {
        return source;
    }
}
