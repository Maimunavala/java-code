2️⃣ Smart Banking System (Abstract Class + Transaction Logic)
Concepts Used

Abstract Class

Inheritance

Method Implementation

Array of Objects

Step 1: Abstract Class Account
abstract class Account {

    int accountNumber;
    String holderName;
    double balance;

    Account(int accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    abstract double calculateInterest();

    void deposit(double amount) {
        balance = balance + amount;
    }

    void withdraw(double amount) {
        if (amount <= balance) {
            balance = balance - amount;
        } else {
            System.out.println("Insufficient Balance");
        }
    }

    void display() {
        System.out.println("Account No: " + accountNumber);
        System.out.println("Holder: " + holderName);
        System.out.println("Balance: " + balance);
    }
}
Explanation

Account is abstract because interest calculation will be different for each account type.

Step 2: SavingsAccount Class
class SavingsAccount extends Account {

    SavingsAccount(int accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    double calculateInterest() {
        return balance * 0.04;
    }
}
Rule
Savings Interest = 4%
Step 3: CurrentAccount Class
class CurrentAccount extends Account {

    CurrentAccount(int accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    double calculateInterest() {

        if (balance < 1000) {
            balance = balance - 500;
            System.out.println("Penalty Applied: 500");
        }

        return 0;
    }
}
Rule
Current account:
No interest
Penalty = ₹500 if balance < 1000
Step 4: Main Class
public class BankingSystem {

    public static void main(String[] args) {

        Account[] acc = new Account[4];

        acc[0] = new SavingsAccount(101, "Rahul", 5000);
        acc[1] = new CurrentAccount(102, "Amit", 800);
        acc[2] = new SavingsAccount(103, "Neha", 7000);
        acc[3] = new CurrentAccount(104, "Riya", 1500);

        for (Account a : acc) {

            a.deposit(1000);
            a.withdraw(500);

            double interest = a.calculateInterest();

            a.display();
            System.out.println("Interest: " + interest);
            System.out.println("------------------");
        }
    }
}
Example Output
Account No: 101
Holder: Rahul
Balance: 5500
Interest: 220

Penalty Applied: 500
Account No: 102
Holder: Amit
Balance: 800
Interest: 0