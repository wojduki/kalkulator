package com.wojduki.kalkulator.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PokojTest {
    Pokoj pokoj = new Pokoj(3,4,2);
    @Test
    void liczPowPodlogiTest() {
        //given
        //when
        pokoj.liczPowPodlogi();
        //then
        assertEquals(12, pokoj.getPowPodlogi());
    }
    @Test
    void liczPowSufituTest() {
        //given
        //when
        pokoj.liczPowSufitu();
        //then
        assertEquals(12, pokoj.getPowSufitu());
    }

    @Test
    void liczPowScianTest() {
        //given
        //when
        pokoj.liczPowScian();
        //then
        assertEquals(28, pokoj.getPowScian());
    }
}