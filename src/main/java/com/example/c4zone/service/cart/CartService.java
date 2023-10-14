package com.example.c4zone.service.cart;

import com.example.c4zone.dto.order.ICartDto;
import com.example.c4zone.dto.product.IProductCartDto;
import com.example.c4zone.dto.product.IProductDto;
import com.example.c4zone.model.order.Cart;
import com.example.c4zone.model.product.Product;
import com.example.c4zone.repository.cart.ICartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService implements ICartService{
    @Autowired
    ICartRepository cartRepository;
    /**
     * method create Cart
     * Create TinDT
     * Date 12-10-2023
     * param Cart cart
     * return voide
     */
    @Override
    public void saveCart(Long idUser,Long idProduct,Long newQuantity) {

        cartRepository.addToCart(idUser,idProduct,newQuantity);
    }
    /**
     * method get quantity idProduct of cart form Product
     * Create TinDT
     * Date 12-10-2023
     * param Cart cart
     * return Long
     */
    @Override
    public Long getQuantityProduct(Long id) {
        return cartRepository.quantityProduct(id);
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
}
