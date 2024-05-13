package com.wojduki.kalkulator.model;

public class AtticRoom extends Room {

    protected double slant, wysKolankowej;
    protected double b;
    public AtticRoom(double width, double length, double height, double slant, double wysKolankowej) {
        super(width, length, height);
        this.slant = slant;
        this.wysKolankowej=wysKolankowej;
    }

    @Override
    protected void calculateWallsArea() {
        double a = height -wysKolankowej;
        b = Math.sqrt((slant * slant) - (a * a));
        double triangleArea= (0.5*a)* b;
        if(triangleArea==0) {
            System.out.println("Powierzchnia trójkąta równa zero!");
        }
        //a to długość wzdłuż skosu
        else wallsArea = width * height + ((length * height - triangleArea) * 2) + slant * width + wysKolankowej* width;
    }
    @Override
    protected void calculateCeilingArea() {
        ceilingArea = width *(length - b);
    }

}
