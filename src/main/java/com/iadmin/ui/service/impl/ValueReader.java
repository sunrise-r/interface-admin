package com.iadmin.ui.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;

public class ValueReader<T> {

    private final String entityKey;

    private final ObjectMapper mapper;
    private final Class<T> entityClass;
    private final static String FILE_EXT = ".json";
    private final String fileEndPattern;

    public ValueReader(String entityKey, ObjectMapper mapper, Class<T> entityClass) {
        this.entityKey = entityKey;
        this.mapper = mapper;
        this.entityClass = entityClass;
        fileEndPattern = entityKey + FILE_EXT;
    }

    public T read(String file, InputStream inputStream) throws IOException {
        if (file.endsWith(fileEndPattern)) {
            return mapper.readValue(inputStream, entityClass);
        } else return null;
    }

    public String getEntityKey() {
        return entityKey;
    }

}
