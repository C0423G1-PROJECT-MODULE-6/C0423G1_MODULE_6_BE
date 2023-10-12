package com.example.c4zone.service.customer;

import com.example.c4zone.dto.order.ICustomerDtoOrder;
import com.example.c4zone.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ICustomerService {
    Page<Customer> findCustomerByNameAndAge(Pageable pageable, String valueSearchName, String valueSearchAge, Boolean valueSearchGender);
    /**
     * method findByCustomer
     * Create ThoiND
     * Date 12-10-2023
     * param Long id
     * return HttpStatus
     */
    ICustomerDtoOrder findCustomerByIdOrder(Long id);
    /**
     * Author: TinDT
     * Goal: save customers
     */
    void saveCustomer(Customer customer);

    Customer findCustomerByPhone(String phoneNumberCustomer);

    Customer findCustomerByEmail(String emailCustomer);

    Optional<Customer> findById(Long idCustomerOrder);
}
