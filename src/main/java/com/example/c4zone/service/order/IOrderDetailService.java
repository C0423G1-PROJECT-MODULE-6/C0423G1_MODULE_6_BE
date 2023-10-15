package com.example.c4zone.service.order;

import com.example.c4zone.dto.order.ICartDto;
import com.example.c4zone.dto.order.IOrderHistoryDtoTotal;
import com.example.c4zone.model.order.OrderBill;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface IOrderDetailService {


    void createOrderBill(OrderBill orderBill);


    void createOrderDetail(List<ICartDto> cartDto);

    Double calculateTotalMoney();

    void updateTotalMoney(Double totalMoney);

    Page<IOrderHistoryDtoTotal> getAllSaleHistory(Pageable pageable, String valueSearchName, int i);
}
