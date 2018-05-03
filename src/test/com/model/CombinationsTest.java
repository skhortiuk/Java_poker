package com.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CombinationsTest {
    @Test
    public void getPower() {
        Combinations combinations = new Combinations();
        combinations.setPower(20);
        assertEquals(20, combinations.getPower(), 0);

    }

}
