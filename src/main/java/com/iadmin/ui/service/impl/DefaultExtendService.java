package com.iadmin.ui.service.impl;

import com.iadmin.ui.model.ListProjection;
import com.iadmin.ui.model.Registry;
import com.iadmin.ui.service.ExtendService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DefaultExtendService implements ExtendService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public List<Registry> applyInheritance(List<Registry> registries) {
        return registries.stream()
                .map(this::applyInheritance)
                .collect(Collectors.toList());
    }

    @Override
    public Registry applyInheritance(Registry registry) {
        List<ListProjection> projectionRoots = new ArrayList<>();
        List<ListProjection> projectionChild = new ArrayList<>();
        registry.getPresentations()
                .stream()
                .flatMap(p -> p.getProjections().stream())
                .forEach(listProjection -> {
                    if (listProjection.getParentReference() == null)
                        projectionRoots.add(listProjection);
                    else
                        projectionChild.add(listProjection);
                });

        int prevSize = projectionChild.size();
        while (prevSize > 0) {
            for (int i = 0; i < projectionChild.size(); i++) {
                ListProjection child = projectionChild.get(i);

                ListProjection parent = getListProjection(projectionRoots, child);
                if (parent == null)
                    continue;

                child = applyInheritance(parent, child);
                projectionRoots.add(child);
                projectionChild.remove(child);
                i--;
            }
            if (projectionChild.size() == prevSize) {
                List<String> remaining = new ArrayList<>();
                projectionChild.forEach(x -> remaining.add(x.getParentCode() + "." + x.getCode()));
                logger.error("Wrong inheritance found for the: " + String.join(" ", remaining));
                return registry;
            }
            prevSize = projectionChild.size();
        }
        return registry;
    }

    private ListProjection getListProjection(List<ListProjection> projectionRoots, ListProjection child) {
        return projectionRoots.stream()
                            .filter(root -> root.getParentCode().equals(child.getParentReference().getPresentationCode()))
                            .filter(root -> root.getCode().equals(child.getParentReference().getProjectionCode()))
                            .findFirst()
                            .orElse(null);
    }

    private ListProjection applyInheritance(ListProjection parent, ListProjection child) {
        child.setActions(applyInheritance(parent.getActions(), child.getActions()));
        child.setFields(applyInheritance(parent.getFields(), child.getFields()));
        return child;
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
