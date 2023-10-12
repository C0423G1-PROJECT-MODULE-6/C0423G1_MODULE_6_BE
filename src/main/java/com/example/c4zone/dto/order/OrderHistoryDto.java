package com.example.c4zone.dto.order;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OrderHistoryDto {
   private String nameProduct;
   private Integer quantityOrder;
}
