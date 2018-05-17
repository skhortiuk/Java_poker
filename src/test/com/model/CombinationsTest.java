package com.model;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public class CombinationsTest {
    private Combinations combinations;
  /*  private List<Card> cards;
    private List<Card> cardsSort;
    @Before
    public void beforeCombinationsTest() throws Exception{
        combinations = new Combinations();
        cards = new ArrayList<>();
        cardsSort = new ArrayList<>();
    }*/

    @Test
    public void getPower() {
        combinations = new Combinations();
        combinations.setPower(20);
        assertEquals(20, combinations.getPower(), 0);

    }
/*
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

/*
    @Test
    public void calculate() {
        Deck deck = new Deck();
        deck.refill();
        combinations.calculate();

        assertEquals(0,combinations.getPower(), 0 );
    }*//*

    @Test
    public void highCard() {
        Card card = new Card(6,1);
        Card card2 = new Card(2, 2);
        Card card3 = new Card(3,1);
        Card card4 = new Card(9, 2);
        Card card5 = new Card(10,1);
        Card card6 = new Card(5, 4);
        Card card7 = new Card(12, 4);
        cards.add(card);
        cards.add(card2);
        cards.add(card3);
        cards.add(card4);
        cards.add(card5);
        cards.add(card6);
        cards.add(card7);
        int size = cards.size();
        combinations.addCards(card);
        combinations.addCards(card2);
        combinations.addCards(card3);
        combinations.addCards(card4);
        combinations.addCards(card5);
        combinations.addCards(card6);
        combinations.addCards(card7);
        combinations.calculate();
        assertEquals(12.10090605, combinations.calculatePower(), 0.000000001);
        getCombinationName();
       // String combMane = "High card " + cards.get(size - 1).getNameValue()
        assertEquals("High card QUEEN","High card " + cards.get(size - 1).getNameValue() );


    }

    @Test
    public void onePair() {
        Card card = new Card(6,1);
        Card card2 = new Card(6, 2);
        Card card3 = new Card(3,1);
        Card card4 = new Card(9, 2);
        Card card5 = new Card(10,1);
        Card card6 = new Card(5, 4);
        Card card7 = new Card(12, 4);

        combinations.addCards(card);
        combinations.addCards(card2);
        combinations.addCards(card3);
        combinations.addCards(card4);
        combinations.addCards(card5);
        combinations.addCards(card6);
        combinations.addCards(card7);
        combinations.calculate();
        assertEquals(26.121009, combinations.calculatePower(), 0.0000001);

    }
    @Test
    public void twoPair() {
        Card card = new Card(6,1);
        Card card2 = new Card(6, 2);
        Card card3 = new Card(3,1);
        Card card4 = new Card(9, 2);
        Card card5 = new Card(5,2);
        Card card6 = new Card(5, 4);
        Card card7 = new Card(12, 4);

        combinations.addCards(card);
        combinations.addCards(card2);
        combinations.addCards(card3);
        combinations.addCards(card4);
        combinations.addCards(card5);
        combinations.addCards(card6);
        combinations.addCards(card7);
        combinations.calculate();
        assertEquals(46.05119, combinations.calculatePower(), 0.00001);

    }

    @Test
    public void threeOfaKind() {
        Card card = new Card(6,1);
        Card card2 = new Card(2, 2);
        Card card3 = new Card(3,1);
        Card card4 = new Card(5, 3);
        Card card5 = new Card(5,2);
        Card card6 = new Card(5, 4);
        Card card7 = new Card(12, 4);

        combinations.addCards(card);
        combinations.addCards(card2);
        combinations.addCards(card3);
        combinations.addCards(card4);
        combinations.addCards(card5);
        combinations.addCards(card6);
        combinations.addCards(card7);
        combinations.calculate();
        assertEquals(75.1206, combinations.calculatePower(), 0.00001);
    }

    @Test
    public void straight() {
        Card card = new Card(10,1);
        Card card2 = new Card(9, 2);
        Card card3 = new Card(8,1);
        Card card4 = new Card(7, 3);
        Card card5 = new Card(11,2);
        Card card6 = new Card(5, 4);
        Card card7 = new Card(12, 4);

        combinations.addCards(card);
        combinations.addCards(card2);
        combinations.addCards(card3);
        combinations.addCards(card4);
        combinations.addCards(card5);
        combinations.addCards(card6);
        combinations.addCards(card7);
        combinations.calculate();
        assertEquals(102.0, combinations.calculatePower(), 0.0);
    }
    @Test
    public void straightToFive() {
        Card card = new Card(2,1);
        Card card2 = new Card(3, 2);
        Card card3 = new Card(4,1);
        Card card4 = new Card(7, 3);
        Card card5 = new Card(11,2);
        Card card6 = new Card(5, 4);
        Card card7 = new Card(14, 4);

        combinations.addCards(card);
        combinations.addCards(card2);
        combinations.addCards(card3);
        combinations.addCards(card4);
        combinations.addCards(card5);
        combinations.addCards(card6);
        combinations.addCards(card7);
        combinations.calculate();
        assertEquals(95.0, combinations.calculatePower(), 0.0);
    }
    @Test
    public void flush() {
        Card card = new Card(2,2);
        Card card2 = new Card(3, 2);
        Card card3 = new Card(4,2);
        Card card4 = new Card(7, 3);
        Card card5 = new Card(11,2);
        Card card6 = new Card(5, 2);
        Card card7 = new Card(14, 4);

        combinations.addCards(card);
        combinations.addCards(card2);
        combinations.addCards(card3);
        combinations.addCards(card4);
        combinations.addCards(card5);
        combinations.addCards(card6);
        combinations.addCards(card7);
        combinations.calculate();
        assertEquals(131.1105040302, combinations.calculatePower(), 0.0);
    }
    @Test
    public void fullHouse() {
        Card card = new Card(2,2);
        Card card2 = new Card(2, 1);
        Card card3 = new Card(4,4);
        Card card4 = new Card(11, 3);
        Card card5 = new Card(11,1);
        Card card6 = new Card(11, 2);
        Card card7 = new Card(14, 4);

        combinations.addCards(card);
        combinations.addCards(card2);
        combinations.addCards(card3);
        combinations.addCards(card4);
        combinations.addCards(card5);
        combinations.addCards(card6);
        combinations.addCards(card7);
        combinations.calculate();
        assertEquals(151.02, combinations.calculatePower(), 0.0);
    }

    @Test
    public void fourOfKind() {
        Card card = new Card(2,2);
        Card card2 = new Card(11, 4);
        Card card3 = new Card(4,4);
        Card card4 = new Card(11, 3);
        Card card5 = new Card(11,1);
        Card card6 = new Card(11, 2);
        Card card7 = new Card(14, 4);

        combinations.addCards(card);
        combinations.addCards(card2);
        combinations.addCards(card3);
        combinations.addCards(card4);
        combinations.addCards(card5);
        combinations.addCards(card6);
        combinations.addCards(card7);
        combinations.calculate();
        assertEquals(171.2, combinations.calculatePower(), 0.0);
    }

    @Test
    public void straightFlush() {
        Card card = new Card(2,2);
        Card card2 = new Card(7, 4);
        Card card3 = new Card(6,4);
        Card card4 = new Card(8, 4);
        Card card5 = new Card(11,1);
        Card card6 = new Card(10, 4);
        Card card7 = new Card(9, 4);

        combinations.addCards(card);
        combinations.addCards(card2);
        combinations.addCards(card3);
        combinations.addCards(card4);
        combinations.addCards(card5);
        combinations.addCards(card6);
        combinations.addCards(card7);
        combinations.calculate();
        assertEquals(190.0, combinations.calculatePower(), 0.0);
    }
    @Test
    public void straightFlushToFive() {
        Card card = new Card(2,4);
        Card card2 = new Card(3, 4);
        Card card3 = new Card(4,4);
        Card card4 = new Card(5, 4);
        Card card5 = new Card(14,4);
        Card card6 = new Card(10, 1);
        Card card7 = new Card(9, 2);

        combinations.addCards(card);
        combinations.addCards(card2);
        combinations.addCards(card3);
        combinations.addCards(card4);
        combinations.addCards(card5);
        combinations.addCards(card6);
        combinations.addCards(card7);
        combinations.calculate();
        assertEquals(180.0, combinations.calculatePower(), 0.0);
    }
    @Test
    public void returnNull() {


        combinations.calculate();
        assertEquals(0.0, combinations.calculatePower(), 0.0);
    }

    @Test
    public void cardsSize() {
        Card card = new Card(6,1);
        Card card2 = new Card(6, 2);
        combinations.addCards(card);
        combinations.addCards(card2);
        cards.add(card);
        cards.add(card2);
        assertEquals(2, cards.size());

    }

    @Test
    public void setCards() {
        Card card = new Card(2,4);
        Card card2 = new Card(3, 4);
        combinations.setCards(cards);
        cards.add(card);
        cards.add(card2);
        assertEquals(cards.get(1),combinations.getCard(1));
    }*/
}
