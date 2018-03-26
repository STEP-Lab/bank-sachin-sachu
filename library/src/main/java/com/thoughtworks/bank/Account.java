package com.thoughtworks.bank;

public class Account {
    private static final int MINIMUM_BALANCE = 1000;
    private final AccountNumber accountNumber;
    private double balance;

    public Account(AccountNumber accountNumber, double balance) throws MinimumBalanceException {
        this.accountNumber = accountNumber;
        checkForMinimumBalance(balance, MINIMUM_BALANCE);
        this.balance = balance;
    }

    private static void checkForMinimumBalance(double amount, double minimumBalance) throws MinimumBalanceException {
        if(amount < minimumBalance) throw new MinimumBalanceException();
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber.getAccNumber();
    }

    public void debit(double amount) throws MinimumBalanceException {
        if(balance - amount < 0) throw new MinimumBalanceException();
        balance -= amount;
    }

}
