package com.wojduki.kalkulator.controllers;

import com.wojduki.kalkulator.model.Material;
import com.wojduki.kalkulator.model.Work;
import com.wojduki.kalkulator.services.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@Controller
public class WorkController {
    @Autowired
    WorkService workService;

    @Autowired
    KalkulatorController kalkulatorController;

    @GetMapping("/works")
    public String getAllWorks(Model model) {
        List<Work> workList = workService.getAllWorks();
        model.addAttribute("works", workList);
        return "works";
    }
    @GetMapping("/work/edit")
    public String editWork(@RequestParam("id") Integer id, Model model) {
        Work work= workService.getWorkById(id);
        model.addAttribute("work", work);
        return "workedit";
    }
    @PostMapping("/work/save")
    public String saveWorkChanges(@Valid Work work) {
        workService.saveWorkChanges(work);
        return "redirect:/works";
    }
    @GetMapping("/work/form")
    public String createNewWork(Model model) {
        model.addAttribute("work", new Work());
        return "workform";
    }
    @PostMapping("/works")
    public String saveNewWork(@Valid Work work, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println("There were errors");
            bindingResult.getAllErrors().forEach(error -> {
                        System.out.println(error.getObjectName() + " " + error.getDefaultMessage());
                    }
            );
            return "workform";
        } else {
            workService.saveNewWork(work);
            return "redirect:/works";
        }
    }
    @GetMapping("/work/delete/{id}")
    public String deleteWork(@PathVariable("id") Integer id) {
        workService.deleteWork(id);
        return "redirect:/works";
    }
}
