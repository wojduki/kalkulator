package com.wojduki.kalkulator.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RoomTest {
    Room room = new Room(3,4,2);
    @Test
    void calculateFloorAreaTest() {
        //given
        //when
        room.calculateFloorArea();
        //then
        assertEquals(12, room.getFloorArea());
    }
    @Test
    void calculateCeilingAreaTest() {
        //given
        //when
        room.calculateCeilingArea();
        //then
        assertEquals(12, room.getCeilingArea());
    }

    @Test
    void calculateWallsAreaTest() {
        //given
        //when
        room.calculateWallsArea();
        //then
        assertEquals(28, room.getWallsArea());
    }
}