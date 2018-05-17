package com.model;

import org.junit.Before;
import org.junit.Test;


import java.util.ArrayList;
import java.util.Stack;

import static org.junit.Assert.*;

public class PlayerTest {
    private Player player;



    @Before
    public  void  beforePlayerTests() throws Exception{
        player = new Player();

    }

    @Test
    public void isWinner() {
        assertEquals(false,player.isWinner());
    }

    @Test
    public void setWinner() {
        player.setWinner(true);
        assertEquals(true, player.isWinner());
    }
    @Test
    public void isInGame() {
        assertEquals(true, player.isInGame());

    }
    @Test
    public void setInGame() {
        player.setInGame(false);
        assertEquals(false, player.isInGame());
    }
    @Test
    public void isAllIn() {
        assertEquals(false, player.isAllIn());
    }
    @Test
    public void setAllIn() {
        player.setAllIn(true);
        assertEquals(true, player.isAllIn());
    }


    @Test
    public void getChips() {
        assertEquals(0, player.getChips());

    }
    @Test
    public void setChips() {
        player.setChips(150);
        assertEquals(150, player.getChips());

    }
    @Test
    public void getCard() {
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
        ArrayList<Card> cards = new ArrayList<>();
        Card card2_2 = new Card(2,2);
        Card card3_2 = new Card(3,2);
        player.setCards(card2_2);
        player.setCards(card3_2);
        cards.add(card2_2);
        cards.add(card3_2);
        assertEquals(cards, player.getCards());
    }

    @Test
    public void addStack() {
        player.addStack(400);
        assertEquals(400, player.getStackValue());
    }

    @Test
    public void getStack() {
        int numSt = 200;
        player.addStack(numSt+200);//add 400
        player.getStack(numSt);//sub 200
        assertEquals(numSt, player.getStackValue());
    }

    @Test
    public void  getStackAllInTrue() {
        player.addStack(200);
        player.getStack(250);
       // assertEquals(0, player.getStackValue());
        assertEquals(true, player.isAllIn());
    }

    @Test
    public void clearChips() {
        player.clearChips();
        assertEquals(0, player.getChips());

    }
    @Test
    public void getStackValue() {
        player.addStack(250);
        assertEquals(250, player.getStackValue());

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