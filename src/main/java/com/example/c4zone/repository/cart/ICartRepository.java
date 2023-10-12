package com.example.c4zone.repository.cart;

import com.example.c4zone.model.order.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface ICartRepository extends JpaRepository<Cart,Long> {
    /**
     * Author: TinDT
     * Goal: create cart
     */
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO c4_zone.cart(quantity_product_order,id_user,id_product) VALUES(:#{#cart.quantityProductOrder}, :#{#cart.user.id}, :#{#cart.product.idProduct}", nativeQuery = true)
    void saveCart(Cart cart);
}
