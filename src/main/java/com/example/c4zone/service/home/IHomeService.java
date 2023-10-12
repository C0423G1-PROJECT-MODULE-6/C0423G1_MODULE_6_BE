package com.example.c4zone.service.home;

import com.example.c4zone.model.product.Product;

import java.util.List;

public interface IHomeService {
    List<Product> getProductsByName(String name,String sortName,String sortType);
    Product getProductById(Long id);
    List<Product> getBestsellers();
    String getAvatarByProductId(Long product_id);
    List <String> getColorsOfAProductByName(String name);
    List<String> getImageLinksById(Long id);
    List<String> getCapacitiesByName(String name);
}
