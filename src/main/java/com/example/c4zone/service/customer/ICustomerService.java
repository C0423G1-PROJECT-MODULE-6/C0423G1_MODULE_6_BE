package com.example.c4zone.service.customer;

import com.example.c4zone.dto.customer.ICustomerListDto;
import com.example.c4zone.dto.customer.IShoppingHistoryDto;
import com.example.c4zone.dto.order.ICustomerDtoOrder;
import com.example.c4zone.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ICustomerService {
    Page<ICustomerListDto> findCustomerByNameAndAge(Pageable pageable, String valueSearchName, String valueSearchAge, String valueSearchGender);
    Optional<Customer> findById(Long id);
    Page<IShoppingHistoryDto> findShoppingHistory(Pageable pageable, String valueSearchName, Long id);

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


}
