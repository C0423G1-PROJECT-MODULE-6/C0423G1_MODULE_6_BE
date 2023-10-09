package com.example.c4zone.model.supplier;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "supplier")
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_supplier")
    private Integer idSupplier;
    @Column(name = "code_supplier")
    private Integer codeSupplier;
    @Column(name = "name_supplier")
    private String nameSupplier;
    @Column(name = "address_supplier")
    private String addressSupplier;
    @Column(name = "phone_number_supplier")
    private String phoneNumberSupplier;
    @Column(name = "email_supplier")
    private String emailSupplier;
    @Column(name = "status_supplier", columnDefinition = "boolean default false")
    private Boolean statusSupplier;

    public Supplier(Integer idSupplier, Integer codeSupplier, String nameSupplier, String addressSupplier, String phoneNumberSupplier, String emailSupplier, Boolean statusSupplier) {
        this.idSupplier = idSupplier;
        this.codeSupplier = codeSupplier;
        this.nameSupplier = nameSupplier;
        this.addressSupplier = addressSupplier;
        this.phoneNumberSupplier = phoneNumberSupplier;
        this.emailSupplier = emailSupplier;
        this.statusSupplier = statusSupplier;
    }
}
