package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardTest {
    private Deck deck = new Deck();
    private Card card;

    @BeforeEach
    void setUp() {
        deck.refill();
        card = new Card(2, 2);
    }
    //Test

    @Test
    void Card(){
        assertEquals(2, new Card(2,1).getValue());
    }

    @Test
    void getNameValue() {
        assertEquals("Two", card.getNameValue());
    }

    @Test
    void getSuitValue() {
        assertEquals(2, card.getSuitValue());
    }

    @Test
    void getValue() {
        assertEquals(2, card.getValue());
    }
}