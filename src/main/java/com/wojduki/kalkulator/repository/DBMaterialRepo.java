package com.wojduki.kalkulator.repository;

import com.wojduki.kalkulator.model.Material;
import com.wojduki.kalkulator.model.Rodzaj;
import java.util.Collection;

public class DBMaterialRepo implements MaterialRepo{
    @Override
    public void createMaterial(String name, String jednostka, double zuzycieNaM2, double cenaJedn, Rodzaj rodzaj) {
    }
    @Override
    public void createMaterial(Material material){
    }
    @Override
    public void saveMaterialChanges(Material material){}

    @Override
    public Collection<Material> getAllMaterials() {
        return null;
    }

    @Override
    public Material getMaterialById(Integer id) {
        return null;
    }

    @Override
    public void deleteMaterial(Integer id) {
    }

    @Override
    public void build() {
    }
}
