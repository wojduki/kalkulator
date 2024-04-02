package com.wojduki.kalkulator.repository;

import com.wojduki.kalkulator.model.Material;
import com.wojduki.kalkulator.model.Rodzaj;
import jakarta.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class InMemoryMaterialRepo implements MaterialRepo {

    Map<Long, Material> materials = new HashMap<>();

    public InMemoryMaterialRepo() {
    }

    @Override
    public void createMaterial(Long id, String name, String unit, double consumptionPerM2, double unitPrice, Rodzaj rodzaj) {
        materials.put(id, new Material(id, name, unit, consumptionPerM2, unitPrice, rodzaj));
    }
    @Override
    public void createMaterial(Material material) {
        materials.put(material.getId(), material);
    }
    @Override
    public Collection<Material> getAllMaterials() {
        return materials.values();
    }

    @Override
    public Material getMaterial(String name) {
        return materials.get(name);
    }

    @Override
    public void deleteMaterial(String name) {
        materials.remove(name);
    }

    @Override
    @PostConstruct
    public void build() {
        createMaterial(null, "Klej", "kg", 2.5, 14, Rodzaj.PODLOGA);
        createMaterial(null, "Płytki", "szt.", 4, 40, Rodzaj.PODLOGA);
        createMaterial(null, "Grunt", "l", 0.3, 12, Rodzaj.SCIANY);
        createMaterial(null, "Farba", "l", 0.2, 15, Rodzaj.SCIANY);
        createMaterial(null, "Tapeta", "m.b.", 1, 30, Rodzaj.SCIANY);
        createMaterial(null, "Tynk", "worek", 1, 16, Rodzaj.SCIANY);
        createMaterial(null, "Gips", "kg", 1.0, 15, Rodzaj.SUFIT);
    }

    @Override
    public String toString() {
        return "InMemoryRepository{" +
                "materials=" + materials +
                '}';
    }
}
