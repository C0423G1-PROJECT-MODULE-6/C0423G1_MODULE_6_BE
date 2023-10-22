package com.example.c4zone.dto.order;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderPaymentDto{
    private Long idCustomerOrder;
    private Integer paymentMethod;
    private Long idUser;
}
