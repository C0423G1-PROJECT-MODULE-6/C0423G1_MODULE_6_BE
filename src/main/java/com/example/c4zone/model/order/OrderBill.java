package com.example.c4zone.model.order;


import com.example.c4zone.model.customer.Customer;
import com.example.c4zone.model.user.AppUser;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderBill {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long idOrderBill;

    @Column(columnDefinition = "date")
    private String dateOfOrder;
    @Column(columnDefinition = "time")
    private String timeOfOrder;
    private Double totalMoney;
    private Integer paymentMethod;
    private Integer printStatus;
    private Integer paymentStatus = 0;

    @ManyToOne
    @JoinColumn(name = "id_customer",referencedColumnName = "idCustomer")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "id_user",referencedColumnName = "id")
    private AppUser user;


    @Override
    public String toString() {
        return "OrderBill{" +
                "idOrderBill=" + idOrderBill +
                ", dateOfOrder='" + dateOfOrder + '\'' +
                ", timeOfOrder='" + timeOfOrder + '\'' +
                ", totalMoney=" + totalMoney +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", printStatus=" + printStatus +
                ", customer=" + customer +
                ", user=" + user +
                '}';
    }
}
