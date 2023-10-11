package com.example.c4zone.model.product;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<Image> images = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "id_capacity", referencedColumnName = "idCapacity")
    private Capacity capacity;
    @ManyToOne
    @JoinColumn(name = "id_cpu", referencedColumnName = "idCpu")
    private Cpu cpu;
    @ManyToOne
    @JoinColumn(name = "id_ram", referencedColumnName = "idRam")
    private Ram ram;
    @ManyToOne
    @JoinColumn(name = "id_color", referencedColumnName = "idColor")
    private Color color;
    @ManyToOne
    @JoinColumn(name = "id_type", referencedColumnName = "idType")
    private Type type;


}
