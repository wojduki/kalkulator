package com.wojduki.kalkulator.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class KalkulatorController {

    public KalkulatorController(){}

    @GetMapping("/kalk")
    public Double liczObjetosc (@RequestParam double dlugosc, @RequestParam double szerokosc, @RequestParam double wysokosc) {
        return dlugosc*szerokosc*wysokosc;
    }
}
