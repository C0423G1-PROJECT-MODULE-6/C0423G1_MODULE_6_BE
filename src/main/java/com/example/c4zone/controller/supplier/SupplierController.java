package com.example.c4zone.controller.supplier;

import com.example.c4zone.dto.supplier.SupplierDto;
import com.example.c4zone.model.supplier.Supplier;
import com.example.c4zone.service.supplier.ISupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/admin/supplier")
@CrossOrigin("*")
public class SupplierController {
    @Autowired
    private ISupplierService supplierService;

    @GetMapping("")
    public ResponseEntity<Page<Supplier>> getAllSupplier(
            @RequestParam("_page") int page,
            @RequestParam("_limit") int size,
            @RequestParam("name_like") String nameSearch,
            @RequestParam("addressSearch") String addressSearch,
            @RequestParam("emailSearch") String emailSearch
    ){
        Pageable pageable = PageRequest.of(page,size);
        Page<Supplier> listSupplier;
        if (nameSearch != null && !nameSearch.isEmpty()){
            listSupplier = supplierService.getAll(nameSearch,addressSearch,emailSearch,pageable);
        } else {
            listSupplier = supplierService.getAllNoCondition(pageable);
        }
        return new ResponseEntity<>(listSupplier, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSupplier(@PathVariable Long id){
        if (supplierService.findByIdSupplier(id)==null){
            return ResponseEntity.notFound().build();
        }
        supplierService.deleteSupplier(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Supplier> editSupplier(@PathVariable Long id, @RequestBody Supplier supplier) {
        if (supplierService.findByIdSupplier(id) == null) {
            return ResponseEntity.notFound().build();
        } else {
            supplierService.editSupplier(supplier);
            return ResponseEntity.ok(supplier);
        }
    }

    @PostMapping("")
    public ResponseEntity<Supplier> createSupplier(@RequestBody @Valid SupplierDto supplierDto){
        Supplier newSupplier = new Supplier();
        // Copy dl tu SupplierDto sang Supplier
        newSupplier.setCodeSupplier(supplierDto.getCodeSupplier());
        newSupplier.setNameSupplier(supplierDto.getNameSupplier());
        newSupplier.setAddressSupplier(supplierDto.getAddressSupplier());
        newSupplier.setPhoneNumberSupplier(supplierDto.getPhoneNumberSupplier());
        newSupplier.setEmailSupplier(supplierDto.getEmailSupplier());

        supplierService.saveSupplier(newSupplier);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
