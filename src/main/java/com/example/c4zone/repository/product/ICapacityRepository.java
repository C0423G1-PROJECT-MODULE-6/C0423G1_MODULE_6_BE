package com.example.c4zone.repository.product;

import com.example.c4zone.model.product.Capacity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ICapacityRepository extends JpaRepository<Capacity, Long> {
    @Query(value = "SELECT c.id_capacity, c.name, c.status_capacity FROM c4_zone.capacity as c",nativeQuery = true)
    List<Capacity>findAll();
}
