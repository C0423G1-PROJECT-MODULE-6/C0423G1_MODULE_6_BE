package com.example.c4zone.dto.product;

import com.example.c4zone.model.product.*;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.*;

public class ProductDto implements Validator {
    private Long idProduct;
    @NotBlank(message = "Không được để trống tên điện thoại!")
    @Size(min = 5, max = 50, message = "Phải lớn hơn 5 ký tự và ít hơn 50 ký tự!")
    private String nameProduct;
    @NotBlank(message = "Không được để trống màn hình!")
    @Size(min = 5, max = 100, message = "Nhập vào ít nhất 5 ký tự và nhỏ hơn 100 ký tự!")
    private String screenProduct;
    @NotBlank(message = "Không được để trống camera!")
    @Size(min = 5, max = 100, message = "Nhập vào ít nhất 5 ký tự và nhỏ hơn 100 ký tự!")
    private String cameraProduct;
    @Size(max = 10000, message = "Mô tả không được quá 10000 từ!")
    private String descriptionProduct;
    private Boolean statusBusiness = true;
    @NotBlank(message = "Không được để trống camera trước!")
    @Size(min = 5, max = 100, message = "Nhập vào ít nhất 5 ký tự và nhỏ hơn 100 ký tự!")
    private String selfieProduct;
    @NotBlank(message = "Không được để trống tên điện thoại!")
    private String batteryProduct;
    @NotNull(message = "Không được để trống trọng lượng điện thoại!")
    @Min(10)
    @Max(500)
    private Double weightProduct;
    @NotNull(message = "Không được để trống số lượng điện thoại!")
    @Min(0)
    private Double quantityProduct;
    @NotNull(message = "Không được để trống giá điện thoại!")
    @Min(0)
    @Max(30000000)
    private Double priceProduct;
    private ImageDto imageDto;
    private Capacity capacity;
    private Color color;
    private Cpu cpu;
    private Ram ram;
    private Series series;
    private Type type;

    public ProductDto() {
    }

    public ProductDto(Long idProduct, String nameProduct, String screenProduct, String cameraProduct, String descriptionProduct, Boolean statusBusiness, String selfieProduct, String batteryProduct, Double weightProduct, Double quantityProduct, Double priceProduct, ImageDto imageDto, Capacity capacity, Color color, Cpu cpu, Ram ram, Series series, Type type) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.screenProduct = screenProduct;
        this.cameraProduct = cameraProduct;
        this.descriptionProduct = descriptionProduct;
        this.statusBusiness = statusBusiness;
        this.selfieProduct = selfieProduct;
        this.batteryProduct = batteryProduct;
        this.weightProduct = weightProduct;
        this.quantityProduct = quantityProduct;
        this.priceProduct = priceProduct;
        this.imageDto = imageDto;
        this.capacity = capacity;
        this.color = color;
        this.cpu = cpu;
        this.ram = ram;
        this.series = series;
        this.type = type;
    }

    public ImageDto getImageDto() {
        return imageDto;
    }

    public void setImageDto(ImageDto imageDto) {
        this.imageDto = imageDto;
    }

    public Long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Long idProduct) {
        this.idProduct = idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getScreenProduct() {
        return screenProduct;
    }

    public void setScreenProduct(String screenProduct) {
        this.screenProduct = screenProduct;
    }

    public String getCameraProduct() {
        return cameraProduct;
    }

    public void setCameraProduct(String cameraProduct) {
        this.cameraProduct = cameraProduct;
    }

    public String getDescriptionProduct() {
        return descriptionProduct;
    }

    public void setDescriptionProduct(String descriptionProduct) {
        this.descriptionProduct = descriptionProduct;
    }

    public Boolean getStatusBusiness() {
        return statusBusiness;
    }

    public void setStatusBusiness(Boolean statusBusiness) {
        this.statusBusiness = statusBusiness;
    }

    public String getSelfieProduct() {
        return selfieProduct;
    }

    public void setSelfieProduct(String selfieProduct) {
        this.selfieProduct = selfieProduct;
    }

    public String getBatteryProduct() {
        return batteryProduct;
    }

    public void setBatteryProduct(String batteryProduct) {
        this.batteryProduct = batteryProduct;
    }

    public Double getWeightProduct() {
        return weightProduct;
    }

    public void setWeightProduct(Double weightProduct) {
        this.weightProduct = weightProduct;
    }

    public Double getQuantityProduct() {
        return quantityProduct;
    }

    public void setQuantityProduct(Double quantityProduct) {
        this.quantityProduct = quantityProduct;
    }

    public Double getPriceProduct() {
        return priceProduct;
    }

    public void setPriceProduct(Double priceProduct) {
        this.priceProduct = priceProduct;
    }

    public Capacity getCapacity() {
        return capacity;
    }

    public void setCapacity(Capacity capacity) {
        this.capacity = capacity;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Cpu getCpu() {
        return cpu;
    }

    public void setCpu(Cpu cpu) {
        this.cpu = cpu;
    }

    public Ram getRam() {
        return ram;
    }

    public void setRam(Ram ram) {
        this.ram = ram;
    }

    public Series getSeries() {
        return series;
    }

    public void setSeries(Series series) {
        this.series = series;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
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
