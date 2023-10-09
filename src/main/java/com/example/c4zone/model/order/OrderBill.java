package com.example.c4zone.model.order;


import com.example.c4zone.model.customer.Customer;
import com.example.c4zone.model.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

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

    @ManyToOne
    @JoinColumn(name = "id_customer",referencedColumnName = "idCustomer")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "id_user",referencedColumnName = "id")
    private User user;
}
