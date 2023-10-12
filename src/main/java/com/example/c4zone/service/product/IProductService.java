package com.example.c4zone.service.product;

import com.example.c4zone.dto.order.IProductDtoOrder;

public interface IProductService {
    IProductDtoOrder findProductById(Long id);
}
