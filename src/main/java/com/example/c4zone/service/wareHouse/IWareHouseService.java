package com.example.c4zone.service.wareHouse;

import com.example.c4zone.model.wareHouse.IWarehouseProjection;
import com.example.c4zone.model.wareHouse.WareHouse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IWareHouseService {
    Page<IWarehouseProjection> findAllByName(Pageable pageable, String name);
    Page<IWarehouseProjection> findAllByPrice(Pageable pageable, String price);
    Page<IWarehouseProjection> findAllBySupplier(Pageable pageable, String supplier);
    void importProduct(WareHouse wareHouse);

}
