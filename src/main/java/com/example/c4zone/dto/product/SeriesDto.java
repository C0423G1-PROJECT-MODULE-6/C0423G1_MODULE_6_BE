package com.example.c4zone.dto.product;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class SeriesDto implements Validator {
    private Long idSeries;
    private String name;
    private Boolean statusSeries = true;

    public SeriesDto() {
    }

    public SeriesDto(Long idSeries, String name, Boolean statusSeries) {
        this.idSeries = idSeries;
        this.name = name;
        this.statusSeries = statusSeries;
    }

    public Long getIdSeries() {
        return idSeries;
    }

    public void setIdSeries(Long idSeries) {
        this.idSeries = idSeries;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getStatusSeries() {
        return statusSeries;
    }

    public void setStatusSeries(Boolean statusSeries) {
        this.statusSeries = statusSeries;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
