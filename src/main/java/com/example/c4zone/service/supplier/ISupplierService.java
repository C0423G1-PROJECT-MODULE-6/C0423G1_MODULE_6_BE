package com.example.c4zone.service.supplier;

import com.example.c4zone.dto.warehouse.ISupplierDtoWarehouse;
import com.example.c4zone.model.supplier.Supplier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ISupplierService {
    Page<Supplier> getAll(String searchName, String addressSearch, String emailSearch, Pageable pageable);
    void deleteSupplier(Long id);
    Page<Supplier> getAllNoCondition(Pageable pageable);
    Supplier findByIdSupplier(Long id);
    ISupplierDtoWarehouse findSupplierByIdWarehouse(Long id);
    void editSupplier(Supplier supplier);
    void saveSupplier(Supplier newSupplier);
}
