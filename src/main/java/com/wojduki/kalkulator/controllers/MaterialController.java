package com.wojduki.kalkulator.controllers;

import com.wojduki.kalkulator.model.Material;
import com.wojduki.kalkulator.services.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class MaterialController {

    @Autowired
    MaterialService materialService;

    @RequestMapping("/materials")
    public String getAllMaterials(Model model) {
        List<Material> materialList = materialService.getAllMaterials();
        model.addAttribute("materials", materialList);
        return "materials";
    }
    @RequestMapping("/materialpure")
    public String presentMaterialsInSelect(Model model) {
        List<Material> materialList = materialService.getAllMaterials();
        model.addAttribute("materialList", materialList);
        return "materialpure";
    }

    @RequestMapping("/newmaterial")
    public String createNewMaterial(Model model) {
        model.addAttribute("material", new Material());
        return "materialform";
    }
    @RequestMapping(value = "/materials", method = RequestMethod.POST)
    public String saveMaterial(Material material) {
        materialService.saveMaterial(material);
        return "redirect:/materials";
    }
}
