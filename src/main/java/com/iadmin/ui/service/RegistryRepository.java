package com.iadmin.ui.service;


import com.iadmin.ui.model.Registry;

import java.util.List;

/**
 * Интерфейс репозитория по работе с реестрами интерфейсов.
 * Позволяет осуществлять поиск по загруженному реестру данных
 */
public interface RegistryRepository {

    /**
     * Найти все доступные Реестры интерфейсов
     * @return Список доступных реестров интерфейса
     */
    List<Registry> findAll();

    /**
     *
     * @param code
     * @return
     */
    Registry findByCode(String code);


}
