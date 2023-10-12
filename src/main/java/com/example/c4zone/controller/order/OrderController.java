package com.example.c4zone.controller.order;

import com.example.c4zone.dto.order.*;
import com.example.c4zone.model.customer.Customer;
import com.example.c4zone.model.order.OrderBill;
import com.example.c4zone.model.order.OrderDetail;
import com.example.c4zone.model.user.AppUser;
import com.example.c4zone.service.cart.ICartService;
import com.example.c4zone.service.customer.ICustomerService;
import com.example.c4zone.service.order.IOrderDetailService;
import com.example.c4zone.service.product.IProductService;
import com.example.c4zone.service.user.IAppUserService;
import com.example.c4zone.service.user.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;


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
    @Autowired
    private IEmployeeService employeeService;

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
    @GetMapping("/cart/{id}")
    public ResponseEntity<List<ICartDto>> getAllCart(@PathVariable Long id){
        List<ICartDto> cart = cartService.getAllCart(id);
        return new ResponseEntity<>(cart,HttpStatus.OK);
    }
    @PostMapping("/payment")
    public ResponseEntity<OrderBill> paymentOrder(@RequestBody OrderPaymentDto orderPaymentDto){
        OrderBill orderBill = new OrderBill();
        Optional<Customer> customer = customerService.findById(orderPaymentDto.getIdCustomerOrder());
        AppUser appUser = employeeService.getUserById(orderPaymentDto.getIdUser());
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
//        List<CartDto> cartDtos = cartService.getAllCart(orderPaymentDto.getIdUser());

        orderBill.setCustomer(customer.orElse(null));
        orderBill.setUser(appUser);
        orderBill.setDateOfOrder(String.valueOf(localDate));
        orderBill.setTimeOfOrder(String.valueOf(localTime));
        return null;
    }
}

