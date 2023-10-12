package com.example.c4zone.service.order;

import com.example.c4zone.dto.order.OrderHistoryDtoTotal;

import java.util.List;
import java.util.Optional;

public interface IOrderDetailService {
    Optional<List<OrderHistoryDtoTotal>> getAllHistoryTotal();


}
