package model;

import org.junit.Test;

import static org.junit.Assert.*;

public class CardTest {

    @Test
    public void getValue() {
        Card card = new Card(2, 2);
        assertEquals(3, card.getValue());
    }
}