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
public class OrderController_findProductAndChangeQuantity {

    @Autowired
    private MockMvc mockMvc;
    /**
     * Check case success
     * Author: ThoiND
     * Goal: update quantity of product
     */
    @Test
    public void findProductAndChangeQuantity_18() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/admin/order/cart/{idUser}/{idProduct}", 1,1)
                        .param("_quantity", "2"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
    /**
     * Check case quantity out of quantity product
     * Author: ThoiND
     * Goal: update quantity of product
     */
    @Test
    public void findProductAndChangeQuantity_16() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/admin/order/cart/{idUser}/{idProduct}", 1,1)
                        .param("_quantity", "555"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Check case quantity < 0
     * Author: ThoiND
     * Goal: update quantity of product
     */
    @Test
    public void findProductAndChangeQuantity_17() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/admin/order/cart/{idUser}/{idProduct}", 1,1)
                        .param("_quantity", "-1"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Check case quantity = 0
     * Author: ThoiND
     * Goal: update quantity of product
     */
    @Test
    public void findProductAndChangeQuantity_17_1() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/admin/order/cart/{idUser}/{idProduct}", 1,1)
                        .param("_quantity", "0"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

}
