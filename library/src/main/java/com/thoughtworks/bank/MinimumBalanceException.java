package com.thoughtworks.bank;

public class MinimumBalanceException extends Exception {
    MinimumBalanceException() {
        super("Insufficient minimum balance");
    }
}
