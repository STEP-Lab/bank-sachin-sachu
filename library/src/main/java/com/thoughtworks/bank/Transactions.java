package com.thoughtworks.bank;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;

public class Transactions {
    public ArrayList<Transaction> list;

    public Transactions() {
        this.list = new ArrayList<>();
    }

    public void debit(Date date, double amount, String otherAccount) {
        this.list.add(new DebitTransaction(date, amount, otherAccount));
    }

    public void credit(Date date, double amount, String otherAccount) {
        this.list.add(new CreditTransaction(date, amount, otherAccount));
    }

    public Transactions filterByAmountGreaterThan(double amount) {
        Transactions result = new Transactions();
        for (Transaction transaction : list) {
            if (transaction.getAmount() > amount) {
                result.list.add(transaction);
            }
        }
        return result;
    }

    public void print(PrintWriter writer){
        for (Transaction transaction : list) {
            writer.println(transaction.toString());
        }
    }

    public Transactions filterCredit() {
        Transactions result = new Transactions();
        for (Transaction transaction : list) {
            if (transaction instanceof CreditTransaction) {
                result.list.add(transaction);
            }
        }
        return result;
    }

    public Transactions filterDebit() {
        Transactions result = new Transactions();
        for (Transaction transaction : list) {
            if (transaction instanceof DebitTransaction) {
                result.list.add(transaction);
            }
        }
        return result;
    }

    public void printToCsv(PrintWriter writer) {
        writer.println("date,type,amount,source");
        for (Transaction transaction : list) {
            writer.println(transaction.toString());
        }
    }
}
