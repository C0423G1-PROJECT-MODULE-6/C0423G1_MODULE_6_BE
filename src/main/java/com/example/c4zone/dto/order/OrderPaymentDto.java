package com.example.c4zone.dto.order;

import com.example.c4zone.model.product.Product;

import java.util.List;

public class OrderPaymentDto {
    private Long idOrderPaymentDto;
    private Long idCustomerOrder;
    private List<ProductDtoOrder> productDtoOrders;
    private String paymentMethod;
    private Integer printStatus;
}
