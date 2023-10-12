package com.example.c4zone.service.home;

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
    public List<Product> getProductsByName(String name,String sortName,String sortType) {
        return homeRepository.getProductsByName(name,sortName ,sortType) ;
    }

    @Override
    public Product getProductById(Long id) {
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
    public List<String> getImageLinksById(Long id) {
        return homeRepository.getImageLinksById(id);
    }

    @Override
    public List<String> getCapacitiesByName(String name) {
        return homeRepository.getCapacitiesByName(name);
    }
}
