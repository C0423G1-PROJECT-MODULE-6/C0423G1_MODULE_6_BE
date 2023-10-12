package com.example.c4zone.dto.order;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductDtoOrder {
    private Long idProductOrder;
    private Long nameProductOrder;
    private Double priceOfProductOrder;
    private Integer quantityOfProductOrder;

}
