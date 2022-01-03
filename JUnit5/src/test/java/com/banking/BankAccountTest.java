package com.banking;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;


public class BankAccountTest {

    @Test
    public void deposit() throws Exception {
        BankAccount account = new BankAccount("George", "Ilinca", 1000.00, BankAccount.CHECKING);
        double balance = account.deposit(200.00, true);
        assertEquals(1200, balance, 0);
    }

    @Test
    public void withdraw() throws Exception {
        fail("This test has yet to be implemented");
    }

    @Test
    public void getBalance_deposit() throws Exception {
        BankAccount account = new BankAccount("George", "Ilinca", 1000.00, BankAccount.CHECKING);
        double balance = account.deposit(200.00, true);
        assertEquals(1200.00, account.getBalance(), 0);
    }

    @Test
    public void getBalance_withdraw() throws Exception {
        BankAccount account = new BankAccount("George", "Ilinca", 1000.00, BankAccount.CHECKING);
        double balance = account.withdraw(200.00, true);
        assertEquals(800.00, account.getBalance(), 0);
    }

    @Test
    public void isChecking_true(){
        BankAccount account = new BankAccount("George", "Ilinca", 1000.00, BankAccount.CHECKING);
        assertTrue(account.isChecking(), "The account is NOT a checking account");
    }
}
