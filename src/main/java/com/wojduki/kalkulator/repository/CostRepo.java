package com.wojduki.kalkulator.repository;

import com.wojduki.kalkulator.model.Cost;
import com.wojduki.kalkulator.model.Rodzaj;
import com.wojduki.kalkulator.model.Work;

import java.util.Collection;

public interface CostRepo {
    void createCost(String nazwa, double pricePerM2, Rodzaj rodzaj);
    void createCost(String name, String jednostka, double zuzycieNaM2, double cenaJedn, Rodzaj rodzaj);
    void createCost(Cost cost);
    Collection<Cost> getAllCosts();
    void saveCostChanges(Cost cost);

    Work getCostById(Integer id);

    void deleteCost(Integer id);

    void build();
}
