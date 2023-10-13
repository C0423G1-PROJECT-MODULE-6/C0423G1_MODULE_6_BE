package com.example.c4zone.controller.customer;

import com.example.c4zone.dto.customer.CustomerDto;
import com.example.c4zone.model.customer.Customer;
import com.example.c4zone.service.customer.ICustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/admin/customer")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;
    private static final String EMAIL_DTO = "emailCustomer";
    private static final String PHONE_DTO = "phoneNumberCustomer";

    @GetMapping("/list")
    public ResponseEntity<Page<Customer>> listCustomer(@RequestParam(name = "_limit") int limit,
                                                       @RequestParam(name = "_page") int page,
                                                       @RequestParam(name = "name_like") Optional<String> searchName,
                                                       @RequestParam(name = "age") Optional<String> searchAge,
                                                       @RequestParam(name = "gender") Optional<Boolean> searchGender) {
        String valueSearchName = "";
        if (searchName.isPresent()) {
            valueSearchName = searchName.get();
        }

        String valueSearchAge = "";
        if (searchAge.isPresent()) {
            valueSearchAge = searchAge.get();
        }

        Boolean valueSearchGender = null;
        if (searchGender.isPresent()) {
            valueSearchGender = searchGender.get();
        }

        Pageable pageable = PageRequest.of(page, limit);
        Page<Customer> customerList = customerService.findCustomerByNameAndAge(pageable, valueSearchName, valueSearchAge, valueSearchGender);
        if (customerList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(customerList, HttpStatus.OK);
    }
    /**
     * Author: TinDT
     * Goal: create customer
     * * return HttpStatus
     */
    @PostMapping("/create")
    public ResponseEntity<?> createCustomer(@Valid @RequestBody CustomerDto customerDto, BindingResult bindingResult) {
        Customer customer = new Customer();
        Map<String, String> errors = new HashMap<>();
        new CustomerDto().validate(customerDto, bindingResult);
        if (bindingResult.hasErrors()) {
            for (FieldError err : bindingResult.getFieldErrors()) {
                errors.put(err.getField(), err.getDefaultMessage());
            }
        }
        Customer customerCheck = customerService.findCustomerByEmail(customerDto.getEmailCustomer());
        if (customerCheck != null){
            errors.put(EMAIL_DTO,"Email đã được đăng ký");
        }
        Customer  customerCheckPhone = customerService.findCustomerByPhone(customerDto.getPhoneNumberCustomer());
        if (customerCheckPhone != null) {
            errors.put(PHONE_DTO, "Số điện thoại đã được đăng ký");
        }
        if (errors.size() != 0){
            return new ResponseEntity<>(errors, HttpStatus.NOT_ACCEPTABLE);
        }
        BeanUtils.copyProperties(customerDto, customer);
        customerService.saveCustomer(customer);

        return new ResponseEntity<>(customerService.findCustomerByPhone(customer.getPhoneNumberCustomer()),HttpStatus.OK);
    }
}
