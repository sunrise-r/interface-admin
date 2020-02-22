package com.iadmin.ui.service.impl;

import com.iadmin.ui.model.Presentation;
import com.iadmin.ui.model.PresentationReference;
import com.iadmin.ui.model.Registry;
import com.iadmin.ui.service.reader.ReferenceService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReferenceServiceImpl implements ReferenceService {

    @Override
    public boolean containReferences(Registry registry) {
        if (registry.getPresentationReferences() == null) {
            return false;
        }
        return registry.getPresentationReferences().size() > 0;
    }

    @Override
    public Optional<Presentation> getReference(PresentationReference presentationReference, List<Registry> registries) {
        return registries.stream()
                .filter(r -> r.getCode().equals(presentationReference.getRegistryCode()))
                .flatMap(r -> r.getPresentations().stream())
                .filter(p -> p.getCode().equals(presentationReference.getPresentationCode()))
                .findFirst();
    }
}
