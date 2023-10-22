package com.example.c4zone.service.cart;

import com.example.c4zone.dto.order.ICartDto;
import com.example.c4zone.dto.product.IProductCartDto;
import com.example.c4zone.model.order.Cart;
import com.example.c4zone.model.order.OrderBill;
import com.example.c4zone.model.product.Product;
import com.example.c4zone.model.user.AppUser;
import com.example.c4zone.model.wareHouse.WareHouse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


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
    List<ICartDto> getAllCart(Long idCustomer);



    void addToCart(Long idUser, Long idProduct, Integer quantity);

    void deleteCart(Long idUser);

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
    Long getQuantityProductOrder(Long idProduct, Long idCustomer);

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

    /**
     * method delete chosen product
     * Create ThoiND
     * Date 14-10-2023
     * param Long idUser,Long idProduct
     * return status 2xx
     */
    void deleteChosenProduct(Long idUser, Long idProduct);



    void findCartById(OrderBill orderBillByCustomerNotPay);
    /**
     * author :TinDT
     * work day : 12/10/2023
     * @param pageable page control
     * @param name name of search
     * @return page had control
     */
    Page<IProductCartDto> getAllByNameModal(Pageable pageable, String name);
    /**
     * author :TinDT
     * work day : 12/10/2023
     * @param pageable control page return
     * @param price : price of product
     * @return page had control
     */
    Page<IProductCartDto> getAllByPrice(Pageable pageable,String price);
    /**
     * author :TinDT
     * work day : 12/10/2023
     * @param pageable : control page return
     * @param idType : id type's of product
     * @return page had control
     */
    Page<IProductCartDto> getAllByType(Pageable pageable,String idType);
    /**
     * author :TinDT
     * work day : 12/10/2023
     * @param pageable control page return
     * @param value : value of choose quantity
     * @return page had control
     */
    Page<IProductCartDto> getAllByQuantity(Pageable pageable, String value);
    /**
     * author :TinDT
     * work day : 12/10/2023
     * @param Long idProduct
     * @param value : value of choose product
     * @return page had control
     */
    WareHouse findProductById(Long idProduct);

    List<Cart> findCartOfCustomer(Long id);

    void deleteCartByCustomer(Long idCus);


    void creatNewCart(Long idCus);
}
