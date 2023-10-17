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
                .andExpect(jsonPath("totalElements").value(8))
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
    public void getAllSaleHistory_name_11() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/admin/order/saleHistory")
                        .param("_limit", "5")
                        .param("_page", "0")
                        .param("name_like", "Nguyễn Hồng Hà"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("content[0].idOrderBill").value(1))
                .andExpect(jsonPath("content[0].dateOfOrder").value("2023-10-01"))
                .andExpect(jsonPath("content[0].timeOfOrder").value("04:56:26"))
                .andExpect(jsonPath("content[0].nameCustomer").value("Nguyễn Hồng Hà"))
                .andExpect(jsonPath("content[0].infoBuy").value("iPhone 12 128GB x4, iPhone 15 512GB x10"))
                .andExpect(jsonPath("content[0].totalMoney").value(7.8736238E7));
    }



    /**
     * Check case sortName exist
     * Author: NguyenNH
     * Goal: @return list customer
     */
    @Test
    public void getAllSaleHistory_sortName_11() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/admin/order/saleHistory")
                        .param("_limit", "5")
                        .param("_page", "0")
                        .param("sortName", "1"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("content[0].idOrderBill").value(1))
                .andExpect(jsonPath("content[0].dateOfOrder").value("2023-10-01"))
                .andExpect(jsonPath("content[0].timeOfOrder").value("04:56:26"))
                .andExpect(jsonPath("content[0].nameCustomer").value("Nguyễn Hồng Hà"))
                .andExpect(jsonPath("content[0].infoBuy").value("iPhone 12 128GB x4, iPhone 15 512GB x10"))
                .andExpect(jsonPath("content[0].totalMoney").value(7.8736238E7))

                .andExpect(jsonPath("content[4].idOrderBill").value(18))
                .andExpect(jsonPath("content[4].dateOfOrder").value("2023-10-15"))
                .andExpect(jsonPath("content[4].timeOfOrder").value("16:59:49"))
                .andExpect(jsonPath("content[4].nameCustomer").value("Nguyễn Anh Quân"))
                .andExpect(jsonPath("content[4].infoBuy").value("iPhone 15 Pro 512GB x10, iPhone 15 Pro 512GB x10, iPhone 15 Pro 256GB x10"))
                .andExpect(jsonPath("content[4].totalMoney").value(1052117000));
    }



    /**
     * Check case sortCount exist
     * Author: NguyenNH
     * Goal: @return list customer
     */
    @Test
    public void getAllSaleHistory_sortTime_11() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/admin/order/saleHistory")
                        .param("_limit", "5")
                        .param("_page", "0")
                        .param("sortTime", "1"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("content[0].idOrderBill").value(1))
                .andExpect(jsonPath("content[0].dateOfOrder").value("2023-10-01"))
                .andExpect(jsonPath("content[0].timeOfOrder").value("04:56:26"))
                .andExpect(jsonPath("content[0].nameCustomer").value("Nguyễn Hồng Hà"))
                .andExpect(jsonPath("content[0].infoBuy").value("iPhone 12 128GB x4, iPhone 15 512GB x10"))
                .andExpect(jsonPath("content[0].totalMoney").value(7.8736238E7))

                .andExpect(jsonPath("content[4].idOrderBill").value(17))
                .andExpect(jsonPath("content[4].dateOfOrder").value("2023-10-15"))
                .andExpect(jsonPath("content[4].timeOfOrder").value("16:55:16"))
                .andExpect(jsonPath("content[4].nameCustomer").value("Nguyễn Hoàng "))
                .andExpect(jsonPath("content[4].infoBuy").value("iPhone 15 Plus 256GB x10, " +
                        "iPhone 15 Pro 1TB x10, iPhone 15 Pro 1TB x10"))
                .andExpect(jsonPath("content[4].totalMoney").value(1143017000));
    }
    @Test
    public void getAllSaleHistory_sortTotalMoney_11() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/admin/order/saleHistory")
                        .param("_limit", "5")
                        .param("_page", "0")
                        .param("sortTotalMoney", "1"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("content[0].idOrderBill").value(19))
                .andExpect(jsonPath("content[0].dateOfOrder").value("2023-10-15"))
                .andExpect(jsonPath("content[0].timeOfOrder").value("17:03:59"))
                .andExpect(jsonPath("content[0].nameCustomer").value("Nguyễn Hồng Nguyên"))
                .andExpect(jsonPath("content[0].infoBuy").value("iPhone 15 Pro 256GB x10, " +
                        "iPhone 15 Pro 128GB x10, iPhone 15 Pro 128GB x10"))
                .andExpect(jsonPath("content[0].totalMoney").value(878397000))

                .andExpect(jsonPath("content[4].idOrderBill").value(16))
                .andExpect(jsonPath("content[4].dateOfOrder").value("2023-10-15"))
                .andExpect(jsonPath("content[4].timeOfOrder").value("16:52:08"))
                .andExpect(jsonPath("content[4].nameCustomer").value("Nguyễn Thị Thắm"))
                .andExpect(jsonPath("content[4].infoBuy").value("iPhone 13 256GB x10"))
                .andExpect(jsonPath("content[4].totalMoney").value(123213));
    }
}