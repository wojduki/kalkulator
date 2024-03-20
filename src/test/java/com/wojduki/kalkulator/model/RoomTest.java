package com.wojduki.kalkulator.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RoomTest {
    Room room = new Room(3,4,2);
    @Test
    void liczPowPodlogiTest() {
        //given
        //when
        room.liczPowPodlogi();
        //then
        assertEquals(12, room.getPowPodlogi());
    }
    @Test
    void liczPowSufituTest() {
        //given
        //when
        room.liczPowSufitu();
        //then
        assertEquals(12, room.getPowSufitu());
    }

    @Test
    void liczPowScianTest() {
        //given
        //when
        room.liczPowScian();
        //then
        assertEquals(28, room.getPowScian());
    }
}