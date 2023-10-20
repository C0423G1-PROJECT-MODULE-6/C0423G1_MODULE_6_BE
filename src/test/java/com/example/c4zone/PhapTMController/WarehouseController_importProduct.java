package com.example.c4zone.PhapTMController;

import com.example.c4zone.dto.warehouse.WarehouseDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class WarehouseController_importProduct {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    /**
     * input warehouseDto is null
     * author: PhapTM
     *
     * @throws Exception
     */
    @Test
    public void importProduct_13() throws Exception {
        WarehouseDto warehouseDto = new WarehouseDto();
        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/api/admin/warehouse/create")
                                .content(this.objectMapper.writeValueAsString(warehouseDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * input quantity less than 0 or equals 0
     * author: PhapTM
     *
     * @throws Exception
     */

    @Test
    public void importProduct_NO_17() throws Exception {
        WarehouseDto warehouseDto = new WarehouseDto();
        warehouseDto.setIdWarehouse(16L);
        warehouseDto.setInputDate("17-10-2023");
        warehouseDto.setProductId(2L);
        warehouseDto.setQuantity(-10);
        warehouseDto.setSupplierId(1L);
        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/api/admin/warehouse/create")
                                .content(this.objectMapper.writeValueAsString(warehouseDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE)
                )
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     *
     * @throws Exception
     */
    @Test
    public void importProduct_moreThan_NO_17() throws Exception {
        WarehouseDto warehouseDto = new WarehouseDto();
        warehouseDto.setIdWarehouse(16L);
        warehouseDto.setInputDate("17-10-2023");
        warehouseDto.setProductId(2L);
        warehouseDto.setQuantity(3000);
        warehouseDto.setSupplierId(1L);
        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/api/admin/warehouse/create")
                                .content(this.objectMapper.writeValueAsString(warehouseDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE)
                )
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * input id product is null
     * create: PhapTM
     *
     * @throws Exception
     */
    @Test
    public void importProduct_product_NO_13() throws Exception {
        WarehouseDto warehouseDto = new WarehouseDto();
        warehouseDto.setIdWarehouse(16L);
        warehouseDto.setInputDate("17-10-2023");
        warehouseDto.setProductId(null);
        warehouseDto.setQuantity(110);
        warehouseDto.setSupplierId(1L);
        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/api/admin/warehouse/create")
                                .content(this.objectMapper.writeValueAsString(warehouseDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE)
                )
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * input id supplier is null
     * create: PhapTM
     *
     * @throws Exception
     */
    @Test
    public void importProduct_supplier_NO_13() throws Exception {
        WarehouseDto warehouseDto = new WarehouseDto();
        warehouseDto.setIdWarehouse(16L);
        warehouseDto.setInputDate("17-10-2023");
        warehouseDto.setProductId(2L);
        warehouseDto.setQuantity(110);
        warehouseDto.setSupplierId(null);
        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/api/admin/warehouse/create")
                                .content(this.objectMapper.writeValueAsString(warehouseDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE)
                )
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * input quantity is null
     * create: PhapTM
     *
     * @throws Exception
     */
    @Test
    public void importProduct_quantity_NO_13() throws Exception {
        WarehouseDto warehouseDto = new WarehouseDto();
        warehouseDto.setIdWarehouse(16L);
        warehouseDto.setInputDate("17-10-2023");
        warehouseDto.setProductId(2L);
        warehouseDto.setQuantity(null);
        warehouseDto.setSupplierId(1L);
        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/api/admin/warehouse/create")
                                .content(this.objectMapper.writeValueAsString(warehouseDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE)
                )
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * input success data for create
     * create: PhapTM
     *
     * @throws Exception
     */
    @Test
    public void importProduct_NO_18() throws Exception {
        WarehouseDto warehouseDto = new WarehouseDto();
        warehouseDto.setIdWarehouse(17L);
        warehouseDto.setInputDate("17-10-2023");
        warehouseDto.setProductId(2L);
        warehouseDto.setQuantity(420);
        warehouseDto.setSupplierId(1L);
        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/api/admin/warehouse/create")
                                .content(this.objectMapper.writeValueAsString(warehouseDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE)
                )
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
