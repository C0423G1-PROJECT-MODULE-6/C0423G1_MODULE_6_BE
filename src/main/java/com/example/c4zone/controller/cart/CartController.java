package com.example.c4zone.controller.cart;

import com.example.c4zone.model.order.Cart;
import com.example.c4zone.service.cart.ICartService;
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
     * param  cart
     * return Http status
     */
    @Autowired
    private ICartService cartService;
    @PostMapping("/create")
    public ResponseEntity<?> createCart(@RequestParam Long idUSer,
                                        @RequestParam Long idProduct,
                                        @RequestParam Long quantity) {
       Long checkQuantity = cartService.getQuantityProduct(idProduct);
        if (checkQuantity > 1) {
            cartService.saveCart(idUSer,idProduct,quantity);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }

}
