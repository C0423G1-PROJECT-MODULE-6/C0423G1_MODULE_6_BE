package com.example.c4zone.model.order;

import com.example.c4zone.model.product.Product;
import com.example.c4zone.model.user.AppUser;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCart;
    @JoinColumn(name = "quantity_product_order")

    private Integer quantityProductOrder;


    @ManyToOne
    @JoinColumn(name = "id_user",referencedColumnName = "id")
    private AppUser user;


    @ManyToOne
    @JoinColumn(name = "id_product", referencedColumnName = "idProduct")
    private Product product;
}
