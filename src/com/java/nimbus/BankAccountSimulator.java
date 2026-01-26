package com.java.nimbus;

import java.util.Scanner;

public class BankAccountSimulator {

    static class BankAccount {
        private int accountNumber;
        private String accountHolderName;
        private double balance;

        // Constructor with account number and name (balance defaults to 0.0)
        public BankAccount(int accountNumber, String accountHolderName) {
            this.accountNumber = accountNumber;
            this.accountHolderName = accountHolderName;
            this.balance = 0.0;
        }

        // Constructor with account number, name, and initial balance
        public BankAccount(int accountNumber, String accountHolderName, double balance) {
            this.accountNumber = accountNumber;
            this.accountHolderName = accountHolderName;
            this.balance = balance;
        }

        // Method to display account details
        public void display() {
            System.out.printf("%d %s %.2f%n", accountNumber, accountHolderName, balance);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        BankAccount[] accounts = new BankAccount[n];

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            String[] parts = line.split(" ");

            if (parts.length == 2) {
                int accNo = Integer.parseInt(parts[0]);
                String name = parts[1];
                accounts[i] = new BankAccount(accNo, name);
            } else if (parts.length == 3) {
                int accNo = Integer.parseInt(parts[0]);
                String name = parts[1];
                double balance = Double.parseDouble(parts[2]);
                accounts[i] = new BankAccount(accNo, name, balance);
            }
        }

        for (BankAccount acc : accounts) {
            acc.display();
        }

        sc.close();
    }
}
