package com.example.c4zone.dto.product;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


public class ImageDto implements Validator {
    private Long idImage;
    private String name;
    private Boolean statusImage = true;
    private Long product;

    public ImageDto() {
    }

    public ImageDto(Long idImage, String name, Boolean statusImage, Long product) {
        this.idImage = idImage;
        this.name = name;
        this.statusImage = statusImage;
        this.product = product;
    }

    public Long getIdImage() {
        return idImage;
    }

    public void setIdImage(Long idImage) {
        this.idImage = idImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getStatusImage() {
        return statusImage;
    }

    public void setStatusImage(Boolean statusImage) {
        this.statusImage = statusImage;
    }

    public Long getProduct() {
        return product;
    }

    public void setProduct(Long product) {
        this.product = product;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
    // Custom lại sau
    }
}
