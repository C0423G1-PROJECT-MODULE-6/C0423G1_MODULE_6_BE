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
    @Query(value = "select c.id_cart as idCart,c.id_product as idProduct,c.quantity_product_order as quantityOrder ,p.name_product as nameProduct " +
            ",p.price_product as priceProduct " +
            "from cart as c " +
            "join product " +
            "as p on c.id_product = p.id_product " +
            "where c.id_user = :id",nativeQuery = true)
    List<ICartDto> getAllCart(@Param("id")Long idUser);

    @Modifying
    @Transactional
    @Query(value = "insert into cart (id_user, id_product, quantity_product_order) " +
             "values (:userId, :productId, :newQuantity) "  +
             "on duplicate key update quantity_product_order = :newQuantity",nativeQuery = true)
    void addToCart(@Param("userId") Long userId,
                   @Param("productId") Long productId, @Param("newQuantity") Integer newQuantity);

    /**
     * method delete cart after copy to order detail
     * Create ThoiND
     * Date 14-10-2023
     * param id user
     * return void
     */
    @Modifying
    @Transactional
    @Query(value = "delete from cart where id_user = :id",nativeQuery = true)
    void deleteCart(@Param("id") Long idUser);
}
