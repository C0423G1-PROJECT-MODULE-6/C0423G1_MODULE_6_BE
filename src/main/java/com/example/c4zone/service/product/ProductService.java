package com.example.c4zone.service.product;


import com.example.c4zone.dto.order.IProductDtoOrder;
import com.example.c4zone.dto.product.IProductDto;
import com.example.c4zone.model.product.Product;
import com.example.c4zone.repository.product.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return productRepository.findByProductId(idProduct);
    }

    /**
     * author:QuanND
     *
     * @param id
     * @return a product with id=:id
     * day: 17/10/2023
     */
    @Override
    public IProductDto findById(Long id) {
        return productRepository.getProductById(id);
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
    /**
     * method findByProduct
     * Create ThoiND
     * Date 12-10-2023
     * param Long id
     * return IProductDtoOrder
     */
    @Override
    public IProductDtoOrder findProductByIdOrder(Long id) {
        return productRepository.findProductByIdOrder(id);
    }

    @Override
    public IProductDto findProductByIdWarehouse(Long id) {
        return productRepository.findProductByIdWarehouse(id);
    }

    @Override
    public List<IProductDto> findProductWarehouse(Long id) {
        return productRepository.findProductWarehouse(id);
    }

    /**
     * author :QuanND
     * work day : 12/10/2023
     * @param pageable page control
     * @param name name of search
     * @return page had control
     */
    @Override
    public Page<IProductDto> getAllByName(Pageable pageable, String name) {
        return productRepository.getAllByName(pageable, '%'+name+'%');
    }

    /**
     * author :QuanND
     * work day : 12/10/2023
     * @param pageable control page return
     * @param price : price of product
     * @return page had control
     */

    @Override
    public Page<IProductDto> getAllByPrice(Pageable pageable, String price) {
        switch (price) {
            case "smaller 5m":
                return productRepository.getAllByPriceMax(pageable, 5000000.0);
            case "5m to 10m":
                return productRepository.getAllByPrice(pageable, 5000000.0, 10000000.0);
            case "better 10m":
                return productRepository.getAllByPriceMin(pageable, 10000000.0);
            default:
                return productRepository.getAllByName(pageable, "%%");
        }
    }

    /**
     * author :QuanND
     * work day : 12/10/2023
     * @param pageable : control page return
     * @param idType : id type's of product
     * @return page had control
     */
    @Override
    public Page<IProductDto> getAllByType(Pageable pageable, String idType) {
        return productRepository.getAllByType(pageable, Long.parseLong(idType));
    }

    /**
     * author :QuanND
     * work day : 12/10/2023
     * @param pageable control page return
     * @param value : value of choose quantity
     * @return page had control
     */
    @Override
    public Page<IProductDto> getAllByQuantity(Pageable pageable, String value) {
        switch (value) {
            case "smaller 10":
                return productRepository.getAllByQuantityMax(pageable, 10);
            case "10 to 50":
                return productRepository.getAllByQuantity(pageable, 10, 50);
            case "better 50":
                return productRepository.getAllByQuantityMin(pageable, 50);
            default:
                return productRepository.getAllByName(pageable, "%%");
        }
    }

    /**
     * author :QuanND
     * work day : 12/10/2023
     * @param id id of product remove
     */
    @Override
    public void removeProduct(Long id) {
        productRepository.removeProduct(id);
    }

    @Override
    public Integer getQuantityById(Long idProduct) {
        return productRepository.getQuantityByid(idProduct);
    }



}
