package com.example.c4zone.dto.order;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OrderHistoryDtoTotal {
   private Long idOrderBill;
   private String dateOfOrder;
   private String timeOfOrder;
   private String nameCustomer;
   private String nameProduct;
   private Double totalMoney;
   private Long idCustomer;

}
