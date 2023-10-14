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
public class UserRestController_getIdByAppUserName {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getIdByAppUserName_userName_1 () throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get( "/api/user/get-id-app-user/{userName}", (Object) null))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getIdByAppUserName_username_2 () throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get( "/api/user/get-id-app-user/{userName}", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getIdByAppUserName_username_3 () throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get( "/api/user/get-id-app-user/{userName}", "wrong"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getIdByAppUserName_username_4 () throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get( "/api/user/get-id-app-user/{userName}", "admin"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
