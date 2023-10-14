package com.example.c4zone.service.home;

import com.example.c4zone.dto.product.IProductDto;
import com.example.c4zone.model.product.Product;
import com.example.c4zone.repository.home.IHomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeService implements IHomeService {

    @Autowired
    private IHomeRepository homeRepository;

    @Override
    public List<IProductDto> getProductsByNameSortByPriceDESC(String name, String sortName) {
        return homeRepository.getProductsByNameSortByPriceDESC(name, sortName);
    }

    @Override
    public List<IProductDto> getProductsByNameSortByPriceASC(String name, String sortName) {
        return homeRepository.getProductsByNameSortByPriceASC(name, sortName);
    }

    @Override
    public IProductDto getProductById(Long id) {
        return homeRepository.getProductById(id);
    }

    @Override
    public List<Product> getBestsellers() {
        return homeRepository.getBestsellers();
    }

    @Override
    public String getAvatarByProductId(Long product_id) {
        return homeRepository.getAvatarByProductId(product_id);
    }

    @Override
    public List<String> getColorsOfAProductByName(String name) {
        return homeRepository.getColorsOfAProductByName(name);
    }

    @Override
    public List<String> getImageLinksByProductId(Long id) {
        return homeRepository.getImageLinksByProductId(id);
    }

    @Override
    public List<String> getCapacitiesByName(String name) {
        return homeRepository.getCapacitiesOfProductByName(name);
    }

    @Override
    public IProductDto getProductByNameAndCapacityAndColor(String name, String capacity,String color) {
        return homeRepository.getProductByNameAndCapacityAndColor(name, capacity,color);
    }
}
