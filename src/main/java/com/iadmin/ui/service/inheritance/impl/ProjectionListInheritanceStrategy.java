package com.iadmin.ui.service.inheritance.impl;

import com.iadmin.ui.model.BaseProjection;
import com.iadmin.ui.model.ListProjection;
import com.iadmin.ui.service.inheritance.InheritanceStrategy;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ProjectionListInheritanceStrategy implements InheritanceStrategy {

    @Override
    public void applyTo(BaseProjection child, BaseProjection parentProjection) {
        ListProjection childListProjection = (ListProjection) child;
        ListProjection parentListProjection = (ListProjection) parentProjection;
        childListProjection.setActions(applyInheritance(parentListProjection.getActions(), childListProjection.getActions()));
        childListProjection.setFields(applyInheritance(parentListProjection.getFields(), childListProjection.getFields()));
    }

    private <T> List<T> applyInheritance(List<T> parentList, List<T> childList) {
        Collections.reverse(parentList);
        for (T t : parentList) {
            childList.add(0, t);
        }
        Collections.reverse(parentList);
        return childList.stream().distinct().collect(Collectors.toList());
    }
}