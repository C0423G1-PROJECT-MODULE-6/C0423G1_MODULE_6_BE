package com.example.c4zone.service.product;

import com.example.c4zone.model.product.Product;
import com.example.c4zone.repository.product.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService{
    @Autowired
    private IProductRepository productRepository;

    /**
     * author: DaoPTA
     * workday: 12/10/2023
     *
     * @param idProduct find by idProduct
     * @return the object after find by idProduct
     */
    @Override
    public Product findProductById(Long idProduct) {
        return productRepository.findProductById(idProduct);
    }

    /**
     * author: DaoPTA
     * workday: 12/10/2023
     *
     * @param product update object product
     */
    @Override
    public void updateProduct(Product product) {
        productRepository.updateProduct(product);
    }

    /**
     * author: DaoPTA
     * workday: 12/10/2023
     *
     * @param product create object product
     */
    @Override
    public void createProduct(Product product) {
        productRepository.createProduct(product);
    }

    /**
     * author: DaoPTA
     * workday: 12/10/2023
     *
     * @return last insert id after create
     */
    @Override
    public Long getLastInsertedId() {
        return productRepository.getLastInsertedId();
    }
}
