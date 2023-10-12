package com.example.c4zone.controller.wareHouse;

import com.example.c4zone.dto.customer.CustomerDto;
import com.example.c4zone.dto.product.IProductDto;
import com.example.c4zone.dto.product.ProductDto;
import com.example.c4zone.dto.warehouse.IProductDtoWarehouse;
import com.example.c4zone.dto.warehouse.ISupplierDtoWarehouse;
import com.example.c4zone.dto.warehouse.WarehouseDto;
import com.example.c4zone.model.customer.Customer;
import com.example.c4zone.model.product.Image;
import com.example.c4zone.model.product.Product;
import com.example.c4zone.model.wareHouse.IWarehouseProjection;
import com.example.c4zone.model.wareHouse.WareHouse;
import com.example.c4zone.service.product.IProductService;
import com.example.c4zone.service.supplier.ISupplierService;
import com.example.c4zone.service.wareHouse.IWareHouseService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

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
    /**
     * Author: PhapTM
     * Goal: getList WArehouse
     * * return List warehouse
     */

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
    public ResponseEntity<IProductDto> chooseProduct(@PathVariable Long id) {

//        IProductDtoWarehouse productDtoWarehouse = productService.findProductByIdWarehouse(id);
        IProductDto productDto = productService.findProductByIdWarehouse(id);
        return new ResponseEntity<>(productDto, HttpStatus.OK);
    }

    @GetMapping("/supplier/{id}")
    public ResponseEntity<ISupplierDtoWarehouse> getSupplier(@PathVariable Long id) {
        ISupplierDtoWarehouse supplierDtoWarehouse = supplierService.findSupplierByIdWarehouse(id);
        return new ResponseEntity<>(supplierDtoWarehouse, HttpStatus.OK);
    }
    /**
     * Author: PhapTM
     * Goal: importProduct
     * * return HttpStatus
     */

    @PostMapping("/create")
    public ResponseEntity<?> importProduct(@Valid @RequestBody WarehouseDto warehouseDto, BindingResult bindingResult) {
        WareHouse wareHouse = new WareHouse();
        Map<String, String> errors = new HashMap<>();
        new WarehouseDto().validate(warehouseDto, bindingResult);
        if (bindingResult.hasErrors()) {
            for (FieldError err : bindingResult.getFieldErrors()) {
                errors.put(err.getField(), err.getDefaultMessage());
            }
            return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
        }
        BeanUtils.copyProperties(warehouseDto, wareHouse);
        wareHouseService.ImportProduct(wareHouse);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
