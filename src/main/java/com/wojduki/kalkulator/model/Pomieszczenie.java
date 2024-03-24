package com.wojduki.kalkulator.model;

public abstract class Pomieszczenie {

    protected double width, dlugosc, wysokosc;
    protected double powScian, powSufitu, powPodlogi;

    public Pomieszczenie(double width, double dlugosc, double wysokosc) {
        this.width = width;
        this.dlugosc = dlugosc;
        this.wysokosc = wysokosc;
    }

    public final void calculate() {
        calculateFloorArea();
        calculateWallsArea();
        calculateCeilingArea();
    }

    protected void calculateFloorArea() {powPodlogi= width * dlugosc;}

    protected abstract void calculateWallsArea();

    protected abstract void calculateCeilingArea();

    public double getFloorArea() {return powPodlogi;}

    public double getWallsArea() {return powScian;}

    public double getCeilingArea() {return powSufitu;}
}
