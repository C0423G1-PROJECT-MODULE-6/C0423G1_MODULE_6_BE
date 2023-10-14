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
public class CustomerController_findCustomerById {
    @Autowired
    private MockMvc mockMvc;

    /**
     * Check case null Id
     * Author: NguyenNH
     * Goal: @throw Exception
     */
    @Test
    public void findCustomerById_id_1() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/admin/customer/list/{id}", (Object) null))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Check case empty Id
     * Author: NguyenNH
     * Goal: @throw Exception
     */
    @Test
    public void findCustomerById_id_2() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/admin/customer/list/{id}", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Check case Id does not exist in the database
     * Author: NguyenNH
     * Goal: @throw Exception
     */
    @Test
    public void findCustomerById_id_3() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/admin/customer/list/{id}", 1220))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Check case Id exists in the database
     * Author: NguyenNH
     * Goal: @return customer information
     */
    @Test
    public void findCustomerById_id_4() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/admin/customer/list/{id}", 2))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("idCustomer").value(2))
                .andExpect(jsonPath("nameCustomer").value("Nguyễn Hoàng Anh"))
                .andExpect(jsonPath("genderCustomer").value(false))
                .andExpect(jsonPath("emailCustomer").value("anh@gmail.com"))
                .andExpect(jsonPath("dateOfBirthCustomer").value("2022-10-10"))
                .andExpect(jsonPath("phoneNumberCustomer").value("098732165"))
                .andExpect(jsonPath("addressCustomer").value("Da Nang"))
                .andExpect(jsonPath("statusCustomer").value(true));
    }
}
