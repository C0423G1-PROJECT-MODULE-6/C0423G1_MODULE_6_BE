package com.example.c4zone.order;

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
     * Goal: @return list History
     */
    @Test
    public void getAllSaleHistory_limit_11() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/admin/order/saleHistory")
                        .param("_limit", "5")
                        .param("_page", "0"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(5))
                .andExpect(jsonPath("content[0].idOrderBill").value(1))
                .andExpect(jsonPath("content[0].dateOfOrder").value("2023-10-01"))
                .andExpect(jsonPath("content[0].timeOfOrder").value("04:56:26"))
                .andExpect(jsonPath("content[0].nameCustomer").value("Nguyễn Hồng Hà"))
                .andExpect(jsonPath("content[0].infoBuy").value("6.1 inch x4, 6.7 inch x4"))
                .andExpect(jsonPath("content[0].totalMoney").value(78736238))


                .andExpect(jsonPath("content[4].idOrderBill").value(5))
                .andExpect(jsonPath("content[4].dateOfOrder").value("2023-10-05"))
                .andExpect(jsonPath("content[4].timeOfOrder").value("00:45:04"))
                .andExpect(jsonPath("content[4].nameCustomer").value("Nguyễn Hoàng Ánh"))
                .andExpect(jsonPath("content[4].infoBuy").value("6.7 inch x2, 6.7 inch x2"))
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
                .andExpect(jsonPath("content[0].infoBuy").value("6.1 inch x4, 6.7 inch x4"))
                .andExpect(jsonPath("content[0].totalMoney").value(7.8736238E7));
    }




    /**
     * Check case sortName exist
     * Author: ThoiND
     * Goal: @return list History
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
                .andExpect(jsonPath("content[0].infoBuy").value("6.1 inch x4, 6.7 inch x4"))
                .andExpect(jsonPath("content[0].totalMoney").value(7.8736238E7))

                .andExpect(jsonPath("content[4].idOrderBill").value(5))
                .andExpect(jsonPath("content[4].dateOfOrder").value("2023-10-05"))
                .andExpect(jsonPath("content[4].timeOfOrder").value("00:45:04"))
                .andExpect(jsonPath("content[4].nameCustomer").value("Nguyễn Hoàng Ánh"))
                .andExpect(jsonPath("content[4].infoBuy").value("6.7 inch x2, 6.7 inch x2"))
                .andExpect(jsonPath("content[4].totalMoney").value(9.8311772E7));
    }



    /**
     * Check case sortTime exist
     * Author: ThoiND
     * Goal: @return list History
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
                .andExpect(jsonPath("content[0].idOrderBill").value(5))
                .andExpect(jsonPath("content[0].dateOfOrder").value("2023-10-05"))
                .andExpect(jsonPath("content[0].timeOfOrder").value("00:45:04"))
                .andExpect(jsonPath("content[0].nameCustomer").value("Nguyễn Hoàng Ánh"))
                .andExpect(jsonPath("content[0].infoBuy").value("6.7 inch x2, 6.7 inch x2"))
                .andExpect(jsonPath("content[0].totalMoney").value(9.8311772E7))

                .andExpect(jsonPath("content[4].idOrderBill").value(2))
                .andExpect(jsonPath("content[4].dateOfOrder").value("2023-10-02"))
                .andExpect(jsonPath("content[4].timeOfOrder").value("18:22:56"))
                .andExpect(jsonPath("content[4].nameCustomer").value("Nguyễn Hoàng Anh"))
                .andExpect(jsonPath("content[4].infoBuy").value("6.1 inch x2, 6.1 inch x2"))
                .andExpect(jsonPath("content[4].totalMoney").value(5.4173164E7));
    }
    /**
     * Check case sortTotalMoney exist
     * Author: ThoiND
     * Goal: @return list History
     */
    @Test
    public void getAllSaleHistory_sortTotalMoney_11() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/admin/order/saleHistory")
                        .param("_limit", "5")
                        .param("_page", "0")
                        .param("sortTotalMoney", "1"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("content[0].idOrderBill").value(5))
                .andExpect(jsonPath("content[0].dateOfOrder").value("2023-10-05"))
                .andExpect(jsonPath("content[0].timeOfOrder").value("00:45:04"))
                .andExpect(jsonPath("content[0].nameCustomer").value("Nguyễn Hoàng Ánh"))
                .andExpect(jsonPath("content[0].infoBuy").value("6.7 inch x2, 6.7 inch x2"))
                .andExpect(jsonPath("content[0].totalMoney").value(9.8311772E7))

                .andExpect(jsonPath("content[4].idOrderBill").value(4))
                .andExpect(jsonPath("content[4].dateOfOrder").value("2023-10-04"))
                .andExpect(jsonPath("content[4].timeOfOrder").value("10:00:42"))
                .andExpect(jsonPath("content[4].nameCustomer").value("Nguyễn Hồng Nguyên"))
                .andExpect(jsonPath("content[4].infoBuy").value("6.7 inch x1, 6.7 inch x1"))
                .andExpect(jsonPath("content[4].totalMoney").value(2.7338462E7));
    }
}