package com.iadmin.ui.service.impl;

import com.google.common.collect.Lists;
import com.iadmin.ui.model.*;
import com.iadmin.ui.service.RegistryMergeService;
import com.iadmin.ui.service.ResourceRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class DefaultRegistryReaderFactoryTest {

    @Mock
    private ResourceRepository resourceRepository;

    @Mock
    private RegistryMergeService registryMergeService;

    private List<Resource> resources = Lists.newArrayList();

    private DefaultRegistryReaderFactory factory;

    @Before
    public void before() throws IOException {
        factory = new DefaultRegistryReaderFactory(resourceRepository,registryMergeService,resources);
    }

    @Test
    public void createUIRegistriesReader() {

        Action action = new Action();
        FormField formField= new FormField();
        ListProjection listProjection = new ListProjection();
        Presentation presentation = new Presentation();
        FormProjection formProjection = new FormProjection();
        Registry registry = new Registry();
        ListField listField = new ListField();
        RegistrySettings registrySettings = new RegistrySettings();
        PresentationSettings presentationSettings = new PresentationSettings();

        assertNotNull(factory.createUIRegistriesReader());
        assertNotNull(factory.createActionReader(action));
        assertNotNull(factory.createActionsReader(listProjection));
        assertNotNull(factory.createFormFieldReader(formField));
        assertNotNull(factory.createFormFieldsReader(formProjection));
        assertNotNull(factory.createFormProjectionReader(formProjection));
        assertNotNull(factory.createFormProjectionsReader(presentation));
        assertNotNull(factory.createListFieldReader(listField));
        assertNotNull(factory.createListFieldsReader(listProjection));
        assertNotNull(factory.createListProjectionReader(listProjection));
        assertNotNull(factory.createListProjectionsReader(presentation));
        assertNotNull(factory.createPresentationActionsReader(presentation));
        assertNotNull(factory.createPresentationReader(presentation));
        assertNotNull(factory.createPresentationSettingsListReader(presentation));
        assertNotNull(factory.createPresentationSettingsReader(presentationSettings));
        assertNotNull(factory.createPresentationsReader());
        assertNotNull(factory.createUIRegistriesReader());
        assertNotNull(factory.createUIRegistryReader(registry));
        assertNotNull(factory.createUIRegistrySettingsListReader());
        assertNotNull(factory.createUIRegistrySettingsReader(registrySettings));
    }

}
