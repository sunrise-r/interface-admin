package com.iadmin.ui.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import com.iadmin.ui.model.*;
import com.iadmin.ui.service.ValueReadersProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultValuesReaderProvider implements ValueReadersProvider {

    private static final String REGISTRY = Registry.class.getSimpleName();
    private static final String REGISTRY_SETTINGS = RegistrySettings.class.getSimpleName();
    private static final String ACTION = Action.class.getSimpleName();
    private static final String FORM_FIELD = FormField.class.getSimpleName();
    private static final String DATA_FIELD = DataField.class.getSimpleName();
    private static final String FORM_PROJECTION = FormProjection.class.getSimpleName();
    private static final String LIST_FIELD = ListField.class.getSimpleName();
    private static final String LIST_PROJECTION = ListProjection.class.getSimpleName();
    private static final String PRESENTATION = Presentation.class.getSimpleName();
    private static final String PRESENTATION_SETTING = PresentationSettings.class.getSimpleName();
    private static final String DATA_PROJECTION = DataProjection.class.getSimpleName();
    private final ObjectMapper mapper;

    @Autowired
    public DefaultValuesReaderProvider(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<ValueReader<? extends BaseData>> createReaders() {
        List<ValueReader<? extends BaseData>> valueReaders = Lists.newArrayList();
        valueReaders.add(new ValueReader<>(REGISTRY, mapper, Registry.class));
        valueReaders.add(new ValueReader<>(REGISTRY_SETTINGS, mapper, RegistrySettings.class));
        valueReaders.add(new ValueReader<>(ACTION, mapper, Action.class));
        valueReaders.add(new ValueReader<>(FORM_FIELD, mapper, FormField.class));
        valueReaders.add(new ValueReader<>(DATA_FIELD, mapper, DataField.class));
        valueReaders.add(new ValueReader<>(FORM_PROJECTION, mapper, FormProjection.class));
        valueReaders.add(new ValueReader<>(DATA_PROJECTION, mapper, DataProjection.class));
        valueReaders.add(new ValueReader<>(LIST_FIELD, mapper, ListField.class));
        valueReaders.add(new ValueReader<>(LIST_PROJECTION, mapper, ListProjection.class));
        valueReaders.add(new ValueReader<>(PRESENTATION, mapper, Presentation.class));
        valueReaders.add(new ValueReader<>(PRESENTATION_SETTING, mapper, PresentationSettings.class));
        return valueReaders;
    }

    @Override
    public String getRegistry() {
        return REGISTRY;
    }

    @Override
    public String getRegistrySettings() {
        return REGISTRY_SETTINGS;
    }

    @Override
    public String getAction() {
        return ACTION;
    }

    @Override
    public String getFormField() {
        return FORM_FIELD;
    }

    @Override
    public String getFormProjection() {
        return FORM_PROJECTION;
    }

    @Override
    public String getListField() {
        return LIST_FIELD;
    }

    @Override
    public String getListProjection() {
        return LIST_PROJECTION;
    }

    @Override
    public String getPresentation() {
        return PRESENTATION;
    }

    @Override
    public String getPresentationSetting() {
        return PRESENTATION_SETTING;
    }

    @Override
    public String getDataProjection() {
        return DATA_PROJECTION;
    }

    @Override
    public String getDataField() {
        return DATA_FIELD;
    }
}
