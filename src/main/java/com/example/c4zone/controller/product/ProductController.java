package com.example.c4zone.controller.product;

import com.example.c4zone.dto.product.IProductDto;
import com.example.c4zone.dto.product.ImageDto;
import com.example.c4zone.dto.product.ProductDto;
import com.example.c4zone.model.product.Image;
import com.example.c4zone.model.product.Product;
import com.example.c4zone.service.product.IImageService;
import com.example.c4zone.service.product.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("api/admin/product")
public class ProductController {
    @Autowired
    private IProductService productService;
    @Autowired
    private IImageService imageService;

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

    @GetMapping("/")
    public ResponseEntity<Page<IProductDto>> getAll(
            @RequestParam(value = "choose", required = false, defaultValue = "name") String choose,
            @RequestParam(value = "sort", required = false, defaultValue = "") String sort,
            @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
            @RequestParam(value = "value", required = false, defaultValue = "") String value) {
        Page<IProductDto> productDtoPage = null;
        Pageable pageable = PageRequest.of(page, 5);
        switch (sort) {
            case "name":
                pageable = PageRequest.of(page, 5, Sort.by("name").ascending());
                break;
            case "type":
                pageable = PageRequest.of(page, 5, Sort.by("type").ascending());
                break;
            case "price":
                pageable = PageRequest.of(page, 5, Sort.by("price").ascending());
                break;
            case "quantity":
                pageable = PageRequest.of(page, 5, Sort.by("quantity").ascending());
                break;
            default:
                pageable = PageRequest.of(page, 5);
                break;
        }
        switch (choose) {
            case "name":
                productDtoPage = productService.getAllByName(pageable, value);
                break;
            case "price":
                productDtoPage=productService.getAllByPrice(pageable,value);
                break;
            case "type":
                productDtoPage=productService.getAllByType(pageable,value);
                break;
            case "quantity":
                productDtoPage=productService.getAllByQuantity(pageable,value);
                break;
        }
        return new ResponseEntity<>(productDtoPage, HttpStatus.OK);
    }
    @DeleteMapping("/")
    public ResponseEntity<?> removeProduct(@RequestParam(name = "id") Long id){


        return new ResponseEntity<>(HttpStatus.OK);
    }

}
