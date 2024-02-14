package com.models;

import java.util.ArrayList;
import java.util.List;

public class Loan {
    private Borrower borrower;
    private double principle;
    private double rate;
    private double years;
    private double amount;
    private int totalEmi;
    private int perEmiPayment;
    private List<Double> paidAmounts;

    public Loan(Borrower borrower, double principle, double rate, double years) {
        this.borrower = borrower;
        this.principle = principle;
        this.rate = rate;
        this.years = years;
        this.amount = principle + (principle*rate*years)/100;
        this.totalEmi = (int)Math.ceil(years*12);
        this.perEmiPayment = (int)Math.ceil(amount/totalEmi);
        this.paidAmounts = new ArrayList<>(totalEmi);
        for (int i = 0; i < totalEmi; i++) {
            paidAmounts.add((double)perEmiPayment);
        }
    }

    public Borrower getBorrower() {
        return borrower;
    }

    public double getPrinciple() {
        return principle;
    }

    public double getRate() {
        return rate;
    }

    public double getYears() {
        return years;
    }

    public double getAmount() {
        return amount;
    }

    public int getTotalEmi() {
        return totalEmi;
    }

    public int getPerEmiPayment() {
        return perEmiPayment;
    }

    public int getPaidAmount(int emiNum) {
        return (int)Math.ceil(paidAmounts.get(emiNum-1));
    }

    public Loan setBorrower(Borrower borrower) {
        this.borrower = borrower;
        return this;
    }

    public Loan addPayment(double payment, int emiNum) {
        this.paidAmounts.add(emiNum-1, this.paidAmounts.get(emiNum-1)+payment);
        return this;
    }

    public Loan updateTotalEmi(int totalEmi) {
        this.totalEmi = totalEmi;
        return this;
    }
}
