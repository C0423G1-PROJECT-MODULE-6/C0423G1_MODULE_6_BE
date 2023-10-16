package com.example.c4zone.controller.product;

import com.example.c4zone.model.product.Cpu;
import com.example.c4zone.service.product.ICpuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("api/admin/cpu")
public class CpuController {
    @Autowired
    private ICpuService cpuService;

    @GetMapping("/list")
    @ResponseBody
    public ResponseEntity<List<Cpu>> findAll(){
        return new ResponseEntity<>(cpuService.findAll(), HttpStatus.OK);
    }
}
