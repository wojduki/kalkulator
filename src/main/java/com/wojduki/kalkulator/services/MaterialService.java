package com.wojduki.kalkulator.services;

import com.wojduki.kalkulator.model.Material;
import com.wojduki.kalkulator.model.Room;
import com.wojduki.kalkulator.repository.MaterialRepo;
import com.wojduki.kalkulator.repository.SelectedMaterialsHolder;
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

    public void calculateMaterials (Room room, SelectedMaterialsHolder selectedMaterialsHolder) {
        for(Integer id : selectedMaterialsHolder.getFloorMaterialsIds()) {
            double area = room.getFloorArea();
            double price = (materialRepo.getMaterialById(id)).getPricePerM2();
            System.out.println("Cena materiału podłoga: "+ (area * price) + " zł");
        }
    }
}
