package com.wojduki.kalkulator.model;

public abstract class Pomieszczenie {

    protected double width, length, height;
    protected double wallsArea, ceilingArea, floorArea;

    public Pomieszczenie(double width, double length, double height) {
        this.width = width;
        this.length = length;
        this.height = height;
    }

    public final void calculate() {
        calculateFloorArea();
        calculateWallsArea();
        calculateCeilingArea();
    }

    protected void calculateFloorArea() {
        floorArea = width * length;}

    protected abstract void calculateWallsArea();

    protected abstract void calculateCeilingArea();

    public double getFloorArea() {return floorArea;}

    public double getWallsArea() {return wallsArea;}

    public double getCeilingArea() {return ceilingArea;}
}
