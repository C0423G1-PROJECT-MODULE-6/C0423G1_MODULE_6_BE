package com.example.c4zone.model.product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product")
    private long idProduct;
    private String nameProduct;
    private String screenProduct;
    private String cameraProduct;
    private String descriptionProduct;
    private boolean statusBusiness;
    private String selfieProduct;
    private String batteryProduct;
    private double weightProduct;
    private double quantityProduct;
    @ManyToOne
    @JoinColumn(name = "id_capacity",referencedColumnName = "id_capacity")
    private Capacity capacity;
    @ManyToOne
    @JoinColumn(name = "id_cpu",referencedColumnName = "id_cpu")
    private Cpu cpu;
    @ManyToOne
    @JoinColumn(name = "id_ram",referencedColumnName = "id_ram")
    private Ram ram;
    @ManyToOne
    @JoinColumn(name = "id_color",referencedColumnName = "id_color")
    private Color color;
    @ManyToOne
    @JoinColumn(name = "id_type",referencedColumnName = "id_type")
    private Type type;


}
