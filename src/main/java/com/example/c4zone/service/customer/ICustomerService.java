package com.example.c4zone.service.customer;

import com.example.c4zone.dto.order.ICustomerDtoOrder;
import com.example.c4zone.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ICustomerService {
    Page<Customer> findCustomerByNameAndAge(Pageable pageable, String valueSearchName, String valueSearchAge, Boolean valueSearchGender);
    ICustomerDtoOrder findCustomerByIdOrder(Long id);


    Optional<Customer> findById(Long id);
}
