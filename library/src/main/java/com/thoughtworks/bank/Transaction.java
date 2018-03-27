package com.thoughtworks.bank;

import java.util.Date;
import java.util.Objects;

public class Transaction {
    private final Date date;
    private final double amount;
    private final String to;

    public Transaction(Date date, double amount, String to) {
        this.date = date;
        this.amount = amount;
        this.to = to;
    }

    public double getAmount() {
        return amount;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Objects.equals(amount, that.amount) &&
                Objects.equals(to, that.to);
    }

    @Override
    public int hashCode() {

        return Objects.hash(amount, to);
    }
}
