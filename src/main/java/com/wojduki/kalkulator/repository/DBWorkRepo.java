package com.wojduki.kalkulator.repository;

import com.wojduki.kalkulator.model.Type;
import com.wojduki.kalkulator.model.Work;
import java.util.Collection;

public class DBWorkRepo implements CostRepo<Work>{

    public void createWork(String name, double pricePerM2, Type type) {
    }
    @Override
    public void createCost(Work work){
    }
    @Override
    public void updateCost(Integer id, Work work){}

    @Override
    public Collection<Work> getAllCosts() {
        return null;
    }

    @Override
    public Work getCostById(Integer id) {
        return null;
    }

    @Override
    public void deleteCost(Integer id) {
    }

    @Override
    public void build() {
    }
}

