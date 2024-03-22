package com.wojduki.kalkulator.model;

public abstract class Pomieszczenie {

    protected double szerokosc, dlugosc, wysokosc;
    protected double powScian, powSufitu, powPodlogi;

    public Pomieszczenie(double szerokosc, double dlugosc, double wysokosc) {
        this.szerokosc = szerokosc;
        this.dlugosc = dlugosc;
        this.wysokosc = wysokosc;
    }

    public final void calculate() {
        calculateFloorArea();
        calculateWallsArea();
        calculateCeilingArea();
    }

    protected void calculateFloorArea() {powPodlogi= szerokosc * dlugosc;}

    protected abstract void calculateWallsArea();

    protected abstract void calculateCeilingArea();

    public double getFloorArea() {return powPodlogi;}

    public double getWallsArea() {return powScian;}

    public double getCeilingArea() {return powSufitu;}
}
