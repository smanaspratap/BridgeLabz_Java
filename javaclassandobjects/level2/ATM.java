/*Program to Simulate an ATM
Problem Statement: Create a BankAccount class with attributes accountHolder, accountNumber, and balance. Add methods for:
Depositing money.
Withdrawing money (only if sufficient balance exists).
Displaying the current balance.
Explanation: The BankAccount class stores bank account details as attributes. The methods allow interaction with these attributes to modify and view the account's state.
 */

class BankAccount {
    // Attributes
    String accountHolder;
    long accountNumber;
    double balance;

    // Constructor
    BankAccount(String accountHolder, long accountNumber, double balance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // Method to deposit money
    void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("₹" + amount + " deposited successfully.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Method to withdraw money
    void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("₹" + amount + " withdrawn successfully.");
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    // Method to display balance
    void displayBalance() {
        System.out.println("Current Balance: ₹" + balance);
    }
}

public class ATM {
    public static void main(String[] args) {
        // Creating account object
        BankAccount acc = new BankAccount("Manas Singh", 1234567890L, 5000);

        // ATM operations
        acc.displayBalance();
        acc.deposit(2000);
        acc.withdraw(1500);
        acc.displayBalance();
    }
}
