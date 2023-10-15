package com.example.c4zone.controller.cart;
import com.example.c4zone.service.cart.ICartService;
import com.example.c4zone.service.product.IProductService;
import com.example.c4zone.service.user.IAppUserService;
import com.example.c4zone.service.user.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@CrossOrigin("*")
@RequestMapping("/api/admin/cart")
public class CartController {
    /**
     * method create cart for Sale page
     * Create TinDT
     * Date 14-10-2023
     * param  idUser
     * param  idProduct
     * param  quantity
     * return Http status
     */
    @Autowired
    private ICartService cartService;
    @Autowired
    private IProductService productService;
    @Autowired
    private IEmployeeService employeeService;
    @PostMapping("/create")
    public ResponseEntity<?> createCart(@RequestParam Long idUSer,
                                        @RequestParam Long idProduct,
                                        @RequestParam Long quantity) {
//        if (productService.findProductById(idProduct) == null){
//            return new ResponseEntity<>("Không tìm thấy idProduct", HttpStatus.NOT_ACCEPTABLE);
//        }
//        if (employeeService.getUserById(idUSer) == null){
//            return new ResponseEntity<>("Không tìm thấy idUser", HttpStatus.NOT_ACCEPTABLE);
//        }
        if (idProduct == null || idProduct < 1) {
            return new ResponseEntity<>("Không tìm thấy idProduct", HttpStatus.NOT_ACCEPTABLE);
        }
        if (idUSer == null || idUSer < 1) {
            return new ResponseEntity<>("Không tìm thấy idUser", HttpStatus.NOT_ACCEPTABLE);
        }
        if (quantity == null || quantity < 0) {
            return new ResponseEntity<>("Sai số lượng chọn hàng", HttpStatus.NOT_ACCEPTABLE);
        }
        Long checkQuantityProduct = cartService.getQuantityProduct(idProduct);
        Long checkQuantityCart = cartService.getQuantityProductOrder(idProduct, idUSer);

        if (checkQuantityProduct == 0) {
            System.out.println(checkQuantityProduct);
            return new ResponseEntity<>("Sản phẩm đã hết hàng", HttpStatus.NOT_ACCEPTABLE);
        }
        if (checkQuantityCart != null) {
            if ((checkQuantityCart + quantity) > checkQuantityProduct) {
                return new ResponseEntity<>("Số lượng vượt quá số lượng kho", HttpStatus.NOT_ACCEPTABLE);
            }
        }
        cartService.saveCart(idUSer, idProduct, quantity);
        return new ResponseEntity<>(HttpStatus.OK);

    }

}
