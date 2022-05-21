package com.bank_account;

import java.util.Scanner;

public class Account {

    // use "psvm" for a shortcut
    public static void main(String[] args) {
            Scanner scan =  new Scanner(System.in);
            Bank bank = new Bank();

            int choice = 2;
            int AccountNumber;

            do {
                // This displays a menu to the users and asks the users to chose the action of the app
                // uses a scanner to read and store users choices
                System.out.println("\n1). Open a New Account");
                System.out.println("2). Make a Deposit");
                System.out.println("3). Withdraw From an Account");
                System.out.println("4). Account Balance");
                System.out.println("5). Quit\n");
                System.out.println("Press [1-5]\n");

                choice = scan.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println("Enter your name:");
                        String name = scan.next();
                        System.out.println("Create an Account Number:");
                        AccountNumber = scan.nextInt();
                        System.out.println("How much would money would you like to open the account with?");
                        double amount = scan.nextDouble();
                        System.out.println("Your account has been made for " + name + " with $" + amount + " added!");
                        break;

                    case 2:
                        System.out.println("Enter an account number");
                        AccountNumber = scan.nextInt();
                        System.out.println("How much would you like to Deposit?");
                        int deposit = scan.nextInt();
                        bank.depositTo(AccountNumber, deposit);
                        break;

                    case 3:
                        System.out.println("Enter an account number");
                        AccountNumber = scan.nextInt();
                        System.out.println("How much would you like to Withdraw?");
                        int withdraw = scan.nextInt();
                        bank.withdrawFrom(AccountNumber, withdraw);
                        break;

                    case 4:
                        System.out.println("Enter an account number");
                        AccountNumber = scan.nextInt();
                        bank.printAccountInfo(AccountNumber);
                        break;

                    case 5:
                        System.out.println("Here are the balances " + "for each account:");

                    case 6:
                        System.exit(0);
                }
            }
            while (choice <= 4);
    } // end main

    static class BankAccount {
        public int AccountNumber;
        public String Name;
        public double balance;
        public static int numOfAccounts = 0;

        public String getAccountInfo() {
            return "Account number: " + AccountNumber + "\nName";
        }

        public BankAccount(String abc, double xyz) {
            Name = abc;
            balance = xyz;
            numOfAccounts++;
            AccountNumber = numOfAccounts;
        }

        public int getAccountNumber(){
            return AccountNumber;
        }

        public void deposit(double amount) {
            if (amount <=0) {
                System.out.println("Amount to deposited should be positive");
            } else {
                balance = balance + amount;
            }
        }

        public void withdraw(double amount) {
            if (amount <= 0) {
                System.out.println("Amount withdrawn should be positive");
            } else {
                if (balance < amount) {
                    System.out.println("Insufficient funds");
                } else {
                    balance = balance - amount;
                }
            }
        }
    } // end BankAccount

    static class Bank {
        private BankAccount[] accounts;         // stores the accounts in the bank into an array
        private int numOfAccounts = 5;          // limits the number of accounts to 5

        // blank object that dosent contain any accounts
        public Bank() {
            accounts = new BankAccount[5];
            numOfAccounts = 0;
        }

        /*
        Creates a new bank account using the customer name and the opening balance given as parameters
        and returns the account number of this new account. It also adds this account into the account list
        of the Bank calling object.
        */
        public int openNewAccount(String Name, double openingBalance) {
            if(numOfAccounts > 5)
            {
                System.out.println("5 accounts already exist");
            }
            else {
                BankAccount bank = new BankAccount(Name, openingBalance);
                accounts[numOfAccounts] = bank;
                numOfAccounts++;
                return bank.getAccountNumber();
            }
            return numOfAccounts;
        }

        /*
        Withdraws the given amount from the account whose account number is given. If the account is
        not available at the bank, it should print a message.
        */
        public void withdrawFrom(int accountNumber, double amount) {
            for (int i = 0; i < numOfAccounts; i++) {
                if (accountNumber == accounts[i].getAccountNumber()) {
                    accounts[i].withdraw(amount);
                    System.out.println("Amount withdrawn succusfully");
                    return;
                }
            }
        }

        /*
        Deposits the given amount to the account whose account number is given. If the account is not
        available at the bank, it should print a message.
        */
        public void depositTo(int AccountNumber, double amount) {
            for (int i = 0; i < numOfAccounts; i++) {
                if (AccountNumber == accounts[i].getAccountNumber()) {
                    accounts[i].deposit(amount);
                    System.out.println("Amount deposited succusfully");
                    return;
                }
            }
            System.out.println("Account number not found");
        }

        /*
        Prints the account number, the customer name and the balance of the bank account whose
        account number is given. If the account is not available at the bank, it should print a message.
        */
        public void printAccountInfo(int AccountNumber) {
            for (int i = 0; i < numOfAccounts; i++) {
                if (AccountNumber == accounts[i].getAccountNumber()  ) {
                    System.out.println(accounts[i].getAccountInfo());
                    return;
                }
            }
            System.out.println("Account number not found.");
        }

        public void printAccountInfo(int AccountNumber, int n) {
            for (int i =0; i<numOfAccounts; i++) {
                if (AccountNumber == accounts[i].getAccountNumber()) {
                    System.out.println(accounts[i].getAccountInfo());
                    return;
                }
            }
            System.out.println("Account number not found.");
        }

    } // end Bank

}