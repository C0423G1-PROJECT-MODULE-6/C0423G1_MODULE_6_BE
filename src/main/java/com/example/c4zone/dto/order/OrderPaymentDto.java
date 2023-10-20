package com.example.c4zone.dto.order;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotNull;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderPaymentDto{
    private Long idCustomerOrder;
    private Integer paymentMethod;
    private Long idUser;


}
