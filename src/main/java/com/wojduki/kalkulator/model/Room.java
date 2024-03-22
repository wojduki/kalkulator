package com.wojduki.kalkulator.model;

public class Room extends Pomieszczenie {

    public Room(double szerokosc, double dlugosc, double wysokosc) {
        super(szerokosc, dlugosc, wysokosc);
    }

    @Override
    protected void calculateCeilingArea() {powSufitu= szerokosc * dlugosc;}

    @Override
    protected void calculateWallsArea() {
        powScian = ((szerokosc * wysokosc) + (dlugosc * wysokosc)) * 2;
    }

}
