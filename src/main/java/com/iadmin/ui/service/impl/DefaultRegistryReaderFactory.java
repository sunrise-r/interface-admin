package com.iadmin.ui.service.impl;

import com.iadmin.ui.model.*;
import com.iadmin.ui.service.ReaderServiceData;
import com.iadmin.ui.service.RegistryMergeService;
import com.iadmin.ui.service.RegistryReaderFactory;
import com.iadmin.ui.service.ResourceRepository;
import com.iadmin.ui.service.reader.action.ActionReader;
import com.iadmin.ui.service.reader.action.ActionsReader;
import com.iadmin.ui.service.reader.base.ListReader;
import com.iadmin.ui.service.reader.base.UIReader;
import com.iadmin.ui.service.reader.field.*;
import com.iadmin.ui.service.reader.presentation.*;
import com.iadmin.ui.service.reader.projection.*;
import com.iadmin.ui.service.reader.registry.UIRegistriesReader;
import com.iadmin.ui.service.reader.registry.UIRegistryReader;
import com.iadmin.ui.service.reader.registry.UIRegistrySettingsListReader;
import com.iadmin.ui.service.reader.registry.UIRegistrySettingsReader;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.List;

public class DefaultRegistryReaderFactory implements RegistryReaderFactory {

    private final ReaderServiceData readerServiceData;

    public DefaultRegistryReaderFactory(ResourceRepository resourceRepository, RegistryMergeService registryMergeService, List<Resource> resources) throws IOException {
        readerServiceData = new DefaultReaderServiceData(this, registryMergeService, resources, resourceRepository);
    }

    @Override
    public UIReader<List<Registry>> createUIRegistriesReader() {
        return new UIRegistriesReader(readerServiceData);
    }

    @Override
    public ListReader<FormField> createFormFieldsReader(FormProjection source) {
        return new FormFieldsReader(readerServiceData, source);
    }

    @Override
    public ListReader<DataField> createDataFieldsReader(DataProjection source) {
        return new DataFieldsReader(readerServiceData, source);
    }

    @Override
    public UIReader<FormProjection> createFormProjectionReader(FormProjection source) {
        return new FormProjectionReader(readerServiceData, source);
    }

    @Override
    public UIReader<DataProjection> createDataProjectionReader(DataProjection source) {
        return new DataProjectionReader(readerServiceData, source);
    }

    @Override
    public ListReader<ListField> createListFieldsReader(ListProjection owner) {
        return new ListFieldsReader(readerServiceData, owner);
    }

    @Override
    public ListReader<Action> createActionsReader(ListProjection owner) {
        return new ActionsReader(readerServiceData, owner);
    }

    @Override
    public UIReader<ListProjection> createListProjectionReader(ListProjection source) {
        return new ListProjectionReader(readerServiceData, source);
    }

    @Override
    public UIReader<PresentationSettings> createPresentationSettingsReader(PresentationSettings source) {
        return new PresentationSettingsReader(readerServiceData, source);
    }

    @Override
    public ListReader<PresentationSettings> createPresentationSettingsListReader(Presentation presentation) {
        return new PresentationSettingsListReader(readerServiceData, presentation);
    }

    @Override
    public ListReader<ListProjection> createListProjectionsReader(Presentation presentation) {
        return new ListProjectionsReader(readerServiceData, presentation);
    }

    @Override
    public ListReader<FormProjection> createFormProjectionsReader(Presentation presentation) {
        return new FormProjectionsReader(readerServiceData, presentation);
    }

    @Override
    public ListReader<DataProjection> createDataProjectionsReader(Presentation presentation) {
        return new DataProjectionsReader(readerServiceData, presentation);
    }

    @Override
    public UIReader<Action> createActionReader(Action source) {
        return new ActionReader(readerServiceData, source);
    }

    @Override
    public UIReader<List<Action>> createPresentationActionsReader(Presentation presentation) {
        return new PresentationActionsReader(readerServiceData, presentation);
    }

    @Override
    public UIReader<Presentation> createPresentationReader(Presentation source) {
        return new PresentationReader(readerServiceData, source);
    }

    @Override
    public UIReader<Registry> createUIRegistryReader(Registry source) {
        return new UIRegistryReader(readerServiceData, source);
    }

    @Override
    public ListReader<Presentation> createPresentationsReader() {
        return new PresentationsReader(readerServiceData);
    }

    @Override
    public ListReader<RegistrySettings> createUIRegistrySettingsListReader() {
        return new UIRegistrySettingsListReader(readerServiceData);
    }

    @Override
    public UIReader<RegistrySettings> createUIRegistrySettingsReader(RegistrySettings source) {
        return new UIRegistrySettingsReader(readerServiceData, source);
    }

    @Override
    public UIReader<ListField> createListFieldReader(ListField source) {
        return new ListFieldReader(readerServiceData, source);
    }

    @Override
    public UIReader<FormField> createFormFieldReader(FormField source) {
        return new FormFieldReader(readerServiceData, source);
    }

    @Override
    public UIReader<DataField> createDataFieldReader(DataField source) {
        return new DataFieldReader(readerServiceData, source);
    }
}
