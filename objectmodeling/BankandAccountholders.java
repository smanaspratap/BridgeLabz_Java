/* Problem 2: Bank and Account Holders (Association)
Description:
Model a relationship where a Bank has Customer objects associated with it.
A Customer can have a bank account, and the account is linked to a Bank.

Goal:
Illustrate association by setting up a relationship
between customers and the bank.
*/

import java.util.ArrayList;

// Bank class
class Bank {
    String bankName;
    ArrayList<Customer> customers; // Bank is associated with Customers

    // Constructor to initialize bank
    Bank(String bankName) {
        this.bankName = bankName;
        customers = new ArrayList<>();
    }

    // Method to open an account for a customer
    void openAccount(Customer customer, double initialBalance) {
        customer.balance = initialBalance;   // Setting customer's balance
        customer.bank = this;                // Linking customer to this bank
        customers.add(customer);             // Adding customer to bank
        System.out.println("Account opened for " + customer.name + " in " + bankName);
    }
}

// Customer class
class Customer {
    String name;
    double balance;
    Bank bank; // Customer is associated with Bank

    // Constructor to initialize customer
    Customer(String name) {
        this.name = name;
    }

    // Method to view account balance
    void viewBalance() {
        System.out.println("Customer: " + name);
        System.out.println("Bank: " + bank.bankName);
        System.out.println("Balance: ₹" + balance);
    }
}

// Main class to demonstrate association
public class BankandAccountholders {
    public static void main(String[] args) {

        // Creating Bank object
        Bank bank = new Bank("State Bank of India");

        // Creating Customer objects
        Customer c1 = new Customer("Manas");
        Customer c2 = new Customer("Rahul");

        // Opening accounts for customers
        bank.openAccount(c1, 5000);
        bank.openAccount(c2, 10000);

        // Customers viewing their balances
        c1.viewBalance();
        c2.viewBalance();
    }
}

