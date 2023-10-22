package com.example.c4zone.NghiaNPX.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.util.UriComponentsBuilder;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class SupplierController_getSupplierById {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    /**
     * author: NghiaNPX
     * date: 13/10/2023
     * goal: this function to test data of item [idSupplier]
     * with [idSupplier] = null
     * @throws Exception
     */
    @Test
    public void getSupplierById_idSupplier_1() throws Exception {
        Long id = null;
        UriComponentsBuilder builder = UriComponentsBuilder.fromPath("/api/admin/business/supplier/{id}");
        String url = builder.buildAndExpand(id).toUriString();
        this.mockMvc.perform(
                MockMvcRequestBuilders.get(url)
        ).andExpect(status().isBadRequest()).andDo(print());
    }

    /**
     * author: NghiaNPX
     * date: 13/10/2023
     * goal: this function to test data of item [idSupplier]
     * with [idSupplier] = ""
     * @throws Exception
     */
    @Test
    public void getSupplierById_idSupplier_2() throws Exception {
        String id = "";
        UriComponentsBuilder builder = UriComponentsBuilder.fromPath("/api/admin/business/supplier/{id}");
        String url = builder.buildAndExpand(id).toUriString();
        this.mockMvc.perform(
                MockMvcRequestBuilders.get(url)
        ).andExpect(status().isBadRequest()).andDo(print());
    }

    /**
     * author: NghiaNPX
     * date: 13/10/2023
     * goal: this function to test data of item [idSupplier]
     * with [idSupplier] was not in Database
     * @throws Exception
     */
    @Test
    public void getSupplierById_idSupplier_3() throws Exception {
        Long id = 100L;
        UriComponentsBuilder builder = UriComponentsBuilder.fromPath("/api/admin/business/supplier/{id}");
        String url = builder.buildAndExpand(id).toUriString();
        this.mockMvc.perform(
                MockMvcRequestBuilders.get(url)
        ).andExpect(status().isNotFound()).andDo(print());
    }

    /**
     * author: NghiaNPX
     * date: 13/10/2023
     * goal: this function to test data of item [idSupplier]
     * with [idSupplier] was in Database
     * @throws Exception
     */
    @Test
    public void getSupplierById_idSupplier_4() throws Exception {
        Long id = 5L;
        UriComponentsBuilder builder = UriComponentsBuilder.fromPath("/api/admin/business/supplier/{id}");
        String url = builder.buildAndExpand(id).toUriString();
        this.mockMvc.perform(
                MockMvcRequestBuilders.get(url)
        ).andExpect(status().is2xxSuccessful()).andDo(print());
    }
}
