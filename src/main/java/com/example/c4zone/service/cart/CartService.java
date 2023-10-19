package com.example.c4zone.service.cart;


import com.example.c4zone.dto.order.ICartDto;
import com.example.c4zone.dto.order.IOrderDetailDto;
import com.example.c4zone.model.order.Cart;
import com.example.c4zone.model.order.OrderBill;
import com.example.c4zone.model.order.OrderDetail;
import com.example.c4zone.model.product.Product;
import com.example.c4zone.model.user.AppUser;

import com.example.c4zone.repository.cart.ICartRepository;
import com.example.c4zone.repository.order.IOrderDetailRepository;
import com.example.c4zone.repository.product.IProductRepository;
import com.example.c4zone.service.order.IOrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService implements ICartService{
    @Autowired
    ICartRepository cartRepository;
    @Autowired
    IOrderDetailRepository orderDetailRepository;
    @Autowired
    IProductRepository  productRepository;
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
    }

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



    /**
     * method delete chosen product
     * Create ThoiND
     * Date 14-10-2023
     * param Long idUser,Long idProduct
     * return status 2xx
     */
    @Override
    public void deleteChosenProduct(Long idUser, Long idProduct) {
         cartRepository.deleteChosenProduct(idUser,idProduct);
    }

    @Override
    public void findCartById(OrderBill orderBillByCustomerNotPay) {
        List<OrderDetail> orderDetailByOrderBill = orderDetailRepository
                .getAllOrderDetail(orderBillByCustomerNotPay.getIdOrderBill());
        for (OrderDetail orderDetail : orderDetailByOrderBill){
            cartRepository.addToCart(orderBillByCustomerNotPay.getUser().getId(),orderDetail.getProduct().getIdProduct(),
                            orderDetail.getQuantityOrder());
        }
    }
}
