package com.iadmin.ui.model;

/**
 * Represents reference to some presentation
 * Used to create Interface Regestries that contains reference to presentations from other registries
 */
public class PresentationReference {

    /**
     * Code of Interface Registry that contains presentation reference
     */
    private String registryCode;

    /**
     * Code of presentation.
     */
    private String  presentationCode;

    public String getRegistryCode() {
        return registryCode;
    }

    public void setRegistryCode(String registryCode) {
        this.registryCode = registryCode;
    }

    public String getPresentationCode() {
        return presentationCode;
    }

    public void setPresentationCode(String presentationCode) {
        this.presentationCode = presentationCode;
    }
}
