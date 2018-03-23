package com.thoughtworks.bank;

public class Account {
    private static final int MINIMUM_BALANCE = 1000;
    private final String accountNumber;
    private int balance;

    public Account(String accountNumber, int balance) throws MinimumBalanceException {
        this.accountNumber = accountNumber;
        if(balance < MINIMUM_BALANCE) throw new MinimumBalanceException();
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}
