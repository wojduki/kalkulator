package com.wojduki.kalkulator.model;

import jakarta.persistence.*;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Size;
@Entity
public class Material extends Cost {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;
    @NotEmpty(message = "Pole nie może być puste!")
    @Size(min=1, max=5,message = "Podaj więcej niż 1 znak, a mniej niż 5")
    private String unit;
    @NotEmpty(message = "Pole nie może być puste!")
    private double unitPrice;
    @NotEmpty(message = "Pole nie może być puste!")
    private double consumptionPerM2;

    public Material() {
        super();
    }

    public Material(String name, String unit, double consumptionPerM2, double unitPrice, Type type) {
        super(name, type);
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

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
}
