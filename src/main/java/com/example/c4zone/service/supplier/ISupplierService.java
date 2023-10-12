package com.example.c4zone.service.supplier;

import com.example.c4zone.model.supplier.Supplier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ISupplierService {
    Page<Supplier> getAll(String searchName, String addressSearch, String emailSearch, Pageable pageable);
    void deleteSupplier(Long id);
    Page<Supplier> getAllNoCondition(Pageable pageable);
    Supplier findByIdSupplier(Long id);
}
