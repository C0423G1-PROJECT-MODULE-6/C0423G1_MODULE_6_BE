package com.example.c4zone.dto.customer;

public interface IShoppingHistoryDto {
    String getDateOfOrder();

    String getNameProduct();

    Double getPriceOrder();
    Integer getQuantityOrder();
    String getTimeOfOrder();
}
