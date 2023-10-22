package com.example.c4zone.service.cart;


import com.example.c4zone.dto.order.ICartDto;
import com.example.c4zone.dto.product.IProductCartDto;
import com.example.c4zone.model.order.Cart;
import com.example.c4zone.model.order.OrderBill;
import com.example.c4zone.model.order.OrderDetail;
import com.example.c4zone.model.product.Product;
import com.example.c4zone.model.user.AppUser;

import com.example.c4zone.model.wareHouse.WareHouse;
import com.example.c4zone.repository.cart.ICartRepository;
import com.example.c4zone.repository.order.IOrderDetailRepository;
import com.example.c4zone.repository.product.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public List<ICartDto> getAllCart(Long idCustomer) {
        return cartRepository.getAllCart(idCustomer);
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
    public Long getQuantityProductOrder(Long idProduct, Long idCustomer) {
        return cartRepository.quantityProductCart(idProduct,idCustomer);
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
    /**
     * method delete chosen product
     * Create TinDT
     * Date 14-10-2023
     * param Long idUser,Long idProduct
     * return list product
     */
    @Override
    public Page<IProductCartDto> getAllByNameModal(Pageable pageable, String name) {
        return cartRepository.getAllByName(pageable, '%'+name+'%');
    }
    /**
     * author :TinDT
     * work day : 12/10/2023
     * @param pageable control page return
     * @param price : price of product
     * @return page had control
     */

    @Override
    public Page<IProductCartDto> getAllByPrice(Pageable pageable, String price) {
        switch (price) {
            case "smaller 5m":
                return cartRepository.getAllByPriceMax(pageable, 5000000.0);
            case "5m to 10m":
                return cartRepository.getAllByPrice(pageable, 5000000.0, 10000000.0);
            case "better 10m":
                return cartRepository.getAllByPriceMin(pageable, 10000000.0);
            default:
                return cartRepository.getAllByName(pageable, "%%");
        }
    }
    /**
     * author :TinDT
     * work day : 12/10/2023
     * @param pageable : control page return
     * @param idType : id type's of product
     * @return page had control
     */
    @Override
    public Page<IProductCartDto> getAllByType(Pageable pageable, String idType) {
        return cartRepository.getAllByType(pageable, Long.parseLong(idType));
    }

    /**
     * author :TinDT
     * work day : 12/10/2023
     * @param pageable control page return
     * @param value : value of choose quantity
     * @return page had control
     */
    @Override
    public Page<IProductCartDto> getAllByQuantity(Pageable pageable, String value) {
        switch (value) {
            case "smaller 10":
                return cartRepository.getAllByQuantityMax(pageable, 10);
            case "10 to 50":
                return cartRepository.getAllByQuantity(pageable, 10, 50);
            case "better 50":
                return cartRepository.getAllByQuantityMin(pageable, 50);
            default:
                return cartRepository.getAllByName(pageable, "%%");
        }
    }
    /**
     * author :TinDT
     * work day : 12/10/2023
     * @param idProduct control page return
     * @return page had control
     */

    @Override
    public WareHouse findProductById(Long idProduct) {
        return cartRepository.getProductWareById(idProduct);
    }

    @Override
    public List<Cart> findCartOfCustomer(Long id) {
        return cartRepository.getAllCartOfCustomer(id);
    }

    @Override
    public void deleteCartByCustomer(Long idCus) {
        cartRepository.deleteCartByIdCus(idCus);
    }

    @Override
    public void creatNewCart(Long idCus) {
        cartRepository.createNewCart(idCus);
    }

}
