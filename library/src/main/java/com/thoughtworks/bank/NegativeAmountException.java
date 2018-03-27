package com.thoughtworks.bank;

public class NegativeAmountException extends Exception {
    NegativeAmountException() { super("Negative amount"); }
}
