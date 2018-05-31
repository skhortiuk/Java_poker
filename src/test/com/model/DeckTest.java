package com.model;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class DeckTest {
    private Deck deck, deck2;

    @Before
    public void beforeDeckTest() {
        deck = new Deck();
        deck2 = new Deck();
    }

    @Test
    public void getCard() {
        deck.creator();
        Card test = deck.getCard();
        int test_suit = test.getSuitValue();
        int test_value = test.getValue();
        assertEquals(4, test_suit);
        assertEquals(14, test_value);
    }

    @Test
    public void clearDeck() {
        Stack<Card> cards;
        deck.creator();
        cards = deck.getCards();
        cards.clear();
        assertEquals(0, cards.size());
    }

    @Test
    public void shuffleDeck() {
        Stack<Card> cards, cardsTest;
        deck.creator();
        cards = deck.getCards();
        deck.shuffle();
        deck2.creator();
        cardsTest = deck2.getCards();
        assertNotEquals(cards.get(0), cardsTest.get(0));

    }

    @Test
    public void shuffleDeckCollections() {
        Stack<Card> cards, cardsTest;
        deck.creator();
        cards = deck.getCards();
        Collections.shuffle(cards);
        deck2.creator();
        cardsTest = deck2.getCards();
        assertNotEquals(cards.get(0), cardsTest.get(0));

    }


    @Test
    public void refill() {
        deck.refill();
        assertEquals(52, deck.getCards().size());
    }

    @Test
    public void is_random_refill() throws Exception{
        Deck first_deck = new Deck();
        Deck second_deck = new Deck();
        first_deck.refill();
        second_deck.refill();
        assertNotEquals(first_deck.getCards(), second_deck.getCards());
    }
}