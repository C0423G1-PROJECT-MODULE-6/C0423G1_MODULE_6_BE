package com.example.c4zone.service.product;

<<<<<<< HEAD
import com.example.c4zone.dto.order.IProductDtoOrder;
=======
import com.example.c4zone.model.product.Product;
>>>>>>> 63942a3a1008093c285f9019baf18abe1c55a8b4
import com.example.c4zone.repository.product.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
<<<<<<< HEAD
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository productRepository;

    @Override
    public IProductDtoOrder findProductById(Long id) {
        return productRepository.findProductById(id);
=======
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
>>>>>>> 63942a3a1008093c285f9019baf18abe1c55a8b4
    }
}
