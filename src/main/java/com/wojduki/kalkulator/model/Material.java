package com.wojduki.kalkulator.model;

public class Material extends Koszt{
    private final String jednostka;
    private final double cenaJedn;
    private final double zuzycieNaM2;
    private final Rodzaj rodzaj;

    public Material(String nazwa, String jednostka, double zuzycieNaM2, double cenaJedn, Rodzaj rodzaj) {
        this.nazwa=nazwa;
        this.jednostka=jednostka;
        this.zuzycieNaM2 = zuzycieNaM2;
        this.cenaJedn = cenaJedn;
        this.rodzaj = rodzaj;
        cenaZaM2=zuzycieNaM2*cenaJedn;
    }
    @Override
    public String getNazwa() {return nazwa;}

    @Override
    public double getCenaZaM2() {return cenaZaM2;}

    public String getJednostka() {
        return jednostka;
    }

    public double getCenaJedn() {
        return cenaJedn;
    }

    public double getZuzycieNaM2() {
        return zuzycieNaM2;
    }

    public Rodzaj getRodzaj() {return rodzaj;}
}
