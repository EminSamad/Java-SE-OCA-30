package task6;

import java.util.ArrayList;
import java.util.Scanner;

public class BasicBankingSystem {
    static ArrayList<Accounts> accountList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("***************************************************");
        System.out.println("---Banking System---");
        System.out.println("***************************************************");

        while (true) {
            System.out.println("Functions :");
            System.out.println("Enter '1' for Add Bank account");
            System.out.println("Enter '2' for Performing transaction");
            System.out.println("Enter '3' for View Account information");
            System.out.println("Enter 'q' for Quitting");
            System.out.print("Enter the number of function which you want :");
            String functionNum = scanner.nextLine();

            if (functionNum.equals("q")) {
                System.out.println("Quitting the system. Goodbye!");
                break;
            }

            if (!functionNum.equals("1") && !functionNum.equals("2") && !functionNum.equals("3")) {
                System.out.println("Invalid Function Number! ");
            }
            switch (functionNum) {
                case "1":
                    addAccount();
                    break;
                case "2":
                    performTransaction();
                    break;
                case "3":
                    displayAccounts();
                    break;
            }

        }
    }
    public static void addAccount() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Customer Name: ");
        String accountName = scanner.nextLine();
        System.out.print("Enter Initial Balance: ");

        try {
            double balance = scanner.nextDouble();
            if (balance < 0) {
                System.out.println("Balance cannot be negative. Account creation failed.");
                return;
            }
            accountList.add(new Accounts(accountName, balance));
            System.out.println("Bank Account created successfully.");
        } catch (Exception e) {
            System.out.println("Invalid input. Account creation failed.");
            scanner.nextLine();
        }
    }
    public static void performTransaction() {
        Scanner scanner = new Scanner(System.in);
        if (accountList.isEmpty()) {
            System.out.println("No accounts available to perform a transaction.");
            return;
        }

        displayAccounts();
        System.out.print("Enter the account number for the transaction: ");
        int accountIndex;
        try {
            accountIndex = Integer.parseInt(scanner.nextLine()) - 1;
            if (accountIndex < 0 || accountIndex >= accountList.size()) {
                System.out.println("Invalid account number.");
                return;
            }
            Accounts account = accountList.get(accountIndex);

            System.out.println("Choose Transaction Type: 1 for Deposit, 2 for Withdraw");
            int transactionType = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter the amount: ");
            double amount = Double.parseDouble(scanner.nextLine());

            switch (transactionType) {
                case 1:
                    account.deposit(amount);
                    break;
                case 2:
                    account.withdraw(amount);
                    break;
                default:
                    System.out.println("Invalid transaction type.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter valid numbers.");
        }
    }
    public static void displayAccounts() {
        if (accountList.isEmpty()) {
            System.out.println("No accounts available.");
            return;
        }
        System.out.println("Account List:");
        for (int i = 0; i < accountList.size(); i++) {
            System.out.println((i + 1) + ". " + accountList.get(i));
        }
    }
}
