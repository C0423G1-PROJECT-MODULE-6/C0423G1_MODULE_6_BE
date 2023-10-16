package com.example.c4zone.ThienPT.controler;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class SupplierControler_deleteSupplier {
    @Autowired
    private MockMvc mockMvc;


    /**
     * Check case success delete supplier
     * @throws Exception
     * */

    @Test
    public void deleteSupplier_id_28() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.delete("/api/admin/supplier/{id}",2)
        ).andExpect(status().is2xxSuccessful());
    }

    /**
     * Check case id=null in  delete supplier
     * @throws Exception
     * */

    @Test
    public void deleteSupplier_id_25() throws Exception{
        this.mockMvc.perform(
                MockMvcRequestBuilders.delete("/api/admin/supplier/{id}","null")
        ).andExpect(status().isBadRequest());
    }

    /**
     * Check case id empty in  delete supplier
     * @throws Exception
     * */

    @Test
    public void deleteSupplier_id_26() throws Exception{
        this.mockMvc.perform(
                MockMvcRequestBuilders.delete("/api/admin/supplier/{id}","")
        ).andExpect(status().isMethodNotAllowed());
    }

    /**
     * Check case id not found in  delete supplier
     * @throws Exception
     * */

    @Test
    public void deleteSupplier_id_27() throws Exception{
        this.mockMvc.perform(
                MockMvcRequestBuilders.delete("/api/admin/supplier/{id}",3)
        ).andExpect(status().isNotFound());
    }
}
