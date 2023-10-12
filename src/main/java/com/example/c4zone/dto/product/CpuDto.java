package com.example.c4zone.dto.product;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class CpuDto implements Validator {
    private Long idCpu;
    private String name;
    private Boolean statusCpu = true;

    public CpuDto() {
    }

    public CpuDto(Long idCpu, String name, Boolean statusCpu) {
        this.idCpu = idCpu;
        this.name = name;
        this.statusCpu = statusCpu;
    }

    public Long getIdCpu() {
        return idCpu;
    }

    public void setIdCpu(Long idCpu) {
        this.idCpu = idCpu;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getStatusCpu() {
        return statusCpu;
    }

    public void setStatusCpu(Boolean statusCpu) {
        this.statusCpu = statusCpu;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
