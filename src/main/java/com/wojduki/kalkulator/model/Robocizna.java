package com.wojduki.kalkulator.model;

public class Robocizna extends Koszt {

    public Robocizna(String nazwa, double cenaZaM2) {
        this.nazwa=nazwa;
        this.cenaZaM2 = cenaZaM2;
    }
    @Override
    public String getNazwa() {return nazwa;}
    @Override
    public double getCenaZaM2() {return cenaZaM2;}

}
