package com.example.c4zone.repository.product;

import com.example.c4zone.model.product.Color;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IColorRepository extends JpaRepository<Color, Long> {
    @Query(value = "SELECT c.id_color, c.name, c.status_color FROM c4_zone.color as c", nativeQuery = true)
    List<Color> findAll();
}
