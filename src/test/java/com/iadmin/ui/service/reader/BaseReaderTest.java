package com.iadmin.ui.service.reader;

import com.iadmin.ui.service.ReaderServiceData;
import com.iadmin.ui.service.RegistryAccessor;
import com.iadmin.ui.service.RegistryMergeService;
import com.iadmin.ui.service.RegistryReaderFactory;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.Silent.class)
public abstract class BaseReaderTest {

    @Mock
    protected RegistryReaderFactory registryReaderFactory;

    @Mock
    protected RegistryMergeService registryMergeService;

    @Mock
    protected ReaderServiceData readerServiceData;

    @Mock
    protected RegistryAccessor registryAccessor;

    @Before
    public void baseBefore() {
        reset(registryReaderFactory, registryMergeService, readerServiceData, registryAccessor);
        when(readerServiceData.getRegistryMergeService()).thenReturn(registryMergeService);
        when(readerServiceData.getRegistryReaderFactory()).thenReturn(registryReaderFactory);
        when(readerServiceData.getRegistryAccessor()).thenReturn(registryAccessor);
    }
}
