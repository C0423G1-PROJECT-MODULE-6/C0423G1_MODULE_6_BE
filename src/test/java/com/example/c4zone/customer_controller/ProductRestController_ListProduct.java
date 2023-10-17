package com.example.c4zone.customer_controller;
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
public class ProductRestController_ListProduct {
    @Autowired
    private MockMvc mockMvc;
    /**
     * Check case there are no parameters passed in
     * Author: TinDT
     * Goal: @throw Exception
     */
    @Test
    public void getAll_11() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/admin/product/list")).andDo(print())
                .andExpect(jsonPath("totalPages").value(9))
                .andExpect(jsonPath("totalElements").value(45))
                .andExpect(jsonPath("content[0].id").value(39))
                .andExpect(jsonPath("content[0].name").value("Apple Watch SE 2023 GPS 44mm Sport Loop "))
                .andExpect(jsonPath("content[0].color").value("Xanh Đen Đậm"))
                .andExpect(jsonPath("content[0].cpu").value("Apple S8"))
                .andExpect(jsonPath("content[0].capacity").value("32GB"))
                .andExpect(jsonPath("content[0].quantity").value(10.0))
                .andExpect(jsonPath("content[0].camera").value("Không có"))
                .andExpect(jsonPath("content[0].price").value(7190000.0))
                .andExpect(status().is2xxSuccessful())
        ;
    }
    /**
     * Check case name is empty
     * Author: TinDT
     * workday: 12/10/2023
     * Goal: @throw Exception
     */
    @Test
    public void getAll_name_11() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/admin/product/list?choose=name&value=", "")).andDo(print())
                .andExpect(jsonPath("totalPages").value(9))
                .andExpect(jsonPath("totalElements").value(45))
                .andExpect(jsonPath("content[0].id").value(39))
                .andExpect(jsonPath("content[0].name").value("Apple Watch SE 2023 GPS 44mm Sport Loop "))
                .andExpect(jsonPath("content[0].color").value("Xanh Đen Đậm"))
                .andExpect(jsonPath("content[0].cpu").value("Apple S8"))
                .andExpect(jsonPath("content[0].capacity").value("32GB"))
                .andExpect(jsonPath("content[0].quantity").value(10.0))
                .andExpect(jsonPath("content[0].camera").value("Không có"))
                .andExpect(jsonPath("content[0].price").value(7190000.0))
                .andExpect(status().is2xxSuccessful())
        ;
    }
    /**
     * Check case page is null
     * Author: TinDT
     * Goal: @throw Exception
     */
    @Test
    public void getAll_page_07() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/admin/product/list&page=''")).andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Check case page is empty
     * Author: TinDT
     * Goal: @throw Exception
     */
    @Test
    public void getAll_page_08() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/admin/product/list&page=")).andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Check case page is negative number
     * Author: TinDT
     * Goal: @throw Exception
     */
    @Test
    public void getAll_page_09() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/admin/product/list&page=-1")).andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Check case name is exit database
     * Author: TinDT
     * Goal: @throw Exception
     */
    @Test
    public void getAll_page_10() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/admin/product/list?choose=name&value=DinhQuan&page=0")).andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Check case name is exit database
     * Author: TinDT
     * Goal: @throw Exception
     */
    @Test
    public void getAll_page_11() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/admin/product/list?page=0")).andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(9))
                .andExpect(jsonPath("totalElements").value(45))
                .andExpect(jsonPath("content[0].id").value(39))
                .andExpect(jsonPath("content[0].name").value("Apple Watch SE 2023 GPS 44mm Sport Loop"))
                .andExpect(jsonPath("content[0].color").value("Xanh Đen Đậm"))
                .andExpect(jsonPath("content[0].cpu").value("Apple S8"))
                .andExpect(jsonPath("content[0].capacity").value("32GB"))
                .andExpect(jsonPath("content[0].quantity").value(10.0))
                .andExpect(jsonPath("content[0].camera").value("Không có"))
                .andExpect(jsonPath("content[0].price").value(7190000.0))
        ;
    }
    /**
     * Check case choose is null
     * Author: TinDT
     * Goal: @throw Exception
     */
    @Test
    public void getAll_choose_7() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/admin/product/list?choose=''")).andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(9))
                .andExpect(jsonPath("totalElements").value(45))
                .andExpect(jsonPath("content[0].id").value(39))
                .andExpect(jsonPath("content[0].name").value("Apple Watch SE 2023 GPS 44mm Sport Loop "))
                .andExpect(jsonPath("content[0].color").value("Xanh Đen Đậm"))
                .andExpect(jsonPath("content[0].cpu").value("Apple S8"))
                .andExpect(jsonPath("content[0].capacity").value("32GB"))
                .andExpect(jsonPath("content[0].quantity").value(10.0))
                .andExpect(jsonPath("content[0].camera").value("Không có"))
                .andExpect(jsonPath("content[0].price").value(7190000.0))
        ;
    }
    /**
     * Check case choose is empty
     * Author: TinDT
     * Goal: @throw Exception
     */
    @Test
    public void getAll_choose_8() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/admin/product/list?choose=")).andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(9))
                .andExpect(jsonPath("totalElements").value(45))
                .andExpect(jsonPath("content[0].id").value(39))
                .andExpect(jsonPath("content[0].name").value("Apple Watch SE 2023 GPS 44mm Sport Loop "))
                .andExpect(jsonPath("content[0].color").value("Xanh Đen Đậm"))
                .andExpect(jsonPath("content[0].cpu").value("Apple S8"))
                .andExpect(jsonPath("content[0].capacity").value("32GB"))
                .andExpect(jsonPath("content[0].quantity").value(10.0))
                .andExpect(jsonPath("content[0].camera").value("Không có"))
                .andExpect(jsonPath("content[0].price").value(7190000.0))
        ;
    }
    /**
     * Check case choose is not available and has default value
     * Author: TinDT
     * Goal: @throw Exception
     */

    @Test
    public void getAll_choose_9() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/admin/product/list?choose=quan")).andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(9))
                .andExpect(jsonPath("totalElements").value(45))
                .andExpect(jsonPath("content[0].id").value(39))
                .andExpect(jsonPath("content[0].name").value("Apple Watch SE 2023 GPS 44mm Sport Loop "))
                .andExpect(jsonPath("content[0].color").value("Xanh Đen Đậm"))
                .andExpect(jsonPath("content[0].cpu").value("Apple S8"))
                .andExpect(jsonPath("content[0].capacity").value("32GB"))
                .andExpect(jsonPath("content[0].quantity").value(10.0))
                .andExpect(jsonPath("content[0].camera").value("Không có"))
                .andExpect(jsonPath("content[0].price").value(7190000.0))
        ;
    }
    /**
     * Check case sort is null
     * Author: TinDT
     * Goal: @throw Exception
     */

    @Test
    public void getAll_sort_07() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/admin/product/list?sort=''")).andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(9))
                .andExpect(jsonPath("totalElements").value(45))
                .andExpect(jsonPath("content[0].id").value(39))
                .andExpect(jsonPath("content[0].name").value("Apple Watch SE 2023 GPS 44mm Sport Loop "))
                .andExpect(jsonPath("content[0].color").value("Xanh Đen Đậm"))
                .andExpect(jsonPath("content[0].cpu").value("Apple S8"))
                .andExpect(jsonPath("content[0].capacity").value("32GB"))
                .andExpect(jsonPath("content[0].quantity").value(10.0))
                .andExpect(jsonPath("content[0].camera").value("Không có"))
                .andExpect(jsonPath("content[0].price").value(7190000.0))
        ;
    }

    /**
     * Check case sort is not exits and has default value
     * Author: TinDT
     * Goal: @throw Exception
     */
    @Test
    public void getAll_sort_09() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/admin/product/list?sort=abczyz")).andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(9))
                .andExpect(jsonPath("totalElements").value(45))
                .andExpect(jsonPath("content[0].id").value(39))
                .andExpect(jsonPath("content[0].name").value("Apple Watch SE 2023 GPS 44mm Sport Loop "))
                .andExpect(jsonPath("content[0].color").value("Xanh Đen Đậm"))
                .andExpect(jsonPath("content[0].cpu").value("Apple S8"))
                .andExpect(jsonPath("content[0].capacity").value("32GB"))
                .andExpect(jsonPath("content[0].quantity").value(10.0))
                .andExpect(jsonPath("content[0].camera").value("Không có"))
                .andExpect(jsonPath("content[0].price").value(7190000.0))
        ;
    }


    /**
     * Check case success when sort is type
     * Author: TinDT
     * Goal: @throw Exception
     */
    @Test
    public void getAll_sort_type_11() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/admin/product/list?sort=type")).andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(9))
                .andExpect(jsonPath("totalElements").value(45))
                .andExpect(jsonPath("content[0].id").value(36))
                .andExpect(jsonPath("content[0].name").value("Ipad Air 5 Wifi 64GB"))
                .andExpect(jsonPath("content[0].color").value("Trắng"))
                .andExpect(jsonPath("content[0].cpu").value("Apple M1"))
                .andExpect(jsonPath("content[0].capacity").value("64GB"))
                .andExpect(jsonPath("content[0].quantity").value(10))
                .andExpect(jsonPath("content[0].camera").value("12MP"))
                .andExpect(jsonPath("content[0].price").value(1.439E7))
        ;
    }
    /**
     * Check case success when sort is price and default value
     * Author: TinDT
     * Goal: @throw Exception
     */
    @Test
    public void getAll_sort_price_11() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/admin/product/list?sort=price")).andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(9))
                .andExpect(jsonPath("totalElements").value(45))
                .andExpect(jsonPath("content[0].id").value(42))
                .andExpect(jsonPath("content[0].name").value("Apple Watch SE 2023 GPS 40mm Sport Band"))
                .andExpect(jsonPath("content[0].color").value("Xanh Đen Đậm"))
                .andExpect(jsonPath("content[0].cpu").value("Apple S8"))
                .andExpect(jsonPath("content[0].capacity").value("32GB"))
                .andExpect(jsonPath("content[0].quantity").value(10.0))
                .andExpect(jsonPath("content[0].camera").value("Không có"))
                .andExpect(jsonPath("content[0].price").value(6390000.0))
        ;
    }
    /**
     * Check case success when sort is quantity and default value
     * Author: TinDT
     * Goal: @throw Exception
     */
    @Test
    public void getAll_sort_quantity_11() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/admin/product/list?sort=quantity")).andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(9))
                .andExpect(jsonPath("totalElements").value(45))
                .andExpect(jsonPath("content[0].id").value(2))
                .andExpect(jsonPath("content[0].name").value("iPhone 13 256GB"))
                .andExpect(jsonPath("content[0].color").value("Trắng"))
                .andExpect(jsonPath("content[0].cpu").value("Apple A15 Bionic"))
                .andExpect(jsonPath("content[0].capacity").value("256GB"))
                .andExpect(jsonPath("content[0].quantity").value(10.0))
                .andExpect(jsonPath("content[0].camera").value("12 MP"))
                .andExpect(jsonPath("content[0].price").value(1.949E7))
        ;
    }


}
