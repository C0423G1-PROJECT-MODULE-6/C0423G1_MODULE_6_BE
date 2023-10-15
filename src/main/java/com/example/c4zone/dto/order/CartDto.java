package com.example.c4zone.dto.order;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CartDto {
    private Integer quantityProduct;
    private Double priceOrder;
    private Long idOrder;
    private Long idProduct;
}
