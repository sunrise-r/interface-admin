package com.iadmin.ui.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.iadmin.ui.model.*;
import org.assertj.core.util.Sets;
import org.junit.Test;

import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DefaultValuesReaderProviderTest {

    DefaultValuesReaderProvider provider = new DefaultValuesReaderProvider(new ObjectMapper());

    @Test
    public void createReaders() {
        List<ValueReader<? extends BaseData>> readres = provider.createReaders();
        Set<String> keys = Sets.newHashSet();
        for (ValueReader<? extends BaseData> r : readres) {
            keys.add(r.getEntityKey());
        }
        assertTrue(keys.contains(Registry.class.getSimpleName()));
        assertTrue(keys.contains(RegistrySettings.class.getSimpleName()));
        assertTrue(keys.contains(Action.class.getSimpleName()));
        assertTrue(keys.contains(FormField.class.getSimpleName()));
        assertTrue(keys.contains(FormProjection.class.getSimpleName()));
        assertTrue(keys.contains(ListField.class.getSimpleName()));
        assertTrue(keys.contains(ListProjection.class.getSimpleName()));
        assertTrue(keys.contains(Presentation.class.getSimpleName()));
        assertTrue(keys.contains(PresentationSettings.class.getSimpleName()));
    }

    @Test
    public void checkCodes() {
        assertEquals(Registry.class.getSimpleName(), provider.getRegistry());
        assertEquals(RegistrySettings.class.getSimpleName(), provider.getRegistrySettings());
        assertEquals(Action.class.getSimpleName(), provider.getAction());
        assertEquals(FormField.class.getSimpleName(), provider.getFormField());
        assertEquals(FormProjection.class.getSimpleName(), provider.getFormProjection());
        assertEquals(ListField.class.getSimpleName(), provider.getListField());
        assertEquals(ListProjection.class.getSimpleName(), provider.getListProjection());
        assertEquals(Presentation.class.getSimpleName(), provider.getPresentation());
        assertEquals(PresentationSettings.class.getSimpleName(), provider.getPresentationSetting());
    }
}
