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

    /**
     * author: NghiaNPX
     * date: 12/10/2023
     * goal: edit an object in DB
     *
     */
    @Modifying
    @Transactional
    @Query(value = "update c4_zone.supplier " +
            "set address_supplier = :address, " +
            "code_supplier = :code, " +
            "email_supplier = :email, " +
            "name_supplier = :name, " +
            "phone_number_supplier = :phoneNumber " +
            "where id_supplier = :id", nativeQuery = true)
    void updateSupplier(@Param("id") Long idSupplier,
                        @Param("code") Integer codeSupplier,
                        @Param("name") String nameSupplier,
                        @Param("address") String addressSupplier,
                        @Param("phoneNumber") String phoneNumberSupplier,
                        @Param("email") String emailSupplier);

    /**
     * author: NghiaNPX
     * date: 12/10/2023
     * goal: create new supplier
     *
     */
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO c4_zone.supplier (code_supplier, name_supplier, address_supplier, phone_number_supplier, email_supplier, status_supplier) " +
            "VALUES (:#{#supplier.codeSupplier}, " +
            ":#{#supplier.nameSupplier}, " +
            ":#{#supplier.addressSupplier}, " +
            ":#{#supplier.phoneNumberSupplier}, " +
            ":#{#supplier.emailSupplier}, false)", nativeQuery = true)
    void saveSupplier(@Param("supplier") Supplier newSupplier);

    /**
     * author: NghiaNPX
     * date: 13/10/2023
     * goal: SQL statement for querying supplier by code_supplier
     */
    @Query(value = "select * from c4_zone.supplier where code_supplier like :code", nativeQuery = true)
    Supplier findByCode(@Param("code") String s);

    /**
     * author: NghiaNPX
     * date: 13/10/2023
     * goal: SQL statement for querying supplier by name_supplier
     */
    @Query(value = "select * from c4_zone.supplier where name_supplier like :name", nativeQuery = true)
    Supplier findByName(@Param("name") String s);

    /**
     * author: NghiaNPX
     * date: 13/10/2023
     * goal: SQL statement for querying supplier by phone_number_supplier
     */
    @Query(value = "select * from c4_zone.supplier where phone_number_supplier like :phone", nativeQuery = true)
    Supplier findByPhoneNumber(@Param("phone") String s);

    /**
     * author: NghiaNPX
     * date: 13/10/2023
     * goal: SQL statement for querying supplier by email_supplier
     */
    @Query(value = "select * from c4_zone.supplier where email_supplier like :email", nativeQuery = true)
    Supplier findByEmail(@Param("email") String s);
}
