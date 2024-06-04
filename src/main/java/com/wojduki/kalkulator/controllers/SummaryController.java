package com.wojduki.kalkulator.controllers;

import com.wojduki.kalkulator.services.MaterialService;
import com.wojduki.kalkulator.services.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class SummaryController {
    @Autowired
    MaterialService materialService;
    @Autowired
    WorkService workService;
    @Autowired
    KalkulatorController kalkulatorController;

    @GetMapping("/summary")
    public String presentSummary(Model model){
        model.addAttribute("roomArrays", kalkulatorController.toString());
        model.addAttribute("materialResults", materialService.getResults());
        model.addAttribute("workResults", workService.getResults());
        return "summarypage";
    }
}
