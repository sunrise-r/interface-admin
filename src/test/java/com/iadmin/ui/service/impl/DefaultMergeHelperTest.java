package com.iadmin.ui.service.impl;

import com.google.common.collect.Lists;
import com.iadmin.ui.model.Presentation;
import com.iadmin.ui.model.Registry;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class DefaultMergeHelperTest {

    private DefaultMergeHelper mergeHelper = new DefaultMergeHelper();

    @Test
    public void mergeNonConflictTest() throws Exception {
        final String registryCode = "registryCode";
        final String name = "name";
        Presentation p1 = new Presentation();
        Presentation p2 = new Presentation();
        Presentation p3 = new Presentation();
        p1.setCode("code1");
        p2.setCode("code2");
        p3.setCode("code3");
        final List<Presentation> presentations = Lists.newArrayList();
        Registry one = new Registry();
        Registry two = new Registry();
        one.setCode(registryCode);
        two.setCode(registryCode);
        one.setLabel(name);
        presentations.add(p1);
        presentations.add(p2);
        two.setPresentations(presentations);
        one.setPresentations(new ArrayList<>());

        one.getPresentations().add(p3);
        Registry result = mergeHelper.mergeObjects(one, two);
        assertEquals(name, result.getLabel());
        assertEquals(3, result.getPresentations().size());
        assertEquals(registryCode, result.getCode());

        result = mergeHelper.mergeObjects(one, null);
        assertEquals(one.getCode(), result.getCode());
        result = mergeHelper.mergeObjects(null, two);
        assertEquals(two.getCode(), result.getCode());

    }
}
