package com.wojduki.kalkulator.model;

public abstract class Cost {
    protected String name;
    protected double pricePerM2;
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
