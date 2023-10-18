package com.example.c4zone.product_quan_nd;

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
public class ProductControllerRemoveProduct {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void remove_id_07() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.patch("/api/admin/product/remove?id=null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void remove_id_08() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.patch("/api/admin/product/remove?id=ggg"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void remove_id_09() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.patch("/api/admin/product/remove?id=-1"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void remove_id_11() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.patch("/api/admin/product/remove?id=2"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

}
