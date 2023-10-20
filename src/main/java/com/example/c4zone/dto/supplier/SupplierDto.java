package com.example.c4zone.dto.supplier;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SupplierDto implements Validator {
    private Long idSupplier;
    private String nameSupplier;
    private String addressSupplier;
    private String phoneNumberSupplier;
    private String emailSupplier;
    private Boolean statusSupplier;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        SupplierDto supplierDto = (SupplierDto) target;
        //name
        if (supplierDto.getNameSupplier() == null) {
            errors.rejectValue("nameSupplier", "", "Tên nhà cung cấp không được null!");
        } else if (supplierDto.getNameSupplier().trim().equals("")) {
            errors.rejectValue("nameSupplier", "", "Không được để trống!");
        } else if (!supplierDto.getNameSupplier().matches("^[^0-9`~!@#$%^()_\\-=\\[{\\]}\\\\|;:\",><?]+$")) {
            errors.rejectValue("nameSupplier", "", "Tên chỉ chứa chữ cái và một số ký tự đặc biệt &,.,*,'!,/");
        } else if (supplierDto.getNameSupplier().length() > 100) {
            errors.rejectValue("nameSupplier", "", "Tên không được quá 100 ký tự!");
        } else if (supplierDto.getNameSupplier().length() < 2) {
            errors.rejectValue("nameSupplier", "", "Tên tối thiểu là 2 ký tự!");
        }
        //phone number
        if (supplierDto.getPhoneNumberSupplier() == null) {
            errors.rejectValue("phoneNumberSupplier", "", "SĐT không được null!");
        } else if (supplierDto.getPhoneNumberSupplier().trim().equals("")) {
            errors.rejectValue("phoneNumberSupplier", "", "Không được để trống!");
        } else if (!supplierDto.getPhoneNumberSupplier().matches("^[^a-zA-Z`~!@#$%^&*()_\\-+=\\[{\\]}\\\\|;:'\",<.>/?]+$")) {
            errors.rejectValue("phoneNumberSupplier", "", "SĐT không chứa ký tự chữ và ký tự đặc biệt!");
        } else if (!supplierDto.getPhoneNumberSupplier().matches("^(0|(\\+84))[0-9]+$")) {
            errors.rejectValue("phoneNumberSupplier", "", "SĐT phải bắt đầu từ 0 hoặc +84!");
        } else if (supplierDto.getPhoneNumberSupplier().length() > 12) {
            errors.rejectValue("phoneNumberSupplier", "", "SĐT không quá 12 chữ số!");
        } else if (supplierDto.getPhoneNumberSupplier().length() < 10) {
            errors.rejectValue("phoneNumberSupplier", "", "SĐT tối thiểu 10 chữ số!");
        }
        //email
        if (supplierDto.getEmailSupplier() == null) {
            errors.rejectValue("emailSupplier", "", "Email không được null!");
        } else if (supplierDto.getEmailSupplier().trim().equals("")) {
            errors.rejectValue("emailSupplier", "", "Không được để trống!");
        } else if (!supplierDto.getEmailSupplier().matches("^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            errors.rejectValue("emailSupplier", "", "Email không đúng định dạng!");
        } else if (supplierDto.getEmailSupplier().length() > 100) {
            errors.rejectValue("emailSupplier", "", "Email không được quá 100 ký tự!");
        } else if (supplierDto.getEmailSupplier().length() < 10) {
            errors.rejectValue("emailSupplier", "", "Email tối thiểu 10 ký tự!");
        }
    }
}
