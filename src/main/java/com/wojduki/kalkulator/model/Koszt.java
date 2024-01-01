package com.wojduki.kalkulator.model;

public abstract class Koszt {
    protected String nazwa;
    protected double cenaZaM2;

    public abstract String getNazwa();

    public abstract double getCenaZaM2();
}
