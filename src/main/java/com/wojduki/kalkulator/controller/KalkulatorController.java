package com.wojduki.kalkulator.controller;

import com.wojduki.kalkulator.model.Pokoj;
import com.wojduki.kalkulator.model.PokojPodd;
import com.wojduki.kalkulator.model.PokojPodd2;
import org.springframework.web.bind.annotation.*;

@RestController
public class KalkulatorController {
    Pokoj pokoj;

    public KalkulatorController(){}

    @GetMapping("/kalkulator2")
    public String liczPowierzchnie (@RequestParam double szerokosc, @RequestParam double dlugosc, @RequestParam double wysokosc,
                                    @RequestParam double bokSkosu, @RequestParam double wysKolankowej, @RequestParam double bokSkosu2,
                                    @RequestParam double wysKolankowej2) {
        pokoj= new PokojPodd2(szerokosc, dlugosc, wysokosc, bokSkosu, wysKolankowej, bokSkosu2, wysKolankowej2);
        pokoj.wyliczaj();
        return wyswietlaj(pokoj);
    }
    @GetMapping("/kalkulator1")
    public String liczPowierzchnie (@RequestParam double szerokosc, @RequestParam double dlugosc, @RequestParam double wysokosc,
                                    @RequestParam double bokSkosu, @RequestParam double wysKolankowej) {
        pokoj= new PokojPodd(szerokosc, dlugosc, wysokosc, bokSkosu, wysKolankowej);
        pokoj.wyliczaj();
        return wyswietlaj(pokoj);
    }
    @GetMapping("/kalkulator")
    public String liczPowierzchnie (@RequestParam double szerokosc, @RequestParam double dlugosc, @RequestParam double wysokosc) {
        pokoj= new Pokoj(szerokosc, dlugosc, wysokosc);
        pokoj.wyliczaj();
        return wyswietlaj(pokoj);
    }
    private String wyswietlaj(Pokoj pokoj) {
        return "Powierzchnia ścian: "+pokoj.getPowScian()+"\n"
                +"Powierzchnia sufitu: "+pokoj.getPowSufitu()+"\n"
                +"Powierzchnia podłogi: "+pokoj.getPowPodlogi();
    }
}
