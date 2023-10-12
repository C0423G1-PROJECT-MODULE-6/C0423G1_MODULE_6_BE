package com.example.c4zone.repository.product;

import com.example.c4zone.model.product.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ITypeRepository extends JpaRepository<Type, Long> {
    /**
     * author: DaoPTA
     * workday: 12/10/2023
     *
     * @return list type
     */
    @Query(value = "SELECT t.id_type, t.name, t.status_type FROM c4_zone.type as t", nativeQuery = true)
    List<Type> findAll();
}
