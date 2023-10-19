package com.example.c4zone.service.product;
import com.example.c4zone.dto.order.IProductDtoOrder;
import com.example.c4zone.dto.product.IProductDto;
import com.example.c4zone.model.product.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService {
    Product findProductById(Long idProduct);
    IProductDto findById(Long id);
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
    /**
     * author :QuanND
     * work day : 12/10/2023
     * @param pageable page control
     * @param name name of search
     * @return page had control
     */
    Page<IProductDto> getAllByName(Pageable pageable,String name);
    /**
     * author :QuanND
     * work day : 12/10/2023
     * @param pageable control page return
     * @param price : price of product
     * @return page had control
     */
    Page<IProductDto> getAllByPrice(Pageable pageable,String price);
    /**
     * author :QuanND
     * work day : 12/10/2023
     * @param pageable : control page return
     * @param idType : id type's of product
     * @return page had control
     */
    Page<IProductDto> getAllByType(Pageable pageable,String idType);
    /**
     * author :QuanND
     * work day : 12/10/2023
     * @param pageable control page return
     * @param value : value of choose quantity
     * @return page had control
     */
    Page<IProductDto> getAllByQuantity(Pageable pageable, String value);
    /**
     * author :QuanND
     * work day : 12/10/2023
     * @param id id of product remove
     */
    void removeProduct(Long id);


    Integer getQuantityById(Long idProduct);

}
