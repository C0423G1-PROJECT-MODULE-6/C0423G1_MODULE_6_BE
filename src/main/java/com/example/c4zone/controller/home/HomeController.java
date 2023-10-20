package com.example.c4zone.controller.home;


import com.example.c4zone.dto.product.IColorDto;
import com.example.c4zone.dto.product.IProductDto;
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

    @GetMapping("/list")
    public ResponseEntity<List<IProductDto>> getListByName(@RequestParam(value = "name", defaultValue = "", required = false) String name, @RequestParam(value = "sortName", defaultValue = "id", required = false) String sortName, @RequestParam(value = "sortType", required = false, defaultValue = "desc") String sortType) {
        if (sortType.equals("desc")) {
            List<IProductDto> getListByName = homeService.getProductsByNameSortByPriceDESC("%" + name + "%", sortName);
            if (getListByName.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(getListByName, HttpStatus.OK);
        }
        List<IProductDto> getListByName = homeService.getProductsByNameSortByPriceASC("%" + name + "%", sortName);

        if (getListByName.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(getListByName, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<IProductDto> getProductById(@PathVariable Long id) {
        IProductDto productDto = homeService.getProductById(id);
        if (productDto == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(productDto, HttpStatus.OK);
    }

    @GetMapping("/detail")
    public ResponseEntity<IProductDto> getProductByNameAndCapacityAndColor(@RequestParam(value = "name") String name, @RequestParam(value = "capacity") String capacity, @RequestParam(value = "color") String color) {
        IProductDto productDto = homeService.getProductByNameAndCapacityAndColor(name, capacity, color);
        if (productDto == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(productDto, HttpStatus.OK);
    }

    @GetMapping("/colors")
    public ResponseEntity<List<IColorDto>> getColorsOfAProductByNameAndCapacity(@RequestParam(value = "name") String name,@RequestParam(value = "capacity") String capacity) {
        List<IColorDto> colors = homeService.getColorsOfAProductByNameAndCapacity(name,capacity);
        if (colors == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(colors, HttpStatus.OK);
    }

    @GetMapping("/capacities")
    public ResponseEntity<List<String>> getCapacitiesOfProductByNameAndColor(@RequestParam(value = "name") String name,@RequestParam(value = "color") String color) {
        List<String> capacities = homeService.getCapacitiesOfProductByNameAndColor(name,color);
        if (capacities.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(capacities, HttpStatus.OK);
    }

    @GetMapping("/images/{id}")
    public ResponseEntity<List<String>> getImageLinksByProductId(@PathVariable Long id) {
        List<String> images = homeService.getImageLinksByProductId(id);
        if (images.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(images, HttpStatus.OK);
    }

    @GetMapping("/bestsellers")
    public ResponseEntity<List<IProductDto>> getBestsellers() {
        List<IProductDto> getBestsellers = homeService.getBestsellers();
        if (getBestsellers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(getBestsellers, HttpStatus.OK);
    }

    @GetMapping("/series/{type}")
    public ResponseEntity<List<String>> getSeriesByProductType(@PathVariable String type) {
        List<String> getSeriesByProductType = homeService.getSeriesByProductType("%" + type + "%");
        if (getSeriesByProductType.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(getSeriesByProductType, HttpStatus.OK);
    }
}
