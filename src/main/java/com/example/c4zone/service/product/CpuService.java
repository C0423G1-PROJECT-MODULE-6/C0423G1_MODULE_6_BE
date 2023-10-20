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
    /**
     * author: DaoPTA
     * workday: 12/10/2023
     *
     * @return find all list cpu
     */
    @Override
    public List<Cpu> findAll() {
        return cpuRepository.findAll();
    }

    @Override
    public Cpu findByIdCpu(Long idCpu) {
        return cpuRepository.findCpuById(idCpu);
    }
}
