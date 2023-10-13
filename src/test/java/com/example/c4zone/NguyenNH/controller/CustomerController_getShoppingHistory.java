package com.example.c4zone.NguyenNH.controller;

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
public class CustomerController_getShoppingHistory {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getShoppingHistory_id_7() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/admin/customer/history/{id}", (Object) null)
                        .param("_limit", "3")
                        .param("_page", "0"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getShoppingHistory_id_8() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/admin/customer/history/{id}","")
                        .param("_limit", "3")
                        .param("_page", "0"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getShoppingHistory_id_9() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/admin/customer/history/{id}",55)
                        .param("_limit", "3")
                        .param("_page", "0"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getShoppingHistory_id_10() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/admin/customer/history/{id}",9)
                        .param("_limit", "3")
                        .param("_page", "0"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getShoppingHistory_id_11() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/admin/customer/history/{id}",1)
                        .param("_limit", "3")
                        .param("_page", "0"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("content[0].dateOfOrder").value("2023-10-10"))
                .andExpect(jsonPath("content[0].nameProduct").value("6.1 inch"))
                .andExpect(jsonPath("content[0].priceOrder").value("12221.0"))

                .andExpect(jsonPath("content[1].dateOfOrder").value("2023-02-10"))
                .andExpect(jsonPath("content[1].nameProduct").value("6.1 inch"))
                .andExpect(jsonPath("content[1].priceOrder").value("200.0"));
    }

}
