package com.example.c4zone.model.wareHouse;

import com.example.c4zone.model.product.Product;
import com.example.c4zone.model.supplier.Supplier;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class WareHouse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idWarehouse;
    private String inputDate;
    private Integer quantity;
    @ManyToOne
    @JoinColumn(name = "supplier_id", referencedColumnName = "id_supplier")
    private Supplier supplier;
    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "idProduct")
    private Product product;

    public WareHouse(Long idWarehouse, String inputDate, Integer quantity, Supplier supplier, Product product) {
        this.idWarehouse = idWarehouse;
        this.inputDate = inputDate;
        this.quantity = quantity;
        this.supplier = supplier;
        this.product = product;
    }
}
