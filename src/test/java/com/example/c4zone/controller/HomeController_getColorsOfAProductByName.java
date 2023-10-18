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
public class HomeController_getColorsOfAProductByName {

    @Autowired
    private MockMvc mockMvc;
    @Test
    public void getColorsOfAProductByName_id_8() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/admin/home/colors?name={name}", ""))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
    @Test void getColorsOfAProductByName_id_9() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/admin/home/colors?name={name}", "abcxyz"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
    @Test void getColorsOfAProductByName_id_11() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/admin/home/colors?name={name}", "iphone 12"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
