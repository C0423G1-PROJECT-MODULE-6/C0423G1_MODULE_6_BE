package com.example.c4zone.model.order;

import com.example.c4zone.model.product.Product;
import com.example.c4zone.model.user.User;
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
    private Integer quantityProductOrder;


    @ManyToOne
    @JoinColumn(name = "id_user",referencedColumnName = "id")
    private User user;


    @ManyToOne
    @JoinColumn(name = "id_product", referencedColumnName = "idProduct")
    private Product product;
}
