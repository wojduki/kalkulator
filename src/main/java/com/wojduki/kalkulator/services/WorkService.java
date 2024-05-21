package com.wojduki.kalkulator.services;

import com.wojduki.kalkulator.model.Work;
import com.wojduki.kalkulator.repository.CostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class WorkService {
    @Autowired
    CostRepo<Work> workRepo;

    public List<Work> getAllWorks() {
        return new ArrayList<>(workRepo.getAllCosts());
    }
    public Work getWorkById(Integer id) {
        return workRepo.getCostById(id);
    }
    public void saveCost(Work work) {
        workRepo.createCost(work);
    }

    public void saveWorkChanges(Work work) {
        workRepo.saveCostChanges(work);
    }
    public void deleteWork(Integer id) {
        workRepo.deleteCost(id);
    }

    public void calculateWorks (double area, List<Integer> idList) {
        for(Integer id : idList) {
            String name = (workRepo.getCostById(id)).getName();
            double price = (workRepo.getCostById(id)).getPricePerM2();
            System.out.println("Koszt robocizny: "+id+" "+name+" = "+(area * price)+" zł");
        }
        System.out.println("----------------------------");
    }
}
