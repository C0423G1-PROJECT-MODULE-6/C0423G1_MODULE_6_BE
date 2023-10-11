package com.example.c4zone.service.product;

import com.example.c4zone.model.product.Product;
import com.example.c4zone.repository.product.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService{
    @Autowired
    private IProductRepository productRepository;
    @Override
    public Product findProductById(Long idProduct) {
        return productRepository.findProductById(idProduct);
    }

    @Override
    public void updateProduct(Product product) {
        productRepository.updateProduct(product);
    }

    @Override
    public void createProduct(Product product) {
        productRepository.createProduct(product);
    }

    @Override
    public Long getLastInsertedId() {
        return productRepository.getLastInsertedId();
    }
}
