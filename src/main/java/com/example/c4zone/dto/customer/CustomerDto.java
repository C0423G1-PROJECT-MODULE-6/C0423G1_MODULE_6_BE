package com.example.c4zone.dto.customer;

import com.example.c4zone.dto.customer.until.FormatCustomer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.Column;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto implements Validator {
    private Long idCustomer;
    private String nameCustomer;
    private Boolean genderCustomer = true;
    private String emailCustomer;
    private String dateOfBirthCustomer;
    private String phoneNumberCustomer;
    private String addressCustomer;
    private Boolean statusCustomer = true;
    private static final String NAME_DTO = "nameCustomer";
    private static final String BIRTHDAY_DTO = "dateOfBirthCustomer";
    private static final String ADDRESS_DTO = "addressCustomer";
    private static final String PHONE_DTO = "phoneNumberCustomer";
    private static final String EMAIL_DTO = "emailCustomer";
    private static final String NAME_REGEX = "^[a-zA-zÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễếệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ ]*$";
    private static final String BIRTHDAY_REGEX  = "^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$";
    private static final String PHONE_REGEX  = "(84|0[3|5|7|8|9])+([0-9]{8})\\b";
    private static final String EMAIL_REGEX  = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        CustomerDto customerDto = (CustomerDto) target;
        // Check name

        if (customerDto.getNameCustomer() == null){
           errors.rejectValue(NAME_DTO, "", "Vui lòng bổ sung tên khách hàng!");
       }else if (customerDto.getNameCustomer().trim().equals("")) {
           errors.rejectValue(NAME_DTO, "", "Không được để trống tên!");
       } else if (customerDto.getNameCustomer().length() < 2) {
           errors.rejectValue(NAME_DTO, "", "Tên nhập vào không đủ độ dài cho phép");
       } else if (customerDto.getNameCustomer().length() > 100) {
           errors.rejectValue(NAME_DTO, "", "Tên quá dài! Không nhập quá 50 ký tự!");
       } else if (!customerDto.getNameCustomer().matches(NAME_REGEX)) {
           errors.rejectValue(NAME_DTO, "", "Tên không được chứa ký tự đặc biệt!");
       }
        // Check address

        if (customerDto.getAddressCustomer() == null) {
            errors.rejectValue(ADDRESS_DTO, "", "Vui lòng bổ sung địa chỉ khách hàng!");
        } else if (customerDto.getAddressCustomer().trim().equals("")) {
            errors.rejectValue(ADDRESS_DTO, "", "Không được để trống địa chỉ!");
        } else if (customerDto.getAddressCustomer().length() < 7) {
            errors.rejectValue(ADDRESS_DTO, "", "Địa chỉ nhập vào không đủ độ dài cho phép!");
        } else if (customerDto.getAddressCustomer().length() > 100) {
            errors.rejectValue(ADDRESS_DTO, "", "Địa chỉ quá dài! Không nhập quá 100 ký tự!");
        }
        // Check day of birth
        if (customerDto.getDateOfBirthCustomer() == null) {
            errors.rejectValue(BIRTHDAY_DTO, "", "Vui lòng bổ sung  ngày sinh khách hàng!");
        } else if (customerDto.getDateOfBirthCustomer().trim().equals("")) {
            errors.rejectValue(BIRTHDAY_DTO, "", "Không để trống ngày sinh khách hàng!");
        } else if (!customerDto.getDateOfBirthCustomer().matches(BIRTHDAY_REGEX)) {
            errors.rejectValue(BIRTHDAY_DTO, "", "Nhập không đúng định dạng ngày sinh !");
        } else if (!FormatCustomer.isDateValidAndBeforeCurrent(customerDto.getDateOfBirthCustomer())) {
            errors.rejectValue(BIRTHDAY_DTO, "", "Vượt quá thời gian thực tế !");
        }else if (!FormatCustomer.check18YearsOld(customerDto.getDateOfBirthCustomer())) {
            errors.rejectValue(BIRTHDAY_DTO, "", "Cảnh báo chưa đủ 18 tuổi !");
        }
        // Check number phone
        if (customerDto.getPhoneNumberCustomer() == null) {
            errors.rejectValue(PHONE_DTO, "", "Vui lòng bổ sung số điện thoại");
        } else if (customerDto.getPhoneNumberCustomer().trim().equals("")) {
            errors.rejectValue(PHONE_DTO, "", "Không được để trống số điện thoại");
        } else if (customerDto.getPhoneNumberCustomer().length() < 10) {
            errors.rejectValue(PHONE_DTO, "", "Không đúng độ dài ký tự cho phép ");
        } else if (customerDto.getPhoneNumberCustomer().length() > 11) {
            errors.rejectValue(PHONE_DTO, "", "Số điện thoại quá ký tự cho phép");
        } else if (!customerDto.getPhoneNumberCustomer().matches(PHONE_REGEX)) {
            errors.rejectValue(PHONE_DTO, "", "Bạn nhập sai định dạng số điện thoại!");
        }
        // Check email
        if (customerDto.getEmailCustomer() == null) {
            errors.rejectValue(EMAIL_DTO, "", "Vui lòng bổ sung email khách hàng");
        } else if (customerDto.getEmailCustomer().trim().equals("")) {
            errors.rejectValue(EMAIL_DTO, "", "Không được để trống email");
        } else if (customerDto.getEmailCustomer().length() > 50) {
            errors.rejectValue(EMAIL_DTO, "", "Email vượt quá ký tự cho phép");
        } else if (!customerDto.getEmailCustomer().matches(EMAIL_REGEX)) {
            errors.rejectValue(EMAIL_DTO, "", "Bạn nhập sai định dạng email!");
        }


    }

}
