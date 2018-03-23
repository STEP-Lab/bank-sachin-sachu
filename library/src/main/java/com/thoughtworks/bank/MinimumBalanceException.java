package com.thoughtworks.bank;

public class MinimumBalanceException extends Exception {
    public MinimumBalanceException() {
        super("Insufficient minimum balance");
    }
}
