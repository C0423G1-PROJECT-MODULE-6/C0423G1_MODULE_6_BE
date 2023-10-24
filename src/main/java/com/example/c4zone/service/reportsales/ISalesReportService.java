package com.example.c4zone.service.reportsales;

import com.example.c4zone.dto.reportsales.TypeReport;
import com.example.c4zone.model.product.Product;
import com.example.c4zone.dto.reportsales.SalesReport;

import java.util.List;

public interface ISalesReportService {
    List<SalesReport> getData();

    List<Product> getDataProduct();

    List<SalesReport> getDataSreach(String startDate, String endDate, String searchTerm);

    Product getById(Long idProduct);

    Integer getQuantityToday();

    Integer getDailyToday();

    Double getDailyMonth();

    List<TypeReport> getTypeReport();
}
