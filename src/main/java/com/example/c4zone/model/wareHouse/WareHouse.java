        package com.example.c4zone.model.wareHouse;

        import com.example.c4zone.model.product.Product;
        import com.example.c4zone.model.supplier.Supplier;
        import lombok.Getter;
        import lombok.NoArgsConstructor;
        import lombok.Setter;
        import org.springframework.format.annotation.DateTimeFormat;

        import javax.persistence.*;
        import java.time.LocalDate;

        @Entity
        @Setter
        @Getter
        @NoArgsConstructor
        public class WareHouse {
            @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
            private Long idWarehouse;
            @DateTimeFormat(pattern = "dd-MM-yyyy")
            private LocalDate inputDate;
            private Integer quantity;
            @ManyToOne
            @JoinColumn(name = "supplier_id", referencedColumnName = "id_supplier")
            private Supplier supplierId;
            @ManyToOne
            @JoinColumn(name = "product_id", referencedColumnName = "idProduct")
            private Product productId;

            public WareHouse(LocalDate inputDate, Integer quantity, Supplier supplierId, Product productId) {
                this.inputDate = inputDate;
                this.quantity = quantity;
                this.supplierId = supplierId;
                this.productId = productId;
            }

            public WareHouse(Long idWarehouse, LocalDate inputDate, Integer quantity, Supplier supplierId, Product productId) {
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

            public LocalDate getInputDate() {
                return inputDate;
            }

            public void setInputDate(LocalDate inputDate) {
                this.inputDate = inputDate;
            }

            public Integer getQuantity() {
                return quantity;
            }

            public void setQuantity(Integer quantity) {
                this.quantity = quantity;
            }

            public Supplier getSupplierId() {
                return supplierId;
            }

            public void setSupplierId(Supplier supplierId) {
                this.supplierId = supplierId;
            }

            public Product getProductId() {
                return productId;
            }

            public void setProductId(Product productId) {
                this.productId = productId;
            }
        }
