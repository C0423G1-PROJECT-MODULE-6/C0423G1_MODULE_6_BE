package com.example.c4zone.repository.product;

import com.example.c4zone.model.product.Cpu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ICpuRepository extends JpaRepository<Cpu, Long> {
    /**
     * author: DaoPTA
     * workday: 12/10/2023
     *
     * @return list CPU
     */
    @Query(value = "SELECT cpu.id_cpu, cpu.name, cpu.status_cpu FROM c4_zone.cpu as cpu", nativeQuery = true)
    List<Cpu> findAll();

    @Query(value = "SELECT cp.id_cpu, cp.name FROM c4_zone.cpu as cp " +
            "WHERE id_cpu = :idCpu and status_cpu = true", nativeQuery = true)
    Cpu findCpuById(@Param("idCpu") Long idCpu);
}
