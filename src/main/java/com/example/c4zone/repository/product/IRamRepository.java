package com.example.c4zone.repository.product;

import com.example.c4zone.model.product.Ram;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IRamRepository extends JpaRepository<Ram, Long> {
    @Query(value = "SELECT r.id_ram, r.name, r.status_ram FROM c4_zone.ram as r", nativeQuery = true)
    List<Ram> findAll();
}
