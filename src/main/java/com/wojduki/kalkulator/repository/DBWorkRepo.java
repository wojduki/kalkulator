package com.wojduki.kalkulator.repository;

import com.wojduki.kalkulator.model.Type;
import com.wojduki.kalkulator.model.Work;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.Collection;

public class DBWorkRepo implements CostRepo<Work>{
    @PersistenceContext
    private EntityManager em;
    public void createWork(String name, double pricePerM2, Type type) {
        Work work= new Work(name, pricePerM2, type);
        em.persist(work);
    }
    @Override
    public void createCost(Work work){
        em.persist(work);
    }
    @Override
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
    public void deleteCost(Integer id) {
        em.remove(id);
    }

    @Override
    public void build() {
    }
}

