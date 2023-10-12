package com.example.c4zone.dto.user.employee;
import com.example.c4zone.model.user.Role;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import java.sql.Date;
public class EmployeeDto implements Validator {
    private Long id;
    private String userName;
    private Role role;
    private String employeeName;
    private String employeeCode;
    private String employeeAddress;
    private String employeePhone;
    private String employeeImage;
    private String employeeIdCard;
    private Date employeeBirthday;
    private Date employeeStartDate;
    private String email;
    private String employeeGender;
    private boolean flagDelete;


    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
