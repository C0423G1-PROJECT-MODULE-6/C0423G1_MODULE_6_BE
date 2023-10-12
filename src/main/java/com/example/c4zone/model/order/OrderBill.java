package com.example.c4zone.model.order;


import com.example.c4zone.model.customer.Customer;
import com.example.c4zone.model.user.AppUser;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class OrderBill {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long idOrderBill;

    @Column(columnDefinition = "date")
    private String dateOfOrder;
    private Double totalMoney;

    @ManyToOne
    @JoinColumn(name = "id_customer",referencedColumnName = "idCustomer")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "id_user",referencedColumnName = "id")

    private AppUser user;

    @OneToMany(mappedBy = "orderBill", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderDetail> orderDetails = new ArrayList<>();

}
