package com.iadmin.ui.service.inheritance.impl;

import com.iadmin.ui.model.BaseProjection;
import com.iadmin.ui.model.FormField;
import com.iadmin.ui.model.FormProjection;
import com.iadmin.ui.service.inheritance.InheritanceStrategy;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProjectionFormInheritanceStrategy implements InheritanceStrategy {

    @Override
    public void applyTo(BaseProjection child, BaseProjection parent) {
        FormProjection childFormProjection = (FormProjection) child;
        FormProjection parentFormProjection = (FormProjection) parent;
        childFormProjection.setFields(inherit(childFormProjection.getFields(), parentFormProjection.getFields()));
        if (childFormProjection.getMethod() == null) {
            childFormProjection.setMethod(parentFormProjection.getMethod());
        }
        if (childFormProjection.getActionUrl() == null) {
            childFormProjection.setActionUrl(parentFormProjection.getActionUrl());
        }
        if (childFormProjection.getFormType() == null) {
            childFormProjection.setFormType(parentFormProjection.getFormType());
        }
    }

    private List<FormField> inherit(List<FormField> child, List<FormField> parent) {
        return Stream.concat(child.stream(), parent.stream()).distinct().collect(Collectors.toList());
    }
}
