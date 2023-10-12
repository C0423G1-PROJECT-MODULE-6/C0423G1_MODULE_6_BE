package com.example.c4zone.service.customer;

import com.example.c4zone.dto.customer.IShoppingHistory;
import com.example.c4zone.dto.order.ICustomerDtoOrder;
import com.example.c4zone.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ICustomerService {
    Page<Customer> findCustomerByNameAndAge(Pageable pageable, String valueSearchName, String valueSearchAge, Boolean valueSearchGender);
    Optional<Customer> findById(Long id);
    Page<IShoppingHistory> findShoppingHistory(Pageable pageable, String valueSearchName, Long id);
    ICustomerDtoOrder findCustomerByIdOrder(Long id);


    /**
     * Author: TinDT
     * Goal: save customers
     */
    void saveCustomer(Customer customer);

    Customer findCustomerByPhone(String phoneNumberCustomer);


    Customer findCustomerByEmail(String emailCustomer);


}
