package com.wojduki.kalkulator.model;

public class Room extends Pomieszczenie {

    public Room(double width, double length, double wysokosc) {
        super(width, length, wysokosc);
    }

    @Override
    protected void calculateCeilingArea() {
        ceilingArea = width * length;}

    @Override
    protected void calculateWallsArea() {
        wallsArea = ((width * height) + (length * height)) * 2;
    }

}
