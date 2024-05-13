package com.wojduki.kalkulator.controllers;

import com.wojduki.kalkulator.model.Room;
import com.wojduki.kalkulator.model.AtticRoom;
import com.wojduki.kalkulator.model.AtticRoom2;
import org.springframework.web.bind.annotation.*;

@RestController
public class KalkulatorController {
    private Room room;

    @GetMapping("/kalkulator2")
    public String calculateAreas(@RequestParam double width, @RequestParam double length, @RequestParam double height,
                                 @RequestParam double slant, @RequestParam double wysKolankowej, @RequestParam double slant2,
                                 @RequestParam double wysKolankowej2) {
        room = new AtticRoom2(width, length, height, slant, wysKolankowej, slant2, wysKolankowej2);
        room.calculate();
        return toString();
    }
    @GetMapping("/kalkulator1")
    public String calculateAreas(@RequestParam double width, @RequestParam double length, @RequestParam double height,
                                 @RequestParam double slant, @RequestParam double wysKolankowej) {
        room = new AtticRoom(width, length, height, slant, wysKolankowej);
        room.calculate();
        return toString();
    }
    @GetMapping("/kalkulator")
    public String calculateAreas(@RequestParam double width, @RequestParam double length, @RequestParam double height) {
        room = new Room(width, length, height);
        room.calculate();
        return toString();
    }
    @Override
    public String toString() {
        return "Powierzchnia ścian: "+ room.getWallsArea()+"\n"
                +"Powierzchnia sufitu: "+ room.getCeilingArea()+"\n"
                +"Powierzchnia podłogi: "+ room.getFloorArea();
    }
    public Room getRoom() {
        return room;
    }
}
