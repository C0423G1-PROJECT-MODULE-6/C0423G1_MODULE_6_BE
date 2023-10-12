package com.example.c4zone.model.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
<<<<<<< HEAD
    private long idProduct;
=======
    private Long idProduct;
>>>>>>> 63942a3a1008093c285f9019baf18abe1c55a8b4
    private String nameProduct;
    private String screenProduct;
    private String cameraProduct;
    private String descriptionProduct;
    private Boolean statusBusiness = true;
    private String selfieProduct;
    private String batteryProduct;
<<<<<<< HEAD
    private double weightProduct;
    private double quantityProduct;
    private double priceProduct;
=======
    private Double weightProduct;
    private Double quantityProduct;
    private Double priceProduct;
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<Image> images = new ArrayList<>();
>>>>>>> 63942a3a1008093c285f9019baf18abe1c55a8b4
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
<<<<<<< HEAD
=======
    @ManyToOne
    @JoinColumn(name = "id_series", referencedColumnName = "idSeries")
    private Series series;
>>>>>>> 63942a3a1008093c285f9019baf18abe1c55a8b4
}
