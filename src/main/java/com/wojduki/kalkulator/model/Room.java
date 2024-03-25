package com.wojduki.kalkulator.model;

public class Room extends Pomieszczenie {

    public Room(double width, double dlugosc, double wysokosc) {
        super(width, dlugosc, wysokosc);
    }

    @Override
    protected void calculateCeilingArea() {
        ceilingArea = width * dlugosc;}

    @Override
    protected void calculateWallsArea() {
        wallsArea = ((width * wysokosc) + (dlugosc * wysokosc)) * 2;
    }

}
