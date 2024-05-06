package com.wojduki.kalkulator.controllers;

import com.wojduki.kalkulator.model.Material;
import com.wojduki.kalkulator.services.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MaterialController {

    @Autowired
    MaterialService materialService;

    @GetMapping("/material/select")
    public String presentMaterialsInSelect(Model model) {
        List<Material> materialList = materialService.getAllMaterials();
        //List<Material> selectedMaterials= new ArrayList<>();
        model.addAttribute("materialList", materialList);
        Material material= new Material();
        model.addAttribute("material", material);
        //model.addAttribute("selectedMaterials", selectedMaterials);
        return "materialselect";
    }

    @PostMapping("/material/select")
    public String presentSelectedMaterials(Material material) {
        System.out.println("Materiał="+material.getId());
        return "redirect:/materials";
    }

    @GetMapping("/materials")
    public String getAllMaterials(Model model) {
        List<Material> materialList = materialService.getAllMaterials();
        model.addAttribute("materials", materialList);
        return "materials";
    }
    @GetMapping("/material/edit")
    public String editMaterial(@RequestParam("id") Integer id, Model model) {
        Material material= materialService.getMaterialById(id);
        model.addAttribute("material", material);
        return "materialedit";
    }

    @PostMapping("/material/save")
    public String saveMaterialChanges(@Valid Material material) {
        materialService.saveMaterialChanges(material);
        return "redirect:/materials";
    }
    @GetMapping("/material/form")
    public String createNewMaterial(Model model) {
        model.addAttribute("material", new Material());
        return "materialform";
    }
    @PostMapping("/materials")
    public String saveMaterial(@Valid Material material, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println("There were errors");
            bindingResult.getAllErrors().forEach(error -> {
                        System.out.println(error.getObjectName() + " " + error.getDefaultMessage());
                    }
            );
            return "materialform";
        } else {
            materialService.saveMaterial(material);
            return "redirect:/materials";
        }
    }
    @GetMapping("/material/delete/{id}")
    public String deleteMaterial(@PathVariable("id") Integer id) {
        materialService.deleteMaterial(id);
        return "redirect:/materials";
    }
}
