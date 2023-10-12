package com.example.c4zone.service.wareHouse;

import com.example.c4zone.model.wareHouse.IWarehouseProjection;
import com.example.c4zone.model.wareHouse.WareHouse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IWareHouseService {
    Page<IWarehouseProjection> findAll(Pageable pageable);
    void ImportProduct(WareHouse wareHouse);
}
