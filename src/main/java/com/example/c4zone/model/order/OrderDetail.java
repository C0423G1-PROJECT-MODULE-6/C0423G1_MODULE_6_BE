package com.example.c4zone.model.order;

import com.example.c4zone.model.product.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idOrderDetail;
    private int quantityOrder;
    private double priceOrder;

    @ManyToOne
    @JoinColumn(name = "id_product", referencedColumnName = "idProduct")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "id_order", referencedColumnName = "idOrderBill")
    private OrderBill order;
}
