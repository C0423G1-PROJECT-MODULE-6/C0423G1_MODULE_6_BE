package com.example.c4zone.order;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class OrderController_getAllCart {

    @Autowired
    private MockMvc mockMvc;
    @Test
    public void getAllCart_idUser_1() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/admin/order/cart/{id}", (Object) null))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getAllCart_idUser_2() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                .get("/api/admin/order/cart/{id}",""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void getAllCart_idUser_3() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/admin/order/cart/{id}", 3))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
}
