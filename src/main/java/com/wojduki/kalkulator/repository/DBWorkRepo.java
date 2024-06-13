package com.wojduki.kalkulator.repository;

import com.wojduki.kalkulator.model.Type;
import com.wojduki.kalkulator.model.Work;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.Collection;

public class DBWorkRepo implements CostRepo<Work>{
    @PersistenceContext
    private EntityManager em;
    @Transactional
    public void createWork(String name, double pricePerM2, Type type) {
        Work work= new Work(name, pricePerM2, type);
        em.persist(work);
    }
    @Override
    @Transactional
    public void createCost(Work work){
        em.persist(work);
    }
    @Override
    @Transactional
    public void updateCost(Integer id, Work work){
        em.merge(work);
    }

    @Override
    public Collection<Work> getAllCosts() {

        return em.createQuery("from Work", Work.class).getResultList();
    }

    @Override
    public Work getCostById(Integer id) {

        return em.createQuery("from Work w where w.id=:id", Work.class)
                .setParameter("id", id).getSingleResult();
    }

    @Override
    @Transactional
    public void deleteCost(Integer id) {
        em.remove(id);
    }

    //@PostConstruct
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
}

