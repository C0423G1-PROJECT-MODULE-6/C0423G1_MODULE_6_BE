package com.example.c4zone.repository.supplier;

import com.example.c4zone.dto.warehouse.ISupplierDtoWarehouse;
import com.example.c4zone.model.supplier.Supplier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ISupplierRepository extends JpaRepository<Supplier,Long> {
    @Query(value = "SELECT * FROM  Supplier s WHERE s.name_supplier LIKE concat('%',:nameSearch,'%') " +
            "AND s.address_supplier LIKE concat('%',:addressSearch,'%') " +
            "AND s.email_supplier LIKE concat('%',:emailSearch,'%') ",nativeQuery = true)
    Page<Supplier> getAllSupplier(@Param("nameSearch") String name, @Param("addressSearch") String addressSearch
            , @Param("emailSearch") String emailSearch, Pageable pageable);

    @Modifying
    @Transactional
    @Query(value = "update Supplier as s set s.status_supplier = 1 where s.id_supplier = :id",nativeQuery = true)
    void deleteSupplier(@Param(value = "id") Long id);

    @Query("select s from Supplier s")
    Page<Supplier> getAllSupplierNoCondition(Pageable pageable);
    @Query(value = "SELECT * FROM Supplier s WHERE s.id_supplier = :id",nativeQuery = true)
    Supplier findSupplierById(@Param("id") Long id);
    @Query(value = "select id_supplier as idSupplier, name_supplier as nameSupplier, " +
            "from supplier " +
            "where id_supplier = :id",nativeQuery = true)
    ISupplierDtoWarehouse findSupplierByIdWarehouse(Long id);
}
