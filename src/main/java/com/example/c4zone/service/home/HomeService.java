package com.example.c4zone.service.home;

import com.example.c4zone.dto.product.ColorDto;
import com.example.c4zone.dto.product.IColorDto;
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
    public List<IColorDto> getColorsOfAProductByNameAndCapacity(String name,String capacity) {
        return homeRepository.getColorsOfAProductByNameAndCapacity(name,capacity);
    }

    @Override
    public List<String> getImageLinksByProductId(Long id) {
        return homeRepository.getImageLinksByProductId(id);
    }

    @Override
    public List<String> getCapacitiesOfProductByNameAndColor(String name,String color) {
        return homeRepository.getCapacitiesOfProductByNameAndColor(name,color);
    }

    @Override
    public IProductDto getProductByNameAndCapacityAndColor(String name, String capacity,String color) {
        return homeRepository.getProductByNameAndCapacityAndColor(name, capacity,color);
    }

    @Override
    public List<String> getSeriesByProductType(String type) {
        return homeRepository.getSeriesByProductType(type);
    }
}
