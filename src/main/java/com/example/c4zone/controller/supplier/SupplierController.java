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
@RequestMapping("/api/admin/supplier")
@CrossOrigin("*")
public class SupplierController {
    @Autowired
    private ISupplierService supplierService;

    @GetMapping("")
    public ResponseEntity<Page<Supplier>> getAllSupplier(
            @RequestParam("_page") int page,
            @RequestParam("_limit") int size,
            @RequestParam("name_like") String nameSearch,
            @RequestParam("addressSearch") String addressSearch,
            @RequestParam("emailSearch") String emailSearch
    ) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Supplier> listSupplier;
        if (nameSearch != null && !nameSearch.isEmpty()) {
            listSupplier = supplierService.getAll(nameSearch, addressSearch, emailSearch, pageable);
        } else {
            listSupplier = supplierService.getAllNoCondition(pageable);
        }
        if (listSupplier == null || listSupplier.isEmpty()) {
            return new ResponseEntity<>(listSupplier, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(listSupplier, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSupplier(@PathVariable Long id) {
        if (id.equals("")) {
            return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body("Giá trị của id không thể mang giá trị rỗng");
        }
        if (id == null) {
            return ResponseEntity.badRequest().body("Giá trị của id không thể là null");
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
        if (supplierService.findByIdSupplier(id) == null) {
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
    private ResponseEntity<Object> getSupplierById(@PathVariable Long id) {
        Supplier supplier = supplierService.findById(id);
        if (id == null) {
            return new ResponseEntity<>("Giá trị id không thể null!", HttpStatus.BAD_REQUEST);
        }
        if (id.equals("")) {
            return new ResponseEntity<>("Giá trị id không thể rỗng!", HttpStatus.BAD_REQUEST);
        }
        if (supplier == null) {
            return new ResponseEntity<>("Không tìm thấy đối tượng Supplier!", HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(supplier, HttpStatus.OK);
        }
    }
}
