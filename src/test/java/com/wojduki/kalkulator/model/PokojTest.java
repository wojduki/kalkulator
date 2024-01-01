package com.wojduki.kalkulator.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PokojTest {
    @Test
    void liczPowPodlogiTest() {
        //given
        Pokoj pokoj = new Pokoj(3.5, 5, 3);
        //when
        pokoj.wyliczaj();
        //then
        assertEquals(17.5, pokoj.getPowPodlogi());
    }
    @Test
    void liczPowSufituTest() {
        //given
        Pokoj pokoj = new Pokoj(3,4,2.5);
        //when
        pokoj.wyliczaj();
        //then
        assertEquals(12, pokoj.getPowSufitu());
    }

    @Test
    void liczPowScianTest() {
        //given
        Pokoj pokoj = new Pokoj(3,4,2);
        //when
        pokoj.wyliczaj();
        //then
        assertEquals(28, pokoj.getPowScian());
    }
}