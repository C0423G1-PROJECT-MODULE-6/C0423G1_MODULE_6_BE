package com.example.c4zone.repository.cart;

import com.example.c4zone.dto.order.ICartDto;
import com.example.c4zone.dto.product.IProductCartDto;
import com.example.c4zone.model.order.Cart;
import com.example.c4zone.model.product.Product;
import com.example.c4zone.model.user.AppUser;
import com.example.c4zone.model.wareHouse.WareHouse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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


    @Query(value = "select c.id_cart as idCart,c.id_product as idProduct,c.quantity_product_order as quantityOrder " +
            ",concat(p.name_product, ', ', cl.name, ', ', cp.name) as nameProduct " +
            ",p.price_product as priceProduct, p.quantity_product as quantityProduct " +
            "from cart as c " +
            "join product " +
            "as p on c.id_product = p.id_product " +
            "join color " +
            "as cl on cl.id_color = p.id_color " +
            "join capacity " +
            "as cp on cp.id_capacity = p.id_capacity " +
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
    @Query(value =" select quantity from c4_zone.ware_house  where product_id = :id",nativeQuery = true)
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
    @Query(nativeQuery = true, value = "insert into c4_zone.cart (id_customer,id_product,quantity_product_order ) VALUES (:id_user, :id_product, :newQuantity) ON DUPLICATE KEY UPDATE quantity_product_order = quantity_product_order + :newQuantity")
    void createCard(@Param("id_user") Long idUser,@Param("id_product") Long idProduct, @Param("newQuantity") Long newQuantity);
    /**
     * method get quantity cart from iProduct and iUserof cart
     * Create TinDT
     * Date 14-10-2023
     * param Long idProduct
     * param Long idUser
     * return Long
     */
    @Query(value =" select c.quantity_product_order  from cart c where c.id_product = :id_product and c.id_customer = :id_customer",nativeQuery = true)
    Long quantityProductCart(@Param("id_product") Long idProduct,@Param("id_customer") Long idCustomer);
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
    /**
     * author :TinDT
     *
     * @param pageable :page control size and number page
     * @param name     : of input search
     * @return
     */
    @Query(value = "SELECT " +
            "    p.id_product AS id," +
            "    p.name_product AS name," +
            "    p.price_product AS price," +
            "    SUM(w.quantity) AS quantity," +
            "    ca.name AS capacity," +
            "    c.name AS cpu," +
            "    co.name AS color " +
            " FROM " +
            "    c4_zone.ware_house w " +
            "        JOIN " +
            "    product p ON w.product_id = p.id_product" +
            "        JOIN " +
            "    capacity ca ON p.id_capacity = ca.id_capacity" +
            "        JOIN" +
            "    color co ON p.id_color = co.id_color" +
            "        JOIN " +
            "    cpu c ON p.id_cpu = c.id_cpu" +
            " WHERE " +
            "    p.status_business = TRUE  " +
            "    AND p.name_product like :name " +
            " group by w.product_id", nativeQuery = true)
    Page<IProductCartDto> getAllByName(Pageable pageable, @Param("name") String name);

    /**
     * author :TinDT
     *
     * @param pageable :page control size and number page
     * @param min      : price of product min :min
     * @return a page did control and satisfy the search and sorting conditions
     */
    @Query(value = "SELECT " +
            "    p.id_product AS id," +
            "    p.name_product AS name," +
            "    p.price_product AS price," +
            "    SUM(w.quantity) AS quantity," +
            "    ca.name AS capacity," +
            "    c.name AS cpu," +
            "    co.name AS color " +
            " FROM " +
            "    c4_zone.ware_house w " +
            "        JOIN " +
            "    product p ON w.product_id = p.id_product" +
            "        JOIN " +
            "    capacity ca ON p.id_capacity = ca.id_capacity" +
            "        JOIN" +
            "    color co ON p.id_color = co.id_color" +
            "        JOIN " +
            "    cpu c ON p.id_cpu = c.id_cpu" +
            " WHERE " +
            "    p.status_business = TRUE  " +
            "    AND p.price_product >= :min " +
            " group by w.product_id", nativeQuery = true)
    Page<IProductCartDto> getAllByPriceMin(Pageable pageable, @Param("min") Double min);
    /**
     * author :TinDT
     *
     * @param pageable :page control size and number page
     * @param max      : price of product min :min
     * @return a page did control and satisfy the search and sorting conditions
     */
    @Query(value = "SELECT " +
            "    p.id_product AS id," +
            "    p.name_product AS name," +
            "    p.price_product AS price," +
            "    SUM(w.quantity) AS quantity," +
            "    ca.name AS capacity," +
            "    c.name AS cpu," +
            "    co.name AS color " +
            " FROM " +
            "    c4_zone.ware_house w " +
            "        JOIN " +
            "    product p ON w.product_id = p.id_product" +
            "        JOIN " +
            "    capacity ca ON p.id_capacity = ca.id_capacity" +
            "        JOIN" +
            "    color co ON p.id_color = co.id_color" +
            "        JOIN " +
            "    cpu c ON p.id_cpu = c.id_cpu" +
            " WHERE " +
            "    p.status_business = TRUE  " +
            "    AND p.price_product <= :max " +
            " group by w.product_id", nativeQuery = true)
    Page<IProductCartDto> getAllByPriceMax(Pageable pageable, @Param("max") Double max);
    /**
     * author :TinDT
     *
     * @param pageable :page control size and number page
     * @param min      :price of product min :min
     * @param max      :price of product max:max
     * @return a page did control and satisfy the search and sorting conditions
     */
    @Query(value = "SELECT " +
            "    p.id_product AS id," +
            "    p.name_product AS name," +
            "    p.price_product AS price," +
            "    SUM(w.quantity) AS quantity," +
            "    ca.name AS capacity," +
            "    c.name AS cpu," +
            "    co.name AS color " +
            " FROM " +
            "    c4_zone.ware_house w " +
            "        JOIN " +
            "    product p ON w.product_id = p.id_product" +
            "        JOIN " +
            "    capacity ca ON p.id_capacity = ca.id_capacity" +
            "        JOIN" +
            "    color co ON p.id_color = co.id_color" +
            "        JOIN " +
            "    cpu c ON p.id_cpu = c.id_cpu" +
            " WHERE " +
            "    p.status_business = TRUE  " +
            "   AND p.price_product between :min and :max " +
            " group by w.product_id", nativeQuery = true)
    Page<IProductCartDto> getAllByPrice(Pageable pageable, @Param("min") Double min, @Param("max") Double max);
    /**
     * author :TinDT
     *
     * @param pageable :page control size and number page
     * @param type     :value :id_type
     * @return
     */
    @Query(value ="SELECT " +
            "    p.id_product AS id," +
            "    p.name_product AS name," +
            "    p.price_product AS price," +
            "    SUM(w.quantity) AS quantity," +
            "    ca.name AS capacity," +
            "    c.name AS cpu," +
            "    co.name AS color " +
            " FROM " +
            "    c4_zone.ware_house w " +
            "        JOIN " +
            "    product p ON w.product_id = p.id_product" +
            "        JOIN " +
            "    capacity ca ON p.id_capacity = ca.id_capacity" +
            "        JOIN" +
            "    color co ON p.id_color = co.id_color" +
            "        JOIN " +
            "    cpu c ON p.id_cpu = c.id_cpu" +
            "        JOIN " +
            "    type t ON t.id_type = p.id_type" +
            " WHERE " +
            "    p.status_business = TRUE  " +
            "    AND t.id_type = :type " +
            "group by w.product_id", nativeQuery = true)
    Page<IProductCartDto> getAllByType(Pageable pageable, @Param("type") Long type);
    /**
     * author :TinDT
     *
     * @param pageable :page control size and number page
     * @param min      : quantity of product min :min
     * @param max      max of quantity product
     * @return a page did control and satisfy the search and sorting conditions
     */
    @Query(value ="SELECT " +
            "    p.id_product AS id," +
            "    p.name_product AS name," +
            "    p.price_product AS price," +
            "    SUM(w.quantity) AS quantity," +
            "    ca.name AS capacity," +
            "    c.name AS cpu," +
            "    co.name AS color " +
            " FROM " +
            "    c4_zone.ware_house w " +
            "        JOIN " +
            "    product p ON w.product_id = p.id_product" +
            "        JOIN " +
            "    capacity ca ON p.id_capacity = ca.id_capacity" +
            "        JOIN" +
            "    color co ON p.id_color = co.id_color" +
            "        JOIN " +
            "    cpu c ON p.id_cpu = c.id_cpu" +
            " WHERE " +
            "    p.status_business = TRUE  " +
            "    AND w.quantity <= :max and p.quantity_product >=:min group by w.product_id", nativeQuery = true)
    Page<IProductCartDto> getAllByQuantity(Pageable pageable, @Param("min") Integer min, @Param("max") Integer max);
    /**
     * author :TinDt
     *
     * @param pageable :page control size and number page
     * @param max      max of quantity product
     * @return a page did control and satisfy the search and sorting conditions
     */
    @Query(value ="SELECT " +
            "    p.id_product AS id," +
            "    p.name_product AS name," +
            "    p.price_product AS price," +
            "    SUM(w.quantity) AS quantity," +
            "    ca.name AS capacity," +
            "    c.name AS cpu," +
            "    co.name AS color " +
            " FROM " +
            "    c4_zone.ware_house w " +
            "        JOIN " +
            "    product p ON w.product_id = p.id_product" +
            "        JOIN " +
            "    capacity ca ON p.id_capacity = ca.id_capacity" +
            "        JOIN" +
            "    color co ON p.id_color = co.id_color" +
            "        JOIN " +
            "    cpu c ON p.id_cpu = c.id_cpu" +
            " WHERE " +
            "    p.status_business = TRUE  " +
            "    AND w.quantity < :max group by w.product_id", nativeQuery = true)
    Page<IProductCartDto> getAllByQuantityMax(Pageable pageable, @Param("max") Integer max);

    /**
     * author :TinDT
     *
     * @param pageable :page control size and number page
     * @param min      : quantity of product min :min
     * @return :a page did control and satisfy the search and sorting conditions
     */
    @Query(value ="SELECT " +
            "    p.id_product AS id," +
            "    p.name_product AS name," +
            "    p.price_product AS price," +
            "    SUM(w.quantity) AS quantity," +
            "    ca.name AS capacity," +
            "    c.name AS cpu," +
            "    co.name AS color " +
            " FROM " +
            "    c4_zone.ware_house w " +
            "        JOIN " +
            "    product p ON w.product_id = p.id_product" +
            "        JOIN " +
            "    capacity ca ON p.id_capacity = ca.id_capacity" +
            "        JOIN" +
            "    color co ON p.id_color = co.id_color" +
            "        JOIN " +
            "    cpu c ON p.id_cpu = c.id_cpu" +
            " WHERE " +
            "    p.status_business = TRUE  " +
            "    AND w.quantity >= :min group by w.product_id", nativeQuery = true)
    Page<IProductCartDto> getAllByQuantityMin(Pageable pageable, @Param("min") int min);
    @Query(value =" select * from ware_house where product_id = :id_product ",nativeQuery = true)
    WareHouse getProductWareById(@Param("id_product") Long idProduct);
}
