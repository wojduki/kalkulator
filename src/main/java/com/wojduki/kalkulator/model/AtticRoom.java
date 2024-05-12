package com.wojduki.kalkulator.model;

public class AtticRoom extends Room {

    protected double bokSkosu, wysKolankowej;
    protected double przyprosB;
    public AtticRoom(double width, double length, double height, double bokSkosu, double wysKolankowej) {
        super(width, length, height);
        this.bokSkosu=bokSkosu;
        this.wysKolankowej=wysKolankowej;
    }

    @Override
    protected void calculateWallsArea() {
        double przyprosA= height -wysKolankowej;
        przyprosB = Math.sqrt((bokSkosu * bokSkosu) - (przyprosA * przyprosA));
        double powTrojkat= (0.5*przyprosA)*przyprosB;
        if(powTrojkat==0) {
            System.out.println("Powierzchnia trójkąta równa zero!");
        }
        //a to długość wzdłuż skosu
        else wallsArea = width * height + ((length * height - powTrojkat) * 2) + bokSkosu* width + wysKolankowej* width;
    }
    @Override
    protected void calculateCeilingArea() {
        ceilingArea = width *(length -przyprosB);
    }

}
