package com.thoughtworks.bank;

import java.util.Date;

public class Account {
    private static final int MINIMUM_BALANCE = 1000;
    private final AccountNumber accountNumber;
    private Transactions transactions;
    private Money balance;

    public Account(Money money, AccountNumber accountNumber) throws MinimumBalanceException {
        if(money.getAmount() < MINIMUM_BALANCE) throw new MinimumBalanceException();
        this.balance = money;
        this.accountNumber = accountNumber;
        this.transactions = new Transactions();
    }

    public double getBalance() {
        return balance.getAmount();
    }

    public String getAccountNumber() {
        return accountNumber.getAccNumber();
    }

    public void debit(double amount, String otherAccount) throws NegativeAmountException {
        balance.deduct(amount);
        transactions.debit(new Date(), amount, otherAccount);
    }

    public void credit(double amount, String otherAccount) throws NegativeAmountException {
        balance.add(amount);
        transactions.credit(new Date(), amount, otherAccount);
    }
}
