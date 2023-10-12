package com.example.c4zone.repository.wareHouse;

import com.example.c4zone.model.wareHouse.IWarehouseProjection;
import com.example.c4zone.model.wareHouse.WareHouse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;


public interface IWareHouseRepository extends JpaRepository<WareHouse, Long> {
    @Query(value = " SELECT " +
            " w.id_warehouse AS idWarehouse , " +
            " p.name_product AS nameProduct ," +
            " p.price_product AS priceProduct ," +
            " s.name_supplier AS nameSupplier ," +
            " w.input_date AS inputDate ," +
            " w.quantity AS quantity , " +
            " (p.price_product * w.quantity) AS totalPrice " +
            "FROM ware_house w " +
            "JOIN product p ON w.product_id = p.id_product " +
            "JOIN supplier s ON w.supplier_id = s.id_supplier " +
            "GROUP BY w.id_warehouse, w.input_date ", nativeQuery = true)
    Page<IWarehouseProjection> findAllWareHouse(Pageable pageable);

    @Transactional
    @Modifying
    @Query(value = "insert into ware_house(product_id,supplier_id, quantity, input_date) " +
            "values(:wareHouse.product_id,:wareHouse.supplier_id, :wareHouse.quantity, date(now()))", nativeQuery = true)
    void ImportProduct(WareHouse wareHouse);
}
