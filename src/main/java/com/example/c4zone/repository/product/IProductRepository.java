package com.example.c4zone.repository.product;

import com.example.c4zone.dto.order.IProductDtoOrder;
import com.example.c4zone.model.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface IProductRepository extends JpaRepository<Product,Long> {
    @Query(value = "select id_product as idProductOrder, name_product as nameProductOrder, " +
            "price_product as priceProductOrder " +
            "from product " +
            "where id_product = :id",nativeQuery = true)
    IProductDtoOrder findProductById(Long id);
}
