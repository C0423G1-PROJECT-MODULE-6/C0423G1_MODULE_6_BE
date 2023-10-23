package com.example.c4zone.NghiaNPX.controller;

import com.example.c4zone.dto.supplier.SupplierDto;
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
public class SupplierController_createSupplier {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    /**
     * author: NghiaNPX
     * date: 13/10/2023
     * goal: this function to test data of item [nameSupplier]
     * with [nameSupplier] = null
     *
     * @throws Exception
     */
    @Test
    public void createSupplier_nameSupplier_13() throws Exception {
        SupplierDto supplierDto = new SupplierDto();
        supplierDto.setNameSupplier(null);
        supplierDto.setAddressSupplier("48");
        supplierDto.setPhoneNumberSupplier("0987412589");
        supplierDto.setEmailSupplier("tanlong@gmail.com");
        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/api/admin/business/supplier/create")
                                .content(this.objectMapper.writeValueAsString(supplierDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print()).andExpect(status().is4xxClientError());
    }

    /**
     * author: NghiaNPX
     * date: 13/10/2023
     * goal: this function to test valid data of item [nameSupplier]
     * with [nameSupplier] = ""
     *
     * @throws Exception
     */
    @Test
    public void createSupplier_nameSupplier_14() throws Exception {
        SupplierDto supplierDto = new SupplierDto();
        supplierDto.setNameSupplier("");
        supplierDto.setAddressSupplier("48");
        supplierDto.setPhoneNumberSupplier("0987412589");
        supplierDto.setEmailSupplier("tanlong@gmail.com");
        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/api/admin/business/supplier/create")
                                .content(this.objectMapper.writeValueAsString(supplierDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print()).andExpect(status().is4xxClientError());
    }

    /**
     * author: NghiaNPX
     * date: 13/10/2023
     * goal: this function to test data of item [nameSupplier]
     * with [nameSupplier] in wrong format
     *
     * @throws Exception
     */
    @Test
    public void createSupplier_nameSupplier_15() throws Exception {
        SupplierDto supplierDto = new SupplierDto();
        supplierDto.setNameSupplier("Công ty TNHH Tân T%&^N");
        supplierDto.setAddressSupplier("48");
        supplierDto.setPhoneNumberSupplier("0987412589");
        supplierDto.setEmailSupplier("tanlong@gmail.com");
        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/api/admin/business/supplier/create")
                                .content(this.objectMapper.writeValueAsString(supplierDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print()).andExpect(status().is4xxClientError());
    }

    /**
     * author: NghiaNPX
     * date: 13/10/2023
     * goal: this function to test data of item [nameSupplier]
     * with [nameSupplier] > 100 characters
     *
     * @throws Exception
     */
    @Test
    public void createSupplier_nameSupplier_16() throws Exception {
        SupplierDto supplierDto = new SupplierDto();
        supplierDto.setNameSupplier("Công ty TNHH Nguyễn Phan Xuân NghĩaCông ty TNHH Nguyễn Phan Xuân NghĩaCông ty TNHH Nguyễn Phan Xuân NghĩaCông ty TNHH Nguyễn Phan Xuân NghĩaCông ty TNHH Nguyễn Phan Xuân NghĩaCông ty TNHH Nguyễn Phan Xuân NghĩaCông ty TNHH Nguyễn Phan Xuân NghĩaCông ty TNHH Nguyễn Phan Xuân Nghĩa");
        supplierDto.setAddressSupplier("48");
        supplierDto.setPhoneNumberSupplier("0987412589");
        supplierDto.setEmailSupplier("tanlong@gmail.com");
        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/api/admin/business/supplier/create")
                                .content(this.objectMapper.writeValueAsString(supplierDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print()).andExpect(status().is4xxClientError());
    }

    /**
     * author: NghiaNPX
     * date: 13/10/2023
     * goal: this function to test data of item [nameSupplier]
     * with [nameSupplier] < 2 characters
     *
     * @throws Exception
     */
    @Test
    public void createSupplier_nameSupplier_17() throws Exception {
        SupplierDto supplierDto = new SupplierDto();
        supplierDto.setNameSupplier("a");
        supplierDto.setAddressSupplier("48");
        supplierDto.setPhoneNumberSupplier("0987412589");
        supplierDto.setEmailSupplier("tanlong@gmail.com");
        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/api/admin/business/supplier/create")
                                .content(this.objectMapper.writeValueAsString(supplierDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print()).andExpect(status().is4xxClientError());
    }

    /**
     * author: NghiaNPX
     * date: 13/10/2023
     * goal: this function to test data of item [phoneNumberSupplier]
     * with [phoneNumberSupplier] = null
     *
     * @throws Exception
     */
    @Test
    public void createSupplier_phoneNumberSupplier_13() throws Exception {
        SupplierDto supplierDto = new SupplierDto();
        supplierDto.setNameSupplier("Công Ty TNHH Tân Long");
        supplierDto.setAddressSupplier("48");
        supplierDto.setPhoneNumberSupplier(null);
        supplierDto.setEmailSupplier("tanlong@gmail.com");
        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/api/admin/business/supplier/create")
                                .content(this.objectMapper.writeValueAsString(supplierDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print()).andExpect(status().is4xxClientError());
    }

    /**
     * author: NghiaNPX
     * date: 13/10/2023
     * goal: this function to test data of item [phoneNumberSupplier]
     * with [phoneNumberSupplier] = ""
     *
     * @throws Exception
     */
    @Test
    public void createSupplier_phoneNumberSupplier_14() throws Exception {
        SupplierDto supplierDto = new SupplierDto();
        supplierDto.setNameSupplier("Công Ty TNHH Tân Long");
        supplierDto.setAddressSupplier("48");
        supplierDto.setPhoneNumberSupplier("");
        supplierDto.setEmailSupplier("tanlong@gmail.com");
        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/api/admin/business/supplier/create")
                                .content(this.objectMapper.writeValueAsString(supplierDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print()).andExpect(status().is4xxClientError());
    }

    /**
     * author: NghiaNPX
     * date: 13/10/2023
     * goal: this function to test data of item [phoneNumberSupplier]
     * with [phoneNumberSupplier] in wrong format 1
     *
     * @throws Exception
     */
    @Test
    public void createSupplier_phoneNumberSupplier_1_15() throws Exception {
        SupplierDto supplierDto = new SupplierDto();
        supplierDto.setNameSupplier("Công Ty TNHH Tân Long");
        supplierDto.setAddressSupplier("48");
        supplierDto.setPhoneNumberSupplier("@#%^1524852");
        supplierDto.setEmailSupplier("tanlong@gmail.com");
        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/api/admin/business/supplier/create")
                                .content(this.objectMapper.writeValueAsString(supplierDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print()).andExpect(status().is4xxClientError());
    }

    /**
     * author: NghiaNPX
     * date: 13/10/2023
     * goal: this function to test data of item [phoneNumberSupplier]
     * with [phoneNumberSupplier] in wrong format 2
     *
     * @throws Exception
     */
    @Test
    public void createSupplier_phoneNumberSupplier_2_15() throws Exception {
        SupplierDto supplierDto = new SupplierDto();
        supplierDto.setNameSupplier("Công Ty TNHH Tân Long");
        supplierDto.setAddressSupplier("48");
        supplierDto.setPhoneNumberSupplier("12345678914");
        supplierDto.setEmailSupplier("tanlong@gmail.com");
        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/api/admin/business/supplier/create")
                                .content(this.objectMapper.writeValueAsString(supplierDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print()).andExpect(status().is4xxClientError());
    }

    /**
     * author: NghiaNPX
     * date: 13/10/2023
     * goal: this function to test data of item [phoneNumberSupplier]
     * with [phoneNumberSupplier] > 12 digital characters
     *
     * @throws Exception
     */
    @Test
    public void createSupplier_phoneNumberSupplier_16() throws Exception {
        SupplierDto supplierDto = new SupplierDto();
        supplierDto.setNameSupplier("Công Ty TNHH Tân Long");
        supplierDto.setAddressSupplier("48");
        supplierDto.setPhoneNumberSupplier("09147852147856");
        supplierDto.setEmailSupplier("tanlong@gmail.com");
        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/api/admin/business/supplier/create")
                                .content(this.objectMapper.writeValueAsString(supplierDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print()).andExpect(status().is4xxClientError());
    }

    /**
     * author: NghiaNPX
     * date: 13/10/2023
     * goal: this function to test data of item [phoneNumberSupplier]
     * with [phoneNumberSupplier] < 10 digital characters
     *
     * @throws Exception
     */
    @Test
    public void createSupplier_phoneNumberSupplier_17() throws Exception {
        SupplierDto supplierDto = new SupplierDto();
        supplierDto.setNameSupplier("Công Ty TNHH Tân Long");
        supplierDto.setAddressSupplier("48");
        supplierDto.setPhoneNumberSupplier("0941258");
        supplierDto.setEmailSupplier("tanlong@gmail.com");
        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/api/admin/business/supplier/create")
                                .content(this.objectMapper.writeValueAsString(supplierDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print()).andExpect(status().is4xxClientError());
    }

    /**
     * author: NghiaNPX
     * date: 13/10/2023
     * goal: this function to test data of item [emailSupplier]
     * with [emailSupplier] = null
     *
     * @throws Exception
     */
    @Test
    public void createSupplier_emailSupplier_13() throws Exception {
        SupplierDto supplierDto = new SupplierDto();
        supplierDto.setNameSupplier("Công Ty TNHH Tân Long");
        supplierDto.setAddressSupplier("48");
        supplierDto.setPhoneNumberSupplier("0987412589");
        supplierDto.setEmailSupplier(null);
        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/api/admin/business/supplier/create")
                                .content(this.objectMapper.writeValueAsString(supplierDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print()).andExpect(status().is4xxClientError());
    }

    /**
     * author: NghiaNPX
     * date: 13/10/2023
     * goal: this function to test data of item [emailSupplier]
     * with [emailSupplier] = ""
     *
     * @throws Exception
     */
    @Test
    public void createSupplier_emailSupplier_14() throws Exception {
        SupplierDto supplierDto = new SupplierDto();
        supplierDto.setNameSupplier("Công Ty TNHH Tân Long");
        supplierDto.setAddressSupplier("48");
        supplierDto.setPhoneNumberSupplier("0987412589");
        supplierDto.setEmailSupplier("");
        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/api/admin/business/supplier/create")
                                .content(this.objectMapper.writeValueAsString(supplierDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print()).andExpect(status().is4xxClientError());
    }

    /**
     * author: NghiaNPX
     * date: 13/10/2023
     * goal: this function to test data of item [emailSupplier]
     * with [emailSupplier] wrong format
     *
     * @throws Exception
     */
    @Test
    public void createSupplier_emailSupplier_15() throws Exception {
        SupplierDto supplierDto = new SupplierDto();
        supplierDto.setNameSupplier("Công Ty TNHH Tân Long");
        supplierDto.setAddressSupplier("48");
        supplierDto.setPhoneNumberSupplier("0987412589");
        supplierDto.setEmailSupplier("tanlonggmail.com");
        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/api/admin/business/supplier/create")
                                .content(this.objectMapper.writeValueAsString(supplierDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print()).andExpect(status().is4xxClientError());
    }

    /**
     * author: NghiaNPX
     * date: 13/10/2023
     * goal: this function to test data of item [emailSupplier]
     * with [emailSupplier] > 100 characters
     *
     * @throws Exception
     */
    @Test
    public void createSupplier_emailSupplier_16() throws Exception {
        SupplierDto supplierDto = new SupplierDto();
        supplierDto.setNameSupplier("Công Ty TNHH Tân Long");
        supplierDto.setAddressSupplier("48");
        supplierDto.setPhoneNumberSupplier("0987412589");
        supplierDto.setEmailSupplier("tanlongtanlongtanlongtanlongtanlongtanlongtanlongtanlongtanlongtanlongtanlongtanlongtanlongtanlongtanlongtanlongtanlongtanlongtanlongtanlongtanlongtanlongtanlongtanlongtanlongtanlongtanlongtanlong@gmail.com");
        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/api/admin/business/supplier/create")
                                .content(this.objectMapper.writeValueAsString(supplierDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print()).andExpect(status().is4xxClientError());
    }

    /**
     * author: NghiaNPX
     * date: 13/10/2023
     * goal: this function to test data of item [emailSupplier]
     * with [emailSupplier] < 10 characters
     *
     * @throws Exception
     */
    @Test
    public void createSupplier_emailSupplier_17() throws Exception {
        SupplierDto supplierDto = new SupplierDto();
        supplierDto.setNameSupplier("Công Ty TNHH Tân Long");
        supplierDto.setAddressSupplier("48");
        supplierDto.setPhoneNumberSupplier("0987412589");
        supplierDto.setEmailSupplier("t@gm.vn");
        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/api/admin/business/supplier/create")
                                .content(this.objectMapper.writeValueAsString(supplierDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print()).andExpect(status().is4xxClientError());
    }

    /**
     * author: NghiaNPX
     * date: 13/10/2023
     * goal: this function to test all valid data of items
     * with successfully creation
     *
     * @throws Exception
     */
    @Test
    public void createSupplier_successfully_18() throws Exception {
        SupplierDto supplierDto = new SupplierDto();
        supplierDto.setNameSupplier("Công Ty TNHH Tân Long");
        supplierDto.setAddressSupplier("48");
        supplierDto.setPhoneNumberSupplier("0987412589");
        supplierDto.setEmailSupplier("tanlong@gmail.com");
        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/api/admin/business/supplier/create")
                                .content(this.objectMapper.writeValueAsString(supplierDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print()).andExpect(status().is2xxSuccessful());
    }
}
