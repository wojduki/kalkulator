package com.wojduki.kalkulator.model;

import jakarta.persistence.*;

@Entity
public class Work extends Cost {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    public Work(String nazwa, double pricePerM2, Type type) {
        super(nazwa, pricePerM2, type);
    }

    public Work() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
