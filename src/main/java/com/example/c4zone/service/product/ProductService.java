package com.example.c4zone.service.product;

import com.example.c4zone.dto.order.IProductDtoOrder;
import com.example.c4zone.repository.product.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository productRepository;

    @Override
    public IProductDtoOrder findProductById(Long id) {
        return productRepository.findProductById(id);
    }
}
