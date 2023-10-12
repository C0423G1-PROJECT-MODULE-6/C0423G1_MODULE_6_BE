package com.example.c4zone.controller.product;

import com.example.c4zone.dto.product.ImageDto;
import com.example.c4zone.dto.product.ProductDto;
import com.example.c4zone.model.product.Image;
import com.example.c4zone.model.product.Product;
import com.example.c4zone.service.product.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin("*")
@RequestMapping("api/admin/product")
public class ProductController {
    @Autowired
    private IProductService productService;
    @Autowired
    private IImageService imageService;
    @Autowired
    private ICapacityService capacityService;
    @Autowired
    private IColorService colorService;
    @Autowired
    private ICpuService cpuService;
    @Autowired
    private IRamService ramService;
    @Autowired
    private ISeriesService service;
    @Autowired
    private ITypeService typeService;

    @GetMapping("/create")
    public ResponseEntity<ProductDto> getProductForCreate() {
        ProductDto productDto = new ProductDto();
        ImageDto imageDto = new ImageDto();
        imageDto.setName("https://firebasestorage.googleapis.com/v0/b/c4zone-da49c.appspot.com/o" +
                "/iphone-11-pro-max-vang-4-1-org.jpg?alt=media&token=28942019-622c-4713-be08-47bd3f13d56b&_gl" +
                "=1*1fq0a6k*_ga*MTQ5MDIxMDE1Mi4xNjkxNDc3ODQy*_ga_CW55HF8NVT*MTY5NzAzNDk1Ni4zLjEuMTY5NzAzNTQyNi40Ny4wLjA.");
        productDto.setImageDto(imageDto);
        return new ResponseEntity<>(productDto, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<ProductDto> findProductById(@PathVariable("id") Long id) {
        Image image = imageService.findImageProductByIdProduct(id);
        Product product = productService.findProductById(id);
        ImageDto imageDto = new ImageDto();
        BeanUtils.copyProperties(image, imageDto);
        ProductDto productDto = new ProductDto();
        BeanUtils.copyProperties(product, productDto);
        imageDto.setProduct(product.getIdProduct());
        productDto.setImageDto(imageDto);
        return new ResponseEntity<>(productDto, HttpStatus.OK);
    }

    @PostMapping("/add")
    @ResponseBody
    public ResponseEntity<Object> createProduct(@Valid @RequestBody ProductDto productDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Map<String, String> error = new HashMap<>();
            for (FieldError err : bindingResult.getFieldErrors()) {
                error.put(err.getField(), err.getDefaultMessage());
            }
            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        }
        Product product = new Product();
        Image image = new Image();
        BeanUtils.copyProperties(productDto, product);
        BeanUtils.copyProperties(productDto.getImageDto(), image);
        productService.createProduct(product);
        Long idProduct = productService.getLastInsertedId();
        if (idProduct != null) {
            if (image.getName() == null) {
                image.setName("");
                imageService.createImageProduct(image, idProduct);
            } else {
                imageService.createImageProduct(image, idProduct);
            }
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Object> updateProduct(@Valid @RequestBody ProductDto productDto, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            Map<String, String> error = new HashMap<>();
            for (FieldError err : bindingResult.getFieldErrors()) {
                error.put(err.getField(), err.getDefaultMessage());
            }
            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        }
        Product product = new Product();
        Image image = new Image();
        BeanUtils.copyProperties(productDto, product);
        BeanUtils.copyProperties(productDto.getImageDto(), image);
        productService.updateProduct(product);
        imageService.updateImageProduct(image, product.getIdProduct());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
