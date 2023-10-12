package com.example.c4zone.dto.product;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class ColorDto implements Validator {
    private Long idColor;
    private String name;
    private Boolean statusColor = true;

    public ColorDto() {
    }

    public ColorDto(Long idColor, String name, Boolean statusColor) {
        this.idColor = idColor;
        this.name = name;
        this.statusColor = statusColor;
    }

    public Long getIdColor() {
        return idColor;
    }

    public void setIdColor(Long idColor) {
        this.idColor = idColor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getStatusColor() {
        return statusColor;
    }

    public void setStatusColor(Boolean statusColor) {
        this.statusColor = statusColor;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
