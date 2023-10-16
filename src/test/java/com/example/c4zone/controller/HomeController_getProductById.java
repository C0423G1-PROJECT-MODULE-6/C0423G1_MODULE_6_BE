package com.example.c4zone.controller;

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
public class HomeController_getProductById {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getProductById_id_1() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/admin/home/detail/{id}", (Object) null))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getProductById_id_2() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/admin/home/detail/{id}", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getProductById_id_3() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/admin/home/detail/{id}", 1000))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    @Test
    public void getProductById_id_4() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/admin/home/{id}", 1))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("id").value(1))
                .andExpect(jsonPath("name").value("iPhone 12 128GB"))
                .andExpect(jsonPath("battery").value("2815 mAh"))
                .andExpect(jsonPath("camera").value("12 MP"))
                .andExpect(jsonPath("price").value("1.649E7"))
                .andExpect(jsonPath("quantity").value("10.0"))
                .andExpect(jsonPath("screen").value("6.1 inch"))
                .andExpect(jsonPath("selfie").value("12 MP"))
                .andExpect(jsonPath("weight").value("164.0 g"))
                .andExpect(jsonPath("capacity").value("128GB"))
                .andExpect(jsonPath("color").value("Xanh Lá"))
                .andExpect(jsonPath("cpu").value("Apple A14 Bionic"))
                .andExpect(jsonPath("ram").value("6GB"))
                .andExpect(jsonPath("series").value("IPhone 12"))
                .andExpect(jsonPath("type").value("Iphone"));
    }
}
