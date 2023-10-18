package com.example.c4zone.service.product;

import com.example.c4zone.model.product.Series;

import java.util.List;

public interface ISeriesService {
    List<Series> findAll();
    Series findByIdSeries(Long idSeries);
}
