package com.iadmin.ui.service.reader.registry;

import com.iadmin.ui.model.Registry;
import com.iadmin.ui.service.ReaderServiceData;
import com.iadmin.ui.service.reader.base.ListReader;
import com.iadmin.ui.service.reader.base.UIReader;

import java.util.List;

/**
 * Читалка списка доступных Реестров интерфейса
 */
public class UIRegistriesReader extends ListReader<Registry> {

    public UIRegistriesReader(ReaderServiceData readerServiceData) {
        super(readerServiceData);
    }


    @Override
    protected UIReader<Registry> getSingleReader(Registry source) {
        return registryReaderFactory.createUIRegistryReader(source);
    }

    @Override
    protected List<Registry> find() {
        return registryAccessor.getUIRegistries();
    }
}
