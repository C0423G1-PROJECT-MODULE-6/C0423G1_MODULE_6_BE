package com.example.c4zone.controller.product;

import com.example.c4zone.model.product.Color;
import com.example.c4zone.service.product.IColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("api/admin/business/color")
public class ColorController {
    @Autowired
    private IColorService colorService;

    @GetMapping("/list")
    @ResponseBody
    public ResponseEntity<List<Color>> findAll(){
        return new ResponseEntity<>(colorService.findAll(), HttpStatus.OK);
    }
}
