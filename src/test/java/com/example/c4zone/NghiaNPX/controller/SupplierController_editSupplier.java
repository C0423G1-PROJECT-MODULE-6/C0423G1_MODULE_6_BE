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
import org.springframework.web.util.UriComponentsBuilder;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class SupplierController_editSupplier {
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
    public void editSupplier_nameSupplier_19() throws Exception {
        SupplierDto supplierDto = new SupplierDto();
        supplierDto.setIdSupplier(5L);
        supplierDto.setNameSupplier(null);
        supplierDto.setAddressSupplier("Thành phố Cần Thơ");
        supplierDto.setPhoneNumberSupplier("07103665665");
        supplierDto.setEmailSupplier("kienquoc@gmail.com");
        this.mockMvc.perform(
                        MockMvcRequestBuilders.patch("/api/admin/supplier/edit/5")
                                .content(this.objectMapper.writeValueAsString(supplierDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print()).andExpect(status().is4xxClientError());
    }

    /**
     * author: NghiaNPX
     * date: 13/10/2023
     * goal: this function to test data of item [nameSupplier]
     * with [nameSupplier] = ""
     *
     * @throws Exception
     */
    @Test
    public void editSupplier_nameSupplier_20() throws Exception {
        SupplierDto supplierDto = new SupplierDto();
        supplierDto.setIdSupplier(5L);
        supplierDto.setNameSupplier("");
        supplierDto.setAddressSupplier("Thành phố Cần Thơ");
        supplierDto.setPhoneNumberSupplier("07103665665");
        supplierDto.setEmailSupplier("kienquoc@gmail.com");
        this.mockMvc.perform(
                        MockMvcRequestBuilders.patch("/api/admin/supplier/edit/5")
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
    public void editSupplier_nameSupplier_21() throws Exception {
        SupplierDto supplierDto = new SupplierDto();
        supplierDto.setIdSupplier(5L);
        supplierDto.setNameSupplier("1549#$%");
        supplierDto.setAddressSupplier("Thành phố Cần Thơ");
        supplierDto.setPhoneNumberSupplier("07103665665");
        supplierDto.setEmailSupplier("kienquoc@gmail.com");
        this.mockMvc.perform(
                        MockMvcRequestBuilders.patch("/api/admin/supplier/edit/5")
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
    public void editSupplier_nameSupplier_22() throws Exception {
        SupplierDto supplierDto = new SupplierDto();
        supplierDto.setIdSupplier(5L);
        supplierDto.setNameSupplier("Công ty TNHH Nguyễn Phan Xuân NghĩaCông ty TNHH Nguyễn Phan Xuân NghĩaCông ty TNHH Nguyễn Phan Xuân NghĩaCông ty TNHH Nguyễn Phan Xuân NghĩaCông ty TNHH Nguyễn Phan Xuân NghĩaCông ty TNHH Nguyễn Phan Xuân NghĩaCông ty TNHH Nguyễn Phan Xuân NghĩaCông ty TNHH Nguyễn Phan Xuân Nghĩa");
        supplierDto.setAddressSupplier("Thành phố Cần Thơ");
        supplierDto.setPhoneNumberSupplier("07103665665");
        supplierDto.setEmailSupplier("kienquoc@gmail.com");
        this.mockMvc.perform(
                        MockMvcRequestBuilders.patch("/api/admin/supplier/edit/5")
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
    public void editSupplier_nameSupplier_23() throws Exception {
        SupplierDto supplierDto = new SupplierDto();
        supplierDto.setIdSupplier(5L);
        supplierDto.setNameSupplier("a");
        supplierDto.setAddressSupplier("Thành phố Cần Thơ");
        supplierDto.setPhoneNumberSupplier("07103665665");
        supplierDto.setEmailSupplier("kienquoc@gmail.com");
        this.mockMvc.perform(
                        MockMvcRequestBuilders.patch("/api/admin/supplier/edit/5")
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
    public void editSupplier_phoneNumberSupplier_19() throws Exception {
        SupplierDto supplierDto = new SupplierDto();
        supplierDto.setIdSupplier(5L);
        supplierDto.setNameSupplier("Công Ty TNHH MTV TMDV Hữu Hải");
        supplierDto.setAddressSupplier("Thành phố Cần Thơ");
        supplierDto.setPhoneNumberSupplier(null);
        supplierDto.setEmailSupplier("kienquoc@gmail.com");
        this.mockMvc.perform(
                        MockMvcRequestBuilders.patch("/api/admin/supplier/edit/5")
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
    public void editSupplier_phoneNumberSupplier_20() throws Exception {
        SupplierDto supplierDto = new SupplierDto();
        supplierDto.setIdSupplier(5L);
        supplierDto.setNameSupplier("Công Ty TNHH MTV TMDV Hữu Hải");
        supplierDto.setAddressSupplier("Thành phố Cần Thơ");
        supplierDto.setPhoneNumberSupplier("");
        supplierDto.setEmailSupplier("kienquoc@gmail.com");
        this.mockMvc.perform(
                        MockMvcRequestBuilders.patch("/api/admin/supplier/edit/5")
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
    public void editSupplier_phoneNumberSupplier_1_21() throws Exception {
        SupplierDto supplierDto = new SupplierDto();
        supplierDto.setIdSupplier(5L);
        supplierDto.setNameSupplier("Công Ty TNHH MTV TMDV Hữu Hải");
        supplierDto.setAddressSupplier("Thành phố Cần Thơ");
        supplierDto.setPhoneNumberSupplier("@#%^1524852");
        supplierDto.setEmailSupplier("kienquoc@gmail.com");
        this.mockMvc.perform(
                        MockMvcRequestBuilders.patch("/api/admin/supplier/edit/5")
                                .content(this.objectMapper.writeValueAsString(supplierDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print()).andExpect(status().is4xxClientError());
    }

    /**
     * author: NghiaNPX
     * date: 13/10/2023
     * goal: this function to test data of item [phoneNumberSupplier]
     * with [phoneNumberSupplier] wrong format 2
     *
     * @throws Exception
     */
    @Test
    public void editSupplier_phoneNumberSupplier_2_21() throws Exception {
        SupplierDto supplierDto = new SupplierDto();
        supplierDto.setIdSupplier(5L);
        supplierDto.setNameSupplier("Công Ty TNHH MTV TMDV Hữu Hải");
        supplierDto.setAddressSupplier("Thành phố Cần Thơ");
        supplierDto.setPhoneNumberSupplier("12345678914");
        supplierDto.setEmailSupplier("kienquoc@gmail.com");
        this.mockMvc.perform(
                        MockMvcRequestBuilders.patch("/api/admin/supplier/edit/5")
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
    public void editSupplier_phoneNumberSupplier_22() throws Exception {
        SupplierDto supplierDto = new SupplierDto();
        supplierDto.setIdSupplier(5L);
        supplierDto.setNameSupplier("Công Ty TNHH MTV TMDV Hữu Hải");
        supplierDto.setAddressSupplier("Thành phố Cần Thơ");
        supplierDto.setPhoneNumberSupplier("09147852147856");
        supplierDto.setEmailSupplier("kienquoc@gmail.com");
        this.mockMvc.perform(
                        MockMvcRequestBuilders.patch("/api/admin/supplier/edit/5")
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
    public void editSupplier_phoneNumberSupplier_23() throws Exception {
        SupplierDto supplierDto = new SupplierDto();
        supplierDto.setIdSupplier(5L);
        supplierDto.setNameSupplier("Công Ty TNHH MTV TMDV Hữu Hải");
        supplierDto.setAddressSupplier("Thành phố Cần Thơ");
        supplierDto.setPhoneNumberSupplier("0941258");
        supplierDto.setEmailSupplier("kienquoc@gmail.com");
        this.mockMvc.perform(
                        MockMvcRequestBuilders.patch("/api/admin/supplier/edit/5")
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
    public void editSupplier_emailSupplier_19() throws Exception {
        SupplierDto supplierDto = new SupplierDto();
        supplierDto.setIdSupplier(5L);
        supplierDto.setNameSupplier("Công Ty TNHH MTV TMDV Hữu Hải");
        supplierDto.setAddressSupplier("Thành phố Cần Thơ");
        supplierDto.setPhoneNumberSupplier("07103665665");
        supplierDto.setEmailSupplier(null);
        this.mockMvc.perform(
                        MockMvcRequestBuilders.patch("/api/admin/supplier/edit/5")
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
    public void editSupplier_emailSupplier_20() throws Exception {
        SupplierDto supplierDto = new SupplierDto();
        supplierDto.setIdSupplier(5L);
        supplierDto.setNameSupplier("Công Ty TNHH MTV TMDV Hữu Hải");
        supplierDto.setAddressSupplier("Thành phố Cần Thơ");
        supplierDto.setPhoneNumberSupplier("07103665665");
        supplierDto.setEmailSupplier("");
        this.mockMvc.perform(
                        MockMvcRequestBuilders.patch("/api/admin/supplier/edit/5")
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
    public void editSupplier_emailSupplier_21() throws Exception {
        SupplierDto supplierDto = new SupplierDto();
        supplierDto.setIdSupplier(5L);
        supplierDto.setNameSupplier("Công Ty TNHH MTV TMDV Hữu Hải");
        supplierDto.setAddressSupplier("Thành phố Cần Thơ");
        supplierDto.setPhoneNumberSupplier("07103665665");
        supplierDto.setEmailSupplier("tanlonggmail.com");
        this.mockMvc.perform(
                        MockMvcRequestBuilders.patch("/api/admin/supplier/edit/5")
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
    public void editSupplier_emailSupplier_22() throws Exception {
        SupplierDto supplierDto = new SupplierDto();
        supplierDto.setIdSupplier(5L);
        supplierDto.setNameSupplier("Công Ty TNHH MTV TMDV Hữu Hải");
        supplierDto.setAddressSupplier("Thành phố Cần Thơ");
        supplierDto.setPhoneNumberSupplier("07103665665");
        supplierDto.setEmailSupplier("tanlongtanlongtanlongtanlongtanlongtanlongtanlongtanlongtanlongtanlongtanlongtanlongtanlongtanlongtanlongtanlongtanlongtanlongtanlongtanlongtanlongtanlongtanlongtanlongtanlongtanlongtanlongtanlong@gmail.com");
        this.mockMvc.perform(
                        MockMvcRequestBuilders.patch("/api/admin/supplier/edit/5")
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
    public void editSupplier_emailSupplier_24() throws Exception {
        SupplierDto supplierDto = new SupplierDto();
        supplierDto.setIdSupplier(5L);
        supplierDto.setNameSupplier("Công Ty TNHH MTV TMDV Hữu Hải");
        supplierDto.setAddressSupplier("Thành phố Cần Thơ");
        supplierDto.setPhoneNumberSupplier("07103665665");
        supplierDto.setEmailSupplier("t@gm.vn");
        this.mockMvc.perform(
                        MockMvcRequestBuilders.patch("/api/admin/supplier/edit/5")
                                .content(this.objectMapper.writeValueAsString(supplierDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print()).andExpect(status().is4xxClientError());
    }

    /**
     * author: NghiaNPX
     * date: 13/10/2023
     * goal: this function to test all valid data of items
     * with successfully update
     *
     * @throws Exception
     */
    @Test
    public void editSupplier_successfully_24() throws Exception {
        SupplierDto supplierDto = new SupplierDto();
        supplierDto.setIdSupplier(5L);
        supplierDto.setNameSupplier("Công Ty TNHH MTV TMDV Hữu Hải");
        supplierDto.setAddressSupplier("Thành phố Cần Thơ");
        supplierDto.setPhoneNumberSupplier("07103665665");
        supplierDto.setEmailSupplier("kienquoc@gmail.com");
        this.mockMvc.perform(
                        MockMvcRequestBuilders.patch("/api/admin/supplier/edit/5")
                                .content(this.objectMapper.writeValueAsString(supplierDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print()).andExpect(status().is2xxSuccessful());
    }
}
