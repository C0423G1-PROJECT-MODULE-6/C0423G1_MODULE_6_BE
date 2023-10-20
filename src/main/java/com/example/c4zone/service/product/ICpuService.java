package com.example.c4zone.service.product;

import com.example.c4zone.model.product.Cpu;

import java.util.List;

public interface ICpuService {
    List<Cpu> findAll();
    Cpu findByIdCpu (Long idCpu);
}
