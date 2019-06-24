package com.iadmin.ui.service.inheritance.impl;

import com.google.common.collect.Maps;
import com.iadmin.ui.model.BaseProjection;
import com.iadmin.ui.model.ParentReference;
import com.iadmin.ui.service.inheritance.InheritanceStrategy;
import com.iadmin.ui.service.inheritance.InheritanceWorker;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class DefaultInheritanceWorker implements InheritanceWorker {


    private Map<ParentReference, BaseProjection> references;

    private Set<BaseProjection> toApply;

    private Map<ParentReference, Integer> inheritanceLvlMap = Maps.newHashMap();

    private final InheritanceStrategy inheritanceStrategy;

    public DefaultInheritanceWorker(List<BaseProjection> toApply, InheritanceStrategy inheritanceStrategy) {
        references = toApply.stream()
                .collect(Collectors.toMap(p -> getProjectionReference(p), p -> p));
        this.toApply = toApply.stream().collect(Collectors.toSet());
        this.inheritanceStrategy = inheritanceStrategy;
    }

    public void applyInheritance() {
        toApply.stream().filter(p -> p.getParentReference() == null).forEach(p -> inheritanceLvlMap.put(getProjectionReference(p), 0));
        applyRecursive();
    }

    private Set<BaseProjection> applyRecursive() {
        toApply.stream().filter(p -> inheritanceLvlMap.containsKey(p.getParentReference()))
                .forEach(p -> calcAndPutToInheritanceMap(p));
        toApply = toApply.stream().filter(ta -> !inheritanceLvlMap.keySet().contains(getProjectionReference(ta))).collect(Collectors.toSet());
        if (toApply.size() > 0) {
            return applyRecursive();
        }
        return toApply;
    }

    private void calcAndPutToInheritanceMap(BaseProjection p) {
        BaseProjection parentProjection = references.get(p.getParentReference());
        Integer iLevel = inheritanceLvlMap.get(p.getParentReference()) + 1;
        inheritanceStrategy.applyTo(p, parentProjection);
        inheritanceLvlMap.put(getProjectionReference(p), iLevel);
    }

    private ParentReference getProjectionReference(BaseProjection p) {
        return new ParentReference().presentationCode(p.getParentCode()).projectionCode(p.getCode());
    }
}
