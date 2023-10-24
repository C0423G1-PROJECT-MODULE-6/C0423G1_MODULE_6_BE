package com.example.c4zone.controller.wareHouse;

import com.example.c4zone.dto.product.IProductDto;
import com.example.c4zone.dto.warehouse.ISupplierDtoWarehouse;
import com.example.c4zone.dto.warehouse.WarehouseDto;
import com.example.c4zone.model.product.Type;
import com.example.c4zone.model.supplier.Supplier;
import com.example.c4zone.model.wareHouse.IWarehouseProjection;
import com.example.c4zone.service.product.IProductService;
import com.example.c4zone.service.product.ITypeService;
import com.example.c4zone.service.supplier.ISupplierService;
import com.example.c4zone.service.wareHouse.IWareHouseService;
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
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@CrossOrigin("*")
@RequestMapping("api/admin/ware/warehouse")
public class WareHouseController {
    @Autowired
    private IWareHouseService wareHouseService;
    @Autowired
    private IProductService productService;
    @Autowired
    private ISupplierService supplierService;
    @Autowired
    private ITypeService typeService;

    /**
     * Method find All
     * Author PhapTM
     * Create 12-10-2023
     *
     * @param choose : Select type to search
     * @param sort   : Arranged in many ways
     * @param page   : number page
     * @param value  :  value of option choose
     * @return list Warehouse Management
     */

    @GetMapping("")
    public ResponseEntity<Page<IWarehouseProjection>> findAll(
            @RequestParam(value = "sort", required = false, defaultValue = "") String sort,
            @RequestParam(value = "choose", required = false, defaultValue = "name") String choose,
            @RequestParam(value = "value", required = false, defaultValue = "") String value,
            @RequestParam(value = "page", required = false, defaultValue = "0") Integer page) {
        Page<IWarehouseProjection> warehouseProjections = null;
        Pageable pageable;

        switch (sort) {
            case "name":
                pageable = PageRequest.of(page, 10, Sort.by("nameProduct").ascending());
                break;
            case "price":
                pageable = PageRequest.of(page, 10, Sort.by("priceProduct").ascending());
                break;
            case "supplier":
                pageable = PageRequest.of(page, 10, Sort.by("nameSupplier").ascending());
                break;
            case "quantity":
                pageable = PageRequest.of(page, 10, Sort.by("quantity").ascending());
                break;
            case "totalPrice":
                pageable = PageRequest.of(page, 10, Sort.by("totalPrice").ascending());
                break;
            case "inputDate":
                pageable = PageRequest.of(page, 10, Sort.by("inputDate").descending());
                break;
            default:
                pageable = PageRequest.of(page, 10, Sort.by("idWarehouse").descending());
                break;
        }
        switch (choose) {
            case "name":
                warehouseProjections = wareHouseService.findAllByName(pageable, value);
                break;
            case "price":
                warehouseProjections = wareHouseService.findAllByPrice(pageable, value);
                break;
            case "supplier":
                warehouseProjections = wareHouseService.findAllBySupplier(pageable, value);
                break;
            case "quantity":
                warehouseProjections = wareHouseService.findAllByQuantity(pageable, value);
                break;
            default:
                warehouseProjections = wareHouseService.findAllByName(pageable, "");
        }
        return new ResponseEntity<>(warehouseProjections, HttpStatus.OK);
    }

    /**
     * Method: chooseProduct
     * Author: PhapTM
     * Create: 12-10-2023
     *
     * @param id find id by product
     * @return object of product
     */
    @GetMapping("/product/{id}")
    public ResponseEntity<IProductDto> chooseProduct(@PathVariable Long id) {
        IProductDto productDto = productService.findProductWarehouse(id);
        if (productDto == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(productDto, HttpStatus.OK);
    }

    /**
     * Method: chooseProduct
     * Author: PhapTM
     * Create: 12-10-2023
     *
     * @param id find by id by supplier
     * @return object of supplier
     */
    @GetMapping("/supplier/{id}")
    public ResponseEntity<ISupplierDtoWarehouse> getSupplier(@PathVariable Long id) {
        ISupplierDtoWarehouse supplierDtoWarehouse = supplierService.findSupplierByIdWarehouse(id);
        if (supplierDtoWarehouse == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(supplierDtoWarehouse, HttpStatus.OK);
    }

    /**
     * Method: chooseSupplier
     * Author: PhapTM
     * Create: 12-10-2023
     *
     * @param warehouseDto  create object by warehouseDto
     * @param bindingResult returns error results
     * @return if true, return of HttpStatus.CREATE
     * else, return of HttpStatus.BAD_REQUEST
     */

    @PostMapping("/create")
    public ResponseEntity<Object> importProduct(@Valid @RequestBody WarehouseDto warehouseDto, BindingResult bindingResult) {

        Map<String, String> errors = new HashMap<>();
        new WarehouseDto().validate(warehouseDto, bindingResult);
        if (bindingResult.hasErrors()) {
            for (FieldError err : bindingResult.getFieldErrors()) {
                errors.put(err.getField(), err.getDefaultMessage());
            }
            return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
        }
        wareHouseService.importProduct(warehouseDto.getProductId(), warehouseDto.getQuantity(), warehouseDto.getSupplierId());
        wareHouseService.updateProductQuantity(warehouseDto.getProductId(), warehouseDto.getQuantity());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * author: ThienPT
     * date: 23/10/2023
     * goal: Get list all supplier
     *
     * @param page to find supplier by id
     * @param size to find supplier by id
     * @param nameSearch to find supplier by id
     * @param addressSearch to find supplier by id
     * @param emailSearch to find supplier by id
     * @return HttpStatus
     */
    @GetMapping("/supplier")
    public ResponseEntity<Object> getAllSupplier(
            @RequestParam("_page") Integer page,
            @RequestParam("_limit") Integer size,
            @RequestParam("name_like") String nameSearch,
            @RequestParam("addressSearch") String addressSearch,
            @RequestParam("emailSearch") String emailSearch
    ) {
        if (page == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Giá trị của trang hiện tại không thể là null");
        }
        if (size == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Giá trị của kích cỡ dòng trong 1 trang không thể null");
        }
        if (page.equals("")){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Giá trị của trang hiện tại không thể là rỗng");
        }
        if (size.equals("")){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Giá trị của kích cỡ dòng trong 1 trang không thể rỗng");
        }
        if (nameSearch == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Giá trị của trường tên nhà cung cấp không thể là null");
        }
        if (addressSearch == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Giá trị của trường địa chỉ nhà cung cấp không thể là null");
        }
        if (emailSearch == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Giá trị của trường email nhà cung cấp không thể là null");
        }
        Pageable pageable = PageRequest.of(page, size);
        Page<Supplier> listSupplier;
        if (nameSearch.isEmpty() && addressSearch.isEmpty() && emailSearch.isEmpty()) {
            listSupplier = supplierService.getAllNoCondition(pageable);
        } else {
            listSupplier = supplierService.getAll(nameSearch, addressSearch, emailSearch, pageable);
        }

        if (listSupplier == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if(listSupplier.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(listSupplier, HttpStatus.OK);
    }


    /**
     * author :PhapTM
     * work day : 23/10/2023
     *
     * @param choose :choose with search
     * @param sort   : sort with field
     * @param page   : number page
     * @param value  : value of option choose
     * @return
     */
    @GetMapping("/list")
    public ResponseEntity<Page<IProductDto>> getAll(
            @RequestParam(value = "choose", required = false, defaultValue = "name") String choose,
            @RequestParam(value = "sort", required = false, defaultValue = "") String sort,
            @RequestParam(value = "otherSort", required = false, defaultValue = "asc") String otherSort,
            @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
            @RequestParam(value = "value", required = false, defaultValue = "") String value,
            @RequestParam (value = "size",required = false,defaultValue = "10") Integer size ) {
        Page<IProductDto> productDtoPage;
        Pageable pageable;
        Sort sort1;
        switch (sort) {
            case "name":
                sort1 = Sort.by("name");
                break;
            case "type":
                sort1 = Sort.by("type");
                break;
            case "price":
                sort1 = Sort.by("price");
                break;
            case "quantity":
                sort1 = Sort.by("quantity");
                break;
            default:
                sort1 = Sort.by("quantity");
                break;
        }
        if (otherSort.equals("asc")) {
            sort1 = sort1.ascending();
        } else {
            sort1 = sort1.descending();
        }
        pageable = PageRequest.of(page, size, sort1);
        switch (choose) {
            case "name":
                productDtoPage = productService.getAllByName(pageable, value);
                break;
            case "price":
                if (Objects.equals(value, "")) {
                    productDtoPage = productService.getAllByName(pageable, "");
                    break;
                }
                productDtoPage = productService.getAllByPrice(pageable, value);
                break;
            case "type":
                if (Objects.equals(value, "")) {
                    productDtoPage = productService.getAllByName(pageable, "");
                    break;
                }
                productDtoPage = productService.getAllByType(pageable, value);
                break;
            case "quantity":
                productDtoPage = productService.getAllByQuantity(pageable, value);
                break;
            default:
                productDtoPage = productService.getAllByName(pageable, "");
                break;
        }
        if (productDtoPage.getContent().isEmpty()) {
            return new ResponseEntity<>(productDtoPage, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(productDtoPage, HttpStatus.OK);
    }

    /**
     * author: PhapTM
     * create: 23/10/2023
     * @return list of type product
     */
    @GetMapping("/type/list")
    @ResponseBody
    public ResponseEntity<List<Type>> findAll(){
        return new ResponseEntity<>(typeService.findAll(), HttpStatus.OK);
    }

}
