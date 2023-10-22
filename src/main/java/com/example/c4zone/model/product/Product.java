package com.example.c4zone.model.product;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.json.JSONObject;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduct;
    private String nameProduct;
    private String screenProduct;
    private String cameraProduct;
    @Column(columnDefinition = "LONGTEXT")
    private String descriptionProduct;
    private Boolean statusBusiness = true;
    private String selfieProduct;
    private String batteryProduct;
    private String weightProduct;
    @Column(columnDefinition = "bigint")
    private Long quantityProduct;
    private Double priceProduct;

    @OneToMany(mappedBy = "product")
    @JsonBackReference
    private List<Image> images;

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

    @ManyToOne
    @JoinColumn(name = "id_series", referencedColumnName = "idSeries")
    private Series series;

    public String toStringQR() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", String.valueOf(idProduct));
        jsonObject.put("nameProduct", nameProduct);
        return jsonObject.toString();
    }

}


