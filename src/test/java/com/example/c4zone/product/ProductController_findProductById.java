//package com.example.c4zone.product;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@SpringBootTest
//@AutoConfigureMockMvc
//public class ProductController_findProductById {
//    @Autowired
//    private MockMvc mockMvc;
//
//    /**
//     * this function is success
//     * author: DaoPTA
//     * workday: 12/10/2023
//     * @throws Exception valid get info id
//     */
//    @Test
//    public void findProductById_1() throws Exception {
//        this.mockMvc.perform(
//                MockMvcRequestBuilders.get("/api/admin/product/{id}", "2"))
//                .andDo(print())
//                .andExpect(status().is2xxSuccessful());
//    }
//
//    /**
//     * This function is used to check the id parameter is empty
//     * author: DaoPTA
//     * workday: 12/10/2023
//     * @throws Exception
//     */
//    @Test
//    public void findProductById_2() throws Exception {
//        this.mockMvc.perform(
//                MockMvcRequestBuilders.get("/api/admin/product/{id}", ""))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void findProductById_3() throws Exception {
//        this.mockMvc.perform(
//                MockMvcRequestBuilders.get("/api/admin/product/{id}", "100"))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//}
