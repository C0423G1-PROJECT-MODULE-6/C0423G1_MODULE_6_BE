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
        private String inputDate;
        @NotNull(message = "Không được để trống số lượng")
        @Min(0)
        private Integer quantity;

        @NotBlank(message = "Vui lòng chọn nhà cung cấp")
        private Long supplierId;
        @NotBlank(message = "Vui lòng chọn sản phẩm")
        private Long productId;

        public WarehouseDto() {
        }

        public WarehouseDto(Long idWarehouse, String inputDate, Integer quantity, Long supplierId, Long productId) {
            this.idWarehouse = idWarehouse;
            this.inputDate = inputDate;
            this.quantity = quantity;
            this.supplierId = supplierId;
            this.productId = productId;
        }

        public Long getIdWarehouse() {
            return idWarehouse;
        }

        public void setIdWarehouse(Long idWarehouse) {
            this.idWarehouse = idWarehouse;
        }

        public String getInputDate() {
            return inputDate;
        }

        public void setInputDate(String inputDate) {
            this.inputDate = inputDate;
        }

        public Integer getQuantity() {
            return quantity;
        }

        public void setQuantity(Integer quantity) {
            this.quantity = quantity;
        }

        public Long getSupplierId() {
            return supplierId;
        }

        public void setSupplierId(Long supplierId) {
            this.supplierId = supplierId;
        }

        public Long getProductId() {
            return productId;
        }

        public void setProductId(Long productId) {
            this.productId = productId;
        }

        @Override
        public boolean supports(Class<?> clazz) {
            return false;
        }

        @Override
        public void validate(Object target, Errors errors) {

        }
    }
