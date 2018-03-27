package com.thoughtworks.bank;

import java.util.Currency;
import java.util.Locale;

public class Money {
    private double amount;
    private final Currency currency;

    public Money(Locale locale, double amount) throws NegativeAmountException {
        if(amount < 0) throw new NegativeAmountException();
        this.currency = Currency.getInstance(locale);
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public void deduct(double amount) throws NegativeAmountException {
        if(this.amount - amount < 0) throw new NegativeAmountException();
        this.amount -= amount;
    }

    public void add(double amount) throws NegativeAmountException {
        if(amount < 0) throw new NegativeAmountException();
        this.amount += amount;
    }

    public String getCurrency() {
        return currency.getCurrencyCode();
    }
}
