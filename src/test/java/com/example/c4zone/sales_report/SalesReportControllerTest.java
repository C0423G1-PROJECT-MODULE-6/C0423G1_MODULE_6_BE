package com.example.c4zone.sales_report;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class SalesReportControllerTest {
    @Autowired
    private MockMvc mockMvc;

    /**
     * Returns list of products
     * Author : LoiVT
     * Date : 19/10/2023
     */

    @Test
    public void getProduct_6() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/admin/sales-report/product"))
                .andDo(print())
                .andExpect(jsonPath("$[0].idProduct").value(1))
                .andExpect(jsonPath("$[0].nameProduct").value("Iphone 11"))
                .andExpect(status().is2xxSuccessful());
    }
    /**
     * returns list product when there is no data
     * Author : LoiVT
     * Date : 19/10/2023
     */
    @Test
    public void getProduct_5() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/admin/sales-report/product"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Returns list of sales report
     * Author : LoiVT
     * Date : 19/10/2023
     */
    @Test
    public void getSalesReport_6() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/admin/sales-report"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$[0].name").value("Tất Cả"))
                .andExpect(jsonPath("$[0].date").value("2023-10-01"))
                .andExpect(jsonPath("$[0].quantity").value(0))
                .andExpect(jsonPath("$[0].daily").value(0));
    }
    /**
     * returns list sales product when there is no data
     * Author : LoiVT
     * Date : 19/10/2023
     */
    @Test
    public void getSalesReport_5() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/admin/sales-report"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * show list sales report when searchTerm is empty
     * Author : LoiVT
     * Date : 19/10/2023
     */
    @Test
    public void getSalesReportSearch_sreachTerm_8() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/admin/sales-report/sreach")
                        .param("startDate", "2023-10-01")
                        .param("endDate", "2023-10-15")
                        .param("searchTerm", ""))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$[0].name").value("Tất Cả"))
                .andExpect(jsonPath("$[0].date").value("2023-10-01"))
                .andExpect(jsonPath("$[0].quantity").value(0))
                .andExpect(jsonPath("$[0].daily").value(0));
    }

    /**
     * show list sales report in searchTerm when data is wrong
     * Author : LoiVT
     * Date : 19/10/2023
     */

    @Test
    public void getSalesReportSearch_10() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/admin/sales-report/sreach")
                        .param("startDate", "2023-10-01")
                        .param("endDate", "2023-10-15")
                        .param("searchTerm", "'Iphone 11'"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
    /**
     * Show list when all are empty
     * Author : LoiVT
     * Date : 19/10/2023
     */
    @Test
    public void getSalesReportSearch_8() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/admin/sales-report/sreach")
                        .param("startDate", "")
                        .param("endDate", "")
                        .param("searchTerm", ""))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
    /**
     * show list when all are null
     * Author : LoiVT
     * Date : 19/10/2023
     */

    @Test
    public void getSalesReportSearch_7() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/admin/sales-report/sreach")
                        .param("startDate",  "null")
                        .param("endDate",  "null")
                        .param("searchTerm",  "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


}
