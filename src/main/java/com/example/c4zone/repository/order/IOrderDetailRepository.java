package com.example.c4zone.repository.order;


import com.example.c4zone.dto.order.IOrderDetailDto;
import com.example.c4zone.dto.order.IOrderHistoryDtoTotal;

import com.example.c4zone.model.order.OrderBill;
import com.example.c4zone.model.order.OrderDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public interface IOrderDetailRepository extends JpaRepository<OrderBill,Long> {

    /**
     * method create order bill
     * Create ThoiND
     * Date 14-10-2023
     * param orderbill
     * return void
     */
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO  order_bill  ( date_of_order ,  payment_method ,  print_status ,  time_of_order ,  " +
            "total_money ,  id_customer ,  id_user ) " +
            "VALUES (:#{#orderBill.dateOfOrder},:#{#orderBill.paymentMethod},:#{#orderBill.printStatus}," +
            ":#{#orderBill.timeOfOrder},:#{#orderBill.totalMoney},:#{#orderBill.customer.idCustomer}," +
            ":#{#orderBill.user.id})",nativeQuery = true)
    void createOrderBill(@Param("orderBill") OrderBill orderBill);
    /**
     * method create order detail
     * Create ThoiND
     * Date 14-10-2023
     * param orderDetail
     * return void
     */
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO  order_detail  ( price_order , quantity_order, id_order,id_product ) " +
            "VALUES (:#{#orderDetail.priceOrder},:#{#orderDetail.quantityOrder},:#{#orderDetail.orderBill.idOrderBill}," +
            ":#{#orderDetail.product.idProduct})",nativeQuery = true)
    void createOrderDetail(@Param("orderDetail") OrderDetail orderDetail);

    /**
     * method get all order detail of order bill
     * Create ThoiND
     * Date 14-10-2023
     * param id order bill
     * return void
     */
    @Query(value = "select price_order as priceProduct, quantity_order as quantityOrder " +
            "from order_detail " +
            "where id_order = :id",nativeQuery = true)
    List<IOrderDetailDto> getAllOrderDetailByOrderBill(@Param("id") Long idOrderBill);
    /**
     * method update total money to order bill
     * Create ThoiND
     * Date 14-10-2023
     * param orderbill
     * return void
     */
    @Modifying
    @Transactional
    @Query(value = "update order_bill set total_money = :total where id_order_bill = :id",nativeQuery = true)
    void updateTotalMoney( @Param("id") Long idOrderBill,@Param("total") Double totalMoney);
    /**
     * method find order bill newest
     * Create ThoiND
     * Date 14-10-2023
     * param none
     * return order bill
     */
    @Query(value = "select * from order_bill order by id_order_bill desc limit 1",nativeQuery = true)
    OrderBill findOrderBillWithNewest();

    /**
     * method get all sale history
     * Create ThoiND
     * Date 14-10-2023
     * param pageable, searchName
     * return page
     */
    @Query(value = "SELECT " +
            "    OB.id_order_bill as idOrderBill, " +
            "    OB.date_of_order as dateOfOrder , " +
            "    OB.time_of_order as timeOfOrder, " +
            "    C.name_customer as nameCustomer, " +
            "    GROUP_CONCAT(CONCAT(P.name_product, ' x', OD.quantity_order) SEPARATOR ', ') as infoBuy , " +
            "    OB.total_money as totalMoney " +
            "FROM " +
            "    order_bill OB " +
            "LEFT JOIN " +
            "    order_detail OD ON OB.id_order_bill = OD.id_order " +
            "LEFT JOIN " +
            "    customer C ON OB.id_customer = C.id_customer " +
            "LEFT JOIN " +
            "    product P ON OD.id_product = P.id_product " +
            "WHERE C.name_customer like :name " +
            "GROUP BY " +
            "    OB.id_order_bill",nativeQuery = true)
    Page<IOrderHistoryDtoTotal> getAllHistory(Pageable pageable,@Param("name") String s);
    /**
     * method get all sale history sort by name product
     * Create ThoiND
     * Date 14-10-2023
     * param pageable, searchName
     * return page
     */
    @Query(value = "SELECT " +
            "    OB.id_order_bill as idOrderBill, " +
            "    OB.date_of_order as dateOfOrder , " +
            "    OB.time_of_order as timeOfOrder, " +
            "    C.name_customer as nameCustomer, " +
            "    GROUP_CONCAT(CONCAT(P.name_product, ' x', OD.quantity_order) SEPARATOR ', ') as infoBuy , " +
            "    OB.total_money as totalMoney " +
            "FROM " +
            "    order_bill OB " +
            "LEFT JOIN " +
            "    order_detail OD ON OB.id_order_bill = OD.id_order " +
            "LEFT JOIN " +
            "    customer C ON OB.id_customer = C.id_customer " +
            "LEFT JOIN " +
            "    product P ON OD.id_product = P.id_product " +
            "WHERE C.name_customer like :name " +
            "GROUP BY " +
            "    OB.id_order_bill " +
            "ORDER BY " +
            "    SUBSTRING_INDEX(SUBSTRING_INDEX(infoBuy, ' x', -1), ', ', -1) desc",nativeQuery = true)
    Page<IOrderHistoryDtoTotal> getAllHistorySortProduct(Pageable pageable,@Param("name") String s);
    /**
     * method get all sale history sort by quantity of order
     * Create ThoiND
     * Date 14-10-2023
     * param pageable, searchName
     * return page
     */
    @Query(value = "SELECT " +
            "    OB.id_order_bill as idOrderBill, " +
            "    OB.date_of_order as dateOfOrder , " +
            "    OB.time_of_order as timeOfOrder, " +
            "    C.name_customer as nameCustomer, " +
            "    GROUP_CONCAT(CONCAT(P.name_product, ' x', OD.quantity_order) SEPARATOR ', ') as infoBuy , " +
            "    OB.total_money as totalMoney " +
            "FROM " +
            "    order_bill OB " +
            "LEFT JOIN " +
            "    order_detail OD ON OB.id_order_bill = OD.id_order " +
            "LEFT JOIN " +
            "    customer C ON OB.id_customer = C.id_customer " +
            "LEFT JOIN " +
            "    product P ON OD.id_product = P.id_product " +
            "WHERE C.name_customer like :name " +
            "GROUP BY " +
            "    OB.id_order_bill " +
            "ORDER BY " +
            "    CAST(SUBSTRING_INDEX(SUBSTRING_INDEX(info_buy, ' x', -1), ', ', -1) AS SIGNED) desc",nativeQuery = true)
    Page<IOrderHistoryDtoTotal> getAllHistorySortQuantity(Pageable pageable,@Param("name") String s);
}
