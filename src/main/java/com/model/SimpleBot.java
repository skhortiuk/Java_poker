package com.model;

import java.util.ArrayList;


public class SimpleBot implements Bot {

    Combinations combinations = new Combinations();

    @Override
    public int think(ArrayList<Card> cards, int stack, int bank, int prevRate) {
        combinations.setCards(cards);
        combinations.calculate();
        double power = combinations.getPower();
        if (stack > 750) {
//            if can check
            if (prevRate == 0) {
                if (power >= 40) {
                    return 200;
                }
//                if have good hand
                if (power >= 20) {
                    return 100;
                }
//                if have simple hand
                else {
                    return 0;
                }
            }
//            if need call
            if (prevRate > 0) {
                if (power >= 70) {
                    if (prevRate >= 500) {
                        return prevRate;
                    } else {
                        return 500;
                    }
                }
                if (power >= 50) {
                    if (bank <= 800) {
                        if (prevRate <= 100) {
                            return prevRate+150;
                        }
                    } else {
                        return prevRate;
                    }
                }
                if (power >= 40) {
                    if (bank <= 600) {
                        return prevRate+100;
                    } else {
                        return prevRate;
                    }
                }
                if (power >= 20) {
                    return prevRate;
                } else {
                    return -1;
                }
            }
        }
        if (power >= 70) {
            return stack;
        }

        if (prevRate == 0) {
            return 0;
        }
        return -1;
    }
}
