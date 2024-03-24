package com.wojduki.kalkulator.model;

import jakarta.persistence.*;

@Entity
public class Work extends Cost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    public Work(String nazwa, double cenaZaM2, Rodzaj rodzaj) {
        super(nazwa, cenaZaM2, rodzaj);
    }

    public Work() {
    }
}
