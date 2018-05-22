package com.model;

import org.junit.Before;
import org.junit.Test;

import java.util.Stack;

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
        Deck deck = new Deck();
        deck.creator();
        Card test = deck.getCard();
        int test_suit = test.getSuitValue();
        int test_value = test.getValue();
        assertEquals(4,test_suit);
        assertEquals(14, test_value);

    }
}