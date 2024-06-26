package com.wojduki.kalkulator.controllers;

import com.wojduki.kalkulator.model.Material;
import com.wojduki.kalkulator.model.Type;
import com.wojduki.kalkulator.repository.SelectedItemsHolder;
import com.wojduki.kalkulator.services.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@Controller
public class MaterialController {

    @Autowired
    MaterialService materialService;
    @Autowired
    KalkulatorController kalkulatorController;

    @GetMapping("/material/select")
    public String presentMaterialsInSelect(Model model) {
        model.addAttribute("floorMaterialsList", materialService.getMaterialsByType(Type.FLOOR));
        model.addAttribute("wallsMaterialsList", materialService.getMaterialsByType(Type.WALLS));
        model.addAttribute("ceilingMaterialsList", materialService.getMaterialsByType(Type.CEILING));
        model.addAttribute("material", new Material());
        model.addAttribute("selectedMaterialsHolder", new SelectedItemsHolder());
        return "materialselect";
    }

    @PostMapping("/material/select")
    public String calculateSelectedMaterials(SelectedItemsHolder selectedMaterialsHolder, Model model) {
        materialService.calculateMaterials(kalkulatorController.getRoom(), selectedMaterialsHolder);
        model.addAttribute("results", materialService.getResults());
        return "resultpage";
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
    public String updateMaterial(@Valid Material material) {
        materialService.updateMaterial(material);
        return "redirect:/materials";
    }
    @GetMapping("/material/form")
    public String createNewMaterial(Model model) {
        model.addAttribute("material", new Material());
        return "materialform";
    }
    @PostMapping("/materials")
    public String saveNewMaterial(@Valid Material material, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println("There were errors");
            bindingResult.getAllErrors().forEach(error -> {
                        System.out.println(error.getObjectName() + " " + error.getDefaultMessage());
                    }
            );
            return "materialform";
        } else {
            materialService.saveNewMaterial(material);
            return "redirect:/materials";
        }
    }
    @GetMapping("/material/delete/{id}")
    public String deleteMaterial(@PathVariable("id") Integer id) {
        materialService.deleteMaterial(id);
        return "redirect:/materials";
    }
}
