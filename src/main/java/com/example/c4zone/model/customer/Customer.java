package com.example.c4zone.model.customer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCustomer;
    @Column(name = "name_customer")
    private String nameCustomer;
    @Column(name = "gender_customer")
    private Boolean genderCustomer = true;
    @Column(name = "email_customer")
    private String emailCustomer;
    @Column(name = "birth_date_customer", columnDefinition = "date")
    private String dateOfBirthCustomer;
    @Column(name = "phone_number_customer")
    private String phoneNumberCustomer;
    @Column(name = "address_customer")
    private String addressCustomer;
    @Column(name = "status_customer")
    private Boolean statusCustomer = true;

}
