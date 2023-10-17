package com.example.c4zone.HaiBH.controller;

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
public class UserRestController_showInformation {

    @Autowired
    private MockMvc mockMvc;

    /**
     * Creator: Bui Huu Hai
     * Goal: [id] = null
     * @Throw: Exception
     */
    @Test
    public void showInformation_id_1 () throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get( "/api/user/information/{id}", (Object) null))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Creator: Bui Huu Hai
     * Goal: [id] = ""
     * @Throw: Exception
     */
    @Test
    public void showInformation_id_2 () throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get( "/api/user/information/{id}", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Creator: Bui Huu Hai
     * Goal: [id] = not exist in DB
     * @Throw: Exception
     */
    @Test
    public void showInformation_id_3 () throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get( "/api/user/information/{id}", 1))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Creator: Bui Huu Hai
     * Goal: [id] = exist in DB, successful
     * @Throw: Exception
     */
    @Test
    public void showInformation_id_4 () throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get( "/api/user/information/{id}", 2))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("id").value(2))
                .andExpect(jsonPath("userName").value("admin"))
                .andExpect(jsonPath("employeeName").value("hai admin"))
                .andExpect(jsonPath("employeePhone").value("0942409424"))
                .andExpect(jsonPath("employeeBirthday").value("1996-08-31"))
                .andExpect(jsonPath("email").value("buihuuhai318@gmail.com"))
                .andExpect(jsonPath("employeeAddress").value("da nang"));
    }
}
