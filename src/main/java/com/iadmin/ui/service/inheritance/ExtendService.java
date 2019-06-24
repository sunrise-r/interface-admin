package com.iadmin.ui.service.inheritance;

import com.iadmin.ui.model.Registry;

import java.io.IOException;
import java.util.List;

public interface ExtendService {

    /**
     * Применить наследование для всех данных в реестрах
     */
    List<Registry> applyInheritance(List<Registry> registries);

    /**
     * Применить наследование для всех данных в реестре
     */
    Registry applyInheritance(Registry registry) throws IOException;
}
