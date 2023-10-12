package com.example.c4zone.repository.order;


import com.example.c4zone.dto.order.OrderHistoryDto;
import com.example.c4zone.dto.order.OrderHistoryDtoTotal;
import com.example.c4zone.model.order.OrderBill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IOrderDetailRepository extends JpaRepository<OrderBill,Long> {
    @Query(value = "select p.name_product as nameProduct, odd.quantity_order as quantityOrder " +
            "from order_detail as odd " +
            "join product as p " +
            "on p.id_product = odd.id_product " +
            "join order_bill as ob " +
            "on odd.id_order = ob.id_order_bill " +
            "join customer as c " +
            "on ob.id_customer = c.id_customer " +
            "where c.id_customer = :id",nativeQuery = true)
    Optional<List<OrderHistoryDto>> getAllHistory(@Param("id")Long id);

    @Query(value = "select od.date_of_order as dateOfOrder, od.time_of_order as timeOfOrder, " +
            "c.name_customer as nameCustomer, od.total_money as totalMoney, c.id_customer as idCustomer" +
            ", od.id_order_bill as idOrderBill  " +
            "from order_bill as od " +
            "join customer as c " +
            "on od.id_customer = c.id_customer",nativeQuery = true)
    Optional<List<OrderHistoryDtoTotal>> getAllHistoryTotal();

}
