package com.models;

import java.util.*;

public class Bank {
    private final String bankName;
    private final Map<String, Borrower> borrowerMap;

    public Bank(String bankName) {
        this.bankName = bankName;
        borrowerMap = new HashMap<>();
    }

    public String getBankName() {
        return bankName;
    }

    public Borrower getBorrower(String borrowerName) {
        return borrowerMap.get(borrowerName);
    }

    public Borrower addBorrower(String borrowerName) {
        Borrower borrower = null;
        if(!borrowerMap.containsKey(borrowerName)) {
            borrower = new Borrower(borrowerName);
            borrower.setBorrowerBank(this);
            this.borrowerMap.put(borrowerName, borrower);
        }
        return borrower;
    }
}
