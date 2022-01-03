package com.banking;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTestParameterized {

    private BankAccount account;
    private static int count;


    @BeforeAll
    public static void beforeClass() {
        System.out.println("This executes before any test cases. Count = " + count++);
    }

    @BeforeEach
    public void setup() {
        account = new BankAccount("George", "Ilinca", 1000.00, BankAccount.CHECKING);
        System.out.println("Running a test...");
    }

    @ParameterizedTest
    @MethodSource("provideArgumentsForDeposit")
    public void deposit(double amount, boolean branch, double expected) throws Exception {
        double balance = account.deposit(amount, branch);
        assertEquals(expected, balance, .01);
    }

    @ParameterizedTest
    @MethodSource("provideArgumentsForWithdrawBranch")
    public void withdraw_branch(double amount, boolean branch, double expected) throws Exception {
        double balance = account.withdraw(amount, branch);
        assertEquals(expected, balance, .01);
    }

    @ParameterizedTest
    @MethodSource("provideArgumentsForWithdrawNotBranch")
    public void withdraw_notBranch(double amount, boolean branch, double expected) throws Exception {
        assertThrows(IllegalArgumentException.class, () ->  account.withdraw(amount, branch));
    }

    @ParameterizedTest
    @MethodSource("provideArgumentsForDeposit")
    public void getBalance_deposit(double amount, boolean branch, double expected) throws Exception {
        double balance = account.deposit(amount, branch);
        assertEquals(expected, account.getBalance(), .01);
    }

    @ParameterizedTest
    @MethodSource("provideArgumentsForWithdrawBranch")
    public void getBalance_withdraw(double amount, boolean branch, double expected) throws Exception {
        double balance = account.withdraw(amount, branch);
        assertEquals(expected, account.getBalance(), .01);
    }

    @Test
    public void isChecking_true() {
        assertTrue(account.isChecking(), "The account is NOT a checking account");
    }

    @AfterAll
    public static void afterClass() {
        System.out.println("This executes after any test cases. Count = " + count++);
    }

    @AfterEach
    public void teardown() {
        System.out.println("Count = " + count++);
    }

    private static Stream<Arguments> provideArgumentsForDeposit() {
        return Stream.of(
                Arguments.of(100.00, true, 1100.00),
                Arguments.of(200.00, true, 1200.00),
                Arguments.of(325.14, true, 1325.14),
                Arguments.of(489.33, true, 1489.33),
                Arguments.of(1000.00, true, 2000.00));
    }

    private static Stream<Arguments> provideArgumentsForWithdrawBranch() {
        return Stream.of(
                Arguments.of(100.00, true, 900.00),
                Arguments.of(200.00, true, 800.00),
                Arguments.of(325.14, true, 674.86),
                Arguments.of(489.33, true, 510.67),
                Arguments.of(1000.00, true, 0));
    }

    private static Stream<Arguments> provideArgumentsForWithdrawNotBranch() {
        return Stream.of(
                Arguments.of(600.00, false, 400.00),
                Arguments.of(700.00, false, 300.00),
                Arguments.of(825.14, false, 274.86),
                Arguments.of(989.33, false, 10.67),
                Arguments.of(1000.00, false, 0));
    }
}
