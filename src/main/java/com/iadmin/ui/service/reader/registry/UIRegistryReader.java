package com.iadmin.ui.service.reader.registry;

import com.iadmin.ui.exception.MergeException;
import com.iadmin.ui.model.Presentation;
import com.iadmin.ui.model.Registry;
import com.iadmin.ui.model.RegistrySettings;
import com.iadmin.ui.service.ReaderServiceData;
import com.iadmin.ui.service.reader.base.ListReader;
import com.iadmin.ui.service.reader.base.SingleReader;

import java.io.IOException;

public class UIRegistryReader extends SingleReader<Registry> {

    private final ListReader<Presentation> presentationsResourceParser;
    private final ListReader<RegistrySettings> uiRegistrySettingsParser;

    public UIRegistryReader(ReaderServiceData readerServiceData, Registry source) {
        super(readerServiceData, source);
        presentationsResourceParser = registryReaderFactory.createPresentationsReader();
        uiRegistrySettingsParser = registryReaderFactory.createUIRegistrySettingsListReader();
    }

    @Override
    public Registry read() throws IOException, MergeException {
        source.setPresentations(registryMergeService.merge(source.getPresentations(), presentationsResourceParser.read()));
        source.setSettings(registryMergeService.merge(source.getSettings(), uiRegistrySettingsParser.read()));
        return source;
    }
}
