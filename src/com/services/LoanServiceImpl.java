package com.services;

import com.models.Bank;
import com.models.BankRegistry;
import com.models.Borrower;
import com.models.Loan;

public class LoanServiceImpl implements LoanService{

    @Override
    public void allocateLoan(String bankName, String borrowerName, double principle, double years, double rate) {
        Bank bank = BankRegistry.getBankByName(bankName);
        Borrower borrower = bank.getBorrower(borrowerName);
        if(borrower == null) {
            borrower = bank.addBorrower(borrowerName);
        }
        Loan loan = new Loan(borrower, principle, rate, years);
        borrower.setLoanAvailed(loan);

    }

    @Override
    public void makePayment(String bankName, String borrowerName, double lumpSum, int emiNum) {
        Bank bank = BankRegistry.getBankByName(bankName);
        Borrower borrower = bank.getBorrower(borrowerName);
        Loan loan = borrower.getLoanAvailed();
        loan.addPayment(lumpSum, emiNum);
        int numberOfEmiPaid = (int)Math.floor(lumpSum / loan.getPerEmiPayment());
        loan.updateTotalEmi(loan.getTotalEmi() - numberOfEmiPaid);
    }

    @Override
    public String getBalance(String bankName, String borrowerName, int emiNum) {
        Bank bank = BankRegistry.getBankByName(bankName);
        Borrower borrower = bank.getBorrower(borrowerName);
        Loan loan = borrower.getLoanAvailed();
        int amountPaid = 0;
        for (int i = 1; i <= emiNum ; i++) {
            amountPaid += loan.getPaidAmount(i);
        }
        int remainingEmi = (int)Math.ceil((loan.getAmount() - amountPaid) / loan.getPerEmiPayment());
        return bankName + " " + borrowerName + " " + amountPaid + " " + remainingEmi;
    }
}
