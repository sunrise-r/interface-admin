package com.iadmin.ui.service.dto;

import java.io.Serializable;
import java.util.List;

public class RegistryDto implements Serializable {

    private RegistrySettingsDto settingsDto;

    /**
     * Список доступных представлений сущности для интерфейса
     */
    private List<PresentationDto> presentationsDto;

    public RegistrySettingsDto getSettingsDto() {
        return settingsDto;
    }

    public void setSettingsDto(RegistrySettingsDto settingsDto) {
        this.settingsDto = settingsDto;
    }

    public List<PresentationDto> getPresentationsDto() {
        return presentationsDto;
    }

    public void setPresentationsDto(List<PresentationDto> presentationsDto) {
        this.presentationsDto = presentationsDto;
    }
}
