package com.example.c4zone.controller.wareHouse;

import com.example.c4zone.dto.product.IProductDto;
import com.example.c4zone.dto.warehouse.IProductDtoWarehouse;
import com.example.c4zone.dto.warehouse.ISupplierDtoWarehouse;
import com.example.c4zone.model.wareHouse.IWarehouseProjection;
import com.example.c4zone.model.wareHouse.WareHouse;
import com.example.c4zone.service.product.IProductService;
import com.example.c4zone.service.supplier.ISupplierService;
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
@RequestMapping("api/admin/warehouse")
public class WareHouseController {
    @Autowired
    private IWareHouseService wareHouseService;
    @Autowired
    private IProductService productService;
    @Autowired
    private ISupplierService supplierService;

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
    @GetMapping("/product/{id}")
    public ResponseEntity<IProductDto> chooseProduct(@PathVariable Long id){

//        IProductDtoWarehouse productDtoWarehouse = productService.findProductByIdWarehouse(id);
        IProductDto productDto = productService.findProductByIdWarehouse(id);
        return new ResponseEntity<>(productDto,HttpStatus.OK);
    }
    @GetMapping("/supplier/{id}")
    public ResponseEntity<ISupplierDtoWarehouse> getSupplier(@PathVariable Long id){
        ISupplierDtoWarehouse supplierDtoWarehouse = supplierService.findSupplierByIdWarehouse(id);
        return new ResponseEntity<>(supplierDtoWarehouse, HttpStatus.OK);
    }
    @PostMapping("")
    public ResponseEntity<WareHouse> importProduct(@RequestBody WareHouse wareHouse){
        wareHouseService.ImportProduct(wareHouse);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
