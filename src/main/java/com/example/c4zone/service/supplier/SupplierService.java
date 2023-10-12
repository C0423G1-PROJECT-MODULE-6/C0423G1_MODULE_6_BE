package com.example.c4zone.service.supplier;

import com.example.c4zone.model.supplier.Supplier;
import com.example.c4zone.repository.supplier.ISupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SupplierService implements ISupplierService {
    @Autowired
    private ISupplierRepository supplierRepository;
    @Override
    public Page<Supplier> getAll(String searchName, String addressSearch, String emailSearch, Pageable pageable) {
        return supplierRepository.getAllSupplier(searchName,addressSearch,emailSearch,pageable);
    }

    @Override
    public void deleteSupplier(Long id) {
        supplierRepository.deleteSupplier(id);
    }

    @Override
    public Page<Supplier> getAllNoCondition(Pageable pageable) {
        return supplierRepository.getAllSupplierNoCondition(pageable);
    }

    @Override
    public Supplier findByIdSupplier(Long id) {
        return supplierRepository.findSupplierById(id);
    }
}
