package com.model;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CombinationsTest {
    private Combinations combinations;
    private List<Card> cards;
    @Before
    public void beforeCombinationsTest() throws Exception{
        combinations = new Combinations();
        cards = new ArrayList<>();
    }

    @Test
    public void getPower() {
        combinations.setPower(20);
        assertEquals(20, combinations.getPower(), 0);

    }

    @Test
    public void getCombinationName() {
        combinations.setCombinationName("Pairs");
        assertEquals("Pairs", combinations.getCombinationName());
    }

    @Test
    public void addCards() {
        Card card = new Card(5,1);
        Card card2 = new Card(6, 2);
        combinations.addCards(card);
        combinations.addCards(card2);
        assertEquals(card2, combinations.getCard(1));
    }

    @Test
    public void calculate() {


        combinations.calculate();

        assertEquals(0,combinations.getPower(), 0 );
    }
}
