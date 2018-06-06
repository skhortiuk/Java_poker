package com.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Combinations {
    private double power;
    private List<Card> cards = new ArrayList<>();
    private String combinationName;


    Combinations() {
        this.power = 0.00000;
    }

    String getCombinationName() {
        return combinationName;
    }

    void setCombinationName(String string) {
        combinationName = string;
    }

    void addCards(Card card) {
        this.cards.add(card);
    }


    Card getCard(int number) {
        return this.cards.get(number);
    }

    double getPower() {
        return this.power;
    }

    void setPower(double numbpower) {
        power = numbpower;
    }

    void calculate() {
        cards.sort(Comparator.comparing(Card::getValue));
        this.power = calculatePower();
    }

    double calculatePower() {
        double combination;
        combination = straightFlush();
        if ((int) combination != 0)
            return combination;
        combination = fourOfKind();
        if ((int) combination != 0)
            return combination;
        combination = fullHouse();
        if ((int) combination != 0)
            return combination;
        combination = flush();
        if ((int) combination != 0)
            return combination;
        combination = straight();
        if ((int) combination != 0)
            return combination;
        combination = threeOfaKind();
        if ((int) combination != 0)
            return combination;
        combination = twoPair();
        if ((int) combination != 0)
            return combination;
        combination = onePair();
        if ((int) combination != 0)
            return combination;
        combination = highCard();
        if ((int) combination != 0)
            return combination;
        return 0;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    private double highCard() {
        if (cards.isEmpty())
            return 0;
        int size = cards.size();
        double result = 0;
        double cof = 1;
        combinationName = "High card " + cards.get(size - 1).getNameValue();
        for (int i = 0; i < size; i++) {
            if (i == 5)
                break;
            result += cards.get(size - (i + 1)).getValue() * cof;
            cof *= 0.01;
        }
        return result;
    }

    private double onePair() {
        if (cards.size() < 2)
            return 0;
        int size = cards.size();
        for (int i = size - 1; i > 0; i--) {
            if (cards.get(i).getValue() == cards.get(i - 1).getValue()) {
                double hc = 0.0;
                double d = 0.01;
                int pair2 = i - 1;
                int kicker = 0;
                for (int j = size - 1; j >= 0; j--) {
                    if (kicker == 3) {
                        break;
                    }
                    if (j != i && j != pair2) {
                        kicker++;
                        hc += (double) cards.get(j).getValue() * d;
                        d *= 0.01;
                    }
                }
                combinationName = "Pair of " + cards.get(i).getNameValue();
                return 20.0 + (double) cards.get(i).getValue() + hc;
            }
        }
        return 0;
    }

    private double twoPair() {
        if (cards.size() < 4) {
            return 0;
        }
        int firstPair = 0;
        int secondPair = 0;
        boolean isTwoPair = false;
        double hc = 0.0;
        int size = cards.size();
        for (int i = size - 1; i > 0; i--) {
            if ((cards.get(i).getValue() == cards.get(i - 1).getValue()) && (firstPair == 0)) {
                combinationName = "TWO pairs of " + cards.get(i).getNameValue();
                firstPair = cards.get(i).getValue();
                continue;
            }
            if ((firstPair != 0) && (cards.get(i).getValue() == cards.get(i - 1).getValue())) {
                combinationName = String.format("%s and %s", combinationName, cards.get(i).getNameValue());
                secondPair = cards.get(i).getValue();
                isTwoPair = true;
                break;
            }
        }
        if (isTwoPair) {
            for (int i = size - 1; i >= 0; i--) {
                if (secondPair == cards.get(i).getValue() || firstPair == cards.get(i).getValue())
                    continue;
                hc += (double) cards.get(i).getValue() * 0.0001;
                break;
            }
            return 40.0 + (double) firstPair + (double) secondPair * 0.01 + hc;
        }
        return 0;
    }

    private double threeOfaKind() {
        if (cards.size() < 3) {
            return 0;
        }
        int size = cards.size();
        double hc = 0.0;
        double d = 0.01;
        boolean isThreeOfaKind = false;
        int card = 0;
        for (int i = size - 1; i > 1; i--) {
            if (cards.get(i).getValue() == cards.get(i - 1).getValue() && cards.get(i).getValue() == cards.get(i - 2).getValue()) {
                combinationName = "THREE of a kind " + cards.get(i).getNameValue();
                card = cards.get(i).getValue();
                isThreeOfaKind = true;
                break;
            }
        }
        if (isThreeOfaKind) {
            int tmp = 0;
            for (int i = size - 1; i >= 0; i--) {
                if (card == cards.get(i).getValue())
                    continue;
                if (tmp == 2)
                    break;
                hc += (double) cards.get(i).getValue() * d;
                d *= 0.01;
                tmp++;
            }
            return 70 + (double) card + hc;
        }
        return 0;
    }

    private double straight() {
        if (cards.size() < 5) {
            return 0;
        }
        int size = cards.size();
        int valueCard;
        int hc;
        for (int i = size - 1; i >= 0; i--) {
            valueCard = cards.get(i).getValue();
            hc = i;
            for (int j = i; j >= 0; j--) {
                if (valueCard - 1 == cards.get(j).getValue()) {
                    valueCard--;
                    for (int k = j; k >= 0; k--) {
                        if (valueCard - 1 == cards.get(k).getValue()) {
                            valueCard--;
                            for (int l = k; l >= 0; l--) {
                                if (valueCard - 1 == cards.get(l).getValue()) {
                                    valueCard--;
                                    for (int m = l; m >= 0; m--) {
                                        if (valueCard - 1 == cards.get(m).getValue()) {
                                            combinationName = "Straight to " + cards.get(hc).getNameValue();
                                            return 90 + cards.get(hc).getValue();
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        if ((cards.get(size - 1).getValue() == 14))
            if ((cards.get(0).getValue() == 2))
                for (int i = 1; i < size; i++) {
                    if (cards.get(i).getValue() == 3)
                        for (int j = i; j < size; j++) {
                            if (cards.get(j).getValue() == 4)
                                for (int k = j; k < size; k++) {
                                    if (cards.get(k).getValue() == 5)
                                        combinationName = "Straight to FIVE";
                                    return 95;
                                }
                        }
                }
        return 0;
    }

    private double flush() {
        if (cards.size() < 5) {
            return 0;
        }
        int size = cards.size();
        int tmp = 1;
        int hsuitc = 0;
        double d = 0.01;
        double hc = 0.0;
        for (int suit = 0; suit < 5; suit++) {
            for (int i = size - 1; i >= 0; i--) {
                if (cards.get(i).getSuitValue() == suit) {
                    tmp++;
                    if (tmp == 2)
                        hsuitc = i;
                }
                if (tmp == 6) {
                    int number = 0;
                    for (int j = size - 1; j >= 0; j--) {
                        if (number > 4)
                            continue;
                        if (suit == cards.get(j).getSuitValue()) {
                            hc += (double) cards.get(j).getValue() * d;
                            d *= 0.01;
                            number++;
                        }
                    }
                    combinationName = "Flush to " + cards.get(hsuitc).getNameValue();
                    return 120.0 + (double) cards.get(hsuitc).getValue() + hc;
                }
            }
            tmp = 1;
            hsuitc = 0;
        }
        return 0;
    }

    private double fullHouse() {
        if (cards.size() < 5) {
            return 0;
        }
        if ((int) onePair() != 0 && (int) threeOfaKind() != 0) {
            int size = cards.size();
            String one = null;
            int one_int = 0;
            for (int i = size - 1; i > 1; i--) {
                if (cards.get(i).getValue() == cards.get(i - 1).getValue() && cards.get(i).getValue() == cards.get(i - 2).getValue()) {
                    one = cards.get(i).getNameValue();
                    one_int = cards.get(i).getValue();
                    break;
                }
            }
            for (int i = size - 1; i > 0; i--) {
                if (cards.get(i).getValue() == one_int)
                    continue;
                if (cards.get(i).getValue() == cards.get(i - 1).getValue()) {
                    combinationName = "Full house " + one + " of " + cards.get(i).getNameValue();
                    return 140.0 + (double) one_int + (double) cards.get(i).getValue() * 0.01;
                }
            }
        }
        return 0;
    }

    private double fourOfKind() {
        if (cards.size() < 4) {
            return 0;
        }
        int size = cards.size();
        double hc = 0;
        for (int i = size - 1; i > 2; i--) {
            if (cards.get(i).getValue() == cards.get(i - 1).getValue() && cards.get(i).getValue() == cards.get(i - 2).getValue() && cards.get(i).getValue() == cards.get(i - 3).getValue()) {
                for (int j = size - 1; j >= 0; j--) {
                    if (cards.get(i).getValue() != cards.get(j).getValue()) {
                        if ((int) hc != 0)
                            continue;
                        hc += (double) cards.get(j).getValue() * 0.01;
                    }
                }
                combinationName = "FOUR of a kind " + cards.get(i).getNameValue();
                return 160.0 + (double) cards.get(i).getValue() + hc;
            }
        }
        return 0;
    }

    private double straightFlush() {
        if (cards.size() < 5) {
            return 0;
        }
        int size = cards.size();
        int cardSuit;
        int valueCard;
        int hc;
        for (int i = size - 1; i >= 0; i--) {
            valueCard = cards.get(i).getValue();
            cardSuit = cards.get(i).getSuitValue();
            hc = i;
            for (int j = i; j >= 0; j--) {
                if (valueCard - 1 == cards.get(j).getValue() && cardSuit == cards.get(j).getSuitValue()) {
                    valueCard--;
                    for (int k = j; k >= 0; k--) {
                        if (valueCard - 1 == cards.get(k).getValue() && cardSuit == cards.get(k).getSuitValue()) {
                            valueCard--;
                            for (int l = k; l >= 0; l--) {
                                if (valueCard - 1 == cards.get(l).getValue() && cardSuit == cards.get(l).getSuitValue()) {
                                    valueCard--;
                                    for (int m = l; m >= 0; m--) {
                                        if (valueCard - 1 == cards.get(m).getValue() && cardSuit == cards.get(m).getSuitValue()) {
                                            combinationName = "Straight flush to " + cards.get(hc).getNameValue();
                                            return 180 + cards.get(hc).getValue();
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        cardSuit = cards.get(size - 1).getSuitValue();
        if ((cards.get(size - 1).getValue() == 14) && (cards.get(0).getValue() == 2) && (cards.get(0).getSuitValue() == cardSuit)) {
            for (int i = 1; i < size; i++) {
                if (cards.get(i).getValue() == 3 && cards.get(i).getSuitValue() == cardSuit) {
                    for (int j = i; j < size; j++) {
                        if (cards.get(j).getValue() == 4 && cards.get(j).getSuitValue() == cardSuit) {
                            for (int k = j; k < size; k++) {
                                if (cards.get(k).getValue() == 5 && cards.get(k).getSuitValue() == cardSuit) {
                                    combinationName = "Straight flush to FIVE";
                                    return 180;
                                }
                            }
                        }
                    }
                }
            }
        }
        return 0;
    }
}