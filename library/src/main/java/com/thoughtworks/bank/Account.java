package com.thoughtworks.bank;

public class Account {
    private final String accountNo;
    private int balance;

    public Account(String accountNo, int balance) {
        this.accountNo = accountNo;
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }
}
