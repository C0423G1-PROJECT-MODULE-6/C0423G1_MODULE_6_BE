package com.example.c4zone.repository.product;

import com.example.c4zone.model.product.Cpu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ICpuRepository extends JpaRepository<Cpu, Long> {
    @Query(value = "SELECT cpu.id_cpu, cpu.name, cpu.status_cpu FROM c4_zone.cpu as cpu", nativeQuery = true)
    List<Cpu> findAll();
}
