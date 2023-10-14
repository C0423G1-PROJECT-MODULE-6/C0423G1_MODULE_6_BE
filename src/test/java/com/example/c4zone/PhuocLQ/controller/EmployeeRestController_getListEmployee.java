package com.example.c4zone.PhuocLQ.controller;
import com.example.c4zone.model.user.AppUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeRestController_getListEmployee {
    @Autowired
    private MockMvc mockMvc;

    /**
     * Create: PhuocLQ
     * Date create: 13/10/2023
     * Handling: Input page = null type to the path
     * @throws Exception
     */
    @Test
    public void displayListEmployee_searchPage_7() throws Exception{
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/admin/employee/list")
                                .param("page", "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create: PhuocLQ
     * Date create: 13/10/2023
     * Handling: Input page = valid data type to the path
     * @throws Exception
     */
    @Test
    public void displayListEmployee_searchPage_11() throws Exception{
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/admin/employee/list")
                                .param("page", "2"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create: PhuocLQ
     * Date create: 13/10/2023
     * Handling: Input searchJob = null type to the path
     * @throws Exception
     */
    @Test
    public void displayListEmployee_searchJob_7() throws Exception{
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/admin/employee/list")
                                .param("searchJob", "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Create: PhuocLQ
     * Date create: 13/10/2023
     * Handling: Input searchJob = '' type to the path
     * @throws Exception
     */
    @Test
    public void displayListEmployee_searchJob_8() throws Exception{
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/admin/employee/list")
                                .param("searchJob", "''"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Create: PhuocLQ
     * Date create: 13/10/2023
     * Handling: Input searchJob = invalid data type to the path
     * @throws Exception
     */
    @Test
    public void displayListEmployee_searchJob_9() throws Exception{
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/admin/employee/list")
                                .param("searchJob", "5"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create: PhuocLQ
     * Date create: 13/10/2023
     * Handling: Input searchJob = valid data type to the path
     * @throws Exception
     */
    @Test
    public void displayListEmployee_searchJob_11() throws Exception{
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/admin/employee/list")
                                .param("searchJob", "3"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create: PhuocLQ
     * Date create: 13/10/2023
     * Handling: Input searchName = null to the path
     * @throws Exception
     */
    @Test
    public void displayListEmployee_searchName_7() throws Exception{
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/admin/employee/list")
                                .param("searchName", "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Create: PhuocLQ
     * Date create: 13/10/2023
     * Handling: Input searchName = '' to the path
     * @throws Exception
     */
    @Test
    public void displayListEmployee_searchName_8() throws Exception{
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/admin/employee/list")
                                .param("searchName", "''"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Create: PhuocLQ
     * Date create: 13/10/2023
     * Handling: Input invalid data to the path
     * @throws Exception
     */
    @Test
    public void displayListEmployee_searchName_9() throws Exception{
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/admin/employee/list")
                                .param("searchName", "5"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Create: PhuocLQ
     * Date create: 13/10/2023
     * Handling: Input valid data to the path
     * @throws Exception
     */
    @Test
    public void displayListEmployee_searchName_11() throws Exception{
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/admin/employee/list")
                                .param("searchName", "phước"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create: PhuocLQ
     * Date create: 13/10/2023
     * Handling: Input searchPhone = null to the path
     * @throws Exception
     */
    @Test
    public void displayListEmployee_searchPhone_7() throws Exception{
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/admin/employee/list")
                                .param("searchPhone", "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Create: PhuocLQ
     * Date create: 13/10/2023
     * Handling: Input searchPhone = '' to the path
     * @throws Exception
     */
    @Test
    public void displayListEmployee_searchPhone_8() throws Exception{
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/admin/employee/list")
                                .param("searchPhone", "''"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Create: PhuocLQ
     * Date create: 13/10/2023
     * Handling: Input invalid data to the path
     * @throws Exception
     */
    @Test
    public void displayListEmployee_searchPhone_9() throws Exception{
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/admin/employee/list")
                                .param("searchPhone", "a"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Create: PhuocLQ
     * Date create: 13/10/2023
     * Handling: Input valid data to the path
     * @throws Exception
     */
    @Test
    public void displayListEmployee_searchPhone_11() throws Exception{
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/admin/employee/list")
                                .param("searchPhone", "3"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
