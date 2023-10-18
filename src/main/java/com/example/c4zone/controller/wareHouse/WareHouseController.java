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
import org.springframework.data.domain.Sort;
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
     * Method find All
     * Author PhapTM
     * Create 12-10-2023
     * @param choose : Select type to search
     * @param sort : Arranged in many ways
     * @param page : number page
     * @param value :  value of option choose
     * @return list Warehouse Management
     */

    @GetMapping("")
    public ResponseEntity<Page<IWarehouseProjection>> findAll(
                @RequestParam(value = "choose", required = false, defaultValue = "name") String choose,
                @RequestParam(value = "sort", required = false, defaultValue = "") String sort,
                @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
                @RequestParam(value = "value", required = false, defaultValue = "") String value) {
        Page<IWarehouseProjection> warehouseProjections = null;
        Pageable pageable;
        if(page < 0){
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        switch (sort){
            case "name":
                pageable = PageRequest.of(page, 5, Sort.by("name").ascending());
                break;
            case "price":
                pageable = PageRequest.of(page, 5, Sort.by("price").ascending());
                break;
            case "supplier":
                pageable = PageRequest.of(page, 5, Sort.by("supplier").ascending());
                break;
            default:
                pageable = PageRequest.of(page, 5);
                break;
        }
        switch (choose){
            case "name":
                warehouseProjections = wareHouseService.findAllByName(pageable,value);
                break;
            case "price":
                warehouseProjections = wareHouseService.findAllByPrice(pageable,value);
                break;
            case "supplier":
                warehouseProjections = wareHouseService.findAllBySupplier(pageable,value);
                break;
        }
        return new ResponseEntity<>(warehouseProjections, HttpStatus.OK);
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
        if(productDto == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
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
        if(supplierDtoWarehouse ==null ){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(supplierDtoWarehouse, HttpStatus.OK);
    }

    /**
     * Method: chooseSupplier
     * Author: PhapTM
     * Create: 12-10-2023
     * @param warehouseDto create object by warehouseDto
     * @param bindingResult returns error results
     * @return if true, return of HttpStatus.CREATE
     *         else, return of HttpStatus.BAD_REQUEST
     */

    @PostMapping("/create")
    public ResponseEntity<?> importProduct(@Valid @RequestBody WarehouseDto warehouseDto, BindingResult bindingResult) {
        Map<String, String> errors = new HashMap<>();
        new WarehouseDto().validate(warehouseDto, bindingResult);
        if (bindingResult.hasErrors()) {
            for (FieldError err : bindingResult.getFieldErrors()) {
                errors.put(err.getField(), err.getDefaultMessage());
            }
            return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
        }
        wareHouseService.importProduct(warehouseDto.getProductId(), warehouseDto.getQuantity(), warehouseDto.getSupplierId());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
//    @PostMapping("/create")
//    public ResponseEntity<?> importProduct(@Valid @RequestBody WarehouseDto warehouseDto, BindingResult bindingResult) {
//        Map<String, String> errors = new HashMap<>();
//        new WarehouseDto().validate(warehouseDto, bindingResult);
//        if (bindingResult.hasErrors()) {
//            for (FieldError err : bindingResult.getFieldErrors()) {
//                errors.put(err.getField(), err.getDefaultMessage());
//            }
//            return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
//        }
//        WareHouse wareHouse = new WareHouse();
//        BeanUtils.copyProperties(warehouseDto,wareHouse);
//        wareHouseService.importProduct(wareHouse);
//        return new ResponseEntity<>(HttpStatus.CREATED);
//    }


}
