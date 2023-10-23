package com.example.c4zone.dto.order;

import com.example.c4zone.model.customer.Customer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ObjectResponseScanDto {
    private ICustomerDtoOrder customer;
    private List<ICartDto> cartDto;
}
