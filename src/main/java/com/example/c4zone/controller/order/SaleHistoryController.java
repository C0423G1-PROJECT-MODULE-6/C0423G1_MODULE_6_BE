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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/admin/business/order/saleHistory")
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
            @RequestParam(name = "name_like",required = false,defaultValue = "") Optional<String> searchName,
            @RequestParam(name = "sort",required = false,defaultValue = "date") String sort,
            @RequestParam(name = "orther",required = false,defaultValue = "asc") String orther
//            @RequestParam(name = "sortNameCustomer") Optional<String> sortCustomer,
//            @RequestParam(name = "sortTime") Optional<String> sortTime,
//            @RequestParam(name = "sortNameProduct") Optional<String> sortNameProduct,
//            @RequestParam(name = "sortQuantity") Optional<String> sortQuantity,
//            @RequestParam(name = "sortTotalMoney") Optional<String> sortTotalMoney
    ) {
        Pageable pageable;
        Sort sort1;
        switch (sort){
            case "sortTime":
                sort1=Sort.by("t");
                break;
            case "sortNameCustomer":
                sort1=Sort.by("");

                break;
            case "sortNameProduct":
                sort1=Sort.by("");

                break;
            case "sortQuantity":
                sort1=Sort.by("");

                break;
            case "sortTotalMoney":
                sort1=Sort.by("");

                break;
            default:
                sort1=Sort.by("");
                break;
        }
        if (orther.equals("dsc")){
            sort1=sort1.descending();
        }else {
            sort1=sort1.ascending();
        }
        pageable= PageRequest.of(page,limit,sort1);



        Page<IOrderHistoryDtoTotal> saleHistoryList = orderDetailService.getAllSaleHistory(pageable, searchName.get() ,0);
        if (saleHistoryList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(saleHistoryList, HttpStatus.OK);
    }
}
