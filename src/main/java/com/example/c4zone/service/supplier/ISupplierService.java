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

    /**
     * author: NghiaNPX
     * date: 12/10/2023
     * goal: edit object
     *
     * @param supplier is object existing in DB
     */
    void editSupplier(Supplier supplier);

    /**
     * author: NghiaNPX
     * date: 12/10/2023
     * goal: save new object
     *
     * @param newSupplier is new object being created
     */
    void saveSupplier(Supplier newSupplier);

    /**
     * author: NghiaNPX
     * date: 13/10/2023
     * goal: find supplier by name_supplier
     *
     * @param nameSupplier is passing value
     * @return an object with existing name_supplier in database
     */
    Supplier findSupplierByName(String nameSupplier);

    /**
     * author: NghiaNPX
     * date: 13/10/2023
     * goal: find supplier by phone_number_supplier
     *
     * @param phoneNumberSupplier is passing value
     * @return an object with existing name_supplier in database
     */
    Supplier findSupplierByPhoneNumber(String phoneNumberSupplier);

    /**
     * author: NghiaNPX
     * date: 13/10/2023
     * goal: find supplier by email_supplier
     *
     * @param emailSupplier is passing value
     * @return an object with existing name_supplier in database
     */
    Supplier findSupplierByEmail(String emailSupplier);

    /**
     * author: NghiaNPX
     * date: 13/10/2023
     * * goal: find supplier by id_supplier
     *
     * @param id passing value
     * @return a supplier
     */
    Supplier findById(Long id);
}
