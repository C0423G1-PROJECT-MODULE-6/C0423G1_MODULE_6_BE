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
     * return Double total money
     */
    @Override
    public Double calculateTotalMoney(Long idUser, Long idCustomerOrder) {
        OrderBill orderBill = orderDetailRepository.getOrderBillWithCusAndUser(idCustomerOrder,idUser);
        if (orderBill == null){
            return null;
        }
        List<IOrderDetailDto> orderDetails = orderDetailRepository.getAllOrderDetailByOrderBill(orderBill.getIdOrderBill());
        if (orderDetails.isEmpty()){
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
     * method create order detail
     * Create ThoiND
     * Date 14-10-2023
     * param List cartDto
     * return status 2xx
     */
    @Override
    public void createOrderDetail(List<ICartDto> cartDto, Long idCustomerOrder, Long idUser) {
        OrderBill orderBillByCusAndUser = orderDetailRepository.getOrderBillWithCusAndUser(idCustomerOrder,idUser);
        if (orderBillByCusAndUser != null){
            for (ICartDto cartDto1 : cartDto){
                OrderDetail orderDetail = new OrderDetail();
                Product product = productRepository.findProductByIdProduct(cartDto1.getIdProduct());
                orderDetail.setQuantityOrder(cartDto1.getQuantityOrder());
                orderDetail.setProduct(product);
                orderDetail.setPriceOrder(product.getPriceProduct());
                orderDetail.setOrderBill(orderBillByCusAndUser);
                orderDetailRepository.createOrderDetail(orderDetail);

                Integer quantityOfProduct = productRepository.getQuantityByid(cartDto1.getIdProduct());
                Integer quantityOfProductAfterPayment = quantityOfProduct - orderDetail.getQuantityOrder();
                productRepository.updateQuantityOfProduct(cartDto1.getIdProduct(),quantityOfProductAfterPayment);
            }
            cartRepository.deleteCartByIdCus(idCustomerOrder);
        }
    }
    /**
     * method get all history
     * Create ThoiND
     * Date 14-10-2023
     * param pageable, searchName, i to choose case sort
     * return Page<IOrderHistoryDtoTotal>
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
    /**
     * method find bill of customer not pay
     * Create ThoiND
     * Date 15-10-2023
     * param id customer
     * return OrderBill
     */
    @Override
    public OrderBill isNotPayOfCustomer(Long id) {
        return orderDetailRepository.getOrderBillNotPayOfCus(id);
    }
    /**
     * method delete old bill not pay by customer
     * Create ThoiND
     * Date 15-10-2023
     * param id customer
     * return status 2xx
     */

    @Override
    public void deteleOldBillNotPay(Long id) {
        orderDetailRepository.deleteOldBillNotPay(id);
    }
    /**
     * method update totalmoney ,payment method
     * Create ThoiND
     * Date 15-10-2023
     * param total money, payment method, id customer, id user
     * return status 2xx
     */
    @Override
    public void updateOrderBill(Double totalMoney, Integer printStatus,
                                Long idCustomerOrder, Long idUser) {
        OrderBill orderBill = orderDetailRepository.getOrderBillWithCusAndUser(idCustomerOrder,idUser);
        orderDetailRepository.updateOrderBill(orderBill.getIdOrderBill(),totalMoney, printStatus);
    }
    /**
     * method update print status at final step
     * Create ThoiND
     * Date 15-10-2023
     * param print status, id cus, id user
     * return status 2xx
     */
    @Override
    public void updateOrderBill(Double totalMoney, int printStatus, OrderBill orderBill) {
        orderDetailRepository.updateOrderBill(totalMoney,printStatus, orderBill.getIdOrderBill());
    }
    /**
     * method deleteOrderDetail of bill
     * Create ThoiND
     * Date 15-10-2023
     * param id orderbill
     * return status 2xx
     */
    @Override
    public void deleteOrderDetailOfBill(Long idOrderBill) {
        orderDetailRepository.deleteOrderDetailOfBill(idOrderBill);
    }
    @Override
    public OrderBill findBillNewest(){
       return orderDetailRepository.findOrderBillWithNewest();
    }
}

