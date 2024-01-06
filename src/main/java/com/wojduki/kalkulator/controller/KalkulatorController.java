package com.wojduki.kalkulator.controller;

import com.wojduki.kalkulator.model.Pokoj;
import org.springframework.web.bind.annotation.*;

@RestController
public class KalkulatorController {
    Pokoj pokoj;

    public KalkulatorController(){}

    @GetMapping("/kalk")
    public String liczObjetosc (@RequestParam double szerokosc, @RequestParam double dlugosc, @RequestParam double wysokosc) {
        pokoj= new Pokoj(szerokosc, dlugosc, wysokosc);
        pokoj.wyliczaj();
        return "Powierzchnia ścian: "+pokoj.getPowScian()+"\n"
                +"Powierzchnia sufitu: "+pokoj.getPowSufitu()+"\n"
                +"Powierzchnia podłogi: "+pokoj.getPowPodlogi();
    }
}
