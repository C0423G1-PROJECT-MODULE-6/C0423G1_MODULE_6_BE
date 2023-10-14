package com.example.c4zone.NghiaNPX.controller;

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
public class SupplierController_createSupplier {

    @Autowired
    private MockMvc mockMvc;
    @Test
    public void createSupplier_1() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.
                post("/api/admin/supplier/create"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
                //.andExpect(jsonPath(""));

    }
}
