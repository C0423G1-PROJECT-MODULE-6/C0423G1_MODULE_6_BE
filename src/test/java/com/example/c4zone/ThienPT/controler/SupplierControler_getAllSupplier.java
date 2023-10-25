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
 class SupplierControler_getAllSupplier {
    @Autowired
    private MockMvc mockMvc;

    /**
     * author: ThienPT
     * date : 13/10/2023
     * Check case success display list supplier
     *
     * @throws Exception
     * */

    @Test
     void getAllStudent_6() throws  Exception{
        this.mockMvc.perform(
                MockMvcRequestBuilders.get(
                        "/api/admin/business/supplier?_page=0&_limit=3&name_like=&addressSearch=&emailSearch="
                )
        ).andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("content[0].idSupplier").value(26))
                .andExpect(jsonPath("content[0].nameSupplier").value("Phan Thanh Thien"))
                .andExpect(jsonPath("content[0].addressSupplier").value("1"))
                .andExpect(jsonPath("content[0].phoneNumberSupplier").value("0906438630"))
                .andExpect(jsonPath("content[0].emailSupplier").value("thien@gmail.com"))
                .andExpect(jsonPath("content[0].statusSupplier").value(true));
    }

    /**
     * author: ThienPT
     * date : 13/10/2023
     * Check case empty list supplier
     *
     * @throws Exception
     * */

    @Test
    void getAllStudent_5() throws  Exception{
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/api/admin/business/supplier?_page=0&_limit=3&name_like=&addressSearch=&emailSearch=")
        ).andDo(print())
                .andExpect(status().isNotFound());
    }

    /**
     * author: ThienPT
     * date : 13/10/2023
     * goal: Check case page in url null in supplier
     * with [page] is null
     *
     * @throws Exception
     * */

    @Test
    void getAllStudent_page_1() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/admin/business/supplier")
                                .param("_page", (String) null)
                                .param("_limit", "3")
                                .param("name_like", "")
                                .param("addressSearch", "")
                                .param("emailSearch", "")
                ).andExpect(status().isBadRequest())
                .andDo(print());
    }

    /**
     * author: ThienPT
     * date : 13/10/2023
     * goal: Check case page in url not found in supplier
     * with [page] not found in data
     *
     * @throws Exception
     * */

    @Test
    void getAllStudent_page_2() throws  Exception{
        this.mockMvc.perform(
                MockMvcRequestBuilders.get(("/api/admin/business/supplier?_page=10&_limit=3&name_like=&addressSearch=&emailSearch="))
        ).andExpect(status().isNoContent()).andDo(print());
    }

    /**
     * author: ThienPT
     * date : 13/10/2023
     * goal: Check case page in url null in supplier
     * with [addressSearch] is null
     *
     * @throws Exception
     * */

    @Test
    void getAllStudent_addressSearch_1() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/admin/business/supplier")
                                .param("_page", "0")
                                .param("_limit", "3")
                                .param("name_like", "")
                                .param("addressSearch", (String) null)
                                .param("emailSearch", "" )
                ).andExpect(status().isBadRequest())
                .andDo(print());
    }

    /**
     * author: ThienPT
     * date : 13/10/2023
     * goal: Check case page in url not found in supplier
     * with [addressSearch] not found in data
     *
     * @throws Exception
     * */

    @Test
    void getAllStudent_addressSearch_2() throws  Exception{
        this.mockMvc.perform(
                MockMvcRequestBuilders.get(("/api/admin/business/supplier?_page=0&_limit=3&name_like=&addressSearch=zzz&emailSearch="))
        ).andExpect(status().isNoContent()).andDo(print());
    }

    /**
     * author: ThienPT
     * date : 13/10/2023
     * goal: Check case page in url null in supplier
     * with [email] is null
     *
     * @throws Exception
     * */

    @Test
    void getAllStudent_email_1() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/admin/business/supplier")
                                .param("_page", "0")
                                .param("_limit", "3")
                                .param("name_like", "")
                                .param("addressSearch", "")
                                .param("emailSearch", (String) null)
                ).andExpect(status().isBadRequest())
                .andDo(print());
    }

    /**
     * author: ThienPT
     * date : 13/10/2023
     * goal: Check case page in url not found in supplier
     * with [addressSearch] not found in data
     *
     * @throws Exception
     * */

    @Test
    void getAllStudent_email_2() throws  Exception{
        this.mockMvc.perform(
                MockMvcRequestBuilders.get(("/api/admin/business/supplier?_page=0&_limit=3&name_like=&addressSearch=&emailSearch=no-content"))
        ).andExpect(status().isNoContent()).andDo(print());
    }
}


