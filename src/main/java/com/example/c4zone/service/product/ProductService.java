package com.example.c4zone.service.product;


import com.example.c4zone.dto.order.IProductDtoOrder;
import com.example.c4zone.dto.product.IProductDto;
import com.example.c4zone.model.product.Product;
import com.example.c4zone.repository.product.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @Override
    public IProductDtoOrder findProductByIdOrder(Long id) {
        return productRepository.findProductByIdOrder(id);
    }

    @Override
    public Page<IProductDto> getAllByName(Pageable pageable, String name) {
        return productRepository.getAllByName(pageable, '%'+name+'%');
    }

    @Override
    public Page<IProductDto> getAllByPrice(Pageable pageable, String price) {
        switch (price) {
            case "smaller 5m":
                return productRepository.getAllByPriceMax(pageable, 5000000.0);
            case "5m to 10m":
                return productRepository.getAllByPrice(pageable, 5000000.0, 10000000.0);
            case "better 10m":
                return productRepository.getAllByPriceMin(pageable, 10000000.0);
        }
        return null;
    }

    @Override
    public Page<IProductDto> getAllByType(Pageable pageable, String idType) {
        return productRepository.getAllByType(pageable, Long.parseLong(idType));
    }

    @Override
    public Page<IProductDto> getAllByQuantity(Pageable pageable, String value) {
        switch (value) {
            case "smaller 10":
                return productRepository.getAllByQuantityMax(pageable, 10);
            case "10 to 50":
                return productRepository.getAllByQuantity(pageable, 10,50);
            case "better 50":
                return productRepository.getAllByQuantityMin(pageable, 50);
        }
        return null;
    }

    @Override
    public void removeProduct(Long id) {
        productRepository.removeProduct(id);
    }

}
