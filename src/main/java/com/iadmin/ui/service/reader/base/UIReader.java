package com.iadmin.ui.service.reader.base;

import com.iadmin.ui.exception.MergeException;
import com.iadmin.ui.service.ReaderServiceData;
import com.iadmin.ui.service.RegistryAccessor;
import com.iadmin.ui.service.RegistryMergeService;
import com.iadmin.ui.service.RegistryReaderFactory;

import java.io.IOException;

public abstract class UIReader<T> {

    protected final RegistryReaderFactory registryReaderFactory;

    protected final RegistryMergeService registryMergeService;

    protected final RegistryAccessor registryAccessor;

    public UIReader(ReaderServiceData readerServiceData) {
        registryReaderFactory = readerServiceData.getRegistryReaderFactory();
        registryMergeService = readerServiceData.getRegistryMergeService();
        registryAccessor = readerServiceData.getRegistryAccessor();
    }

    public abstract T read() throws IOException, MergeException;
}
