package com.example.c4zone.model.supplier;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "supplier")
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_supplier")
    private Long idSupplier;
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
}
