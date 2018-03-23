package com.thoughtworks.bank;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Account {
    private static final int MINIMUM_BALANCE = 1000;
    private final String accountNumber;
    private double balance;

    public Account(String accountNumber, double balance) throws MinimumBalanceException, InvalidAccountNumberException {
        checkForValidAccountNumber(accountNumber);
        this.accountNumber = accountNumber;
        if(balance < MINIMUM_BALANCE) throw new MinimumBalanceException();
        this.balance = balance;
    }

    private static void checkForValidAccountNumber(String accNumber) throws InvalidAccountNumberException {
        Pattern pattern = Pattern.compile("[\\d]{4}-[\\d]{4}");
        Matcher matcher = pattern.matcher(accNumber);
        if(!matcher.matches()) throw new InvalidAccountNumberException();
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}
