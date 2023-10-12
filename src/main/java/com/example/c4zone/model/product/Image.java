package com.example.c4zone.model.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idImage;
    @Column(columnDefinition = "LONGTEXT")
    private String name;
    private Boolean statusImage = true;
    @ManyToOne
    @JoinColumn(name = "id_product",referencedColumnName = "idProduct")
    private Product product;

}
