package com.example.c4zone.service.cart;

import com.example.c4zone.dto.order.ICartDto;
import com.example.c4zone.dto.product.IProductCartDto;
import com.example.c4zone.dto.product.IProductDto;
import com.example.c4zone.model.customer.Customer;
import com.example.c4zone.model.order.Cart;
import com.example.c4zone.model.product.Product;

import java.util.List;

public interface ICartService {
    /**
     * method Create Cart
     * Create TinDT
     * Date 12-10-2023
     * param Cart cart
     * return voide
     */
    void saveCart(Long idUser,Long idProduct,Long newQuantity);

    /**
     * method getAllCart
     * Create ThoiND
     * Date 12-10-2023
     * param Long idUser
     * return List<ICartDto>
     */
    List<ICartDto> getAllCart(Long idUser);
    /**
     * method get quantity idProduct of cart form Product
     * Create TinDT
     * Date 12-10-2023
     * param  cart
     * return Long
     */
    Long getQuantityProduct(Long id);
}
