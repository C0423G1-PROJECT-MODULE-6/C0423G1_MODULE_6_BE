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
public class UserRestController_logout {

    @Autowired
    private MockMvc mockMvc;

    /**
     * Creator: Bui Huu Hai
     * Goal: username = null
     * @Throw: Exception
     */
    @Test
    public void logout_username_1 () throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get( "/api/user/logout/{userName}", (Object) null))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Creator: Bui Huu Hai
     * Goal: username = ""
     * @Throw: Exception
     */
    @Test
    public void logout_username_2 () throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get( "/api/user/logout/{userName}", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Creator: Bui Huu Hai
     * Goal: username = invalid username
     * @Throw: Exception
     */
    @Test
    public void logout_username_3 () throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get( "/api/user/logout/{userName}", "wrong"))
                .andDo(print())
                .andExpect(status().is5xxServerError());
    }

    /**
     * Creator: Bui Huu Hai
     * Goal: username = valid username online
     * @Throw: Exception
     */
    @Test
    public void logout_username_4 () throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get( "/api/user/information/{id}", "admin"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
