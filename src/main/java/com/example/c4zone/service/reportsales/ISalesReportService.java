package com.example.c4zone.service.reportsales;

import com.example.c4zone.model.product.Product;
import com.example.c4zone.dto.reportsales.SalesReport;

import java.util.List;

public interface ISalesReportService {
    List<SalesReport> getData(String startDate, String endDate, String searchTerm);

    List<Product> getDataProduct();

    List<SalesReport> getDataSreach(String startDate, String endDate, String searchTerm);
}
