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
        if(getListByName == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(getListByName, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id){
        Product product = homeService.getProductById(id);
        if(product== null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(product,HttpStatus.OK);
    }
    @GetMapping("/bestsellers")
    public ResponseEntity<List<Product>> getBestSellers(){
        List<Product> getBestsellers = homeService.getBestsellers();
        if(getBestsellers.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(getBestsellers,HttpStatus.OK);
    }
    @GetMapping("/avatar/{id}")
    public ResponseEntity<String> getAvatarByProductId(@PathVariable Long id){
        String avatar = homeService.getAvatarByProductId(id);
        if(avatar == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(avatar,HttpStatus.OK);
    }
    @GetMapping("/colors/{name}")
    public ResponseEntity<List<String>> getColorsOfAProductByName(@PathVariable String name){
        List <String> colors = homeService.getColorsOfAProductByName(name);
        if(colors == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(colors,HttpStatus.OK);
    }

    @GetMapping("/capacities/{name}")
    public ResponseEntity <List<String>>getCapacitiesByName(@PathVariable String name){
        List <String> capacities = homeService.getCapacitiesByName(name);
        if(capacities == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(capacities,HttpStatus.OK);
    }

    @GetMapping("/images/{id}")
    public ResponseEntity<List<String>> getImageLinksById(@PathVariable Long id){
        List<String> images = homeService.getImageLinksById(id);
        if(images == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(images,HttpStatus.OK);
    }

}
