package com.example.c4zone.controller.product;

import com.example.c4zone.model.product.Ram;
import com.example.c4zone.service.product.IRamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("api/admin/business/ram")
public class RamController {
    @Autowired
    private IRamService ramService;

    @GetMapping("/list")
    @ResponseBody
    public ResponseEntity<List<Ram>> findAll() {
        return new ResponseEntity<>(ramService.findAll(), HttpStatus.OK);
    }
}
