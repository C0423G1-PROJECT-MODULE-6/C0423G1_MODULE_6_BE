package com.example.c4zone.controller.product;

import com.example.c4zone.dto.product.IProductDto;
import com.example.c4zone.dto.product.ImageDto;
import com.example.c4zone.dto.product.ListImageDto;
import com.example.c4zone.dto.product.ProductDto;
import com.example.c4zone.model.product.*;
import com.example.c4zone.service.product.*;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import org.json.JSONObject;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.validation.Valid;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.*;

@RestController
@CrossOrigin("*")
@RequestMapping("api/admin/product")
public class ProductController {
    @Autowired
    private IProductService productService;
    @Autowired
    private IImageService imageService;
//    @Autowired
//    private ICapacityService capacityService;
//    @Autowired
//    private IColorService colorService;
//    @Autowired
//    private ICpuService cpuService;
//    @Autowired
//    private IRamService ramService;
//    @Autowired
//    private ISeriesService seriesService;
//    @Autowired
//    private ITypeService typeService;

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
        imageDto.setName("");
        productDto.setImageDto(imageDto);
        return new ResponseEntity<>(productDto, HttpStatus.OK);
    }

    /**
     * author: DaoPTA
     * workday: 12/10/2023
     *
     * @param idProduct The id parameter is used to find by id
     * @return id to find
     */
    @GetMapping("/{idProduct}")
    @ResponseBody
    public ResponseEntity<ProductDto> findProductById(@PathVariable("idProduct") Long idProduct) {
        List<Image> image = imageService.findImageProductByIdProduct(idProduct);
        Product product = productService.findProductById(idProduct);
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
     * @param productDto    to save the object dto
     * @param bindingResult returns errors on save
     * @return if true, return it HttpStatus.OK
     * else false, return it HttpStatus.BAD_REQUEST
     */
    @PostMapping("/add")
    @ResponseBody
    public ResponseEntity<Object> createProduct(@Valid @RequestBody(required = false) ProductDto productDto,
                                                BindingResult bindingResult
                                                ) throws WriterException, IOException {

        Map<String, String> error = new HashMap<>();
        new ProductDto().validate(productDto, bindingResult);
        if (bindingResult.hasErrors()) {
            for (FieldError err : bindingResult.getFieldErrors()) {
                error.put(err.getField(), err.getDefaultMessage());
            }
            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        }
        Product product = new Product();
        BeanUtils.copyProperties(productDto, product);
        productService.createProduct(product);
        Long idProduct = productService.getLastInsertedId();
        imageService.insertImageByProductId(productDto.getImageDtoList(),idProduct);


        String qrCodeText = product.toString();
        int width = 300;
        int height = 300;

        BitMatrix bitMatrix = new QRCodeWriter().encode(qrCodeText, BarcodeFormat.QR_CODE, width, height);
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                bufferedImage.setRGB(x, y, bitMatrix.get(x, y) ? 0xFF000000 : 0xFFFFFFFF);
            }
        }
        File qrCodeFile = new File("D:\\Sprint_6_Continute\\QRcode" + product.getIdProduct() + ".png");
        ImageIO.write(bufferedImage, "png", qrCodeFile);

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ImageIO.write(bufferedImage, "png", byteArrayOutputStream);
        byte[] qrCodeImage = byteArrayOutputStream.toByteArray();
        String qrCodeBase64 = Base64.getEncoder().encodeToString(qrCodeImage);

        JSONObject response = new JSONObject();
        response.put("objectId", product.getIdProduct());
        response.put("qrCodeBase64", qrCodeBase64);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * author: DaoPTA
     * workday: 12/10/2023
     *
     * @param productDto    to update the object dto
     * @param bindingResult returns errors on update
     * @return if true, return it HttpStatus.OK
     * else false, return it HttpStatus.BAD_REQUEST
     */
    @PatchMapping("/{idProduct}")
    @ResponseBody
    public ResponseEntity updateProduct(@Valid @RequestBody ProductDto productDto, @PathVariable Long idProduct, BindingResult bindingResult) {
        Product product = (Product) productService.findProductById(idProduct);
        new ProductDto().validate(productDto, bindingResult);
        Map<String, String> error = new HashMap<>();
        if (bindingResult.hasErrors()) {
            for (FieldError err : bindingResult.getFieldErrors()) {
                error.put(err.getField(), err.getDefaultMessage());
            }
            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        }
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
     *
     * @param choose :choose with search
     * @param sort   : sort with field
     * @param page   : number page
     * @param value  : value of option choose
     * @return
     */
    @GetMapping("/list")
    public ResponseEntity<Page<IProductDto>> getAll(
            @RequestParam(value = "choose", required = false, defaultValue = "name") String choose,
            @RequestParam(value = "sort", required = false, defaultValue = "") String sort,
            @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
            @RequestParam(value = "value", required = false, defaultValue = "") String value) {
        Page<IProductDto> productDtoPage;
        Pageable pageable;
        if (page < 0) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
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
                if (value.matches("^\\w+$")) {
                    productDtoPage = productService.getAllByName(pageable, value);
                    break;
                } else {
                    return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
                }
            case "price":
                productDtoPage = productService.getAllByPrice(pageable, value);
                break;
            case "type":
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
            return new ResponseEntity<>(productDtoPage, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(productDtoPage, HttpStatus.OK);
    }

    /**
     * author :QuanND
     * work day : 12/10/2023
     *
     * @param id
     * @return if Http status
     */
    @PatchMapping("/remove")
    public ResponseEntity<?> removeProduct(@RequestParam(name = "id") Long id) {
        if (productService.findProductById(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            productService.removeProduct(id);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
