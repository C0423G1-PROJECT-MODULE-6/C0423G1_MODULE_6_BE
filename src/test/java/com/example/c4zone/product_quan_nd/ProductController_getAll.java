package com.example.c4zone.product_quan_nd;

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
public class ProductController_getAll {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getAll_11() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/admin/product/list")).andDo(print())
                .andExpect(jsonPath("totalPages").value(9))
                .andExpect(jsonPath("totalElements").value(45))
                .andExpect(jsonPath("content[0].id").value(39))
                .andExpect(jsonPath("content[0].name").value("Apple Watch SE 2023 GPS 44mm Sport Loop"))
                .andExpect(jsonPath("content[0].color").value("Xanh Đen Đậm"))
                .andExpect(jsonPath("content[0].cpu").value("Apple S8"))
                .andExpect(jsonPath("content[0].capacity").value("32GB"))
                .andExpect(jsonPath("content[0].quantity").value(10.0))
                .andExpect(jsonPath("content[0].camera").value("Không có"))
                .andExpect(jsonPath("content[0].price").value(7190000.0))
                .andExpect(status().is2xxSuccessful())
        ;
    }

    @Test
    public void getAll_name_11() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/admin/product/list?choose=name&value=", "")).andDo(print())
                .andExpect(jsonPath("totalPages").value(9))
                .andExpect(jsonPath("totalElements").value(45))
                .andExpect(jsonPath("content[0].id").value(39))
                .andExpect(jsonPath("content[0].name").value("Apple Watch SE 2023 GPS 44mm Sport Loop"))
                .andExpect(jsonPath("content[0].color").value("Xanh Đen Đậm"))
                .andExpect(jsonPath("content[0].cpu").value("Apple S8"))
                .andExpect(jsonPath("content[0].capacity").value("32GB"))
                .andExpect(jsonPath("content[0].quantity").value(10.0))
                .andExpect(jsonPath("content[0].camera").value("Không có"))
                .andExpect(jsonPath("content[0].price").value(7190000.0))
                .andExpect(status().is2xxSuccessful())
        ;
    }

    @Test
    public void getAll_page_07() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/admin/product/list&page=null")).andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getAll_page_08() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/admin/product/list&page=")).andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getAll_page_09() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/admin/product/list&page=-1")).andDo(print())
                .andExpect(status().is4xxClientError());
    }


    @Test
    public void getAll_page_10() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/admin/product/list?choose=name&value=DinhQuan&page=0")).andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getAll_page_11() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/admin/product/list?page=0")).andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(9))
                .andExpect(jsonPath("totalElements").value(45))
                .andExpect(jsonPath("content[0].id").value(39))
                .andExpect(jsonPath("content[0].name").value("Apple Watch SE 2023 GPS 44mm Sport Loop"))
                .andExpect(jsonPath("content[0].color").value("Xanh Đen Đậm"))
                .andExpect(jsonPath("content[0].cpu").value("Apple S8"))
                .andExpect(jsonPath("content[0].capacity").value("32GB"))
                .andExpect(jsonPath("content[0].quantity").value(10.0))
                .andExpect(jsonPath("content[0].camera").value("Không có"))
                .andExpect(jsonPath("content[0].price").value(7190000.0))
        ;
    }

    @Test
    public void getAll_choose_7() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/admin/product/list?choose=null")).andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(9))
                .andExpect(jsonPath("totalElements").value(45))
                .andExpect(jsonPath("content[0].id").value(39))
                .andExpect(jsonPath("content[0].name").value("Apple Watch SE 2023 GPS 44mm Sport Loop"))
                .andExpect(jsonPath("content[0].color").value("Xanh Đen Đậm"))
                .andExpect(jsonPath("content[0].cpu").value("Apple S8"))
                .andExpect(jsonPath("content[0].capacity").value("32GB"))
                .andExpect(jsonPath("content[0].quantity").value(10.0))
                .andExpect(jsonPath("content[0].camera").value("Không có"))
                .andExpect(jsonPath("content[0].price").value(7190000.0))
        ;
    }

    @Test
    public void getAll_choose_8() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/admin/product/list?choose=")).andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(9))
                .andExpect(jsonPath("totalElements").value(45))
                .andExpect(jsonPath("content[0].id").value(39))
                .andExpect(jsonPath("content[0].name").value("Apple Watch SE 2023 GPS 44mm Sport Loop"))
                .andExpect(jsonPath("content[0].color").value("Xanh Đen Đậm"))
                .andExpect(jsonPath("content[0].cpu").value("Apple S8"))
                .andExpect(jsonPath("content[0].capacity").value("32GB"))
                .andExpect(jsonPath("content[0].quantity").value(10.0))
                .andExpect(jsonPath("content[0].camera").value("Không có"))
                .andExpect(jsonPath("content[0].price").value(7190000.0))
        ;
    }

    @Test
    public void getAll_choose_9() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/admin/product/list?choose=quan")).andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(9))
                .andExpect(jsonPath("totalElements").value(45))
                .andExpect(jsonPath("content[0].id").value(39))
                .andExpect(jsonPath("content[0].name").value("Apple Watch SE 2023 GPS 44mm Sport Loop"))
                .andExpect(jsonPath("content[0].color").value("Xanh Đen Đậm"))
                .andExpect(jsonPath("content[0].cpu").value("Apple S8"))
                .andExpect(jsonPath("content[0].capacity").value("32GB"))
                .andExpect(jsonPath("content[0].quantity").value(10.0))
                .andExpect(jsonPath("content[0].camera").value("Không có"))
                .andExpect(jsonPath("content[0].price").value(7190000.0))
        ;
    }

    @Test
    public void getAll_choose_11() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/admin/product/list?choose=name")).andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(9))
                .andExpect(jsonPath("totalElements").value(45))
                .andExpect(jsonPath("content[0].id").value(39))
                .andExpect(jsonPath("content[0].name").value("Apple Watch SE 2023 GPS 44mm Sport Loop"))
                .andExpect(jsonPath("content[0].color").value("Xanh Đen Đậm"))
                .andExpect(jsonPath("content[0].cpu").value("Apple S8"))
                .andExpect(jsonPath("content[0].capacity").value("32GB"))
                .andExpect(jsonPath("content[0].quantity").value(10.0))
                .andExpect(jsonPath("content[0].camera").value("Không có"))
                .andExpect(jsonPath("content[0].price").value(7190000.0))
        ;
    }

    @Test
    public void getAll_sort_07() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/admin/product/list?sort=null")).andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(9))
                .andExpect(jsonPath("totalElements").value(45))
                .andExpect(jsonPath("content[0].id").value(39))
                .andExpect(jsonPath("content[0].name").value("Apple Watch SE 2023 GPS 44mm Sport Loop"))
                .andExpect(jsonPath("content[0].color").value("Xanh Đen Đậm"))
                .andExpect(jsonPath("content[0].cpu").value("Apple S8"))
                .andExpect(jsonPath("content[0].capacity").value("32GB"))
                .andExpect(jsonPath("content[0].quantity").value(10.0))
                .andExpect(jsonPath("content[0].camera").value("Không có"))
                .andExpect(jsonPath("content[0].price").value(7190000.0))
        ;
    }

    @Test
    public void getAll_sort_08() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/admin/product/list?sort=")).andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(9))
                .andExpect(jsonPath("totalElements").value(45))
                .andExpect(jsonPath("content[0].id").value(39))
                .andExpect(jsonPath("content[0].name").value("Apple Watch SE 2023 GPS 44mm Sport Loop"))
                .andExpect(jsonPath("content[0].color").value("Xanh Đen Đậm"))
                .andExpect(jsonPath("content[0].cpu").value("Apple S8"))
                .andExpect(jsonPath("content[0].capacity").value("32GB"))
                .andExpect(jsonPath("content[0].quantity").value(10.0))
                .andExpect(jsonPath("content[0].camera").value("Không có"))
                .andExpect(jsonPath("content[0].price").value(7190000.0))
        ;
    }

    @Test
    public void getAll_sort_09() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/admin/product/list?sort=abczyz")).andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(9))
                .andExpect(jsonPath("totalElements").value(45))
                .andExpect(jsonPath("content[0].id").value(39))
                .andExpect(jsonPath("content[0].name").value("Apple Watch SE 2023 GPS 44mm Sport Loop"))
                .andExpect(jsonPath("content[0].color").value("Xanh Đen Đậm"))
                .andExpect(jsonPath("content[0].cpu").value("Apple S8"))
                .andExpect(jsonPath("content[0].capacity").value("32GB"))
                .andExpect(jsonPath("content[0].quantity").value(10.0))
                .andExpect(jsonPath("content[0].camera").value("Không có"))
                .andExpect(jsonPath("content[0].price").value(7190000.0))
        ;
    }

    @Test
    public void getAll_sort_name_11() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/admin/product/list?sort=name")).andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(9))
                .andExpect(jsonPath("totalElements").value(45))
                .andExpect(jsonPath("content[0].id").value(42))
                .andExpect(jsonPath("content[0].name").value("Apple Watch SE 2023 GPS 40mm Sport Band"))
                .andExpect(jsonPath("content[0].color").value("Xanh Đen Đậm"))
                .andExpect(jsonPath("content[0].cpu").value("Apple S8"))
                .andExpect(jsonPath("content[0].capacity").value("32GB"))
                .andExpect(jsonPath("content[0].quantity").value(10.0))
                .andExpect(jsonPath("content[0].camera").value("Không có"))
                .andExpect(jsonPath("content[0].price").value(6390000.0))
        ;
    }

    @Test
    public void getAll_sort_type_11() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/admin/product/list?sort=type")).andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(9))
                .andExpect(jsonPath("totalElements").value(45))
                .andExpect(jsonPath("content[0].id").value(34))
                .andExpect(jsonPath("content[0].name").value("Ipad Air 5 Wifi + Cellular 256GB"))
                .andExpect(jsonPath("content[0].color").value("Trắng"))
                .andExpect(jsonPath("content[0].cpu").value("Apple M1"))
                .andExpect(jsonPath("content[0].capacity").value("256GB"))
                .andExpect(jsonPath("content[0].quantity").value(10.0))
                .andExpect(jsonPath("content[0].camera").value("12MP"))
                .andExpect(jsonPath("content[0].price").value(21590000.0))
                .andExpect(jsonPath("content[0].type").value("Ipad"))
        ;
    }

    @Test
    public void getAll_sort_price_11() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/admin/product/list?sort=price")).andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(9))
                .andExpect(jsonPath("totalElements").value(45))
                .andExpect(jsonPath("content[0].id").value(42))
                .andExpect(jsonPath("content[0].name").value("Apple Watch SE 2023 GPS 40mm Sport Band"))
                .andExpect(jsonPath("content[0].color").value("Xanh Đen Đậm"))
                .andExpect(jsonPath("content[0].cpu").value("Apple S8"))
                .andExpect(jsonPath("content[0].capacity").value("32GB"))
                .andExpect(jsonPath("content[0].quantity").value(10.0))
                .andExpect(jsonPath("content[0].camera").value("Không có"))
                .andExpect(jsonPath("content[0].price").value(6390000.0))
        ;
    }

    @Test
    public void getAll_sort_quantity_11() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/admin/product/list?sort=quantity")).andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(9))
                .andExpect(jsonPath("totalElements").value(45))
                .andExpect(jsonPath("content[0].id").value(1))
                .andExpect(jsonPath("content[0].name").value("iPhone 12 128GB"))
                .andExpect(jsonPath("content[0].color").value("Xanh Lá"))
                .andExpect(jsonPath("content[0].cpu").value("Apple A14 Bionic"))
                .andExpect(jsonPath("content[0].capacity").value("128GB"))
                .andExpect(jsonPath("content[0].quantity").value(10.0))
                .andExpect(jsonPath("content[0].camera").value("12 MP"))
                .andExpect(jsonPath("content[0].price").value(16490000.0))
        ;
    }
    @Test
    public void getAll_choose_name_11() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/admin/product/list?choose=name&value=#")).andDo(print())
                .andExpect(status().is4xxClientError())
        ;
    }



}
