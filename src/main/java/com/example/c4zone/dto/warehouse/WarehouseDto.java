package com.example.c4zone.dto.warehouse;

import com.example.c4zone.model.product.Product;
import com.example.c4zone.model.supplier.Supplier;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class WarehouseDto implements Validator {

    private Long idWarehouse;
    private Integer quantity;
    @NotNull(message = "Không được để trống số lượng")
    @Min(0)
    private Product product;
    @NotBlank(message = "Vui lòng chọn sản phẩm")
    private Supplier supplier;
    @NotBlank(message = "Vui lòng chọn nhà cung cấp")
    private String inputDate;

    public WarehouseDto() {
    }

    public WarehouseDto(Long idWarehouse, Integer quantity, Product product, Supplier supplier, String inputDate) {
        this.idWarehouse = idWarehouse;
        this.quantity = quantity;
        this.product = product;
        this.supplier = supplier;
        this.inputDate = inputDate;
    }

    public Long getIdWarehouse() {
        return idWarehouse;
    }

    public void setIdWarehouse(Long idWarehouse) {
        this.idWarehouse = idWarehouse;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public String getInputDate() {
        return inputDate;
    }

    public void setInputDate(String inputDate) {
        this.inputDate = inputDate;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
