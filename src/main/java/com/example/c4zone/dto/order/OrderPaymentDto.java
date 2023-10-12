package com.example.c4zone.dto.order;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor
public class OrderPaymentDto {
    private Long idOrderPaymentDto;
    private Long idCustomerOrder;
    private String paymentMethod;
    private Integer printStatus;
    private Long idUser;
}
