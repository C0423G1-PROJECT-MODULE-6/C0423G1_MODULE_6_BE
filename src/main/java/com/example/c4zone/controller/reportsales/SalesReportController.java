package com.example.c4zone.controller.reportsales;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.c4zone.dto.reportsales.SalesReport;
import com.example.c4zone.service.reportsales.ISalesReportService;
import com.example.c4zone.model.product.Product;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/admin/sales-report")
public class SalesReportController {
    @Autowired
    private ISalesReportService salesReportService;

    @GetMapping("")
    public ResponseEntity<List<SalesReport>> getSalesReport() {
        List<SalesReport> salesReportData = salesReportService.getData();
        return ResponseEntity.ok(salesReportData);
    }

    @GetMapping("/product")
    public ResponseEntity<List<Product>> getProduct() {
        List<Product> dataProduct = salesReportService.getDataProduct();
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
}
