package com.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    Player player = new Player();

    @Test
    void isWinner() {
        boolean actual = player.isWinner();
        assertFalse(actual);
    }


    @Test
    void isInGame() {
        boolean actual = player.isInGame();
        assertTrue(actual);
    }


    @Test
    void isAllIn() {
        boolean actual = player.isAllIn();
        assertFalse(actual);
    }

    @Test
    void setAllIn() {
    }

    @Test
    void getChips() {
    }

    @Test
    void setChips() {
    }

    @Test
    void getCard() {
    }

    @Test
    void getCards() {
    }

    @Test
    void addStack() {
    }

    @Test
    void getStack() {
    }

    @Test
    void clearChips() {
    }

    @Test
    void getStackValue() {
    }

    @Test
    void getPower() {
    }

    @Test
    void getCombinationName() {
    }

    @Test
    void del() {

    }

    @Test
    void getHandCard() {
    }

    @Test
    void setCards() {
    }
}