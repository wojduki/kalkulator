package com.wojduki.kalkulator.model;

public class AtticRoom extends Room {

    protected double bokSkosu, wysKolankowej;
    protected double przyprosB;
    public AtticRoom(double width, double dlugosc, double wysokosc, double bokSkosu, double wysKolankowej) {
        super(width, dlugosc, wysokosc);
        this.bokSkosu=bokSkosu;
        this.wysKolankowej=wysKolankowej;
    }

    @Override
    protected void calculateWallsArea() {
        double przyprosA= wysokosc -wysKolankowej;
        przyprosB = Math.sqrt((bokSkosu * bokSkosu) - (przyprosA * przyprosA));
        double powTrojkat= (0.5*przyprosA)*przyprosB;
        if(powTrojkat==0) {
            System.out.println("Powierzchnia trójkąta równa zero!");
        }
        //a to długość wzdłuż skosu
        else wallsArea = width * wysokosc + ((dlugosc * wysokosc - powTrojkat) * 2) + bokSkosu* width + wysKolankowej* width;
    }
    @Override
    protected void calculateCeilingArea() {
        ceilingArea = width *(dlugosc -przyprosB);
    }

}
