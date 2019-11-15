package com.iadmin.ui.service.dto;

import java.util.HashMap;

public class PropertiesFieldDto implements Serializable {
    private HashMap<String,Object> properties;

    public HashMap<String, Object> getProperties() {
        return properties;
    }

    public void setProperties(HashMap<String, Object> properties) {
        this.properties = properties;
    }
}
