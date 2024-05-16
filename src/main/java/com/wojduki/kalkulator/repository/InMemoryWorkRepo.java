package com.wojduki.kalkulator.repository;

import com.wojduki.kalkulator.model.Material;
import com.wojduki.kalkulator.model.Rodzaj;
import com.wojduki.kalkulator.model.Work;
import jakarta.annotation.PostConstruct;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class InMemoryWorkRepo implements WorkRepo {
    Map<Integer, Work> works = new HashMap<>();
    public InMemoryWorkRepo() {
    }

    @Override
    public void createWork(String nazwa, double pricePerM2, Rodzaj rodzaj) {
        Work newWork= new Work(nazwa, pricePerM2, rodzaj);
        newWork.setId(getNewId());
        works.put(newWork.getId(), newWork);
    }

    @Override
    public void createWork(Work work) {
        work.setId(getNewId());
        works.put(work.getId(), work);
    }

    @Override
    public Collection<Work> getAllWorks() {
        return null;
    }

    @Override
    public void saveWorkChanges(Work work) {

    }

    @Override
    public Material getWorkById(Integer id) {
        return null;
    }

    @Override
    public void deleteWork(Integer id) {

    }
    @PostConstruct
    @Override
    public void build() {
        createWork("Gruntowanie", 15.0, Rodzaj.SCIANY);
        createWork("Gipsowanie", 40.0, Rodzaj.SCIANY);
        createWork("Malowanie", 25.0, Rodzaj.SCIANY);
        createWork("Płytkowanie", 50.0, Rodzaj.SCIANY);
        createWork("Tapetowanie", 40.0, Rodzaj.SCIANY);
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
