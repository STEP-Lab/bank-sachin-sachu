package com.thoughtworks.bank;

public class InvalidAccountNumberException extends Exception {
    InvalidAccountNumberException() {
        super("Invalid account number");
    }
}
