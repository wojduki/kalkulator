package com.wojduki.kalkulator.services;

import com.wojduki.kalkulator.model.Work;
import com.wojduki.kalkulator.repository.WorkRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WorkService {
    @Autowired
    WorkRepo workRepo;

    public List<Work> getAllWorks() {
        return new ArrayList<>(workRepo.getAllWorks());
    }
    public Work getWorkById(Integer id) {
        return workRepo.getWorkById(id);
    }
    public void saveCost(Work work) {
        workRepo.createWork(work);
    }

    public void saveWorkChanges(Work work) {
        workRepo.saveWorkChanges(work);
    }
    public void deleteWork(Integer id) {
        workRepo.deleteWork(id);
    }

    public void calculateWorks (double area, List<Integer> idList) {
        for(Integer id : idList) {
            String name = (workRepo.getWorkById(id)).getName();
            double price = (workRepo.getWorkById(id)).getPricePerM2();
            System.out.println("Koszt robocizny: "+id+" "+name+" = "+(area * price)+" zł");
        }
        System.out.println("----------------------------");
    }
}
