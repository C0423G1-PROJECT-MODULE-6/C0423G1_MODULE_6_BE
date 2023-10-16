package com.example.c4zone.service.cart;


import com.example.c4zone.dto.order.ICartDto;
import com.example.c4zone.model.product.Product;
import com.example.c4zone.model.user.AppUser;

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
     * param  cart
     * return voide
     */
    @Override
    public void saveCart(Long idUser,Long idProduct,Long newQuantity) {

        cartRepository.createCard(idUser,idProduct,newQuantity);

    }

    /**
     * method get quantity idProduct of cart form Product
     * Create TinDT
     * Date 12-10-2023
     * param  cart
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


    @Override
    public void addToCart(Long idUser, Long idProduct, Integer quantity) {
        cartRepository.addToCart(idUser,idProduct,quantity);
    }

    @Override
    public void deleteCart(Long idUser) {
        cartRepository.deleteCart(idUser);

    /**
     * method get quantity idProduct of cart form Product
     * Create TinDT
     * Date 12-10-2023
     * param  Long idProduct
     * return Long
     */
    @Override
    public Long getQuantityProductOrder(Long idProduct, Long idUser) {
        return cartRepository.quantityProductCart(idProduct,idUser);
    }
    /**
     * method get product  from iProduct
     * Create TinDT
     * Date 14-10-2023
     * param Long idProduct
     * return Product
     */
    @Override
    public Product getProductById(Long idProduct) {
        if (cartRepository.getProductById(idProduct)== null){
            return null;
        }
        return cartRepository.getProductById(idProduct);
    }
    /**
     * method get product  from iProduct
     * Create TinDT
     * Date 14-10-2023
     * param Long idProduct
     * return Product
     */
    @Override
    public AppUser getUserById(Long idUser) {
        if (cartRepository.getUserById(idUser)== null){
            return null;
        }
        return cartRepository.getUserById(idUser);

    }
}
