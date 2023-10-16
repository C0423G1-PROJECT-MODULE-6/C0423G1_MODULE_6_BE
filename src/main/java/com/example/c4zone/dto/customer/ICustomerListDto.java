package com.example.c4zone.dto.customer;

public interface ICustomerListDto {
    Long getIdCustomer();
    String getNameCustomer();
    Boolean getGenderCustomer();
    String getEmailCustomer();
    String getDateOfBirthCustomer();
    String getPhoneNumberCustomer();
    String getAddressCustomer();
    Integer getTotalPurchases();
}
