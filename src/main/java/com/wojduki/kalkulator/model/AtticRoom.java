package com.wojduki.kalkulator.model;

public class AtticRoom extends Room {

    protected double bokSkosu, wysKolankowej;
    protected double przyprosB;
    public AtticRoom(double szerokosc, double dlugosc, double wysokosc, double bokSkosu, double wysKolankowej) {
        super(szerokosc, dlugosc, wysokosc);
        this.bokSkosu=bokSkosu;
        this.wysKolankowej=wysKolankowej;
    }

    @Override
    protected void liczPowScian() {
        double przyprosA= wysokosc -wysKolankowej;
        przyprosB = Math.sqrt((bokSkosu * bokSkosu) - (przyprosA * przyprosA));
        double powTrojkat= (0.5*przyprosA)*przyprosB;
        if(powTrojkat==0) {
            System.out.println("Powierzchnia trójkąta równa zero!");
        }
        //a to długość wzdłuż skosu
        else powScian = szerokosc * wysokosc + ((dlugosc * wysokosc - powTrojkat) * 2) + bokSkosu* szerokosc + wysKolankowej* szerokosc;
    }
    @Override
    protected void liczPowSufitu() {
        powSufitu= szerokosc *(dlugosc -przyprosB);
    }

}
