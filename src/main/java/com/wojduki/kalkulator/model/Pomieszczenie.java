package com.wojduki.kalkulator.model;

public abstract class Pomieszczenie {

    protected double width, dlugosc, wysokosc;
    protected double wallsArea, ceilingArea, floorArea;

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

    protected void calculateFloorArea() {
        floorArea = width * dlugosc;}

    protected abstract void calculateWallsArea();

    protected abstract void calculateCeilingArea();

    public double getFloorArea() {return floorArea;}

    public double getWallsArea() {return wallsArea;}

    public double getCeilingArea() {return ceilingArea;}
}
