package com.example.c4zone.controller.supplier;

import com.example.c4zone.dto.supplier.SupplierDto;
import com.example.c4zone.model.supplier.Supplier;
import com.example.c4zone.service.supplier.ISupplierService;
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
@RequestMapping("/api/admin/business/supplier")
@CrossOrigin("*")
public class SupplierController {
    @Autowired
    private ISupplierService supplierService;


    /**
     * author: ThienPT
     * date: 18/10/2023
     * goal: Get list all supplier
     *
     * @param page to find supplier by id
     * @param size to find supplier by id
     * @param nameSearch to find supplier by id
     * @param addressSearch to find supplier by id
     * @param emailSearch to find supplier by id
     * @return HttpStatus
     */

    @GetMapping("")
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
            listSupplier = supplierService.getAll(nameSearch.trim(), addressSearch, emailSearch, pageable);
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
     * author: ThienPT
     * date: 18/10/2023
     * goal: Delete available supplier
     *
     * @param id to find supplier by id
     * @return HttpStatus
     */

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteSupplier(@PathVariable Long id) {
        if (id.equals("")) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Giá trị của id không thể mang giá trị rỗng");
        }
        if (id == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Giá trị của id không thể là null");
        }
        if (supplierService.findByIdSupplier(id) == null) {
            return ResponseEntity.notFound().build();
        }
        supplierService.deleteSupplier(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * author: NghiaNPX
     * date: 12/10/2023
     * goal: Edit available supplier
     *
     * @param id          to find customer by id
     * @param supplierDto to overwrite the old object
     * @return HttpStatus
     */
    @PatchMapping("/edit/{id}")
    @ResponseBody
    public ResponseEntity<Object> editSupplier(@PathVariable Long id,
                                               @RequestBody SupplierDto supplierDto,
                                               BindingResult bindingResult) {
        Supplier availableSupplier = supplierService.findById(id);
        if (availableSupplier == null) {
            return new ResponseEntity<>("Không tìm thấy đối tượng Supplier!", HttpStatus.NOT_FOUND);
        }
        if (id == null) {
            return new ResponseEntity<>("Giá trị id không thể null!", HttpStatus.BAD_REQUEST);
        }
        if (id.equals("")) {
            return new ResponseEntity<>("Giá trị id không thể rỗng!", HttpStatus.BAD_REQUEST);
        }
        new SupplierDto().validate(supplierDto, bindingResult);
        Map<String, String> errors = new HashMap<>();
        if (bindingResult.hasErrors()) {
            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                errors.put(fieldError.getField(), fieldError.getDefaultMessage());
            }
        }
        if (!(availableSupplier.getNameSupplier()).equals(supplierDto.getNameSupplier())) {
            Supplier duplicatedNameSupplier = supplierService.findSupplierByName(supplierDto.getNameSupplier());
            if (duplicatedNameSupplier != null) {
                errors.put("nameSupplier", "Tên nhà cung cấp đã tồn tại!");
            }
        }
        if (!(availableSupplier.getPhoneNumberSupplier()).equals(supplierDto.getPhoneNumberSupplier())) {
            Supplier duplicatedPhoneNumberSupplier = supplierService.findSupplierByPhoneNumber(supplierDto.getPhoneNumberSupplier());
            if (duplicatedPhoneNumberSupplier != null) {
                errors.put("phoneNumberSupplier", "SĐT đã tồn tại!");
            }
        }
        if (!(availableSupplier.getEmailSupplier()).equals(supplierDto.getEmailSupplier())) {
            Supplier duplicatedEmailSupplier = supplierService.findSupplierByEmail(supplierDto.getEmailSupplier());
            if (duplicatedEmailSupplier != null) {
                errors.put("emailSupplier", "Email đã tồn tại!");
            }
        }
        if (errors.size() != 0) {
            return new ResponseEntity<>(errors, HttpStatus.NOT_ACCEPTABLE);
        }
        Supplier newSupplier = new Supplier();
        BeanUtils.copyProperties(supplierDto, newSupplier);
        supplierService.editSupplier(newSupplier);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * author: NghiaNPX
     * date: 12/10/2023
     * goal: create new supplier
     *
     * @param supplierDto   to save the object dto
     * @param bindingResult to return errors
     * @return HttpStatus
     */
    @PostMapping("/create")
    @ResponseBody
    public ResponseEntity<Object> createSupplier(@RequestBody @Valid SupplierDto supplierDto,
                                                 BindingResult bindingResult) {
        new SupplierDto().validate(supplierDto, bindingResult);
        Map<String, String> errors = new HashMap<>();
        if (bindingResult.hasErrors()) {
            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                errors.put(fieldError.getField(), fieldError.getDefaultMessage());
            }
        }
        Supplier duplicatedNameSupplier = supplierService.findSupplierByName(supplierDto.getNameSupplier());
        if (duplicatedNameSupplier != null) {
            errors.put("nameSupplier", "Tên nhà cung cấp đã tồn tại!");
        }
        Supplier duplicatedPhoneNumberSupplier = supplierService.findSupplierByPhoneNumber(supplierDto.getPhoneNumberSupplier());
        if (duplicatedPhoneNumberSupplier != null) {
            errors.put("phoneNumberSupplier", "SĐT đã tồn tại!");
        }
        Supplier duplicatedEmailSupplier = supplierService.findSupplierByEmail(supplierDto.getEmailSupplier());
        if (duplicatedEmailSupplier != null) {
            errors.put("emailSupplier", "Email đã tồn tại!");
        }
        if (errors.size() != 0) {
            return new ResponseEntity<>(errors, HttpStatus.NOT_ACCEPTABLE);
        }
        Supplier newSupplier = new Supplier();
        BeanUtils.copyProperties(supplierDto, newSupplier);
        supplierService.saveSupplier(newSupplier);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * author: NghiaNPX
     * date: 13/10/2023
     * goal: find an object by id
     *
     * @param id passing value to find Supplier
     * @return HttpResponse
     */
    @GetMapping("/{id}")
    public ResponseEntity<Object> getSupplierById(@PathVariable Long id) {
        Supplier supplier = supplierService.findById(id);
        if (id == null) {
            return new ResponseEntity<>("Giá trị id không được null!", HttpStatus.BAD_REQUEST);
        }
        if (id.equals("")) {
            return new ResponseEntity<>("Giá trị id không được rỗng!", HttpStatus.BAD_REQUEST);
        }
        if (supplier == null) {
            return new ResponseEntity<>("Không tìm thấy đối tượng Supplier!", HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(supplier, HttpStatus.OK);
        }
    }
}
