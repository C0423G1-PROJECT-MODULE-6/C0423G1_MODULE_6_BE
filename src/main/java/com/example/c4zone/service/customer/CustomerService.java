package com.example.c4zone.service.customer;

import com.example.c4zone.dto.customer.ICustomerListDto;
import com.example.c4zone.dto.customer.IShoppingHistoryDto;
import com.example.c4zone.dto.order.ICustomerDtoOrder;
import com.example.c4zone.model.customer.Customer;
import com.example.c4zone.repository.customer.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;

    /**
     * Author: TinDT
     * Goal: save customers
     */

    @Override
    public void saveCustomer(Customer customer) {
        customer.setStatusCustomer(true);
        customerRepository.saveCustomer(customer);
    }

    /**
     * Author: TinDT
     * Goal: find customers by phone
     */
    @Override
    public Customer findCustomerByPhone(String phoneNumberCustomer) {
        return customerRepository.findCustomerByPhone(phoneNumberCustomer);
    }

    /**
     * Author: TinDT
     * Goal: find customers by email
     */
    @Override
    public Customer findCustomerByEmail(String emailCustomer) {
        return customerRepository.findCustomerByEmail(emailCustomer);
    }

    @Override
    public Page<ICustomerListDto> findCustomerByNameAndAge(Pageable pageable, String valueSearchName, String valueSearchAge, String valueSearchGender) {
        if (!valueSearchAge.equals("") && !valueSearchGender.equals("3")) {
            return customerRepository.findAllCustomerByAgeAndGender(pageable, "%" + valueSearchName + "%", valueSearchAge, valueSearchGender);
        }
        if (!valueSearchGender.equals("3")) {
            return customerRepository.findAllCustomerByGender(pageable, "%" + valueSearchName + "%", valueSearchGender);
        }
        if (!valueSearchAge.equals("")) {
            return customerRepository.findAllCustomerByAge(pageable, "%" + valueSearchName + "%",valueSearchAge);
        }
//        if (!valueSearchAge.equals("")&&valueSearchGender.equals("3")){
//            return customerRepository.findAllCustomerByNameAndAge(pageable, "%" + valueSearchName + "%", valueSearchAge);
//        }
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

    @Override
    public Optional<Customer> findById(Long id) {
        return customerRepository.findCustomerById(id);
    }

    @Override
    public Page<IShoppingHistoryDto> findShoppingHistory(Pageable pageable, String valueSearchName, Long id) {
        return customerRepository.findShoppingHistory(pageable, "%" + valueSearchName + "%", id);
    }
}
