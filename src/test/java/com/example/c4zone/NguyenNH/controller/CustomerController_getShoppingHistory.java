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


    /**
     * Check case null Id
     * Author: NguyenNH
     * Goal: @throw Exception
     */
    @Test
    public void getShoppingHistory_id_7() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/admin/customer/history/{id}", (Object) null)
                        .param("_limit", "3")
                        .param("_page", "0"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Check case empty Id
     * Author: NguyenNH
     * Goal: @throw Exception
     */
    @Test
    public void getShoppingHistory_id_8() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/admin/customer/history/{id}", "")
                        .param("_limit", "3")
                        .param("_page", "0"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Check case Id does not exist in the database
     * Author: NguyenNH
     * Goal: @throw Exception
     */
    @Test
    public void getShoppingHistory_id_9() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/admin/customer/history/{id}", 55)
                        .param("_limit", "3")
                        .param("_page", "0"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Check case Id exists in the database but no results are returned
     * Author: NguyenNH
     * Goal: @throw Exception
     */
    @Test
    public void getShoppingHistory_id_10() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/admin/customer/history/{id}", 10)
                        .param("_limit", "3")
                        .param("_page", "0"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Check case Id exists in the database
     * Author: NguyenNH
     * Goal: @return purchase history of customer
     */
    @Test
    public void getShoppingHistory_id_11() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/admin/customer/history/{id}", 1)
                        .param("_limit", "3")
                        .param("_page", "0"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("content[0].dateOfOrder").value("2023-02-10"))
                .andExpect(jsonPath("content[0].nameProduct").value("iPhone 12 128GB"))
                .andExpect(jsonPath("content[0].priceOrder").value("3000.0"))

                .andExpect(jsonPath("content[1].dateOfOrder").value("2008-02-10"))
                .andExpect(jsonPath("content[1].nameProduct").value("iPhone 12 128GB"))
                .andExpect(jsonPath("content[1].priceOrder").value("123123.0"));
    }

    /**
     * Check case limit null
     * Author: NguyenNH
     * Goal: @throw Exception
     */
    @Test
    public void getShoppingHistory_limit_7() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/admin/customer/history/{id}", 1)
                        .param("_limit", (String) null)
                        .param("_page", "0"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Check case limit empty
     * Author: NguyenNH
     * Goal: @throw Exception
     */
    @Test
    public void getShoppingHistory_limit_8() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/admin/customer/history/{id}", 1)
                        .param("_limit", "")
                        .param("_page", "0"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Check case limit exist
     * Author: NguyenNH
     * Goal: @return purchase history of customer
     */
    @Test
    public void getShoppingHistory_limit_11() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/admin/customer/history/{id}", 1)
                        .param("_limit", "5")
                        .param("_page", "0"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("content[0].dateOfOrder").value("2023-02-10"))
                .andExpect(jsonPath("content[0].nameProduct").value("iPhone 12 128GB"))
                .andExpect(jsonPath("content[0].priceOrder").value("3000.0"));
    }

    /**
     * Check case page null
     * Author: NguyenNH
     * Goal: @throw Exception
     */
    @Test
    public void getShoppingHistory_page_7() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/admin/customer/history/{id}", 1)
                        .param("_limit", "5")
                        .param("_page", (String) null))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Check case page empty
     * Author: NguyenNH
     * Goal: @throw Exception
     */
    @Test
    public void getShoppingHistory_page_8() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/admin/customer/history/{id}", 1)
                        .param("_limit", "5")
                        .param("_page", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Check case page not exist
     * Author: NguyenNH
     * Goal: @throw Exception
     */
    @Test
    public void getShoppingHistory_page_9() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/admin/customer/history/{id}", 1)
                        .param("_limit", "5")
                        .param("_page", "55"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Check case page exist
     * Author: NguyenNH
     * Goal: @return purchase history of customer
     */
    @Test
    public void getShoppingHistory_page_11() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/admin/customer/history/{id}", 1)
                        .param("_limit", "5")
                        .param("_page", "0"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("content[1].dateOfOrder").value("2008-02-10"))
                .andExpect(jsonPath("content[1].nameProduct").value("iPhone 12 128GB"))
                .andExpect(jsonPath("content[1].priceOrder").value("123123.0"));
    }

    /**
     * Check case name not exist in the database
     * Author: NguyenNH
     * Goal: @throw Exception
     */
    @Test
    public void getShoppingHistory_name_9() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/admin/customer/history/{id}", 1)
                        .param("_limit", "5")
                        .param("_page", "0")
                        .param("name_like", "Không có trong DB"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Check case name exist in the database
     * Author: NguyenNH
     * Goal: @return purchase history of customer
     */
    @Test
    public void getShoppingHistory_name_11() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/admin/customer/history/{id}", 1)
                        .param("_limit", "5")
                        .param("_page", "0")
                        .param("name_like", "iPhone"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("content[0].dateOfOrder").value("2023-02-10"))
                .andExpect(jsonPath("content[0].nameProduct").value("iPhone 12 128GB"))
                .andExpect(jsonPath("content[0].priceOrder").value("3000.0"));
    }
}
