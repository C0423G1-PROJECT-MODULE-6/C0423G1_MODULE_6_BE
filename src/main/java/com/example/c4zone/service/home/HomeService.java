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
    public List<Product> getProductsByName(String name) {
        return homeRepository.getProductsByName(name) ;
    }
}
