package com.example.c4zone.model.wareHouse;

public interface IWarehouseProjection {
     Long getIdWarehouse();
     String getInputDate();
     String getNameProduct();
     String getNameSupplier();
     Integer getQuantity();
     Double getPriceProduct();
     Double getTotalPrice();
     String getColor();
     String getCapacity();
}
