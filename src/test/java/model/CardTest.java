package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardTest {
    Card card;

    @BeforeEach
    void setUp() {
        card = new Card(2,2);
    }

    @Test
    void getNameValue() {
        assertEquals("T2wo", card.getNameValue());
    }

    @Test
    void getSuitValue() {
    }

    @Test
    void getValue() {
    }
}