package com.wojduki.kalkulator.repository;

import com.wojduki.kalkulator.model.Material;
import com.wojduki.kalkulator.model.Type;
import java.util.Collection;

public class DBMaterialRepo implements CostRepo<Material>{

    public void createMaterial(String name, String jednostka, double zuzycieNaM2, double cenaJedn, Type type) {
    }
    @Override
    public void createCost(Material material){
    }
    @Override
    public void updateCost(Integer id,Material material){}

    @Override
    public Collection<Material> getAllCosts() {
        return null;
    }

    @Override
    public Material getCostById(Integer id) {
        return null;
    }

    @Override
    public void deleteCost(Integer id) {
    }

    @Override
    public void build() {
    }
}
