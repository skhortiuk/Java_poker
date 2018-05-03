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
   /* @Test
    public void getCards() {
        Player player = new Player();
        Card card2_2 = new Card(2,2);
        Card card3_2 = new Card(3,2);
        player.setCards(card2_2);
        player.setCards(card3_2);
        assertEquals(card2_2, player.getCard(1));

    }*/

}