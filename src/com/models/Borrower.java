package com.models;

import java.util.UUID;

public class Borrower {
    private String borrowerName;
    private final String borrowerId;
    private Bank borrowerBank;
    private Loan loanAvailed;

    public Borrower(String borrowerName) {
        this.borrowerName = borrowerName;
        this.borrowerId = UUID.randomUUID().toString();
    }

    public String getBorrowerName() {
        return borrowerName;
    }

    public Bank getBorrowerBank() {
        return borrowerBank;
    }

    public Loan getLoanAvailed() {
        return loanAvailed;
    }

    public Borrower setBorrowerName(String borrowerName) {
        this.borrowerName = borrowerName;
        return this;
    }

    public Borrower setBorrowerBank(Bank borrowerBank) {
        this.borrowerBank = borrowerBank;
        return this;
    }

    public Borrower setLoanAvailed(Loan loanAvailed) {
        this.loanAvailed = loanAvailed;
        return this;
    }
}
