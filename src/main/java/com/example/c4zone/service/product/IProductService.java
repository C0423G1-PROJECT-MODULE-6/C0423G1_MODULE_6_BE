package com.example.c4zone.service.product;




import com.example.c4zone.dto.order.IProductDtoOrder;
import com.example.c4zone.model.product.Product;

public interface IProductService {
    Product findProductById(Long idProduct);
    void updateProduct(Product product);
    void createProduct(Product product);
    Long getLastInsertedId();
    IProductDtoOrder findProductByIdOrder(Long id);

}
