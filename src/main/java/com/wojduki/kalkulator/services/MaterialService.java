package com.wojduki.kalkulator.services;

import com.wojduki.kalkulator.model.Material;
import com.wojduki.kalkulator.repository.CostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class MaterialService {

    @Autowired
    CostRepo<Material> materialRepo;

    String resultMaterial;

    public List<Material> getAllMaterials() {
        return new ArrayList<>(materialRepo.getAllCosts());
    }
    public Material getMaterialById(Integer id) {
        return materialRepo.getCostById(id);
    }
    public void saveNewMaterial(Material material) {
        materialRepo.createCost(material);
    }

    public void saveMaterialChanges(Material material) {
        materialRepo.saveCostChanges(material);
    }
    public void deleteMaterial(Integer id) {
        materialRepo.deleteCost(id);
    }

    public void calculateMaterials (double area, List<Integer> idList) {
        for(Integer id : idList) {
            String name = (materialRepo.getCostById(id)).getName();
            double price = (materialRepo.getCostById(id)).getPricePerM2();
            resultMaterial= (id+" "+name+" = "+(area * price)+" zł");
            System.out.println(resultMaterial);
        }
        System.out.println("----------------------------");
    }
    public String getResultMaterial() {
        return resultMaterial;
    }
}
