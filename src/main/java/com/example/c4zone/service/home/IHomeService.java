package com.example.c4zone.service.home;

import com.example.c4zone.dto.product.ColorDto;
import com.example.c4zone.dto.product.IColorDto;
import com.example.c4zone.dto.product.IProductDto;
import com.example.c4zone.model.product.Product;

import java.util.List;

public interface IHomeService {
    List<IProductDto> getProductsByNameSortByPriceDESC(String name,String sortName);
    List<IProductDto> getProductsByNameSortByPriceASC(String name,String sortName);
    IProductDto getProductById(Long id);
    List<Product> getBestsellers();
    List <IColorDto> getColorsOfAProductByNameAndCapacity(String name,String capacity);
    List<String> getImageLinksByProductId(Long id);
    List<String> getCapacitiesOfProductByNameAndColor(String name,String color);
    IProductDto getProductByNameAndCapacityAndColor(String name, String capacity,String color);
    List<String> getSeriesByProductType(String type);
}
