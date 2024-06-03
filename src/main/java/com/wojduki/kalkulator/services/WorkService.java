package com.wojduki.kalkulator.services;

import com.wojduki.kalkulator.model.Room;
import com.wojduki.kalkulator.model.Work;
import com.wojduki.kalkulator.repository.CostRepo;
import com.wojduki.kalkulator.repository.SelectedItemsHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class WorkService {
    @Autowired
    CostRepo<Work> workRepo;
    ArrayList<String> results= new ArrayList<>();

    public List<Work> getAllWorks() {
        return new ArrayList<>(workRepo.getAllCosts());
    }
    public Work getWorkById(Integer id) {
        return workRepo.getCostById(id);
    }
    public void saveNewWork(Work work) {
        workRepo.createCost(work);
    }

    public void saveWorkChanges(Work work) {
        workRepo.saveCostChanges(work);
    }
    public void deleteWork(Integer id) {
        workRepo.deleteCost(id);
    }

    public void calculateWorks (Room room, SelectedItemsHolder selectedItemsHolder) {
        results.clear();
        calculateFloorWorks(room, selectedItemsHolder);
        results.add("----------------------------");
        calculateWallsWorks(room, selectedItemsHolder);
        results.add("----------------------------");
        calculateCeilingWorks(room, selectedItemsHolder);
        }

    public void calculateFloorWorks(Room room, SelectedItemsHolder selectedItemsHolder) {
        for (Integer id : selectedItemsHolder.getFloorItemsIds()) {
            String name = (workRepo.getCostById(id)).getName();
            double price = (workRepo.getCostById(id)).getPricePerM2();
            String result = (id + " " + name + " = " + (room.getFloorArea() * price) + " zł");
            results.add(result);
        }
    }
    public void calculateWallsWorks(Room room, SelectedItemsHolder selectedItemsHolder) {
        for (Integer id : selectedItemsHolder.getWallsItemsIds()) {
            String name = (workRepo.getCostById(id)).getName();
            double price = (workRepo.getCostById(id)).getPricePerM2();
            String result = (id + " " + name + " = " + (room.getWallsArea() * price) + " zł");
            results.add(result);
        }
    }
    public void calculateCeilingWorks(Room room, SelectedItemsHolder selectedItemsHolder) {
        for (Integer id : selectedItemsHolder.getCeilingItemsIds()) {
            String name = (workRepo.getCostById(id)).getName();
            double price = (workRepo.getCostById(id)).getPricePerM2();
            String result = (id + " " + name + " = " + (room.getCeilingArea() * price) + " zł");
            results.add(result);
        }
    }
    public ArrayList<String> getResults() {
        return results;
    }
}
