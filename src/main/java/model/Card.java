package model;

public class Card {
    private Cards card;
    private Suit suit;

    //    Constructor
    Card(int valueCard, int suitCard) {
        initCard(valueCard);
        initSuit(suitCard);
    }

    String getNameValue() {
        return card.name();
    }

    public int getSuitValue() {
        return suit.getValue();
    }

    public int getValue() {
        return card.getValue();
    }

    //    Initialization card from int to string
    private void initCard(int val) {
        card = Cards.values()[val - 2];
    }

    private void initSuit(int st) {
        suit = Suit.values()[st - 1];
    }

    enum Cards {
        Two, Three, Four, Five, Six, Seven, Eight, Nine, Ten, Jack, Queen, King, Ace;

        public int getValue() {
            return ordinal() + 2;
        }
    }

    enum Suit {
        Spades, Clubs, Hearts, Diamonds;

        public int getValue() {
            return ordinal() + 1;
        }
    }
}

/*
2 = Two
3 = Three
4 = Four
5 = Five
6 = Six
7 = Seven
8 = Eight
9 = Nine
10 = Ten
11 = Jack
12 = Queen
13 = King
14 = Ace
 */
/*
1 = Spades
2 = Clubs
3 = Hearts
4 = Diamonds
 */