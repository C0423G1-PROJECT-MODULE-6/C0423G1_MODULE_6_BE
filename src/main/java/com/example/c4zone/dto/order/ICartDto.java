package com.example.c4zone.dto.order;

public interface ICartDto {
    Long getIdCart();
    Long getIdProduct();
    String getNameProduct();
    Double getPriceProduct();
    Integer getQuantityOrder();


}
