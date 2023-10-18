package com.example.c4zone.customer_controller;
import com.example.c4zone.dto.customer.CustomerDto;
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
public class CustomerRestController_CreateCustomer {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    /**
     * this function use to test the validation of field name more specific is null
     * Author: TinDT
     */
    @Test
    public void create_Customer_name_13() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setNameCustomer(null);
        customerDto.setDateOfBirthCustomer("2002-10-03");
        customerDto.setAddressCustomer("16 Mỹ khê Đà Nẵng");
        customerDto.setGenderCustomer(true);
        customerDto.setPhoneNumberCustomer("0339779768");
        customerDto.setEmailCustomer("thoaitin@gmail.com");
        customerDto.setStatusCustomer(true);

        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/api/admin/customer/create")
                                .content(this.objectMapper.writeValueAsString(customerDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print()).andExpect(status().is4xxClientError());
    }
    /**
     * this function use to test the validation of field name more specific is empty
     * Author: TinDT
     */
    @Test
    public void create_Customer_name_14() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setNameCustomer("");
        customerDto.setDateOfBirthCustomer("2002-10-03");
        customerDto.setAddressCustomer("16 Mỹ khê Đà Nẵng");
        customerDto.setGenderCustomer(true);
        customerDto.setPhoneNumberCustomer("0339779768");
        customerDto.setEmailCustomer("thoaitin@gmail.com");
        customerDto.setStatusCustomer(true);

        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/api/admin/customer/create")
                                .content(this.objectMapper.writeValueAsString(customerDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print()).andExpect(status().is4xxClientError());
    }
    /**
     * This function is used to check the validation of a specific field name that is not in the validate format
     * Author: TinDT
     */
    @Test
    public void create_Customer_name_15() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setNameCustomer("damthoaitin@");
        customerDto.setDateOfBirthCustomer("2002-10-03");
        customerDto.setAddressCustomer("16 Mỹ khê Đà Nẵng");
        customerDto.setGenderCustomer(true);
        customerDto.setPhoneNumberCustomer("0339779768");
        customerDto.setEmailCustomer("thoaitin@gmail.com");

        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/api/admin/customer/create")
                                .content(this.objectMapper.writeValueAsString(customerDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print()).andExpect(status().is4xxClientError());
    }
    /**
     * This function is used to check specific field name validation instead of validation
     shorter character length 2
     * * Author: TinDT
     */
    @Test
    public void create_Customer_name_16() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setNameCustomer("A");
        customerDto.setDateOfBirthCustomer("2002-10-03");
        customerDto.setAddressCustomer("16 Mỹ khê Đà Nẵng");
        customerDto.setGenderCustomer(true);
        customerDto.setPhoneNumberCustomer("0339779768");
        customerDto.setEmailCustomer("thoaitin@gmail.com");

        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/api/admin/customer/create")
                                .content(this.objectMapper.writeValueAsString(customerDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print()).andExpect(status().is4xxClientError());
    }
    /**
     * This function is used to check specific field name validation instead of validation
     longer character length 100
     * Author: TinDT
     */
    @Test
    public void create_Customer_name_17() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setNameCustomer("Đàmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm");
        customerDto.setDateOfBirthCustomer("2002-10-03");
        customerDto.setAddressCustomer("16 Mỹ khê Đà Nẵng");
        customerDto.setGenderCustomer(true);
        customerDto.setPhoneNumberCustomer("0339779768");
        customerDto.setEmailCustomer("thoaitin@gmail.com");
        customerDto.setStatusCustomer(true);

        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/api/admin/customer/create")
                                .content(this.objectMapper.writeValueAsString(customerDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print()).andExpect(status().is4xxClientError());
    }
    /**
     * this function use to test the validation of field day of birth more specific is null
     * Author: TinDT
     */
    @Test
    public void create_Customer_DayOfBirth_13() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setNameCustomer("Đàm Thoại Tin");
        customerDto.setDateOfBirthCustomer(null);
        customerDto.setAddressCustomer("16 Mỹ khê Đà Nẵng");
        customerDto.setGenderCustomer(true);
        customerDto.setPhoneNumberCustomer("0339779768");
        customerDto.setEmailCustomer("thoaitin@gmail.com");
        customerDto.setStatusCustomer(true);

        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/api/admin/customer/create")
                                .content(this.objectMapper.writeValueAsString(customerDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print()).andExpect(status().is4xxClientError());
    }
    /**
     * this function use to test the validation of field day of birth more specific is empty
     * Author: TinDT
     */
    @Test
    public void create_Customer_dayOfBirth_14() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setNameCustomer("Đàm Thoại Tin");
        customerDto.setDateOfBirthCustomer("");
        customerDto.setAddressCustomer("16 Mỹ khê Đà Nẵng");
        customerDto.setGenderCustomer(true);
        customerDto.setPhoneNumberCustomer("0339779768");
        customerDto.setEmailCustomer("thoaitin@gmail.com");
        customerDto.setStatusCustomer(true);

        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/api/admin/customer/create")
                                .content(this.objectMapper.writeValueAsString(customerDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print()).andExpect(status().is4xxClientError());
    }
    /**
     * This function is used to check the validation of a specific field day of birth that is not in the validate format
     * Author: TinDT
     */
    @Test
    public void create_Customer_dayOfBirth_15() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setNameCustomer("Đàm Thoại Tin ");
        customerDto.setDateOfBirthCustomer("2002-10/03");
        customerDto.setAddressCustomer("16 Mỹ khê Đà Nẵng");
        customerDto.setGenderCustomer(true);
        customerDto.setPhoneNumberCustomer("0339779768");
        customerDto.setEmailCustomer("thoaitin@gmail.com");

        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/api/admin/customer/create")
                                .content(this.objectMapper.writeValueAsString(customerDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print()).andExpect(status().is4xxClientError());
    }
    /**
     * This function is used to check the validation of a specific field day of birth beyond actual time
     * Author: TinDT
     */
    @Test
    public void create_Customer_dayOfBirth_99() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setNameCustomer("Đàm Thoại Tin ");
        customerDto.setDateOfBirthCustomer("2030-10-03");
        customerDto.setAddressCustomer("16 Mỹ khê Đà Nẵng");
        customerDto.setGenderCustomer(true);
        customerDto.setPhoneNumberCustomer("0339779768");
        customerDto.setEmailCustomer("thoaitin@gmail.com");

        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/api/admin/customer/create")
                                .content(this.objectMapper.writeValueAsString(customerDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print()).andExpect(status().is4xxClientError());
    }
    /**
     * This function is used to check the validation of a specific field phone number is null
     * Author: TinDT
     */
    @Test
    public void create_Customer_phoneOfNumber_13() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setNameCustomer("Đàm Thoại Tin");
        customerDto.setDateOfBirthCustomer("2000-10-03");
        customerDto.setAddressCustomer("16 Mỹ khê Đà Nẵng");
        customerDto.setGenderCustomer(true);
        customerDto.setPhoneNumberCustomer(null);
        customerDto.setEmailCustomer("thoaitin@gmail.com");

        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/api/admin/customer/create")
                                .content(this.objectMapper.writeValueAsString(customerDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print()).andExpect(status().is4xxClientError());
    }
    /**
     * This function is used to check the validation of a specific field phone number is empty
     * Author: TinDT
     */
    @Test
    public void create_Customer_phoneOfNumber_14() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setNameCustomer("Đàm Thoại Tin");
        customerDto.setDateOfBirthCustomer("2000-10-03");
        customerDto.setAddressCustomer("16 Mỹ khê Đà Nẵng");
        customerDto.setGenderCustomer(true);
        customerDto.setPhoneNumberCustomer("");
        customerDto.setEmailCustomer("thoaitin@gmail.com");

        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/api/admin/customer/create")
                                .content(this.objectMapper.writeValueAsString(customerDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print()).andExpect(status().is4xxClientError());
    }
    /**
     * This function is used to check the validation of a specific field phone number is  not in the validate format
     * Author: TinDT
     */
    @Test
    public void create_Customer_phoneOfNumber_15() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setNameCustomer("Đàm Thoại Tin");
        customerDto.setDateOfBirthCustomer("2000-10-03");
        customerDto.setAddressCustomer("16 Mỹ khê Đà Nẵng");
        customerDto.setGenderCustomer(true);
        customerDto.setPhoneNumberCustomer("0222a36658");
        customerDto.setEmailCustomer("thoaitin@gmail.com");

        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/api/admin/customer/create")
                                .content(this.objectMapper.writeValueAsString(customerDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print()).andExpect(status().is4xxClientError());
    }
    /**
     * This function is used to check specific field phone number validation instead of validation shorter character length 10
     * Author: TinDT
     */
    @Test
    public void create_Customer_phoneOfNumber_16() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setNameCustomer("Đàm Thoại Tin");
        customerDto.setDateOfBirthCustomer("2000-10-03");
        customerDto.setAddressCustomer("16 Mỹ khê Đà Nẵng");
        customerDto.setGenderCustomer(true);
        customerDto.setPhoneNumberCustomer("033977876");
        customerDto.setEmailCustomer("thoaitin@gmail.com");

        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/api/admin/customer/create")
                                .content(this.objectMapper.writeValueAsString(customerDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print()).andExpect(status().is4xxClientError());
    }
    /**
     * This function is used to check specific field phone number validation instead of validation longer character length 11
     * Author: TinDT
     */
    @Test
    public void create_Customer_phoneOfNumber_17() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setNameCustomer("Đàm Thoại Tin");
        customerDto.setDateOfBirthCustomer("2000-10-03");
        customerDto.setAddressCustomer("16 Mỹ khê Đà Nẵng");
        customerDto.setGenderCustomer(true);
        customerDto.setPhoneNumberCustomer("033977876");
        customerDto.setEmailCustomer("thoaitin@gmail.com");

        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/api/admin/customer/create")
                                .content(this.objectMapper.writeValueAsString(customerDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print()).andExpect(status().is4xxClientError());
    }
    /**
     * This function is used to check whether a phone number exists or not
     * * Author: TinDT
     */
    @Test
    public void create_Customer_phone_number_99() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setNameCustomer("Đàm Thoại Tin");
        customerDto.setDateOfBirthCustomer("2000-10-03");
        customerDto.setAddressCustomer("16 Mỹ khê Đà Nẵng");
        customerDto.setGenderCustomer(true);
        customerDto.setPhoneNumberCustomer("0339779768");
        customerDto.setEmailCustomer("aaacb@gmail.com");
        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/api/admin/customer/create")
                                .content(this.objectMapper.writeValueAsString(customerDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print()).andExpect(status().is4xxClientError());
    }
    /**
     * This function is used to check the validation of a specific field email is null
     * Author: TinDT
     */
    @Test
    public void create_Customer_email_13() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setNameCustomer("Đàm Thoại Tin");
        customerDto.setDateOfBirthCustomer("2000-10-03");
        customerDto.setAddressCustomer("16 Mỹ khê Đà Nẵng");
        customerDto.setGenderCustomer(true);
        customerDto.setPhoneNumberCustomer("0339779768");
        customerDto.setEmailCustomer(null);

        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/api/admin/customer/create")
                                .content(this.objectMapper.writeValueAsString(customerDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print()).andExpect(status().is4xxClientError());
    }
    /**
     * This function is used to check the validation of a specific field email is empty
     * Author: TinDT
     */
    @Test
    public void create_Customer_email_14() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setNameCustomer("Đàm Thoại Tin");
        customerDto.setDateOfBirthCustomer("2000-10-03");
        customerDto.setAddressCustomer("16 Mỹ khê Đà Nẵng");
        customerDto.setGenderCustomer(true);
        customerDto.setPhoneNumberCustomer("0339779768");
        customerDto.setEmailCustomer("");

        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/api/admin/customer/create")
                                .content(this.objectMapper.writeValueAsString(customerDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print()).andExpect(status().is4xxClientError());
    }
    /**
     * This function is used to check specific field email validation instead of validation longer character length 11
     * Author: TinDT
     */
    @Test
    public void create_Customer_email_15() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setNameCustomer("Đàm Thoại Tin");
        customerDto.setDateOfBirthCustomer("2000-10-03");
        customerDto.setAddressCustomer("16 Mỹ khê Đà Nẵng");
        customerDto.setGenderCustomer(true);
        customerDto.setPhoneNumberCustomer("0339779768");
        customerDto.setEmailCustomer("thoaitingmail.com");

        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/api/admin/customer/create")
                                .content(this.objectMapper.writeValueAsString(customerDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print()).andExpect(status().is4xxClientError());
    }
    /**
     * This function is used to check specific field phone number validation instead of validation shorter character length 10
     * Author: TinDT
     */
    @Test
    public void create_Customer_email_16() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setNameCustomer("Đàm Thoại Tin");
        customerDto.setDateOfBirthCustomer("2000-10-03");
        customerDto.setAddressCustomer("16 Mỹ khê Đà Nẵng");
        customerDto.setGenderCustomer(true);
        customerDto.setPhoneNumberCustomer("0339776568");
        customerDto.setEmailCustomer("ab@gmail.com");
        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/api/admin/customer/create")
                                .content(this.objectMapper.writeValueAsString(customerDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print()).andExpect(status().is4xxClientError());
    }
    /**
     * This function is used to check specific field email validation instead of validation longer character length 50
     * Author: TinDT
     */
    @Test
    public void create_Customer_email_17() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setNameCustomer("Đàm Thoại Tin");
        customerDto.setDateOfBirthCustomer("2000-10-03");
        customerDto.setAddressCustomer("16 Mỹ khê Đà Nẵng");
        customerDto.setGenderCustomer(true);
        customerDto.setPhoneNumberCustomer("0339756568");
        customerDto.setEmailCustomer("asadksamdjsakljdklnjsakldjklasjlkjdklajslkjdklajslkdjklasjdjaskljdaskljdklasjkldjlkasjdjklasjdlkjsajdlksajkldjlkasb@gmail.com");
        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/api/admin/customer/create")
                                .content(this.objectMapper.writeValueAsString(customerDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print()).andExpect(status().is4xxClientError());
    }
    /**
     * This function is used to check whether a email exists or not
     * * Author: TinDT
     */
    @Test
    public void create_Customer_email_99() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setNameCustomer("Đàm Thoại Tin");
        customerDto.setDateOfBirthCustomer("2000-10-03");
        customerDto.setAddressCustomer("16 Mỹ khê Đà Nẵng");
        customerDto.setGenderCustomer(true);
        customerDto.setPhoneNumberCustomer("0339756568");
        customerDto.setEmailCustomer("ab@gmail.com");
        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/api/admin/customer/create")
                                .content(this.objectMapper.writeValueAsString(customerDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print()).andExpect(status().is4xxClientError());
    }
    /**
     * This function is used to check the validation of a specific field address is null
     * Author: TinDT
     */
    @Test
    public void create_Customer_address_13() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setNameCustomer("Đàm Thoại Tin");
        customerDto.setDateOfBirthCustomer("2000-10-03");
        customerDto.setAddressCustomer(null);
        customerDto.setGenderCustomer(true);
        customerDto.setPhoneNumberCustomer("0339779768");
        customerDto.setEmailCustomer("tinthoai@gmail.com");

        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/api/admin/customer/create")
                                .content(this.objectMapper.writeValueAsString(customerDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print()).andExpect(status().is4xxClientError());
    }
    /**
     * This function is used to check the validation of a specific field address is empty
     * Author: TinDT
     */
    @Test
    public void create_Customer_address_14() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setNameCustomer("Đàm Thoại Tin");
        customerDto.setDateOfBirthCustomer("2000-10-03");
        customerDto.setAddressCustomer("");
        customerDto.setGenderCustomer(true);
        customerDto.setPhoneNumberCustomer("0335645768");
        customerDto.setEmailCustomer("tinthoai@gmail.com");

        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/api/admin/customer/create")
                                .content(this.objectMapper.writeValueAsString(customerDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print()).andExpect(status().is4xxClientError());
    }
    /**
     * This function is used to check specific field address validation instead of validation shorter character length 7
     * Author: TinDT
     */
    @Test
    public void create_Customer_address_16() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setNameCustomer("Đàm Thoại Tin");
        customerDto.setDateOfBirthCustomer("2000-10-03");
        customerDto.setAddressCustomer("da nan");
        customerDto.setGenderCustomer(true);
        customerDto.setPhoneNumberCustomer("0335679768");
        customerDto.setEmailCustomer("tinthoai@gmail.com");

        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/api/admin/customer/create")
                                .content(this.objectMapper.writeValueAsString(customerDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print()).andExpect(status().is4xxClientError());
    }
    /**
     * This function is used to check specific field address validation instead of validation longer character length 100
     * Author: TinDT
     */
    @Test
    public void create_Customer_address_17() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setNameCustomer("Đàm Thoại Tin");
        customerDto.setDateOfBirthCustomer("2000-10-03");
        customerDto.setAddressCustomer("Đà Nẵng Đà Nẵng adhsahdjsahjdsajhdakshhdkjsahdjhsahdjhkjashdkjsahjdjahskdhaskdjkashdjashkjdhsahdahsjdhakjshdjsahjdhjkahsdhkjashhdjkhkasjdhjkashdjashdĐà NẵngĐà NẵngĐà NẵngĐà NẵngĐà NẵngĐà NẵngĐà NẵngĐà NẵngĐà NẵngĐà NẵngĐà NẵngĐà NẵngĐà NẵngĐà NẵngĐà NẵngĐà NẵngĐà NẵngĐà NẵngĐà NẵngĐà NẵngĐà NẵngĐà Nẵng");
        customerDto.setGenderCustomer(true);
        customerDto.setPhoneNumberCustomer("0335679768");
        customerDto.setEmailCustomer("tinthoai@gmail.com");

        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/api/admin/customer/create")
                                .content(this.objectMapper.writeValueAsString(customerDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print()).andExpect(status().is4xxClientError());
    }
    /**
     * This function is used to check that all data is correct
     * Author: TinDT
     */
    @Test
    public void create_Customer() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setNameCustomer("Đàm Thoại Tin");
        customerDto.setDateOfBirthCustomer("2000-10-03");
        customerDto.setAddressCustomer("Đà Nẵng");
        customerDto.setGenderCustomer(true);
        customerDto.setPhoneNumberCustomer("0316454514");
        customerDto.setEmailCustomer("nguyen@gmail.com");
        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/api/admin/customer/create")
                                .content(this.objectMapper.writeValueAsString(customerDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print()).andExpect(status().is4xxClientError());
    }

}
