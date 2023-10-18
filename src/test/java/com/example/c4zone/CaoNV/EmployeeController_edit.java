package com.example.c4zone.CaoNV;

import com.example.c4zone.dto.user.employee.EmployeeDto;
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
public class EmployeeController_edit {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    /**
     * Author:CaoNV
     * Date:13/10/2023
     * Function test input null to field name
     * @throws Exception
     */
    @Test
    public void create_employee_name_5() throws Exception{
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmployeeCode("NV004");
        employeeDto.setEmployeeName(null);
        employeeDto.setEmployeeAddress("123 NVL");
        employeeDto.setEmployeeBirthday("2002-02-02");
        employeeDto.setEmployeeIdCard("123456789");
        employeeDto.setEmployeePhone("0123456789");
        employeeDto.setEmployeeStartDate("2023-09-18");
        employeeDto.setEmployeeImage("");
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .patch("/api/admin/employee/edit")
                                .content(this.objectMapper.writeValueAsString(employeeDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Author:CaoNV
     * Date:13/10/2023
     * Function test input empty to field name
     * @throws Exception
     */
    @Test
    public void create_employee_name_6() throws Exception{
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setUserName("LQP");
        employeeDto.setEmployeeName("");
        employeeDto.setEmployeeCode("NV004");
        employeeDto.setEmployeeAddress("123 NVL");
        employeeDto.setEmployeePhone("0123456789");
        employeeDto.setEmployeeImage("");
        employeeDto.setEmployeeIdCard("123456789");
        employeeDto.setEmployeeBirthday("2002-02-02");
        employeeDto.setEmployeeStartDate("2023-09-18");
        employeeDto.setEmail("lequangphuoc@gmail.com");

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .patch("/api/admin/employee/edit")
                                .content(this.objectMapper.writeValueAsString(employeeDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Author:CaoNV
     * Date:13/10/2023
     * Function test input number to field name
     * @throws Exception
     */
    @Test
    public void create_employee_name_7() throws Exception{
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmployeeCode("NV004");
        employeeDto.setEmployeeName("123456");
        employeeDto.setEmployeeAddress("123 NVL");
        employeeDto.setEmployeeBirthday("2002-02-02");
        employeeDto.setEmployeeIdCard("123456789");
        employeeDto.setEmployeePhone("0123456789");
        employeeDto.setEmployeeStartDate("2023-09-18");
        employeeDto.setEmployeeImage("");
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .patch("/api/admin/employee/edit")
                                .content(this.objectMapper.writeValueAsString(employeeDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Author:CaoNV
     * Date:13/10/2023
     * Function test input max length to field name
     * @throws Exception
     */
    @Test
    public void create_employee_name_8() throws Exception{
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmployeeCode("NV004");
        employeeDto.setEmployeeName("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
        employeeDto.setEmployeeAddress("123 NVL");
        employeeDto.setEmployeeBirthday("2002-02-02");
        employeeDto.setEmployeeIdCard("123456789");
        employeeDto.setEmployeePhone("0123456789");
        employeeDto.setEmployeeStartDate("2023-09-18");
        employeeDto.setEmployeeImage("");
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .patch("/api/admin/employee/edit")
                                .content(this.objectMapper.writeValueAsString(employeeDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Author:CaoNV
     * Date:13/10/2023
     * Function test input null to field address
     * @throws Exception
     */
    @Test
    public void create_employee_address_9() throws Exception{
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmployeeCode("NV004");
        employeeDto.setEmployeeName("Tan");
        employeeDto.setEmployeeAddress(null);
        employeeDto.setEmployeeBirthday("2002-02-02");
        employeeDto.setEmployeeIdCard("123456789");
        employeeDto.setEmployeePhone("0123456789");
        employeeDto.setEmployeeStartDate("2023-09-18");
        employeeDto.setEmployeeImage("");
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .patch("/api/admin/employee/edit")
                                .content(this.objectMapper.writeValueAsString(employeeDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Author:CaoNV
     * Date:13/10/2023
     * Function test input empty to field address
     * @throws Exception
     */
    @Test
    public void create_employee_address_10() throws Exception{
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmployeeCode("NV004");
        employeeDto.setEmployeeName("Tan");
        employeeDto.setEmployeeAddress("");
        employeeDto.setEmployeeBirthday("2002-02-02");
        employeeDto.setEmployeeIdCard("123456789");
        employeeDto.setEmployeePhone("0123456789");
        employeeDto.setEmployeeStartDate("2023-09-18");
        employeeDto.setEmployeeImage("");
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .patch("/api/admin/employee/edit")
                                .content(this.objectMapper.writeValueAsString(employeeDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Author:CaoNV
     * Date:13/10/2023
     * Function test input max length to field address
     * @throws Exception
     */
    @Test
    public void create_employee_address_11() throws Exception{
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmployeeCode("NV004");
        employeeDto.setEmployeeName("Tan");
        employeeDto.setEmployeeAddress("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
        employeeDto.setEmployeeBirthday("2002-02-02");
        employeeDto.setEmployeeIdCard("123456789");
        employeeDto.setEmployeePhone("0123456789");
        employeeDto.setEmployeeStartDate("2023-09-18");
        employeeDto.setEmployeeImage("");
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .patch("/api/admin/employee/edit")
                                .content(this.objectMapper.writeValueAsString(employeeDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Author:CaoNV
     * Date:13/10/2023
     * Function test input null to field birthday
     * @throws Exception
     */
    @Test
    public void create_employee_birthday_12() throws Exception{
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmployeeCode("NV004");
        employeeDto.setEmployeeName("Tan");
        employeeDto.setEmployeeAddress("123 NVL");
        employeeDto.setEmployeeBirthday(null);
        employeeDto.setEmployeeIdCard("123456789");
        employeeDto.setEmployeePhone("0123456789");
        employeeDto.setEmployeeStartDate("2023-09-18");
        employeeDto.setEmployeeImage("");
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .patch("/api/admin/employee/edit")
                                .content(this.objectMapper.writeValueAsString(employeeDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Author:CaoNV
     * Date:13/10/2023
     * Function test input empty to field birthday
     * @throws Exception
     */
    @Test
    public void create_employee_birthday_13() throws Exception{
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmployeeCode("NV004");
        employeeDto.setEmployeeName("Tan");
        employeeDto.setEmployeeAddress("123 NVL");
        employeeDto.setEmployeeBirthday("");
        employeeDto.setEmployeeIdCard("123456789");
        employeeDto.setEmployeePhone("0123456789");
        employeeDto.setEmployeeStartDate("2023-09-18");
        employeeDto.setEmployeeImage("");
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .patch("/api/admin/employee/edit")
                                .content(this.objectMapper.writeValueAsString(employeeDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Author:CaoNV
     * Date:13/10/2023
     * Function test input null to field start day
     * @throws Exception
     */
    @Test
    public void create_employee_startDay_14() throws Exception{
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmployeeCode("NV004");
        employeeDto.setEmployeeName("Tan");
        employeeDto.setEmployeeAddress("123 NVL");
        employeeDto.setEmployeeBirthday(null);
        employeeDto.setEmployeeIdCard("123456789");
        employeeDto.setEmployeePhone("0123456789");
        employeeDto.setEmployeeStartDate("2023-09-18");
        employeeDto.setEmployeeImage("");
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .patch("/api/admin/employee/edit")
                                .content(this.objectMapper.writeValueAsString(employeeDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Author:CaoNV
     * Date:13/10/2023
     * Function test input empty to field start day
     * @throws Exception
     */
    @Test
    public void create_employee_startDay_15() throws Exception{
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmployeeCode("NV004");
        employeeDto.setEmployeeName("Tan");
        employeeDto.setEmployeeAddress("123 NVL");
        employeeDto.setEmployeeBirthday("");
        employeeDto.setEmployeeIdCard("123456789");
        employeeDto.setEmployeePhone("0123456789");
        employeeDto.setEmployeeStartDate("2023-09-18");
        employeeDto.setEmployeeImage("");
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .patch("/api/admin/employee/edit")
                                .content(this.objectMapper.writeValueAsString(employeeDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Author:CaoNV
     * Date:13/10/2023
     * Function test input null to field idCard
     * @throws Exception
     */
    @Test
    public void create_employee_idCard_16() throws Exception{
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmployeeCode("NV004");
        employeeDto.setEmployeeName("Tan");
        employeeDto.setEmployeeAddress("123 NVL");
        employeeDto.setEmployeeBirthday("2002-02-02");
        employeeDto.setEmployeeIdCard(null);
        employeeDto.setEmployeePhone("0123456789");
        employeeDto.setEmployeeStartDate("2023-09-18");
        employeeDto.setEmployeeImage("");
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .patch("/api/admin/employee/edit")
                                .content(this.objectMapper.writeValueAsString(employeeDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Author:CaoNV
     * Date:13/10/2023
     * Function test input empty to field idCard
     * @throws Exception
     */
    @Test
    public void create_employee_idCard_17() throws Exception{
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmployeeCode("NV004");
        employeeDto.setEmployeeName("Tan");
        employeeDto.setEmployeeAddress("123 NVL");
        employeeDto.setEmployeeBirthday("2002-02-02");
        employeeDto.setEmployeeIdCard("");
        employeeDto.setEmployeePhone("0123456789");
        employeeDto.setEmployeeStartDate("2023-09-18");
        employeeDto.setEmployeeImage("");
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .patch("/api/admin/employee/edit")
                                .content(this.objectMapper.writeValueAsString(employeeDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Author:CaoNV
     * Date:13/10/2023
     * Function test input max length to field idCard
     * @throws Exception
     */
    @Test
    public void create_employee_idCArd_18() throws Exception{
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmployeeCode("NV004");
        employeeDto.setEmployeeName("Tan");
        employeeDto.setEmployeeAddress("123 NVL");
        employeeDto.setEmployeeBirthday("2002-02-02");
        employeeDto.setEmployeeIdCard("111111111111111111111");
        employeeDto.setEmployeePhone("0123456789");
        employeeDto.setEmployeeStartDate("2023-09-18");
        employeeDto.setEmployeeImage("");
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .patch("/api/admin/employee/edit")
                                .content(this.objectMapper.writeValueAsString(employeeDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Author:CaoNV
     * Date:13/10/2023
     * Function test input wrong format to field idCard
     * @throws Exception
     */
    @Test
    public void create_employee_idCArd_19() throws Exception{
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmployeeCode("NV004");
        employeeDto.setEmployeeName("Tan");
        employeeDto.setEmployeeAddress("123 NVL");
        employeeDto.setEmployeeBirthday("2002-02-02");
        employeeDto.setEmployeeIdCard("01234567aaa");
        employeeDto.setEmployeePhone("0123456789");
        employeeDto.setEmployeeStartDate("2023-09-18");
        employeeDto.setEmployeeImage("");
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .patch("/api/admin/employee/edit")
                                .content(this.objectMapper.writeValueAsString(employeeDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Author:CaoNV
     * Date:13/10/2023
     * Function test input null to field phoneNumber
     * @throws Exception
     */
    @Test
    public void create_employee_phoneNumber_20() throws Exception{
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmployeeCode("NV004");
        employeeDto.setEmployeeName("Tan");
        employeeDto.setEmployeeAddress("123 NVL");
        employeeDto.setEmployeeBirthday("2002-02-02");
        employeeDto.setEmployeeIdCard("123456789");
        employeeDto.setEmployeePhone(null);
        employeeDto.setEmployeeStartDate("2023-09-18");
        employeeDto.setEmployeeImage("");
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .patch("/api/admin/employee/edit")
                                .content(this.objectMapper.writeValueAsString(employeeDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Author:CaoNV
     * Date:13/10/2023
     * Function test input empty to field phoneNumber
     * @throws Exception
     */
    @Test
    public void create_employee_phoneNumber_21() throws Exception{
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmployeeCode("NV004");
        employeeDto.setEmployeeName("Tan");
        employeeDto.setEmployeeAddress("123 NVL");
        employeeDto.setEmployeeBirthday("2002-02-02");
        employeeDto.setEmployeeIdCard("123456789");
        employeeDto.setEmployeePhone("");
        employeeDto.setEmployeeStartDate("2023-09-18");
        employeeDto.setEmployeeImage("");
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .patch("/api/admin/employee/edit")
                                .content(this.objectMapper.writeValueAsString(employeeDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Author:CaoNV
     * Date:13/10/2023
     * Function test input max length to field phoneNumber
     * @throws Exception
     */
    @Test
    public void create_employee_phoneNumber_22() throws Exception{
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmployeeCode("NV004");
        employeeDto.setEmployeeName("Tan");
        employeeDto.setEmployeeAddress("123 NVL");
        employeeDto.setEmployeeBirthday("2002-02-02");
        employeeDto.setEmployeeIdCard("123456789");
        employeeDto.setEmployeePhone("1231231231231231231231231232");
        employeeDto.setEmployeeStartDate("2023-09-18");
        employeeDto.setEmployeeImage("");
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .patch("/api/admin/employee/edit")
                                .content(this.objectMapper.writeValueAsString(employeeDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Author:CaoNV
     * Date:13/10/2023
     * Function test input wrong format to field phoneNumber
     * @throws Exception
     */
    @Test
    public void create_employee_phoneNumber_23() throws Exception{
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmployeeCode("NV004");
        employeeDto.setEmployeeName("Tan");
        employeeDto.setEmployeeAddress("123 NVL");
        employeeDto.setEmployeeBirthday("2002-02-02");
        employeeDto.setEmployeeIdCard("012345678");
        employeeDto.setEmployeePhone("asdasda");
        employeeDto.setEmployeeStartDate("2023-09-18");
        employeeDto.setEmployeeImage("");
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .patch("/api/admin/employee/edit")
                                .content(this.objectMapper.writeValueAsString(employeeDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Author:CaoNV
     * Date:13/10/2023
     * Function test input all item successfully
     * @throws Exception
     */
    @Test
    public void edit_employee_all_item_24() throws Exception{
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmployeeCode("NNV0001");
        employeeDto.setEmployeeName("Phan Ta Anh Dao");
        employeeDto.setEmployeeAddress("536 Điện Biên Phủ, Thanh Khê, Đà Nẵng");
        employeeDto.setEmployeeBirthday("1988-10-25");
        employeeDto.setEmployeeIdCard("049098000697");
        employeeDto.setEmployeePhone("0905451778");
        employeeDto.setEmployeeStartDate("2023-10-12");
        employeeDto.setEmployeeImage("");
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .patch("/api/admin/employee/update/1")
                                .content(this.objectMapper.writeValueAsString(employeeDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }




}
