package com.example.c4zone.service.product;

<<<<<<< HEAD
import com.example.c4zone.dto.order.IProductDtoOrder;

public interface IProductService {
    IProductDtoOrder findProductById(Long id);
=======
import com.example.c4zone.model.product.Product;

public interface IProductService {
    Product findProductById(Long idProduct);
    void updateProduct(Product product);
    void createProduct(Product product);
    Long getLastInsertedId();
>>>>>>> 63942a3a1008093c285f9019baf18abe1c55a8b4
}
