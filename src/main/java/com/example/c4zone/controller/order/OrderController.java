package com.example.c4zone.controller.order;

import com.example.c4zone.dto.order.*;
import com.example.c4zone.service.cart.ICartService;
import com.example.c4zone.service.customer.ICustomerService;
import com.example.c4zone.service.order.IOrderDetailService;
import com.example.c4zone.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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
    @Autowired
    private ICartService cartService;

    /**
     * method findByCustomer
     * Create ThoiND
     * Date 12-10-2023
     * param Long id
     * return HttpStatus
     */
    @GetMapping("/customer/{id}")
    public ResponseEntity<ICustomerDtoOrder> findCustomer(@PathVariable Long id){
        ICustomerDtoOrder customerDtoOrder = customerService.findCustomerByIdOrder(id);
        return new ResponseEntity<>(customerDtoOrder,HttpStatus.OK);
    }
    /**
     * method findByProduct
     * Create ThoiND
     * Date 12-10-2023
     * param Long id
     * return HttpStatus
     */
    @GetMapping("/product/{id}")
    public ResponseEntity<IProductDtoOrder> findProduct(@PathVariable Long id){
        IProductDtoOrder productDtoOrder = productService.findProductByIdOrder(id);
        return new ResponseEntity<>(productDtoOrder,HttpStatus.OK);
    }
    /**
     * method getAllCart
     * Create ThoiND
     * Date 12-10-2023
     * param Long idUser
     * return HttpStatus
     */
    @GetMapping("/cart")
    public ResponseEntity<List<ICartDto>> getAllCart(){
        List<ICartDto> cart = cartService.getAllCart(1L);
        return new ResponseEntity<>(cart,HttpStatus.OK);
    }
//    @PostMapping("/paymentOrder")
//    public ResponseEntity<OrderBill> payOrder(@RequestBody OrderBill orderBill){
//        LocalDate localDate = LocalDate.now();
//        LocalTime localTime = LocalTime.now();
//
//        orderBill.setDateOfOrder(String.valueOf(localDate));
//        orderBill.setTimeOfOrder(String.valueOf(localTime));
//        return null;
//    }
}
