package com.example.c4zone.controller.reportsales;

import com.example.c4zone.service.home.IHomeService;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.c4zone.dto.reportsales.SalesReport;
import com.example.c4zone.service.reportsales.ISalesReportService;
import com.example.c4zone.model.product.Product;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/admin/business/sales-report")
public class SalesReportController {
    @Autowired
    private ISalesReportService salesReportService;
    @Autowired
    private IHomeService homeService;

    @GetMapping("")
    public ResponseEntity<List<SalesReport>> getSalesReport() {
        List<SalesReport> salesReportData = salesReportService.getData();
        return ResponseEntity.ok(salesReportData);
    }

    @GetMapping("/product")
    public ResponseEntity<List<Product>> getProduct() {
        List<Product> dataProduct = new ArrayList<>();
        dataProduct = salesReportService.getDataProduct();
        return new ResponseEntity<>(dataProduct, HttpStatus.OK);
    }

    @GetMapping("/createproduct")
    public ResponseEntity<List<Product>> getProductQR() throws WriterException, IOException {
        List<Product> dataProduct = salesReportService.getDataProduct();
        for (int i = 0; i < dataProduct.size(); i++) {
            String qrCodeText = dataProduct.get(i).toStringQR();
            int width = 300;
            int height = 300;

            BitMatrix bitMatrix = new QRCodeWriter().encode(qrCodeText, BarcodeFormat.QR_CODE, width, height);
            BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {
                    bufferedImage.setRGB(x, y, bitMatrix.get(x, y) ? 0xFF000000 : 0xFFFFFFFF);
                }
            }
            File qrCodeFile = new File("/Users/buihuuhai/anh/" + dataProduct.get(i).getIdProduct() + ".png");
            ImageIO.write(bufferedImage, "png", qrCodeFile);

            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ImageIO.write(bufferedImage, "png", byteArrayOutputStream);
            byte[] qrCodeImage = byteArrayOutputStream.toByteArray();
            String qrCodeBase64 = Base64.getEncoder().encodeToString(qrCodeImage);

            JSONObject response = new JSONObject();
            response.put("objectId", dataProduct.get(i).getIdProduct());
            response.put("qrCodeBase64", qrCodeBase64);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
        }
        return ResponseEntity.ok(dataProduct);
    }

    @GetMapping("/sreach")
    public ResponseEntity<List<SalesReport>> getSalesReportSearch(
            @RequestParam("startDate") String startDate,
            @RequestParam("endDate") String endDate,
            @RequestParam("searchTerm") String searchTerm) {
        String resultString = searchTerm.replace("'", "");
        List<SalesReport> dataSearch = salesReportService.getDataSreach(startDate, endDate, resultString);
        return ResponseEntity.ok(dataSearch);
    }

    @GetMapping("/quantity")
    public ResponseEntity<Integer> getQuantityToDay() {
        Integer data = salesReportService.getQuantityToday();
        return ResponseEntity.ok(data);
    }

    @GetMapping("/daily")
    public ResponseEntity<Integer> getDailyToDay() {
        Integer data = salesReportService.getDailyToday();
        return ResponseEntity.ok(data);
    }

    @GetMapping("/dailymonth")
    public ResponseEntity<Double> getDailyMonth() {
        Double data = salesReportService.getDailyMonth();
        double newValue;
        if (data < 0) {
            newValue = -data;
        } else {
            newValue = data;
        }
        return ResponseEntity.ok(newValue);
    }
}
