package com.example.c4zone.order;

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
public class OrderController_getAllCart {

    @Autowired
    private MockMvc mockMvc;
    /**
     * Check case null
     * Author: ThoiND
     * Goal: throw exception
     */
    @Test
    public void getAllCart_idUser_1() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/admin/order/cart/{id}", (Object) null))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Check case empty
     * Author: ThoiND
     * Goal: throw exception
     */
    @Test
    public void getAllCart_idUser_2() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                .get("/api/admin/order/cart/{id}",""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Check case not exist
     * Author: ThoiND
     * Goal: throw exception
     */
    @Test
    public void getAllCart_idUser_3() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/admin/order/cart/{id}", 10))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Check case exist
     * Author: ThoiND
     * Goal: return List cart
     */
    @Test
    public void getAllCart_idUser_4() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/admin/order/cart/{id}", 1))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$[0].idCart").value(29));
    }
}
