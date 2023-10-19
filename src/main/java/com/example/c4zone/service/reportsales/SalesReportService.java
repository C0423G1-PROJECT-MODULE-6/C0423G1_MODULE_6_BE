package com.example.c4zone.service.reportsales;

import com.example.c4zone.model.product.Product;
import com.example.c4zone.dto.reportsales.SalesReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.c4zone.repository.reportsales.SalesReportRepository;
import java.util.List;

@Service
public class SalesReportService implements ISalesReportService {
    @Autowired
    private SalesReportRepository salesReportRepository;

    @Override
    public List<SalesReport> getData(String startDate, String endDate, String searchTerm) {
        System.out.println(salesReportRepository.getData(startDate, endDate, searchTerm));
        return salesReportRepository.getData(startDate, endDate, searchTerm);

    }

    @Override
    public List<Product> getDataProduct() {
        return salesReportRepository.findAll();
    }

    @Override
    public List<SalesReport> getDataSreach(String startDate, String endDate, String searchTerm) {
        List<Product> products = getDataProduct();
        for (int i = 0; i < products.size(); i++) {
            if (searchTerm.equals(products.get(i).getNameProduct())) {
                return salesReportRepository.getDataSreach(startDate, endDate, products.get(i).getIdProduct());
            }
        }
        return salesReportRepository.getDataSreachNull(startDate, endDate);
    }

}
