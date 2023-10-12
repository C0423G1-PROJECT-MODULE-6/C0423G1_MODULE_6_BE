package com.example.c4zone.service.customer;

import com.example.c4zone.dto.order.ICustomerDtoOrder;

public interface ICustomerService {
    ICustomerDtoOrder findCustomerById(Long id);
}
