package com.example.c4zone.controller.order;

import com.example.c4zone.dto.order.IOrderHistoryDtoTotal;
import com.example.c4zone.service.order.IOrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/admin/business/order/saleHistory")
@CrossOrigin("*")
public class SaleHistoryController {
    @Autowired
    private IOrderDetailService orderDetailService;
    /**
     * method get all history
     * Create ThoiND
     * Date 14-10-2023
     * param limit,page,name_like or sortName,sortTime,...
     * return status 2xx
     */
    @GetMapping("")
    public ResponseEntity<Page<IOrderHistoryDtoTotal>> getAllSaleHistory(
            @RequestParam(name = "_limit",required = false,defaultValue = "10") int limit,
            @RequestParam(name = "_page" ,required = false,defaultValue = "0") int page,
            @RequestParam(name = "name_like",required = false,defaultValue = "") String searchName,
            @RequestParam(name = "sort",required = false,defaultValue = "timeOfOrder") String sort,
            @RequestParam(name = "other",required = false,defaultValue = "asc") String other
    ) {
        Pageable pageable;
        Sort sort1;
        switch (sort){
            case "sortTime":
                sort1=Sort.by("timeOfOrder");
                break;
            case "sortNameCustomer":
                sort1=Sort.by("nameCustomer");

                break;
            case "sortNameProduct":
                sort1=Sort.by("timeOfOrder");
                break;
            case "sortQuantity":
                sort1=Sort.by("nameCustomer");

                break;
            case "sortTotalMoney":
                sort1=Sort.by("total_money");
                break;
            default:
                sort1=Sort.by("id_order_bill");
                break;
        }
        if (other.equals("dsc")){
            sort1=sort1.descending();
        }else {
            sort1=sort1.ascending();
        }
        pageable= PageRequest.of(page,limit,sort1);

        Page<IOrderHistoryDtoTotal> saleHistoryList = orderDetailService.getAllSaleHistory(pageable, searchName);
        if (saleHistoryList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(saleHistoryList, HttpStatus.OK);
    }
}