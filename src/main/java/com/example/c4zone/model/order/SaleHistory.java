package com.example.c4zone.model.order;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class SaleHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSaleHistory;

    @Column(columnDefinition = "time")
    private String timeOfOrder;

    @ManyToOne
    @JoinColumn(name = "id_order_detail",referencedColumnName = "idOrderDetail")
    private OrderDetail orderDetail;
}
