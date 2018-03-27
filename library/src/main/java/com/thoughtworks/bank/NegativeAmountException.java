package com.thoughtworks.bank;

public class NegativeAmountException extends Exception {
    public NegativeAmountException() { super("Negative amount"); }
}
