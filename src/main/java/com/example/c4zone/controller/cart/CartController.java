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
     * Author: TinDT
     * Goal: create cart of employee for sale page
     * * return HttpStatus
     */
    @Autowired
    private ICartService cartService;
    @PostMapping("/create")
    public ResponseEntity<?> createCart(@RequestBody Cart cart) {
        cartService.saveCart(cart);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
