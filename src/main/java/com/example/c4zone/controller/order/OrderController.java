package com.example.c4zone.controller.order;

import com.example.c4zone.dto.order.*;
import com.example.c4zone.model.customer.Customer;
import com.example.c4zone.model.order.OrderBill;

import com.example.c4zone.model.user.AppUser;
import com.example.c4zone.service.cart.ICartService;
import com.example.c4zone.service.customer.ICustomerService;
import com.example.c4zone.service.order.IOrderDetailService;
import com.example.c4zone.service.product.IProductService;

import com.example.c4zone.service.user.IAppUserService;
import com.example.c4zone.service.user.IEmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


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
    @Autowired
    private IAppUserService appUserService;

    /**
     * method findByCustomer
     * Create ThoiND
     * Date 12-10-2023
     * param Long id
     * return Customer status 2xx
     */
    @GetMapping("/customer/{id}")
    public ResponseEntity<?> findCustomer(@PathVariable Long id){
        ICustomerDtoOrder customerDtoOrder = customerService.findCustomerByIdOrder(id);
        OrderBill orderBillByCustomerNotPay = orderDetailService.isNotPayOfCustomer(id);
        if (orderBillByCustomerNotPay != null){
            return new ResponseEntity<>(orderBillByCustomerNotPay,HttpStatus.OK);
        }
        return new ResponseEntity<>(customerDtoOrder,HttpStatus.OK);
    }
    /**
     * method getAllCart
     * Create ThoiND
     * Date 12-10-2023
     * param Long idUser
     * return cartList status 2xx
     */
    @GetMapping("/cart/{idUser}")
    public ResponseEntity<?> getAllCart(@PathVariable Long idUser){
        List<ICartDto> cart = cartService.getAllCart(idUser);
        if (cart == null){
            return new ResponseEntity<>("Không tìm thấy",HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(cart,HttpStatus.OK);
    }
    /**
     * method add to cart and update quantity
     * Create ThoiND
     * Date 14-10-2023
     * param Long idUser,Long idProduct
     * return status 2xx
     */
    @PostMapping("/cart/{idUser}/{idProduct}")
    public ResponseEntity<String> findProductAndChangeQuantity(
            @RequestParam(name = "_quantity", defaultValue = "1",required = false) Integer quantity,
            @PathVariable Long idUser,
            @PathVariable Long idProduct
    ){
        Integer quantityOfProduct = productService.getQuantityById(idProduct);
        if (quantity == null){
            return new ResponseEntity<>("Số lượng không được để trống",HttpStatus.BAD_REQUEST);
        }
        if (quantity <= 0){
            return new ResponseEntity<>("Số lượng phải lớn hơn 0",HttpStatus.BAD_REQUEST);
        }
        if (quantity > quantityOfProduct){
            return new ResponseEntity<>("Số lượng trong kho không đủ",HttpStatus.BAD_REQUEST);
        }
        cartService.addToCart(idUser,idProduct,quantity);
        return new ResponseEntity<>("Bạn đã thêm sản phẩm vào đơn hàng",HttpStatus.OK);
    }
    /**
     * method get bill by customer (other screen modal to choose old bill or create new)
     * Create ThoiND
     * Date 14-10-2023
     * param Long idUser,Long idProduct
     * return status 2xx
     */
    @GetMapping("/customer/getOrderNotPay/{idCus}/{idUser}")
    public ResponseEntity<?> getOrderNotPayByChoose(
            @RequestParam(name = "_choose") Integer choose,
            @PathVariable Long idCus,
            @PathVariable Long idUser){
        OrderBill orderBillByCustomerNotPay = orderDetailService.isNotPayOfCustomer(idCus);
        if (orderBillByCustomerNotPay == null){
            return new ResponseEntity<>("Không tìm thấy",HttpStatus.NOT_FOUND);
        }else {
            if (choose == 1){
                return new ResponseEntity<>(orderBillByCustomerNotPay,HttpStatus.OK);
            }else if (choose == 2){
                orderDetailService.deleteOrderDetailOfBill(orderBillByCustomerNotPay.getIdOrderBill());
                orderDetailService.deteleOldBillNotPay(idCus);
                OrderBill orderBill = new OrderBill();
                Optional<Customer> customer = customerService.findById(idCus);
                if (!customer.isPresent()){
                    return new ResponseEntity<>("Không tìm thấy khách hàng",HttpStatus.NOT_FOUND);
                }
                AppUser appUser = appUserService.findAppUserById(idUser);
                if (appUser == null){
                    return new ResponseEntity<>("Không tìm thấy tài khoản",HttpStatus.NOT_FOUND);
                }
                LocalDate localDate = LocalDate.now();
                LocalTime localTime = LocalTime.now();

                orderBill.setCustomer(customer.orElse(null));
                orderBill.setUser(appUser);
                orderBill.setDateOfOrder(String.valueOf(localDate));
                orderBill.setTimeOfOrder(String.valueOf(localTime));
                orderBill.setTotalMoney(0.0);
                orderBill.setPaymentMethod(0);
                orderBill.setPrintStatus(0);
                orderBill.setPaymentStatus(0);
                orderDetailService.createOrderBill(orderBill);
                return new ResponseEntity<>(orderBill,HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    /**
     * method show orderBill before pay when click button "thanh toan"
     * Create ThoiND
     * Date 14-10-2023
     * param orderPaymentDto
     * return status 2xx
     */
    @PostMapping("/payment/showBill")
    public ResponseEntity<?> showOrderBillBeforePay(@RequestBody OrderPaymentDto orderPaymentDto){

        List<ICartDto> cartDto = cartService.getAllCart(orderPaymentDto.getIdUser());

        orderDetailService.createOrderDetail(cartDto,orderPaymentDto.getIdCustomerOrder(),orderPaymentDto.getIdUser());

        Double totalMoney = orderDetailService.calculateTotalMoney(orderPaymentDto.getIdUser(),orderPaymentDto.getIdCustomerOrder());

        orderDetailService.updateOrderBill(totalMoney,orderPaymentDto.getPaymentMethod(),
                orderPaymentDto.getIdCustomerOrder(),orderPaymentDto.getIdUser());


        OrderBill orderBill = orderDetailService.isNotPayOfCustomer(orderPaymentDto.getIdCustomerOrder());

        if (orderBill == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(orderBill,HttpStatus.OK);
    }
    @PostMapping("/payment/acceptPay/{idCus}/{idUser}")
    public ResponseEntity<?> acceptToPay(@RequestParam(name = "_printStatus") int printStatus,
                                         @PathVariable Long idCus,
                                         @PathVariable Long idUser){

        if (printStatus == 1){
            orderDetailService.updateOrderBill(printStatus,idCus,idUser);
            return new ResponseEntity<>("innnn",HttpStatus.OK);
        }else {
            return new ResponseEntity<>("ok",HttpStatus.OK);
        }
    }
    /**
     * method get all history
     * Create ThoiND
     * Date 14-10-2023
     * param limit,page,name_like or sortName,sortTime,...
     * return status 2xx
     */
    @GetMapping("/saleHistory")
    public ResponseEntity<Page<IOrderHistoryDtoTotal>> getAllSaleHistory(
            @RequestParam(name = "_limit") int limit,
            @RequestParam(name = "_page") int page,
            @RequestParam(name = "name_like") Optional<String> searchName,
            @RequestParam(name = "sortNameCustomer") Optional<String> sortCustomer,
            @RequestParam(name = "sortTime") Optional<String> sortTime,
            @RequestParam(name = "sortNameProduct") Optional<String> sortNameProduct,
            @RequestParam(name = "sortQuantity") Optional<String> sortQuantity,
            @RequestParam(name = "sortTotalMoney") Optional<String> sortTotalMoney) {
        String valueSearchName = "";
        if (searchName.isPresent()) {
            valueSearchName = searchName.get();
        }
        Boolean valueSortNameCustomer = false;
        if (sortCustomer.isPresent()){
            valueSortNameCustomer = true;
        }
        Boolean valueSortTime = false;
        if (sortTime.isPresent()){
            valueSortTime = true;
        }
        Boolean valueSortNameProduct = false;
        if (sortNameProduct.isPresent()){
            valueSortNameProduct = true;
        }
        Boolean valueSortQuantity = false;
        if (sortQuantity.isPresent()){
            valueSortQuantity = true;
        }
        Boolean valueSortTotalMoney = false;
        if (sortTotalMoney.isPresent()){
            valueSortTotalMoney = true;
        }

        Pageable pageable = PageRequest.of(page, limit);
        if (valueSortNameCustomer){
            pageable = PageRequest.of(page, limit, Sort.by("name_customer").descending());
        } else if (valueSortTime){
            pageable = PageRequest.of(page, limit, Sort.by("time_of_order").ascending());
        }else if (valueSortNameProduct){
            Page<IOrderHistoryDtoTotal> saleHistoryList = orderDetailService.getAllSaleHistory(pageable, valueSearchName,1);
            return new ResponseEntity<>(saleHistoryList, HttpStatus.OK);
        } else if (valueSortQuantity) {
            Page<IOrderHistoryDtoTotal> saleHistoryList = orderDetailService.getAllSaleHistory(pageable, valueSearchName,2);
            return new ResponseEntity<>(saleHistoryList, HttpStatus.OK);
        } else if (valueSortTotalMoney) {
            pageable = PageRequest.of(page, limit, Sort.by("total_money").descending());
        }

        Page<IOrderHistoryDtoTotal> saleHistoryList = orderDetailService.getAllSaleHistory(pageable, valueSearchName ,0);
        if (saleHistoryList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(saleHistoryList, HttpStatus.OK);
}}

