package com.example.c4zone.repository.product;

import com.example.c4zone.model.product.Capacity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ICapacityRepository extends JpaRepository<Capacity, Long> {
    /**
     * author: DaoPTA
     * workday: 12/10/2023
     *
     * @return list capacity
     */
    @Query(value = "SELECT c.id_capacity, c.name, c.status_capacity FROM c4_zone.capacity as c",nativeQuery = true)
    List<Capacity>findAll();

    @Transactional
    @Modifying
    @Query(value = "SELECT c.id_capacity, c.name FROM c4_zone.capacity as c " +
            "WHERE id_capacity = :idCapacity and status_capacity = true", nativeQuery = true)
    Capacity findCapacityById(@Param("idCapacity") Long idCapacity);
}
