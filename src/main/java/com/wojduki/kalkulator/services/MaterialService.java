package com.wojduki.kalkulator.services;

import com.wojduki.kalkulator.model.Material;
import com.wojduki.kalkulator.model.Room;
import com.wojduki.kalkulator.model.Type;
import com.wojduki.kalkulator.model.Work;
import com.wojduki.kalkulator.repository.CostRepo;
import com.wojduki.kalkulator.repository.SelectedItemsHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MaterialService {

    @Autowired
    CostRepo<Material> materialRepo;
    ArrayList<String> results= new ArrayList<>();

    public List<Material> getAllMaterials() {
        return new ArrayList<>(materialRepo.getAllCosts());
    }
    public List<Material> getFloorMaterials(){
        return materialRepo.getAllCosts().stream().filter(material -> material.getType()== Type.FLOOR).collect(Collectors.toList());
    }
    public List<Material> getWallsMaterials(){
        return materialRepo.getAllCosts().stream().filter(material -> material.getType()==Type.WALLS).collect(Collectors.toList());
    }
    public List<Material> getCeilingMaterials(){
        return materialRepo.getAllCosts().stream().filter(material -> material.getType()==Type.CEILING).collect(Collectors.toList());
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

    public void calculateMaterials(Room room, SelectedItemsHolder selectedItemsHolder) {
        results.clear();
        calculateSingleMaterials(room.getFloorArea(), selectedItemsHolder.getFloorItemsIds());
        results.add("----------------------------");
        calculateSingleMaterials(room.getWallsArea(), selectedItemsHolder.getWallsItemsIds());
        results.add("----------------------------");
        calculateSingleMaterials(room.getCeilingArea(), selectedItemsHolder.getCeilingItemsIds());
    }
    public void calculateSingleMaterials (double area, List<Integer> idList) {
        for(Integer id : idList) {
            String name = (materialRepo.getCostById(id)).getName();
            double price = (materialRepo.getCostById(id)).getPricePerM2();
            String result = (id+" "+name+" Koszt= "+(area * price)+" zł");
            results.add(result);
        }
    }
    public ArrayList<String> getResults() {
        return results;
    }
}
