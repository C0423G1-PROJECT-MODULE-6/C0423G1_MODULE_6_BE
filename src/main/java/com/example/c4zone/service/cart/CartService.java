package com.example.c4zone.service.cart;


import com.example.c4zone.dto.order.ICartDto;
import com.example.c4zone.model.order.Cart;
import com.example.c4zone.repository.cart.ICartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    /**
     * method getAllCart
     * Create ThoiND
     * Date 12-10-2023
     * param Long idUser
     * return List<ICartDto>
     */
    @Override
    public List<ICartDto> getAllCart(Long idUser) {
        return cartRepository.getAllCart(idUser);
    }

    @Override
    public void addToCart(Long idUser, Long idProduct, Integer quantity) {
        cartRepository.addToCart(idUser,idProduct,quantity);
    }

    @Override
    public void deleteCart(Long idUser) {
        cartRepository.deleteCart(idUser);
    }
}
