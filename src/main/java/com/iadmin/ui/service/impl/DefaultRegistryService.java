package com.iadmin.ui.service.impl;

import com.iadmin.ui.exception.MergeException;
import com.iadmin.ui.model.*;
import com.iadmin.ui.service.RegistryService;
import com.iadmin.ui.service.ResourceService;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Сервис для работы с UIRegisty, одна из основных фукний это:
 * Сканнер ресурсов который позволяет найти все возможные опеределения интерфейса и собрать их воедино.(And rule them all)
 * и представить их виде списка Реестров Интерфейсов.
 */
@Service
public class DefaultRegistryService implements RegistryService {

    private final ResourceService defaultResourceService;

    public DefaultRegistryService(ResourceService defaultResourceService) {
        this.defaultResourceService = defaultResourceService;
    }

    @Override
    public Registry createSampleUiRegistry() {
        Registry registry = new Registry();
        registry.setCode("sampleRegistryCode");
        registry.setLabel("Sample Registry");
        registry.setPresentations(createSamplePresentations(registry.getCode()));
        registry.setSettings(createSampleSettings(registry.getCode()));
        return registry;
    }


    /**
     * Сканирует ресурсы и строит на основе их список доступных интерфейсов
     * На основе даного списка будет сроиться пользовательский интерфейс iadmin
     *
     * @return Список доступных реестров интерфейсов.
     * @throws IOException Возникает при ошибке в чтениии ресурса.
     */
    @Override
    public List<Registry> loadRegistries() throws IOException, MergeException {
        List<Resource> resources = defaultResourceService.getResources(defaultResourceService.getScanPath());
        return defaultResourceService.read(resources);
    }

    private RegistrySettings createSampleSettings(String parentCode) {
        RegistrySettings registrySettings = new RegistrySettings();
        registrySettings.setEnabled(true);
        registrySettings.setCode("sampleSettingsCode");
        registrySettings.setLabel("Sample settings name");
        registrySettings.setParentCode(parentCode);
        return registrySettings;
    }

    private List<Presentation> createSamplePresentations(String parentCode) {
        final int count = 2;
        List<Presentation> presentations = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            presentations.add(createSamplePresentation(parentCode));
        }
        return presentations;
    }

    private Presentation createSamplePresentation(String parentCode) {
        Presentation presentation = new Presentation();
        presentation.setLabel("Sample Presentation Name");
        presentation.setCode("samplePresentationCode");
        presentation.setParentCode(parentCode);
        presentation.setActions(createSampleActions(presentation.getParentCode()));
        presentation.setFormProjections(createSampleFormProjections(presentation.getCode()));
        presentation.setProjections(createSampleListProjections(presentation.getCode()));
        presentation.setSettings(createSamplePresentationSettings(presentation.getCode()));
        return presentation;
    }

    private List<ListProjection> createSampleListProjections(String parentCode) {
        final int count = 3;
        List<ListProjection> listProjections = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            listProjections.add(createSampleListProjection(parentCode));
        }
        return listProjections;

    }

    private ListProjection createSampleListProjection(String parentCode) {
        ListProjection listProjection = new ListProjection();
        listProjection.setDescription("List projection description");
        listProjection.setCode("listProjectionCode");
        listProjection.setDisplayType("listPorjectionDisplayType");
        listProjection.setLabel("List projection name");
        listProjection.setParentCode(parentCode);
        listProjection.setActions(createSampleActions(listProjection.getCode()));
        listProjection.setFields(createSampleListFields(listProjection.getCode()));
        return listProjection;
    }

    private List<ListField> createSampleListFields(String parentCode) {
        final int count = 2;
        List<ListField> listFields = new ArrayList<>(count);
        for (int i = 0; i < 2; i++) {
            listFields.add(createSampleListField(parentCode));
        }
        return listFields;
    }

    private ListField createSampleListField(String parentCode) {
        ListField listField = new ListField();
        listField.setSorting(true);
        listField.setCode("sampleListFieldCode");
        listField.setTranslationCode("sampleListFieldTranslationCode");
        listField.setDisplayFormat("sampleListFieldDisplayFormat");
        listField.setLabel("List field name");
        listField.setParentCode(parentCode);
        return listField;
    }

    private PresentationSettings createSamplePresentationSettings(String code) {
        PresentationSettings presentationSettings = new PresentationSettings();
        presentationSettings.setEnabled(true);
        presentationSettings.setParentCode(code);
        presentationSettings.setCode("samplePresentationSettingsCode");
        presentationSettings.setLabel("samplePresentationSettingsName");
        return presentationSettings;
    }

    private List<FormProjection> createSampleFormProjections(String parentCode) {
        final int count = 2;
        List<FormProjection> formProjections = new ArrayList<>(count);
        for (int i = 0; i < 2; i++) {
            formProjections.add(createSampleFormProjection(parentCode));
        }
        return formProjections;
    }

    private FormProjection createSampleFormProjection(String parentCode) {
        FormProjection formProjection = new FormProjection();
        formProjection.setCode("sampleFormProjectionCode");
        formProjection.setLabel("Sample FormProjection Name");
        formProjection.setDisplayType("sampleDisplayType");
        formProjection.setDescription("Form Projection Description");
        formProjection.setParentCode(parentCode);
        formProjection.setFields(createSampleFormFields(formProjection.getParentCode()));
        return formProjection;
    }

    private List<FormField> createSampleFormFields(String parentCode) {
        final int count = 7;
        List<FormField> formFields = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            formFields.add(createSampleFormField(parentCode));
        }
        return formFields;
    }

    private FormField createSampleFormField(String parentCode) {
        FormField formField = new FormField();
        int count = 3;
        List<String> validations = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            validations.add("validationNumber_" + i);
        }
        formField.setFieldLength("");
        formField.setRequired(false);
        formField.setCode("sampleFormFieldCode");
        formField.setDisplayFormat("sampleFormFieldDisplayFormat");
        formField.setLabel("Sample form field name");
        formField.setParentCode(parentCode);
        return formField;
    }

    private List<Action> createSampleActions(String parentCode) {
        final int count = 3;
        List<Action> actions = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            actions.add(createSampleAction(parentCode));
        }
        return actions;
    }

    private Action createSampleAction(String parentCode) {
        Action action = new Action();
        action.setDisplayType("sampleActionDisplayType");
        action.setCode("sampleActionCode");
        action.setLabel("Sample action name");
        action.setParentCode(parentCode);
        return action;
    }

}
