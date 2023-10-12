package com.example.c4zone.controller.wareHouse;

import com.example.c4zone.dto.product.IProductDto;
import com.example.c4zone.dto.warehouse.ISupplierDtoWarehouse;
import com.example.c4zone.dto.warehouse.WarehouseDto;
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
     * Method: findAll
     * Author: PhapTM
     * Create: 12-10-2023
     * @param page control page: size and number
     * @return page Warehouse
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

    /**
     * Method: chooseProduct
     * Author: PhapTM
     * Create: 12-10-2023
     * @param id find id by product
     * @return object of product
     */
    @GetMapping("/product/{id}")
    public ResponseEntity<IProductDto> chooseProduct(@PathVariable Long id) {
        IProductDto productDto = productService.findProductByIdWarehouse(id);
        return new ResponseEntity<>(productDto, HttpStatus.OK);
    }

    /**
     * Method: chooseProduct
     * Author: PhapTM
     * Create: 12-10-2023
     * @param id find by id by supplier
     * @return object of supplier
     */
    @GetMapping("/supplier/{id}")
    public ResponseEntity<ISupplierDtoWarehouse> getSupplier(@PathVariable Long id) {
        ISupplierDtoWarehouse supplierDtoWarehouse = supplierService.findSupplierByIdWarehouse(id);
        return new ResponseEntity<>(supplierDtoWarehouse, HttpStatus.OK);
    }

    /**
     * Method: chooseProduct
     * Author: PhapTM
     * Create: 12-10-2023
     * @param warehouseDto create object by warehouseDto
     * @param bindingResult returns error results
     * @return if true, return of HttpStatus.OK
     *         else, return of HttpStatus.BAD_REQUEST
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
