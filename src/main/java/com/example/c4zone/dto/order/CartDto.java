package com.example.c4zone.dto.order;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CartDto {
    private Long idCartDto;
    private String nameProduct;
    private Double priceProduct;
    private Integer quantityProduct;
}
