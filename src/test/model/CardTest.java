package model;

import org.junit.Before;
import org.junit.Test;

import model.Card;

import static org.junit.Assert.*;

public class CardTest {

    private Card card;

    @Before
    public void setUp() throws Exception {
        card = new Card(2, 2);
    }

    @Test
    public void getNameValue() {
    }

    @Test
    public void getSuitValue() {
    }

    @Test
    public void getValue() {
        assertEquals(2, card.getValue());
    }
}