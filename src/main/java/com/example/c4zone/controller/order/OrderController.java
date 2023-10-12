package com.example.c4zone.controller.order;

import com.example.c4zone.dto.order.ICustomerDtoOrder;
import com.example.c4zone.dto.order.IProductDtoOrder;
import com.example.c4zone.service.customer.ICustomerService;
import com.example.c4zone.service.order.IOrderDetailService;
import com.example.c4zone.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/api/admin/order")
@CrossOrigin("*")
@RestController
public class OrderController {
    @Autowired
    private IOrderDetailService orderDetailService;
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private IProductService productService;

    @GetMapping("/customer/{id}")
    public ResponseEntity<ICustomerDtoOrder> findCustomer(@PathVariable Long id){
        ICustomerDtoOrder customerDtoOrder = customerService.findCustomerById(id);
        return new ResponseEntity<>(customerDtoOrder,HttpStatus.OK);
    }
    @GetMapping("/product/{id}")
    public ResponseEntity<IProductDtoOrder> findProduct(@PathVariable Long id){
        IProductDtoOrder productDtoOrder = productService.findProductById(id);
        return new ResponseEntity<>(productDtoOrder,HttpStatus.OK);
    }

}
