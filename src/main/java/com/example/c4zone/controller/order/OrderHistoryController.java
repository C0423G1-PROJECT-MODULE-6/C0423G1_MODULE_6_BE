package com.example.c4zone.controller.order;

import com.example.c4zone.dto.order.OrderHistoryDtoTotal;
import com.example.c4zone.service.order.IOrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/admin/orderHistory")

public class OrderHistoryController {
    @Autowired
    private IOrderDetailService orderDetailService;
    @GetMapping("")
    private ResponseEntity<Optional<List<OrderHistoryDtoTotal>>> showHistory(){
        Optional<List<OrderHistoryDtoTotal>> orderHistoryDtoTotals = orderDetailService.getAllHistoryTotal();
        return new ResponseEntity<>(orderHistoryDtoTotals,HttpStatus.OK);
    }
}
