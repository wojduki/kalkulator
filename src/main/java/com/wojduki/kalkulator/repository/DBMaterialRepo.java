package com.wojduki.kalkulator.repository;

import com.wojduki.kalkulator.model.Material;
import com.wojduki.kalkulator.model.Type;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.util.Collection;

public class DBMaterialRepo implements CostRepo<Material>{
    @PersistenceContext
    private EntityManager em;
    @Transactional
    public void createMaterial(String name, String unit, double consumptionPerM2, double unitPrice, Type type) {
        Material material= new Material(name, unit, consumptionPerM2, unitPrice, type);
        em.persist(material);
    }
    @Override
    @Transactional
    public void createCost(Material material){
        em.persist(material);
    }
    @Override
    @Transactional
    public void updateCost(Integer id,Material material){
        em.merge(material);
    }

    @Override
    public Collection<Material> getAllCosts() {
        return em.createQuery("from Material", Material.class).getResultList();
    }
    @Override
    public Material getCostById(Integer id) {
        return em.createQuery("from Material m where m.id=:id", Material.class)
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
        createMaterial("Grunt", "l", 0.3, 12, Type.FLOOR);
        createMaterial("Klej", "kg", 2.5, 14, Type.FLOOR);
        createMaterial("Płytki", "szt.", 4, 40, Type.FLOOR);
        createMaterial("Grunt", "l", 0.3, 12, Type.WALLS);
        createMaterial("Farba", "l", 0.2, 15, Type.WALLS);
        createMaterial("Tapeta", "m.b.", 1, 30, Type.WALLS);
        createMaterial("Tynk", "worek", 1, 16, Type.WALLS);
        createMaterial("Grunt", "l", 0.3, 12, Type.CEILING);
        createMaterial("Gips", "kg", 1.0, 15, Type.CEILING);
        createMaterial("Farba", "l", 0.2, 15, Type.CEILING);
    }
}
