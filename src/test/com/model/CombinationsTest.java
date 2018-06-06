package com.model;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CombinationsTest {
    private Combinations combinations;
    private List<Card> cards;

    @Before
    public void beforeCombinationsTest() throws Exception {
        combinations = new Combinations();
        cards = new ArrayList<>();
    }

    @Test
    public void getPower() {
        combinations = new Combinations();
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
        Card card = new Card(5, 1);
        Card card2 = new Card(6, 2);
        combinations.addCards(card);
        combinations.addCards(card2);
        assertEquals(card2, combinations.getCard(1));
    }


    @Test
    public void calculate() {
        Player first_player = new Player();
        Player second_player = new Player();
        first_player.setCards(new Card(3, 3));
        first_player.setCards(new Card(3, 4));
        second_player.setCards(new Card(3, 1));
        second_player.setCards(new Card(3, 2));
        assertEquals(first_player.getPower(), second_player.getPower(), 1e-8);
    }


    @Test
    public void onePair() {
        combinations.addCards(new Card(6, 1));
        combinations.addCards(new Card(6, 2));
        combinations.addCards(new Card(3, 1));
        combinations.addCards(new Card(9, 2));
        combinations.addCards(new Card(10, 1));
        combinations.addCards(new Card(5, 4));
        combinations.addCards(new Card(12, 4));
        combinations.calculate();
        assertEquals(26.121009, combinations.calculatePower(), 1e-8);

    }


    @Test
    public void twoPair() {
        combinations.addCards(new Card(6, 1));
        combinations.addCards(new Card(6, 2));
        combinations.addCards(new Card(3, 1));
        combinations.addCards(new Card(9, 2));
        combinations.addCards(new Card(5, 2));
        combinations.addCards(new Card(5, 4));
        combinations.addCards(new Card(12, 4));
        combinations.calculate();
        assertEquals(46.05119, combinations.calculatePower(), 1e-4);
    }

    @Test
    public void straight() {
        combinations.addCards(new Card(10, 1));
        combinations.addCards(new Card(9, 2));
        combinations.addCards(new Card(8, 1));
        combinations.addCards(new Card(7, 3));
        combinations.addCards(new Card(11, 2));
        combinations.addCards(new Card(5, 4));
        combinations.addCards(new Card(12, 4));
        combinations.calculate();
        assertEquals(102.0, combinations.calculatePower(), 0.0);
    }

    @Test
    public void threeOfaKind() {
        combinations.addCards(new Card(6, 1));
        combinations.addCards(new Card(2, 2));
        combinations.addCards(new Card(3, 1));
        combinations.addCards(new Card(5, 3));
        combinations.addCards(new Card(5, 2));
        combinations.addCards(new Card(5, 4));
        combinations.addCards(new Card(12, 4));
        combinations.calculate();
        assertEquals(75.1206, combinations.calculatePower(), 0.00001);
    }


    @Test
    public void highCard() {
        cards.add(new Card(6, 1));
        cards.add(new Card(2, 2));
        cards.add(new Card(3, 1));
        cards.add(new Card(9, 2));
        cards.add(new Card(10, 1));
        cards.add(new Card(5, 4));
        cards.add(new Card(12, 4));
        int size = cards.size();
        combinations.addCards(new Card(6, 1));
        combinations.addCards(new Card(2, 2));
        combinations.addCards(new Card(3, 1));
        combinations.addCards(new Card(9, 2));
        combinations.addCards(new Card(10, 1));
        combinations.addCards(new Card(5, 4));
        combinations.addCards(new Card(12, 4));
        combinations.calculate();
        assertEquals(12.10090605, combinations.calculatePower(), 0.000000001);
        getCombinationName();
        // String combMane = "High card " + cards.get(size - 1).getNameValue()
        assertEquals("High card QUEEN", "High card " + cards.get(size - 1).getNameValue());
    }

    @Test
    public void straightToFive() {
        combinations.addCards(new Card(12, 2));
        combinations.addCards(new Card(13, 3));
        combinations.addCards(new Card(9, 1));
        combinations.addCards(new Card(2, 3));
        combinations.addCards(new Card(8, 1));
        combinations.addCards(new Card(7, 2));
        combinations.addCards(new Card(10, 1));
        combinations.addCards(new Card(3, 2));
        combinations.addCards(new Card(4, 1));
        combinations.addCards(new Card(5, 4));
        combinations.addCards(new Card(14, 4));
        combinations.calculate();
        combinations.calculatePower();
        assertEquals(95.0, combinations.getPower(), 0.0);
        assertEquals("Straight to FIVE", combinations.getCombinationName());
    }

    @Test
    public void notStraightToFiveAfterAce() {
        combinations.addCards(new Card(12, 2));
        combinations.addCards(new Card(10, 2));
        combinations.addCards(new Card(7, 1));
        combinations.addCards(new Card(6, 4));
        combinations.addCards(new Card(14, 4));
        combinations.calculate();
        combinations.calculatePower();
    }
    @Test
    public void notStraightToFiveAfterTwo() {
        combinations.addCards(new Card(12, 2));
        combinations.addCards(new Card(10, 2));
        combinations.addCards(new Card(7, 1));
        combinations.addCards(new Card(2, 4));
        combinations.addCards(new Card(14, 4));
        combinations.calculate();
        combinations.calculatePower();
    }
    @Test
    public void notStraightToFiveAfterThree() {
        combinations.addCards(new Card(12, 2));
        combinations.addCards(new Card(10, 2));
        combinations.addCards(new Card(3, 1));
        combinations.addCards(new Card(2, 4));
        combinations.addCards(new Card(14, 4));
        combinations.calculate();
        combinations.calculatePower();
    }
    @Test
    public void notStraightToFiveAfterFour() {
        combinations.addCards(new Card(12, 2));
        combinations.addCards(new Card(4, 2));
        combinations.addCards(new Card(3, 1));
        combinations.addCards(new Card(2, 4));
        combinations.addCards(new Card(14, 4));
        combinations.calculate();
        combinations.calculatePower();
    }

    @Test
    public void flush() {
        combinations.addCards(new Card(2, 2));
        combinations.addCards(new Card(3, 2));
        combinations.addCards(new Card(4, 2));
        combinations.addCards(new Card(7, 3));
        combinations.addCards(new Card(11, 2));
        combinations.addCards(new Card(5, 2));
        combinations.addCards(new Card(14, 4));
        combinations.calculate();
        assertEquals(131.1105040302, combinations.calculatePower(), 0.0);
    }

    @Test
    public void fullHouse() {
        combinations.addCards(new Card(2, 2));
        combinations.addCards(new Card(2, 1));
        combinations.addCards(new Card(4, 4));
        combinations.addCards(new Card(11, 3));
        combinations.addCards(new Card(11, 1));
        combinations.addCards(new Card(11, 2));
        combinations.addCards(new Card(14, 4));
        combinations.calculate();
        assertEquals(151.02, combinations.calculatePower(), 0.0);
    }

    @Test
    public void fourOfKind() {
        combinations.addCards(new Card(2, 2));
        combinations.addCards(new Card(11, 4));
        combinations.addCards(new Card(4, 4));
        combinations.addCards(new Card(11, 3));
        combinations.addCards(new Card(11, 1));
        combinations.addCards(new Card(11, 2));
        combinations.addCards(new Card(14, 4));
        combinations.calculate();
        assertEquals(171.2, combinations.calculatePower(), 0.0);
    }

    @Test
    public void straightFlush() {
        combinations.addCards(new Card(2, 2));
        combinations.addCards(new Card(7, 4));
        combinations.addCards(new Card(6, 4));
        combinations.addCards(new Card(8, 4));
        combinations.addCards(new Card(11, 1));
        combinations.addCards(new Card(10, 4));
        combinations.addCards(new Card(9, 4));
        combinations.calculate();
        assertEquals(190.0, combinations.calculatePower(), 0.0);
    }

    @Test
    public void straightFlushToFive() {
        combinations.addCards(new Card(2, 4));
        combinations.addCards(new Card(3, 4));
        combinations.addCards(new Card(4, 4));
        combinations.addCards(new Card(5, 4));
        combinations.addCards(new Card(14, 4));
        combinations.addCards(new Card(10, 1));
        combinations.addCards(new Card(9, 2));
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
        Card card = new Card(6, 1);
        Card card2 = new Card(6, 2);
        combinations.addCards(card);
        combinations.addCards(card2);
        cards.add(card);
        cards.add(card2);
        assertEquals(2, cards.size());

    }

    @Test
    public void setCards() {
        Card card = new Card(2, 4);
        Card card2 = new Card(3, 4);
        combinations.setCards(cards);
        cards.add(card);
        cards.add(card2);
        assertEquals(cards.get(1), combinations.getCard(1));
    }
}
