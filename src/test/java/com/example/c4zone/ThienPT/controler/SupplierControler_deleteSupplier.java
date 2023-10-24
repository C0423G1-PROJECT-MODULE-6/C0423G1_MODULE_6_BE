package com.example.c4zone.ThienPT.controler;

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
class SupplierControler_deleteSupplier {
    @Autowired
    private MockMvc mockMvc;


    /**
     * author: ThienPT
     * date : 13/10/2023
     * goal: Check case success delete supplier
     * @throws Exception
     * */

    @Test
    void deleteSupplier_id_28() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.delete("/api/admin/business/supplier/{id}",2)
        ).andExpect(status().is2xxSuccessful());
    }

    /**
     * author: ThienPT
     * date : 13/10/2023
     * goal: Check case success delete supplier
     * with [id] is null
     *
     * @throws Exception
     * */

    @Test
     void deleteSupplier_id_25() throws Exception{
        Long id=null;
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .delete("/api/admin/business/supplier/{id}",id)
        ).andExpect(status().is4xxClientError()).andDo(print());
    }


    /**
     * author: ThienPT
     * date : 13/10/2023
     * goal: Check case success delete supplier
     * with [id] is empty string
     *
     * @throws Exception
     * */

    @Test
    void deleteSupplier_id_26() throws Exception{
        String id = "";
        UriComponentsBuilder builder = UriComponentsBuilder.fromPath("/api/admin/business/supplier/{id}");
        String url = builder.buildAndExpand(id).toUriString();
        this.mockMvc.perform(
                MockMvcRequestBuilders.delete(url)
        ).andExpect(status().is4xxClientError()).andDo(print());
    }

    /**
     * author: ThienPT
     * date : 13/10/2023
     * goal: Check case success delete supplier
     * with [id] can not find in data supplier
     *
     * @throws Exception
     * */

    @Test
    void deleteSupplier_id_27() throws Exception{
        this.mockMvc.perform(
                MockMvcRequestBuilders.delete("/api/admin/business/supplier/{id}",1000)
        ).andExpect(status().isNotFound()).andDo(print());
    }
}
