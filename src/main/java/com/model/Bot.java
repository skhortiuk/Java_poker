package com.model;

import java.util.ArrayList;

public interface Bot {

    /**
     * com.Main function for bots
     *
     * @param cards    the collection who elements can be used for bot manipulations.
     *                 For more info about methods with cards see class (com.model.Card)
     * @param stack    the number of chips the current bot has
     * @param bank     the number of chips that can be taken by the bot in the event of a win
     * @param prevRate the last bet of the previous player to be taken to continue the game
     * @return if value of return less than zero then bot make a fold
     * if value of return zero then bot make check
     * !!! Always check if the bot can actually make a check
     * if value of return more than zero then bot make bet/raise by this value
     */
    int think(ArrayList<Card> cards, int stack, int bank, int prevRate);
}
