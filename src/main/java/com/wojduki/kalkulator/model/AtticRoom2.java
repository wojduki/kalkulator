package com.wojduki.kalkulator.model;

public class AtticRoom2 extends AtticRoom {

    protected double bokSkosu2, wysKolankowej2;
    protected double przyprosB2;
    public AtticRoom2(double width, double dlugosc, double wysokosc, double bokSkosu, double wysKolankowej, double bokSkosu2, double wysKolankowej2) {
        super(width, dlugosc, wysokosc, bokSkosu, wysKolankowej);
        this.bokSkosu2=bokSkosu2;
        this.wysKolankowej2=wysKolankowej2;
    }

    @Override
    protected void calculateWallsArea() {
        double przyprosA= wysokosc -wysKolankowej;
        przyprosB = Math.sqrt((bokSkosu * bokSkosu) - (przyprosA * przyprosA));
        double powTrojkat= (0.5*przyprosA)*przyprosB;

        double przyprosA2= wysokosc -wysKolankowej2;
        przyprosB2 = Math.sqrt((bokSkosu2 * bokSkosu2) - (przyprosA2 * przyprosA2));
        double powTrojkat2= (0.5*przyprosA2)*przyprosB2;
        
        if(powTrojkat==0) {
            System.out.println("Powierzchnia trójkąta równa zero!");
        } else if (powTrojkat2==0) {
            System.out.println("Powierzchnia trójkąta2 równa zero!");
        }
        //a to długość wzdłuż skosu
        else wallsArea = ((dlugosc * wysokosc - powTrojkat-powTrojkat2) * 2)+bokSkosu* width +wysKolankowej* width +bokSkosu2* width +wysKolankowej2* width;
    }
    @Override
    protected void calculateCeilingArea() {
        ceilingArea = width *(dlugosc -przyprosB-przyprosB2);
    }

}
