package com.example.c4zone.repository.product;

import com.example.c4zone.model.product.Series;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ISeriesRepository extends JpaRepository<Series, Long> {
    /**
     * author: DaoPTA
     * workday: 12/10/2023
     *
     * @return list Series
     */
    @Query(value = "SELECT s.id_series, s.name, s.status_series FROM c4_zone.series as s", nativeQuery = true)
    List<Series> findAll();
    @Query(value = "SELECT s.id_series, r.name FROM c4_zone.series as s" +
            " WHERE id_series = :idSeries and status_series = true",nativeQuery = true)
    Series findSeriesById(@Param("idSeries") Long idSeries);
}
