package com.iadmin.ui.service.inheritance.impl;

import com.iadmin.ui.model.BaseProjection;
import com.iadmin.ui.model.Registry;
import com.iadmin.ui.service.inheritance.ExtendService;
import com.iadmin.ui.service.inheritance.InheritanceWorker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

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
        logger.info("Start applying inheritance");
        List<BaseProjection> toApply = registry.getPresentations().stream().flatMap(p -> p.getProjections().stream()).collect(Collectors.toList());
        InheritanceWorker projectionInheritanceWorker = new DefaultInheritanceWorker(toApply,new ProjectionListInheritanceStrategy());
        projectionInheritanceWorker.applyInheritance();

        toApply = registry.getPresentations().stream().flatMap(p->p.getFormProjections().stream()).collect(Collectors.toList());
        projectionInheritanceWorker = new DefaultInheritanceWorker(toApply,new ProjectionFormInheritanceStrategy());
        projectionInheritanceWorker.applyInheritance();
        return registry;
    }
}
