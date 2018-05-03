package com.model;

import org.junit.Test;


import java.util.ArrayList;

import static org.junit.Assert.*;

public class PlayerTest {

    @Test
    public void isWinner() {
        Player player = new Player();
        assertEquals(false,player.isWinner());
    }

    @Test
    public void setWinner() {
        Player player = new Player();
        player.setWinner(true);
        assertEquals(true, player.isWinner());
    }
    @Test
    public void isInGame() {
        Player player = new Player();
        assertEquals(true, player.isInGame());

    }

    @Test
    public void getChips() {
        Player player = new Player();
        assertEquals(0, player.getChips());

    }
    @Test
    public void setChips() {
        Player player = new Player();
        player.setChips(150);
        assertEquals(150, player.getChips());

    }
    @Test
    public void isAllIn() {
        Player player = new Player();
        assertEquals(false, player.isAllIn());
    }
    @Test
    public void clearChips() {
        Player player = new Player();
        player.clearChips();
        assertEquals(0, player.getChips());

    }
    @Test
    public void getStackValue() {
        Player player = new Player();
        player.addStack(250);
        assertEquals(250, player.getStackValue());

    }

    @Test
    public void getCard() {
        Player player = new Player();
        ArrayList<Card> cards = new ArrayList<>();
        Card card2_2 = new Card(2,2);
        Card card3_2 = new Card(3,2);
        player.setCards(card2_2);
        player.setCards(card3_2);
        cards.add(card2_2);
        cards.add(card3_2);
        assertEquals(card2_2, player.getCard(0));
    }
    @Test
    public void getCards() {
        Player player = new Player();
        ArrayList<Card> cards = new ArrayList<>();
        Card card2_2 = new Card(2,2);
        Card card3_2 = new Card(3,2);
        player.setCards(card2_2);
        player.setCards(card3_2);
        cards.add(card2_2);
        cards.add(card3_2);
        assertEquals(cards, player.getCards());
    }
   /* @Test
    public void getComvination() {
        Player player = new Player();
        ArrayList<Card> cards = new ArrayList<>();
        Combinations combinations = new Combinations();
        Card card2_2 = new Card(2,2);
        Card card3_2 = new Card(3,2);
        Card card4_2 = new Card(4,2);
        Card card5_2 = new Card(5,2);
        Card card6_2 = new Card(6,2);
        Card card7_2 = new Card(7,2);
        Card card8_2 = new Card(8,2);
        player.setCards(card2_2);
        player.setCards(card3_2);
        cards.add(card2_2);
        cards.add(card3_2);
        cards.add(card4_2);
        cards.add(card5_2);
        cards.add(card6_2);
        cards.add(card7_2);
        cards.add(card8_2);


        assertEquals(cards, player.getCards());
    }*/

}