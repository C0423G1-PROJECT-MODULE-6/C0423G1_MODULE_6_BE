package com.example.c4zone.repository.product;

import com.example.c4zone.model.product.Series;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ISeriesRepository extends JpaRepository<Series, Long> {
    @Query(value = "SELECT s.id_series, s.name, s.status_series FROM c4_zone.series as s", nativeQuery = true)
    List<Series> findAll();
}
