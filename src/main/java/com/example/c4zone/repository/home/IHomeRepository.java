package com.example.c4zone.repository.home;

import com.example.c4zone.dto.product.IProductDto;
import com.example.c4zone.model.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller

public interface IHomeRepository extends JpaRepository<Product, Long> {
    /**
     * @param name
     * @param sortName : must be product_id or price
     * @return a list of product combining with sorting type. This method is born for list page and searching function
     * @author Tai Phat
     */
    @Query(value = "SELECT \n" +
            "    p.id_product AS id,\n" +
            "    p.name_product AS name,\n" +
            "    p.price_product AS price,\n" +
            "    p.quantity_product AS quantity\n" +
            "FROM\n" +
            "    product p\n" +
            "        JOIN\n" +
            "    capacity ON capacity.id_capacity = p.id_capacity\n" +
            "        JOIN\n" +
            "    color ON color.id_color = p.id_color\n" +
            "WHERE\n" +
            "    p.name_product LIKE :searchName \n" +
            "ORDER BY CASE WHEN :sortName = 'id' THEN p.id_product END DESC, CASE WHEN :sortName = 'price' THEN p.price_product END DESC", nativeQuery = true)
    List<IProductDto> getProductsByNameSortByPriceDESC(@Param("searchName") String name, @Param("sortName") String sortName);


    @Query(value = "SELECT \n" +
            "    p.id_product AS id,\n" +
            "    p.name_product AS name,\n" +
            "    p.price_product AS price,\n" +
            "    p.quantity_product AS quantity\n" +
            "FROM\n" +
            "    product p\n" +
            "        JOIN\n" +
            "    capacity ON capacity.id_capacity = p.id_capacity\n" +
            "        JOIN\n" +
            "    color ON color.id_color = p.id_color\n" +
            "WHERE\n" +
            "    p.name_product LIKE :searchName \n" +
            "ORDER BY CASE WHEN :sortName = 'id' THEN p.id_product END DESC, CASE WHEN :sortName = 'price' THEN p.price_product END ASC", nativeQuery = true)
    List<IProductDto> getProductsByNameSortByPriceASC(@Param("searchName") String name, @Param("sortName") String sortName);

    /**
     * @param id
     * @return all information of a product. These values will be shown in detail page in specification part.
     * @author Tai Phat
     */
    @Query(value = "SELECT \n" +
            "    p.id_product AS id,\n" +
            "    p.name_product AS name,\n" +
            "    p.battery_product AS battery,\n" +
            "    p.camera_product AS camera,\n" +
            "    p.description_product AS description,\n" +
            "    p.price_product AS price,\n" +
            "    p.quantity_product AS quantity,\n" +
            "    p.screen_product AS screen,\n" +
            "    p.selfie_product AS selfie,\n" +
            "    p.weight_product AS weight,\n" +
            "    ca.name AS capacity,\n" +
            "    co.name AS color,\n" +
            "    cp.name AS `cpu`,\n" +
            "    r.name AS ram,\n" +
            "    s.name AS series,\n" +
            "    t.name AS type\n" +
            "FROM\n" +
            "    product p\n" +
            "        JOIN\n" +
            "    capacity ca ON ca.id_capacity = p.id_capacity\n" +
            "        JOIN\n" +
            "    color co ON co.id_color = p.id_color\n" +
            "        JOIN\n" +
            "    `cpu` cp ON cp.id_cpu = p.id_cpu\n" +
            "        JOIN\n" +
            "    ram r ON r.id_ram = p.id_ram\n" +
            "        JOIN\n" +
            "    series s ON s.id_series = p.id_series\n" +
            "        JOIN\n" +
            "    type t ON t.id_type = p.id_type\n" +
            "WHERE\n" +
            " p.id_product = :id", nativeQuery = true)
    IProductDto getProductById(@Param("id") Long id);

    /**
     * This method is used for detail page. When user click on each capacity or color button
     *
     * @param name
     * @param capacity
     * @param color
     * @return
     * @author Tai Phat
     */
    @Query(value = "SELECT \n" +
            "    p.id_product AS id,\n" +
            "    p.name_product AS name,\n" +
            "    p.battery_product AS battery,\n" +
            "    p.camera_product AS camera,\n" +
            "    p.description_product AS description,\n" +
            "    p.price_product AS price,\n" +
            "    p.quantity_product AS quantity,\n" +
            "    p.screen_product AS screen,\n" +
            "    p.selfie_product AS selfie,\n" +
            "    p.weight_product AS weight,\n" +
            "    ca.name AS capacity,\n" +
            "    co.name AS color,\n" +
            "    cp.name AS `cpu`,\n" +
            "    r.name AS ram,\n" +
            "    s.name AS series,\n" +
            "    t.name AS type\n" +
            "FROM\n" +
            "    product p\n" +
            "        JOIN\n" +
            "    capacity ca ON ca.id_capacity = p.id_capacity\n" +
            "        JOIN\n" +
            "    color co ON co.id_color = p.id_color\n" +
            "        JOIN\n" +
            "    `cpu` cp ON cp.id_cpu = p.id_cpu\n" +
            "        JOIN\n" +
            "    ram r ON r.id_ram = p.id_ram\n" +
            "        JOIN\n" +
            "    series s ON s.id_series = p.id_series\n" +
            "        JOIN\n" +
            "    type t ON t.id_type = p.id_type\n" +
            "WHERE\n" +
            " p.name_product like :name and ca.name like :capacity and co.name like :color", nativeQuery = true)
    IProductDto getProductByNameAndCapacityAndColor(@Param("name") String name, @Param("capacity") String capacity, @Param("color") String color);


    /**
     * @param product_id
     * @return URL of the avatar of the product
     * @author Tai Phat
     */
    @Query(value = "  SELECT \n" +
            "    name\n" +
            "FROM\n" +
            "    image\n" +
            "WHERE\n" +
            "    id_product = :product_id\n" +
            "LIMIT 1", nativeQuery = true)
    String getAvatarByProductId(@Param("product_id") Long product_id);


    /**
     * @param name: this name must be formatted before receive ex: Iphone 14 pro max 128GB -> Iphone 14 pro max
     * @return all colors of a specific product
     * @author Tai Phat
     */
    @Query(value = "SELECT DISTINCT\n" +
            "    color.name\n" +
            "FROM\n" +
            "    product\n" +
            "        JOIN\n" +
            "    color ON product.id_color = color.id_color\n" +
            "WHERE\n" +
            "    name_product LIKE :name", nativeQuery = true)
    List<String> getColorsOfAProductByName(@Param("name") String name);


    /**
     * @param name: this name must be formatted before receive ex: Iphone 14 pro max 128GB -> Iphone 14 pro max
     * @return a list of capacities of a product
     * @author Tai Phat
     */
    @Query(value = "SELECT DISTINCT \n" +
            "    capacity.name AS capacity \n" +
            "FROM\n" +
            "    product\n" +
            "        JOIN\n" +
            "    capacity ON capacity.id_capacity = product.id_capacity\n" +
            "WHERE\n" +
            "    name_product LIKE :name", nativeQuery = true)
    List<String> getCapacitiesOfProductByName(@Param("name") String name);


    /**
     * @param product_id
     * @return a list of images of a product
     * @author Tai Phat
     */
    @Query(value = "SELECT \n" +
            "    name\n" +
            "FROM\n" +
            "    image\n" +
            "WHERE\n" +
            "    id_product = :product_id ", nativeQuery = true)
    List<String> getImageLinksByProductId(@Param("product_id") Long product_id);

    /**
     * @return 8 products that are bestsellers of C4ZONE store
     * @author Tai Phat
     */
    @Query(value = "SELECT \n" +
            "    p.id_product AS id,\n" +
            "    p.name_product AS name,\n" +
            "    p.price_product AS price,\n" +
            "    p.quantity_product AS quantity\n" +
            "FROM\n" +
            "    product p\n" +
            "        JOIN\n" +
            "    order_detail o ON o.id_order_detail = p.id_product\n" +
            "GROUP BY id\n" +
            "ORDER BY SUM(o.quantity_order) DESC\n" +
            "LIMIT 8;\n" +
            "    ", nativeQuery = true)
    List<Product> getBestsellers();
}
