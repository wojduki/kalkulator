package com.wojduki.kalkulator.repository;

import com.wojduki.kalkulator.model.Material;
import com.wojduki.kalkulator.model.Rodzaj;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Collection;

public interface MaterialRepo {

    void createMaterial(String name, String jednostka, double zuzycieNaM2, double cenaJedn, Rodzaj rodzaj);

    void createMaterial(Material material);
    Collection<Material> getAllMaterials();
    void saveMaterialChanges(Integer id, Material material);

    Material getMaterialById(Integer id);

    void deleteMaterial(Integer id);

    void build();
}

