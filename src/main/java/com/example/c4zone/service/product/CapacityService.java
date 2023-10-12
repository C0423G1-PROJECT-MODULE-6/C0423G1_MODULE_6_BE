package com.example.c4zone.service.product;

import com.example.c4zone.model.product.Capacity;
import com.example.c4zone.repository.product.ICapacityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CapacityService implements ICapacityService{
    @Autowired
    private ICapacityRepository capacityRepository;

    /**
     * author: DaoPTA
     * workday: 12/10/2023
     *
     * @return find all list capacity
     */
    @Override
    public List<Capacity> findAll() {
        return capacityRepository.findAll();
    }
}
