package com.iadmin.ui.service.reader;

import com.iadmin.ui.model.Presentation;
import com.iadmin.ui.model.PresentationReference;
import com.iadmin.ui.model.Registry;

import java.util.List;
import java.util.Optional;

/**
 * Service used to resolve references
 */
public interface ReferenceService {

    /**
     * Check if registry contains references
     *
     * @param registry Interface Registry
     * @return true if @registry contains references to presentation in other registries
     */
    boolean containReferences(Registry registry);

    /**
     * Get presentation by it's reference
     *
     * @param presentationReference Reference data
     * @param registries            List of available Interface Registries
     * @return Presentation
     */
    Optional<Presentation> getReference(PresentationReference presentationReference, List<Registry> registries);
}
