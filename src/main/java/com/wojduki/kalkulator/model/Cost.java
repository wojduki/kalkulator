package com.wojduki.kalkulator.model;

import jakarta.persistence.*;
import org.hibernate.validator.constraints.NotEmpty;
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Cost {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotEmpty(message = "Pole nie może być puste!")
    protected String name;
    @NotEmpty(message = "Pole nie może być puste!")
    protected double pricePerM2;

    protected Type type;

    public Cost(String name, double pricePerM2, Type type) {
        this.name = name;
        this.pricePerM2 = pricePerM2;
        this.type = type;
    }

    public Cost(String name, Type type) {
        this.name = name;
        this.type = type;
    }

    public Cost() {
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setPricePerM2(double pricePerM2) {
        this.pricePerM2 = pricePerM2;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getName(){return name;}
    public double getPricePerM2() {return pricePerM2;}
    public Type getType() {return type;}
}
