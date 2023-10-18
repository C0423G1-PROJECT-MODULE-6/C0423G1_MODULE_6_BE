    package com.example.c4zone.dto.warehouse;

    import com.example.c4zone.model.product.Product;
    import com.example.c4zone.model.supplier.Supplier;
    import org.springframework.validation.Errors;
    import org.springframework.validation.Validator;

    import javax.validation.constraints.Max;
    import javax.validation.constraints.Min;
    import javax.validation.constraints.NotBlank;
    import javax.validation.constraints.NotNull;

    public class WarehouseDto implements Validator {
        @NotNull(message = "ID không được để trống")
        private Long idWarehouse;
        private String inputDate;
        @NotNull(message = "Không được để trống số lượng")
        @Min(value = 0, message = "Số lượng không được nhỏ hơn 0")
        @Max(2000)
        private Integer quantity;

        @NotNull(message = "Vui lòng chọn nhà cung cấp")
        private Long supplierId;
        @NotNull(message = "Vui lòng chọn sản phẩm")
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
            WarehouseDto warehouseDto = (WarehouseDto) target;
            if(warehouseDto.getIdWarehouse() == null){
                errors.rejectValue("idWarehouse","", "Vui lòng không để trống id");
            }
            if(warehouseDto.getInputDate() == null){
                errors.rejectValue("inputDate","", "Vui lòng nhập ngày");
            }

            if(warehouseDto.getQuantity() == null){
                errors.rejectValue("quantity","", "Vui lòng không để trống số lượng");
            }else if(warehouseDto.getQuantity() < 0) {
                errors.rejectValue("quantity", "vui lòng nhập số lượng lớn hơn 0");
            } else if (warehouseDto.getQuantity() > 2000 ) {
                errors.rejectValue("quantity", "Vui lòng nhập không quá 2000 sản phẩm");
            }
            if(warehouseDto.getProductId() == null){
                errors.rejectValue("productId","", "Vui lòng không để trống sản phẩm");
            }
            if(warehouseDto.getSupplierId() == null){
                errors.rejectValue("supplierId","", "Vui lòng không để trống nhà cung cấp");
            }
        }

        @Override
        public String toString() {
            return "WarehouseDto{" +
                    "idWarehouse=" + idWarehouse +
                    ", inputDate='" + inputDate + '\'' +
                    ", quantity=" + quantity +
                    ", supplierId=" + supplierId +
                    ", productId=" + productId +
                    '}';
        }
    }
