package com.example.c4zone.PhapTMController;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
public class WarehouseController_findAll {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void findAllWarehouse_page_5() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/admin/warehouse"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void findAllWarehouse_page_6() throws Exception{
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/api/admin/warehouse"))
                .andDo(print())
                .andExpect(jsonPath("totalPages").value(2))
                .andExpect(jsonPath("totalElements").value(6))
                .andExpect(jsonPath("content[0].idWarehouse").value(1))
                .andExpect(jsonPath("content[0].inputDate").value("12-10-2023"))
                .andExpect(jsonPath("content[0].quantity").value(100))
                .andExpect(jsonPath("content[0].nameProduct").value("iPhone 15 Pro 512GB"))
                .andExpect(jsonPath("content[0].priceProduct").value(3.659E7))
                .andExpect(jsonPath("content[0].nameSupplier").value("apple"))
                .andExpect(jsonPath("content[0].totalPrice").value(3.659E9))
                .andExpect(status().is2xxSuccessful());

    }
    @Test
    public void findAllWarehouse_name_11() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/admin/warehouse?choose=name&value=", "")).andDo(print())
                .andExpect(jsonPath("totalPages").value(2))
                .andExpect(jsonPath("totalElements").value(6))
                .andExpect(jsonPath("content[0].idWarehouse").value(1))
                .andExpect(jsonPath("content[0].inputDate").value("12-10-2023"))
                .andExpect(jsonPath("content[0].quantity").value(100))
                .andExpect(jsonPath("content[0].nameProduct").value("iPhone 15 Pro 512GB"))
                .andExpect(jsonPath("content[0].priceProduct").value(3.659E7))
                .andExpect(jsonPath("content[0].nameSupplier").value("apple"))
                .andExpect(jsonPath("content[0].totalPrice").value(3.659E9))
                .andExpect(status().is2xxSuccessful());
    }
    @Test
    public void findAll_page_07() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/admin/warehouse&page=null")).andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void findAll_page_08() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/admin/warehouse&page=")).andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void findAll_page_09() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/admin/warehouse&page=-1")).andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void findAll_page_10() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/admin/warehouse?choose=name&value=Samsung&page=0")).andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void findAll_choose_name_11() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/admin/ưwarehouse?choose=name&value=#")).andDo(print())
                .andExpect(status().is4xxClientError())
        ;
    }
    @Test
    public void findAll_page_11() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/admin/warehouse?page=0")).andDo(print())
                .andExpect(jsonPath("totalPages").value(2))
                .andExpect(jsonPath("totalElements").value(6))
                .andExpect(jsonPath("content[0].idWarehouse").value(1))
                .andExpect(jsonPath("content[0].inputDate").value("12-10-2023"))
                .andExpect(jsonPath("content[0].quantity").value(100))
                .andExpect(jsonPath("content[0].nameProduct").value("iPhone 15 Pro 512GB"))
                .andExpect(jsonPath("content[0].priceProduct").value(3.659E7))
                .andExpect(jsonPath("content[0].nameSupplier").value("apple"))
                .andExpect(jsonPath("content[0].totalPrice").value(3.659E9))
                .andExpect(status().is2xxSuccessful());
    }
    @Test
    public void findAll_choose_7() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/admin/warehouse?choose=null")).andDo(print())
                .andExpect(jsonPath("totalPages").value(2))
                .andExpect(jsonPath("totalElements").value(6))
                .andExpect(jsonPath("content[0].idWarehouse").value(1))
                .andExpect(jsonPath("content[0].inputDate").value("12-10-2023"))
                .andExpect(jsonPath("content[0].quantity").value(100))
                .andExpect(jsonPath("content[0].nameProduct").value("iPhone 15 Pro 512GB"))
                .andExpect(jsonPath("content[0].priceProduct").value(3.659E7))
                .andExpect(jsonPath("content[0].nameSupplier").value("apple"))
                .andExpect(jsonPath("content[0].totalPrice").value(3.659E9))
                .andExpect(status().is2xxSuccessful());
    }
    @Test
    public void findAll_choose_8() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/admin/warehouse?choose=")).andDo(print())
                .andExpect(jsonPath("totalPages").value(2))
                .andExpect(jsonPath("totalElements").value(6))
                .andExpect(jsonPath("content[0].idWarehouse").value(1))
                .andExpect(jsonPath("content[0].inputDate").value("12-10-2023"))
                .andExpect(jsonPath("content[0].quantity").value(100))
                .andExpect(jsonPath("content[0].nameProduct").value("iPhone 15 Pro 512GB"))
                .andExpect(jsonPath("content[0].priceProduct").value(3.659E7))
                .andExpect(jsonPath("content[0].nameSupplier").value("apple"))
                .andExpect(jsonPath("content[0].totalPrice").value(3.659E9))
                .andExpect(status().is2xxSuccessful());
    }
    @Test
    public void findAll_choose_11() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/admin/warehouse?choose=name")).andDo(print())
                .andExpect(jsonPath("totalPages").value(2))
                .andExpect(jsonPath("totalElements").value(6))
                .andExpect(jsonPath("content[0].idWarehouse").value(1))
                .andExpect(jsonPath("content[0].inputDate").value("12-10-2023"))
                .andExpect(jsonPath("content[0].quantity").value(100))
                .andExpect(jsonPath("content[0].nameProduct").value("iPhone 15 Pro 512GB"))
                .andExpect(jsonPath("content[0].priceProduct").value(3.659E7))
                .andExpect(jsonPath("content[0].nameSupplier").value("apple"))
                .andExpect(jsonPath("content[0].totalPrice").value(3.659E9))
                .andExpect(status().is2xxSuccessful());
    }
    @Test
    public void findAll_sort_07() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/admin/warehouse?sort=null")).andDo(print())
                .andExpect(jsonPath("totalPages").value(2))
                .andExpect(jsonPath("totalElements").value(6))
                .andExpect(jsonPath("content[0].idWarehouse").value(1))
                .andExpect(jsonPath("content[0].inputDate").value("12-10-2023"))
                .andExpect(jsonPath("content[0].quantity").value(100))
                .andExpect(jsonPath("content[0].nameProduct").value("iPhone 15 Pro 512GB"))
                .andExpect(jsonPath("content[0].priceProduct").value(3.659E7))
                .andExpect(jsonPath("content[0].nameSupplier").value("apple"))
                .andExpect(jsonPath("content[0].totalPrice").value(3.659E9))
                .andExpect(status().is2xxSuccessful());
    }
    @Test
    public void findAll_sort_09() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/admin/warehouse?sort=")).andDo(print())
                .andExpect(jsonPath("totalPages").value(2))
                .andExpect(jsonPath("totalElements").value(6))
                .andExpect(jsonPath("content[0].idWarehouse").value(1))
                .andExpect(jsonPath("content[0].inputDate").value("12-10-2023"))
                .andExpect(jsonPath("content[0].quantity").value(100))
                .andExpect(jsonPath("content[0].nameProduct").value("iPhone 15 Pro 512GB"))
                .andExpect(jsonPath("content[0].priceProduct").value(3.659E7))
                .andExpect(jsonPath("content[0].nameSupplier").value("apple"))
                .andExpect(jsonPath("content[0].totalPrice").value(3.659E9))
                .andExpect(status().is2xxSuccessful());
    }
    @Test
    public void findAll_sort_name_11() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/admin/warehouse?sort=name")).andDo(print())
                .andExpect(jsonPath("totalPages").value(2))
                .andExpect(jsonPath("totalElements").value(6))
                .andExpect(jsonPath("content[0].idWarehouse").value(1))
                .andExpect(jsonPath("content[0].inputDate").value("12-10-2023"))
                .andExpect(jsonPath("content[0].quantity").value(100))
                .andExpect(jsonPath("content[0].nameProduct").value("iPhone 15 Pro 512GB"))
                .andExpect(jsonPath("content[0].priceProduct").value(3.659E7))
                .andExpect(jsonPath("content[0].nameSupplier").value("apple"))
                .andExpect(jsonPath("content[0].totalPrice").value(3.659E9))
                .andExpect(status().is2xxSuccessful());
    }
    @Test
    public void findAll_sort_price_11() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/admin/warehouse?sort=price")).andDo(print())
                .andExpect(jsonPath("totalPages").value(2))
                .andExpect(jsonPath("totalElements").value(6))
                .andExpect(jsonPath("content[0].idWarehouse").value(1))
                .andExpect(jsonPath("content[0].inputDate").value("12-10-2023"))
                .andExpect(jsonPath("content[0].quantity").value(100))
                .andExpect(jsonPath("content[0].nameProduct").value("iPhone 15 Pro 512GB"))
                .andExpect(jsonPath("content[0].priceProduct").value(3.659E7))
                .andExpect(jsonPath("content[0].nameSupplier").value("apple"))
                .andExpect(jsonPath("content[0].totalPrice").value(3.659E9))
                .andExpect(status().is2xxSuccessful());
    }
    @Test
    public void findAll_sort_supplier_11() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/admin/warehouse?sort=supplier")).andDo(print())
                .andExpect(jsonPath("totalPages").value(2))
                .andExpect(jsonPath("totalElements").value(6))
                .andExpect(jsonPath("content[0].idWarehouse").value(1))
                .andExpect(jsonPath("content[0].inputDate").value("12-10-2023"))
                .andExpect(jsonPath("content[0].quantity").value(100))
                .andExpect(jsonPath("content[0].nameProduct").value("iPhone 15 Pro 512GB"))
                .andExpect(jsonPath("content[0].priceProduct").value(3.659E7))
                .andExpect(jsonPath("content[0].nameSupplier").value("apple"))
                .andExpect(jsonPath("content[0].totalPrice").value(3.659E9))
                .andExpect(status().is2xxSuccessful());
    }

}
