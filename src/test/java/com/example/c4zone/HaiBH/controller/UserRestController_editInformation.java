package com.example.c4zone.HaiBH.controller;

import com.example.c4zone.dto.user.UserInfoDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.sql.Date;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserRestController_editInformation {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    /**
     * Creator: Bui Huu Hai
     * Goal: userInfoDto = null
     * @Throw: Exception
     */
    @Test
    public void editInformation_object_19 () throws Exception {

//        UserInfoDto userInfoDto = null;

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .put( "/api/user/information/edit")
                                .content(this.objectMapper.writeValueAsString(null))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Creator: Bui Huu Hai
     * Goal: userInfoDto = ""
     * @Throw: Exception
     */
    @Test
    public void editInformation_object_20 () throws Exception {

        UserInfoDto userInfoDto = new UserInfoDto();
        userInfoDto.setEmail("");
        userInfoDto.setEmployeeAddress("");
        userInfoDto.setEmployeePhone("");
        userInfoDto.setEmployeeName("");


        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .put( "/api/user/information/edit")
                                .content(this.objectMapper.writeValueAsString(userInfoDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Creator: Bui Huu Hai
     * Goal: phone = String
     * @Throw: Exception
     */
    @Test
    public void editInformation_phone_21 () throws Exception {

        UserInfoDto userInfoDto = new UserInfoDto();
        userInfoDto.setEmail("buihuhai318@gmail.com");
        userInfoDto.setEmployeeAddress("da nang");
        userInfoDto.setEmployeePhone("string");
        userInfoDto.setEmployeeName("Bui Huu Hai");;
        userInfoDto.setEmployeeBirthday(Date.valueOf("1996-08-31"));

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .put( "/api/user/information/edit")
                                .content(this.objectMapper.writeValueAsString(userInfoDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Creator: Bui Huu Hai
     * Goal: name = 1 letter
     * @Throw: Exception
     */
    @Test
    public void editInformation_name_22 () throws Exception {

        UserInfoDto userInfoDto = new UserInfoDto();
        userInfoDto.setEmail("buihuhai318@gmail.com");
        userInfoDto.setEmployeeAddress("da nang");
        userInfoDto.setEmployeePhone("string");
        userInfoDto.setEmployeeName("hai");;
        userInfoDto.setEmployeeBirthday(Date.valueOf("1996-08-31"));

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .put( "/api/user/information/edit")
                                .content(this.objectMapper.writeValueAsString(userInfoDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Creator: Bui Huu Hai
     * Goal: phone = more than 10 number
     * @Throw: Exception
     */
    @Test
    public void editInformation_phone_23 () throws Exception {

        UserInfoDto userInfoDto = new UserInfoDto();
        userInfoDto.setEmail("buihuhai318@gmail.com");
        userInfoDto.setEmployeeAddress("da nang");
        userInfoDto.setEmployeePhone("0942409424123");
        userInfoDto.setEmployeeName("Bui Huu Hai");;
        userInfoDto.setEmployeeBirthday(Date.valueOf("1996-08-31"));

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .put( "/api/user/information/edit")
                                .content(this.objectMapper.writeValueAsString(userInfoDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Creator: Bui Huu Hai
     * Goal: userInfoDto = valid, successfully
     * @Throw: Exception
     */
    @Test
    public void editInformation_object_24 () throws Exception {

        UserInfoDto userInfoDto = new UserInfoDto();
        userInfoDto.setEmail("buihuhai3108@gmail.com");
        userInfoDto.setEmployeeAddress("da nang");
        userInfoDto.setEmployeePhone("0942409424");
        userInfoDto.setEmployeeName("Bui Huu Hai");;
        userInfoDto.setEmployeeBirthday(Date.valueOf("2005-10-10"));

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .put( "/api/user/information/edit")
                                .content(this.objectMapper.writeValueAsString(userInfoDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
