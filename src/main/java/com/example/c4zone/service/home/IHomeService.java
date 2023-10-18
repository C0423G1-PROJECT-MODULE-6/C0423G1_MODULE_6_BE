package com.example.c4zone.service.home;

import com.example.c4zone.dto.product.IProductDto;
import com.example.c4zone.model.product.Product;

import java.util.List;

public interface IHomeService {
    List<IProductDto> getProductsByNameSortByPriceDESC(String name,String sortName);

    List<IProductDto> getProductsByNameSortByPriceASC(String name,String sortName);
    IProductDto getProductById(Long id);
    List<Product> getBestsellers();
    String getAvatarByProductId(Long product_id);
    List <String> getColorsOfAProductByName(String name);
    List<String> getImageLinksByProductId(Long id);
    List<String> getCapacitiesByName(String name);
    IProductDto getProductByNameAndCapacityAndColor(String name, String capacity,String color);
    List<String> getSeriesByProductType(String type);
}
