package com.example.c4zone.repository.product;

import com.example.c4zone.model.product.Ram;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IRamRepository extends JpaRepository<Ram, Long> {
    /**
     * author: DaoPTA
     * workday: 12/10/2023
     *
     * @return list Ram
     */
    @Query(value = "SELECT r.id_ram, r.name, r.status_ram FROM c4_zone.ram as r", nativeQuery = true)
    List<Ram> findAll();
    @Query(value = "SELECT r.id_ram, r.name FROM c4_zone.ram as r" +
            " WHERE id_ram = :idRam and status_ram = true",nativeQuery = true)
    Ram findRamById(@Param("idRam") Long idRam);
}
