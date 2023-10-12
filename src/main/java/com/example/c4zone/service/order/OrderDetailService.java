package com.example.c4zone.service.order;

import com.example.c4zone.repository.order.IOrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailService implements IOrderDetailService{
    @Autowired
    private IOrderDetailRepository orderDetailRepository;
}
