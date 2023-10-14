package com.example.c4zone.repository.cart;

import com.example.c4zone.dto.order.ICartDto;
import com.example.c4zone.dto.product.IProductCartDto;
import com.example.c4zone.dto.product.IProductDto;
import com.example.c4zone.model.order.Cart;
import com.example.c4zone.model.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ICartRepository extends JpaRepository<Cart,Long> {
    /**
     * method Create Cart
     * Create TinDT
     * Date 14-10-2023
     * param Cart cart
     * return void
     */
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO c4_zone.cart(quantity_product_order,id_user,id_product) VALUES(:quantity_product_order, :id_user, :id_product", nativeQuery = true)
    void saveCart(@Param("quantity_product_order")Long quantity,@Param("id_user")Long idUser,@Param("id_product")Long idProduct);
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
    /**
     * method get quantity idProduct of cart form product
     * Create TinDT
     * Date 14-10-2023
     * param Cart cart
     * return Long
     */
    @Query(value =" select p.quantity_product as quantityProduct from product p where p.id_product = :id ",nativeQuery = true)
    Long quantityProduct(@Param("id") Long id);
    @Transactional

    @Modifying
    @Query(nativeQuery = true, value = "insert into cart (id_user, id_product, quantity_product_order)" +
            "VALUES (:id_user, :id_product, :quantity_product_order) " +
            "ON DUPLICATE KEY UPDATE quantity_product_order = quantity_product_order + :newQuantity")
    void addToCart(@Param("id_user") Long idUser,@Param("id_product") Long idProduct, @Param("newQuantity") Long newQuantity);
//    ALTER TABLE cart ADD UNIQUE INDEX user_medicine_index (app_user_id, medicine_id);
}
