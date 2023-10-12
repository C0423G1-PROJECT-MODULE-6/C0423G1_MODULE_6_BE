package com.example.c4zone.service.customer;

import com.example.c4zone.dto.order.ICustomerDtoOrder;
import com.example.c4zone.repository.customer.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService{
    @Autowired
   private ICustomerRepository customerRepository;


    @Override
    public ICustomerDtoOrder findCustomerByIdOrder(Long id) {
        return customerRepository.findCustomerByIdOrder(id);
    }
}
