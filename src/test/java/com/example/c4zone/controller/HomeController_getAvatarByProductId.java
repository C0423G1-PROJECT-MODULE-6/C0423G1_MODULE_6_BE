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
public class HomeController_getAvatarByProductId {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getAvatarByProductId_id_8() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/admin/home/avatar/{id}", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void getAvatarByProductId_id_9() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/admin/home/avatar/{id}", 999))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getAvatarByProductId_id_11() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/admin/home/avatar/{id}", 1))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

}

