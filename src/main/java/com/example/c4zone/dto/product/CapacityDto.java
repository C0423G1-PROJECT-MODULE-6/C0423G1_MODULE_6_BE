package com.example.c4zone.dto.product;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class CapacityDto implements Validator {
    private Long idCapacity;
    private String name;
    private Boolean statusCapacity = true;

    public CapacityDto() {
    }

    public Long getIdCapacity() {
        return idCapacity;
    }

    public void setIdCapacity(Long idCapacity) {
        this.idCapacity = idCapacity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getStatusCapacity() {
        return statusCapacity;
    }

    public void setStatusCapacity(Boolean statusCapacity) {
        this.statusCapacity = statusCapacity;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
