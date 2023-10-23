package com.example.c4zone.controller.order;

import com.example.c4zone.dto.order.*;
import com.example.c4zone.model.customer.Customer;
import com.example.c4zone.model.order.Cart;
import com.example.c4zone.model.order.OrderBill;

import com.example.c4zone.model.user.AppUser;
import com.example.c4zone.service.cart.ICartService;
import com.example.c4zone.service.customer.ICustomerService;
import com.example.c4zone.service.order.IOrderDetailService;
import com.example.c4zone.service.product.IProductService;

import com.example.c4zone.service.user.IAppUserService;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDate;
import java.time.LocalTime;

import java.util.List;
import java.util.Optional;


@RequestMapping("/api/admin/sale/order")
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
        if (id != null){
            ICustomerDtoOrder customerDtoOrder = customerService.findCustomerByIdOrder(id);
            OrderBill orderBillByCustomerNotPay = orderDetailService.isNotPayOfCustomer(id);
            List<Cart> cartOfCustomer = cartService.findCartOfCustomer(id);
            ObjectResponseDto objectResponseDto = new ObjectResponseDto();
            if (orderBillByCustomerNotPay != null){
                if (cartOfCustomer.isEmpty()){
                    orderDetailService.deleteOrderDetailOfBill(orderBillByCustomerNotPay.getIdOrderBill());
                    orderDetailService.deleteOldBillNotPay(orderBillByCustomerNotPay.getCustomer().getIdCustomer());
                    objectResponseDto.setType("customer");
                    objectResponseDto.setObjectResponse(customerDtoOrder);
                    return new ResponseEntity<>(objectResponseDto,HttpStatus.OK);
                }else {
                    objectResponseDto.setType("orderBill");
                    objectResponseDto.setObjectResponse(orderBillByCustomerNotPay);
                    return new ResponseEntity<>(objectResponseDto,HttpStatus.OK);
                }
            }else if (!cartOfCustomer.isEmpty()){
                objectResponseDto.setType("cartOrder");
                objectResponseDto.setObjectResponse(cartOfCustomer);
                return new ResponseEntity<>(objectResponseDto,HttpStatus.OK);
            }else {
                objectResponseDto.setType("customer");
                objectResponseDto.setObjectResponse(customerDtoOrder);
                return new ResponseEntity<>(objectResponseDto,HttpStatus.OK);
            }
        }
        return new ResponseEntity<>("Không tìm thấy id",HttpStatus.NOT_FOUND);
    }

    /**
     * method get bill by customer (other screen modal to choose old bill or create new)
     * after Check Customer's bill has not pay yet
     * Create ThoiND
     * Date 14-10-2023
     * param Long idUser,Long idProduct
     * return status 2xx
     */
    @GetMapping("/customer/getCartByChoose/{idCus}")
    public ResponseEntity<Object> getOrderNotPayByChoose(
            @RequestParam(name = "_choose") Integer choose,
            @PathVariable Long idCus){
        if (idCus != null) {
            if (choose == 1) {
                List<Cart> cart = cartService.findCartOfCustomer(idCus);
                if (cart == null) {
                    return new ResponseEntity<>("Không tìm thấy", HttpStatus.NOT_FOUND);
                } else {
                    return new ResponseEntity<>(cart, HttpStatus.OK);
                }
            } else if (choose == 2) {
                cartService.deleteCartByCustomer(idCus);
                List<Cart> cart1 = cartService.findCartOfCustomer(idCus);
                return new ResponseEntity<>(cart1, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    @GetMapping("/customer/getOrderNotPay/{idCus}/{idUser}")
    public ResponseEntity<Object> getOrderNotPayByChoose(
            @RequestParam(name = "_choose") Integer choose,
            @PathVariable Long idCus,
            @PathVariable Long idUser){
        if (idCus != null && idUser != null){
            OrderBill orderBillByCustomerNotPay = orderDetailService.isNotPayOfCustomer(idCus);
            if (orderBillByCustomerNotPay == null){
                return new ResponseEntity<>("Không tìm thấy",HttpStatus.NOT_FOUND);
            }else {
                if (choose == 1){
                    return new ResponseEntity<>(orderBillByCustomerNotPay,HttpStatus.OK);
                }else if (choose == 2){
                    orderDetailService.deleteOrderDetailOfBill(orderBillByCustomerNotPay.getIdOrderBill());
                    orderDetailService.deleteOldBillNotPay(idCus);
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
                    cartService.deleteCartByCustomer(idCus);
                    return new ResponseEntity<>(orderBill,HttpStatus.OK);
                }
            }
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }


    /**
     * method getAllCart
     * Create ThoiND
     * Date 12-10-2023
     * param Long idUser
     * return cartList status 2xx
     */
    @GetMapping("/cart/{idCustomer}")
    public ResponseEntity<Object> getAllCart(@PathVariable Long idCustomer){
        if (idCustomer != null){
            List<ICartDto> cart = cartService.getAllCart(idCustomer);
            if (cart == null){
                return new ResponseEntity<>("Không tìm thấy giỏ hàng",HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(cart,HttpStatus.OK);
        }
        return new ResponseEntity<>("Không tìm thấy ID",HttpStatus.NOT_FOUND);
    }
    /**
     * method add to cart and update quantity
     * Create ThoiND
     * Date 14-10-2023
     * param Long idUser,Long idProduct
     * return status 2xx
     */
    @PostMapping("/cart/{idCustomer}/{idProduct}")
    public ResponseEntity<String> findProductAndChangeQuantity(
            @RequestParam(name = "_quantity", defaultValue = "1",required = false) Integer quantity,
            @PathVariable Long idCustomer,
            @PathVariable Long idProduct
    ){
        if (idCustomer != null && idProduct != null){
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
            cartService.addToCart(idCustomer,idProduct,quantity);
            return new ResponseEntity<>("Bạn đã thêm sản phẩm vào đơn hàng",HttpStatus.OK);
        }
        return new ResponseEntity<>("Không tìm thấy ID",HttpStatus.NOT_FOUND);
    }
    /**
     * method delete chosen product
     * Create ThoiND
     * Date 14-10-2023
     * param Long idUser,Long idProduct
     * return status 2xx
     */
//    @PostMapping("/cart/deleteChosenProduct/{idUser},{idProduct}")
    @PostMapping("/cart/deleteChosenProduct/{idProduct}/{idCustomer}")
    public ResponseEntity<Object> deleteChosenProduct(@PathVariable Long idCustomer,@PathVariable Long idProduct){
        if (idCustomer == null){
            return new ResponseEntity<>("Không tìm thấy idUser",HttpStatus.BAD_REQUEST);
        }
        if (idProduct == null){
            return new ResponseEntity<>("Không tìm thấy idProduct",HttpStatus.BAD_REQUEST);
        }
        cartService.deleteChosenProduct(idCustomer,idProduct);
        return new ResponseEntity<>("Bạn đã xóa sản phẩm",HttpStatus.OK);
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
    public ResponseEntity<Object> showOrderBillBeforePay(@RequestBody OrderPaymentDto orderPaymentDto){
        if (orderPaymentDto.getIdCustomerOrder() != null && orderPaymentDto.getIdUser() != null){
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
        return new ResponseEntity<>("Không tìm thấy ID",HttpStatus.NOT_FOUND);
    }
    @GetMapping("/payment/showBillNewest/{idCustomer}")
    public ResponseEntity<Object> showBillNewest(@PathVariable Long idCustomer){
        if (idCustomer != null){
            OrderBill orderBill = orderDetailService.isNotPayOfCustomer(idCustomer);
            return new ResponseEntity<>(orderBill,HttpStatus.OK);
        }
        return new ResponseEntity<>("Không tìm thấy ID",HttpStatus.NOT_FOUND);
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
        if (orderBill != null){
            List<ICartDto> cartDto = cartService.getAllCart(orderBill.getCustomer().getIdCustomer());
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
        return new ResponseEntity<>("Không tìm thấy ID",HttpStatus.NOT_FOUND);
    }
}

