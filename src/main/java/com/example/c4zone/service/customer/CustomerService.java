package com.example.c4zone.service.customer;

import com.example.c4zone.dto.order.ICustomerDtoOrder;
import com.example.c4zone.model.customer.Customer;
import com.example.c4zone.repository.customer.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public Page<Customer> findCustomerByNameAndAge(Pageable pageable, String valueSearchName, String valueSearchAge, Boolean valueSearchGender) {
        if (!valueSearchAge.equals("")) {
            return customerRepository.findAllCustomerByAge(pageable, "%" + valueSearchName + "%", valueSearchAge, valueSearchGender);
        }
        if (valueSearchGender != null) {
            return customerRepository.findAllCustomerByGender(pageable, "%" + valueSearchName + "%", valueSearchGender);
        }
        return customerRepository.findAllCustomerByName(pageable, "%" + valueSearchName + "%");


    }
    /**
     * method findByCustomer
     * Create ThoiND
     * Date 12-10-2023
     * param Long id
     * return HttpStatus
     */
    @Override
    public ICustomerDtoOrder findCustomerByIdOrder(Long id) {
        return customerRepository.findCustomerByIdOrder(id);
    }
}
