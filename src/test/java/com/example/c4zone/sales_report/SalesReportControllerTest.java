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
    public void getProduct_11() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/admin/sales-report/product"))
                .andDo(print())
                .andExpect(jsonPath("$[0].idProduct").value(1))
                .andExpect(jsonPath("$[0].nameProduct").value("Iphone 11"))
                .andExpect(status().is2xxSuccessful());

    }

    /**
     * Returns list of sales report
     * Author : LoiVT
     * Date : 19/10/2023
     */
    @Test
    public void getSalesReport_11() throws Exception {
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
     * show list sales report when searchTerm is empty
     * Author : LoiVT
     * Date : 19/10/2023
     */
    @Test
    public void getSalesReportSearch_4() throws Exception {
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
    public void getSalesReportSearch_3() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/admin/sales-report/sreach")
                        .param("startDate", "2023-10-01")
                        .param("endDate", "2023-10-15")
                        .param("searchTerm", "aaaaaaaaaa"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$[0].name").value("Tất Cả"))
                .andExpect(jsonPath("$[0].date").value("2023-10-01"))
                .andExpect(jsonPath("$[0].quantity").value(0))
                .andExpect(jsonPath("$[0].daily").value(0));
    }

}
