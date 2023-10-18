//package com.example.c4zone.NghiaNPX.controller;
//
//import com.example.c4zone.dto.supplier.SupplierDto;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//
//@SpringBootTest
//@AutoConfigureMockMvc
//public class SupplierController_createSupplier {
//    @Autowired
//    private MockMvc mockMvc;
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    /**
//     * author: NghiaNPX
//     * date: 13/10/2023
//     * goal: this function to test valid data of item [codeSupplier]
//     * with a negative number
//     * @throws Exception
//     */
//    @Test
//    public void createSupplier_8() throws Exception{
//        SupplierDto supplierDto = new SupplierDto();
//        supplierDto.setCodeSupplier(-202390);
//        supplierDto.setNameSupplier("Công ty TNHH Tân Long Mobile");
//        supplierDto.setAddressSupplier("Thành phố Đà Nẵng");
//        supplierDto.setPhoneNumberSupplier("0969980926");
//        supplierDto.setEmailSupplier("tanlong@gmail.com");
//        this.mockMvc.perform(
//                MockMvcRequestBuilders.post("/api/admin/supplier/create")
//                        .content(this.objectMapper.writeValueAsString(supplierDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print()).andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * author: NghiaNPX
//     * date: 13/10/2023
//     * goal: this function to test valid data of item [codeSupplier]
//     * with over 6 digits number
//     * @throws Exception
//     */
//    @Test
//    public void createSupplier_9() throws Exception{
//        SupplierDto supplierDto = new SupplierDto();
//        supplierDto.setCodeSupplier(202390484);
//        supplierDto.setNameSupplier("Công ty TNHH Tân Long Mobile");
//        supplierDto.setAddressSupplier("Thành phố Đà Nẵng");
//        supplierDto.setPhoneNumberSupplier("0969980926");
//        supplierDto.setEmailSupplier("tanlong@gmail.com");
//        this.mockMvc.perform(
//                MockMvcRequestBuilders.post("/api/admin/supplier/create")
//                        .content(this.objectMapper.writeValueAsString(supplierDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print()).andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * author: NghiaNPX
//     * date: 13/10/2023
//     * goal: this function to test valid data of item [codeSupplier]
//     * with duplicated value
//     * @throws Exception
//     */
//    @Test
//    public void createSupplier_10() throws Exception{
//        SupplierDto supplierDto = new SupplierDto();
//        supplierDto.setCodeSupplier(202305);
//        supplierDto.setNameSupplier("Công ty TNHH Tân Long Mobile");
//        supplierDto.setAddressSupplier("Thành phố Đà Nẵng");
//        supplierDto.setPhoneNumberSupplier("02363871296");
//        supplierDto.setEmailSupplier("tanlong@gmail.com");
//        this.mockMvc.perform(
//                        MockMvcRequestBuilders.post("/api/admin/supplier/create")
//                                .content(this.objectMapper.writeValueAsString(supplierDto))
//                                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print()).andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * author: NghiaNPX
//     * date: 13/10/2023
//     * goal: this function to test valid data of item [nameSupplier]
//     * with an empty value
//     * @throws Exception
//     */
//    @Test
//    public void createSupplier_2() throws Exception{
//        SupplierDto supplierDto = new SupplierDto();
//        supplierDto.setCodeSupplier(202390);
//        supplierDto.setNameSupplier("");
//        supplierDto.setAddressSupplier("Thành phố Đà Nẵng");
//        supplierDto.setPhoneNumberSupplier("0969980926");
//        supplierDto.setEmailSupplier("tanlong@gmail.com");
//        this.mockMvc.perform(
//                        MockMvcRequestBuilders.post("/api/admin/supplier/create")
//                                .content(this.objectMapper.writeValueAsString(supplierDto))
//                                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print()).andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * author: NghiaNPX
//     * date: 13/10/2023
//     * goal: this function to test valid data of item [nameSupplier]
//     * with digital characters
//     * @throws Exception
//     */
//    @Test
//    public void createSupplier_11() throws Exception{
//        SupplierDto supplierDto = new SupplierDto();
//        supplierDto.setCodeSupplier(202390);
//        supplierDto.setNameSupplier("15489");
//        supplierDto.setAddressSupplier("Thành phố Đà Nẵng");
//        supplierDto.setPhoneNumberSupplier("0969980926");
//        supplierDto.setEmailSupplier("tanlong@gmail.com");
//        this.mockMvc.perform(
//                        MockMvcRequestBuilders.post("/api/admin/supplier/create")
//                                .content(this.objectMapper.writeValueAsString(supplierDto))
//                                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print()).andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * author: NghiaNPX
//     * date: 13/10/2023
//     * goal: this function to test valid data of item [nameSupplier]
//     * with special character values
//     * @throws Exception
//     */
//    @Test
//    public void createSupplier_12() throws Exception{
//        SupplierDto supplierDto = new SupplierDto();
//        supplierDto.setCodeSupplier(202390);
//        supplierDto.setNameSupplier("&#*(@+;>,<");
//        supplierDto.setAddressSupplier("Thành phố Đà Nẵng");
//        supplierDto.setPhoneNumberSupplier("0969980926");
//        supplierDto.setEmailSupplier("tanlong@gmail.com");
//        this.mockMvc.perform(
//                        MockMvcRequestBuilders.post("/api/admin/supplier/create")
//                                .content(this.objectMapper.writeValueAsString(supplierDto))
//                                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print()).andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * author: NghiaNPX
//     * date: 13/10/2023
//     * goal: this function to test valid data of item [nameSupplier]
//     * with over 100 characters of value
//     * @throws Exception
//     */
//    @Test
//    public void createSupplier_13() throws Exception{
//        SupplierDto supplierDto = new SupplierDto();
//        supplierDto.setCodeSupplier(202390);
//        supplierDto.setNameSupplier("Nguyễn Phan Xuân Nghĩa Nguyễn Phan Xuân Nghĩa Nguyễn Phan Xuân Nghĩa Nguyễn Phan Xuân Nghĩa Nguyễn Phan Xuân Nghĩa Nguyễn Phan Xuân Nghĩa Nguyễn Phan Xuân Nghĩa Nguyễn Phan Xuân Nghĩa Nguyễn Phan Xuân Nghĩa Nguyễn Phan Xuân Nghĩa Nguyễn Phan Xuân Nghĩa Nguyễn Phan Xuân Nghĩa Nguyễn Phan Xuân Nghĩa Nguyễn Phan Xuân Nghĩa Nguyễn Phan Xuân Nghĩa Nguyễn Phan Xuân Nghĩa Nguyễn Phan Xuân Nghĩa Nguyễn Phan Xuân Nghĩa Nguyễn Phan Xuân Nghĩa Nguyễn Phan Xuân Nghĩa ");
//        supplierDto.setAddressSupplier("Thành phố Đà Nẵng");
//        supplierDto.setPhoneNumberSupplier("0969980926");
//        supplierDto.setEmailSupplier("tanlong@gmail.com");
//        this.mockMvc.perform(
//                        MockMvcRequestBuilders.post("/api/admin/supplier/create")
//                                .content(this.objectMapper.writeValueAsString(supplierDto))
//                                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print()).andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * author: NghiaNPX
//     * date: 13/10/2023
//     * goal: this function to test valid data of item [phoneNumberSupplier]
//     * with an empty value
//     * @throws Exception
//     */
//    @Test
//    public void createSupplier_3() throws Exception{
//        SupplierDto supplierDto = new SupplierDto();
//        supplierDto.setCodeSupplier(202390);
//        supplierDto.setNameSupplier("Công ty TNHH Tân Long Mobile");
//        supplierDto.setAddressSupplier("Thành phố Đà Nẵng");
//        supplierDto.setPhoneNumberSupplier("");
//        supplierDto.setEmailSupplier("tanlong@gmail.com");
//        this.mockMvc.perform(
//                        MockMvcRequestBuilders.post("/api/admin/supplier/create")
//                                .content(this.objectMapper.writeValueAsString(supplierDto))
//                                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print()).andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * author: NghiaNPX
//     * date: 13/10/2023
//     * goal: this function to test valid data of item [phoneNumberSupplier]
//     * with over 12 digits
//     * @throws Exception
//     */
//    @Test
//    public void createSupplier_15() throws Exception{
//        SupplierDto supplierDto = new SupplierDto();
//        supplierDto.setCodeSupplier(202390);
//        supplierDto.setNameSupplier("Công ty TNHH Tân Long Mobile");
//        supplierDto.setAddressSupplier("Thành phố Đà Nẵng");
//        supplierDto.setPhoneNumberSupplier("0969980926132");
//        supplierDto.setEmailSupplier("tanlong@gmail.com");
//        this.mockMvc.perform(
//                        MockMvcRequestBuilders.post("/api/admin/supplier/create")
//                                .content(this.objectMapper.writeValueAsString(supplierDto))
//                                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print()).andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * author: NghiaNPX
//     * date: 13/10/2023
//     * goal: this function to test valid data of item [phoneNumberSupplier]
//     * with a value of special character or letters
//     * @throws Exception
//     */
//    @Test
//    public void createSupplier_16() throws Exception{
//        SupplierDto supplierDto = new SupplierDto();
//        supplierDto.setCodeSupplier(202390);
//        supplierDto.setNameSupplier("Công ty TNHH Tân Long Mobile");
//        supplierDto.setAddressSupplier("Thành phố Đà Nẵng");
//        supplierDto.setPhoneNumberSupplier("@#%#abkqw");
//        supplierDto.setEmailSupplier("tanlong@gmail.com");
//        this.mockMvc.perform(
//                        MockMvcRequestBuilders.post("/api/admin/supplier/create")
//                                .content(this.objectMapper.writeValueAsString(supplierDto))
//                                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print()).andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * author: NghiaNPX
//     * date: 13/10/2023
//     * goal: this function to test valid data of item [phoneNumberSupplier]
//     * with wrong format
//     * @throws Exception
//     */
//    @Test
//    public void createSupplier_17() throws Exception{
//        SupplierDto supplierDto = new SupplierDto();
//        supplierDto.setCodeSupplier(202390);
//        supplierDto.setNameSupplier("Công ty TNHH Tân Long Mobile");
//        supplierDto.setAddressSupplier("Thành phố Đà Nẵng");
//        supplierDto.setPhoneNumberSupplier("1969980926");
//        supplierDto.setEmailSupplier("tanlong@gmail.com");
//        this.mockMvc.perform(
//                        MockMvcRequestBuilders.post("/api/admin/supplier/create")
//                                .content(this.objectMapper.writeValueAsString(supplierDto))
//                                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print()).andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * author: NghiaNPX
//     * date: 13/10/2023
//     * goal: this function to test valid data of item [emailSupplier]
//     * with an empty value
//     * @throws Exception
//     */
//    @Test
//    public void createSupplier_4() throws Exception{
//        SupplierDto supplierDto = new SupplierDto();
//        supplierDto.setCodeSupplier(202390);
//        supplierDto.setNameSupplier("Công ty TNHH Tân Long Mobile");
//        supplierDto.setAddressSupplier("Thành phố Đà Nẵng");
//        supplierDto.setPhoneNumberSupplier("0969980926");
//        supplierDto.setEmailSupplier("");
//        this.mockMvc.perform(
//                        MockMvcRequestBuilders.post("/api/admin/supplier/create")
//                                .content(this.objectMapper.writeValueAsString(supplierDto))
//                                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print()).andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * author: NghiaNPX
//     * date: 13/10/2023
//     * goal: this function to test valid data of item [emailSupplier]
//     * with wrong format
//     * @throws Exception
//     */
//    @Test
//    public void createSupplier_19() throws Exception{
//        SupplierDto supplierDto = new SupplierDto();
//        supplierDto.setCodeSupplier(202390);
//        supplierDto.setNameSupplier("Công ty TNHH Tân Long Mobile");
//        supplierDto.setAddressSupplier("Thành phố Đà Nẵng");
//        supplierDto.setPhoneNumberSupplier("0969980926");
//        supplierDto.setEmailSupplier("tanlonggmail.com");
//        this.mockMvc.perform(
//                        MockMvcRequestBuilders.post("/api/admin/supplier/create")
//                                .content(this.objectMapper.writeValueAsString(supplierDto))
//                                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print()).andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * author: NghiaNPX
//     * date: 13/10/2023
//     * goal: this function to test valid data of item [emailSupplier]
//     * with over 100 characters
//     * @throws Exception
//     */
//    @Test
//    public void createSupplier_20() throws Exception{
//        SupplierDto supplierDto = new SupplierDto();
//        supplierDto.setNameSupplier("Công ty TNHH Tân Long Mobile");
//        supplierDto.setAddressSupplier("Thành phố Đà Nẵng");
//        supplierDto.setPhoneNumberSupplier("0969980926");
//        supplierDto.setEmailSupplier("tanlongtanlongtanlongtanlongtanlongtanlongtanlongtanlongtanlongtanlongtanlongtanlongtanlongtanlongtanlongtanlongtanlongtanlongtanlongtanlongtanlongtanlongtanlongtanlongtanlon@gmail.com");
//        this.mockMvc.perform(
//                        MockMvcRequestBuilders.post("/api/admin/supplier/create")
//                                .content(this.objectMapper.writeValueAsString(supplierDto))
//                                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print()).andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * author: NghiaNPX
//     * date: 13/10/2023
//     * goal: this function to test successful creation for supplier object
//     * @throws Exception
//     */
//    @Test
//    public void createSupplier_22() throws Exception{
//        SupplierDto supplierDto = new SupplierDto();
//        supplierDto.setCodeSupplier(202412);
//        supplierDto.setNameSupplier("Công ty TNHH Tân Long Mobile");
//        supplierDto.setAddressSupplier("Thành phố Đà Nẵng");
//        supplierDto.setPhoneNumberSupplier("0969980926");
//        supplierDto.setEmailSupplier("tanlong@gmail.com");
//        this.mockMvc.perform(
//                        MockMvcRequestBuilders.post("/api/admin/supplier/create")
//                                .content(this.objectMapper.writeValueAsString(supplierDto))
//                                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print()).andExpect(status().is2xxSuccessful());
//    }
//}
