package com.example.c4zone.service.product;




import com.example.c4zone.dto.order.IProductDtoOrder;
import com.example.c4zone.dto.product.IProductDto;
import com.example.c4zone.dto.warehouse.IProductDtoWarehouse;
import com.example.c4zone.model.product.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService {
    Product findProductById(Long idProduct);
    void updateProduct(Product product);
    void createProduct(Product product);
    Long getLastInsertedId();
    /**
     * method findByProduct
     * Create ThoiND
     * Date 12-10-2023
     * param Long id
     * return IProductDtoOrder
     */
    IProductDtoOrder findProductByIdOrder(Long id);
    IProductDto findProductByIdWarehouse(Long id);
    Page<IProductDto> getAllByName(Pageable pageable,String name);
    Page<IProductDto> getAllByPrice(Pageable pageable,String price);
    Page<IProductDto> getAllByType(Pageable pageable,String idType);

    Page<IProductDto> getAllByQuantity(Pageable pageable, String value);

    void removeProduct(Long id);
}
