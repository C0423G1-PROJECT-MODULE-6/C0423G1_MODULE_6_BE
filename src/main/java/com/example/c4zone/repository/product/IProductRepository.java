package com.example.c4zone.repository.product;
import com.example.c4zone.dto.product.IProductDto;
import com.example.c4zone.dto.order.IProductDtoOrder;
import com.example.c4zone.model.product.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface IProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "select p.id_product, p.name_product, p.battery_product, p.camera_product, p.price_product," +
            " p.quantity_product, p.description_product, p.screen_product, p.selfie_product, p.weight_product" +
            " from c4_zone.product as p" +
            " JOIN capacity as c on p.id_capacity = c.id_capacity" +
            " JOIN color as co on p.id_color = co.id_color" +
            " JOIN cpu as cp on p.id_cpu = cp.id_cpu" +
            " JOIN ram as r on p.id_ram = r.id_ram" +
            " JOIN series as s on p.id_series = s.id_series" +
            " JOIN type as t on p.id_type = t.id_type" +
            " WHERE p.id_product= :idProduct and p.status_business = true", nativeQuery = true)
    Product findProductById(@Param("idProduct") Long idProduct);

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

    @Query(value = "SELECT LAST_INSERT_ID()", nativeQuery = true)
    Long getLastInsertedId();

    @Transactional
    @Modifying
    @Query(value = "UPDATE product set name_product = :#{#product.nameProduct},battery_product = :#{#product.batteryProduct}, " +
            "description_product= :#{#product.descriptionProduct}, camera_product = :#{#product.cameraProduct}, " +
            "price_product = :#{#product.priceProduct}, quantity_product = :#{#product.quantityProduct}, " +
            "screen_product = :#{#product.screenProduct}, selfie_product = :#{#product.selfieProduct}, " +
            "weight_product = :#{#product.weightProduct}, id_capacity = :#{#product.capacity.idCapacity}, " +
            "id_color = :#{#product.color.idColor}, id_cpu = :#{#product.cpu.idCpu}, id_ram = :#{#product.ram.idRam}, " +
            "id_series = :#{#product.series.idSeries}, id_type = :#{#product.type.idType} " +
            "WHERE id_product = :#{#product.idProduct}", nativeQuery = true)
    void updateProduct(@Param("product") Product product);
    @Query(value = "select id_product as idProductOrder, name_product as nameProductOrder, " +
            "price_product as priceProductOrder " +
            "from product " +
            "where id_product = :id",nativeQuery = true)
    IProductDtoOrder findProductByIdOrder(Long id);

    @Query(value = "SELECT " +
            "    p.id_product AS id," +
            "    p.battery_product AS battery," +
            "    p.camera_product AS camera," +
            "    p.name_product AS name," +
            "    p.price_product AS price," +
            "    p.quantity_product AS quantity," +
            "    ca.id_capacity AS capacity," +
            "    c.id_cpu AS cpu," +
            "    co.id_color AS color " +
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

    @Query(value = "SELECT " +
            "    p.id_product AS id," +
            "    p.battery_product AS battery," +
            "    p.camera_product AS camera," +
            "    p.name_product AS name," +
            "    p.price_product AS price," +
            "    p.quantity_product AS quantity," +
            "    ca.id_capacity AS capacity," +
            "    c.id_cpu AS cpu," +
            "    co.id_color AS color " +
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
            "    AND p.id_type = :type ", nativeQuery = true)
    Page<IProductDto> getAllByType(Pageable pageable, @Param("type") Long type);

    @Query(value = "SELECT " +
            "    p.id_product AS id," +
            "    p.battery_product AS battery," +
            "    p.camera_product AS camera," +
            "    p.name_product AS name," +
            "    p.price_product AS price," +
            "    p.quantity_product AS quantity," +
            "    ca.id_capacity AS capacity," +
            "    c.id_cpu AS cpu," +
            "    co.id_color AS color " +
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


}
