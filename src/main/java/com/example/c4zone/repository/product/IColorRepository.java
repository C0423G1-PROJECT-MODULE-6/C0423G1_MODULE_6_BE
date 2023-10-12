package com.example.c4zone.repository.product;

import com.example.c4zone.model.product.Color;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IColorRepository extends JpaRepository<Color, Long> {
    @Query(value = "SELECT c.id_color, c.name, c.status_color FROM c4_zone.color as c", nativeQuery = true)
    List<Color> findAll();
    @Transactional
    @Modifying
    @Query(value = "SELECT co.id_color, co.name FROM c4_zone.color as co " +
            "WHERE id_color = :idColor and status_color = true", nativeQuery = true)
    Color findColorById(@Param("idColor") Long idColor);
}
