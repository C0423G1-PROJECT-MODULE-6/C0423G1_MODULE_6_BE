package com.example.c4zone.product;

import com.example.c4zone.dto.product.ImageDto;
import com.example.c4zone.dto.product.ProductDto;
import com.example.c4zone.model.product.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;


@SpringBootTest
@AutoConfigureMockMvc
public class ProductController_createProduct {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;


    /**
     * author: DaoPTA
     * workday: 13/10/2023
     * This function is used to check if it is correct
     *
     * @throws Exception
     */

    @Test
    public void createProduct_1 () throws Exception {
        ProductDto productDto = new ProductDto();
        productDto.setNameProduct("Phan Tá Anh Đào");
        productDto.setBatteryProduct("100%");
        productDto.setCameraProduct("12mp, 12mp, 12mp");
        productDto.setPriceProduct(11000000.0);
        productDto.setQuantityProduct(100.0);
        productDto.setScreenProduct("64 in");
        productDto.setSelfieProduct("15mp");
        productDto.setWeightProduct(200.5);
        productDto.setStatusBusiness(true);
        productDto.setDescriptionProduct("Ngon bổ rẻ");
        Capacity capacity = new Capacity();
        capacity.setIdCapacity(1L);
        productDto.setCapacity(capacity);
        Color color = new Color();
        color.setIdColor(1L);
        productDto.setColor(color);
        Cpu cpu = new Cpu();
        cpu.setIdCpu(1L);
        productDto.setCpu(cpu);
        Ram ram = new Ram();
        ram.setIdRam(1L);
        productDto.setRam(ram);
        Series series = new Series();
        series.setIdSeries(1L);
        productDto.setSeries(series);
        Type type = new Type();
        type.setIdType(1L);
        productDto.setType(type);
        ImageDto imageDto = new ImageDto();
        imageDto.setName("image");
        imageDto.setStatusImage(true);
        productDto.setImageDto(imageDto);
        this.mockMvc.perform(
                MockMvcRequestBuilders.post("/api/admin/product/add")
                        .content(this.objectMapper.writeValueAsString(productDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * author: DaoPTA
     * workday: 13/10/2023
     * this function use to test the validation of field name more specific is null
     *
     * @throws Exception
     */
    @Test
    public void createProduct_name_2 () throws Exception {
        ProductDto productDto = new ProductDto();
//        productDto.setNameProduct("Phan Tá Anh Đào");
        productDto.setBatteryProduct("100%");
        productDto.setCameraProduct("12mp, 12mp, 12mp");
        productDto.setPriceProduct(11000000.0);
        productDto.setQuantityProduct(0.0D);
        productDto.setScreenProduct("64 in");
        productDto.setSelfieProduct("15mp");
        productDto.setWeightProduct(200.5D);
        productDto.setStatusBusiness(true);
        productDto.setDescriptionProduct("Ngon bổ rẻ");
        Capacity capacity = new Capacity();
        capacity.setIdCapacity(1L);
        productDto.setCapacity(capacity);
        Color color = new Color();
        color.setIdColor(1L);
        productDto.setColor(color);
        Cpu cpu = new Cpu();
        cpu.setIdCpu(1L);
        productDto.setCpu(cpu);
        Ram ram = new Ram();
        ram.setIdRam(1L);
        productDto.setRam(ram);
        Series series = new Series();
        series.setIdSeries(1L);
        productDto.setSeries(series);
        Type type = new Type();
        type.setIdType(1L);
        productDto.setType(type);
        ImageDto imageDto = new ImageDto();
        imageDto.setName("image");
        imageDto.setStatusImage(true);
        productDto.setImageDto(imageDto);
        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/api/admin/product/add")
                                .content(this.objectMapper.writeValueAsString(productDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * author: DaoPTA
     * workday: 13/10/2023
     * This function is used to validate specific field names rather than WRONG FORMAT
     *
     * @throws Exception
     */
    @Test
    public void createProduct_name_3 () throws Exception {
        ProductDto productDto = new ProductDto();
        productDto.setNameProduct("42387283HFWEJHDJ");
        productDto.setBatteryProduct("100%");
        productDto.setCameraProduct("12mp, 12mp, 12mp");
        productDto.setPriceProduct(11000000.0);
        productDto.setQuantityProduct(0.0D);
        productDto.setScreenProduct("64 in");
        productDto.setSelfieProduct("15mp");
        productDto.setWeightProduct(200.5D);
        productDto.setStatusBusiness(true);
        productDto.setDescriptionProduct("Ngon bổ rẻ");
        Capacity capacity = new Capacity();
        capacity.setIdCapacity(1L);
        productDto.setCapacity(capacity);
        Color color = new Color();
        color.setIdColor(1L);
        productDto.setColor(color);
        Cpu cpu = new Cpu();
        cpu.setIdCpu(1L);
        productDto.setCpu(cpu);
        Ram ram = new Ram();
        ram.setIdRam(1L);
        productDto.setRam(ram);
        Series series = new Series();
        series.setIdSeries(1L);
        productDto.setSeries(series);
        Type type = new Type();
        type.setIdType(1L);
        productDto.setType(type);
        ImageDto imageDto = new ImageDto();
        imageDto.setName("image");
        imageDto.setStatusImage(true);
        productDto.setImageDto(imageDto);
        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/api/admin/product/add")
                                .content(this.objectMapper.writeValueAsString(productDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * author: DaoPTA
     * workday: 13/10/2023
     * This function is used to check that specific field names are not entered
     *
     * @throws Exception
     */
    @Test
    public void createProduct_name_4 () throws Exception {
        ProductDto productDto = new ProductDto();
        productDto.setNameProduct("!@$@&@(&@)");
        productDto.setBatteryProduct("100%");
        productDto.setCameraProduct("12mp, 12mp, 12mp");
        productDto.setPriceProduct(11000000.0);
        productDto.setQuantityProduct(0.0D);
        productDto.setScreenProduct("64 in");
        productDto.setSelfieProduct("15mp");
        productDto.setWeightProduct(200.5D);
        productDto.setStatusBusiness(true);
        productDto.setDescriptionProduct("Ngon bổ rẻ");
        Capacity capacity = new Capacity();
        capacity.setIdCapacity(1L);
        productDto.setCapacity(capacity);
        Color color = new Color();
        color.setIdColor(1L);
        productDto.setColor(color);
        Cpu cpu = new Cpu();
        cpu.setIdCpu(1L);
        productDto.setCpu(cpu);
        Ram ram = new Ram();
        ram.setIdRam(1L);
        productDto.setRam(ram);
        Series series = new Series();
        series.setIdSeries(1L);
        productDto.setSeries(series);
        Type type = new Type();
        type.setIdType(1L);
        productDto.setType(type);
        ImageDto imageDto = new ImageDto();
        imageDto.setName("image");
        imageDto.setStatusImage(true);
        productDto.setImageDto(imageDto);
        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/api/admin/product/add")
                                .content(this.objectMapper.writeValueAsString(productDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * author: DaoPTA
     * workday: 13/10/2023
     * This function is used to check and confirm that a specific field name is not entered more than the number of characters
     *
     * @throws Exception
     */
    @Test
    public void createProduct_name_5 () throws Exception {
        ProductDto productDto = new ProductDto();
        productDto.setNameProduct("Phan Tá Anh Đàooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo" +
                "ooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo" +
                "ooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo");
        productDto.setBatteryProduct("100%");
        productDto.setCameraProduct("12mp, 12mp, 12mp");
        productDto.setPriceProduct(11000000.0);
        productDto.setQuantityProduct(0.0D);
        productDto.setScreenProduct("64 in");
        productDto.setSelfieProduct("15mp");
        productDto.setWeightProduct(200.5D);
        productDto.setStatusBusiness(true);
        productDto.setDescriptionProduct("Ngon bổ rẻ");
        Capacity capacity = new Capacity();
        capacity.setIdCapacity(1L);
        productDto.setCapacity(capacity);
        Color color = new Color();
        color.setIdColor(1L);
        productDto.setColor(color);
        Cpu cpu = new Cpu();
        cpu.setIdCpu(1L);
        productDto.setCpu(cpu);
        Ram ram = new Ram();
        ram.setIdRam(1L);
        productDto.setRam(ram);
        Series series = new Series();
        series.setIdSeries(1L);
        productDto.setSeries(series);
        Type type = new Type();
        type.setIdType(1L);
        productDto.setType(type);
        ImageDto imageDto = new ImageDto();
        imageDto.setName("image");
        imageDto.setStatusImage(true);
        productDto.setImageDto(imageDto);
        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/api/admin/product/add")
                                .content(this.objectMapper.writeValueAsString(productDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * author: DaoPTA
     * workday: 13/10/2023
     * this function use to test the validation of field price more specific is null
     *
     * @throws Exception
     */
    @Test
    public void createProduct_price_2 () throws Exception {
        ProductDto productDto = new ProductDto();
        productDto.setNameProduct("Phan Tá Anh Đào");
        productDto.setBatteryProduct("100%");
        productDto.setCameraProduct("12mp, 12mp, 12mp");
//        productDto.setPriceProduct(11000000.0);
        productDto.setQuantityProduct(0.0D);
        productDto.setScreenProduct("64 in");
        productDto.setSelfieProduct("15mp");
        productDto.setWeightProduct(200.5D);
        productDto.setStatusBusiness(true);
        productDto.setDescriptionProduct("Ngon bổ rẻ");
        Capacity capacity = new Capacity();
        capacity.setIdCapacity(1L);
        productDto.setCapacity(capacity);
        Color color = new Color();
        color.setIdColor(1L);
        productDto.setColor(color);
        Cpu cpu = new Cpu();
        cpu.setIdCpu(1L);
        productDto.setCpu(cpu);
        Ram ram = new Ram();
        ram.setIdRam(1L);
        productDto.setRam(ram);
        Series series = new Series();
        series.setIdSeries(1L);
        productDto.setSeries(series);
        Type type = new Type();
        type.setIdType(1L);
        productDto.setType(type);
        ImageDto imageDto = new ImageDto();
        imageDto.setName("image");
        imageDto.setStatusImage(true);
        productDto.setImageDto(imageDto);
        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/api/admin/product/add")
                                .content(this.objectMapper.writeValueAsString(productDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * author: DaoPTA
     * workday: 13/10/2023
     * This function is used to validate specific field price rather than WRONG FORMAT
     *
     * @throws Exception
     */
    @Test
    public void createProduct_price_3_4 () throws Exception {
        ProductDto productDto = new ProductDto();
        productDto.setNameProduct("Phan Tá Anh Đào");
        productDto.setBatteryProduct("100%");
        productDto.setCameraProduct("12mp, 12mp, 12mp");
        productDto.setPriceProduct(300000000000.0);
        productDto.setQuantityProduct(0.0D);
        productDto.setScreenProduct("64 in");
        productDto.setSelfieProduct("15mp");
        productDto.setWeightProduct(200.5D);
        productDto.setStatusBusiness(true);
        productDto.setDescriptionProduct("Ngon bổ rẻ");
        Capacity capacity = new Capacity();
        capacity.setIdCapacity(1L);
        productDto.setCapacity(capacity);
        Color color = new Color();
        color.setIdColor(1L);
        productDto.setColor(color);
        Cpu cpu = new Cpu();
        cpu.setIdCpu(1L);
        productDto.setCpu(cpu);
        Ram ram = new Ram();
        ram.setIdRam(1L);
        productDto.setRam(ram);
        Series series = new Series();
        series.setIdSeries(1L);
        productDto.setSeries(series);
        Type type = new Type();
        type.setIdType(1L);
        productDto.setType(type);
        ImageDto imageDto = new ImageDto();
        imageDto.setName("image");
        imageDto.setStatusImage(true);
        productDto.setImageDto(imageDto);
        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/api/admin/product/add")
                                .content(this.objectMapper.writeValueAsString(productDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * author: DaoPTA
     * workday: 13/10/2023
     * This function is used to check and confirm that a specific field name is not entered more than the number of characters
     *
     * @throws Exception
     */
    @Test
    public void createProduct_price_5 () throws Exception {
        ProductDto productDto = new ProductDto();
        productDto.setNameProduct("Phan Tá Anh Đào");
        productDto.setBatteryProduct("100%");
        productDto.setCameraProduct("12mp, 12mp, 12mp");
        productDto.setPriceProduct(30000000000000000000000000000000000000000000000000000000000000000000000000000000000000000.0);
        productDto.setQuantityProduct(0.0D);
        productDto.setScreenProduct("64 in");
        productDto.setSelfieProduct("15mp");
        productDto.setWeightProduct(200.5D);
        productDto.setStatusBusiness(true);
        productDto.setDescriptionProduct("Ngon bổ rẻ");
        Capacity capacity = new Capacity();
        capacity.setIdCapacity(1L);
        productDto.setCapacity(capacity);
        Color color = new Color();
        color.setIdColor(1L);
        productDto.setColor(color);
        Cpu cpu = new Cpu();
        cpu.setIdCpu(1L);
        productDto.setCpu(cpu);
        Ram ram = new Ram();
        ram.setIdRam(1L);
        productDto.setRam(ram);
        Series series = new Series();
        series.setIdSeries(1L);
        productDto.setSeries(series);
        Type type = new Type();
        type.setIdType(1L);
        productDto.setType(type);
        ImageDto imageDto = new ImageDto();
        imageDto.setName("image");
        imageDto.setStatusImage(true);
        productDto.setImageDto(imageDto);
        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/api/admin/product/add")
                                .content(this.objectMapper.writeValueAsString(productDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * author: DaoPTA
     * workday: 13/10/2023
     * this function use to test the validation of field battery more specific is null
     *
     * @throws Exception
     */
    @Test
    public void createProduct_battery_2 () throws Exception {
        ProductDto productDto = new ProductDto();
        productDto.setNameProduct("Phan Tá Anh Đào");
//        productDto.setBatteryProduct("100%");
        productDto.setCameraProduct("12mp, 12mp, 12mp");
        productDto.setPriceProduct(11000000.0);
        productDto.setQuantityProduct(0.0D);
        productDto.setScreenProduct("64 in");
        productDto.setSelfieProduct("15mp");
        productDto.setWeightProduct(200.5D);
        productDto.setStatusBusiness(true);
        productDto.setDescriptionProduct("Ngon bổ rẻ");
        Capacity capacity = new Capacity();
        capacity.setIdCapacity(1L);
        productDto.setCapacity(capacity);
        Color color = new Color();
        color.setIdColor(1L);
        productDto.setColor(color);
        Cpu cpu = new Cpu();
        cpu.setIdCpu(1L);
        productDto.setCpu(cpu);
        Ram ram = new Ram();
        ram.setIdRam(1L);
        productDto.setRam(ram);
        Series series = new Series();
        series.setIdSeries(1L);
        productDto.setSeries(series);
        Type type = new Type();
        type.setIdType(1L);
        productDto.setType(type);
        ImageDto imageDto = new ImageDto();
        imageDto.setName("image");
        imageDto.setStatusImage(true);
        productDto.setImageDto(imageDto);
        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/api/admin/product/add")
                                .content(this.objectMapper.writeValueAsString(productDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * author: DaoPTA
     * workday: 13/10/2023
     * This function is used to validate specific field battery rather than WRONG FORMAT
     *
     * @throws Exception
     */
    @Test
    public void createProduct_battety_3_4 () throws Exception {
        ProductDto productDto = new ProductDto();
        productDto.setNameProduct("Phan Tá Anh Đào");
        productDto.setBatteryProduct("100!@#");
        productDto.setCameraProduct("12mp, 12mp, 12mp");
        productDto.setPriceProduct(11000000.0);
        productDto.setQuantityProduct(0.0D);
        productDto.setScreenProduct("64 in");
        productDto.setSelfieProduct("15mp");
        productDto.setWeightProduct(200.5D);
        productDto.setStatusBusiness(true);
        productDto.setDescriptionProduct("Ngon bổ rẻ");
        Capacity capacity = new Capacity();
        capacity.setIdCapacity(1L);
        productDto.setCapacity(capacity);
        Color color = new Color();
        color.setIdColor(1L);
        productDto.setColor(color);
        Cpu cpu = new Cpu();
        cpu.setIdCpu(1L);
        productDto.setCpu(cpu);
        Ram ram = new Ram();
        ram.setIdRam(1L);
        productDto.setRam(ram);
        Series series = new Series();
        series.setIdSeries(1L);
        productDto.setSeries(series);
        Type type = new Type();
        type.setIdType(1L);
        productDto.setType(type);
        ImageDto imageDto = new ImageDto();
        imageDto.setName("image");
        imageDto.setStatusImage(true);
        productDto.setImageDto(imageDto);
        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/api/admin/product/add")
                                .content(this.objectMapper.writeValueAsString(productDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * author: DaoPTA
     * workday: 13/10/2023
     * This function is used to check and confirm that a specific field battery is not entered more than the number of characters
     *
     * @throws Exception
     */
    @Test
    public void createProduct_battery_5 () throws Exception {
        ProductDto productDto = new ProductDto();
        productDto.setNameProduct("Phan Tá Anh Đào");
        productDto.setBatteryProduct("100%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%" +
                "%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%" +
                "%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        productDto.setCameraProduct("12mp, 12mp, 12mp");
        productDto.setPriceProduct(11000000.0);
        productDto.setQuantityProduct(0.0D);
        productDto.setScreenProduct("64 in");
        productDto.setSelfieProduct("15mp");
        productDto.setWeightProduct(200.5D);
        productDto.setStatusBusiness(true);
        productDto.setDescriptionProduct("Ngon bổ rẻ");
        Capacity capacity = new Capacity();
        capacity.setIdCapacity(1L);
        productDto.setCapacity(capacity);
        Color color = new Color();
        color.setIdColor(1L);
        productDto.setColor(color);
        Cpu cpu = new Cpu();
        cpu.setIdCpu(1L);
        productDto.setCpu(cpu);
        Ram ram = new Ram();
        ram.setIdRam(1L);
        productDto.setRam(ram);
        Series series = new Series();
        series.setIdSeries(1L);
        productDto.setSeries(series);
        Type type = new Type();
        type.setIdType(1L);
        productDto.setType(type);
        ImageDto imageDto = new ImageDto();
        imageDto.setName("image");
        imageDto.setStatusImage(true);
        productDto.setImageDto(imageDto);
        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/api/admin/product/add")
                                .content(this.objectMapper.writeValueAsString(productDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * author: DaoPTA
     * workday: 13/10/2023
     * this function use to test the validation of field camera more specific is null
     *
     * @throws Exception
     */
    @Test
    public void createProduct_camera_2 () throws Exception {
        ProductDto productDto = new ProductDto();
        productDto.setNameProduct("Phan Tá Anh Đào");
        productDto.setBatteryProduct("100%");
//        productDto.setCameraProduct("12mp, 12mp, 12mp");
        productDto.setPriceProduct(11000000.0);
        productDto.setQuantityProduct(0.0D);
        productDto.setScreenProduct("64 in");
        productDto.setSelfieProduct("15mp");
        productDto.setWeightProduct(200.5D);
        productDto.setStatusBusiness(true);
        productDto.setDescriptionProduct("Ngon bổ rẻ");
        Capacity capacity = new Capacity();
        capacity.setIdCapacity(1L);
        productDto.setCapacity(capacity);
        Color color = new Color();
        color.setIdColor(1L);
        productDto.setColor(color);
        Cpu cpu = new Cpu();
        cpu.setIdCpu(1L);
        productDto.setCpu(cpu);
        Ram ram = new Ram();
        ram.setIdRam(1L);
        productDto.setRam(ram);
        Series series = new Series();
        series.setIdSeries(1L);
        productDto.setSeries(series);
        Type type = new Type();
        type.setIdType(1L);
        productDto.setType(type);
        ImageDto imageDto = new ImageDto();
        imageDto.setName("image");
        imageDto.setStatusImage(true);
        productDto.setImageDto(imageDto);
        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/api/admin/product/add")
                                .content(this.objectMapper.writeValueAsString(productDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * author: DaoPTA
     * workday: 13/10/2023
     * This function is used to validate specific field camera rather than WRONG FORMAT
     *
     * @throws Exception
     */
    @Test
    public void createProduct_camera_3_4 () throws Exception {
        ProductDto productDto = new ProductDto();
        productDto.setNameProduct("Phan Tá Anh Đào");
        productDto.setBatteryProduct("100%");
        productDto.setCameraProduct("$^^&&^*^*");
        productDto.setPriceProduct(11000000.0);
        productDto.setQuantityProduct(0.0D);
        productDto.setScreenProduct("64 in");
        productDto.setSelfieProduct("15mp");
        productDto.setWeightProduct(200.5D);
        productDto.setStatusBusiness(true);
        productDto.setDescriptionProduct("Ngon bổ rẻ");
        Capacity capacity = new Capacity();
        capacity.setIdCapacity(1L);
        productDto.setCapacity(capacity);
        Color color = new Color();
        color.setIdColor(1L);
        productDto.setColor(color);
        Cpu cpu = new Cpu();
        cpu.setIdCpu(1L);
        productDto.setCpu(cpu);
        Ram ram = new Ram();
        ram.setIdRam(1L);
        productDto.setRam(ram);
        Series series = new Series();
        series.setIdSeries(1L);
        productDto.setSeries(series);
        Type type = new Type();
        type.setIdType(1L);
        productDto.setType(type);
        ImageDto imageDto = new ImageDto();
        imageDto.setName("image");
        imageDto.setStatusImage(true);
        productDto.setImageDto(imageDto);
        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/api/admin/product/add")
                                .content(this.objectMapper.writeValueAsString(productDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * author: DaoPTA
     * workday: 13/10/2023
     * This function is used to check and confirm that a specific field camera is not entered more than the number of characters
     *
     * @throws Exception
     */
    @Test
    public void createProduct_camera_5 () throws Exception {
        ProductDto productDto = new ProductDto();
        productDto.setNameProduct("Phan Tá Anh Đào");
        productDto.setBatteryProduct("100%");
        productDto.setCameraProduct("12mp, 12mp, 12mp,12mp, 12mp, 12mp,12mp, 12mp, 12mp," +
                "12mp, 12mp, 12mp,12mp, 12mp, 12mp,12mp, 12mp, 12mp,12mp, 12mp, 12mp,12mp, 12mp, 12mp," +
                "12mp, 12mp, 12mp,12mp, 12mp, 12mp,12mp, 12mp, 12mp,12mp, 12mp, 12mp,12mp, 12mp, 12mp," +
                "12mp, 12mp, 12mp,12mp, 12mp, 12mp,12mp, 12mp, 12mp,12mp, 12mp, 12mp,12mp, 12mp, 12mp,12mp, 12mp, 12mp," +
                "12mp, 12mp, 12mp,12mp, 12mp, 12mp,12mp, 12mp, 12mp,12mp, 12mp, 12mp,12mp, 12mp, 12mp," +
                "12mp, 12mp, 12mp,12mp, 12mp, 12mp,12mp, 12mp, 12mp,12mp, 12mp, 12mp,12mp, 12mp, 12mp," +
                "12mp, 12mp, 12mp,12mp, 12mp, 12mp,12mp, 12mp, 12mp,12mp, 12mp, 12mp,12mp, 12mp, 12mp");
        productDto.setPriceProduct(11000000.0);
        productDto.setQuantityProduct(0.0D);
        productDto.setScreenProduct("64 in");
        productDto.setSelfieProduct("15mp");
        productDto.setWeightProduct(200.5D);
        productDto.setStatusBusiness(true);
        productDto.setDescriptionProduct("Ngon bổ rẻ");
        Capacity capacity = new Capacity();
        capacity.setIdCapacity(1L);
        productDto.setCapacity(capacity);
        Color color = new Color();
        color.setIdColor(1L);
        productDto.setColor(color);
        Cpu cpu = new Cpu();
        cpu.setIdCpu(1L);
        productDto.setCpu(cpu);
        Ram ram = new Ram();
        ram.setIdRam(1L);
        productDto.setRam(ram);
        Series series = new Series();
        series.setIdSeries(1L);
        productDto.setSeries(series);
        Type type = new Type();
        type.setIdType(1L);
        productDto.setType(type);
        ImageDto imageDto = new ImageDto();
        imageDto.setName("image");
        imageDto.setStatusImage(true);
        productDto.setImageDto(imageDto);
        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/api/admin/product/add")
                                .content(this.objectMapper.writeValueAsString(productDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

}
