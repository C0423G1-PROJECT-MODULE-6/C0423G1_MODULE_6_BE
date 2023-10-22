package com.example.c4zone.controller.product;

import com.example.c4zone.model.product.Series;
import com.example.c4zone.service.product.ISeriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("api/admin/business/series")
public class SeriesController {
    @Autowired
    private ISeriesService seriesService;

    @GetMapping("/list")
    @ResponseBody
    public ResponseEntity<List<Series>> findAll() {
        return new ResponseEntity<>(seriesService.findAll(), HttpStatus.OK);
    }
}
