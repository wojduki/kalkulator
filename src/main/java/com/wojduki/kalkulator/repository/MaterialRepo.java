package com.wojduki.kalkulator.repository;

import com.wojduki.kalkulator.model.Material;
import com.wojduki.kalkulator.model.Rodzaj;
import java.util.Collection;

public interface MaterialRepo {

    void createMaterial(String name, String jednostka, double zuzycieNaM2, double cenaJedn, Rodzaj rodzaj);

    void createMaterial(Material material);
    Collection<Material> getAllMaterials();
    void saveMaterialChanges(Material material);

    Material getMaterialById(Integer id);

    void deleteMaterial(Integer id);

    void build();
}

