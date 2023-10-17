package com.example.c4zone.controller;

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
public class HomeController_getCapacitiesByName {

    @Autowired
    private MockMvc mockMvc;
    @Test
    public void getCapacitiesByName_id_8() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/admin/home/capacities?name={name}", ""))
                .andDo(print())
                .andExpect(status().isNoContent());
    }
    @Test
    public void getCapacitiesByName_id_9() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/admin/home/capacities?name={name}", "abcxyz"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }
    @Test
    public void getCapacitiesByName_id_11() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/admin/home/capacities?name={name}", "iphone 15 pro max"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
