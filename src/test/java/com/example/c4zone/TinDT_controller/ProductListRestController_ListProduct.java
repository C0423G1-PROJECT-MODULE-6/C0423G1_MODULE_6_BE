package com.example.c4zone.TinDT_controller;

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
public class ProductListRestController_ListProduct{
    @Autowired
    private MockMvc mockMvc;


    /**
     * Check case limit null
     * Author: TinDT
     * Goal: @throw Exception
     */
    @Test
    public void getAllCustomer_limit_7() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/admin/customer/list")
                        .param("_limit", (String) null)
                        .param("_page", "0"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Check case limit empty
     * Author: TinDT
     * Goal: @throw Exception
     */
    @Test
    public void getAllCustomer_limit_8() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/admin/customer/list")
                        .param("_limit", "")
                        .param("_page", "0"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Check case all success
     * Author: TinDT
     * Goal: @return list customer
     */
    @Test
    public void getAllCustomer_limit_11() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/admin/customer/list")
                        .param("_limit", "5")
                        .param("_page", "1"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(2))
                .andExpect(jsonPath("totalElements").value(10))
                .andExpect(jsonPath("content[0].idCustomer").value(6))
                .andExpect(jsonPath("content[0].nameCustomer").value("Nguyễn Thị Thắm"))
                .andExpect(jsonPath("content[0].genderCustomer").value(false))
                .andExpect(jsonPath("content[0].emailCustomer").value("tham@gmail.com"))
                .andExpect(jsonPath("content[0].dateOfBirthCustomer").value("1990-10-10"))
                .andExpect(jsonPath("content[0].phoneNumberCustomer").value("0054631279"))
                .andExpect(jsonPath("content[0].addressCustomer").value("Sai Gon"))
                .andExpect(jsonPath("content[0].statusCustomer").value(true));
    }

    /**
     * Check case page null
     * Author: TinDT
     * Goal: @throw Exception
     */
    @Test
    public void getAllCustomer_page_7() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/admin/customer/list")
                        .param("_limit", "5")
                        .param("_page", (String) null))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Check case page empty
     * Author: TinDT
     * Goal: @throw Exception
     */
    @Test
    public void getAllCustomer_page_8() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/admin/customer/list")
                        .param("_limit", "5")
                        .param("_page", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Check case page not exist
     * Author: TinDT
     * Goal: @throw Exception
     */
    @Test
    public void getAllCustomer_page_9() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/admin/customer/list")
                        .param("_limit", "5")
                        .param("_page", "55"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     * Check case page exist
     * Author: TinDT
     * Goal: @return list customer
     */
    @Test
    public void getAllCustomer_page_11() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/admin/customer/list")
                        .param("_limit", "5")
                        .param("_page", "1"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(2))
                .andExpect(jsonPath("totalElements").value(10))
                .andExpect(jsonPath("content[0].idCustomer").value(6))
                .andExpect(jsonPath("content[0].nameCustomer").value("Nguyễn Thị Thắm"))
                .andExpect(jsonPath("content[0].genderCustomer").value(false))
                .andExpect(jsonPath("content[0].emailCustomer").value("tham@gmail.com"))
                .andExpect(jsonPath("content[0].dateOfBirthCustomer").value("2023-10-10"))
                .andExpect(jsonPath("content[0].phoneNumberCustomer").value("0054631279"))
                .andExpect(jsonPath("content[0].addressCustomer").value("Sai Gon"))
                .andExpect(jsonPath("content[0].statusCustomer").value(true))

                .andExpect(jsonPath("content[4].idCustomer").value(10))
                .andExpect(jsonPath("content[4].nameCustomer").value("Nguyễn Văn Hải"))
                .andExpect(jsonPath("content[4].genderCustomer").value(true))
                .andExpect(jsonPath("content[4].emailCustomer").value("hai@gmail.com"))
                .andExpect(jsonPath("content[4].dateOfBirthCustomer").value("2000-10-10"))
                .andExpect(jsonPath("content[4].phoneNumberCustomer").value("0983125476"))
                .andExpect(jsonPath("content[4].addressCustomer").value("Da Nang"))
                .andExpect(jsonPath("content[4].statusCustomer").value(true));
    }


    /**
     * Check case name not exist in the database
     * Author: TinDT
     * Goal: @throw Exception
     */
    @Test
    public void getAllCustomer_name_9() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/admin/customer/list")
                        .param("_limit", "5")
                        .param("_page", "0")
                        .param("name_like", "không có trong DB")
                        .param("age", "")
                        .param("gender", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     * Check case name exist in the database
     * Author: TinDT
     * Goal: @return list customer
     */
    @Test
    public void getAllCustomer_name_11() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/admin/customer/list")
                        .param("_limit", "5")
                        .param("_page", "0")
                        .param("name_like", "Nguyễn Hoàng Anh")
                        .param("age", "")
                        .param("gender", ""))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("content[0].idCustomer").value(2))
                .andExpect(jsonPath("content[0].nameCustomer").value("Nguyễn Hoàng Anh"))
                .andExpect(jsonPath("content[0].genderCustomer").value(false))
                .andExpect(jsonPath("content[0].emailCustomer").value("anh@gmail.com"))
                .andExpect(jsonPath("content[0].dateOfBirthCustomer").value("2022-10-10"))
                .andExpect(jsonPath("content[0].phoneNumberCustomer").value("098732165"))
                .andExpect(jsonPath("content[0].addressCustomer").value("Da Nang"))
                .andExpect(jsonPath("content[0].statusCustomer").value(true));
    }

    /**
     * Check case age not exist in the database
     * Author: TinDT
     * Goal: @throw Exception
     */
    @Test
    public void getAllCustomer_age_9() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/admin/customer/list")
                        .param("_limit", "5")
                        .param("_page", "0")
                        .param("name_like", "")
                        .param("age", "100")
                        .param("gender", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     * Check case age exist in the database
     * Author: TinDT
     * Goal: @return list customer
     */
    @Test
    public void getAllCustomer_age_11() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/admin/customer/list")
                        .param("_limit", "5")
                        .param("_page", "0")
                        .param("name_like", "")
                        .param("age", "23")
                        .param("gender", ""))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("content[0].idCustomer").value(10))
                .andExpect(jsonPath("content[0].nameCustomer").value("Nguyễn Văn Hải"))
                .andExpect(jsonPath("content[0].genderCustomer").value(true))
                .andExpect(jsonPath("content[0].emailCustomer").value("hai@gmail.com"))
                .andExpect(jsonPath("content[0].dateOfBirthCustomer").value("2000-10-10"))
                .andExpect(jsonPath("content[0].phoneNumberCustomer").value("0983125476"))
                .andExpect(jsonPath("content[0].addressCustomer").value("Da Nang"))
                .andExpect(jsonPath("content[0].statusCustomer").value(true));
    }

    /**
     * Check case gender not exist in the database
     * Author: TinDt
     * Goal: @throw Exception
     */
    @Test
    public void getAllCustomer_gender_9() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/admin/customer/list")
                        .param("_limit", "5")
                        .param("_page", "0")
                        .param("name_like", "")
                        .param("age", "")
                        .param("gender", "10"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     * Check case gender exist in the database
     * Author: TinDT
     * Goal: @return list customer
     */
    @Test
    public void getAllCustomer_gender_11() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/admin/customer/list")
                        .param("_limit", "5")
                        .param("_page", "0")
                        .param("name_like", "")
                        .param("age", "")
                        .param("gender", "1"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("content[0].idCustomer").value(1))
                .andExpect(jsonPath("content[0].nameCustomer").value("Nguyễn Hồng Hà"))
                .andExpect(jsonPath("content[0].genderCustomer").value(true))
                .andExpect(jsonPath("content[0].emailCustomer").value("ha@gmail.com"))
                .andExpect(jsonPath("content[0].dateOfBirthCustomer").value("2021-10-10"))
                .andExpect(jsonPath("content[0].phoneNumberCustomer").value("123312654"))
                .andExpect(jsonPath("content[0].addressCustomer").value("Ha Noi"))
                .andExpect(jsonPath("content[0].statusCustomer").value(true))

                .andExpect(jsonPath("content[4].idCustomer").value(9))
                .andExpect(jsonPath("content[4].nameCustomer").value("Nguyễn Hồng Nguyên"))
                .andExpect(jsonPath("content[4].genderCustomer").value(true))
                .andExpect(jsonPath("content[4].emailCustomer").value("nguyen@gmail.com"))
                .andExpect(jsonPath("content[4].dateOfBirthCustomer").value("2023-10-10"))
                .andExpect(jsonPath("content[4].phoneNumberCustomer").value("023165489"))
                .andExpect(jsonPath("content[4].addressCustomer").value("Ha Noi"))
                .andExpect(jsonPath("content[4].statusCustomer").value(true));
    }

    /**
     * Check case sortName exist
     * Author: TinDT
     * Goal: @return list customer
     */
    @Test
    public void getAllCustomer_sortName_11() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/admin/customer/list")
                        .param("_limit", "5")
                        .param("_page", "0")
                        .param("sortName", "1"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("content[0].idCustomer").value(8))
                .andExpect(jsonPath("content[0].nameCustomer").value("Nguyễn Anh Quân"))
                .andExpect(jsonPath("content[0].genderCustomer").value(true))
                .andExpect(jsonPath("content[0].emailCustomer").value("quan@gmail.com"))
                .andExpect(jsonPath("content[0].dateOfBirthCustomer").value("2021-10-10"))
                .andExpect(jsonPath("content[0].phoneNumberCustomer").value("0983125476"))
                .andExpect(jsonPath("content[0].addressCustomer").value("Sai Gon"))
                .andExpect(jsonPath("content[0].statusCustomer").value(true))

                .andExpect(jsonPath("content[4].idCustomer").value(1))
                .andExpect(jsonPath("content[4].nameCustomer").value("Nguyễn Hồng Hà"))
                .andExpect(jsonPath("content[4].genderCustomer").value(true))
                .andExpect(jsonPath("content[4].emailCustomer").value("ha@gmail.com"))
                .andExpect(jsonPath("content[4].dateOfBirthCustomer").value("2021-10-10"))
                .andExpect(jsonPath("content[4].phoneNumberCustomer").value("123312654"))
                .andExpect(jsonPath("content[4].addressCustomer").value("Ha Noi"))
                .andExpect(jsonPath("content[4].statusCustomer").value(true));
    }

    /**
     * Check case sortCount exist
     * Author: TinDT
     * Goal: @return list customer
     */
    @Test
    public void getAllCustomer_sortCount_11() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/admin/customer/list")
                        .param("_limit", "5")
                        .param("_page", "0")
                        .param("sortCount", "1"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
