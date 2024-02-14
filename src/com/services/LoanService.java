package com.services;

import com.models.Bank;
import com.models.Borrower;

public interface LoanService {
    void allocateLoan(String bankName, String borrowerName, double principle, double years, double rate);
    void makePayment(String bankName, String borrowerName, double lumpSum, int emiNum);
    String getBalance(String bankName, String borrowerName, int emiNum);
}
