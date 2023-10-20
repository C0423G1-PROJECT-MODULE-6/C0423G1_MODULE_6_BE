package com.example.c4zone.service.product;

import com.example.c4zone.model.product.Series;
import com.example.c4zone.repository.product.ISeriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeriesService implements ISeriesService{
    @Autowired
    private ISeriesRepository seriesRepository;
    /**
     * author: DaoPTA
     * workday: 12/10/2023
     *
     * @return find all list series
     */
    @Override
    public List<Series> findAll() {
        return seriesRepository.findAll();
    }

    @Override
    public Series findByIdSeries(Long idSeries) {
        return seriesRepository.findSeriesById(idSeries);
    }
}
