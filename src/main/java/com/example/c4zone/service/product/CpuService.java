package com.example.c4zone.service.product;

import com.example.c4zone.model.product.Cpu;
import com.example.c4zone.repository.product.ICpuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CpuService implements ICpuService{
    @Autowired
    private ICpuRepository cpuRepository;
    @Override
    public List<Cpu> findAll() {
        return cpuRepository.findAll();
    }
}
