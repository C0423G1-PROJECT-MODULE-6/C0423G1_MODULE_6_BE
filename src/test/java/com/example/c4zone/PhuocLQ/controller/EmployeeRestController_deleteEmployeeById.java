package com.example.c4zone.PhuocLQ.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeRestController_deleteEmployeeById {
    @Autowired
    private MockMvc mockMvc;

    /**
     * Author: PhuocLQ
     * Date create: 13/10/2023
     * Handling: Input id = null type to the path
     * @throws Exception
     */
    @Test
    public void deleteEmployee_25() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .delete("/api/admin/employee/delete")
                                .param("id",(String) null))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Author: PhuocLQ
     * Date create: 13/10/2023
     * Handling: Input id = "" type to the path
     * @throws Exception
     */
    @Test
    public void deleteEmployee_26() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .delete("/api/admin/employee/delete")
                                .param("id", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Author: PhuocLQ
     * Date create: 13/10/2023
     * Handling: Input id = 25 to the path
     * @throws Exception
     */
    @Test
    public void deleteEmployee_27() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .delete("/api/admin/employee/delete")
                                .param("id", "25"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Author: PhuocLQ
     * Date create: 13/10/2023
     * Handling: Input id = 4 to the path
     * @throws Exception
     */
    @Test
    public void deleteUserById_28() throws Exception{
        this.mockMvc.perform(
                        MockMvcRequestBuilders.delete("/api/admin/employee/delete/{id}",4))
                .andDo(print()).andExpect(status().is2xxSuccessful());
    }
}
