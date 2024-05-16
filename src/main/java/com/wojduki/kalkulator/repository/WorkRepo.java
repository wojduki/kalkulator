package com.wojduki.kalkulator.repository;

import com.wojduki.kalkulator.model.Work;
import com.wojduki.kalkulator.model.Material;
import com.wojduki.kalkulator.model.Rodzaj;
import java.util.Collection;

public interface WorkRepo {

    void createWork(String nazwa, double pricePerM2, Rodzaj rodzaj);

    void createWork(Work work);
    Collection<Work> getAllWorks();
    void saveWorkChanges(Work work);

    Material getWorkById(Integer id);

    void deleteWork(Integer id);

    void build();
}
