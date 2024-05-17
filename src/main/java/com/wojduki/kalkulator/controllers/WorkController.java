package com.wojduki.kalkulator.controllers;

import com.wojduki.kalkulator.model.Work;
import com.wojduki.kalkulator.services.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
}
