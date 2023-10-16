package com.example.c4zone.service.supplier;

import com.example.c4zone.dto.warehouse.ISupplierDtoWarehouse;
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
        return supplierRepository.getAllSupplier(searchName, addressSearch, emailSearch, pageable);
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

    @Override
    public ISupplierDtoWarehouse findSupplierByIdWarehouse(Long id) {
        return supplierRepository.findSupplierByIdWarehouse(id);
    }

    /**
     * author: NghiaNPX
     * date: 12/10/2023
     * goal: edit an object
     *
     * @param supplier is object existing in DB
     */
    @Override
    public void editSupplier(Supplier supplier) {
        supplierRepository.updateSupplier(supplier.getIdSupplier(),
                supplier.getCodeSupplier(),
                supplier.getNameSupplier(),
                supplier.getAddressSupplier(),
                supplier.getPhoneNumberSupplier(),
                supplier.getEmailSupplier());
    }

    /**
     * author: NghiaNPX
     * date: 12/10/2023
     * goal: save new object
     *
     * @param newSupplier is new object being created
     */
    @Override
    public void saveSupplier(Supplier newSupplier) {
        supplierRepository.saveSupplier(newSupplier);
    }

    /**
     * author: NghiaNPX
     * date: 13/10/2023
     * goal: find supplier by codeSupplier
     *
     * @param codeSupplier is passing value
     * @return object from SQL statement
     */
    @Override
    public Supplier findSupplierByCode(Integer codeSupplier) {
        return supplierRepository.findByCode("%" + codeSupplier + "%");
    }

    /**
     * author: NghiaNPX
     * date: 13/10/2023
     * goal: find supplier by nameSupplier
     *
     * @param nameSupplier is passing value
     * @return object from SQL statement
     */
    @Override
    public Supplier findSupplierByName(String nameSupplier) {
        return supplierRepository.findByName("%" + nameSupplier + "%");
    }

    /**
     * author: NghiaNPX
     * date: 13/10/2023
     * goal: find supplier by phoneNumberSupplier
     *
     * @param phoneNumberSupplier is passing value
     * @return object from SQL statement
     */
    @Override
    public Supplier findSupplierByPhoneNumber(String phoneNumberSupplier) {
        return supplierRepository.findByPhoneNumber("%" + phoneNumberSupplier + "%");
    }

    /**
     * author: NghiaNPX
     * date: 13/10/2023
     * goal: find supplier by emailSupplier
     *
     * @param emailSupplier is passing value
     * @return object from SQL statement
     */
    @Override
    public Supplier findSupplierByEmail(String emailSupplier) {
        return supplierRepository.findByEmail("%" + emailSupplier + "%");
    }
}
