package com.example.c4zone.dto.customer;

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
    private static final String NAME_DTO = "name";
    private static final String BIRTHDAY_DTO = "birthday";
    private static final String ADDRESS_DTO = "address";
    private static final String PHONE_DTO = "phoneNumber";
    private static final String EMAIL_DTO = "email";
    private static final String NOTE_DTO = "note";
    private static final String CODE_DTO = "code";
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
       if (customerDto.getNameCustomer()== null){
           errors.rejectValue(NAME_DTO, "", "Vui lòng bổ sung tên khách hàng!");
       }
    }
}
