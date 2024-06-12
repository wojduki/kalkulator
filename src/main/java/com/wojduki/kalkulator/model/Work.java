package com.wojduki.kalkulator.model;

import jakarta.persistence.*;

@Entity
public class Work extends Cost {

    public Work(String name, double pricePerM2, Type type) {
        super(name, pricePerM2, type);
    }

    public Work() {
        super();
    }
}
