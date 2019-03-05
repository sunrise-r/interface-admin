package com.iadmin.ui.service.reader.registry;

import com.iadmin.ui.model.RegistrySettings;
import com.iadmin.ui.service.ReaderServiceData;
import com.iadmin.ui.service.reader.base.SingleReader;

public class UIRegistrySettingsReader extends SingleReader<RegistrySettings> {

    public UIRegistrySettingsReader(ReaderServiceData readerServiceData, RegistrySettings source) {
        super(readerServiceData, source);
    }

    @Override
    public RegistrySettings read() {
        return source;
    }
}
