package com.wojduki.kalkulator.repository;

import com.wojduki.kalkulator.model.Material;
import com.wojduki.kalkulator.model.Rodzaj;
import java.util.Collection;

public interface MaterialRepo {

    void createMaterial(String name, String jednostka, double zuzycieNaM2, double cenaJedn, Rodzaj rodzaj);

    Collection<Material> getAllMaterials();

    Material getMaterial(String name);

    void deleteMaterial(String name);

    void build();
}

