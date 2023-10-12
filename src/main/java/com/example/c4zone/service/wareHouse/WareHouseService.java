package com.example.c4zone.service.wareHouse;

import com.example.c4zone.model.wareHouse.IWarehouseProjection;
import com.example.c4zone.model.wareHouse.WareHouse;
import com.example.c4zone.repository.wareHouse.IWareHouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class WareHouseService implements IWareHouseService{
    @Autowired
    private IWareHouseRepository wareHouseRepository;
    @Override
    public Page<IWarehouseProjection> findAll(Pageable pageable) {
        return wareHouseRepository.findAllWareHouse(pageable);
    }

    @Override
    public void ImportProduct(WareHouse wareHouse) {
        wareHouseRepository.ImportProduct(wareHouse);
    }
}
