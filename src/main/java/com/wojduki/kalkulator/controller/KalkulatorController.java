package com.wojduki.kalkulator.controller;

import com.wojduki.kalkulator.model.Material;
import com.wojduki.kalkulator.repository.MaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/kalkulator")
public class KalkulatorController {
    private final MaterialRepository materialRepository;
    @Autowired
    public KalkulatorController(MaterialRepository materialRepository) {
        this.materialRepository = materialRepository;
    }

    @GetMapping
    public List<Material> getMaterial() {
        return materialRepository.findAll();
    }

}
