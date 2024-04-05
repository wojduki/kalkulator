package com.wojduki.kalkulator.model;

import org.hibernate.validator.constraints.NotEmpty;

public abstract class Cost {
    @NotEmpty(message = "Pole nie może być puste!")
    protected String name;
    @NotEmpty(message = "Pole nie może być puste!")
    protected double pricePerM2;
    @NotEmpty
    protected Rodzaj rodzaj;

    public Cost(String name, double pricePerM2, Rodzaj rodzaj) {
        this.name = name;
        this.pricePerM2 = pricePerM2;
        this.rodzaj = rodzaj;
    }

    public Cost(String name, Rodzaj rodzaj) {
        this.name = name;
        this.rodzaj = rodzaj;
    }

    public Cost() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPricePerM2(double pricePerM2) {
        this.pricePerM2 = pricePerM2;
    }

    public void setRodzaj(Rodzaj rodzaj) {
        this.rodzaj = rodzaj;
    }

    public String getName(){return name;}
    public double getPricePerM2() {return pricePerM2;}
    public Rodzaj getRodzaj() {return rodzaj;}
}
