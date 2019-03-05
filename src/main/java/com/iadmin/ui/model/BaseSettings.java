package com.iadmin.ui.model;

class BaseSettings extends ChildData {

    /**
     * Достпна для просмотра?
     */
    private boolean enabled;

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
