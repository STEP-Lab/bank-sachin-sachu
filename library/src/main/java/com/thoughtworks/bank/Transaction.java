package com.thoughtworks.bank;

import java.util.Date;
import java.util.Objects;

public class Transaction {
    private final Date date;
    private String type;
    private final double amount;
    private final String source;

    Transaction(Date date, String type, double amount, String source) {
        this.date = date;
        this.type = type;
        this.amount = amount;
        this.source = source;
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
                Objects.equals(source, that.source);
    }

    @Override
    public String toString() {
        return date +
                "," + type + "," + amount +
                "," + source;
    }
}
