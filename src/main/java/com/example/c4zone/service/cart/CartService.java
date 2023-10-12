package com.example.c4zone.service.cart;

import com.example.c4zone.model.order.Cart;
import com.example.c4zone.repository.cart.ICartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService implements ICartService{
    @Autowired
    ICartRepository cartRepository;
    /**
     * Author: TinDT
     * Goal: create cart
     */
    @Override
    public void saveCart(Cart cart) {
        cartRepository.saveCart(cart);
    }
}
