package com.model;

import org.junit.Test;


import static org.junit.Assert.*;

public class CardTest {

    @Test
    public void getValue() {
        Card card = new Card(2, 2);
        assertEquals(2, card.getValue());
    }

    @Test
    public void getSuitValue() {
        Card card = new Card(2,4);
        assertEquals(4, card.getSuitValue());
    }

    @Test
    public void getNameValue() {
        Card card = new Card(3,2);
        assertEquals("THREE", card.getNameValue());
    }
}