package com.example.c4zone.controller.customer;

import com.example.c4zone.dto.customer.CustomerDto;
import com.example.c4zone.dto.customer.IShoppingHistory;
import com.example.c4zone.dto.product.ProductDto;
import com.example.c4zone.model.customer.Customer;
import com.example.c4zone.service.customer.ICustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
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

    private static final String EMAIL = "emailCustomer";
    private static final String PHONE = "phoneNumberCustomer";

    /**
     * Author: NguyenNH
     * Goal: show list customer
     * * return HttpStatus
     */
    @GetMapping("/list")
    public ResponseEntity<Page<Customer>> listCustomer(@RequestParam(name = "_limit") int limit,
                                                       @RequestParam(name = "_page") int page,
                                                       @RequestParam(name = "name_like") Optional<String> searchName,
                                                       @RequestParam(name = "age") Optional<String> searchAge,
                                                       @RequestParam(name = "gender") Optional<Boolean> searchGender,
                                                       @RequestParam(name = "sortName") Optional<String> sortName,
                                                       @RequestParam(name = "sortCount") Optional<String> sortCount) {
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

        Boolean valueSortName = false;
        if (sortName.isPresent()){
            valueSortName = true;
        }

        Boolean valueSortCount = false;
        if (sortCount.isPresent()){
            valueSortCount = true;
        }

        Pageable pageable = PageRequest.of(page, limit);
        if (valueSortName){
            pageable = PageRequest.of(page, limit, Sort.by("name_customer").ascending());
        } else if (valueSortCount){
            pageable = PageRequest.of(page, limit, Sort.by("total_purchases").ascending());
        }

        Page<Customer> customerList = customerService.findCustomerByNameAndAge(pageable, valueSearchName, valueSearchAge, valueSearchGender);
        if (customerList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(customerList, HttpStatus.OK);
    }

    /**
     * Author: NguyenNH
     * Goal: find customer by id
     * * return HttpStatus
     */
    @GetMapping("list/{id}")
    public ResponseEntity<Customer> findById(@PathVariable Long id) {
        Customer customer = customerService.findById(id).orElse(null);
        if (customer == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    /**
     * Author: NguyenNH
     * Goal: show list shopping history
     * * return HttpStatus
     */
    @GetMapping("/history/{id}")
    public ResponseEntity<Page<IShoppingHistory>> shoppingHistory(@RequestParam(name = "_limit") int limit,
                                                                  @RequestParam(name = "_page") int page,
                                                                  @RequestParam(name = "name_like") Optional<String> searchName,
                                                                  @PathVariable Long id) {
        String valueSearchName = "";
        if (searchName.isPresent()) {
            valueSearchName = searchName.get();
        }
        Pageable pageable = PageRequest.of(page, limit);
        Page<IShoppingHistory> shoppingHistoryPage = customerService.findShoppingHistory(pageable, valueSearchName, id);
        if (shoppingHistoryPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(shoppingHistoryPage, HttpStatus.OK);
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
        if (customerCheck != null) {
            errors.put(EMAIL, "Email đã được đăng ký");
        }
        Customer customerCheckPhone = customerService.findCustomerByPhone(customerDto.getPhoneNumberCustomer());
        if (customerCheckPhone != null) {
            errors.put(PHONE, "Số điện thoại đã được đăng ký");
        }
        if (errors.size() != 0) {
            return new ResponseEntity<>(errors, HttpStatus.NOT_ACCEPTABLE);
        }
        BeanUtils.copyProperties(customerDto, customer);
        customerService.saveCustomer(customer);

        return new ResponseEntity<>(customerService.findCustomerByPhone(customer.getPhoneNumberCustomer()), HttpStatus.OK);
    }
}