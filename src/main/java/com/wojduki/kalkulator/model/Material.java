package com.wojduki.kalkulator.model;

import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
public class Material extends Koszt{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String jednostka;
    private double cenaJedn;
    private double zuzycieNaM2;
    private Rodzaj rodzaj;

    public Material() {
    }

    public Material(String nazwa, String jednostka, double zuzycieNaM2, double cenaJedn, Rodzaj rodzaj) {
        this.nazwa=nazwa;
        this.jednostka=jednostka;
        this.zuzycieNaM2 = zuzycieNaM2;
        this.cenaJedn = cenaJedn;
        this.rodzaj = rodzaj;
        cenaZaM2=zuzycieNaM2*cenaJedn;
    }

    @Override
    public String getNazwa() {return nazwa;}

    @Override
    public double getCenaZaM2() {return cenaZaM2;}

    public String getJednostka() {
        return jednostka;
    }

    public double getCenaJedn() {
        return cenaJedn;
    }

    public double getZuzycieNaM2() {
        return zuzycieNaM2;
    }

    public Rodzaj getRodzaj() {return rodzaj;}
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
