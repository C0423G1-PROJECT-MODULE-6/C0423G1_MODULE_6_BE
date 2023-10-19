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
public class WarehouseController_findSupplierById {

    @Autowired
    private MockMvc mockMvc;

    /**
     * method: Test id parameter is null
     * author: PhapTM
     * @throws Exception
     */

    @Test
    public void findSupplierById_NO_1() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/api/admin/warehouse/supplier/"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * method: Test id parameter is empty
     * author: PhapTM
     * @throws Exception
     */
    @Test
    public void findSupplierById_NO_2() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/api/admin/warehouse/supplier/{id}", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * method: Test id parameter is not found
     * author: PhapTM
     * @throws Exception
     */
    @Test
    public void findSupplierById_NO_3() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/api/admin/warehouse/supplier/{id}", "10"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * method: Test id parameter is successfully
     * author: PhapTM
     * @throws Exception
     */
    @Test public void findSupplierById_NO_4() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/api/admin/warehouse/supplier/{id}", "2"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("id").value(1))
                .andExpect(jsonPath("name_supplier").value("apple"));
    }
}
