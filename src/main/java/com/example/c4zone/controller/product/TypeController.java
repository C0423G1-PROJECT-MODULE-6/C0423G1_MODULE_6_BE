package com.example.c4zone.controller.product;

import com.example.c4zone.model.product.Type;
import com.example.c4zone.service.product.ITypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("api/admin/type")
public class TypeController {
    @Autowired
    private ITypeService typeService;

    @GetMapping("/list")
    @ResponseBody
    public ResponseEntity<List<Type>> findAll(){
        return new ResponseEntity<>(typeService.findAll(), HttpStatus.OK);
    }
}
