package com.example.c4zone.service.order;

import com.example.c4zone.dto.order.ICartDto;
import com.example.c4zone.dto.order.IOrderDetailDto;

import com.example.c4zone.dto.order.IOrderHistoryDtoTotal;
import com.example.c4zone.model.order.OrderBill;
import com.example.c4zone.model.order.OrderDetail;
import com.example.c4zone.model.product.Product;
import com.example.c4zone.repository.cart.ICartRepository;
import com.example.c4zone.repository.order.IOrderDetailRepository;
import com.example.c4zone.repository.product.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class OrderDetailService implements IOrderDetailService{
    @Autowired
    private IOrderDetailRepository orderDetailRepository;
    @Autowired
    private IProductRepository productRepository;
    @Autowired
    private ICartRepository cartRepository;


    /**
     * method create order bill
     * Create ThoiND
     * Date 14-10-2023
     * param orderbill
     * return status 2xx
     */
    @Override
    public void createOrderBill(OrderBill orderBill) {
        orderDetailRepository.createOrderBill(orderBill);

    }
    /**
     * method calculate total money
     * Create ThoiND
     * Date 14-10-2023
     * param none
     * return status 2xx
     */
    @Override
    public Double calculateTotalMoney() {
        OrderBill orderBill = orderDetailRepository.findOrderBillWithNewest();
        if (orderBill == null){
            return null;
        }
        List<IOrderDetailDto> orderDetails = orderDetailRepository.getAllOrderDetailByOrderBill(orderBill.getIdOrderBill());
        if (orderDetails.size() == 0){
            return null;
        }
        double total = 0;
        for (IOrderDetailDto orderDetail: orderDetails) {
            total += orderDetail.getPriceProduct() * orderDetail.getQuantityOrder()
                    + orderDetail.getPriceProduct() * 0.1;
        }
        return total;
    }

    /**
     * method update total money to order bill
     * Create ThoiND
     * Date 14-10-2023
     * param totalMoney
     * return status 2xx
     */
    @Override
    public void updateTotalMoney(Double totalMoney) {
        OrderBill orderBill = orderDetailRepository.findOrderBillWithNewest();
        orderDetailRepository.updateTotalMoney(orderBill.getIdOrderBill(),totalMoney);
    }

    /**
     * method create order detail
     * Create ThoiND
     * Date 14-10-2023
     * param List cartDto
     * return status 2xx
     */
    @Override
    public void createOrderDetail(List<ICartDto> cartDto) {
        OrderBill orderBill = orderDetailRepository.findOrderBillWithNewest();
        if (orderBill != null){
            for (ICartDto cartDto1 : cartDto){
                OrderDetail orderDetail = new OrderDetail();
                Product product = productRepository.findProductByIdProduct(cartDto1.getIdProduct());
                orderDetail.setQuantityOrder(cartDto1.getQuantityOrder());
                orderDetail.setProduct(product);
                orderDetail.setPriceOrder(product.getPriceProduct());
                orderDetail.setOrderBill(orderBill);
                orderDetailRepository.createOrderDetail(orderDetail);
                Integer quantityOfProduct = productRepository.getQuantityByid(cartDto1.getIdProduct());
                Integer quantityOfProductAfterPayment = quantityOfProduct - orderDetail.getQuantityOrder();
                productRepository.updateQuantityOfProduct(cartDto1.getIdProduct(),quantityOfProductAfterPayment);
                cartRepository.deleteCart(orderBill.getUser().getId());
            }
        }
    }
    /**
     * method get all history
     * Create ThoiND
     * Date 14-10-2023
     * param pageable, searchName, i to choose case sort
     * return status 2xx
     */
    @Override
    public Page<IOrderHistoryDtoTotal> getAllSaleHistory(Pageable pageable, String valueSearchName, int i) {
        if (i == 1){
            return orderDetailRepository.getAllHistorySortProduct(pageable , "%" + valueSearchName +"%");
        }else if (i == 2){
            return orderDetailRepository.getAllHistorySortQuantity(pageable , "%" + valueSearchName +"%");
        }
        return orderDetailRepository.getAllHistory(pageable , "%" + valueSearchName +"%");
    }

}
