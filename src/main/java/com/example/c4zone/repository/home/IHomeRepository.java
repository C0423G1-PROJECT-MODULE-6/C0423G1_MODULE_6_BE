package com.example.c4zone.repository.home;

import com.example.c4zone.model.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller

public interface IHomeRepository extends JpaRepository<Product, Long> {
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
        "    capacity.name AS capacity,\n" +
        "    color.name AS color,\n" +
        "    cpu.name AS cpu,\n" +
        "    r.name AS ram,\n" +
        "    s.name AS series,\n" +
        "    t.name AS product_type\n" +
        "FROM\n" +
        "    product p\n" +
        "        JOIN\n" +
        "    capacity ON capacity.id_capacity = p.id_capacity\n" +
        "        JOIN\n" +
        "    color ON color.id_color = p.id_color\n" +
        "        JOIN\n" +
        "    cpu ON cpu.id_cpu = p.id_cpu\n" +
        "        JOIN\n" +
        "    ram r ON r.id_ram = p.id_ram\n" +
        "        JOIN\n" +
        "    series s ON s.id_series = p.id_series\n" +
        "        JOIN\n" +
        "    type t ON t.id_type = p.id_type\n" +
        "WHERE\n" +
        "    p.name_product LIKE :name;", nativeQuery = true)
    List<Product> getProductsByName(@Param("name") String name);

}
