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
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
@CrossOrigin("*")
@RequestMapping("api/admin/product")
public class ProductController {
    @Autowired
    private IProductService productService;
    @Autowired
    private IImageService imageService;

    /**
     * author: DaoPTA
     * workday: 12/10/2023
     *
     * @return set image by firebase in list
     */
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

    /**
     * author: DaoPTA
     * workday: 12/10/2023
     *
     * @param id The id parameter is used to find by id
     * @return id to find
     */
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

    /**
     * author: DaoPTA
     * workday: 12/10/2023
     *
     * @param productDto to save the object dto
     * @param bindingResult returns errors on save
     * @return if true, return it HttpStatus.OK
     *          else false, return it HttpStatus.BAD_REQUEST
     */
    @PostMapping("/add")
    @ResponseBody
    public ResponseEntity<Object> createProduct(@Valid @RequestBody ProductDto productDto, BindingResult bindingResult) {
        Map<String, String> error = new HashMap<>();
        new ProductDto().validate(productDto, bindingResult);
        if (bindingResult.hasErrors()) {
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

    /**
     * author: DaoPTA
     * workday: 12/10/2023
     *
     * @param productDto to update the object dto
     * @param bindingResult returns errors on update
     * @return if true, return it HttpStatus.OK
     *          else false, return it HttpStatus.BAD_REQUEST
     */
    @PatchMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Object> updateProduct(@Valid @RequestBody ProductDto productDto, BindingResult bindingResult){
        Map<String, String> error = new HashMap<>();
        new ProductDto().validate(productDto,bindingResult);
        if (bindingResult.hasErrors()) {
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

    /**
     * author :QuanND
     * work day : 12/10/2023
     * @param choose :choose with search
     * @param sort : sort with field
     * @param page : number page
     * @param value : value of option choose
     * @return
     */
    @GetMapping("/list")
    public ResponseEntity<Page<IProductDto>> getAll(
            @RequestParam(value = "choose", required = false, defaultValue = "name") String choose,
            @RequestParam(value = "sort", required = false, defaultValue = "") String sort,
            @RequestParam(value = "otherSort", required = false, defaultValue = "asc") String otherSort,
            @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
            @RequestParam(value = "value", required = false, defaultValue = "") String value) {
        Page<IProductDto> productDtoPage;
        Pageable pageable;
        Sort sort1;
        int size = 5;
        switch (sort) {
            case "name":
                sort1 = Sort.by("name");
                break;
            case "type":
                sort1 = Sort.by("type");
                break;
            case "price":
                sort1 = Sort.by("price");
                break;
            case "quantity":
                sort1 = Sort.by("quantity");
                break;
            default:
                sort1 = Sort.unsorted();
                break;
        }
        if (otherSort.equals("dsc")) {
            sort1 = sort1.descending();
        } else {
            sort1 = sort1.ascending();
        }
        pageable = PageRequest.of(page, size, sort1);
        switch (choose) {
            case "name":
                productDtoPage = productService.getAllByName(pageable, value);
                break;
            case "price":
                if (Objects.equals(value, "")) {
                    productDtoPage = productService.getAllByName(pageable, "");
                    break;
                }
                productDtoPage = productService.getAllByPrice(pageable, value);
                break;
            case "type":
                if (Objects.equals(value, "")) {
                    productDtoPage = productService.getAllByName(pageable, "");
                    break;
                }
                productDtoPage = productService.getAllByType(pageable, value);
                break;
            case "quantity":
                productDtoPage = productService.getAllByQuantity(pageable, value);
                break;
            default:
                productDtoPage = productService.getAllByName(pageable, "");
                break;
        }
        if (productDtoPage.getContent().isEmpty()) {
            return new ResponseEntity<>(productDtoPage, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(productDtoPage, HttpStatus.OK);
    }

    /**
     * author :QuanND
     * work day : 12/10/2023
     * @param id
     * @return if Http status
     */
    @PatchMapping("/remove")
    public ResponseEntity<?> removeProduct(@RequestParam(name = "id") Long id){
        if (productService.findById(id)==null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
            productService.removeProduct(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
