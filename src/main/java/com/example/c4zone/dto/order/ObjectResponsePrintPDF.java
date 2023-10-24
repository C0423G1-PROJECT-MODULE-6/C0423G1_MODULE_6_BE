package com.example.c4zone.dto.order;

import com.example.c4zone.model.customer.Customer;
import com.example.c4zone.model.order.OrderBill;
import com.example.c4zone.model.order.OrderDetail;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ObjectResponsePrintPDF {
    private OrderBill orderBill;
    private List<IOrderDetailPdfDto> orderDetails;
    private Customer customer;
}
