package com.models;

import java.util.HashMap;
import java.util.Map;

public class BankRegistry {
    private static final Map<String, Bank> bankMap = new HashMap<>();

    private BankRegistry() {
    }

    public static Bank getBankByName(String bankName) {
        return bankMap.get(bankName);
    }

    public static void addBank(String bankName) {
        Bank bank = new Bank(bankName);
        bankMap.put(bankName, bank);
    }
}
