package com.wojduki.kalkulator.model;

import jakarta.persistence.*;

@Entity
public class Robocizna extends Koszt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    public Robocizna(String nazwa, double cenaZaM2) {
        this.nazwa=nazwa;
        this.cenaZaM2 = cenaZaM2;
    }

    public Robocizna() {
    }

    @Override
    public String getNazwa() {return nazwa;}
    @Override
    public double getCenaZaM2() {return cenaZaM2;}

}
