package com.example.c4zone.dto.product;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class TypeDto implements Validator {
    private Long idType;
    private String name;
    private Boolean statusType = true;

    public TypeDto() {
    }

    public TypeDto(Long idType, String name, Boolean statusType) {
        this.idType = idType;
        this.name = name;
        this.statusType = statusType;
    }

    public Long getIdType() {
        return idType;
    }

    public void setIdType(Long idType) {
        this.idType = idType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getStatusType() {
        return statusType;
    }

    public void setStatusType(Boolean statusType) {
        this.statusType = statusType;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
// custom lại sau
    }
}
