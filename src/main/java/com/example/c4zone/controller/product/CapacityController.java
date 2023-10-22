package com.example.c4zone.controller.product;

import com.example.c4zone.model.product.Capacity;
import com.example.c4zone.service.product.ICapacityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("api/admin/business/capacity")
public class CapacityController {
    @Autowired
    private ICapacityService capacityService;

    @GetMapping("/list")
    @ResponseBody
    public ResponseEntity<List<Capacity>> findAll(){
        return new ResponseEntity<>(capacityService.findAll(), HttpStatus.OK);
    }
}
