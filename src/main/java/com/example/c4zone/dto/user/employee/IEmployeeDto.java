package com.example.c4zone.dto.user.employee;

import java.time.LocalDate;

public interface IEmployeeDto {
    Long getId();
    String getUserName();
    String getEmployeePassword();
    String getEmployeeName();
    String getEmail();
    String getEmployeeCode();
    String getEmployeeImage();
    String getEmployeeBirthday();
    String getEmployeeAddress();
    String getEmployeePhone();
    String getEmployeeGender();
    String getEmployeeImage();
    String getEmployeeIdCard();
    LocalDate getEmployeeBirthday();
    LocalDate getEmployeeStartDay();
    String getEmployeeTypeName();
    Long getRoleId();
}
