package com.example.c4zone.service.order;

import com.example.c4zone.dto.order.OrderHistoryDto;
import com.example.c4zone.dto.order.OrderHistoryDtoTotal;
import com.example.c4zone.repository.order.IOrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderDetailService implements IOrderDetailService{
    @Autowired
    private IOrderDetailRepository orderDetailRepository;


    @Override
    public Optional<List<OrderHistoryDtoTotal>> getAllHistoryTotal() {
        List<OrderHistoryDtoTotal> list = orderDetailRepository.getAllHistoryTotal().orElse(null);
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                String product = "";
                List<OrderHistoryDto> listTemp = orderDetailRepository.getAllHistory(list.get(i).getIdCustomer()).orElse(null);
                for (int j = 0; j < listTemp.size(); j++) {
                    product += listTemp.get(i).getNameProduct() + " " + listTemp.get(i).getQuantityOrder() + ", ";
                }
                list.get(i).setNameProduct(product);
            }
            return Optional.of(list);
        }
        return Optional.ofNullable(list);
    }
}
