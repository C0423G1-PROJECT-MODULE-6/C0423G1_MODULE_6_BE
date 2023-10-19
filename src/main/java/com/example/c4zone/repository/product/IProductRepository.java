package com.example.c4zone.repository.product;

import com.example.c4zone.dto.order.IProductDtoOrder;
import com.example.c4zone.dto.product.IProductDto;
import com.example.c4zone.model.product.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {

    /**
     * author: DaoPTA
     * workday: 12/10/2023
     *
     * @param idProduct find by id with product
     * @return object to find for idProduct
     */
    @Query(value = "select p.id_product, p.name_product, p.battery_product, p.camera_product, p.price_product," +
            " p.quantity_product, p.description_product, p.screen_product, p.selfie_product, p.weight_product," +
            " c.id_capacity, co.id_color, cp.id_cpu, r.id_ram, s.id_series, t.id_type, p.status_business" +
            " from c4_zone.product as p" +
            " JOIN capacity as c on p.id_capacity = c.id_capacity" +
            " JOIN color as co on p.id_color = co.id_color" +
            " JOIN cpu as cp on p.id_cpu = cp.id_cpu" +
            " JOIN ram as r on p.id_ram = r.id_ram" +
            " JOIN series as s on p.id_series = s.id_series" +
            " JOIN type as t on p.id_type = t.id_type" +
            " WHERE p.id_product= :idProduct and p.status_business = true", nativeQuery = true)
    Product findByProductId(@Param("idProduct") Long idProduct);

    /**
     * author: DaoPTA
     * workday: 12/10/2023
     *
     * @param product add new object product
     */
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO product(name_product,battery_product,description_product,camera_product," +
            "price_product,quantity_product,screen_product,selfie_product,weight_product," +
            "id_capacity,id_color,id_cpu,id_ram,id_series,id_type, status_business)" +
            "VALUES ( :#{#product.nameProduct}, :#{#product.batteryProduct}, :#{#product.descriptionProduct}," +
            " :#{#product.cameraProduct}, :#{#product.priceProduct}, :#{#product.quantityProduct}, " +
            ":#{#product.screenProduct}, :#{#product.selfieProduct}, :#{#product.weightProduct}, " +
            ":#{#product.capacity?.idCapacity}, :#{#product.color?.idColor}, :#{#product.cpu?.idCpu}, " +
            ":#{#product.ram?.idRam}, :#{#product.series?.idSeries}, :#{#product.type?.idType}, true)", nativeQuery = true)
    void createProduct(@Param("product") Product product);

    /**
     * author: DaoPTA
     * workday: 12/10/2023
     *
     * @return Last inserted id after new addition
     */
    @Query(value = "SELECT LAST_INSERT_ID()", nativeQuery = true)
    Long getLastInsertedId();

    /**
     * author: DaoPTA
     * workday: 12/10/2023
     *
     * @param product update object product
     */
    @Transactional
    @Modifying
    @Query(value = "UPDATE product set name_product = :#{#product.nameProduct}, battery_product = :#{#product.batteryProduct}, " +
            "description_product= :#{#product.descriptionProduct}, camera_product = :#{#product.cameraProduct}, " +
            "price_product = :#{#product.priceProduct}, quantity_product = :#{#product.quantityProduct}, " +
            "screen_product = :#{#product.screenProduct}, selfie_product = :#{#product.selfieProduct}, " +
            "weight_product = :#{#product.weightProduct}, id_capacity = :#{#product.capacity.idCapacity}, " +
            "id_color = :#{#product.color.idColor}, id_cpu = :#{#product.cpu.idCpu}, id_ram = :#{#product.ram.idRam}, " +
            "id_series = :#{#product.series.idSeries}, id_type = :#{#product.type.idType} " +
            "WHERE id_product = :#{#product.idProduct}", nativeQuery = true)
    void updateProduct(@Param("product") Product product);

    /**
     * method findByProduct
     * Create ThoiND
     * Date 12-10-2023
     * param Long id
     * return IProductDtoOrder
     */
    @Query(value = "select id_product as idProductOrder, name_product as nameProductOrder, " +
            "price_product as priceProductOrder " +
            "from product " +
            "where id_product = :id", nativeQuery = true)
    IProductDtoOrder findProductByIdOrder(Long id);
    @Query(value = "select id_product as id," +
            "              name_product as name " +
            "            from product " +
            "            where id_product = :id",nativeQuery = true)
    IProductDto getProductById(Long id);


    /**
     * author :QuanND
     *
     * @param pageable :page control size and number page
     * @param name     : of input search
     * @return
     */
    @Query(value = "SELECT " +
            "    p.id_product AS id," +
            "    p.battery_product AS battery," +
            "    p.camera_product AS camera," +
            "    p.name_product AS name," +
            "    p.price_product AS price," +
            "    p.quantity_product AS quantity," +
            "    t.name AS type," +
            "    ca.name AS capacity," +
            "    c.name AS cpu," +
            "    co.name AS color " +
            " FROM " +
            "    c4_zone.product p " +
            "        JOIN " +
            "    capacity ca ON p.id_capacity = ca.id_capacity" +
            "        JOIN" +
            "    color co ON p.id_color = co.id_color" +
            "        JOIN " +
            "    cpu c ON p.id_cpu = c.id_cpu" +
            "        JOIN " +
            "    ram r ON p.id_ram = r.id_ram" +
            "        JOIN " +
            "    type t ON p.id_type = t.id_type " +
            "        JOIN " +
            "    series s ON p.id_series = s.id_series " +
            " WHERE " +
            "    p.status_business = TRUE  " +
            "    AND p.name_product like :name ", nativeQuery = true)
    Page<IProductDto> getAllByName(Pageable pageable, @Param("name") String name);

    /**
     * author :QuanND
     *
     * @param pageable :page control size and number page
     * @param type     :value :id_type
     * @return
     */
    @Query(value = "SELECT " +
            "    p.id_product AS id," +
            "    p.battery_product AS battery," +
            "    p.camera_product AS camera," +
            "    p.name_product AS name," +
            "    p.price_product AS price," +
            "    p.quantity_product AS quantity," +
            "    ca.name AS capacity," +
            "    t.name AS type," +
            "    c.name AS cpu," +
            "    co.name AS color " +
            " FROM " +
            "    c4_zone.product p " +
            "        JOIN " +
            "    capacity ca ON p.id_capacity = ca.id_capacity" +
            "        JOIN " +
            "    color co ON p.id_color = co.id_color" +
            "        JOIN " +
            "    cpu c ON p.id_cpu = c.id_cpu" +
            "        JOIN " +
            "    ram r ON p.id_ram = r.id_ram" +
            "        JOIN " +
            "    type t ON p.id_type = t.id_type " +
            "        JOIN " +
            "    series s ON p.id_series = s.id_series " +
            " WHERE " +
            "    p.status_business = TRUE  " +
            "    AND t.id_type = :type ", nativeQuery = true)
    Page<IProductDto> getAllByType(Pageable pageable, @Param("type") Long type);

    /**
     * author :QuanND
     *
     * @param pageable :page control size and number page
     * @param min      :price of product min :min
     * @param max      :price of product max:max
     * @return a page did control and satisfy the search and sorting conditions
     */
    @Query(value = "SELECT " +
            "    p.id_product AS id," +
            "    p.battery_product AS battery," +
            "    p.camera_product AS camera," +
            "    p.name_product AS name," +
            "    p.price_product AS price," +
            "    p.quantity_product AS quantity," +
            "    ca.name AS capacity," +
            "    t.name AS type," +
            "    c.name AS cpu," +
            "    co.name AS color " +
            " FROM " +
            "    c4_zone.product p " +
            "        JOIN " +
            "    capacity ca ON p.id_capacity = ca.id_capacity" +
            "        JOIN " +
            "    color co ON p.id_color = co.id_color" +
            "        JOIN " +
            "    cpu c ON p.id_cpu = c.id_cpu" +
            "        JOIN " +
            "    ram r ON p.id_ram = r.id_ram" +
            "        JOIN " +
            "    type t ON p.id_type = t.id_type " +
            "        JOIN " +
            "    series s ON p.id_series = s.id_series " +
            " WHERE " +
            "    p.status_business = TRUE  " +
            "    AND p.price_product between :min and :max", nativeQuery = true)
    Page<IProductDto> getAllByPrice(Pageable pageable, @Param("min") Double min, @Param("max") Double max);

    /**
     * author :QuanND
     *
     * @param pageable :page control size and number page
     * @param min      : price of product min :min
     * @return a page did control and satisfy the search and sorting conditions
     */
    @Query(value = "SELECT " +
            "    p.id_product AS id," +
            "    p.battery_product AS battery," +
            "    p.camera_product AS camera," +
            "    p.name_product AS name," +
            "    p.price_product AS price," +
            "    p.quantity_product AS quantity," +
            "    ca.name AS capacity," +
            "    t.name AS type," +
            "    c.name AS cpu," +
            "    co.name AS color " +
            " FROM " +
            "    c4_zone.product p " +
            "        JOIN " +
            "    capacity ca ON p.id_capacity = ca.id_capacity" +
            "        JOIN " +
            "    color co ON p.id_color = co.id_color" +
            "        JOIN " +
            "    cpu c ON p.id_cpu = c.id_cpu" +
            "        JOIN " +
            "    ram r ON p.id_ram = r.id_ram" +
            "        JOIN " +
            "    type t ON p.id_type = t.id_type " +
            "        JOIN " +
            "    series s ON p.id_series = s.id_series " +
            " WHERE " +
            "    p.status_business = TRUE  " +
            "    AND p.price_product >= :min", nativeQuery = true)
    Page<IProductDto> getAllByPriceMin(Pageable pageable, @Param("min") Double min);

    /**
     * author :QuanND
     *
     * @param pageable :page control size and number page
     * @param max      max of price product
     * @return a page did control and satisfy the search and sorting conditions
     */
    @Query(value = "SELECT " +
            "    p.id_product AS id," +
            "    p.battery_product AS battery," +
            "    p.camera_product AS camera," +
            "    p.name_product AS name," +
            "    p.price_product AS price," +
            "    p.quantity_product AS quantity," +
            "    ca.name AS capacity," +
            "    t.name AS type," +
            "    c.name AS cpu," +
            "    co.name AS color " +
            " FROM " +
            "    c4_zone.product p " +
            "        JOIN " +
            "    capacity ca ON p.id_capacity = ca.id_capacity" +
            "        JOIN " +
            "    color co ON p.id_color = co.id_color" +
            "        JOIN " +
            "    cpu c ON p.id_cpu = c.id_cpu" +
            "        JOIN " +
            "    ram r ON p.id_ram = r.id_ram" +
            "        JOIN " +
            "    type t ON p.id_type = t.id_type " +
            "        JOIN " +
            "    series s ON p.id_series = s.id_series " +
            " WHERE " +
            "    p.status_business = TRUE  " +
            "    AND p.price_product <= :max", nativeQuery = true)
    Page<IProductDto> getAllByPriceMax(Pageable pageable, @Param("max") Double max);

    /**
     * author :QuanND
     *
     * @param id
     * @return
     */
    @Query(value = "   SELECT " +
            "    p.id_product AS id," +
            "    p.name_product AS name," +
            "    p.price_product AS price" +
            " FROM " +
            "    c4_zone.product p" +
            " WHERE " +
            "    p.id_product =:id", nativeQuery = true)
    IProductDto findProductByIdWarehouse(Long id);
    @Query(value = "   SELECT " +
            "    p.id_product AS id," +
            "    p.name_product AS name," +
            "    p.price_product AS price" +
            "    i.name as image " +
            " FROM  " +
            "    c4_zone.product p " +
            " JOIN image i " +
            " ON p.id=i.id_image " +
            " WHERE " +
            "    p.id_product =:id ", nativeQuery = true)
    List<IProductDto> findProductWarehouse(Long id);

    /**
     * author :QuanND
     *
     * @param pageable :page control size and number page
     * @param max      max of quantity product
     * @return a page did control and satisfy the search and sorting conditions
     */
    @Query(value = "SELECT " +
            "    p.id_product AS id," +
            "    p.battery_product AS battery," +
            "    p.camera_product AS camera," +
            "    p.name_product AS name," +
            "    p.price_product AS price," +
            "    p.quantity_product AS quantity," +
            "    t.name AS type,"+
            "    ca.name AS capacity," +
            "    c.name AS cpu," +
            "    co.name AS color " +
            " FROM " +
            "    c4_zone.product p " +
            "        JOIN " +
            "    capacity ca ON p.id_capacity = ca.id_capacity" +
            "        JOIN " +
            "    color co ON p.id_color = co.id_color" +
            "        JOIN " +
            "    cpu c ON p.id_cpu = c.id_cpu" +
            "        JOIN " +
            "    ram r ON p.id_ram = r.id_ram" +
            "        JOIN " +
            "    type t ON p.id_type = t.id_type " +
            "        JOIN " +
            "    series s ON p.id_series = s.id_series " +
            " WHERE " +
            "    p.status_business = TRUE  " +
            "    AND p.quantity_product < :max", nativeQuery = true)
    Page<IProductDto> getAllByQuantityMax(Pageable pageable, @Param("max") int max);

    /**
     * author :QuanND
     *
     * @param pageable :page control size and number page
     * @param min      : quantity of product min :min
     * @param max      max of quantity product
     * @return a page did control and satisfy the search and sorting conditions
     */
    @Query(value = "SELECT " +
            "    p.id_product AS id," +
            "    p.battery_product AS battery," +
            "    p.camera_product AS camera," +
            "    p.name_product AS name," +
            "    p.price_product AS price," +
            "    p.quantity_product AS quantity," +
            "    t.name AS type,"+
            "    ca.name AS capacity," +
            "    c.name AS cpu," +
            "    co.name AS color " +
            " FROM " +
            "    c4_zone.product p " +
            "        JOIN " +
            "    capacity ca ON p.id_capacity = ca.id_capacity" +
            "        JOIN " +
            "    color co ON p.id_color = co.id_color" +
            "        JOIN " +
            "    cpu c ON p.id_cpu = c.id_cpu" +
            "        JOIN " +
            "    ram r ON p.id_ram = r.id_ram" +
            "        JOIN " +
            "    type t ON p.id_type = t.id_type " +
            "        JOIN " +
            "    series s ON p.id_series = s.id_series " +
            " WHERE " +
            "    p.status_business = TRUE  " +
            "    AND p.quantity_product <= :max and p.quantity_product>=:min", nativeQuery = true)
    Page<IProductDto> getAllByQuantity(Pageable pageable, @Param("min") int min, @Param("max") int max);

    /**
     * author :QuanND
     *
     * @param pageable :page control size and number page
     * @param min      : quantity of product min :min
     * @return :a page did control and satisfy the search and sorting conditions
     */
    @Query(value = "SELECT " +
            "    p.id_product AS id," +
            "    p.battery_product AS battery," +
            "    p.camera_product AS camera," +
            "    p.name_product AS name," +
            "    p.price_product AS price," +
            "    p.quantity_product AS quantity," +
            "    t.name AS type,"+
            "    ca.name AS capacity," +
            "    c.name AS cpu," +
            "    co.name AS color " +
            " FROM " +
            "    c4_zone.product p " +
            "        JOIN " +
            "    capacity ca ON p.id_capacity = ca.id_capacity" +
            "        JOIN " +
            "    color co ON p.id_color = co.id_color" +
            "        JOIN " +
            "    cpu c ON p.id_cpu = c.id_cpu" +
            "        JOIN " +
            "    ram r ON p.id_ram = r.id_ram" +
            "        JOIN " +
            "    type t ON p.id_type = t.id_type " +
            "        JOIN " +
            "    series s ON p.id_series = s.id_series " +
            " WHERE " +
            "    p.status_business = TRUE  " +
            "    AND p.quantity_product >= :min", nativeQuery = true)
    Page<IProductDto> getAllByQuantityMin(Pageable pageable, @Param("min") int min);

    /**
     * author:QuanND
     *
     * @param id :id of product remove
     */
    @Transactional
    @Modifying
    @Query(value = "UPDATE product p " +
            " SET p.status_business= false " +
            " where p.id_product = :id ", nativeQuery = true)
    void removeProduct(@Param("id") Long id);

    /**
     * method find product by id product
     * Create ThoiND
     * Date 14-10-2023
     * param id product
     * return product
     */
    @Query(value = "select * from product where id_product = :id", nativeQuery = true)
    Product findProductByIdProduct(@Param("id") Long idProduct);

    /**
     * method get quantity by id product
     * Create ThoiND
     * Date 14-10-2023
     * param id product
     * return quantity current product
     */
    @Query(value = "select quantity_product from product where id_product = :id", nativeQuery = true)
    Integer getQuantityByid(@Param("id") Long idProduct);

    /**
     * method update quantity of product
     * Create ThoiND
     * Date 14-10-2023
     * param id product
     * return void
     */
    @Modifying
    @Transactional
    @Query(value = "update product set quantity_product = :quantity where id_product = :id", nativeQuery = true)
    void updateQuantityOfProduct(@Param("id") Long idProduct, @Param("quantity") Integer quantityOfProductAfterPayment);

}
