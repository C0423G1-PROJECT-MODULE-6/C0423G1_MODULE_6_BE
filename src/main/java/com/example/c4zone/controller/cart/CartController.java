package com.example.c4zone.controller.cart;
import com.example.c4zone.dto.product.IProductDto;
import com.example.c4zone.model.product.Product;
import com.example.c4zone.model.user.AppUser;
import com.example.c4zone.service.cart.ICartService;
import com.example.c4zone.service.product.IProductService;
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
    public ResponseEntity<?> createCart(@RequestParam (defaultValue = "0", name="id_user") Long idUSer,
                                        @RequestParam (defaultValue = "0", name = "id_product") Long idProduct,
                                        @RequestParam (defaultValue = "0",name = "quantity") Long quantity) {
        AppUser user = employeeService.getEmployeeById(idUSer);
        IProductDto product = productService.findById(idProduct);
        if (user == null){
            return new ResponseEntity<>("Không tìm thấy idUser", HttpStatus.NOT_ACCEPTABLE);
        }
//        if (product == null){
//            return new ResponseEntity<>("Không tìm thấy idProduct", HttpStatus.NOT_ACCEPTABLE);
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
            return new ResponseEntity<>("Sản phẩm "+product.getName() +" đã hết hàng", HttpStatus.NO_CONTENT);
        }
        if (checkQuantityCart != null) {
            if ((checkQuantityCart + quantity) > checkQuantityProduct) {
                return new ResponseEntity<>("Số lượng " + product.getName() +" vượt quá số lượng kho", HttpStatus.CREATED);
            }
        }
        cartService.saveCart(idUSer, idProduct, quantity);
        return new ResponseEntity<>(product.getName() +"chọn thành công ",HttpStatus.OK);

    }

}
