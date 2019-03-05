package com.iadmin.ui.service.reader.registry;

import com.iadmin.ui.model.RegistrySettings;
import com.iadmin.ui.service.ReaderServiceData;
import com.iadmin.ui.service.reader.base.ListReader;
import com.iadmin.ui.service.reader.base.UIReader;

import java.util.List;

public class UIRegistrySettingsListReader extends ListReader<RegistrySettings> {

    public UIRegistrySettingsListReader(ReaderServiceData readerServiceData) {
        super(readerServiceData);
    }

    @Override
    protected UIReader<RegistrySettings> getSingleReader(RegistrySettings source) {
        return registryReaderFactory.createUIRegistrySettingsReader(source);
    }

    @Override
    protected List<RegistrySettings> find() {
        return registryAccessor.getUIRegistrySettings();
    }
}
