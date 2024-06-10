package com.wojduki.kalkulator.services;

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
public class WorkService {
    @Autowired
    CostRepo<Work> workRepo;
    ArrayList<String> results= new ArrayList<>();

    public List<Work> getAllWorks() {
        return new ArrayList<>(workRepo.getAllCosts());
    }
    public List<Work> getFloorWorks(){
        return workRepo.getAllCosts().stream().filter(work -> work.getType()==Type.FLOOR).collect(Collectors.toList());
    }
    public List<Work> getWallsWorks(){
        return workRepo.getAllCosts().stream().filter(work -> work.getType()==Type.WALLS).collect(Collectors.toList());
    }
    public List<Work> getCeilingWorks(){
        return workRepo.getAllCosts().stream().filter(work -> work.getType()==Type.CEILING).collect(Collectors.toList());
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
        calculateSingleWorks(room.getFloorArea(), selectedItemsHolder.getFloorItemsIds());
        results.add("----------------------------");
        calculateSingleWorks(room.getWallsArea(), selectedItemsHolder.getWallsItemsIds());
        results.add("----------------------------");
        calculateSingleWorks(room.getCeilingArea(), selectedItemsHolder.getCeilingItemsIds());
        }

    public void calculateSingleWorks(double area, List<Integer> idList) {
        for (Integer id : idList) {
            String name = (workRepo.getCostById(id)).getName();
            double price = (workRepo.getCostById(id)).getPricePerM2();
            String result = (id + " " + name + " Koszt= " + (area * price) + " zł");
            results.add(result);
        }
    }

    public ArrayList<String> getResults() {
        return results;
    }
}
