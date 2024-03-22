package com.wojduki.kalkulator.model;

import jakarta.persistence.*;

@Entity
public class Material extends Cost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String jednostka;
    private double cenaJedn;
    private double zuzycieNaM2;

    public Material() {
        super();
    }

    public Material(String nazwa, String jednostka, double zuzycieNaM2, double cenaJedn, Rodzaj rodzaj) {
        super(nazwa, rodzaj);
        this.jednostka=jednostka;
        this.zuzycieNaM2 = zuzycieNaM2;
        this.cenaJedn = cenaJedn;
        pricePerM2 =zuzycieNaM2*cenaJedn;
    }

    public String getJednostka() {
        return jednostka;
    }
    public double getCenaJedn() {
        return cenaJedn;
    }
    public double getZuzycieNaM2() {
        return zuzycieNaM2;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
}
