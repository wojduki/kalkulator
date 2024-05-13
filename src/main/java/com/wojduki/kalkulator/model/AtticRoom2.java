package com.wojduki.kalkulator.model;

public class AtticRoom2 extends AtticRoom {

    protected double slant2, wysKolankowej2;
    protected double b2;
    public AtticRoom2(double width, double length, double height, double slant, double wysKolankowej, double slant2, double wysKolankowej2) {
        super(width, length, height, slant, wysKolankowej);
        this.slant2 = slant2;
        this.wysKolankowej2=wysKolankowej2;
    }

    @Override
    protected void calculateWallsArea() {
        double a = height -wysKolankowej;
        b = Math.sqrt((slant * slant) - (a * a));
        double triangleArea= (0.5*a)* b;

        double a2 = height -wysKolankowej2;
        b2 = Math.sqrt((slant2 * slant2) - (a2 * a2));
        double triangleArea2= (0.5*a2)* b2;
        
        if(triangleArea==0) {
            System.out.println("Powierzchnia trójkąta równa zero!");
        } else if (triangleArea2==0) {
            System.out.println("Powierzchnia trójkąta2 równa zero!");
        }
        //a to długość wzdłuż skosu
        else wallsArea = ((length * height - triangleArea-triangleArea2) * 2)+ slant * width +wysKolankowej* width + slant2 * width +wysKolankowej2* width;
    }
    @Override
    protected void calculateCeilingArea() {
        ceilingArea = width *(length - b - b2);
    }

}
