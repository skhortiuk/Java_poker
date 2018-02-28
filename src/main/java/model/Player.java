package model;

import java.util.ArrayList;

public class Player {
    public boolean isWinner = false;
    public boolean inGame;
    public boolean allIn = false;
    private Combinations combinations;
    private int Chips = 0;
    private ArrayList<Card> cards = new ArrayList<>();
    private ArrayList<Card> handCard = new ArrayList<>();
    private Stack stack;

    public Player() {
        this.combinations = new Combinations();
        stack = new Stack();
        this.inGame = true;
    }

    public int getChips() {
        return Chips;
    }

    public void setChips(int chips) {
        Chips = chips;
    }

    public Card getCard(int number) {
        return this.cards.get(number);
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void addStack(int number) {
        stack.setValue(number);
    }

    public void getStack(int number) {
        if (stack.ifCanTakeStack(number)) {
            stack.getStack(number);
        } else {
            allIn = true;
        }
    }

    public void clearChips() {
        this.Chips = 0;
    }

    public int getStackValue() {
        return this.stack.getValue();
    }

    public double getPower() {
        this.combinations.calculate();
        return this.combinations.getPower();
    }

    public String getCombinationName() {
        return this.combinations.getCombinationName();
    }

    public void del() {
        this.isWinner = false;
        this.inGame = false;
        cards.clear();
    }

    public ArrayList<Card> getHandCard() {
        return handCard;
    }

    public void setCards(Card card) {
        if (handCard.size() < 2) {
            handCard.add(card);

        }
        this.cards.add(card);
        this.combinations.addCards(card);
    }
}
