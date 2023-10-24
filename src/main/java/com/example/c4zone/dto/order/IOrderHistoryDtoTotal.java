package com.example.c4zone.dto.order;



public interface IOrderHistoryDtoTotal {
    Long getIdOrderBill();
    String getDateOfOrder();
    String getTimeOfOrder();
    String getNameCustomer();
    Integer getTotalQuantity();
    Double getTotalMoney();
    String getInfoBuy();
}
