package com.wojduki.kalkulator.model;

import jakarta.persistence.*;

@Entity
public class Material extends Cost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String unit;
    private double unitPrice;
    private double consumptionPerM2;

    public Material() {
        super();
    }

    public Material(Long id, String name, String unit, double consumptionPerM2, double unitPrice, Rodzaj rodzaj) {
        super(name, rodzaj);
        this.unit = unit;
        this.consumptionPerM2 = consumptionPerM2;
        this.unitPrice = unitPrice;
        pricePerM2 = consumptionPerM2 * unitPrice;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public void setConsumptionPerM2(double consumptionPerM2) {
        this.consumptionPerM2 = consumptionPerM2;
    }

    public String getUnit() {
        return unit;
    }
    public double getUnitPrice() {
        return unitPrice;
    }
    public double getConsumptionPerM2() {
        return consumptionPerM2;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
}
