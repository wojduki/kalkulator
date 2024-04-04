package com.wojduki.kalkulator.controllers;

import com.wojduki.kalkulator.model.Material;
import com.wojduki.kalkulator.services.MaterialService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MaterialController {

    @Autowired
    MaterialService materialService;

    @RequestMapping("/material/select")
    public String presentMaterialsInSelect(Model model) {
        List<Material> materialList = materialService.getAllMaterials();
        model.addAttribute("materialList", materialList);
        return "materialselect";
    }
    @RequestMapping("/materials")
    public String getAllMaterials(Model model) {
        List<Material> materialList = materialService.getAllMaterials();
        model.addAttribute("materials", materialList);
        return "materials";
    }
    @RequestMapping("/material/edit")
    public String editMaterial(@RequestParam("id") Integer id, Model model) {
        Material material= materialService.getMaterialById(id);
        model.addAttribute("material", material);
        return "materialedit";
    }
    @RequestMapping(value = "/materials", method = RequestMethod.PATCH)
    public String saveMaterialChanges(Material material) {
        materialService.saveMaterialChanges(material);
        return "redirect:/materials";
    }
    @RequestMapping("/material/form")
    public String createNewMaterial(Model model) {
        model.addAttribute("material", new Material());
        return "materialform";
    }
    @RequestMapping(value = "/materials", method = RequestMethod.POST)
    public String saveMaterial(Material material) {
        materialService.saveMaterial(material);
        return "redirect:/materials";
    }
    @RequestMapping("/material/delete/{id}")
    public String deleteMaterial(@PathVariable("id") Integer id) {
        materialService.deleteMaterial(id);
        return "redirect:/materials";
    }
}
