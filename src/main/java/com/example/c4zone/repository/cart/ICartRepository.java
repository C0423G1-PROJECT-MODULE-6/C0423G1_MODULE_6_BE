package com.example.c4zone.repository.cart;

import com.example.c4zone.dto.order.ICartDto;
import com.example.c4zone.dto.product.IProductCartDto;
import com.example.c4zone.dto.product.IProductDto;
import com.example.c4zone.model.order.Cart;
import com.example.c4zone.model.product.Product;
import com.example.c4zone.model.user.AppUser;
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


    @Query(value = "select c.id_cart as idCart,c.id_product as idProduct,c.quantity_product_order as quantityOrder ,p.name_product as nameProduct " +
            ",p.price_product as priceProduct, p.quantity_product as quantityProduct " +
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

   
  
    /**
     * method get quantity idProduct of cart form product
     * Create TinDT
     * Date 14-10-2023
     * param Cart cart
     * return Long
     */
    @Query(value =" select p.quantity_product  from product p where p.id_product = :id ",nativeQuery = true)
    Long quantityProduct(@Param("id") Long id);
    /**
     * method  create cart for sale pages
     * * Create TinDT
     * Date 14-10-2023
     * param Long idUser
     * param Long idProduct
     * param Long newQuantity
     * return void
     */
    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "insert into c4_zone.cart (id_user,id_product,quantity_product_order ) VALUES (:id_user, :id_product, :newQuantity) ON DUPLICATE KEY UPDATE quantity_product_order = quantity_product_order + :newQuantity")
    void createCard(@Param("id_user") Long idUser,@Param("id_product") Long idProduct, @Param("newQuantity") Long newQuantity);
    /**
     * method get quantity cart from iProduct and iUserof cart
     * Create TinDT
     * Date 14-10-2023
     * param Long idProduct
     * param Long idUser
     * return Long
     */
    @Query(value =" select c.quantity_product_order  from cart c where c.id_product = :id_product and c.id_user = :id_user",nativeQuery = true)
    Long quantityProductCart(@Param("id_product") Long idProduct,@Param("id_user") Long idUser);
    /**
     * method get product  from iProduct
     * Create TinDT
     * Date 14-10-2023
     * param Long idProduct
     * return Product
     *
     */
    @Query(value =" select * from product where id_product = :id_product ",nativeQuery = true)
    Product getProductById(@Param("id_product") Long idProduct);
    /**
     * method get user  from idUser
     * Create TinDT
     * Date 14-10-2023
     * param Long idUser
     * return User
     *
     */
    @Query(value =" select * from app_user where id = :id_user ",nativeQuery = true)
    AppUser getUserById(@Param("id_user") Long idUser);

    /**
     * method delete chosen product
     * Create ThoiND
     * Date 14-10-2023
     * param Long idUser,Long idProduct
     * return status 2xx
     */
    @Modifying
    @Transactional
    @Query(value = "delete from cart where id_user = :id and id_product = :idProduct",nativeQuery = true)
    void deleteChosenProduct(@Param("id") Long idUser,@Param("idProduct") Long idProduct);
}
