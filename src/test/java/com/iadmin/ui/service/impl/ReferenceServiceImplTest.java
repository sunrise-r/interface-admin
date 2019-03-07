package com.iadmin.ui.service.impl;

import com.iadmin.ui.model.Presentation;
import com.iadmin.ui.model.PresentationReference;
import com.iadmin.ui.model.Registry;
import org.assertj.core.util.Lists;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ReferenceServiceImplTest {

    private static final String REGISTRY_CODE = "registry";
    private static final String PRESENTATION_CODE = "presentation";
    private ReferenceServiceImpl referenceService = new ReferenceServiceImpl();

    @Test
    public void containReferences() {

        Registry registry = new Registry();
        PresentationReference reference = new PresentationReference();
        registry.getPresentationReferences().add(reference);
        assertTrue(referenceService.containReferences(registry));
    }

    @Test
    public void notContainReferences() {
        Registry registry = new Registry();
        assertFalse(referenceService.containReferences(registry));
    }

    @Test
    public void getReference() {
        PresentationReference reference = new PresentationReference();
        reference.setRegistryCode(REGISTRY_CODE);
        reference.setPresentationCode(PRESENTATION_CODE);
        List<Registry> registries = Lists.newArrayList();
        Registry registry = new Registry();
        Presentation presentation = new Presentation();
        presentation.setCode(PRESENTATION_CODE);
        registry.getPresentations().add(presentation);
        registry.setCode(REGISTRY_CODE);
        registries.add(registry);
        Optional<Presentation> resultPresentation = referenceService.getReference(reference, registries);
        Assert.assertTrue(resultPresentation.get().equals(presentation));
    }
}