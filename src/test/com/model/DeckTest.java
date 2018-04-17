package com.model;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class DeckTest {

    @Test
    public void refill() {
        Deck deck = new Deck();
        deck.refill();
        assertEquals(52, deck.getCards().size());
    }

    @Test
    public void getCard() {
    }
}