package com.iadmin.ui.service.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class ValidationDto implements Serializable {

    private String max;

    private String min;

    private String maxLength;

    private String minLength;

    private String mask;

    private boolean email;

    private boolean required;


    public String getMax() {
        return max;
    }

    public void setMax(String max) {
        this.max = max;
    }

    public String getMin() {
        return min;
    }

    public void setMin(String min) {
        this.min = min;
    }

    public String getMaxLength() {
        return maxLength;
    }

    public void setMaxLength(String maxLength) {
        this.maxLength = maxLength;
    }

    public String getMinLength() {
        return minLength;
    }

    public void setMinLength(String minLength) {
        this.minLength = minLength;
    }

    public String getMask() {
        return mask;
    }

    public void setMask(String mask) {
        this.mask = mask;
    }

    public boolean isRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }

    public boolean getEmail() { return email; }

    public void setEmail(boolean email) { this.email = email; }

    public ValidationDto() {
    }

    public ValidationDto(String max, String min, String maxLength, String minLength, String mask, boolean required) {
        this.max = max;
        this.min = min;
        this.maxLength = maxLength;
        this.minLength = minLength;
        this.mask = mask;
        this.required = required;
    }
}
