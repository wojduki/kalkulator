package com.wojduki.kalkulator.repository;

import com.wojduki.kalkulator.model.Type;
import com.wojduki.kalkulator.model.Work;
import jakarta.annotation.PostConstruct;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class InMemoryWorkRepo implements CostRepo<Work> {
    Map<Integer, Work> works = new HashMap<>();
    public InMemoryWorkRepo() {}

    public void createWork(String nazwa, double pricePerM2, Type type) {
        Work newWork= new Work(nazwa, pricePerM2, type);
        newWork.setId(getNewId());
        works.put(newWork.getId(), newWork);
    }

    @Override
    public void createCost(Work work) {
        work.setId(getNewId());
        works.put(work.getId(), work);
    }

    @Override
    public Collection<Work> getAllCosts() {
        return works.values();
    }

    @Override
    public void updateCost(Integer id, Work work) {
        works.replace(id, work);
    }

    @Override
    public Work getCostById(Integer id) {
        return works.get(id);
    }

    @Override
    public void deleteCost(Integer id) { works.remove(id);

    }
    @PostConstruct
    @Override
    public void build() {
        createWork("Gruntowanie", 12.0, Type.FLOOR);
        createWork("Układanie płytek", 50.0, Type.FLOOR);
        createWork("Układanie paneli", 40.0, Type.FLOOR);
        createWork("Gruntowanie", 12.0, Type.WALLS);
        createWork("Gipsowanie", 40.0, Type.WALLS);
        createWork("Malowanie", 25.0, Type.WALLS);
        createWork("Klejenie płytek", 50.0, Type.WALLS);
        createWork("Tapetowanie", 30.0, Type.WALLS);
        createWork("Gruntowanie", 12.0, Type.CEILING);
        createWork("Gipsowanie", 40.0, Type.CEILING);
        createWork("Malowanie", 25.0, Type.CEILING);
    }
    @Override
    public String toString() {
        return "InMemoryRepository{" +
                "works=" + works +
                '}';
    }
    public Integer getNewId() {
        if (works.isEmpty()) {
            return 1;
        }
        else {
            Integer integer = works.keySet().stream().max(Comparator.naturalOrder()).get();
            return integer+1;
        }
    }
}
