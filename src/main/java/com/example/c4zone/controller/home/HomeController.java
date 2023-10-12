package com.example.c4zone.controller.home;

import com.example.c4zone.model.product.Product;
import com.example.c4zone.service.home.IHomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@CrossOrigin("*")
@RequestMapping("api/admin/home")

public class HomeController {
    @Autowired
    private IHomeService homeService;

    @GetMapping("/list/{name}/{sortType}")
    public ResponseEntity<List<Product>> getListByName(@PathVariable String name, @PathVariable String sortName, @PathVariable String sortType){
        List<Product> getListByName =homeService.getProductsByName(name+"%", sortName,sortType);
        return new ResponseEntity<>(getListByName, HttpStatus.OK);
    }



}
