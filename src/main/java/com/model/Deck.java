package com.model;

import java.util.Collections;
import java.util.Stack;

public class Deck {

    public Stack<Card> getCards() {
        return cards;
    }

    private Stack<Card> cards = new Stack<>();

    public void refill() {
        cards.clear();
        for (int i = 1; i < 5; i++) {
            for (int j = 2; j <= 14; j++) {
                cards.add(new Card(j, i));
            }
        }
        shuffle();
    }
    public void creator() {
        cards.clear();
        for (int i = 1; i < 5; i++) {
            for (int j = 2; j <= 14; j++) {
                cards.add(new Card(j, i));
            }
        }
    }

    private void shuffle() {
        Collections.shuffle(this.cards);
        Collections.shuffle(this.cards);
        Collections.shuffle(this.cards);
        Collections.shuffle(this.cards);
    }

    public Card getCard() {
        return cards.pop();
    }

}