package com.example.c4zone.HaiBH.controller;

import com.example.c4zone.dto.user.AppUserDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserRestController_register {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void register_object_19 () throws Exception {

//        AppUserDto appUserDto = null;

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .put( "/api/user/register")
                                .content(this.objectMapper.writeValueAsString(null))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void register_object_20 () throws Exception {

        AppUserDto appUserDto = new AppUserDto();
        appUserDto.setUserName("");
        appUserDto.setPassword("");

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .put( "/api/user/register")
                                .content(this.objectMapper.writeValueAsString(appUserDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void register_object_24 () throws Exception {

        AppUserDto appUserDto = new AppUserDto();
        appUserDto.setUserName("admin");
        appUserDto.setPassword("123");

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .put( "/api/user/register")
                                .content(this.objectMapper.writeValueAsString(appUserDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
