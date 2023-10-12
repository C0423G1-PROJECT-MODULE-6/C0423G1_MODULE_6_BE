package com.example.c4zone.service.product;

import com.example.c4zone.model.product.Color;
import com.example.c4zone.repository.product.IColorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColorService implements IColorService{
    @Autowired
    private IColorRepository colorRepository;
    /**
     * author: DaoPTA
     * workday: 12/10/2023
     *
     * @return find all list color
     */
    @Override
    public List<Color> findAll() {
        return colorRepository.findAll();
    }
}
