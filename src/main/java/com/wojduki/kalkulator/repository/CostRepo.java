package com.wojduki.kalkulator.repository;

import java.util.Collection;

public interface CostRepo<T> {
    void createCost(T cost);
    Collection<T> getAllCosts();
    void saveCostChanges(T cost);
    T getCostById(Integer id);
    void deleteCost(Integer id);
    void build();
}
