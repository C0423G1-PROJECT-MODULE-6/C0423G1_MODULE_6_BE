package com.example.c4zone.dto.product;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.List;

public class ProductDto implements Validator {
    private Long idProduct;
    private String nameProduct;
    private String screenProduct;
    private String cameraProduct;
    private String descriptionProduct;
    private Boolean statusBusiness = true;
    private String selfieProduct;
    private String batteryProduct;
    private String weightProduct;
    private Long quantityProduct;
    private Double priceProduct;
    private ImageDto imageDto;
    private CapacityDto capacityDto;
    private ColorDto colorDto;
    private CpuDto cpuDto;
    private RamDto ramDto;
    private SeriesDto seriesDto;
    private TypeDto typeDto;
    private List<String> imageDtoList;
    private static final String NAME_PRODUCT_DTO = "nameProduct";
    private static final String SCREEN_PRODUCT_DTO = "screenProduct";
    private static final String CAMERA_PRODUCT_DTO = "cameraProduct";
    private static final String DESCRIPTION_PRODUCT_DTO = "descriptionProduct";
    private static final String SELFIE_PRODUCT_DTO = "selfieProduct";
    private static final String BATTERY_PRODUCT_DTO = "batteryProduct";
    private static final String WEIGHT_PRODUCT_DTO = "weightProduct";
    private static final String PRICE_PRODUCT_DTO = "priceProduct";
    private static final String REGEX_SPECIAL_CHARACTERS = "^[a-zA-ZÀ-Úà-úĂăĐđĨĩƠơƯưẠ-ỹ0-9 .,+]*$";

    public ProductDto() {
    }

    public ProductDto(Long idProduct, String nameProduct, String screenProduct, String cameraProduct, String descriptionProduct, Boolean statusBusiness, String selfieProduct, String batteryProduct, String weightProduct, Long quantityProduct, Double priceProduct, ImageDto imageDto, CapacityDto capacityDto, ColorDto colorDto, CpuDto cpuDto, RamDto ramDto, SeriesDto seriesDto, TypeDto typeDto) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.screenProduct = screenProduct;
        this.cameraProduct = cameraProduct;
        this.descriptionProduct = descriptionProduct;
        this.statusBusiness = statusBusiness;
        this.selfieProduct = selfieProduct;
        this.batteryProduct = batteryProduct;
        this.weightProduct = weightProduct;
        this.quantityProduct = quantityProduct;
        this.priceProduct = priceProduct;
        this.imageDto = imageDto;
        this.capacityDto = capacityDto;
        this.colorDto = colorDto;
        this.cpuDto = cpuDto;
        this.ramDto = ramDto;
        this.seriesDto = seriesDto;
        this.typeDto = typeDto;
    }

    public ProductDto(Long idProduct, String nameProduct, String screenProduct, String cameraProduct, String descriptionProduct, Boolean statusBusiness, String selfieProduct, String batteryProduct, String weightProduct, Long quantityProduct, Double priceProduct, ImageDto imageDto, CapacityDto capacityDto, ColorDto colorDto, CpuDto cpuDto, RamDto ramDto, SeriesDto seriesDto, TypeDto typeDto, List<String> imageDtoList) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.screenProduct = screenProduct;
        this.cameraProduct = cameraProduct;
        this.descriptionProduct = descriptionProduct;
        this.statusBusiness = statusBusiness;
        this.selfieProduct = selfieProduct;
        this.batteryProduct = batteryProduct;
        this.weightProduct = weightProduct;
        this.quantityProduct = quantityProduct;
        this.priceProduct = priceProduct;
        this.imageDto = imageDto;
        this.capacityDto = capacityDto;
        this.colorDto = colorDto;
        this.cpuDto = cpuDto;
        this.ramDto = ramDto;
        this.seriesDto = seriesDto;
        this.typeDto = typeDto;
        this.imageDtoList = imageDtoList;
    }

    public List<String> getImageDtoList() {
        return imageDtoList;
    }

    public void setImageDtoList(List<String> imageDtoList) {
        this.imageDtoList = imageDtoList;
    }

    public ImageDto getImageDto() {
        return imageDto;
    }

    public void setImageDto(ImageDto imageDto) {
        this.imageDto = imageDto;
    }

    public Long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Long idProduct) {
        this.idProduct = idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getScreenProduct() {
        return screenProduct;
    }

    public void setScreenProduct(String screenProduct) {
        this.screenProduct = screenProduct;
    }

    public String getCameraProduct() {
        return cameraProduct;
    }

    public void setCameraProduct(String cameraProduct) {
        this.cameraProduct = cameraProduct;
    }

    public String getDescriptionProduct() {
        return descriptionProduct;
    }

    public void setDescriptionProduct(String descriptionProduct) {
        this.descriptionProduct = descriptionProduct;
    }

    public Boolean getStatusBusiness() {
        return statusBusiness;
    }

    public void setStatusBusiness(Boolean statusBusiness) {
        this.statusBusiness = statusBusiness;
    }

    public String getSelfieProduct() {
        return selfieProduct;
    }

    public void setSelfieProduct(String selfieProduct) {
        this.selfieProduct = selfieProduct;
    }

    public String getBatteryProduct() {
        return batteryProduct;
    }

    public void setBatteryProduct(String batteryProduct) {
        this.batteryProduct = batteryProduct;
    }

    public String getWeightProduct() {
        return weightProduct;
    }

    public void setWeightProduct(String weightProduct) {
        this.weightProduct = weightProduct;
    }

    public Long getQuantityProduct() {
        return quantityProduct;
    }

    public void setQuantityProduct(Long quantityProduct) {
        this.quantityProduct = quantityProduct;
    }

    public Double getPriceProduct() {
        return priceProduct;
    }

    public void setPriceProduct(Double priceProduct) {
        this.priceProduct = priceProduct;
    }

    public CapacityDto getCapacityDto() {
        return capacityDto;
    }

    public void setCapacityDto(CapacityDto capacityDto) {
        this.capacityDto = capacityDto;
    }

    public ColorDto getColorDto() {
        return colorDto;
    }

    public void setColorDto(ColorDto colorDto) {
        this.colorDto = colorDto;
    }

    public CpuDto getCpuDto() {
        return cpuDto;
    }

    public void setCpuDto(CpuDto cpuDto) {
        this.cpuDto = cpuDto;
    }

    public RamDto getRamDto() {
        return ramDto;
    }

    public void setRamDto(RamDto ramDto) {
        this.ramDto = ramDto;
    }

    public SeriesDto getSeriesDto() {
        return seriesDto;
    }

    public void setSeriesDto(SeriesDto seriesDto) {
        this.seriesDto = seriesDto;
    }

    public TypeDto getTypeDto() {
        return typeDto;
    }

    public void setTypeDto(TypeDto typeDto) {
        this.typeDto = typeDto;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        ProductDto productDto = (ProductDto) target;
        //-------------------Name product----------------------------//
        if (productDto.getNameProduct() == null){
            errors.rejectValue(NAME_PRODUCT_DTO,"","Vui lòng bổ sung tên sản phẩm.");
        } else if (productDto.getNameProduct().trim().equals("")) {
            errors.rejectValue(NAME_PRODUCT_DTO,"","Không để trống tên sản phẩm.");
        } else if (productDto.getNameProduct().length() < 5) {
            errors.rejectValue(NAME_PRODUCT_DTO,"","Vui lòng nhập tên hơn 5 ký tự");
        } else if (productDto.getNameProduct().length() > 70) {
            errors.rejectValue(NAME_PRODUCT_DTO,"","Tên không quá 70 ký tự.");
        } else if (!productDto.getNameProduct().matches(REGEX_SPECIAL_CHARACTERS)) {
            errors.rejectValue(NAME_PRODUCT_DTO,"","Tên sản phẩm không chứa ký tự đặc biệt.");
        }
        //--------------------Screen product--------------------------//
        if (productDto.getScreenProduct() == null){
            errors.rejectValue(SCREEN_PRODUCT_DTO,"","Vui lòng bổ sung thông tin màn hình sản phẩm.");
        } else if (productDto.getScreenProduct().trim().equals("")) {
            errors.rejectValue(SCREEN_PRODUCT_DTO,"","Không để trống màn hình sản phẩm.");
        } else if (productDto.getScreenProduct().length() < 5) {
            errors.rejectValue(SCREEN_PRODUCT_DTO, "", "Thông tin phải dài hơn 5 ký tự.");
        } else if (productDto.getScreenProduct().length() > 50) {
            errors.rejectValue(SCREEN_PRODUCT_DTO,"","Vui lòng nhập ít hơn 50 ký tự.");
        } else if (!productDto.getScreenProduct().matches(REGEX_SPECIAL_CHARACTERS)){
            errors.rejectValue(SCREEN_PRODUCT_DTO,"","Thông tin không chứa ký tự đặc biệt.");
        }
        //--------------------Camera product--------------------//
        if (productDto.getCameraProduct() == null){
            errors.rejectValue(CAMERA_PRODUCT_DTO,"","Vui lòng bổ sung thông tin camera sản phẩm.");
        } else if (productDto.getCameraProduct().trim().equals("")) {
            errors.rejectValue(CAMERA_PRODUCT_DTO,"","Không để trống thông tin camera sản phẩm.");
        } else if (productDto.getCameraProduct().length() < 5) {
            errors.rejectValue(CAMERA_PRODUCT_DTO,"","Thông tin camera sản phẩm dài hơn 5 ký tự.");
        } else if (productDto.getCameraProduct().length() > 100) {
            errors.rejectValue(CAMERA_PRODUCT_DTO,"","Vui lòng nhập không quá 100 ký tự.");
        } else if (!productDto.getCameraProduct().matches(REGEX_SPECIAL_CHARACTERS)) {
            errors.rejectValue(CAMERA_PRODUCT_DTO,"","Camera không chứa ký tự đặc bIệt.");
        }
        //--------------------Description Product--------------------//
        if (productDto.getDescriptionProduct().length() > 1000000){
            errors.rejectValue(DESCRIPTION_PRODUCT_DTO,"","Thông tin chi tiết sản phẩm quá dài, vui lòng nhập dưới 1.000.000 ký tự");
        }
        //--------------------Selfie Product--------------------//
        if (productDto.getSelfieProduct() == null){
            errors.rejectValue(SELFIE_PRODUCT_DTO,"","Vui lòng bổ sung thông tin selfie.");
        } else if (productDto.getSelfieProduct().trim().equals("")) {
            errors.rejectValue(SELFIE_PRODUCT_DTO,"","Không được để trống thông tin Selfie.");
        } else if (productDto.getSelfieProduct().length() < 5) {
            errors.rejectValue(SELFIE_PRODUCT_DTO,"","Vui lòng nhập hơn 5 ký tự.");
        } else if (productDto.getSelfieProduct().length() > 100){
            errors.rejectValue(SELFIE_PRODUCT_DTO,"","Vui lòng nhập ít hơn 100 ký tự.");
        } else if (!productDto.getSelfieProduct().matches(REGEX_SPECIAL_CHARACTERS)) {
            errors.rejectValue(SELFIE_PRODUCT_DTO,"","Selfie không chứa ký tự đặc biệt.");
        }
        //--------------------Battery Product--------------------//
        if (productDto.getBatteryProduct() == null ){
            errors.rejectValue(BATTERY_PRODUCT_DTO,"","Vui lòng bổ sung thông tin pin.");
        } else if (productDto.getBatteryProduct().trim().equals("")) {
            errors.rejectValue(BATTERY_PRODUCT_DTO,"","Không để trống thông tin pin.");
        } else if (productDto.getBatteryProduct().length() < 5) {
            errors.rejectValue(BATTERY_PRODUCT_DTO,"","Vui lòng nhập hơn 5 ký tự.");
        } else if (productDto.getBatteryProduct().length() > 100) {
            errors.rejectValue(BATTERY_PRODUCT_DTO,"","Vui lòng nhập ít hơn 100 ký tự.");
        } else if (!productDto.getBatteryProduct().matches(REGEX_SPECIAL_CHARACTERS)) {
            errors.rejectValue(BATTERY_PRODUCT_DTO,"","Thông tin pin không chứa ký tự đặc biệt.");
        }
        //--------------------Weight Product--------------------//
        if (productDto.getWeightProduct() == null) {
            errors.rejectValue(WEIGHT_PRODUCT_DTO,"","Vui lòng bổ sung thông tin trọng lượng.");
        } else if (productDto.getWeightProduct().trim().equals("")) {
            errors.rejectValue(WEIGHT_PRODUCT_DTO,"","Không để trống thông tin trọng lượng.");
        } else if (productDto.getWeightProduct().length() < 5) {
            errors.rejectValue(WEIGHT_PRODUCT_DTO,"","Vui lòng nhập hơn 5 ký tự.");
        } else if (productDto.getWeightProduct().length() > 100) {
            errors.rejectValue(WEIGHT_PRODUCT_DTO,"","Vui lòng nhập ít hơn 100 ký tự.");
        } else if (!productDto.getWeightProduct().matches(REGEX_SPECIAL_CHARACTERS)) {
            errors.rejectValue(WEIGHT_PRODUCT_DTO,"","Thông tin trọng lượng không đúng định dạng.");
        }
        //--------------------Price Product--------------------//
        if (productDto.getPriceProduct() == null) {
            errors.rejectValue(PRICE_PRODUCT_DTO,"","Vui lòng bổ sung thông tin giá.");
        } else if (String.valueOf(productDto.getPriceProduct()).isEmpty()) {
            errors.rejectValue(PRICE_PRODUCT_DTO,"","Không để trống thông tin giá.");
        } else if (productDto.getPriceProduct() != null && productDto.getPriceProduct() < 0) {
            errors.rejectValue(PRICE_PRODUCT_DTO,"","Giá không được là số âm.");
        } else if (productDto.getPriceProduct() != null && productDto.getPriceProduct() > 300000000) {
            errors.rejectValue(PRICE_PRODUCT_DTO,"","Giá không quá 300.000.000");
        } else if (String.valueOf(productDto.getPriceProduct()).matches("^\\d{1,7}$")) {
            errors.rejectValue(PRICE_PRODUCT_DTO,"","Thông tin giá không đúng định dạng.");
        }
    }
}
