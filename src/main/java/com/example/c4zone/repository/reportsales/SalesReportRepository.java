package com.example.c4zone.repository.reportsales;

import com.example.c4zone.model.product.Product;
import com.example.c4zone.dto.reportsales.SalesReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SalesReportRepository extends JpaRepository<Product, Integer> {
    @Query(value = "WITH RECURSIVE AllDates AS (SELECT DATE_FORMAT(NOW(), '%Y-%m-01') AS `date` UNION ALL SELECT DATE_ADD(`date`, INTERVAL 1 DAY) FROM AllDates WHERE DATE_ADD(`date`, INTERVAL 1 DAY) <= LAST_DAY(DATE_FORMAT(NOW(), '%Y-%m-01'))) SELECT ad.`date` AS `date`, 'Tất Cả' AS `name`, COALESCE(SUM((od.price_order - p.price_product) * od.quantity_order), 0) AS `daily`, COALESCE(SUM(od.quantity_order), 0) AS `quantity` FROM AllDates ad LEFT JOIN order_bill ob ON ad.`date` = ob.date_of_order LEFT JOIN order_detail od ON ob.id_order_bill = od.id_order LEFT JOIN product p ON od.id_product = p.id_product GROUP BY ad.`date`, `name` ORDER BY ad.`date`", nativeQuery = true)
    List<SalesReport> getData(String startDate, String endDate, String searchTerm);

    @Query(value = "WITH RECURSIVE DateRange AS (SELECT :startDate AS `date` UNION ALL SELECT DATE_ADD(`date`, INTERVAL 1 DAY) FROM DateRange WHERE DATE_ADD(`date`, INTERVAL 1 DAY) <= :endDate) SELECT dr.`date` AS `date`, 'Tất Cả' AS `name`, COALESCE(SUM((od.price_order - p.price_product) * od.quantity_order), 0) AS `daily`, COALESCE(SUM(od.quantity_order), 0) AS `quantity` FROM DateRange dr LEFT JOIN order_bill ob ON DATE(dr.`date`) = DATE(ob.date_of_order) LEFT JOIN order_detail od ON ob.id_order_bill = od.id_order LEFT JOIN product p ON od.id_product = p.id_product WHERE od.id_product = :idProduct GROUP BY dr.`date`, `name` UNION SELECT dr.`date` AS `date`, 'Tất Cả' AS `name`, 0 AS `daily`, 0 AS `quantity` FROM DateRange dr ORDER BY `date`", nativeQuery = true)
    List<SalesReport> getDataSreach(String startDate, String endDate, Long idProduct);

    @Query(value = "WITH RECURSIVE DateRange AS ("
            + "SELECT :startDate AS `date` "
            + "UNION ALL "
            + "SELECT DATE_ADD(`date`, INTERVAL 1 DAY) "
            + "FROM DateRange "
            + "WHERE DATE_ADD(`date`, INTERVAL 1 DAY) <= :endDate "
            + ")"
            + "SELECT "
            + "dr.`date` AS `date`, "
            + "'Tất Cả' AS `name`, "
            + "COALESCE(SUM((od.price_order - p.price_product) * od.quantity_order), 0) AS `daily`, "
            + "COALESCE(SUM(od.quantity_order), 0) AS `quantity` "
            + "FROM DateRange dr "
            + "LEFT JOIN order_bill ob ON dr.`date` = ob.date_of_order "
            + "LEFT JOIN order_detail od ON ob.id_order_bill = od.id_order "
            + "LEFT JOIN product p ON od.id_product = p.id_product "
            + "GROUP BY dr.`date`, `name` "
            + "ORDER BY `date`", nativeQuery = true)
    List<SalesReport> getDataSreachNull(String startDate, String endDate);
}
