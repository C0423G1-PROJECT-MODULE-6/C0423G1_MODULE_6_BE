package com.example.c4zone.service.cart;

import com.example.c4zone.dto.order.ICartDto;
import com.example.c4zone.model.customer.Customer;
import com.example.c4zone.model.order.Cart;

import java.util.List;

public interface ICartService {
    /**
     * Author: TinDT
     * Goal: create cart for sale page
     */
    void saveCart(Cart cart);

    /**
     * method getAllCart
     * Create ThoiND
     * Date 12-10-2023
     * param Long idUser
     * return List<ICartDto>
     */
    List<ICartDto> getAllCart(Long idUser);
}
