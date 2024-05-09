package com.wojduki.kalkulator.services;

import com.wojduki.kalkulator.model.Material;
import com.wojduki.kalkulator.repository.MaterialRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class MaterialService {

    @Autowired
    MaterialRepo materialRepo;

    public List<Material> getAllMaterials() {
        return new ArrayList<>(materialRepo.getAllMaterials());
    }
    public Material getMaterialById(Integer id) {
        return materialRepo.getMaterialById(id);
    }
    public void saveMaterial(Material material) {
        materialRepo.createMaterial(material);
    }

    public void saveMaterialChanges(Material material) {
        materialRepo.saveMaterialChanges(material);
    }
    public void deleteMaterial(Integer id) {
        materialRepo.deleteMaterial(id);
    }

    public void calculateMaterials (double area, List<Integer> idList) {
        for(Integer id : idList) {
            String name = (materialRepo.getMaterialById(id)).getName();
            double price = (materialRepo.getMaterialById(id)).getPricePerM2();
            System.out.println("Koszt materiału: "+id+" "+name+" = "+(area * price)+" zł");
        }
        System.out.println("----------------------------");
    }
}
