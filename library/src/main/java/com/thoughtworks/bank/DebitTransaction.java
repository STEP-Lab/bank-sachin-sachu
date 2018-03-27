package com.thoughtworks.bank;

import java.util.Date;

public class DebitTransaction extends Transaction{

    public DebitTransaction(Date date, double amount, String to) {
        super(date, amount, to);
    }

    public DebitTransaction(double amount, String to) {
        super(new Date(), amount, to);
    }
}
