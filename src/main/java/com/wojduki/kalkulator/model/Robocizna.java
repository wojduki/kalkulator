package com.wojduki.kalkulator.model;

import jakarta.persistence.*;

@Entity
public class Robocizna extends Cost {

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
}
