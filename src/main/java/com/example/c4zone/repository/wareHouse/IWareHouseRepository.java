package com.example.c4zone.repository.wareHouse;

import com.example.c4zone.model.wareHouse.IWarehouseProjection;
import com.example.c4zone.model.wareHouse.WareHouse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


public interface IWareHouseRepository extends JpaRepository<WareHouse, Long> {

    /**
     * method findAllwarehouse
     * Create: 12-10-2023
     * return: List warehouse
     * author: PhapTM
     */
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
            " WHERE p.name_product like :name " +
            " GROUP BY w.id_warehouse, w.input_date ", nativeQuery = true)
    Page<IWarehouseProjection> findAllWareHouseByName(Pageable pageable, @Param("name") String name);

    /**
     * method findAll by Price
     * author PhapTM
     * create 12-10-2023
     * @param pageable page
     * @param min search in approx
     * @param max search in approx
     * @return
     */

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
            " WHERE p.price_product between :min and :max " +
            " GROUP BY w.id_warehouse, w.input_date ", nativeQuery = true)
    Page<IWarehouseProjection> findAllWareHouseByPrice(Pageable pageable, @Param("min") Double min,@Param("max") Double max);

    /**
     * method findAll by Price
     * author PhapTM
     * create 12-10-2023
     * @param pageable page
     * @param min search in approx
     * @return
     */

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
            " WHERE p.price_product >= :min " +
            " GROUP BY w.id_warehouse, w.input_date ", nativeQuery = true)
    Page<IWarehouseProjection> findAllWareHouseByPriceMin(Pageable pageable, @Param("min") Double min);

    /**
     * method findAll by Price
     * author PhapTM
     * create 12-10-2023
     * @param pageable page
     * @param max search in approx
     * @return
     */

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
            " WHERE p.price_product <= :max " +
            " GROUP BY w.id_warehouse, w.input_date ", nativeQuery = true)
    Page<IWarehouseProjection> findAllWareHouseByPriceMax(Pageable pageable, @Param("max") Double max);

    /**
     * method findAll by Supplier
     * author PhapTM
     * create 12-10-2023
     * @param pageable page
     * @param name search by name supplier
     * @return
     */


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
            " WHERE s.name_supplier like:name " +
            " GROUP BY w.id_warehouse, w.input_date ", nativeQuery = true)
    Page<IWarehouseProjection> findAllWareHouseBySupplier(Pageable pageable, @Param("name") String name);


    /**
     * Method: import Product
     * author: PhapTM
     * create: 15-10-2023
     * @param productId
     * @param quantity
     * @param supplierId
     */

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO ware_house (product_id, quantity, input_date, supplier_id) " +
            "VALUES (:productId, :quantity, CURRENT_DATE(), :supplierId)", nativeQuery = true)
    void importProduct(@Param("productId") Long productId,
                       @Param("quantity") int quantity,
                       @Param("supplierId") Long supplierId);
}
