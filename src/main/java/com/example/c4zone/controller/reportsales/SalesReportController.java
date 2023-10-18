package com.example.c4zone.controller.reportsales;

import org.springframework.beans.factory.annotation.Autowired;
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
    public List<SalesReport> getSalesReport(
            @RequestParam("startDate") String startDate,
            @RequestParam("endDate") String endDate,
            @RequestParam("searchTerm") String searchTerm) {
        List<SalesReport> salesReportData = salesReportService.getData(startDate, endDate, searchTerm);
        return salesReportData;
    }

    @GetMapping("/product")
    public List<Product> getProduct() {
        List<Product> dataProduct = salesReportService.getDataProduct();
        return dataProduct;

    }

    @GetMapping("/sreach")
    public List<SalesReport> getSalesReportSreach(
            @RequestParam("startDate") String startDate,
            @RequestParam("endDate") String endDate,
            @RequestParam("searchTerm") String searchTerm) {
        String resultString = searchTerm.replace("'", "");
        List<SalesReport> dataSreach = salesReportService.getDataSreach(startDate, endDate, resultString);
        return dataSreach;
    }
}






