package com.wojduki.kalkulator.repository;

import com.wojduki.kalkulator.model.Rodzaj;
import java.util.Collection;

public interface CostRepo<T> {
    void createCost(String nazwa, double pricePerM2, Rodzaj rodzaj);
    //void createCost(String name, String jednostka, double zuzycieNaM2, double cenaJedn, Rodzaj rodzaj);
    void createCost(T cost);
    Collection<T> getAllCosts();
    void saveCostChanges(T cost);

    T getCostById(Integer id);

    void deleteCost(Integer id);

    void build();
}
