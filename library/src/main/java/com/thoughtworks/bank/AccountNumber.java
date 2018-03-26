package com.thoughtworks.bank;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AccountNumber {
    private String accNumber;

    public AccountNumber(String accNumber) throws InvalidAccountNumberException {
        Pattern pattern = Pattern.compile("[\\d]{4}-[\\d]{4}");
        Matcher matcher = pattern.matcher(accNumber);
        if(!matcher.matches()) throw new InvalidAccountNumberException();
        this.accNumber = accNumber;
    }

    public String getAccNumber() {
        return accNumber;
    }
}
