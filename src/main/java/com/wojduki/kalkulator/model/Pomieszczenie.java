package com.wojduki.kalkulator.model;

public abstract class Pomieszczenie {

    protected double szerokosc, dlugosc, wysokosc;
    protected double powScian, powSufitu, powPodlogi;

    public Pomieszczenie(double szerokosc, double dlugosc, double wysokosc) {
        this.szerokosc = szerokosc;
        this.dlugosc = dlugosc;
        this.wysokosc = wysokosc;
    }

    public final void wyliczaj() {
        liczPowPodlogi();
        liczPowScian();
        liczPowSufitu();
    }

    protected void liczPowPodlogi() {powPodlogi= szerokosc * dlugosc;}

    protected abstract void liczPowScian();

    protected abstract void liczPowSufitu();
    public double getPowPodlogi() {return powPodlogi;}

    public double getPowScian() {return powScian;}

    public double getPowSufitu() {return powSufitu;}
}
