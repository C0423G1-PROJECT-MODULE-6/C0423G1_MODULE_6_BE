package com.example.c4zone.service.cart;

import com.example.c4zone.dto.order.ICartDto;
import com.example.c4zone.model.product.Product;
import com.example.c4zone.model.user.AppUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICartService {
    /**
     * method Create Cart
     * Create TinDT
     * Date 12-10-2023
     * param Cart cart
     * return voide
     */
    void saveCart(Long idUser, Long idProduct, Long newQuantity);

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
     * param  Long idProduct
     * return Long
     */
    Long getQuantityProduct(Long id);

    /**
     * method get quantity idProduct of cart form Product
     * Create TinDT
     * Date 12-10-2023
     * param  Long idProduct
     * return Long
     */
    Long getQuantityProductOrder(Long idProduct, Long idUser);

    /**
     * method get product  from iProduct
     * Create TinDT
     * Date 14-10-2023
     * param Long idProduct
     * return Product
     */
    Product getProductById(Long idProduct);

    /**
     * method get user  from idUser
     * Create TinDT
     * Date 14-10-2023
     * param Long idUser
     * return User
     */
    AppUser getUserById(Long idUser);

}
