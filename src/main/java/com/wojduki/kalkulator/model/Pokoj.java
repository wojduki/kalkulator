package com.wojduki.kalkulator.model;

public class Pokoj extends Pomieszczenie {

    public Pokoj(double szerokosc, double dlugosc, double wysokosc) {
        super(szerokosc, dlugosc, wysokosc);
    }

    @Override
    protected void liczPowSufitu() {powSufitu= szerokosc * dlugosc;}

    @Override
    protected void liczPowScian() {
        powScian = ((szerokosc * wysokosc) + (dlugosc * wysokosc)) * 2;
    }

}
