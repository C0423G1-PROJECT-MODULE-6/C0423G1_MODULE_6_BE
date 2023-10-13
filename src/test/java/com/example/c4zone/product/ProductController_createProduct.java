package com.example.c4zone.product;

import com.example.c4zone.dto.product.ProductDto;
import com.example.c4zone.model.product.Capacity;
import com.example.c4zone.model.product.Color;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductController_createProduct {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void createProduct_1 () throws Exception {
        ProductDto productDto = new ProductDto();
        productDto.setNameProduct("Phan Tá Anh Đào");
        productDto.setBatteryProduct("100%");
        productDto.setCameraProduct("12mp, 12mp, 12mp");
        productDto.setPriceProduct(11000000.0);
        productDto.setQuantityProduct(100.0);
        productDto.setScreenProduct("64 in");
        productDto.setSelfieProduct("15mp");
        productDto.setWeightProduct(200.5);
        productDto.setDescriptionProduct("Ngon bổ rẻ");
        Capacity capacity = new Capacity();
        capacity.setIdCapacity(1L);
        productDto.setCapacity(capacity);
        Color color = new Color();
        color.setIdColor(1L);
        productDto.setColor(color);

    }

}
