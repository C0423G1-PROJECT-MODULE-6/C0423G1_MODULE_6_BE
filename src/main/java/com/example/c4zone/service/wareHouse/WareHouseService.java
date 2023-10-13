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

    /**
     * Method: findAll
     * Author: PhapTM
     * Create: 12-10-2023
     * @param pageable control page: size and number
     * @return page Warehouse
     */
    @Override
    public Page<IWarehouseProjection> findAllByName(Pageable pageable, String name) {
        return wareHouseRepository.findAllWareHouseByName(pageable, '%'+name+'%');
    }

    /**
     * method findAll by Price
     * author PhapTM
     * create 12-10-2023
     * @param pageable return page
     * @param price search by filter
     * @return
     */
    @Override
    public Page<IWarehouseProjection> findAllByPrice(Pageable pageable, String price) {
        switch (price) {
            case "smaller 5m":
                return wareHouseRepository.findAllWareHouseByPriceMax(pageable, 5000000.0);
            case "5m to 10m":
                return wareHouseRepository.findAllWareHouseByPrice(pageable, 5000000.0, 10000000.0);
            case "better 10m":
                return wareHouseRepository.findAllWareHouseByPriceMin(pageable, 10000000.0);
        }
        return null;
    }

    /**
     * method findAll by supplier
     * author PhapTM
     * create 12-10-2023
     * @param pageable page
     * @param supplier search by name supplier
     * @return
     */

    @Override
    public Page<IWarehouseProjection> findAllBySupplier(Pageable pageable, String supplier) {
        return wareHouseRepository.findAllWareHouseBySupplier(pageable, supplier);
    }

    /**
     * Method: import product
     * Author: PhapTM
     * Create: 12-10-2023
     * @param wareHouse use add object
     */
    @Override
    public void importProduct(WareHouse wareHouse) {
        wareHouseRepository.ImportProduct(wareHouse);
    }
}
