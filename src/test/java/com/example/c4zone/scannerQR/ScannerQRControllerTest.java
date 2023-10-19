package com.example.c4zone.scannerQR;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ScannerQRControllerTest {
    @Autowired
    private MockMvc mockMvc;

    /**
     * Returns list of products
     * Author : LoiVT
     * Date : 19/10/2023
     */

    @Test
    public void getByIdProduct_3() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/admin/scanner-qr")
                        .param("idProduct", "34634345"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$").doesNotExist());
    }


    @Test
    public void getByIdProduct_4() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/admin/scanner-qr")
                        .param("idProduct", "1"))
                .andDo(print())
                .andExpect(jsonPath("idProduct").value(1))
                .andExpect(jsonPath("nameProduct").value("Iphone 11"))
                .andExpect(status().is2xxSuccessful());
    }
}
