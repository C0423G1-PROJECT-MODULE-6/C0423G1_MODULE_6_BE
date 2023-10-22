package com.example.c4zone.service.reportsales;

import com.example.c4zone.model.product.Product;
import com.example.c4zone.dto.reportsales.SalesReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.c4zone.repository.reportsales.SalesReportRepository;

import java.util.List;
import java.util.Objects;

@Service
public class SalesReportService implements ISalesReportService {
    @Autowired
    private SalesReportRepository salesReportRepository;

    @Override
    public List<SalesReport> getData() {
        System.out.println(salesReportRepository.getData());
        return salesReportRepository.getData();

    }

    @Override
    public List<Product> getDataProduct() {
        return salesReportRepository.findAllProduct();
    }

    @Override
    public List<SalesReport> getDataSreach(String startDate, String endDate, String searchTerm) {
        List<Product> products = salesReportRepository.findAllProduct();
        for (int i = 0; i < products.size(); i++) {
            if (searchTerm.equals(products.get(i).getNameProduct())) {
                return salesReportRepository.getDataSreach(startDate, endDate, products.get(i).getIdProduct());
            }
        }
        if (Objects.equals(startDate, "") || Objects.equals(endDate, "")) {
            return salesReportRepository.getData();
        }
        return salesReportRepository.getDataSreachNull(startDate, endDate);
    }

    @Override
    public Product getById(Long idProduct) {
        return salesReportRepository.getByIdProduct(idProduct);
    }

    @Override
    public Integer getQuantityToday() {
        return salesReportRepository.getDailyToday();
    }

    @Override
    public Integer getDailyToday() {
        return salesReportRepository.getQuantityToday();
    }

    @Override
    public Double getDailyMonth() {
        return salesReportRepository.getDailyMonth();
    }

}
