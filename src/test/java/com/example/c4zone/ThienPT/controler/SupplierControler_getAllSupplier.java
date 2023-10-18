package com.example.c4zone.ThienPT.controler;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import javax.persistence.Column;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class SupplierControler_getAllSupplier {
    @Autowired
    private MockMvc mockMvc;

    /**
     * Check case success display list supplier
     * @throws Exception
     * */

    @Test
    public void getAllStudent_6() throws  Exception{
        this.mockMvc.perform(
                MockMvcRequestBuilders.get(
                        "/api/admin/supplier?_page=0&_limit=3&name_like=&addressSearch=&emailSearch="
                )
        ).andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("content[0].idSupplier").value(1))
                .andExpect(jsonPath("content[0].codeSupplier").value(202301))
                .andExpect(jsonPath("content[0].nameSupplier").value("Công Ty TNHH Bao La"))
                .andExpect(jsonPath("content[0].addressSupplier").value("Thành phố Hồ Chí Minh"))
                .andExpect(jsonPath("content[0].phoneNumberSupplier").value("02835119060"))
                .andExpect(jsonPath("content[0].emailSupplier").value("baolamobile@gmail.com"))
                .andExpect(jsonPath("content[0].statusSupplier").value(false));
    }

    /**
     * Check case empty list supplier
     * @throws Exception
     * */

    @Test
    public void getAllStudent_5() throws  Exception{
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/api/admin/supplier?_page=0&_limit=3&name_like=&addressSearch=&emailSearch=")
        ).andDo(print())
                .andExpect(status().isNotFound());
    }
}
