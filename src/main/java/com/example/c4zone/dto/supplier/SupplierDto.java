package com.example.c4zone.dto.supplier;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


public class SupplierDto implements Validator {
    private Long idSupplier;
    private Integer codeSupplier;
    private String nameSupplier;
    private String addressSupplier;
    private String phoneNumberSupplier;
    private String emailSupplier;
    private Boolean statusSupplier;

    public SupplierDto() {

    }

    public SupplierDto(Long idSupplier, Integer codeSupplier, String nameSupplier, String addressSupplier, String phoneNumberSupplier, String emailSupplier, Boolean statusSupplier) {
        this.idSupplier = idSupplier;
        this.codeSupplier = codeSupplier;
        this.nameSupplier = nameSupplier;
        this.addressSupplier = addressSupplier;
        this.phoneNumberSupplier = phoneNumberSupplier;
        this.emailSupplier = emailSupplier;
        this.statusSupplier = statusSupplier;
    }

    public Long getIdSupplier() {
        return idSupplier;
    }

    public void setIdSupplier(Long idSupplier) {
        this.idSupplier = idSupplier;
    }

    public Integer getCodeSupplier() {
        return codeSupplier;
    }

    public void setCodeSupplier(Integer codeSupplier) {
        this.codeSupplier = codeSupplier;
    }

    public String getNameSupplier() {
        return nameSupplier;
    }

    public void setNameSupplier(String nameSupplier) {
        this.nameSupplier = nameSupplier;
    }

    public String getAddressSupplier() {
        return addressSupplier;
    }

    public void setAddressSupplier(String addressSupplier) {
        this.addressSupplier = addressSupplier;
    }

    public String getPhoneNumberSupplier() {
        return phoneNumberSupplier;
    }

    public void setPhoneNumberSupplier(String phoneNumberSupplier) {
        this.phoneNumberSupplier = phoneNumberSupplier;
    }

    public String getEmailSupplier() {
        return emailSupplier;
    }

    public void setEmailSupplier(String emailSupplier) {
        this.emailSupplier = emailSupplier;
    }

    public Boolean getStatusSupplier() {
        return statusSupplier;
    }

    public void setStatusSupplier(Boolean statusSupplier) {
        this.statusSupplier = statusSupplier;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        SupplierDto supplierDto = (SupplierDto) target;
//        String covertedSupplierCode = String.valueOf(supplierDto.getCodeSupplier());
//        if (covertedSupplierCode.isEmpty()){
//            errors.rejectValue("codeSupplier", null, "Không được để trống");
//        } else if (!covertedSupplierCode.matches("^[1-9]{6}$")){
//            errors.rejectValue("codeSupplier",null,"Mã số chỉ chứa ký tự số và không quá 6 chữ số");
//        } else
        if (supplierDto.getCodeSupplier() <= 0) {
            errors.rejectValue("codeSupplier", null, "Mã số không được âm và lớn hơn 0");
        }
        if (supplierDto.getNameSupplier().isEmpty()){
            errors.rejectValue("nameSupplier", null, "Không được để trống");
        } else if (!supplierDto.getNameSupplier().matches("^[^0-9`~!@#$%^&*()_\\-\\+\\=\\[\\{\\]\\}\\\\\\|;:'\",<\\.>\\/\\?]+$")){
            errors.rejectValue("nameSupplier",null, "Tên không được chứa số, ký tự đặc biệt");
        } else if (supplierDto.getNameSupplier().length() > 100) {
            errors.rejectValue("nameSupplier",null, "Tên không được quá 100 ký tự");
        }
        if (supplierDto.getPhoneNumberSupplier().isEmpty()){
            errors.rejectValue("phoneNumberSupplier", null, "Không được để trống");
        } else if (!supplierDto.getPhoneNumberSupplier().matches("^[^a-zA-Z`~!@#$%^&*()_\\-\\+\\=\\[\\{\\]\\}\\\\\\|;:'\",<\\.>\\/\\?]+$")){
            errors.rejectValue("phoneNumberSupplier",null,"SĐT không chứa ký tự chữ và ký tự đặc biệt");
        } else if (!supplierDto.getPhoneNumberSupplier().matches("^(0|(\\+84))[0-9]+$")) {
            errors.rejectValue("phoneNumberSupplier", null, "SĐT phải bắt đầu từ 0 hoặc +84");
        } else if (supplierDto.getPhoneNumberSupplier().length() > 12) {
            errors.rejectValue("phoneNumberSupplier",null,"SĐT không quá 12 chữ số");
        }
        if (supplierDto.getEmailSupplier().isEmpty()){
            errors.rejectValue("emailSupplier", null, "Không được để trống");
        } else if (supplierDto.getEmailSupplier().length() > 100){
            errors.rejectValue("emailSupplier", null, "Email không được quá 100 ký tự");
        } else if (!supplierDto.getEmailSupplier().matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            errors.rejectValue("emailSupplier", null, "Email không đúng định dạng");
        }
    }
}
