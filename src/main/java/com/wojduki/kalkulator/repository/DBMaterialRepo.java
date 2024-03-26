package com.wojduki.kalkulator.repository;

import com.wojduki.kalkulator.model.Material;
import com.wojduki.kalkulator.model.Rodzaj;
import org.springframework.stereotype.Repository;

import java.util.Collection;
@Repository
public class DBMaterialRepo implements MaterialRepo{
    @Override
    public void createMaterial(String name, String jednostka, double zuzycieNaM2, double cenaJedn, Rodzaj rodzaj) {

    }

    @Override
    public Collection<Material> getAllMaterials() {
        return null;
    }

    @Override
    public Material getMaterial(String name) {
        return null;
    }

    @Override
    public void deleteMaterial(String name) {

    }

    @Override
    public void build() {

    }
}
