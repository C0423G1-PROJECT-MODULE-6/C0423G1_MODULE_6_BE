package com.example.c4zone.controller.customer;

import com.example.c4zone.dto.customer.CustomerDto;
import com.example.c4zone.dto.customer.ICustomerListDto;
import com.example.c4zone.dto.customer.IShoppingHistoryDto;
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


    /**
     * Author: NguyenNH
     * Goal: show list customer
     * * return HttpStatus
     */
    @GetMapping("/list")
    public ResponseEntity<Page<ICustomerListDto>> getAllCustomer(@RequestParam(name = "_limit") int limit,
                                                                 @RequestParam(name = "_page") int page,
                                                                 @RequestParam(name = "name_like") Optional<String> searchName,
                                                                 @RequestParam(name = "age") Optional<String> searchAge,
                                                                 @RequestParam(name = "gender") Optional<String> searchGender,
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

        String valueSearchGender = "3";
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
            pageable = PageRequest.of(page, limit, Sort.by("nameCustomer").ascending());
        } else if (valueSortCount){
            pageable = PageRequest.of(page, limit, Sort.by("totalPurchases").descending());
        }


        Page<ICustomerListDto> customerList = customerService.findCustomerByNameAndAge(pageable, valueSearchName, valueSearchAge, valueSearchGender);
        if (customerList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(customerList, HttpStatus.OK);
    }

    /**
     * Author: TinDT
     * Goal: get all customers
     * return list of customers
     */
    @GetMapping("/modal")
    public ResponseEntity<Page<ICustomerListDto>> getAllCustomers(@RequestParam(name = "_limit") Integer limit,
                                                                  @RequestParam(defaultValue = "0", required = false,name = "_page") Integer page,
                                                                  @RequestParam(defaultValue = "", required = false,name = "name_like") String name,
                                                                  @RequestParam(defaultValue = "", required = false,name = "age") String age,
                                                                  @RequestParam(defaultValue = "2", required = false,name = "gender") String gender,
                                                                  @RequestParam(defaultValue = "", required = false,name = "phone") String phoneNumber
                                                                 ) {
        Pageable pageable = PageRequest.of(page, 5, Sort.by("nameCustomer").ascending());
        Page<ICustomerListDto> customers = customerService.getPageCustomerForModal(pageable,name,age,gender,phoneNumber);
        if (customers.getTotalElements() != 0) {
            return ResponseEntity.ok(customers);
        }
        return ResponseEntity.noContent().build();
    }

    /**
     * Author: NguyenNH
     * Goal: find customer by id
     * * return HttpStatus
     */
    @GetMapping("list/{id}")
    public ResponseEntity<Customer> findCustomerById(@PathVariable Long id) {
        Customer customer = customerService.findById(id).orElse(null);
        if (customer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    /**
     * Author: NguyenNH
     * Goal: show list shopping history
     * * return HttpStatus
     */
    @GetMapping("/history/{id}")
    public ResponseEntity<Page<IShoppingHistoryDto>> getShoppingHistory(@RequestParam(name = "_limit") int limit,
                                                                        @RequestParam(name = "_page") int page,
                                                                        @RequestParam(name = "name_like") Optional<String> searchName,
                                                                        @PathVariable Long id) {
        String valueSearchName = "";
        if (searchName.isPresent()) {
            valueSearchName = searchName.get();
        }
        Pageable pageable = PageRequest.of(page, limit);
        Page<IShoppingHistoryDto> shoppingHistoryPage = customerService.findShoppingHistory(pageable, valueSearchName, id);
        if (shoppingHistoryPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
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
        if (customerCheck != null){
            errors.put(EMAIL_DTO,"Email đã được đăng ký");
        }
        Customer customerCheckPhone = customerService.findCustomerByPhone(customerDto.getPhoneNumberCustomer());
        if (customerCheckPhone != null) {
            errors.put(PHONE_DTO, "Số điện thoại đã được đăng ký");
        }
        if (errors.size() != 0) {
            return new ResponseEntity<>(errors, HttpStatus.NOT_ACCEPTABLE);
        }
        BeanUtils.copyProperties(customerDto, customer);
        customerService.saveCustomer(customer);

        return new ResponseEntity<>(customerService.findCustomerByPhone(customer.getPhoneNumberCustomer()), HttpStatus.OK);
    }
}