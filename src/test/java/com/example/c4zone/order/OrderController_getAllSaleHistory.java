package com.example.c4zone.order;

import org.hamcrest.core.IsNull;
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
public class OrderController_getAllSaleHistory {
    @Autowired
    private MockMvc mockMvc;


    /**
     * Check case limit null
     * Author: ThoiND
     * Goal: @throw Exception
     */
    @Test
    public void getAllSaleHistory_limit_7() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/admin/order/saleHistory")
                        .param("_limit", (String) null)
                        .param("_page", "0"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Check case limit empty
     * Author: ThoiND
     * Goal: @throw Exception
     */
    @Test
    public void getAllSaleHistory_limit_8() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/admin/order/saleHistory")
                        .param("_limit", "")
                        .param("_page", "0"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Check case limit exist
     * Author: ThoiND
     * Goal: @return list customer
     */
    @Test
    public void getAllSaleHistory_limit_11() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/admin/order/saleHistory")
                        .param("_limit", "5")
                        .param("_page", "1"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(2))
                .andExpect(jsonPath("totalElements").value(10))
                .andExpect(jsonPath("content[0].idOrderBill").value(10))
                .andExpect(jsonPath("content[0].dateOfOrder").value("2023-10-10"))
                .andExpect(jsonPath("content[0].timeOfOrder").value("16:36:10"))
                .andExpect(jsonPath("content[0].nameCustomer").value("Nguyễn Văn Hải"))
                .andExpect(jsonPath("content[0].infoBuy").value("iPhone 13 256GB x2"))
                .andExpect(jsonPath("content[0].totalMoney").value(16468123))


                .andExpect(jsonPath("content[4].idOrderBill").value(5))
                .andExpect(jsonPath("content[4].dateOfOrder").value("2023-10-05"))
                .andExpect(jsonPath("content[4].timeOfOrder").value("00:45:04"))
                .andExpect(jsonPath("content[4].nameCustomer").value("Nguyễn Hoàng Ánh"))
                .andExpect(jsonPath("content[4].infoBuy").value("iPhone  14 Plus 256GB x1"))
                .andExpect(jsonPath("content[4].totalMoney").value(9.8311772E7));
    }

    /**
     * Check case page null
     * Author: ThoiND
     * Goal: @throw Exception
     */
    @Test
    public void getAllSaleHistory_page_7() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/admin/order/saleHistory")
                        .param("_limit", "5")
                        .param("_page", (String) null))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Check case page empty
     * Author: ThoiND
     * Goal: @throw Exception
     */
    @Test
    public void getAllSaleHistory_page_8() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/admin/order/saleHistory")
                        .param("_limit", "5")
                        .param("_page", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Check case page not exist
     * Author: ThoiND
     * Goal: @throw Exception
     * dang sai
     */
    @Test
    public void getAllSaleHistory_page_9() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/admin/order/saleHistory")
                        .param("_limit", "5")
                        .param("_page", "100"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     * Check case page exist
     * Author: ThoiND
     * Goal: @return list sale history
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
     * Author: ThoiND
     * Goal: @throw Exception
     */
    @Test
    public void getAllSaleHistory_name_9() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/admin/order/saleHistory")
                        .param("_limit", "5")
                        .param("_page", "0")
                        .param("name_like", "không có trong DB"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     * Check case name exist in the database
     * Author: ThoiND
     * Goal: @return list saleHistory
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
     * Check case sortName exist
     * Author: NguyenNH
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
     * Author: NguyenNH
     * Goal: @return list customer
     */
    @Test
    public void getAllSaleHistory_sortCount_11() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/admin/customer/list")
                        .param("_limit", "5")
                        .param("_page", "0")
                        .param("sortCount", "1"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}