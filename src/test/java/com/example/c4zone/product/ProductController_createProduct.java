//package com.example.c4zone.product;
//
//import com.example.c4zone.dto.product.ImageDto;
//import com.example.c4zone.dto.product.ProductDto;
//import com.example.c4zone.model.product.*;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static sun.jvm.hotspot.code.CompressedStream.L;
//
//
//@SpringBootTest
//@AutoConfigureMockMvc
//public class ProductController_createProduct {
//    @Autowired
//    private MockMvc mockMvc;
//    @Autowired
//    private ObjectMapper objectMapper;
//
//
//    /**
//     * author: DaoPTA
//     * workday: 13/10/2023
//     * This function is used to check if it is correct
//     *
//     * @throws Exception
//     */
//
//    @Test
//    public void createProduct_1 () throws Exception {
//        ProductDto productDto = new ProductDto();
//        productDto.setNameProduct("Iphone 17");
//        productDto.setBatteryProduct("100 mPA");
//        productDto.setCameraProduct("12mp 12mp 12mp");
//        productDto.setPriceProduct(11000000.0);
//        productDto.setQuantityProduct(100L);
//        productDto.setScreenProduct("64 inch");
//        productDto.setSelfieProduct("15mp 15mp 15mp");
//        productDto.setWeightProduct("200.5");
//        productDto.setStatusBusiness(true);
//        productDto.setDescriptionProduct("Ngon bổ rẻ");
//        Capacity capacity = new Capacity();
//        capacity.setIdCapacity(1L);
//        productDto.setCapacity(capacity);
//        Color color = new Color();
//        color.setIdColor(1L);
//        productDto.setColor(color);
//        Cpu cpu = new Cpu();
//        cpu.setIdCpu(1L);
//        productDto.setCpu(cpu);
//        Ram ram = new Ram();
//        ram.setIdRam(1L);
//        productDto.setRam(ram);
//        Series series = new Series();
//        series.setIdSeries(1L);
//        productDto.setSeries(series);
//        Type type = new Type();
//        type.setIdType(1L);
//        productDto.setType(type);
//        ImageDto imageDto = new ImageDto();
//        imageDto.setName("image");
//        imageDto.setStatusImage(true);
//        productDto.setImageDto(imageDto);
//        this.mockMvc.perform(
//                MockMvcRequestBuilders.post("/api/admin/product/add")
//                        .content(this.objectMapper.writeValueAsString(productDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is2xxSuccessful());
//    }
//
//    /**
//     * author: DaoPTA
//     * workday: 13/10/2023
//     * this function use to test the validation of field name more specific is null
//     *
//     * @throws Exception
//     */
//    @Test
//    public void createProduct_name_2 () throws Exception {
//        ProductDto productDto = new ProductDto();
//        productDto.setNameProduct("!@$@&@(&@)");
//        productDto.setBatteryProduct("100 mAH");
//        productDto.setCameraProduct("12mp 12mp 12mp");
//        productDto.setPriceProduct(11000000.0);
//        productDto.setQuantityProduct(10L);
//        productDto.setScreenProduct("64 inch");
//        productDto.setSelfieProduct("15mp 15mp");
//        productDto.setWeightProduct("200.5");
//        productDto.setStatusBusiness(true);
//        productDto.setDescriptionProduct("Ngon bổ rẻ");
//        Capacity capacity = new Capacity();
//        capacity.setIdCapacity(1L);
//        productDto.setCapacity(capacity);
//        Color color = new Color();
//        color.setIdColor(1L);
//        productDto.setColor(color);
//        Cpu cpu = new Cpu();
//        cpu.setIdCpu(1L);
//        productDto.setCpu(cpu);
//        Ram ram = new Ram();
//        ram.setIdRam(1L);
//        productDto.setRam(ram);
//        Series series = new Series();
//        series.setIdSeries(1L);
//        productDto.setSeries(series);
//        Type type = new Type();
//        type.setIdType(1L);
//        productDto.setType(type);
//        ImageDto imageDto = new ImageDto();
//        imageDto.setName("image");
//        imageDto.setStatusImage(true);
//        productDto.setImageDto(imageDto);
//        this.mockMvc.perform(
//                        MockMvcRequestBuilders.post("/api/admin/product/add")
//                                .content(this.objectMapper.writeValueAsString(productDto))
//                                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * author: DaoPTA
//     * workday: 13/10/2023
//     * This function is used to validate specific field names rather than WRONG FORMAT
//     *
//     * @throws Exception
//     */
//    @Test
//    public void createProduct_name_3 () throws Exception {
//        ProductDto productDto = new ProductDto();
//        productDto.setNameProduct("42387283HFWEJHDJ");
//        productDto.setBatteryProduct("100%");
//        productDto.setCameraProduct("12mp, 12mp, 12mp");
//        productDto.setPriceProduct(11000000.0);
//        productDto.setQuantityProduct(0L);
//        productDto.setScreenProduct("64 in");
//        productDto.setSelfieProduct("15mp");
//        productDto.setWeightProduct("200.5");
//        productDto.setStatusBusiness(true);
//        productDto.setDescriptionProduct("Ngon bổ rẻ");
//        Capacity capacity = new Capacity();
//        capacity.setIdCapacity(1L);
//        productDto.setCapacity(capacity);
//        Color color = new Color();
//        color.setIdColor(1L);
//        productDto.setColor(color);
//        Cpu cpu = new Cpu();
//        cpu.setIdCpu(1L);
//        productDto.setCpu(cpu);
//        Ram ram = new Ram();
//        ram.setIdRam(1L);
//        productDto.setRam(ram);
//        Series series = new Series();
//        series.setIdSeries(1L);
//        productDto.setSeries(series);
//        Type type = new Type();
//        type.setIdType(1L);
//        productDto.setType(type);
//        ImageDto imageDto = new ImageDto();
//        imageDto.setName("image");
//        imageDto.setStatusImage(true);
//        productDto.setImageDto(imageDto);
//        this.mockMvc.perform(
//                        MockMvcRequestBuilders.post("/api/admin/product/add")
//                                .content(this.objectMapper.writeValueAsString(productDto))
//                                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * author: DaoPTA
//     * workday: 13/10/2023
//     * This function is used to check that specific field names are not entered
//     *
//     * @throws Exception
//     */
//    @Test
//    public void createProduct_name_4 () throws Exception {
//        ProductDto productDto = new ProductDto();
//        productDto.setNameProduct("!@$@&@(&@)");
//        productDto.setBatteryProduct("100%");
//        productDto.setCameraProduct("12mp, 12mp, 12mp");
//        productDto.setPriceProduct(11000000.0);
//        productDto.setQuantityProduct(0L);
//        productDto.setScreenProduct("64 in");
//        productDto.setSelfieProduct("15mp");
//        productDto.setWeightProduct("200.5");
//        productDto.setStatusBusiness(true);
//        productDto.setDescriptionProduct("Ngon bổ rẻ");
//        Capacity capacity = new Capacity();
//        capacity.setIdCapacity(1L);
//        productDto.setCapacity(capacity);
//        Color color = new Color();
//        color.setIdColor(1L);
//        productDto.setColor(color);
//        Cpu cpu = new Cpu();
//        cpu.setIdCpu(1L);
//        productDto.setCpu(cpu);
//        Ram ram = new Ram();
//        ram.setIdRam(1L);
//        productDto.setRam(ram);
//        Series series = new Series();
//        series.setIdSeries(1L);
//        productDto.setSeries(series);
//        Type type = new Type();
//        type.setIdType(1L);
//        productDto.setType(type);
//        ImageDto imageDto = new ImageDto();
//        imageDto.setName("image");
//        imageDto.setStatusImage(true);
//        productDto.setImageDto(imageDto);
//        this.mockMvc.perform(
//                        MockMvcRequestBuilders.post("/api/admin/product/add")
//                                .content(this.objectMapper.writeValueAsString(productDto))
//                                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * author: DaoPTA
//     * workday: 13/10/2023
//     * This function is used to check and confirm that a specific field name is not entered more than the number of characters
//     *
//     * @throws Exception
//     */
//    @Test
//    public void createProduct_name_5 () throws Exception {
//        ProductDto productDto = new ProductDto();
//        productDto.setNameProduct("Phan Tá Anh Đàooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo" +
//                "ooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo" +
//                "ooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo");
//        productDto.setBatteryProduct("100%");
//        productDto.setCameraProduct("12mp, 12mp, 12mp");
//        productDto.setPriceProduct(11000000.0);
//        productDto.setQuantityProduct(0L);
//        productDto.setScreenProduct("64 in");
//        productDto.setSelfieProduct("15mp");
//        productDto.setWeightProduct("200.5");
//        productDto.setStatusBusiness(true);
//        productDto.setDescriptionProduct("Ngon bổ rẻ");
//        Capacity capacity = new Capacity();
//        capacity.setIdCapacity(1L);
//        productDto.setCapacity(capacity);
//        Color color = new Color();
//        color.setIdColor(1L);
//        productDto.setColor(color);
//        Cpu cpu = new Cpu();
//        cpu.setIdCpu(1L);
//        productDto.setCpu(cpu);
//        Ram ram = new Ram();
//        ram.setIdRam(1L);
//        productDto.setRam(ram);
//        Series series = new Series();
//        series.setIdSeries(1L);
//        productDto.setSeries(series);
//        Type type = new Type();
//        type.setIdType(1L);
//        productDto.setType(type);
//        ImageDto imageDto = new ImageDto();
//        imageDto.setName("image");
//        imageDto.setStatusImage(true);
//        productDto.setImageDto(imageDto);
//        this.mockMvc.perform(
//                        MockMvcRequestBuilders.post("/api/admin/product/add")
//                                .content(this.objectMapper.writeValueAsString(productDto))
//                                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * author: DaoPTA
//     * workday: 13/10/2023
//     * this function use to test the validation of field price more specific is null
//     *
//     * @throws Exception
//     */
//    @Test
//    public void createProduct_price_2 () throws Exception {
//        ProductDto productDto = new ProductDto();
//        productDto.setNameProduct("Phan Tá Anh Đào");
//        productDto.setBatteryProduct("100 aMH");
//        productDto.setCameraProduct("12mp 12mp 12mp");
//        productDto.setPriceProduct(11000000.0);
//        productDto.setQuantityProduct(Long.valueOf("edhscjhjkcdnxkl"));
//        productDto.setScreenProduct("64 inch");
//        productDto.setSelfieProduct("15mp 15mp");
//        productDto.setWeightProduct("200.5");
//        productDto.setStatusBusiness(true);
//        productDto.setDescriptionProduct("Ngon bổ rẻ");
//        Capacity capacity = new Capacity();
//        capacity.setIdCapacity(1L);
//        productDto.setCapacity(capacity);
//        Color color = new Color();
//        color.setIdColor(1L);
//        productDto.setColor(color);
//        Cpu cpu = new Cpu();
//        cpu.setIdCpu(1L);
//        productDto.setCpu(cpu);
//        Ram ram = new Ram();
//        ram.setIdRam(1L);
//        productDto.setRam(ram);
//        Series series = new Series();
//        series.setIdSeries(1L);
//        productDto.setSeries(series);
//        Type type = new Type();
//        type.setIdType(1L);
//        productDto.setType(type);
//        ImageDto imageDto = new ImageDto();
//        imageDto.setName("image");
//        imageDto.setStatusImage(true);
//        productDto.setImageDto(imageDto);
//        this.mockMvc.perform(
//                        MockMvcRequestBuilders.post("/api/admin/product/add")
//                                .content(this.objectMapper.writeValueAsString(productDto))
//                                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * author: DaoPTA
//     * workday: 13/10/2023
//     * This function is used to validate specific field price rather than WRONG FORMAT
//     *
//     * @throws Exception
//     */
//    @Test
//    public void createProduct_price_3_4 () throws Exception {
//        ProductDto productDto = new ProductDto();
//        productDto.setNameProduct("Phan Tá Anh Đào");
//        productDto.setBatteryProduct("100%");
//        productDto.setCameraProduct("12mp, 12mp, 12mp");
//        productDto.setPriceProduct(Double.valueOf("ebhdkbqjdnkbe32or893ehoew"));
//        productDto.setQuantityProduct(0L);
//        productDto.setScreenProduct("64 in");
//        productDto.setSelfieProduct("15mp");
//        productDto.setWeightProduct("200.5");
//        productDto.setStatusBusiness(true);
//        productDto.setDescriptionProduct("Ngon bổ rẻ");
//        Capacity capacity = new Capacity();
//        capacity.setIdCapacity(1L);
//        productDto.setCapacity(capacity);
//        Color color = new Color();
//        color.setIdColor(1L);
//        productDto.setColor(color);
//        Cpu cpu = new Cpu();
//        cpu.setIdCpu(1L);
//        productDto.setCpu(cpu);
//        Ram ram = new Ram();
//        ram.setIdRam(1L);
//        productDto.setRam(ram);
//        Series series = new Series();
//        series.setIdSeries(1L);
//        productDto.setSeries(series);
//        Type type = new Type();
//        type.setIdType(1L);
//        productDto.setType(type);
//        ImageDto imageDto = new ImageDto();
//        imageDto.setName("image");
//        imageDto.setStatusImage(true);
//        productDto.setImageDto(imageDto);
//        this.mockMvc.perform(
//                        MockMvcRequestBuilders.post("/api/admin/product/add")
//                                .content(this.objectMapper.writeValueAsString(productDto))
//                                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * author: DaoPTA
//     * workday: 13/10/2023
//     * This function is used to check and confirm that a specific field price is not entered more than the number of characters
//     *
//     * @throws Exception
//     */
//    @Test
//    public void createProduct_price_5 () throws Exception {
//        ProductDto productDto = new ProductDto();
//        productDto.setNameProduct("Phan Tá Anh Đào");
//        productDto.setBatteryProduct("100%");
//        productDto.setCameraProduct("12mp, 12mp, 12mp");
//        productDto.setPriceProduct(30000000000000000000000000000000000000000000000000000000000000000000000000000000000000000.0);
//        productDto.setQuantityProduct(0L);
//        productDto.setScreenProduct("64 in");
//        productDto.setSelfieProduct("15mp");
//        productDto.setWeightProduct("200.5");
//        productDto.setStatusBusiness(true);
//        productDto.setDescriptionProduct("Ngon bổ rẻ");
//        Capacity capacity = new Capacity();
//        capacity.setIdCapacity(1L);
//        productDto.setCapacity(capacity);
//        Color color = new Color();
//        color.setIdColor(1L);
//        productDto.setColor(color);
//        Cpu cpu = new Cpu();
//        cpu.setIdCpu(1L);
//        productDto.setCpu(cpu);
//        Ram ram = new Ram();
//        ram.setIdRam(1L);
//        productDto.setRam(ram);
//        Series series = new Series();
//        series.setIdSeries(1L);
//        productDto.setSeries(series);
//        Type type = new Type();
//        type.setIdType(1L);
//        productDto.setType(type);
//        ImageDto imageDto = new ImageDto();
//        imageDto.setName("image");
//        imageDto.setStatusImage(true);
//        productDto.setImageDto(imageDto);
//        this.mockMvc.perform(
//                        MockMvcRequestBuilders.post("/api/admin/product/add")
//                                .content(this.objectMapper.writeValueAsString(productDto))
//                                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * author: DaoPTA
//     * workday: 13/10/2023
//     * this function use to test the validation of field battery more specific is null
//     *
//     * @throws Exception
//     */
//    @Test
//    public void createProduct_battery_2 () throws Exception {
//        ProductDto productDto = new ProductDto();
//        productDto.setNameProduct("Phan Tá Anh Đào");
////        productDto.setBatteryProduct("100%");
//        productDto.setCameraProduct("12mp, 12mp, 12mp");
//        productDto.setPriceProduct(11000000.0);
//        productDto.setQuantityProduct(0L);
//        productDto.setScreenProduct("64 in");
//        productDto.setSelfieProduct("15mp");
//        productDto.setWeightProduct("200.5");
//        productDto.setStatusBusiness(true);
//        productDto.setDescriptionProduct("Ngon bổ rẻ");
//        Capacity capacity = new Capacity();
//        capacity.setIdCapacity(1L);
//        productDto.setCapacity(capacity);
//        Color color = new Color();
//        color.setIdColor(1L);
//        productDto.setColor(color);
//        Cpu cpu = new Cpu();
//        cpu.setIdCpu(1L);
//        productDto.setCpu(cpu);
//        Ram ram = new Ram();
//        ram.setIdRam(1L);
//        productDto.setRam(ram);
//        Series series = new Series();
//        series.setIdSeries(1L);
//        productDto.setSeries(series);
//        Type type = new Type();
//        type.setIdType(1L);
//        productDto.setType(type);
//        ImageDto imageDto = new ImageDto();
//        imageDto.setName("image");
//        imageDto.setStatusImage(true);
//        productDto.setImageDto(imageDto);
//        this.mockMvc.perform(
//                        MockMvcRequestBuilders.post("/api/admin/product/add")
//                                .content(this.objectMapper.writeValueAsString(productDto))
//                                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * author: DaoPTA
//     * workday: 13/10/2023
//     * This function is used to validate specific field battery rather than WRONG FORMAT
//     *
//     * @throws Exception
//     */
//    @Test
//    public void createProduct_battety_3_4 () throws Exception {
//        ProductDto productDto = new ProductDto();
//        productDto.setNameProduct("Phan Tá Anh Đào");
//        productDto.setBatteryProduct("100!@#");
//        productDto.setCameraProduct("12mp, 12mp, 12mp");
//        productDto.setPriceProduct(11000000.0);
//        productDto.setQuantityProduct(0L);
//        productDto.setScreenProduct("64 in");
//        productDto.setSelfieProduct("15mp");
//        productDto.setWeightProduct("200.5");
//        productDto.setStatusBusiness(true);
//        productDto.setDescriptionProduct("Ngon bổ rẻ");
//        Capacity capacity = new Capacity();
//        capacity.setIdCapacity(1L);
//        productDto.setCapacity(capacity);
//        Color color = new Color();
//        color.setIdColor(1L);
//        productDto.setColor(color);
//        Cpu cpu = new Cpu();
//        cpu.setIdCpu(1L);
//        productDto.setCpu(cpu);
//        Ram ram = new Ram();
//        ram.setIdRam(1L);
//        productDto.setRam(ram);
//        Series series = new Series();
//        series.setIdSeries(1L);
//        productDto.setSeries(series);
//        Type type = new Type();
//        type.setIdType(1L);
//        productDto.setType(type);
//        ImageDto imageDto = new ImageDto();
//        imageDto.setName("image");
//        imageDto.setStatusImage(true);
//        productDto.setImageDto(imageDto);
//        this.mockMvc.perform(
//                        MockMvcRequestBuilders.post("/api/admin/product/add")
//                                .content(this.objectMapper.writeValueAsString(productDto))
//                                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * author: DaoPTA
//     * workday: 13/10/2023
//     * This function is used to check and confirm that a specific field battery is not entered more than the number of characters
//     *
//     * @throws Exception
//     */
//    @Test
//    public void createProduct_battery_5 () throws Exception {
//        ProductDto productDto = new ProductDto();
//        productDto.setNameProduct("Phan Tá Anh Đào");
//        productDto.setBatteryProduct("100%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%" +
//                "%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%" +
//                "%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
//        productDto.setCameraProduct("12mp, 12mp, 12mp");
//        productDto.setPriceProduct(11000000.0);
//        productDto.setQuantityProduct(0L);
//        productDto.setScreenProduct("64 in");
//        productDto.setSelfieProduct("15mp");
//        productDto.setWeightProduct("200.5");
//        productDto.setStatusBusiness(true);
//        productDto.setDescriptionProduct("Ngon bổ rẻ");
//        Capacity capacity = new Capacity();
//        capacity.setIdCapacity(1L);
//        productDto.setCapacity(capacity);
//        Color color = new Color();
//        color.setIdColor(1L);
//        productDto.setColor(color);
//        Cpu cpu = new Cpu();
//        cpu.setIdCpu(1L);
//        productDto.setCpu(cpu);
//        Ram ram = new Ram();
//        ram.setIdRam(1L);
//        productDto.setRam(ram);
//        Series series = new Series();
//        series.setIdSeries(1L);
//        productDto.setSeries(series);
//        Type type = new Type();
//        type.setIdType(1L);
//        productDto.setType(type);
//        ImageDto imageDto = new ImageDto();
//        imageDto.setName("image");
//        imageDto.setStatusImage(true);
//        productDto.setImageDto(imageDto);
//        this.mockMvc.perform(
//                        MockMvcRequestBuilders.post("/api/admin/product/add")
//                                .content(this.objectMapper.writeValueAsString(productDto))
//                                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * author: DaoPTA
//     * workday: 13/10/2023
//     * this function use to test the validation of field camera more specific is null
//     *
//     * @throws Exception
//     */
//    @Test
//    public void createProduct_camera_2 () throws Exception {
//        ProductDto productDto = new ProductDto();
//        productDto.setNameProduct("Phan Tá Anh Đào");
//        productDto.setBatteryProduct("100%");
////        productDto.setCameraProduct("12mp, 12mp, 12mp");
//        productDto.setPriceProduct(11000000.0);
//        productDto.setQuantityProduct(0L);
//        productDto.setScreenProduct("64 in");
//        productDto.setSelfieProduct("15mp");
//        productDto.setWeightProduct("200.5");
//        productDto.setStatusBusiness(true);
//        productDto.setDescriptionProduct("Ngon bổ rẻ");
//        Capacity capacity = new Capacity();
//        capacity.setIdCapacity(1L);
//        productDto.setCapacity(capacity);
//        Color color = new Color();
//        color.setIdColor(1L);
//        productDto.setColor(color);
//        Cpu cpu = new Cpu();
//        cpu.setIdCpu(1L);
//        productDto.setCpu(cpu);
//        Ram ram = new Ram();
//        ram.setIdRam(1L);
//        productDto.setRam(ram);
//        Series series = new Series();
//        series.setIdSeries(1L);
//        productDto.setSeries(series);
//        Type type = new Type();
//        type.setIdType(1L);
//        productDto.setType(type);
//        ImageDto imageDto = new ImageDto();
//        imageDto.setName("image");
//        imageDto.setStatusImage(true);
//        productDto.setImageDto(imageDto);
//        this.mockMvc.perform(
//                        MockMvcRequestBuilders.post("/api/admin/product/add")
//                                .content(this.objectMapper.writeValueAsString(productDto))
//                                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * author: DaoPTA
//     * workday: 13/10/2023
//     * This function is used to validate specific field camera rather than WRONG FORMAT
//     *
//     * @throws Exception
//     */
//    @Test
//    public void createProduct_camera_3_4 () throws Exception {
//        ProductDto productDto = new ProductDto();
//        productDto.setNameProduct("Phan Tá Anh Đào");
//        productDto.setBatteryProduct("100%");
//        productDto.setCameraProduct("$^^&&^*^*");
//        productDto.setPriceProduct(11000000.0);
//        productDto.setQuantityProduct(0L);
//        productDto.setScreenProduct("64 in");
//        productDto.setSelfieProduct("15mp");
//        productDto.setWeightProduct("200.5");
//        productDto.setStatusBusiness(true);
//        productDto.setDescriptionProduct("Ngon bổ rẻ");
//        Capacity capacity = new Capacity();
//        capacity.setIdCapacity(1L);
//        productDto.setCapacity(capacity);
//        Color color = new Color();
//        color.setIdColor(1L);
//        productDto.setColor(color);
//        Cpu cpu = new Cpu();
//        cpu.setIdCpu(1L);
//        productDto.setCpu(cpu);
//        Ram ram = new Ram();
//        ram.setIdRam(1L);
//        productDto.setRam(ram);
//        Series series = new Series();
//        series.setIdSeries(1L);
//        productDto.setSeries(series);
//        Type type = new Type();
//        type.setIdType(1L);
//        productDto.setType(type);
//        ImageDto imageDto = new ImageDto();
//        imageDto.setName("image");
//        imageDto.setStatusImage(true);
//        productDto.setImageDto(imageDto);
//        this.mockMvc.perform(
//                        MockMvcRequestBuilders.post("/api/admin/product/add")
//                                .content(this.objectMapper.writeValueAsString(productDto))
//                                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * author: DaoPTA
//     * workday: 13/10/2023
//     * This function is used to check and confirm that a specific field camera is not entered more than the number of characters
//     *
//     * @throws Exception
//     */
//    @Test
//    public void createProduct_camera_5 () throws Exception {
//        ProductDto productDto = new ProductDto();
//        productDto.setNameProduct("Phan Tá Anh Đào");
//        productDto.setBatteryProduct("100%");
//        productDto.setCameraProduct("12mp, 12mp, 12mp,12mp, 12mp, 12mp,12mp, 12mp, 12mp," +
//                "12mp, 12mp, 12mp,12mp, 12mp, 12mp,12mp, 12mp, 12mp,12mp, 12mp, 12mp,12mp, 12mp, 12mp," +
//                "12mp, 12mp, 12mp,12mp, 12mp, 12mp,12mp, 12mp, 12mp,12mp, 12mp, 12mp,12mp, 12mp, 12mp," +
//                "12mp, 12mp, 12mp,12mp, 12mp, 12mp,12mp, 12mp, 12mp,12mp, 12mp, 12mp,12mp, 12mp, 12mp,12mp, 12mp, 12mp," +
//                "12mp, 12mp, 12mp,12mp, 12mp, 12mp,12mp, 12mp, 12mp,12mp, 12mp, 12mp,12mp, 12mp, 12mp," +
//                "12mp, 12mp, 12mp,12mp, 12mp, 12mp,12mp, 12mp, 12mp,12mp, 12mp, 12mp,12mp, 12mp, 12mp," +
//                "12mp, 12mp, 12mp,12mp, 12mp, 12mp,12mp, 12mp, 12mp,12mp, 12mp, 12mp,12mp, 12mp, 12mp");
//        productDto.setPriceProduct(11000000.0);
//        productDto.setQuantityProduct(0L);
//        productDto.setScreenProduct("64 in");
//        productDto.setSelfieProduct("15mp");
//        productDto.setWeightProduct("200.5");
//        productDto.setStatusBusiness(true);
//        productDto.setDescriptionProduct("Ngon bổ rẻ");
//        Capacity capacity = new Capacity();
//        capacity.setIdCapacity(1L);
//        productDto.setCapacity(capacity);
//        Color color = new Color();
//        color.setIdColor(1L);
//        productDto.setColor(color);
//        Cpu cpu = new Cpu();
//        cpu.setIdCpu(1L);
//        productDto.setCpu(cpu);
//        Ram ram = new Ram();
//        ram.setIdRam(1L);
//        productDto.setRam(ram);
//        Series series = new Series();
//        series.setIdSeries(1L);
//        productDto.setSeries(series);
//        Type type = new Type();
//        type.setIdType(1L);
//        productDto.setType(type);
//        ImageDto imageDto = new ImageDto();
//        imageDto.setName("image");
//        imageDto.setStatusImage(true);
//        productDto.setImageDto(imageDto);
//        this.mockMvc.perform(
//                        MockMvcRequestBuilders.post("/api/admin/product/add")
//                                .content(this.objectMapper.writeValueAsString(productDto))
//                                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * author: DaoPTA
//     * workday: 13/10/2023
//     * this function use to test the validation of field quantity more specific is null
//     *
//     * @throws Exception
//     */
//    @Test
//    public void createProduct_quantity_2 () throws Exception {
//        ProductDto productDto = new ProductDto();
//        productDto.setNameProduct("Phan Tá Anh Đào");
//        productDto.setBatteryProduct("100%");
//        productDto.setCameraProduct("12mp, 12mp, 12mp");
//        productDto.setPriceProduct(11000000.0);
////        productDto.setQuantityProduct(0.0D);
//        productDto.setScreenProduct("64 in");
//        productDto.setSelfieProduct("15mp");
//        productDto.setWeightProduct("200.5");
//        productDto.setStatusBusiness(true);
//        productDto.setDescriptionProduct("Ngon bổ rẻ");
//        Capacity capacity = new Capacity();
//        capacity.setIdCapacity(1L);
//        productDto.setCapacity(capacity);
//        Color color = new Color();
//        color.setIdColor(1L);
//        productDto.setColor(color);
//        Cpu cpu = new Cpu();
//        cpu.setIdCpu(1L);
//        productDto.setCpu(cpu);
//        Ram ram = new Ram();
//        ram.setIdRam(1L);
//        productDto.setRam(ram);
//        Series series = new Series();
//        series.setIdSeries(1L);
//        productDto.setSeries(series);
//        Type type = new Type();
//        type.setIdType(1L);
//        productDto.setType(type);
//        ImageDto imageDto = new ImageDto();
//        imageDto.setName("image");
//        imageDto.setStatusImage(true);
//        productDto.setImageDto(imageDto);
//        this.mockMvc.perform(
//                        MockMvcRequestBuilders.post("/api/admin/product/add")
//                                .content(this.objectMapper.writeValueAsString(productDto))
//                                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * author: DaoPTA
//     * workday: 13/10/2023
//     * This function is used to validate specific field quantity rather than WRONG FORMAT
//     *
//     * @throws Exception
//     */
//    @Test
//    public void createProduct_quantity_3_4 () throws Exception {
//        ProductDto productDto = new ProductDto();
//        productDto.setNameProduct("Phan Tá Anh Đào");
//        productDto.setBatteryProduct("100%");
//        productDto.setCameraProduct("12mp, 12mp, 12mp");
//        productDto.setPriceProduct(11000000.0);
//        productDto.setQuantityProduct(Long.valueOf("38249ry2yhu2efef"));
//        productDto.setScreenProduct("64 in");
//        productDto.setSelfieProduct("15mp");
//        productDto.setWeightProduct("200.5");
//        productDto.setStatusBusiness(true);
//        productDto.setDescriptionProduct("Ngon bổ rẻ");
//        Capacity capacity = new Capacity();
//        capacity.setIdCapacity(1L);
//        productDto.setCapacity(capacity);
//        Color color = new Color();
//        color.setIdColor(1L);
//        productDto.setColor(color);
//        Cpu cpu = new Cpu();
//        cpu.setIdCpu(1L);
//        productDto.setCpu(cpu);
//        Ram ram = new Ram();
//        ram.setIdRam(1L);
//        productDto.setRam(ram);
//        Series series = new Series();
//        series.setIdSeries(1L);
//        productDto.setSeries(series);
//        Type type = new Type();
//        type.setIdType(1L);
//        productDto.setType(type);
//        ImageDto imageDto = new ImageDto();
//        imageDto.setName("image");
//        imageDto.setStatusImage(true);
//        productDto.setImageDto(imageDto);
//        this.mockMvc.perform(
//                        MockMvcRequestBuilders.post("/api/admin/product/add")
//                                .content(this.objectMapper.writeValueAsString(productDto))
//                                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * author: DaoPTA
//     * workday: 13/10/2023
//     * This function is used to check and confirm that a specific field quantity is not entered more than the number of characters
//     *
//     * @throws Exception
//     */
//    @Test
//    public void createProduct_quantity_5 () throws Exception {
//        ProductDto productDto = new ProductDto();
//        productDto.setNameProduct("Phan Tá Anh Đào");
//        productDto.setBatteryProduct("100%");
//        productDto.setCameraProduct("12mp, 12mp, 12mp");
//        productDto.setPriceProduct(11000000.0);
//        productDto.setQuantityProduct(1000000000000000000L);
//        productDto.setScreenProduct("64 in");
//        productDto.setSelfieProduct("15mp");
//        productDto.setWeightProduct("200.5");
//        productDto.setStatusBusiness(true);
//        productDto.setDescriptionProduct("Ngon bổ rẻ");
//        Capacity capacity = new Capacity();
//        capacity.setIdCapacity(1L);
//        productDto.setCapacity(capacity);
//        Color color = new Color();
//        color.setIdColor(1L);
//        productDto.setColor(color);
//        Cpu cpu = new Cpu();
//        cpu.setIdCpu(1L);
//        productDto.setCpu(cpu);
//        Ram ram = new Ram();
//        ram.setIdRam(1L);
//        productDto.setRam(ram);
//        Series series = new Series();
//        series.setIdSeries(1L);
//        productDto.setSeries(series);
//        Type type = new Type();
//        type.setIdType(1L);
//        productDto.setType(type);
//        ImageDto imageDto = new ImageDto();
//        imageDto.setName("image");
//        imageDto.setStatusImage(true);
//        productDto.setImageDto(imageDto);
//        this.mockMvc.perform(
//                        MockMvcRequestBuilders.post("/api/admin/product/add")
//                                .content(this.objectMapper.writeValueAsString(productDto))
//                                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * author: DaoPTA
//     * workday: 13/10/2023
//     * this function use to test the validation of field screen more specific is null
//     *
//     * @throws Exception
//     */
//    @Test
//    public void createProduct_screen_2 () throws Exception {
//        ProductDto productDto = new ProductDto();
//        productDto.setNameProduct("Phan Tá Anh Đào");
//        productDto.setBatteryProduct("100%");
//        productDto.setCameraProduct("12mp, 12mp, 12mp");
//        productDto.setPriceProduct(11000000.0);
//        productDto.setQuantityProduct(0L);
////        productDto.setScreenProduct("64 in");
//        productDto.setSelfieProduct("15mp");
//        productDto.setWeightProduct("200.5");
//        productDto.setStatusBusiness(true);
//        productDto.setDescriptionProduct("Ngon bổ rẻ");
//        Capacity capacity = new Capacity();
//        capacity.setIdCapacity(1L);
//        productDto.setCapacity(capacity);
//        Color color = new Color();
//        color.setIdColor(1L);
//        productDto.setColor(color);
//        Cpu cpu = new Cpu();
//        cpu.setIdCpu(1L);
//        productDto.setCpu(cpu);
//        Ram ram = new Ram();
//        ram.setIdRam(1L);
//        productDto.setRam(ram);
//        Series series = new Series();
//        series.setIdSeries(1L);
//        productDto.setSeries(series);
//        Type type = new Type();
//        type.setIdType(1L);
//        productDto.setType(type);
//        ImageDto imageDto = new ImageDto();
//        imageDto.setName("image");
//        imageDto.setStatusImage(true);
//        productDto.setImageDto(imageDto);
//        this.mockMvc.perform(
//                        MockMvcRequestBuilders.post("/api/admin/product/add")
//                                .content(this.objectMapper.writeValueAsString(productDto))
//                                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * author: DaoPTA
//     * workday: 13/10/2023
//     * This function is used to validate specific field screen rather than WRONG FORMAT
//     *
//     * @throws Exception
//     */
//    @Test
//    public void createProduct_screen_3_4 () throws Exception {
//        ProductDto productDto = new ProductDto();
//        productDto.setNameProduct("Phan Tá Anh Đào");
//        productDto.setBatteryProduct("100%");
//        productDto.setCameraProduct("12mp, 12mp, 12mp");
//        productDto.setPriceProduct(11000000.0);
//        productDto.setQuantityProduct(0L);
//        productDto.setScreenProduct("#@&*@2823471834ffdgsds");
//        productDto.setSelfieProduct("15mp");
//        productDto.setWeightProduct("200.5");
//        productDto.setStatusBusiness(true);
//        productDto.setDescriptionProduct("Ngon bổ rẻ");
//        Capacity capacity = new Capacity();
//        capacity.setIdCapacity(1L);
//        productDto.setCapacity(capacity);
//        Color color = new Color();
//        color.setIdColor(1L);
//        productDto.setColor(color);
//        Cpu cpu = new Cpu();
//        cpu.setIdCpu(1L);
//        productDto.setCpu(cpu);
//        Ram ram = new Ram();
//        ram.setIdRam(1L);
//        productDto.setRam(ram);
//        Series series = new Series();
//        series.setIdSeries(1L);
//        productDto.setSeries(series);
//        Type type = new Type();
//        type.setIdType(1L);
//        productDto.setType(type);
//        ImageDto imageDto = new ImageDto();
//        imageDto.setName("image");
//        imageDto.setStatusImage(true);
//        productDto.setImageDto(imageDto);
//        this.mockMvc.perform(
//                        MockMvcRequestBuilders.post("/api/admin/product/add")
//                                .content(this.objectMapper.writeValueAsString(productDto))
//                                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * author: DaoPTA
//     * workday: 13/10/2023
//     * This function is used to check and confirm that a specific field screen is not entered more than the number of characters
//     *
//     * @throws Exception
//     */
//    @Test
//    public void createProduct_screen_5 () throws Exception {
//        ProductDto productDto = new ProductDto();
//        productDto.setNameProduct("Phan Tá Anh Đào");
//        productDto.setBatteryProduct("100%");
//        productDto.setCameraProduct("12mp, 12mp, 12mp");
//        productDto.setPriceProduct(11000000.0);
//        productDto.setQuantityProduct(0L);
//        productDto.setScreenProduct("64 in,64 in,64 in,64 in,64 in,64 in,64 in,64 in,64 in,64 in,64 in," +
//                "64 in,64 in,64 in,64 in,64 in,64 in,64 in,64 in,64 in,64 in,64 in,64 in,64 in,64 in,64 in," +
//                "64 in,64 in,64 in,64 in,64 in,64 in,64 in,64 in,64 in,64 in,64 in,64 in,64 in,64 in,64 in," +
//                "64 in,64 in,64 in,64 in,64 in,64 in,64 in,64 in,64 in,64 in,64 in,64 in,64 in,64 in,64 in," +
//                "64 in,64 in,64 in,64 in,64 in,64 in,64 in,64 in,64 in,64 in,64 in,64 in,64 in,64 in,64 in," +
//                "64 innnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn");
//        productDto.setSelfieProduct("15mp");
//        productDto.setWeightProduct("200.5");
//        productDto.setStatusBusiness(true);
//        productDto.setDescriptionProduct("Ngon bổ rẻ");
//        Capacity capacity = new Capacity();
//        capacity.setIdCapacity(1L);
//        productDto.setCapacity(capacity);
//        Color color = new Color();
//        color.setIdColor(1L);
//        productDto.setColor(color);
//        Cpu cpu = new Cpu();
//        cpu.setIdCpu(1L);
//        productDto.setCpu(cpu);
//        Ram ram = new Ram();
//        ram.setIdRam(1L);
//        productDto.setRam(ram);
//        Series series = new Series();
//        series.setIdSeries(1L);
//        productDto.setSeries(series);
//        Type type = new Type();
//        type.setIdType(1L);
//        productDto.setType(type);
//        ImageDto imageDto = new ImageDto();
//        imageDto.setName("image");
//        imageDto.setStatusImage(true);
//        productDto.setImageDto(imageDto);
//        this.mockMvc.perform(
//                        MockMvcRequestBuilders.post("/api/admin/product/add")
//                                .content(this.objectMapper.writeValueAsString(productDto))
//                                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * author: DaoPTA
//     * workday: 13/10/2023
//     * this function use to test the validation of field selfie more specific is null
//     *
//     * @throws Exception
//     */
//    @Test
//    public void createProduct_selfie_2 () throws Exception {
//        ProductDto productDto = new ProductDto();
//        productDto.setNameProduct("Phan Tá Anh Đào");
//        productDto.setBatteryProduct("100%");
//        productDto.setCameraProduct("12mp, 12mp, 12mp");
//        productDto.setPriceProduct(11000000.0);
//        productDto.setQuantityProduct(0L);
//        productDto.setScreenProduct("64 in");
////        productDto.setSelfieProduct("15mp");
//        productDto.setWeightProduct("200.5");
//        productDto.setStatusBusiness(true);
//        productDto.setDescriptionProduct("Ngon bổ rẻ");
//        Capacity capacity = new Capacity();
//        capacity.setIdCapacity(1L);
//        productDto.setCapacity(capacity);
//        Color color = new Color();
//        color.setIdColor(1L);
//        productDto.setColor(color);
//        Cpu cpu = new Cpu();
//        cpu.setIdCpu(1L);
//        productDto.setCpu(cpu);
//        Ram ram = new Ram();
//        ram.setIdRam(1L);
//        productDto.setRam(ram);
//        Series series = new Series();
//        series.setIdSeries(1L);
//        productDto.setSeries(series);
//        Type type = new Type();
//        type.setIdType(1L);
//        productDto.setType(type);
//        ImageDto imageDto = new ImageDto();
//        imageDto.setName("image");
//        imageDto.setStatusImage(true);
//        productDto.setImageDto(imageDto);
//        this.mockMvc.perform(
//                        MockMvcRequestBuilders.post("/api/admin/product/add")
//                                .content(this.objectMapper.writeValueAsString(productDto))
//                                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * author: DaoPTA
//     * workday: 13/10/2023
//     * This function is used to validate specific field selfie rather than WRONG FORMAT
//     *
//     * @throws Exception
//     */
//    @Test
//    public void createProduct_selfie_3_4 () throws Exception {
//        ProductDto productDto = new ProductDto();
//        productDto.setNameProduct("Phan Tá Anh Đào");
//        productDto.setBatteryProduct("100%");
//        productDto.setCameraProduct("12mp, 12mp, 12mp");
//        productDto.setPriceProduct(11000000.0);
//        productDto.setQuantityProduct(0L);
//        productDto.setScreenProduct("64 in");
//        productDto.setSelfieProduct("@#$%^HGHKY$%^R%TYIHI*((^438921490");
//        productDto.setWeightProduct("200.5");
//        productDto.setStatusBusiness(true);
//        productDto.setDescriptionProduct("Ngon bổ rẻ");
//        Capacity capacity = new Capacity();
//        capacity.setIdCapacity(1L);
//        productDto.setCapacity(capacity);
//        Color color = new Color();
//        color.setIdColor(1L);
//        productDto.setColor(color);
//        Cpu cpu = new Cpu();
//        cpu.setIdCpu(1L);
//        productDto.setCpu(cpu);
//        Ram ram = new Ram();
//        ram.setIdRam(1L);
//        productDto.setRam(ram);
//        Series series = new Series();
//        series.setIdSeries(1L);
//        productDto.setSeries(series);
//        Type type = new Type();
//        type.setIdType(1L);
//        productDto.setType(type);
//        ImageDto imageDto = new ImageDto();
//        imageDto.setName("image");
//        imageDto.setStatusImage(true);
//        productDto.setImageDto(imageDto);
//        this.mockMvc.perform(
//                        MockMvcRequestBuilders.post("/api/admin/product/add")
//                                .content(this.objectMapper.writeValueAsString(productDto))
//                                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * author: DaoPTA
//     * workday: 13/10/2023
//     * This function is used to check and confirm that a specific field selfie is not entered more than the number of characters
//     *
//     * @throws Exception
//     */
//    @Test
//    public void createProduct_selfie_5 () throws Exception {
//        ProductDto productDto = new ProductDto();
//        productDto.setNameProduct("Phan Tá Anh Đào");
//        productDto.setBatteryProduct("100%");
//        productDto.setCameraProduct("12mp, 12mp, 12mp");
//        productDto.setPriceProduct(11000000.0);
//        productDto.setQuantityProduct(0L);
//        productDto.setScreenProduct("64 in");
//        productDto.setSelfieProduct("15mpmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm" +
//                "mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm" +
//                "mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm" +
//                "mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm" +
//                "mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm");
//        productDto.setWeightProduct("200.5");
//        productDto.setStatusBusiness(true);
//        productDto.setDescriptionProduct("Ngon bổ rẻ");
//        Capacity capacity = new Capacity();
//        capacity.setIdCapacity(1L);
//        productDto.setCapacity(capacity);
//        Color color = new Color();
//        color.setIdColor(1L);
//        productDto.setColor(color);
//        Cpu cpu = new Cpu();
//        cpu.setIdCpu(1L);
//        productDto.setCpu(cpu);
//        Ram ram = new Ram();
//        ram.setIdRam(1L);
//        productDto.setRam(ram);
//        Series series = new Series();
//        series.setIdSeries(1L);
//        productDto.setSeries(series);
//        Type type = new Type();
//        type.setIdType(1L);
//        productDto.setType(type);
//        ImageDto imageDto = new ImageDto();
//        imageDto.setName("image");
//        imageDto.setStatusImage(true);
//        productDto.setImageDto(imageDto);
//        this.mockMvc.perform(
//                        MockMvcRequestBuilders.post("/api/admin/product/add")
//                                .content(this.objectMapper.writeValueAsString(productDto))
//                                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * author: DaoPTA
//     * workday: 13/10/2023
//     * this function use to test the validation of field weight more specific is null
//     *
//     * @throws Exception
//     */
//    @Test
//    public void createProduct_weight_2 () throws Exception {
//        ProductDto productDto = new ProductDto();
//        productDto.setNameProduct("Phan Tá Anh Đào");
//        productDto.setBatteryProduct("100%");
//        productDto.setCameraProduct("12mp, 12mp, 12mp");
//        productDto.setPriceProduct(11000000.0);
//        productDto.setQuantityProduct(0L);
//        productDto.setScreenProduct("64 in");
//        productDto.setSelfieProduct("15mp");
////        productDto.setWeightProduct(200.5D);
//        productDto.setStatusBusiness(true);
//        productDto.setDescriptionProduct("Ngon bổ rẻ");
//        Capacity capacity = new Capacity();
//        capacity.setIdCapacity(1L);
//        productDto.setCapacity(capacity);
//        Color color = new Color();
//        color.setIdColor(1L);
//        productDto.setColor(color);
//        Cpu cpu = new Cpu();
//        cpu.setIdCpu(1L);
//        productDto.setCpu(cpu);
//        Ram ram = new Ram();
//        ram.setIdRam(1L);
//        productDto.setRam(ram);
//        Series series = new Series();
//        series.setIdSeries(1L);
//        productDto.setSeries(series);
//        Type type = new Type();
//        type.setIdType(1L);
//        productDto.setType(type);
//        ImageDto imageDto = new ImageDto();
//        imageDto.setName("image");
//        imageDto.setStatusImage(true);
//        productDto.setImageDto(imageDto);
//        this.mockMvc.perform(
//                        MockMvcRequestBuilders.post("/api/admin/product/add")
//                                .content(this.objectMapper.writeValueAsString(productDto))
//                                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * author: DaoPTA
//     * workday: 13/10/2023
//     * This function is used to validate specific field weight rather than WRONG FORMAT
//     *
//     * @throws Exception
//     */
//    @Test
//    public void createProduct_weight_3_4 () throws Exception {
//        ProductDto productDto = new ProductDto();
//        productDto.setNameProduct("Phan Tá Anh Đào");
//        productDto.setBatteryProduct("100%");
//        productDto.setCameraProduct("12mp, 12mp, 12mp");
//        productDto.setPriceProduct(11000000.0);
//        productDto.setQuantityProduct(0L);
//        productDto.setScreenProduct("64 in");
//        productDto.setSelfieProduct("15mp");
//        productDto.setWeightProduct("c1ry3782b9r8fuc^%&*ey7ru8n2cru82yr");
//        productDto.setStatusBusiness(true);
//        productDto.setDescriptionProduct("Ngon bổ rẻ");
//        Capacity capacity = new Capacity();
//        capacity.setIdCapacity(1L);
//        productDto.setCapacity(capacity);
//        Color color = new Color();
//        color.setIdColor(1L);
//        productDto.setColor(color);
//        Cpu cpu = new Cpu();
//        cpu.setIdCpu(1L);
//        productDto.setCpu(cpu);
//        Ram ram = new Ram();
//        ram.setIdRam(1L);
//        productDto.setRam(ram);
//        Series series = new Series();
//        series.setIdSeries(1L);
//        productDto.setSeries(series);
//        Type type = new Type();
//        type.setIdType(1L);
//        productDto.setType(type);
//        ImageDto imageDto = new ImageDto();
//        imageDto.setName("image");
//        imageDto.setStatusImage(true);
//        productDto.setImageDto(imageDto);
//        this.mockMvc.perform(
//                        MockMvcRequestBuilders.post("/api/admin/product/add")
//                                .content(this.objectMapper.writeValueAsString(productDto))
//                                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * author: DaoPTA
//     * workday: 13/10/2023
//     * This function is used to check and confirm that a specific field selfie is not entered more than the number of characters
//     *
//     * @throws Exception
//     */
//    @Test
//    public void createProduct_weight_5 () throws Exception {
//        ProductDto productDto = new ProductDto();
//        productDto.setNameProduct("Phan Tá Anh Đào");
//        productDto.setBatteryProduct("100%");
//        productDto.setCameraProduct("12mp, 12mp, 12mp");
//        productDto.setPriceProduct(11000000.0);
//        productDto.setQuantityProduct(0L);
//        productDto.setScreenProduct("64 in");
//        productDto.setSelfieProduct("15mp");
//        productDto.setWeightProduct("2000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000.5");
//        productDto.setStatusBusiness(true);
//        productDto.setDescriptionProduct("Ngon bổ rẻ");
//        Capacity capacity = new Capacity();
//        capacity.setIdCapacity(1L);
//        productDto.setCapacity(capacity);
//        Color color = new Color();
//        color.setIdColor(1L);
//        productDto.setColor(color);
//        Cpu cpu = new Cpu();
//        cpu.setIdCpu(1L);
//        productDto.setCpu(cpu);
//        Ram ram = new Ram();
//        ram.setIdRam(1L);
//        productDto.setRam(ram);
//        Series series = new Series();
//        series.setIdSeries(1L);
//        productDto.setSeries(series);
//        Type type = new Type();
//        type.setIdType(1L);
//        productDto.setType(type);
//        ImageDto imageDto = new ImageDto();
//        imageDto.setName("image");
//        imageDto.setStatusImage(true);
//        productDto.setImageDto(imageDto);
//        this.mockMvc.perform(
//                        MockMvcRequestBuilders.post("/api/admin/product/add")
//                                .content(this.objectMapper.writeValueAsString(productDto))
//                                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * author: DaoPTA
//     * workday: 13/10/2023
//     * This function is used to check and confirm that a specific field description is not entered more than the number of characters
//     *
//     * @throws Exception
//     */
//    @Test
//    public void createProduct_description_5 () throws Exception {
//        ProductDto productDto = new ProductDto();
//        productDto.setNameProduct("Phan Tá Anh Đào");
//        productDto.setBatteryProduct("100%");
//        productDto.setCameraProduct("12mp, 12mp, 12mp");
//        productDto.setPriceProduct(11000000.0);
//        productDto.setQuantityProduct(0L);
//        productDto.setScreenProduct("64 in");
//        productDto.setSelfieProduct("15m");
//        productDto.setWeightProduct("200.5");
//        productDto.setStatusBusiness(true);
//        productDto.setDescriptionProduct("Đặc điểm nổi bật của iPhone 15 Pro\n" +
//                "• Chế tác bộ bộ khung viền từ chất liệu Titanium cứng cáp\n" +
//                "• Sở hữu cấu hình mạnh mẽ bậc nhất trong ngành điện thoại\n" +
//                "• Camera hỗ trợ chụp zoom quang hoặc 3x\n" +
//                "• Hỗ trợ quay video chất lượng 4K cùng khả năng chống rung đỉnh cao\n" +
//                "• Thay thế gạt rung bằng Action Button mới lạ và tiện lợi\n" +
//                "• Chuyển đổi cổng sạc USB-C, truyền tải dữ liệu tốc độ cao\n" +
//                "\n" +
//                "Lý do chọn mua iPhone 15 Pro tại Thế Giới Di Động\n" +
//                "iPhone 15 Pro là một trong những chiếc điện thoại thông minh được mong đợi nhất năm 2023. Với nhiều tính năng mới và cải tiến, iPhone 15 Pro chắc chắn sẽ là một lựa chọn tuyệt vời cho những người dùng đang tìm kiếm một chiếc điện thoại cao cấp.\n" +
//                "\n" +
//                "• Chất lượng sản phẩm: Thế Giới Di Động cam kết cung cấp sản phẩm iPhone 15 Pro chính hãng và đảm bảo chất lượng. Điều này giúp bạn yên tâm về xuất xứ sản phẩm và có thể tận hưởng trải nghiệm sử dụng tốt nhất.\n" +
//                "\n" +
//                "• Ưu đãi và khuyến mãi: Thế Giới Di Động thường xuyên có các chương trình khuyến mãi, giảm giá và tặng quà kèm, giúp bạn tiết kiệm được một khoản tiền khi mua iPhone 15 Pro.\n" +
//                "\n" +
//                "• Hệ thống cửa hàng rộng rãi: Thế Giới Di Động có mạng lưới cửa hàng rộng rãi trên toàn quốc, giúp bạn dễ dàng tìm được một cửa hàng gần nhà để mua sắm. Bạn cũng có thể trực tiếp kiểm tra sản phẩm và nhận sự hỗ trợ từ nhân viên tại cửa hàng.\n" +
//                "\n" +
//                "• Dịch vụ hậu mãi tốt: Thế Giới Di Động cung cấp dịch vụ hậu mãi chuyên nghiệp, bao gồm bảo hành, sửa chữa và hỗ trợ kỹ thuật. Điều này giúp bạn yên tâm về việc sử dụng iPhone 15 Pro trong thời gian dài.\n" +
//                "\n" +
//                "• Hệ thống trả góp linh hoạt: Thế Giới Di Động cung cấp các lựa chọn trả góp phù hợp với ngân sách của bạn, giúp bạn mua được sản phẩm mong muốn mà không cần thanh toán toàn bộ số tiền một lúc.\n" +
//                "\n" +
//                "• Uy tín và kinh nghiệm: Với hơn 15 năm hoạt động trên thị trường, Thế Giới Di Động đã xây dựng được một uy tín mạnh mẽ trong ngành công nghiệp điện thoại di động. Điều này giúp bạn yên tâm về việc mua sắm tại Thế Giới Di Động.\n" +
//                "\n" +
//                "• Dịch vụ mua sắm trực tuyến: Ngoài các hệ thống cửa hàng siêu thị, Thế Giới Di Động còn cung cấp dịch vụ mua sắm trực tuyến, giúp bạn mua hàng mọi lúc, mọi nơi và dễ dàng so sánh giá cả.\n" +
//                "\n" +
//                "So sánh iPhone 15 Pro và các sản phẩm khác trong dòng sản phẩm iPhone 15?\n" +
//                "Tiêu chí\n" +
//                "\n" +
//                "iPhone 15 Pro\n" +
//                "\n" +
//                "iPhone 15 Pro Max\n" +
//                "\n" +
//                "iPhone 15 Plus\n" +
//                "\n" +
//                "iPhone 15 128GB\n" +
//                "\n" +
//                "Màn hình\n" +
//                "\n" +
//                "   • Kích thước: 6.1 inch\n" +
//                "\n" +
//                "   • Super Retina XDR OLED\n" +
//                "\n" +
//                "   • Công nghệ ProMotion\n" +
//                "\n" +
//                "   • Dynamic Island\n" +
//                "\n" +
//                "   • 2556 x 1179 pixels\n" +
//                "\n" +
//                "   • Kích thước: 6.7 inch\n" +
//                "\n" +
//                "   • Super Retina XDR OLED\n" +
//                "\n" +
//                "   • Công nghệ ProMotion\n" +
//                "\n" +
//                "   • Dynamic Island\n" +
//                "\n" +
//                "   • 2796 x 1290 pixels\n" +
//                "\n" +
//                "   • Kích thước: 6.7 inch\n" +
//                "\n" +
//                "   • Super Retina XDR OLED\n" +
//                "\n" +
//                "   • Dynamic Island\n" +
//                "\n" +
//                "   • 2796 x 1290 pixels\n" +
//                "\n" +
//                "   • Kích thước: 6.1 inch\n" +
//                "\n" +
//                "   • Super Retina XDR OLED\n" +
//                "\n" +
//                "   • Dynamic Island\n" +
//                "\n" +
//                "   • 2556 x 1179 pixels\n" +
//                "\n" +
//                "Kích thước và khối lượng\n" +
//                "\n" +
//                "   • 146.6 mm x 70.6 mm x 8.25 mm\n" +
//                "\n" +
//                "   • 187 gram\n" +
//                "\n" +
//                "   • 159.9 mm x 76.7 mm x 8.25 mm\n" +
//                "\n" +
//                "   • 221 gram\n" +
//                "\n" +
//                "   • 160.9 mm x 77.8 mm x 7.8 mm\n" +
//                "\n" +
//                "   • 201 gram\n" +
//                "\n" +
//                "   • 147.6 mm x 71.6 mm x 7.8 mm\n" +
//                "\n" +
//                "   • 171 gram\n" +
//                "\n" +
//                "Khung viền\n" +
//                "\n" +
//                "Titanium\n" +
//                "\n" +
//                "Titanium\n" +
//                "\n" +
//                "Nhôm\n" +
//                "\n" +
//                "Nhôm\n" +
//                "\n" +
//                "Chip\n" +
//                "\n" +
//                "Apple A17 Pro\n" +
//                "\n" +
//                "Apple A17 Pro\n" +
//                "\n" +
//                "Apple A16 Bionic\n" +
//                "\n" +
//                "Apple A16 Bionic\n" +
//                "\n" +
//                "Dung lượng\n" +
//                "\n" +
//                "   • 128GB\n" +
//                "\n" +
//                "   • 256GB\n" +
//                "\n" +
//                "   • 512GB\n" +
//                "\n" +
//                "   • 1TB\n" +
//                "\n" +
//                "   • 256GB\n" +
//                "\n" +
//                "   • 512GB\n" +
//                "\n" +
//                "   • 1TB\n" +
//                "\n" +
//                "   • 128GB\n" +
//                "\n" +
//                "   • 256GB\n" +
//                "\n" +
//                "   • 512GB\n" +
//                "\n" +
//                "   • 128GB\n" +
//                "\n" +
//                "   • 256GB\n" +
//                "\n" +
//                "   • 512GB\n" +
//                "\n" +
//                "Camera\n" +
//                "\n" +
//                "   • Camera trước: 12MP, f/1.9\n" +
//                "\n" +
//                "   • Camera chính: 48MP, f/1.78\n" +
//                "\n" +
//                "   • Camera góc siêu rộng: 12MP, f/2.2\n" +
//                "\n" +
//                "   • Camera Telephoto: 12MP, f/2.8, khả năng zoom 2x và 3x\n" +
//                "\n" +
//                "   • Camera trước: 12MP, f/1.9\n" +
//                "\n" +
//                "   • Camera chính: 48MP, f/1.78\n" +
//                "\n" +
//                "   • Camera góc siêu rộng: 12MP, f/2.2\n" +
//                "\n" +
//                "   • Camera Telephoto: 12MP, f/2.8, khả năng zoom 2x và 5x\n" +
//                "\n" +
//                "   • Camera trước: 12MP, f/1.9\n" +
//                "\n" +
//                "   • Camera chính: 48MP, f/1.6\n" +
//                "\n" +
//                "   • Camera góc siêu rộng: 12MP, f/2.4\n" +
//                "\n" +
//                "   • Camera trước: 12MP, f/1.9\n" +
//                "\n" +
//                "   • Camera chính: 48MP, f/1.6\n" +
//                "\n" +
//                "   • Camera góc siêu rộng: 12MP, f/2.4\n" +
//                "\n" +
//                "Nút tác vụ\n" +
//                "\n" +
//                "Có\n" +
//                "\n" +
//                "Có\n" +
//                "\n" +
//                "Không\n" +
//                "\n" +
//                "Không\n" +
//                "\n" +
//                "Thời lượng pin\n" +
//                "\n" +
//                "   • Nghe nhạc: 75 tiếng\n" +
//                "\n" +
//                "   • Xem video: 23 tiếng\n" +
//                "\n" +
//                "   • Xem video (trực tuyến): 20 tiếng\n" +
//                "\n" +
//                "   • Nghe nhạc: 95 tiếng\n" +
//                "\n" +
//                "   • Xem video: 29 tiếng\n" +
//                "\n" +
//                "   • Xem video (trực tuyến): 25 tiếng\n" +
//                "\n" +
//                "   • Nghe nhạc: 100 tiếng\n" +
//                "\n" +
//                "   • Xem video: 26 tiếng\n" +
//                "\n" +
//                "   • Xem video (trực tuyến): 20 tiếng\n" +
//                "\n" +
//                "   • Nghe nhạc: 80 tiếng\n" +
//                "\n" +
//                "   • Xem video: 20 tiếng\n" +
//                "\n" +
//                "   • Xem video (trực tuyến): 16 tiếng\n" +
//                "\n" +
//                "Cảm biến\n" +
//                "\n" +
//                "Cảm biến tiệm cận\n" +
//                "\n" +
//                "Cảm biến tiệm cận\n" +
//                "\n" +
//                "Cảm biến tiệm cận\n" +
//                "\n" +
//                "Cảm biến tiệm cận\n" +
//                "\n" +
//                "Cổng kết nối\n" +
//                "\n" +
//                "USB-C hỗ trợ USB 3\n" +
//                "\n" +
//                "USB-C hỗ trợ USB 3\n" +
//                "\n" +
//                "USB-C hỗ trợ USB 2\n" +
//                "\n" +
//                "USB-C hỗ trợ USB 2\n" +
//                "\n" +
//                " \n" +
//                "Bảng so sánh thông số phiên bản iPhone 15 Pro và iPhone 14 Pro\n" +
//                "Dưới đây sẽ là bảng tổng hợp thông số kỹ thuật giữa hai thế hệ điện thoại iPhone:\n" +
//                "\n" +
//                "Tiêu chí\n" +
//                "\n" +
//                "iPhone 15 Pro\n" +
//                "\n" +
//                "iPhone 14 Pro\n" +
//                "\n" +
//                "Màn hình\n" +
//                "\n" +
//                " \n" +
//                "\n" +
//                "   • Màn hình Super Retina XDR\n" +
//                "\n" +
//                "   • Màn hình toàn phần OLED 6,1 inch\n" +
//                "\n" +
//                "   • Độ phân giải 2556 x 1179 pixels\n" +
//                "\n" +
//                "   • Với mật độ điểm ảnh 460 ppi\n" +
//                "\n" +
//                "   • Màn hình có dải màu rộng (P3)\n" +
//                "\n" +
//                "   • Độ sáng cao nhất 2000 nit\n" +
//                "\n" +
//                "   • Dynamic Island\n" +
//                "\n" +
//                "   • Công nghệ ProMotion với tốc độ làm mới thích ứng lên đến 120Hz\n" +
//                "\n" +
//                "   • Màn hình Luôn Bật\n" +
//                "\n" +
//                " \n" +
//                "\n" +
//                "   • Màn hình Super Retina XDR\n" +
//                "\n" +
//                "   • Màn hình toàn phần OLED 6,1 inch\n" +
//                "\n" +
//                "   • Độ phân giải 2556 x 1179 pixels\n" +
//                "\n" +
//                "   • Với mật độ điểm ảnh 460 ppi\n" +
//                "\n" +
//                "   • Màn hình có dải màu rộng (P3)\n" +
//                "\n" +
//                "   • Độ sáng cao nhất 2000 nit\n" +
//                "\n" +
//                "   • Dynamic Island\n" +
//                "\n" +
//                "   • Công nghệ ProMotion với tốc độ làm mới thích ứng lên đến 120Hz\n" +
//                "\n" +
//                "   • Màn hình Luôn Bật\n" +
//                "\n" +
//                "Kích thước và khối lượng\n" +
//                "\n" +
//                " \n" +
//                "\n" +
//                "   • 146.6 x 70.6 x 8.25 mm\n" +
//                "\n" +
//                "   • 187 g\n" +
//                "\n" +
//                " \n" +
//                "\n" +
//                "   • 147.5 x 71.5 x 7.85 mm\n" +
//                "\n" +
//                "   • 206 g\n" +
//                "\n" +
//                "Khung viền\n" +
//                "\n" +
//                "Titan với mặt sau bằng kính nhám\n" +
//                "\n" +
//                "Thép không gỉ với mặt sau bằng kính nhám\n" +
//                "\n" +
//                "Chip\n" +
//                "\n" +
//                "A17 Pro\n" +
//                "\n" +
//                "A16 Bionic\n" +
//                "\n" +
//                "RAM\n" +
//                "\n" +
//                "8 GB\t6 GB\n" +
//                "Bộ nhớ trong\n" +
//                "\n" +
//                "128 GB, 256 GB, 512 GB, 1 TB\t128 GB, 256 GB, 512 GB, 1 TB\n" +
//                "Hệ điều hành\n" +
//                "\n" +
//                "iOS 17\tiOS 16\n" +
//                "Camera\n" +
//                "\n" +
//                "   • Camera trước TrueDepth 12 MP\n" +
//                "\n" +
//                "   • Camera sau chính 48 MP. Ultra Wide 12 MP, Telephoto 12 MP\n" +
//                "\n" +
//                "   • Camera trước TrueDepth 12 MP\n" +
//                "\n" +
//                "   • Camera sau chính 48 MP. Ultra Wide 12 MP, Telephoto 12 MP\n" +
//                "\n" +
//                "Nút tác vụ\n" +
//                "\n" +
//                "Action Button\n" +
//                "\n" +
//                "Nút chuyển đổi Chuông/Im Lặng\n" +
//                "\n" +
//                "Thời lượng pin\n" +
//                "\n" +
//                " \n" +
//                "\n" +
//                "   • Nghe nhạc: 75 tiếng\n" +
//                "\n" +
//                "   • Xem video: 23 tiếng\n" +
//                "\n" +
//                "   • Xem video (trực tuyến): 20 tiếng\n" +
//                "\n" +
//                " \n" +
//                "\n" +
//                "   • Nghe nhạc: 75 tiếng\n" +
//                "\n" +
//                "   • Xem video: 23 tiếng\n" +
//                "\n" +
//                "   • Xem video (trực tuyến): 20 tiếng\n" +
//                "\n" +
//                "Cảm biến\n" +
//                "\n" +
//                " \n" +
//                "\n" +
//                "   • LiDAR Scanner\n" +
//                "\n" +
//                "   • Con quay hồi chuyển\n" +
//                "\n" +
//                "   • Gia tốc kế lực G\n" +
//                "\n" +
//                "   • Cảm biến tiệm cận   \n" +
//                "\n" +
//                "   • Hai cảm biến ánh sáng môi trường\n" +
//                "\n" +
//                "   • Áp kế\n" +
//                "\n" +
//                " \n" +
//                "\n" +
//                "   • LiDAR Scanner\n" +
//                "\n" +
//                "   • Con quay hồi chuyển\n" +
//                "\n" +
//                "   • Gia tốc kế lực G\n" +
//                "\n" +
//                "   • Cảm biến tiệm cận\n" +
//                "\n" +
//                "   • Hai cảm biến ánh sáng môi trường\n" +
//                "\n" +
//                "   • Áp kế\n" +
//                "\n" +
//                "Cổng kết nối\n" +
//                "\n" +
//                "USB-C hỗ trợ USB 3\n" +
//                "\n" +
//                "Lightning hỗ trợ USB 2\n" +
//                "\n" +
//                "Công suất sạc\n" +
//                "\n" +
//                "20 W\t20 W\n" +
//                "Thời gian sạc\n" +
//                "\n" +
//                "Sạc tới 50% trong 3 phút\tSạc tới 50% trong 30 phút\n" +
//                "Màu sắc\n" +
//                "\n" +
//                "Titan tự nhiên (Natural Titanium), Titan trắng (White Titanium), Titan đen (Black Titanium), Titan xanh (Blue Titanium)\tVàng, Đen, Tím, Bạc\n" +
//                "Kết nối\n" +
//                "\n" +
//                "Wi‑Fi 6E, 5G\tWi‑Fi 6, 5G\n" +
//                " \n" +
//                "Video giới thiệu điện thoại iPhone 15 Pro và iPhone 15 Pro Max\n" +
//                "\n" +
//                "Cuối cùng thì iPhone 15 Pro cũng đã chính thức ra mắt vào tháng 09/2023 sau nhiều đồn đoán trong thời gian qua. Ở lần ra mắt này Apple mang đến một chiếc máy với vẻ ngoài cứng cáp đẹp mắt, một khả năng quay video chuyên nghiệp đi cùng bộ cấu hình cực khủng - hàng đầu phân khúc điện thoại hiện nay.\n" +
//                "Diện mạo cứng cáp sang trọng\n" +
//                "Về thiết kế của iPhone 15 Pro, Apple vẫn sẽ tiếp tục lưu giữ vẻ ngoài vuông vức đặc trưng như những thế hệ trước đó. Mặt lưng cùng bộ khung được làm phẳng giúp tạo nên một sự hòa quyện tuyệt vời giữa hai phần, tạo ra một chiếc điện thoại thanh lịch và hiện đại đúng nghĩa.\n" +
//                "\n" +
//                "Thiết kế điện thoại - iPhone 15 Pro\n" +
//                "\n" +
//                "Nguồn: Ảnh được trích từ Apple.com\n" +
//                "\n" +
//                "Mặt lưng bằng kính cường lực cao cấp làm cho thiết bị trở nên sang trọng và bền bỉ. Nó không chỉ tạo ra vẻ đẹp mà còn đảm bảo tính bền và độ ổn định trong quá trình sử dụng hằng ngày.\n" +
//                "\n" +
//                "Khác với những thế hệ trước đây, thay vì sử dụng chất liệu nhôm thì năm nay Apple sử dụng Titanium để chế tạo bộ khung dành cho máy. Đây thực sự là một điểm gây ấn tượng bởi nó giúp cho khung máy cứng cáp hơn, bền bỉ hơn cũng như mang lại cảm giác sang trọng và đẳng cấp hơn bao giờ hết.\n" +
//                "\n" +
//                "Bộ khung chất liệu mới - iPhone 15 Pro\n" +
//                "\n" +
//                "Nguồn: Ảnh được trích từ Apple.com\n" +
//                "\n" +
//                "Ở iPhone 15 Pro, có một số điểm thay đổi liên quan đến thiết kế khung bên của sản phẩm. Bằng cách tạo ra một đường viền nhẹ ở những vị trí giao nhau giữa khung và mặt lưng, việc cầm nắm sản phẩm giờ đây cũng trở nên tốt hơn giúp mang lại trải nghiệm thoải mái khi bạn sử dụng điện thoại trong thời gian dài.\n" +
//                "\n" +
//                "Hình notch dạng viên thuốc tiện dụng của iPhone 15 Pro được tối ưu hóa để tạo ra không gian sử dụng lớn hơn và màn hình hiển thị mượt mà. Kiểu hình notch này được tăng thêm phần thú vị nhờ Apple bổ sung thêm nhiều chế độ hiển thị mới lạ thông qua tính năng Dynamic Island.\n" +
//                "\n" +
//                "Thiết kế điện thoại - iPhone 15 Pro\n" +
//                "\n" +
//                "Nguồn: Ảnh được trích từ Apple.com\n" +
//                "\n" +
//                "Với viền màn hình siêu mỏng, iPhone 15 Pro thực sự đưa trải nghiệm xem và sử dụng vào một tầm cao mới thú vị hơn, đã mắt hơn, cảm giác khi xem cũng trở nên cực kỳ dễ chịu và thoải mái mà không hề gặp phải tình trạng bí bách gây khó chịu.\n" +
//                "\n" +
//                "Sử dụng Action button mới\n" +
//                "Thay vì sử dụng phím gạt như những phiên bản trước, iPhone 15 Pro được nâng cấp phần này trở thành nút bấm và vẫn giữ nguyên vị trí như cũ. Cách làm này cho phép bạn có thể dễ dàng điều chỉnh chế độ bật tắt chuông của điện thoại iPhone bằng một tay mà không hề gặp phải bất kỳ khó khăn. Ngoài ra, máy còn cho phép bạn có thể cài thêm một vài tiện ích mở ứng dụng nhanh thông qua phím chức năng này.\n" +
//                "\n" +
//                "Thiết kế điện thoại - iPhone 15 Pro\n" +
//                "\n" +
//                "Sử dụng cổng kết nối mới\n" +
//                "Apple quyết định thay đổi cổng kết nối từ Lightning sang Type-C dành cho iPhone 15 Pro, nhằm đáp ứng nhu cầu ngày càng cao về tốc độ và tích hợp đa dụng. Việc này giúp người dùng truyền dữ liệu và sạc pin nhanh chóng hơn bao giờ hết.\n" +
//                "\n" +
//                "Hỗ trợ cổng kết nối Type C - iPhone 15 Pro\n" +
//                "\n" +
//                "Nguồn: Ảnh được trích từ Apple.com\n" +
//                "\n" +
//                "Cổng Type-C là tiêu chuẩn kết nối phổ biến, được sử dụng trên nhiều thiết bị khác của Apple trong những năm gần đây bao gồm Mac, iPad, Apple Watch và AirPods*. Điều này giúp người dùng có thể sử dụng cùng một cáp sạc cho tất cả các thiết bị giúp tiết kiệm thời gian và không gian khi sử dụng các sản phẩm trong hệ sinh thái của Apple.\n" +
//                "\n" +
//                "*Áp dụng đối với những phiên bản thế hệ mới có hỗ trợ chuẩn Type C\n" +
//                "\n" +
//                "Trang bị công nghệ eSIM\n" +
//                "iPhone 15 Pro hỗ trợ công nghệ eSIM cho phép người dùng lưu trữ tối đa 8 eSIM trên điện thoại. Số lượng eSIM có thể hoạt động đồng thời phụ thuộc vào thị trường và khu vực, nhưng thường chỉ giới hạn ở 1 hoặc 2 ( 1 đối với thị trường Việt Nam).\n" +
//                "\n" +
//                "Khả năng kích hoạt eSIM trực tuyến giúp người dùng dễ dàng chuyển đổi giữa các nhà mạng hoặc sử dụng nhiều số điện thoại trên cùng một chiếc iPhone. Thay vì phải đến cửa hàng của nhà mạng, người dùng có thể kích hoạt eSIM thông qua trang web hoặc ứng dụng của nhà mạng.\n" +
//                "\n" +
//                "Sở hữu bộ camera chuẩn chuyên gia\n" +
//                "iPhone 15 Pro được trang bị cụm 3 camera sau với camera chính 48 MP, camera góc siêu rộng 12 MP và camera tele 12 MP. Camera chính 48 MP cho phép người dùng có thể chụp ảnh sắc nét nhằm giúp thu lại vẻ đẹp từ mọi khung cảnh một cách trọn vẹn.\n" +
//                "\n" +
//                "Camera điện thoại - iPhone 15 Pro\n" +
//                "\n" +
//                "Nguồn: Ảnh được trích từ Apple.com\n" +
//                "\n" +
//                "Với cảm biến lớn, camera chính của iPhone 15 Pro có thể thu được nhiều ánh sáng hơn, giúp cho ảnh chụp trong điều kiện ánh sáng yếu có độ sáng cao hơn, ít nhiễu hơn và chi tiết hơn.\n" +
//                "\n" +
//                "Camera điện thoại - iPhone 15 Pro\n" +
//                "\n" +
//                "Nguồn: Ảnh được trích từ Apple.com\n" +
//                "\n" +
//                "Với camera tele 12 MP, người dùng hoàn toàn có thể chụp zoom quang học lên tới 3x (tương tự với tiêu cự 77 mm) cùng khả năng zoom kỹ thuật số tới 15X. Giờ đây người dùng không còn phải bận tâm đến việc chất lượng ảnh bị giảm đi quá nhiều hay quan ngại rằng liệu máy có thể zoom xa hay không, thực sự là những tính năng tiện ích và cần có trên một chiếc flagship.\n" +
//                "\n" +
//                "Camera điện thoại - iPhone 15 Pro\n" +
//                "\n" +
//                "Nguồn: Ảnh được trích từ Apple.com\n" +
//                "\n" +
//                "Camera trước trên iPhone 15 Pro thì được hỗ trợ độ phân giải 12 MP, cho phép chụp ảnh selfie và gọi video với chất lượng tốt hơn. Ngoài ra, camera trước cũng hỗ trợ quay video 4K ở tốc độ khung hình 60fps.\n" +
//                "\n" +
//                "Hỗ trợ quay phim sắc nét và mượt mà\n" +
//                "iPhone 15 Pro cũng được hỗ trợ quay video 2.8K ở tốc độ khung hình 60fps đối với chế độ hành động. Tính năng này giúp người dùng ghi lại những khoảnh khắc quan trọng với độ phân giải cao và đảm bảo được độ ổn định, kể cả khi vừa chạy vừa quay video thì kết quả cho ra cũng ít khi giật lag nhòe mờ.\n" +
//                "\n" +
//                "Quay video trên điện thoại - iPhone 15 Pro\n" +
//                "\n" +
//                "Nguồn: Ảnh được trích từ Apple.com\n" +
//                "\n" +
//                "Chế độ Cinematic trên iPhone 15 Pro cho phép người dùng quay video với hiệu ứng xóa phông tự nhiên. Chế độ này sử dụng công nghệ theo dõi đối tượng để tự động lấy nét vào chủ thể chính và làm mờ hậu cảnh. Điều này giúp video trông chuyên nghiệp hơn khi chủ thể hay nhân vật quan trọng trong đám đông được làm nổi bật.\n" +
//                "\n" +
//                "Trải nghiệm chụp ảnh chân dung chuẩn máy ảnh\n" +
//                "Trước đây, người dùng chỉ có thể chụp ảnh chân dung với tiêu cự cố định. Tuy nhiên, iPhone 15 Pro đã được trang bị camera tele mới, mang lại khả năng thu phóng quang học lên đến 3x. Điều này giúp người dùng có thể điều chỉnh tiêu cự một cách liền mạch và chính xác, từ đó tạo ra những bức ảnh chân dung với độ chi tiết cao và hiệu ứng xóa phông đẹp mắt.\n" +
//                "\n" +
//                "Ảnh thực tế từ điện thoại - iPhone 15 Pro\n" +
//                "\n" +
//                "Nguồn: Ảnh được trích từ Apple.com\n" +
//                "\n" +
//                "Một tính năng mới khác của chế độ chụp chân dung trên iPhone 15 Pro là khả năng chuyển đổi tiêu điểm sau khi chụp. Người dùng có thể dễ dàng điều chỉnh tiêu điểm bằng cách chạm trên màn hình. Điều này giúp người dùng có thể tạo ra những bức ảnh chân dung động và sáng tạo hơn.\n" +
//                "\n" +
//                "Lấy nét sau khi chụp trên điện thoại - iPhone 15 Pro\n" +
//                "\n" +
//                "Nguồn: Ảnh được trích từ Apple.com\n" +
//                "\n" +
//                "Chế độ chụp chân dung trên iPhone 15 Pro cũng được trang bị công cụ Photonic, mang lại một loạt cải tiến về chất lượng hình ảnh. Công cụ này giúp cải thiện độ chi tiết, sắc thái màu sắc, độ trễ màn trập và hiệu suất chụp ảnh trong điều kiện ánh sáng yếu.\n" +
//                "\n" +
//                "Nâng cao trải nghiệm hình ảnh với tấm nền OLED\n" +
//                "iPhone 15 Pro trang bị tấm nền OLED, một công nghệ hiển thị tiên tiến cho màu sắc sáng rực và độ tương phản vượt trội để giúp tạo ra hình ảnh sắc nét, chân thực và chuyển động mượt mà.\n" +
//                "\n" +
//                "Xem thêm: Màn hình OLED là gì? Có gì nổi bật? Thiết bị nào có màn hình OLED?\n" +
//                "\n" +
//                "Bên cạnh việc trang bị tấm nền cao cấp thì điện thoại còn có thêm nhiều công nghệ phụ như: HDR display, True Tone và dải màu rộng P3, cho phép nội dung được tái hiện một cách chân thực với màu sắc cho ra có độ chuẩn xác cao hơn, từ đó phục vụ cho việc chỉnh sửa nội dung đa phương tiện trở nên thuận tiện và dễ dàng hơn bao giờ hết.\n" +
//                "\n" +
//                "Với độ phân giải Super Retina XDR (1179 x 2556 Pixels), chiếc iPhone 15 series này cho phép bạn trải nghiệm hình ảnh với độ chi tiết cao cấp. Mọi pixel trên màn hình đều được điều chỉnh tối ưu để mang đến hình ảnh sắc nét, màu sắc chính xác và độ tương phản đỉnh cao.\n" +
//                "\n" +
//                "Màn hình điện thoại - iPhone 15 Pro\n" +
//                "\n" +
//                "Nguồn: Ảnh được trích từ Apple.com\n" +
//                "\n" +
//                "Kích thước lý tưởng của màn hình 6.1 inch cho phép bạn cầm nắm thiết bị một cách thoải mái và tiện lợi, đồng thời vẫn đảm bảo trải nghiệm xem video và chơi game đỉnh cao.\n" +
//                "\n" +
//                "Viền màn hình của iPhone 15 Pro được thiết kế mỏng hơn so với iPhone 14 Pro, mang lại trải nghiệm xem thoải mái và đắm chìm. Viền màn hình mỏng cũng góp phần tạo nên tổng thể thiết kế thanh thoát và tinh tế của máy, giúp iPhone 15 Pro trở thành một trong những chiếc điện thoại đẹp nhất trên thị trường hiện nay.\n" +
//                "\n" +
//                "Với độ sáng lên tới 2000 nits, màn hình iPhone 15 Pro cho phép bạn xem nội dung ngay cả trong điều kiện ánh sáng mạnh mẽ. Ngoài ra, iPhone 15 Pro vẫn sẽ tiếp tục hỗ trợ tính năng Always-On display nhằm giúp cho người dùng có thể xem thông tin nhanh hoặc cũng có thể làm cho điện thoại trở nên đẹp mắt và thú vị hơn khi đặt/để trên bàn làm việc.\n" +
//                "\n" +
//                "Trải nghiệm thú vị hơn với tính năng Dynamic Island\n" +
//                "Một trong những tính năng nổi bật của iPhone 15 Pro là Dynamic Island, một phần khuyết hình viên thuốc ở phía trên màn hình. Dynamic Island không chỉ chứa camera trước TrueDepth và các cảm biến, mà còn là một tính năng tương tác giúp người dùng dễ dàng nhận thông tin và thao tác với thiết bị.\n" +
//                "\n" +
//                "Hỗ trợ tính năng Dynamic Island - iPhone 15 Pro\n" +
//                "\n" +
//                "Nguồn: Ảnh được trích từ Apple.com\n" +
//                "\n" +
//                "Dynamic Island không chỉ là một phần khuyết chứa camera trước. Nó còn là một tính năng tương tác giúp bạn dễ dàng thao tác với thiết bị. Bạn có thể sử dụng Dynamic Island để điều khiển nhạc, trả lời cuộc gọi hoặc thực hiện các thao tác khác như xem chỉ dẫn đường, bộ đếm thời gian hay ghi âm,...\n" +
//                "\n" +
//                "Ngoài ra Apple còn mang đến tính năng mới đáng chú ý khác mang tên bong bóng nhân đôi. Tính năng này cho phép người dùng mở hai ứng dụng cùng lúc trên màn hình, mỗi ứng dụng sẽ hiển thị dưới dạng một bong bóng ngay trên phần hình notch.\n" +
//                "\n" +
//                "Bong bóng nhân đôi - iPhone 15 Pro\n" +
//                "\n" +
//                "Nguồn: Ảnh được trích từ Internet\n" +
//                "\n" +
//                "Ví dụ, bạn có thể trò chuyện với bạn bè trong khi đồng thời xem chỉ dẫn từ bản đồ hoặc bạn có thể theo dõi điểm số của đội trong khi giải trí từ một nội dung khác. Để mở rộng một trong những hoạt động này, bạn chỉ cần chạm vào nó là ứng dụng sẽ được mở ngay tức thì.\n" +
//                "\n" +
//                "Dẫn đầu về sức mạnh hiệu năng\n" +
//                "Động cơ đằng sau sự hoạt động của iPhone 15 Pro là vi xử lý Apple A17 Pro, một trong những vi xử lý mạnh mẽ và tiên tiến nhất trên thị trường tính tại thời điểm ra mắt điện thoại. Với hiệu năng tối ưu và hiệu suất đỉnh cao, nó biến chiếc điện thoại này thành một công cụ linh hoạt và mạnh mẽ, đáp ứng mọi yêu cầu của bạn.\n" +
//                "\n" +
//                "Theo như hãng có đề cập thì A17 Pro cho hiệu năng mạnh mẽ hơn 10% về phần CPU, 20% cho CPU và tăng gấp 2 lần đối với công cụ thần kinh (Neural Engine) giúp thực hiện gần 35 nghìn tỷ phép tính mỗi giây với 16 lõi (so với A16). Đây quả thực là những con số cực kỳ ấn tượng trên thị trường chipset hiện nay, vì thế điện thoại hoàn toàn có thể tự tin cân tất mọi tựa game hiện nay.\n" +
//                "\n" +
//                "Cấu hình điện thoại - iPhone 15 Pro\n" +
//                "\n" +
//                "Nguồn: Ảnh được trích từ Apple.com\n" +
//                "\n" +
//                "iPhone 15 Pro đảm bảo bạn có đủ khả năng để chạy mượt mà các ứng dụng và tác vụ đa nhiệm mà không gặp trở ngại. Khả năng quản lý dữ liệu và chuyển đổi giữa các ứng dụng một cách nhanh chóng là điều mà iPhone 15 Pro thực hiện một cách dễ dàng.\n" +
//                "\n" +
//                "iPhone 15 Pro chạy trên hệ điều hành iOS 17, phiên bản cập nhật mới nhất của Apple. iOS 17 mang đến cho bạn một giao diện người dùng thân thiện, đa dạng với các tính năng tối ưu hóa và tiện ích mở rộng. Nó cung cấp trải nghiệm người dùng mượt mà, bảo mật tối đa và khả năng tương tác đa phương tiện đỉnh cao.\n" +
//                "\n" +
//                "Xem thêm: iOS 17 chính thức: Khi nào ra mắt, có gì mới, hỗ trợ máy nào?\n" +
//                "\n" +
//                "Năng lượng đáp ứng đủ cho một ngày dài sử dụng\n" +
//                "Chiếc iPhone 15 Pro trang bị viên pin có thể cung cấp thời lượng xem video lên đến 23 giờ, một con số ấn tượng đảm bảo bạn có đủ năng lượng để sử dụng thiết bị trong một khoảng thời gian dài. Dung lượng lớn này cho phép bạn xem video, chơi game và sử dụng ứng dụng mà không cần lo lắng về việc sạc pin thường xuyên.\n" +
//                "\n" +
//                "Nổi bật hơn hết, Apple cho biết iPhone 15 Pro có thời lượng phát video tăng thêm 6 giờ so với iPhone 12 Pro (3687 mAh). Đây quả là một sự chênh lệch đáng kể, giúp người dùng có thể yên tâm sử dụng thiết bị cả ngày dài mà không cần lo lắng về việc hết pin.\n" +
//                "\n" +
//                "Khả năng sạc nhanh là một trong những tính năng quan trọng để giúp bạn tiết kiệm thời gian. iPhone 15 Pro hỗ trợ sạc 20 W, cho phép bạn nạp lại pin nhanh chóng. Bất kể bạn đang bận rộn trong cuộc họp, trên đường đi hay tại nhà, bạn có thể sạc pin một cách hiệu quả và nhanh chóng để sẵn sàng cho những nhiệm vụ tiếp theo.\n" +
//                "\n" +
//                "Theo trang hãng, iPhone 15 Pro có khả năng sạc lên đến 50% chỉ trong vòng 30 phút.\n" +
//                "\n" +
//                "Pin và sạc điện thoại - iPhone 15 Pro\n" +
//                "\n" +
//                "Nguồn: Ảnh được trích từ Apple.com\n" +
//                "\n" +
//                "Hỗ trợ hệ điều hành iOS 17 mới nhất 2023\n" +
//                "iPhone 15 Pro, sản phẩm mới nhất từ Apple đã chính thức xuất hiện với hệ điều hành di động iOS 17. Phiên bản iOS mới này mang đến những cải tiến đáng kể về hiệu năng, bảo mật và trải nghiệm người dùng.\n" +
//                "\n" +
//                "Áp Phích Liên Hệ: Tính Cá Nhân Hóa Tối Ưu\n" +
//                "\n" +
//                "Một trong những tính năng nổi bật của iOS 17 là Áp Phích Liên Hệ. Đây là một cách tuyệt vời để tạo ảnh đại diện tùy chỉnh cho danh bạ của bạn. Thay vì những ảnh đại diện tĩnh thường thấy, bạn có thể tạo Áp Phích Liên Hệ với hình ảnh, văn bản và thậm chí là các yếu tố đồ họa độc đáo khác nhau. Điều này mang lại sự đa dạng và sáng tạo cho danh bạ của bạn.\n" +
//                "\n" +
//                "Không chỉ giúp bạn thể hiện cá tính riêng của mình, Áp Phích Liên Hệ còn giúp bạn dễ dàng nhận biết các liên hệ quan trọng hơn trong danh bạ của mình. Bạn có thể thêm những thông tin nhận dạng dựa trên sở thích hoặc mối quan hệ của bạn với họ. Điều này giúp tạo ra danh bạ cá nhân hóa hơn, giúp bạn tìm kiếm và kết nối dễ dàng hơn bao giờ hết.\n" +
//                "\n" +
//                "NameDrop: Chia Sẻ Dễ Dàng, Nhanh Chóng\n" +
//                "\n" +
//                "Một tính năng tiện ích khác của iOS 17 là NameDrop. Với NameDrop, bạn có thể chia sẻ thông tin liên hệ một cách nhanh chóng giữa các thiết bị Apple* chỉ bằng cách chạm hai thiết bị vào nhau. Tính năng này sử dụng công nghệ AirDrop tiên tiến để truyền thông tin liên hệ qua Bluetooth và Wi-Fi.\n" +
//                "\n" +
//                "*Đối với các thiết bị hỗ trợ iOS 17\n" +
//                "\n" +
//                "Các tính năng trên iOS 17 - iPhone 15 Pro\n" +
//                "\n" +
//                "Nguồn: Ảnh được trích từ Apple.com\n" +
//                "\n" +
//                "NameDrop: Chia Sẻ Dễ Dàng, Nhanh Chóng\n" +
//                "\n" +
//                "Một tính năng tiện ích khác của iOS 17 là NameDrop. Với NameDrop, bạn có thể chia sẻ thông tin liên hệ một cách nhanh chóng giữa các thiết bị Apple chỉ bằng cách chạm hai thiết bị vào nhau. Tính năng này sử dụng công nghệ AirDrop tiên tiến để truyền thông tin liên hệ qua Bluetooth và Wi-Fi.\n" +
//                "\n" +
//                "Dễ dàng chia sẻ số điện thoại, địa chỉ email hoặc các thông tin khác với bạn bè hoặc đồng nghiệp không còn là vấn đề. NameDrop làm cho việc chuyển dữ liệu giữa các thiết bị trở nên dễ dàng và tiện lợi hơn bao giờ hết.\n" +
//                "\n" +
//                "Các tính năng - tiện ích trên iPhone 15 Pro\n" +
//                "Hỗ Trợ Bên Đường Qua Vệ Tinh\n" +
//                "\n" +
//                "Một trong những điểm nổi bật của iPhone 15 Pro là tính năng Hỗ Trợ Bên Đường Qua Vệ Tinh. Đây là một ứng dụng quan trọng cho sự an toàn và tiện ích của người dùng. Với tính năng này, bạn có khả năng gửi yêu cầu hỗ trợ bên đường đến nhà cung cấp dịch vụ hỗ trợ bên đường một cách nhanh chóng và hiệu quả khi gặp sự cố trên đường.\n" +
//                "\n" +
//                "Hỗ trợ vệ tinh - iPhone 15 Pro\n" +
//                "\n" +
//                "Nguồn: Ảnh được trích từ Apple.com\n" +
//                "\n" +
//                "Điều đặc biệt là yêu cầu hỗ trợ sẽ được gửi qua vệ tinh, ngay cả khi iPhone của bạn không có kết nối mạng di động hoặc Wi-Fi. Điều này đảm bảo rằng bạn luôn có sự hỗ trợ cần thiết, bất kể nơi bạn đang đặt chân.\n" +
//                "\n" +
//                "Phát Hiện Va Chạm\n" +
//                "\n" +
//                "An toàn luôn là ưu tiên hàng đầu khi bạn lái xe và iPhone 15 Pro mang lại cho bạn sự an tâm với tính năng Phát Hiện Va Chạm. Tính năng này sử dụng các cảm biến trên iPhone để phát hiện các vụ va chạm ô tô nghiêm trọng. Khi iPhone cảm nhận được va chạm, nó sẽ tự động kích hoạt một chuỗi biện pháp an toàn.\n" +
//                "\n" +
//                "Đầu tiên, chiếc điện thoại sẽ tự động gửi cuộc gọi đến dịch vụ khẩn cấp hoặc các số liên hệ khẩn cấp mà bạn đã đặt trước. Điều này giúp đảm bảo rằng bạn sẽ nhận được sự giúp đỡ ngay khi cần, ngay cả khi bạn không thể thực hiện cuộc gọi bằng tay.\n" +
//                "\n" +
//                "Ngoài ra, tính năng này cũng có khả năng ghi lại thông tin về vụ va chạm, bao gồm vị trí, thời điểm và các chi tiết quan trọng khác. Điều này có thể hữu ích cho việc điều tra và xác định nguyên nhân của sự cố sau này.\n" +
//                "\n" +
//                "Nâng cao trải nghiệm người dùng với hệ sinh thái từ Apple\n" +
//                "iPhone và Apple Watch: Hoạt Động Cùng Nhau Một Cách Liền Mạch\n" +
//                "\n" +
//                "Apple Watch không chỉ là một chiếc đồng hồ thông thường, mà còn là trợ thủ đắc lực của chiếc iPhone của bạn. Với khả năng trả lời cuộc gọi, kiểm tra tin nhắn và điều khiển các ứng dụng trên iPhone, Apple Watch giúp bạn tiết kiệm thời gian và tạo sự tiện lợi trong cuộc sống hàng ngày.\n" +
//                "\n" +
//                "Hơn nữa, nó còn theo dõi sức khỏe và thể dục của bạn, cung cấp thông tin quan trọng về thời tiết và giao thông, giúp bạn điều hướng một cách thông minh hơn.\n" +
//                "\n" +
//                "iPhone và Mac: Kết Nối Dễ Dàng Với Tính Năng Handoff\n" +
//                "\n" +
//                "Tính năng Handoff giữa iPhone và Mac là một ví dụ hoàn hảo về cách Apple làm cho việc chuyển đổi giữa các thiết bị trở nên dễ dàng hơn bao giờ hết. Bạn có thể bắt đầu một công việc trên iPhone, sau đó hoàn thành nó trên Mac mà không gặp bất kỳ sự gián đoạn nào. Việc này thật sự hữu ích khi bạn cần di chuyển giữa các thiết bị để làm việc hoặc giải trí.\n" +
//                "\n" +
//                "Hơn nữa, Apple đã tích hợp tính năng iCloud một cách hoàn hảo vào hệ thống. Điều này cho phép bạn đồng bộ hóa dữ liệu giữa iPhone và Mac một cách dễ dàng. Bạn có thể truy cập tài liệu, ảnh và ứng dụng của mình trên cả hai thiết bị mà không cần mất nhiều công sức để đồng bộ hóa chúng thủ công.\n" +
//                "\n" +
//                "Tương thích với nhiều thiết bị - iPhone 15 Pro\n" +
//                "\n" +
//                "Nguồn: Ảnh được trích từ Apple.com\n" +
//                "\n" +
//                "iPhone và AirPods: Âm Nhạc Mà Không Dây\n" +
//                "\n" +
//                "AirPods, dòng tai nghe không dây của Apple, đã thay đổi cách chúng ta trải nghiệm âm nhạc và trò chuyện. Chúng hoạt động hoàn hảo với iPhone và các thiết bị Apple khác. Với AirPods, bạn có thể dễ dàng nghe nhạc, podcast và trả lời cuộc gọi mà không cần lo lắng về dây cáp rườm rà. Hơn nữa, bạn có thể sử dụng AirPods để điều khiển Siri, giúp bạn tương tác với điện thoại của mình một cách tự nhiên hơn.\n" +
//                "\n" +
//                "Có nên mua iPhone 15 Pro?\n" +
//                "iPhone 15 Pro là một chiếc điện thoại thông minh có nhiều ưu điểm như thiết kế đẹp, hiệu năng mạnh mẽ, camera tuyệt vời và giá cả hợp lý. Nếu bạn đang tìm kiếm một chiếc điện thoại có thể đáp ứng tốt mọi nhu cầu sử dụng, thì iPhone 15 Pro là một lựa chọn đáng cân nhắc.\n" +
//                "\n" +
//                "Câu hỏi thường gặp trước khi mua iPhone 15 Pro\n" +
//                "iPhone 15 Pro có mấy màu?\n" +
//                "\n" +
//                "iPhone 15 Pro hiện đang được ra mắt với 4 màu sắc: Titan tự nhiên (Natural Titanium), Titan trắng (White Titanium), Titan đen (Black Titanium), Titan xanh (Blue Titanium). Các màu sắc này được thiết kế với tone màu huyền bí, lịch lãm giúp toát lên vẻ đẹp sang trọng và đẳng cấp.\n" +
//                "\n" +
//                "Camera của iPhone 15 Pro có chụp ảnh tốt không?\n" +
//                "\n" +
//                "Camera của iPhone 15 Pro có độ phân giải lên đến 48 MP, khẩu độ lớn và nhiều tính năng chụp ảnh tiên tiến. Điều này giúp iPhone 15 Pro có thể chụp ảnh sắc nét, sống động và chuyên nghiệp.\n" +
//                "\n" +
//                "iPhone 15 Pro chạy chip gì và mạnh mẽ ra sao?\n" +
//                "\n" +
//                "iPhone 15 Pro sử dụng con chip Apple A17 Pro, đây là con chip mạnh nhất hiện nay của Apple. A17 Pro mang đến hiệu năng xử lý vượt trội giúp iPhone 15 Pro có thể chạy mượt mà mọi ứng dụng và game.\n" +
//                "\n" +
//                "Giá bán iPhone 15 Pro tại Thế Giới Di Động\n" +
//                "Dưới đây là bảng tổng hợp giá bán iPhone 15 Pro cho từng phiên bản bộ nhớ cho thị trường Quốc Tế và Việt Nam:\n" +
//                "\n" +
//                "Các phiên bản iPhone 15 Pro\n" +
//                "\n" +
//                "Giá bán thị trường quốc tế\n" +
//                "\n" +
//                "Giá bán tại Thế Giới Di Động\n" +
//                "iPhone 15 Pro 128 GB\t999 USD\t28.990.000đ\n" +
//                "iPhone 15 Pro 256 GB\t1.099 USD\t31.990.000đ\n" +
//                "iPhone 15 Pro 512 GB\t1.299 USD\t37.990.000đ\n" +
//                "iPhone 15 Pro 1 TB\t1.499 USD\t43.990.000đ\n" +
//                " \n" +
//                "iPhone 15 Pro thực sự là một lựa chọn hết sức lý tưởng dành cho bất kỳ ai có đủ điều kiện kinh tế, vừa có kiểu dáng đẹp và vừa có cấu hình khủng bên trong, vì thế iPhone 15 Pro hoàn toàn có thể mang đến cho bạn những trải nghiệm mượt mà và ổn định trong khoảng thời gian cực kỳ dài lâu.");
//        Capacity capacity = new Capacity();
//        capacity.setIdCapacity(1L);
//        productDto.setCapacity(capacity);
//        Color color = new Color();
//        color.setIdColor(1L);
//        productDto.setColor(color);
//        Cpu cpu = new Cpu();
//        cpu.setIdCpu(1L);
//        productDto.setCpu(cpu);
//        Ram ram = new Ram();
//        ram.setIdRam(1L);
//        productDto.setRam(ram);
//        Series series = new Series();
//        series.setIdSeries(1L);
//        productDto.setSeries(series);
//        Type type = new Type();
//        type.setIdType(1L);
//        productDto.setType(type);
//        ImageDto imageDto = new ImageDto();
//        imageDto.setName("image");
//        imageDto.setStatusImage(true);
//        productDto.setImageDto(imageDto);
//        this.mockMvc.perform(
//                        MockMvcRequestBuilders.post("/api/admin/product/add")
//                                .content(this.objectMapper.writeValueAsString(productDto))
//                                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * author: DaoPTA
//     * workday: 13/10/2023
//     * this function use to test the validation of field capacity more specific is null
//     *
//     * @throws Exception
//     */
//    @Test
//    public void createProduct_capacity_2 () throws Exception {
//        ProductDto productDto = new ProductDto();
//        productDto.setNameProduct("Phan Tá Anh Đào");
//        productDto.setBatteryProduct("100%");
//        productDto.setCameraProduct("12mp, 12mp, 12mp");
//        productDto.setPriceProduct(11000000.0);
//        productDto.setQuantityProduct(0L);
//        productDto.setScreenProduct("64 in");
//        productDto.setSelfieProduct("15mp");
//        productDto.setWeightProduct("200.5");
//        productDto.setStatusBusiness(true);
//        productDto.setDescriptionProduct("Ngon bổ rẻ");
//        Capacity capacity = new Capacity();
//        capacity.setIdCapacity(Long.valueOf("328yqr73eyd78"));
//        productDto.setCapacity(capacity);
//        Color color = new Color();
//        color.setIdColor(1L);
//        productDto.setColor(color);
//        Cpu cpu = new Cpu();
//        cpu.setIdCpu(1L);
//        productDto.setCpu(cpu);
//        Ram ram = new Ram();
//        ram.setIdRam(1L);
//        productDto.setRam(ram);
//        Series series = new Series();
//        series.setIdSeries(1L);
//        productDto.setSeries(series);
//        Type type = new Type();
//        type.setIdType(1L);
//        productDto.setType(type);
//        ImageDto imageDto = new ImageDto();
//        imageDto.setName("image");
//        imageDto.setStatusImage(true);
//        productDto.setImageDto(imageDto);
//        this.mockMvc.perform(
//                        MockMvcRequestBuilders.post("/api/admin/product/add")
//                                .content(this.objectMapper.writeValueAsString(productDto))
//                                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * author: DaoPTA
//     * workday: 13/10/2023
//     * this function use to test the validation of field color more specific is null
//     *
//     * @throws Exception
//     */
//    @Test
//    public void createProduct_color_2 () throws Exception {
//        ProductDto productDto = new ProductDto();
//        productDto.setNameProduct("Phan Tá Anh Đào");
//        productDto.setBatteryProduct("100%");
//        productDto.setCameraProduct("12mp, 12mp, 12mp");
//        productDto.setPriceProduct(11000000.0);
//        productDto.setQuantityProduct(0L);
//        productDto.setScreenProduct("64 in");
//        productDto.setSelfieProduct("15mp");
//        productDto.setWeightProduct("200.5");
//        productDto.setStatusBusiness(true);
//        productDto.setDescriptionProduct("Ngon bổ rẻ");
//        Capacity capacity = new Capacity();
//        capacity.setIdCapacity(1L);
//        productDto.setCapacity(capacity);
//        Color color = new Color();
//        color.setIdColor(Long.valueOf("3842129ryui"));
//        productDto.setColor(color);
//        Cpu cpu = new Cpu();
//        cpu.setIdCpu(1L);
//        productDto.setCpu(cpu);
//        Ram ram = new Ram();
//        ram.setIdRam(1L);
//        productDto.setRam(ram);
//        Series series = new Series();
//        series.setIdSeries(1L);
//        productDto.setSeries(series);
//        Type type = new Type();
//        type.setIdType(1L);
//        productDto.setType(type);
//        ImageDto imageDto = new ImageDto();
//        imageDto.setName("image");
//        imageDto.setStatusImage(true);
//        productDto.setImageDto(imageDto);
//        this.mockMvc.perform(
//                        MockMvcRequestBuilders.post("/api/admin/product/add")
//                                .content(this.objectMapper.writeValueAsString(productDto))
//                                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * author: DaoPTA
//     * workday: 13/10/2023
//     * this function use to test the validation of field cpu more specific is null
//     *
//     * @throws Exception
//     */
//    @Test
//    public void createProduct_cpu_2 () throws Exception {
//        ProductDto productDto = new ProductDto();
//        productDto.setNameProduct("Phan Tá Anh Đào");
//        productDto.setBatteryProduct("100%");
//        productDto.setCameraProduct("12mp, 12mp, 12mp");
//        productDto.setPriceProduct(11000000.0);
//        productDto.setQuantityProduct(0L);
//        productDto.setScreenProduct("64 in");
//        productDto.setSelfieProduct("15mp");
//        productDto.setWeightProduct("200.5");
//        productDto.setStatusBusiness(true);
//        productDto.setDescriptionProduct("Ngon bổ rẻ");
//        Capacity capacity = new Capacity();
//        capacity.setIdCapacity(1L);
//        productDto.setCapacity(capacity);
//        Color color = new Color();
//        color.setIdColor(1L);
//        productDto.setColor(color);
//        Cpu cpu = new Cpu();
//        cpu.setIdCpu(Long.valueOf("895ry43hri"));
//        productDto.setCpu(cpu);
//        Ram ram = new Ram();
//        ram.setIdRam(1L);
//        productDto.setRam(ram);
//        Series series = new Series();
//        series.setIdSeries(1L);
//        productDto.setSeries(series);
//        Type type = new Type();
//        type.setIdType(1L);
//        productDto.setType(type);
//        ImageDto imageDto = new ImageDto();
//        imageDto.setName("image");
//        imageDto.setStatusImage(true);
//        productDto.setImageDto(imageDto);
//        this.mockMvc.perform(
//                        MockMvcRequestBuilders.post("/api/admin/product/add")
//                                .content(this.objectMapper.writeValueAsString(productDto))
//                                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * author: DaoPTA
//     * workday: 13/10/2023
//     * this function use to test the validation of field ram more specific is null
//     *
//     * @throws Exception
//     */
//    @Test
//    public void createProduct_ram_2 () throws Exception {
//        ProductDto productDto = new ProductDto();
//        productDto.setNameProduct("Phan Tá Anh Đào");
//        productDto.setBatteryProduct("100%");
//        productDto.setCameraProduct("12mp, 12mp, 12mp");
//        productDto.setPriceProduct(11000000.0);
//        productDto.setQuantityProduct(0L);
//        productDto.setScreenProduct("64 in");
//        productDto.setSelfieProduct("15mp");
//        productDto.setWeightProduct("200.5");
//        productDto.setStatusBusiness(true);
//        productDto.setDescriptionProduct("Ngon bổ rẻ");
//        Capacity capacity = new Capacity();
//        capacity.setIdCapacity(1L);
//        productDto.setCapacity(capacity);
//        Color color = new Color();
//        color.setIdColor(1L);
//        productDto.setColor(color);
//        Cpu cpu = new Cpu();
//        cpu.setIdCpu(1L);
//        productDto.setCpu(cpu);
//        Ram ram = new Ram();
//        ram.setIdRam(Long.valueOf("89y54htruirwa"));
//        productDto.setRam(ram);
//        Series series = new Series();
//        series.setIdSeries(1L);
//        productDto.setSeries(series);
//        Type type = new Type();
//        type.setIdType(1L);
//        productDto.setType(type);
//        ImageDto imageDto = new ImageDto();
//        imageDto.setName("image");
//        imageDto.setStatusImage(true);
//        productDto.setImageDto(imageDto);
//        this.mockMvc.perform(
//                        MockMvcRequestBuilders.post("/api/admin/product/add")
//                                .content(this.objectMapper.writeValueAsString(productDto))
//                                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * author: DaoPTA
//     * workday: 13/10/2023
//     * this function use to test the validation of field series more specific is null
//     *
//     * @throws Exception
//     */
//    @Test
//    public void createProduct_series_2 () throws Exception {
//        ProductDto productDto = new ProductDto();
//        productDto.setNameProduct("Phan Tá Anh Đào");
//        productDto.setBatteryProduct("100%");
//        productDto.setCameraProduct("12mp, 12mp, 12mp");
//        productDto.setPriceProduct(11000000.0);
//        productDto.setQuantityProduct(0L);
//        productDto.setScreenProduct("64 in");
//        productDto.setSelfieProduct("15mp");
//        productDto.setWeightProduct("200.5");
//        productDto.setStatusBusiness(true);
//        productDto.setDescriptionProduct("Ngon bổ rẻ");
//        Capacity capacity = new Capacity();
//        capacity.setIdCapacity(1L);
//        productDto.setCapacity(capacity);
//        Color color = new Color();
//        color.setIdColor(1L);
//        productDto.setColor(color);
//        Cpu cpu = new Cpu();
//        cpu.setIdCpu(1L);
//        productDto.setCpu(cpu);
//        Ram ram = new Ram();
//        ram.setIdRam(1L);
//        productDto.setRam(ram);
//        Series series = new Series();
//        series.setIdSeries(Long.valueOf("79854y3hr2q4de"));
//        productDto.setSeries(series);
//        Type type = new Type();
//        type.setIdType(1L);
//        productDto.setType(type);
//        ImageDto imageDto = new ImageDto();
//        imageDto.setName("image");
//        imageDto.setStatusImage(true);
//        productDto.setImageDto(imageDto);
//        this.mockMvc.perform(
//                        MockMvcRequestBuilders.post("/api/admin/product/add")
//                                .content(this.objectMapper.writeValueAsString(productDto))
//                                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * author: DaoPTA
//     * workday: 13/10/2023
//     * this function use to test the validation of field type more specific is null
//     *
//     * @throws Exception
//     */
//    @Test
//    public void createProduct_type_2 () throws Exception {
//        ProductDto productDto = new ProductDto();
//        productDto.setNameProduct("Phan Tá Anh Đào");
//        productDto.setBatteryProduct("100%");
//        productDto.setCameraProduct("12mp, 12mp, 12mp");
//        productDto.setPriceProduct(11000000.0);
//        productDto.setQuantityProduct(0L);
//        productDto.setScreenProduct("64 in");
//        productDto.setSelfieProduct("15mp");
//        productDto.setWeightProduct("200.5");
//        productDto.setStatusBusiness(true);
//        productDto.setDescriptionProduct("Ngon bổ rẻ");
//        Capacity capacity = new Capacity();
//        capacity.setIdCapacity(1L);
//        productDto.setCapacity(capacity);
//        Color color = new Color();
//        color.setIdColor(1L);
//        productDto.setColor(color);
//        Cpu cpu = new Cpu();
//        cpu.setIdCpu(1L);
//        productDto.setCpu(cpu);
//        Ram ram = new Ram();
//        ram.setIdRam(1L);
//        productDto.setRam(ram);
//        Series series = new Series();
//        series.setIdSeries(1L);
//        productDto.setSeries(series);
//        Type type = new Type();
//        type.setIdType(Long.valueOf("895y4qr2w"));
//        productDto.setType(type);
//        ImageDto imageDto = new ImageDto();
//        imageDto.setName("image");
//        imageDto.setStatusImage(true);
//        productDto.setImageDto(imageDto);
//        this.mockMvc.perform(
//                        MockMvcRequestBuilders.post("/api/admin/product/add")
//                                .content(this.objectMapper.writeValueAsString(productDto))
//                                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//}
