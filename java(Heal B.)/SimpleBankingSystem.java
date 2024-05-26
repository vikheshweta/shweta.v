import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Account {
    private String name;
    private double balance;

    public Account(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println(amount + " deposited successfully. New balance: " + balance);
    }

    public boolean withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println(amount + " withdrawn successfully. New balance: " + balance);
            return true;
        } else {
            System.out.println("Insufficient balance.");
            return false;
        }
    }
}

public class SimpleBankingSystem {
    private static Map<Integer, Account> accounts = new HashMap<>();
    private static int accountIdCounter = 1000;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nBanking System Menu:");
            System.out.println("1. Add Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addAccount(scanner);
                    break;
                case 2:
                    deposit(scanner);
                    break;
                case 3:
                    withdraw(scanner);
                    break;
                case 4:
                    checkBalance(scanner);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addAccount(Scanner scanner) {
        System.out.print("Enter account holder's name: ");
        String name = scanner.next();
        System.out.print("Enter initial balance: ");
        double balance = scanner.nextDouble();

        Account account = new Account(name, balance);
        accounts.put(accountIdCounter++, account);
        System.out.println("Account created successfully with ID: " + (accountIdCounter - 1));
    }

    private static void deposit(Scanner scanner) {
        System.out.print("Enter account ID: ");
        int accountId = scanner.nextInt();
        System.out.print("Enter deposit amount: ");
        double amount = scanner.nextDouble();

        Account account = accounts.get(accountId);
        if (account != null) {
            account.deposit(amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    private static void withdraw(Scanner scanner) {
        System.out.print("Enter account ID: ");
        int accountId = scanner.nextInt();
        System.out.print("Enter withdrawal amount: ");
        double amount = scanner.nextDouble();

        Account account = accounts.get(accountId);
        if (account != null) {
            account.withdraw(amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    private static void checkBalance(Scanner scanner) {
        System.out.print("Enter account ID: ");
        int accountId = scanner.nextInt();

        Account account = accounts.get(accountId);
        if (account != null) {
            System.out.println("Balance for account " + accountId + ": " + account.getBalance());
        } else {
            System.out.println("Account not found.");
        }
    }
}

