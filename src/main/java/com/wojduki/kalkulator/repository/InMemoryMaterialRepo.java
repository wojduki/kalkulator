package com.wojduki.kalkulator.repository;

import com.wojduki.kalkulator.model.Material;
import com.wojduki.kalkulator.model.Type;
import jakarta.annotation.PostConstruct;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class InMemoryMaterialRepo implements CostRepo<Material> {
    Map<Integer, Material> materials = new HashMap<>();

    public InMemoryMaterialRepo() {
    }

    public void createMaterial(String name, String unit, double consumptionPerM2, double unitPrice, Type type) {
        Material newMaterial= new Material(name, unit, consumptionPerM2, unitPrice, type);
        newMaterial.setId(getNewId());
        materials.put(newMaterial.getId(), newMaterial);
    }
    @Override
    public void createCost(Material material) {
        material.setId(getNewId());
        materials.put(material.getId(), material);
    }
    @Override
    public void saveCostChanges(Material material) {
        materials.replace(material.getId(), material);
    }
    @Override
    public Collection<Material> getAllCosts() {
        return materials.values();
    }

    @Override
    public Material getCostById(Integer id) {
        return materials.get(id);
    }

    @Override
    public void deleteCost(Integer id) {materials.remove(id);}

    @Override
    @PostConstruct
    public void build() {
        createMaterial("Klej", "kg", 2.5, 14, Type.PODLOGA);
        createMaterial("Płytki", "szt.", 4, 40, Type.PODLOGA);
        createMaterial("Grunt", "l", 0.3, 12, Type.SCIANY);
        createMaterial("Farba", "l", 0.2, 15, Type.SCIANY);
        createMaterial("Tapeta", "m.b.", 1, 30, Type.SCIANY);
        createMaterial("Tynk", "worek", 1, 16, Type.SCIANY);
        createMaterial("Gips", "kg", 1.0, 15, Type.SUFIT);
    }

    @Override
    public String toString() {
        return "InMemoryRepository{" +
                "materials=" + materials +
                '}';
    }
    public Integer getNewId() {
        if (materials.isEmpty()) {
            return 1;
        }
        else {
            Integer integer = materials.keySet().stream().max(Comparator.naturalOrder()).get();
            return integer+1;
        }
    }
}
