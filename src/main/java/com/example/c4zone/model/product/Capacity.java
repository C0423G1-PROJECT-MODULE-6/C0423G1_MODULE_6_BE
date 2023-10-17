package com.example.c4zone.model.product;

import javax.persistence.*;

@Entity
public class Capacity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCapacity;
    private String name;
    private Boolean statusCapacity = true;

    public Capacity() {
    }

    public Capacity(Long idCapacity, String name, Boolean statusCapacity) {
        this.idCapacity = idCapacity;
        this.name = name;
        this.statusCapacity = statusCapacity;
    }

    public Long getIdCapacity() {
        return idCapacity;
    }

    public void setIdCapacity(Long idCapacity) {
        this.idCapacity = idCapacity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getStatusCapacity() {
        return statusCapacity;
    }

    public void setStatusCapacity(Boolean statusCapacity) {
        this.statusCapacity = statusCapacity;
    }
}
