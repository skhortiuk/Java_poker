package com.model;

public class Stack {
    private int value = 0;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean ifCanTakeStack(int number) {
        return value - number > 0;
    }


    public void getStack(int number) {
        value -= number;
    }
}
