package com.example.c4zone.repository.cart;

import com.example.c4zone.dto.order.ICartDto;
import com.example.c4zone.model.order.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ICartRepository extends JpaRepository<Cart,Long> {
    /**
     * Author: TinDT
     * Goal: create cart
     */
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO c4_zone.cart(quantity_product_order,id_user,id_product) VALUES(:#{#cart.quantityProductOrder}, :#{#cart.user.id}, :#{#cart.product.idProduct}", nativeQuery = true)
    void saveCart(Cart cart);
    /**
     * method getAllCart
     * Create ThoiND
     * Date 12-10-2023
     * param Long idUser
     * return List<ICartDto>
     */
    @Query(value = "select cart.id_cart as idCart, p.name_product as nameProduct, p.price_product as priceProduct " +
            "p.quantity_product as quantityProduct " +
            "from cart " +
            "join product as p " +
            "on cart.id_product = p.id_product " +
            "where id_user = :id",nativeQuery = true)
    List<ICartDto> getAllCart(@Param("id")Long idUser);
}
