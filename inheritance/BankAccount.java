/*Sample Problem 1: Bank Account Types 
○ Description: Model a banking system with different account types using 
hierarchical inheritance. BankAccount is the superclass, with 
SavingsAccount, CheckingAccount, and FixedDepositAccount as 
subclasses. 
○ Tasks: 
■ Define a base class BankAccount with attributes like accountNumber 
and balance. 
■ Define subclasses SavingsAccount, CheckingAccount, and 
FixedDepositAccount, each with unique attributes like 
interestRate for SavingsAccount and withdrawalLimit for 
CheckingAccount. 
■ Implement a method displayAccountType() in each subclass to 
specify the account type. 
○ Goal: Explore hierarchical inheritance, demonstrating how each subclass can 
have unique attributes while inheriting from a shared superclass. */


// Superclass
class BankAccount {
    int accountNumber;
    double balance;

    BankAccount(int accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void displayAccountType() {
        System.out.println("General Bank Account");
    }
}

// SavingsAccount subclass
class SavingsAccount extends BankAccount {
    double interestRate;

    SavingsAccount(int accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }

    @Override
    public void displayAccountType() {
        System.out.println("Savings Account");
        System.out.println("Interest Rate: " + interestRate + "%");
    }
}

// CheckingAccount subclass
class CheckingAccount extends BankAccount {
    double withdrawalLimit;

    CheckingAccount(int accountNumber, double balance, double withdrawalLimit) {
        super(accountNumber, balance);
        this.withdrawalLimit = withdrawalLimit;
    }

    @Override
    public void displayAccountType() {
        System.out.println("Checking Account");
        System.out.println("Withdrawal Limit: ₹" + withdrawalLimit);
    }
}

// FixedDepositAccount subclass
class FixedDepositAccount extends BankAccount {
    int lockInPeriod; // in months

    FixedDepositAccount(int accountNumber, double balance, int lockInPeriod) {
        super(accountNumber, balance);
        this.lockInPeriod = lockInPeriod;
    }

    @Override
    public void displayAccountType() {
        System.out.println("Fixed Deposit Account");
        System.out.println("Lock-in Period: " + lockInPeriod + " months");
    }
}

// Main class
class BankAccountDemo{
    public static void main(String[] args) {

        BankAccount a1 = new SavingsAccount(101, 50000, 4.5);
        BankAccount a2 = new CheckingAccount(102, 30000, 10000);
        BankAccount a3 = new FixedDepositAccount(103, 200000, 24);

        a1.displayAccountType();
        System.out.println();

        a2.displayAccountType();
        System.out.println();

        a3.displayAccountType();
    }
}
