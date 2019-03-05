package com.iadmin.ui.service.impl;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.iadmin.ui.model.*;
import com.iadmin.ui.service.RegistryAccessor;
import com.iadmin.ui.service.ValueReadersProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

public class DefaultRegistryAccessor implements RegistryAccessor {

    private static final Logger log = LoggerFactory.getLogger(DefaultRegistryAccessor.class);

    private final ValueReadersProvider provider;

    private final Map<String, List<BaseData>> groupedData;

    private final Map<String, List<ChildData>> presentationSettings;

    private final Map<String, List<ChildData>> listProjections;

    private final Map<String, List<ChildData>> formFields;

    private final Map<String, List<ChildData>> dataFields;

    private final Map<String, List<ChildData>> formProjections;

    private final Map<String, List<ChildData>> dataProjections;

    private final Map<String, List<ChildData>> listFields;

    private Map<String, List<ChildData>> actions;

    /**
     * При создание объекта происходить групировка данных по ключу родительской записи
     *
     * @param groupedData Данные сгруппированные по "типу данных"
     */
    DefaultRegistryAccessor(ValueReadersProvider provider, Map<String, List<BaseData>> groupedData) {
        this.provider = provider;
        this.groupedData = groupedData;
        presentationSettings = groupByParent(groupedData.get(provider.getPresentationSetting()));
        listProjections = groupByParent(groupedData.get(provider.getListProjection()));
        formFields = groupByParent(groupedData.get(provider.getFormField()));
        dataFields = groupByParent(groupedData.get(provider.getDataField()));
        formProjections = groupByParent(groupedData.get(provider.getFormProjection()));
        listFields = groupByParent(groupedData.get(provider.getListField()));
        actions = groupByParent(groupedData.get(provider.getAction()));
        dataProjections = groupByParent(groupedData.get(provider.getDataProjection()));
    }

    /**
     * Сгрупировать данные по родительскому ключу
     *
     * @param datas Данные об интерфейсе
     * @return Словарь данных, где ключем является код родительской записи
     */
    private Map<String, List<ChildData>> groupByParent(List<BaseData> datas) {
        Map<String, List<ChildData>> result = Maps.newHashMap();
        for (BaseData baseData : datas) {
            if (baseData instanceof ChildData) {
                ChildData p = (ChildData) baseData;
                if (!result.containsKey(p.getParentCode())) {
                    result.put(p.getParentCode(), Lists.newArrayList());
                }
                result.get(p.getParentCode()).add(p);
                log.debug("Interface description groupded as {}", p);
            }
        }
        return result;
    }


    @Override
    public List<Registry> getUIRegistries() {
        return (List) groupedData.get(provider.getRegistry());
    }


    @Override
    public List<RegistrySettings> getUIRegistrySettings() {
        return (List) groupedData.get(provider.getRegistrySettings());
    }

    @Override
    public List<Presentation> getPresentations() {
        return (List) groupedData.get(provider.getPresentation());
    }

    @Override
    public List<PresentationSettings> getPresentationSettings(Presentation presentation) {
        return (List) presentationSettings.get(presentation.getCode());
    }

    @Override
    public List<ListProjection> getListProjections(Presentation presentation) {
        return (List) listProjections.get(presentation.getCode());
    }

    @Override
    public List<FormField> getFormFields(FormProjection formProjection) {
        return (List) formFields.get(formProjection.getCode());
    }

    @Override
    public List<DataField> getDataFields(DataProjection dataProjection) {
        return (List) dataFields.get(dataProjection.getCode());
    }

    @Override
    public List<FormProjection> getFormProjections(Presentation presentation) {
        return (List) formProjections.get(presentation.getCode());
    }

    @Override
    public List<DataProjection> getDataProjections(Presentation presentation) {
        return (List) dataProjections.get(presentation.getCode());
    }

    @Override
    public List<ListField> getListFields(ListProjection listProjection) {
        return (List) listFields.get(listProjection.getCode());
    }

    @Override
    public List<Action> getActions(BaseData parentData) {
        return (List) actions.get(parentData.getCode());
    }
}
