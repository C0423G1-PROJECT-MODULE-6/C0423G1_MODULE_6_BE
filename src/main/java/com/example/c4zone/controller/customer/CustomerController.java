package com.example.c4zone.controller.customer;

import com.example.c4zone.model.customer.Customer;
import com.example.c4zone.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/admin/customer")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

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

    @GetMapping("/{id}")
    public ResponseEntity<Customer> findById(@PathVariable Long id) {
        Customer customer = customerService.findById(id).orElse(null);
        if (customer == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(customer,HttpStatus.OK);
    }
    @GetMapping("/history/{id}")
    public ResponseEntity<Page<Customer>> shoppingHistory(@RequestParam(name = "_limit") int limit,
                                                  @RequestParam(name = "_page") int page,
                                                  @RequestParam(name = "name_like") Optional<String> searchName){
        return null;
    }
}
