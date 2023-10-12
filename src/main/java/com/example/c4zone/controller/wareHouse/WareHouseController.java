package com.example.c4zone.controller.wareHouse;

import com.example.c4zone.model.wareHouse.IWarehouseProjection;
import com.example.c4zone.model.wareHouse.WareHouse;
import com.example.c4zone.service.wareHouse.IWareHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("api/admin/warehouse/list")
public class WareHouseController {
    @Autowired
    private IWareHouseService wareHouseService;

    @GetMapping("")
    public ResponseEntity<Page<IWarehouseProjection>> findAll(@RequestParam(defaultValue = "0") int page) {
        Pageable pageable = PageRequest.of(page, 2);
        Page<IWarehouseProjection> wareHousePage = wareHouseService.findAll(pageable);
        if (wareHousePage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(wareHousePage, HttpStatus.OK);
        }
    }
}
