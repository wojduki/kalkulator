package com.wojduki.kalkulator.controller;

import com.wojduki.kalkulator.model.Room;
import com.wojduki.kalkulator.model.AtticRoom;
import com.wojduki.kalkulator.model.AtticRoom2;
import org.springframework.web.bind.annotation.*;

@RestController
public class KalkulatorController {
    Room room;

    @GetMapping("/kalkulator2")
    public String calculateAreas(@RequestParam double szerokosc, @RequestParam double dlugosc, @RequestParam double wysokosc,
                                 @RequestParam double bokSkosu, @RequestParam double wysKolankowej, @RequestParam double bokSkosu2,
                                 @RequestParam double wysKolankowej2) {
        room = new AtticRoom2(szerokosc, dlugosc, wysokosc, bokSkosu, wysKolankowej, bokSkosu2, wysKolankowej2);
        room.calculate();
        return toString();
    }
    @GetMapping("/kalkulator1")
    public String calculateAreas(@RequestParam double szerokosc, @RequestParam double dlugosc, @RequestParam double wysokosc,
                                 @RequestParam double bokSkosu, @RequestParam double wysKolankowej) {
        room = new AtticRoom(szerokosc, dlugosc, wysokosc, bokSkosu, wysKolankowej);
        room.calculate();
        return toString();
    }
    @GetMapping("/kalkulator")
    public String calculateAreas(@RequestParam double szerokosc, @RequestParam double dlugosc, @RequestParam double wysokosc) {
        room = new Room(szerokosc, dlugosc, wysokosc);
        room.calculate();
        return toString();
    }
    @Override
    public String toString() {
        return "Powierzchnia ścian: "+ room.getWallsArea()+"\n"
                +"Powierzchnia sufitu: "+ room.getCeilingArea()+"\n"
                +"Powierzchnia podłogi: "+ room.getFloorArea();
    }
}
