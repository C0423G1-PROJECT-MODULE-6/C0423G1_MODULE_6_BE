package com.example.c4zone.service.home;

import com.example.c4zone.model.product.Product;

import java.util.List;

public interface IHomeService {
    List<Product> getProductsByName(String name);
}
