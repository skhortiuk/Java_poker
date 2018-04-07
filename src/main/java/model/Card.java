package model;

public class Card {
    private Cards one_card;
    private Suit suit;

    //    Constructor
    Card(int valueCard, int suitCard) {
        initCard(valueCard);
        initSuit(suitCard);
    }

    String getNameValue() {
        return one_card.name();
    }

    public int getSuitValue() {
        return suit.getValue();
    }

    public int getValue() {
        return one_card.getValue();
    }

    //    Initialization one_card from int to string
    private void initCard(int val) {
        one_card = Cards.values()[val - 2];
    }

    private void initSuit(int st) {
        suit = Suit.values()[st - 1];
    }

    enum Cards {
        TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE;

        public int getValue() {
            return ordinal() + 2;
        }
    }

    enum Suit {
        SPADES, CLUBS, HEARTS, DIAMONDS;

        public int getValue() {
            return ordinal() + 1;
        }
    }
}

/*
2 = TWO
3 = THREE
4 = FOUR
5 = FIVE
6 = SIX
7 = SEVEN
8 = EIGHT
9 = NINE
10 = TEN
11 = JACK
12 = QUEEN
13 = KING
14 = ACE
 */
/*
1 = SPADES
2 = CLUBS
3 = HEARTS
4 = DIAMONDS
 */