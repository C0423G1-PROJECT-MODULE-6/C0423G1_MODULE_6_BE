package com.example.c4zone.controller.scaneqr;

import com.example.c4zone.model.product.Product;
import com.example.c4zone.service.reportsales.ISalesReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/admin/scanner-qr")
public class ScannerQRController {
    @Autowired
    private ISalesReportService salesReportService;

    @GetMapping("")
    public Product getByIdProduct(
            @RequestParam("idProduct") Long idProduct) {
        Product product = salesReportService.getById(idProduct);
        return product;
    }

}
