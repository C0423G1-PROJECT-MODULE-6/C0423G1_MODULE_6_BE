package com.example.c4zone.dto.product;
import com.example.c4zone.model.product.*;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class ProductDto implements Validator {
    private Long idProduct;
    private String nameProduct;
    private String screenProduct;
    private String cameraProduct;
    private String descriptionProduct;
    private Boolean statusBusiness = true;
    private String selfieProduct;
    private String batteryProduct;
    private Double weightProduct;
    private Double quantityProduct;
    private Double priceProduct;
    private ImageDto imageDto;
    private Capacity capacity;
    private Color color;
    private Cpu cpu;
    private Ram ram;
    private Series series;
    private Type type;
    private static final String NAME_PRODUCT_DTO = "nameProduct";
    private static final String SCREEN_PRODUCT_DTO = "screenProduct";
    private static final String CAMERA_PRODUCT_DTO = "cameraProduct";
    private static final String DESCRIPTION_PRODUCT_DTO = "descriptionProduct";
    private static final String SELFIE_PRODUCT_DTO = "selfieProduct";
    private static final String BATTERY_PRODUCT_DTO = "batteryProduct";
    private static final String WEIGHT_PRODUCT_DTO = "weightProduct";
    private static final String PRICE_PRODUCT_DTO = "priceProduct";
    private static final String REGEX_SPECIAL_CHARACTERS = "^(?!.*\\s{2,})[a-zA-Z0-9\\s]*$";

    public ProductDto() {
    }

    public ProductDto(Long idProduct, String nameProduct, String screenProduct, String cameraProduct, String descriptionProduct, Boolean statusBusiness, String selfieProduct, String batteryProduct, Double weightProduct, Double quantityProduct, Double priceProduct, ImageDto imageDto, Capacity capacity, Color color, Cpu cpu, Ram ram, Series series, Type type) {
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
        this.capacity = capacity;
        this.color = color;
        this.cpu = cpu;
        this.ram = ram;
        this.series = series;
        this.type = type;
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

    public Double getWeightProduct() {
        return weightProduct;
    }

    public void setWeightProduct(Double weightProduct) {
        this.weightProduct = weightProduct;
    }

    public Double getQuantityProduct() {
        return quantityProduct;
    }

    public void setQuantityProduct(Double quantityProduct) {
        this.quantityProduct = quantityProduct;
    }

    public Double getPriceProduct() {
        return priceProduct;
    }

    public void setPriceProduct(Double priceProduct) {
        this.priceProduct = priceProduct;
    }

    public Capacity getCapacity() {
        return capacity;
    }

    public void setCapacity(Capacity capacity) {
        this.capacity = capacity;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Cpu getCpu() {
        return cpu;
    }

    public void setCpu(Cpu cpu) {
        this.cpu = cpu;
    }

    public Ram getRam() {
        return ram;
    }

    public void setRam(Ram ram) {
        this.ram = ram;
    }

    public Series getSeries() {
        return series;
    }

    public void setSeries(Series series) {
        this.series = series;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
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
            errors.rejectValue(NAME_PRODUCT_DTO,"","Vui lòng bổ sung tên sản phẩm!");
        } else if (productDto.getNameProduct().trim().equals("")) {
            errors.rejectValue(NAME_PRODUCT_DTO,"","Không được để trống tên sản phẩm!");
        } else if (productDto.getNameProduct().length() < 5) {
            errors.rejectValue(NAME_PRODUCT_DTO,"","Vui lòng nhập tên hơn 5 ký tự!");
        } else if (productDto.getNameProduct().length() > 70) {
            errors.rejectValue(NAME_PRODUCT_DTO,"","Tên sản phẩm quá dài, nhập tên không quá 70 ký tự!");
        } else if (!productDto.getNameProduct().matches("^[a-zA-ZÀ-Úà-úĂăĐđĨĩƠơƯưẠ-ỹ ]*$")) {
            errors.rejectValue(NAME_PRODUCT_DTO,"","Tên sản phẩm không chứa ký tự đặc biệt!");
        }
        //--------------------Screen product--------------------------//
        if (productDto.getScreenProduct() == null){
            errors.rejectValue(SCREEN_PRODUCT_DTO,"","Vui lòng bổ sung thông tin màn hình sản phẩm!");
        } else if (productDto.getScreenProduct().trim().equals("")) {
            errors.rejectValue(SCREEN_PRODUCT_DTO,"","Không được để trống màn hình sản phẩm!");
        } else if (productDto.getScreenProduct().length() < 5) {
            errors.rejectValue(SCREEN_PRODUCT_DTO, "", "Thông tin màn hình phải dài hơn 5 ký tự!");
        } else if (productDto.getScreenProduct().length() > 50) {
            errors.rejectValue(SCREEN_PRODUCT_DTO,"","Thông tin màn hình quá dài, vui lòng nhập ít hơn 50 ký tự!");
        } else if (!productDto.getScreenProduct().matches(REGEX_SPECIAL_CHARACTERS)){
            errors.rejectValue(SCREEN_PRODUCT_DTO,"","Thông tin màn hình khng chứa ký tự đặc biệt!");
        }
        //--------------------Camera product--------------------//
        if (productDto.getCameraProduct() == null){
            errors.rejectValue(CAMERA_PRODUCT_DTO,"","Vui lòng bổ sung thông tin camera sản phẩm!");
        } else if (productDto.getCameraProduct().trim().equals("")) {
            errors.rejectValue(CAMERA_PRODUCT_DTO,"","Không được để trống thông tin camera sản phẩm!");
        } else if (productDto.getCameraProduct().length() < 5) {
            errors.rejectValue(CAMERA_PRODUCT_DTO,"","Thông tin camera sản phẩm dài hơn 5 ký tự!");
        } else if (productDto.getCameraProduct().length() > 100) {
            errors.rejectValue(CAMERA_PRODUCT_DTO,"","Thông tin camera quá dài, vui lòng nhập không quá 100 ký tự!");
        } else if (!productDto.getCameraProduct().matches(REGEX_SPECIAL_CHARACTERS)) {
            errors.rejectValue(CAMERA_PRODUCT_DTO,"","Thông tin camera không chứa ký tự đặc bIệt!");
        }
        //--------------------Description Product--------------------//
        if (productDto.getDescriptionProduct().length() > 1000000){
            errors.rejectValue(DESCRIPTION_PRODUCT_DTO,"","Thông tin chi tiết sản phẩm quá dài, vui lòng nhập dưới 1.000.000 ký tự");
        }
        //--------------------Selfie Product--------------------//
        if (productDto.getSelfieProduct() == null){
            errors.rejectValue(SELFIE_PRODUCT_DTO,"","Vui lòng bổ sung thông tin selfie!");
        } else if (productDto.getSelfieProduct().trim().equals("")) {
            errors.rejectValue(SELFIE_PRODUCT_DTO,"","Không được để trống thông tin Selfie");
        } else if (productDto.getSelfieProduct().length() < 5) {
            errors.rejectValue(SELFIE_PRODUCT_DTO,"","Thông tin selfie quá ngắn, vui lòng nhập hơn 5 ký tự!");
        } else if (productDto.getSelfieProduct().length() > 100){
            errors.rejectValue(SELFIE_PRODUCT_DTO,"","Thông tin selfie quá dài, vui lòng nhập ít hơn 100 ký tự!");
        } else if (!productDto.getSelfieProduct().matches(REGEX_SPECIAL_CHARACTERS)) {
            errors.rejectValue(SELFIE_PRODUCT_DTO,"","Thông tin selfie không chứa ký tự đặc biệt!");
        }
        //--------------------Battery Product--------------------//
        if (productDto.getBatteryProduct() == null ){
            errors.rejectValue(BATTERY_PRODUCT_DTO,"","Vui lòng bổ sung thông tin pin!");
        } else if (productDto.getBatteryProduct().trim().equals("")) {
            errors.rejectValue(BATTERY_PRODUCT_DTO,"","Không được để trống thông tin pin!");
        } else if (productDto.getBatteryProduct().length() < 5) {
            errors.rejectValue(BATTERY_PRODUCT_DTO,"","Thông tin pin quá ngắn, vui lòng nhập hơn 5 ký tự!");
        } else if (productDto.getBatteryProduct().length() > 100) {
            errors.rejectValue(BATTERY_PRODUCT_DTO,"","Thông tin pin quá dài, vui lòng nhập ít hơn 100 ký tự!");
        } else if (productDto.getBatteryProduct().matches(REGEX_SPECIAL_CHARACTERS)) {
            errors.rejectValue(BATTERY_PRODUCT_DTO,"","Thông tin pin không chứa ký tự đặc biệt!");
        }
        //--------------------Weight Product--------------------//
        if (productDto.getWeightProduct() == null) {
            errors.rejectValue(WEIGHT_PRODUCT_DTO,"","Vui lòng bổ sung thông tin trọng lượng!");
        } else if (String.valueOf(productDto.getWeightProduct()).isEmpty()) {
            errors.rejectValue(WEIGHT_PRODUCT_DTO,"","Không được để trống thông tin trọng lượng!!");
        } else if (productDto.getWeightProduct() != null && productDto.getWeightProduct() < 5) {
            errors.rejectValue(WEIGHT_PRODUCT_DTO,"","Thông tin trọng lượng quá ngắn, vui lòng nhập hơn 5 ký tự!");
        } else if (productDto.getWeightProduct() != null && productDto.getWeightProduct() > 100) {
            errors.rejectValue(WEIGHT_PRODUCT_DTO,"","Thông tin trọng lượng quá dài, vui lòng nhập ít hơn 100 ký tự!");
        } else if (String.valueOf(productDto.getWeightProduct()).matches("^\\d{1,7}$")) {
            errors.rejectValue(WEIGHT_PRODUCT_DTO,"","Thông tin trọng lượng không đúng định dạng!");
        }
        //--------------------Price Product--------------------//
        if (productDto.getPriceProduct() == null) {
            errors.rejectValue(PRICE_PRODUCT_DTO,"","Vui lòng bổ sung thông tin giá!");
        } else if (String.valueOf(productDto.getPriceProduct()).isEmpty()) {
            errors.rejectValue(PRICE_PRODUCT_DTO,"","Không được để trống thông tin giá!!");
        } else if (productDto.getPriceProduct() != null && productDto.getPriceProduct() < 0) {
            errors.rejectValue(PRICE_PRODUCT_DTO,"","Giá không được là số âm!");
        } else if (productDto.getPriceProduct() != null && productDto.getPriceProduct() > 300000000) {
            errors.rejectValue(PRICE_PRODUCT_DTO,"","Giá không quá 300.000.000");
        } else if (String.valueOf(productDto.getPriceProduct()).matches("^\\d{1,7}$")) {
            errors.rejectValue(PRICE_PRODUCT_DTO,"","Thông tin giá không đúng định dạng!");
        }
    }
}
