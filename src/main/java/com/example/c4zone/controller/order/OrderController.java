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


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
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
    private IAppUserService appUserService;

    /**
     * method findByCustomer
     * Create ThoiND
     * Date 12-10-2023
     * param Long id
     * return Customer status 2xx
     */
    @GetMapping("/customer/{id}")
    public ResponseEntity<Object> findCustomer(@PathVariable Long id){
        ICustomerDtoOrder customerDtoOrder = customerService.findCustomerByIdOrder(id);
        OrderBill orderBillByCustomerNotPay = orderDetailService.isNotPayOfCustomer(id);
        ObjectResponseDto objectResponseDto = new ObjectResponseDto();
        if (orderBillByCustomerNotPay != null){
            objectResponseDto.setType("orderBill");
            objectResponseDto.setObjectResponse(orderBillByCustomerNotPay);
            return new ResponseEntity<>(objectResponseDto,HttpStatus.OK);
        }
        objectResponseDto.setType("customer");
        objectResponseDto.setObjectResponse(customerDtoOrder);
        return new ResponseEntity<>(objectResponseDto,HttpStatus.OK);
    }
    /**
     * method getAllCart
     * Create ThoiND
     * Date 12-10-2023
     * param Long idUser
     * return cartList status 2xx
     */
    @GetMapping("/cart/{idUser}")
    public ResponseEntity<Object> getAllCart(@PathVariable Long idUser){
        List<ICartDto> cart = cartService.getAllCart(idUser);
        if (cart == null){
            return new ResponseEntity<>("Không tìm thấy giỏ hàng",HttpStatus.NOT_FOUND);
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
     * method delete chosen product
     * Create ThoiND
     * Date 14-10-2023
     * param Long idUser,Long idProduct
     * return status 2xx
     */
    @PostMapping("/cart/deleteChosenProduct/{idUser},{idProduct}")
    public ResponseEntity<Object> deleteChosenProduct(@PathVariable Long idUser,@PathVariable Long idProduct){
        if (idUser == null){
            return new ResponseEntity<>("Không tìm thấy idUser",HttpStatus.BAD_REQUEST);
        }
        if (idProduct == null){
            return new ResponseEntity<>("Không tìm thấy idProduct",HttpStatus.BAD_REQUEST);
        }
        cartService.deleteChosenProduct(idUser,idProduct);
        return new ResponseEntity<>("Bạn đã xóa sản phẩm",HttpStatus.OK);
    }
    /**
     * method get bill by customer (other screen modal to choose old bill or create new)
     * after Check Customer's bill has not pay yet
     * Create ThoiND
     * Date 14-10-2023
     * param Long idUser,Long idProduct
     * return status 2xx
     */
    @GetMapping("/customer/getOrderNotPay/{idCus}/{idUser}")
    public ResponseEntity<Object> getOrderNotPayByChoose(
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
                cartService.deleteCart(idUser);
                return new ResponseEntity<>(orderBill,HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    /**
     * method show orderBill before pay when click button "thanh toan"
     * if customer dont have bill not pay, create new orbill. else find orderbill with this customer and create orderDetail
     * Create ThoiND
     * Date 14-10-2023
     * param orderPaymentDto
     * return status 2xx
     */
    @PostMapping("/payment/showBill")
    @Transactional
    public ResponseEntity<Object> showOrderBillBeforePay(@RequestBody OrderPaymentDto orderPaymentDto){

        OrderBill orderBillNotPay = orderDetailService.isNotPayOfCustomer(orderPaymentDto.getIdCustomerOrder());
        if (orderBillNotPay == null){
            OrderBill orderBill = new OrderBill();
            Optional<Customer> customer = customerService.findById(orderPaymentDto.getIdCustomerOrder());
            if (!customer.isPresent()){
                return new ResponseEntity<>("Không tìm thấy khách hàng",HttpStatus.NOT_FOUND);
            }
            AppUser appUser = appUserService.findAppUserById(orderPaymentDto.getIdUser());
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
            orderBill.setPaymentMethod(orderPaymentDto.getPaymentMethod());
            orderBill.setPrintStatus(0);
            orderBill.setPaymentStatus(0);
            orderDetailService.createOrderBill(orderBill);
            return new ResponseEntity<>(orderBill,HttpStatus.OK);

        }else {
            return new ResponseEntity<>(orderBillNotPay,HttpStatus.OK);
        }


    }
    @GetMapping("/payment/showBillNewest")
    public ResponseEntity<OrderBill> showBillNewest(){
        OrderBill orderBill = orderDetailService.findBillNewest();
        return new ResponseEntity<>(orderBill,HttpStatus.OK);
    }
    /**
     * method accepToPay to confirm print contact
     * Create ThoiND
     * Date 15-10-2023
     * param printStatus,idCus,idUser
     * return status 2xx
     */
    @PostMapping("/payment/acceptPay")
    public ResponseEntity<Object> acceptToPay(@RequestParam(name = "_printStatus") int printStatus,
                                         @RequestBody OrderBill orderBill){
        List<ICartDto> cartDto = cartService.getAllCart(orderBill.getUser().getId());
        orderDetailService.createOrderDetail(cartDto,orderBill.getCustomer().getIdCustomer(),orderBill.getUser().getId());
        Double totalMoney = orderDetailService.calculateTotalMoney(orderBill.getUser().getId(),orderBill.getCustomer().getIdCustomer());
        ObjectResponseDto objectResponseDto = new ObjectResponseDto();
        if (printStatus == 1){
            orderDetailService.updateOrderBill(totalMoney,printStatus,orderBill);
            objectResponseDto.setType("print");
            objectResponseDto.setObjectResponse(orderBill);
            return new ResponseEntity<>(objectResponseDto,HttpStatus.OK);
        }else if (printStatus == 0){
            orderDetailService.updateOrderBill(totalMoney,printStatus,orderBill);
            objectResponseDto.setType("noPrint");
            objectResponseDto.setObjectResponse(orderBill);
            return new ResponseEntity<>(objectResponseDto,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
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

