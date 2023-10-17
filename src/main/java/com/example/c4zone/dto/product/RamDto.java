package com.example.c4zone.dto.product;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class RamDto implements Validator {
    private Long idRam;
    private String name;
    private Boolean statusRam = true;

    public RamDto() {
    }

    public RamDto(Long idRam, String name, Boolean statusRam) {
        this.idRam = idRam;
        this.name = name;
        this.statusRam = statusRam;
    }

    public Long getIdRam() {
        return idRam;
    }

    public void setIdRam(Long idRam) {
        this.idRam = idRam;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getStatusRam() {
        return statusRam;
    }

    public void setStatusRam(Boolean statusRam) {
        this.statusRam = statusRam;
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
