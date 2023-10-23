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
@Transactional
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
            "total_money, payment_status ,  id_customer ,  id_user ) " +
            "VALUES (:#{#orderBill.dateOfOrder},:#{#orderBill.paymentMethod},:#{#orderBill.printStatus}," +
            ":#{#orderBill.timeOfOrder},:#{#orderBill.totalMoney},:#{#orderBill.paymentStatus},:#{#orderBill.customer.idCustomer}," +
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
    @Query(value =
            "SELECT " +
                    "    OB.id_order_bill as idOrderBill, " +
                    "    OB.date_of_order as dateOfOrder, " +
                    "    OB.time_of_order as timeOfOrder, " +
                    "    C.name_customer as nameCustomer, " +
                    "    GROUP_CONCAT(CONCAT(P.name_product, ' (', C2.name, ' - ', C3.name, ') x', OD.quantity_order) SEPARATOR ', \\n') as infoBuy, " +
                    "    OB.total_money as totalMoney " +
                    "FROM order_bill OB " +
                    "LEFT JOIN order_detail OD ON OB.id_order_bill = OD.id_order " +
                    "LEFT JOIN customer C ON OB.id_customer = C.id_customer " +
                    "LEFT JOIN product P ON OD.id_product = P.id_product " +
                    "LEFT JOIN color C2 ON P.id_color = C2.id_color " +
                    "LEFT JOIN capacity C3 ON P.id_capacity = C3.id_capacity " +
                    "WHERE C.name_customer LIKE :name AND OB.payment_status = 1 " +
                    "GROUP BY OB.id_order_bill ",nativeQuery = true)
    Page<IOrderHistoryDtoTotal> getAllHistory(Pageable pageable, @Param("name") String s);


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
            "WHERE C.name_customer like :name and OB.payment_status = 1 " +
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
            "WHERE C.name_customer like :name and OB.payment_status = 1 " +
            "GROUP BY " +
            "    OB.id_order_bill " +
            "ORDER BY " +
            "    CAST(SUBSTRING_INDEX(SUBSTRING_INDEX(info_buy, ' x', -1), ', ', -1) AS SIGNED) desc",nativeQuery = true)
    Page<IOrderHistoryDtoTotal> getAllHistorySortQuantity(Pageable pageable,@Param("name") String s);
    /**
     * method find bill of customer not pay
     * Create ThoiND
     * Date 15-10-2023
     * param id customer
     * return OrderBill
     */
    @Query(value = "select * from order_bill where id_customer = :id and payment_status = 0",nativeQuery = true)
    OrderBill getOrderBillNotPayOfCus(@Param("id") Long id);

    /**
     * method find bill of customer,user  not pay
     * Create ThoiND
     * Date 15-10-2023
     * param id customer
     * return OrderBill
     */
    @Query(value = "select * from order_bill where id_customer = :idCus and id_user = :idUser and payment_status = 0",nativeQuery = true)
    OrderBill getOrderBillWithCusAndUser(@Param("idCus") Long idCustomerOrder,@Param("idUser") Long idUser);
    /**
     * method update totalmoney ,payment method
     * Create ThoiND
     * Date 15-10-2023
     * param total money, payment method, id customer, id user
     * return status 2xx
     */

    @Modifying
    @Query(value = "update order_bill set total_money = :total,payment_method = :method where id_order_bill = :id",nativeQuery = true)
    void updateOrderBill(@Param("id") Long idOrderBill,@Param("total") Double totalMoney,@Param("method") Integer paymentMethod);
    /**
     * method update print status at final step
     * Create ThoiND
     * Date 15-10-2023
     * param print status, id cus, id user
     * return status 2xx
     */

    @Modifying
    @Query(value = "update order_bill set print_status = :status, payment_status = 1 where id_order_bill = :id",nativeQuery = true)
    void updateOrderBill(@Param("status") int printStatus,@Param("id") Long idOrderBill);
    /**
     * method delete old bill not pay by customer
     * Create ThoiND
     * Date 15-10-2023
     * param id customer
     * return status 2xx
     */
    @Modifying
    @Transactional
    @Query(value = "delete from order_bill where id_customer = :id and payment_status = 0",nativeQuery = true)
    void deleteOldBillNotPay(@Param("id") Long id);
    /**
     * method deleteOrderDetail of bill
     * Create ThoiND
     * Date 15-10-2023
     * param id orderbill
     * return status 2xx
     */
    @Modifying
    @Transactional
    @Query(value = "delete from order_detail where id_order= :id",nativeQuery = true)
    void deleteOrderDetailOfBill(@Param("id") Long idOrderBill);

    @Query(value = "select * from order_detail where id_order = :id",nativeQuery = true)
    List<OrderDetail> getAllOrderDetail(@Param("id") Long idOrderBill);
    @Modifying
    @Query(value = "update order_bill set total_money = :total,print_status = :print,payment_status = 1 where id_order_bill = :id",nativeQuery = true)
    void updateOrderBill(@Param("total") Double totalMoney,@Param("print") int printStatus,@Param("id") Long idOrderBill);
}
