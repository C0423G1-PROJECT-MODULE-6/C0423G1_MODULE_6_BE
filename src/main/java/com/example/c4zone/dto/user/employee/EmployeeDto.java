package com.example.c4zone.dto.user.employee;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class EmployeeDto implements Validator {
    private Long id;
    private String userName;
    private Long roleId;

    private String employeeName;
    private String employeeCode;
    private String employeeAddress;
    private String employeePhone;
    private String employeeImage;
    private String employeeIdCard;
    private String employeeBirthday;
    private String employeeStartDate;

    private String email;
    private String employeeGender;
    private boolean flagDelete;

    public EmployeeDto() {
    }

    public EmployeeDto(Long id, String userName, Long role, String name, String employeeCode, String employeeAddress, String employeePhone, String employeeImage, String employeeIdCard, String employeeBirthday, String employeeStartDate, String email, String employeeGender, boolean flagDelete) {
        this.id = id;
        this.userName = userName;
        this.roleId = role;
        this.employeeName = name;
        this.employeeCode = employeeCode;
        this.employeeAddress = employeeAddress;
        this.employeePhone = employeePhone;
        this.employeeImage = employeeImage;
        this.employeeIdCard = employeeIdCard;
        this.employeeBirthday = employeeBirthday;
        this.employeeStartDate = employeeStartDate;
        this.email = email;
        this.employeeGender = employeeGender;
        this.flagDelete = flagDelete;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public String getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }

    public String getEmployeeImage() {
        return employeeImage;
    }

    public void setEmployeeImage(String employeeImage) {
        this.employeeImage = employeeImage;
    }

    public String getEmployeeIdCard() {
        return employeeIdCard;
    }

    public void setEmployeeIdCard(String employeeIdCard) {
        this.employeeIdCard = employeeIdCard;
    }

    public String getEmployeeBirthday() {
        return employeeBirthday;
    }

    public void setEmployeeBirthday(String employeeBirthday) {
        this.employeeBirthday = employeeBirthday;
    }

    public String getEmployeeStartDate() {
        return employeeStartDate;
    }

    public void setEmployeeStartDate(String employeeStartDate) {
        this.employeeStartDate = employeeStartDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmployeeGender() {
        return employeeGender;
    }

    public void setEmployeeGender(String employeeGender) {
        this.employeeGender = employeeGender;
    }

    public boolean isFlagDelete() {
        return flagDelete;
    }

    public void setFlagDelete(boolean flagDelete) {
        this.flagDelete = flagDelete;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

        EmployeeDto employeeDto = (EmployeeDto) target;


        final String Name = "employeeName";
        if (employeeDto.getEmployeeName() == null) {
            errors.rejectValue(Name, "", "Vui lòng nhập tên");
        } else if (employeeDto.getEmployeeName().length() > 100) {
            errors.rejectValue(Name, "", "Quá ký tự cho phép");
        } else if (!employeeDto.getEmployeeName().matches("^[\\p{L}\\s]+$")) {
            errors.rejectValue(Name, "", "Tên chỉ chứa định dạng chữ");
        }
        final String ADDRESS = "employeeAddress";
        if (employeeDto.getEmployeeAddress() == null) {
            errors.rejectValue(ADDRESS, "", "Vui lòng nhập địa chỉ");
        } else if (employeeDto.getEmployeeAddress().length() > 100) {
            errors.rejectValue(ADDRESS, "", "Địa chỉ quá ký tự cho phép");
        }
        final String PHONE_NUMBER= "employeePhone";
        if (employeeDto.getEmployeePhone() == null) {
            errors.rejectValue(PHONE_NUMBER, "", "Vui lòng nhập số điện thoại");
        } else if (employeeDto.getEmployeePhone().length() > 11) {
            errors.rejectValue(PHONE_NUMBER, "", "Vui lòng chỉ nhập từ 10 đến 11 số");
        } else if (employeeDto.getEmployeePhone().length() <10) {
            errors.rejectValue(PHONE_NUMBER, "", "Vui lòng chỉ nhập từ 10 đến 11 số");
        } else if (!employeeDto.getEmployeePhone().matches("^0\\d{9,10}$")) {
            errors.rejectValue(PHONE_NUMBER, "", "Sai định dạng");
        }
        final String START_DAY="employeeStartDate";
        if (employeeDto.getEmployeeStartDate() == null) {
            errors.rejectValue(START_DAY, "", "Vui lòng nhập ngày bắt đầu");
        } else if (!employeeDto.getEmployeeStartDate().matches("^\\d{4}-\\d{2}-\\d{2}$")) {
            errors.rejectValue(START_DAY,"","Vui lòng nhập đúng định dạng yyyy-mm-dd");

        }




        final String BIRTHDAY = "employeeBirthday";
        if (employeeDto.getEmployeeBirthday() == null) {
            errors.rejectValue(BIRTHDAY, "", "Vui lòng nhập ngày sinh");
        } else if (!FormatEmployee.check18YearsOld(employeeDto.getEmployeeBirthday())) {
            errors.rejectValue(BIRTHDAY, "", "Nhân viên chưa đủ 18 tuổi");
        } else if (!employeeDto.getEmployeeBirthday().matches("^\\d{4}-\\d{2}-\\d{2}$")) {
            errors.rejectValue(BIRTHDAY,"","Vui lòng nhập đúng định dạng yyyy-mm-dd");
        }
        final String ID_CARD="employeeIdCard";
        if (employeeDto.getEmployeeIdCard() == null) {
            errors.rejectValue(ID_CARD, "", "Vui lòng nhập CCCD");
        } else if (employeeDto.getEmployeeIdCard().length() > 20) {
            errors.rejectValue(ID_CARD, "", "CMND/CCCD quá ký tự cho phép");
        } else if (!employeeDto.getEmployeeIdCard().matches("^\\d{9}(\\d{3})?$")) {
            errors.rejectValue(ID_CARD, "", "Sai định dạng");
        }
    }
}
