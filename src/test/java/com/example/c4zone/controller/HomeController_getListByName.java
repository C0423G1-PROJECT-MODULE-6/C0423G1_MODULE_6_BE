package com.example.c4zone.controller;

import jdk.internal.org.jline.utils.Status;
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
public class HomeController_getListByName {
    /**
     * This method get List by Name for search function and showing list function
     *
     * @paras: name : the name that user want to search
     * @paras: sortName: sort on which column
     * @paras: sortType: ascending or descending
     * @author: Tai Phat
     */

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getListByName_id_8() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/admin/home/list?name={name}&sortName={sortName}&sortType={sortType}", "", "id", "desc"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
    @Test
    public void getListByName_id_8_1() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/admin/home/list?name={name}&sortName={sortName}&sortType={sortType}", "iphone", "", "desc"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
    @Test
    public void getListByName_id_8_2() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/admin/home/list?name={name}&sortName={sortName}&sortType={sortType}", "iphone", "id", ""))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void getListByName_id_10() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/admin/home/list?name={name}&sortName={sortName}&sortType={sortType}", "abcxyz", "id", "desc"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void getListByName_id_11() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/admin/home/list?name={name}&sortName={sortName}&sortType={sortType}", "iphone", "id", "desc"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
