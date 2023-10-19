package com.example.c4zone.service.order;

import com.example.c4zone.dto.order.ICartDto;
import com.example.c4zone.dto.order.IOrderHistoryDtoTotal;
import com.example.c4zone.model.order.OrderBill;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface IOrderDetailService {


    void createOrderBill(OrderBill orderBill);


    void createOrderDetail(List<ICartDto> cartDto, Long idCustomerOrder, Long idUser);

    Double calculateTotalMoney(Long idUser, Long idCustomerOrder);



    Page<IOrderHistoryDtoTotal> getAllSaleHistory(Pageable pageable, String valueSearchName, int i);

    OrderBill isNotPayOfCustomer(Long id);

    void deteleOldBillNotPay(Long id);

    void updateOrderBill(Double totalMoney, Integer printStatus, Long idCustomerOrder, Long idUser);

    void updateOrderBill(Double totalMoney, int printStatus, OrderBill orderBill);

    void deleteOrderDetailOfBill(Long idOrderBill);

    OrderBill findBillNewest();
}
