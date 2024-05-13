package com.wojduki.kalkulator.model;

public class Room extends Pomieszczenie {

    public Room(double width, double length, double height) {
        super(width, length, height);
    }

    @Override
    protected void calculateCeilingArea() {
        ceilingArea = width * length;}

    @Override
    protected void calculateWallsArea() {
        wallsArea = ((width * height) + (length * height)) * 2;
    }

}
