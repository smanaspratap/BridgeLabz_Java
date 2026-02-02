/*
Description: Create a banking system with different account types:
Define an abstract class BankAccount with fields like accountNumber, holderName, and balance.
Add methods like deposit(double amount) and withdraw(double amount) (concrete)
and calculateInterest() (abstract).
Implement subclasses SavingsAccount and CurrentAccount with unique interest calculations.
Create an interface Loanable with methods applyForLoan() and calculateLoanEligibility().
Use encapsulation to secure account details and restrict unauthorized access.
Demonstrate polymorphism by processing different account types and calculating interest dynamically.
*/

import java.util.ArrayList;
import java.util.List;

/* ---------- Interface ---------- */
interface Loanable {
    void applyForLoan();
    double calculateLoanEligibility();
}

/* ---------- Abstract Class ---------- */
abstract class BankAccount {

    private String accountNumber;
    private String holderName;
    protected double balance;

    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    // Concrete methods
    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
        }
    }

    // Abstract method
    public abstract double calculateInterest();

    // Encapsulation (getter only)
    public double getBalance() {
        return balance;
    }

    public String getHolderName() {
        return holderName;
    }
}

/* ---------- Savings Account ---------- */
class SavingsAccount extends BankAccount implements Loanable {

    public SavingsAccount(String accNo, String name, double balance) {
        super(accNo, name, balance);
    }

    @Override
    public double calculateInterest() {
        return balance * 0.04; // 4% interest
    }

    @Override
    public void applyForLoan() {
        System.out.println("Savings Account loan applied");
    }

    @Override
    public double calculateLoanEligibility() {
        return balance * 2;
    }
}

/* ---------- Current Account ---------- */
class CurrentAccount extends BankAccount implements Loanable {

    public CurrentAccount(String accNo, String name, double balance) {
        super(accNo, name, balance);
    }

    @Override
    public double calculateInterest() {
        return balance * 0.02; // 2% interest
    }

    @Override
    public void applyForLoan() {
        System.out.println("Current Account loan applied");
    }

    @Override
    public double calculateLoanEligibility() {
        return balance * 3;
    }
}

/* ---------- Main Class ---------- */
public class BankingSystemTest {

    public static void main(String[] args) {

        List<BankAccount> accounts = new ArrayList<>();

        accounts.add(new SavingsAccount("SB101", "Prajwal", 50000));
        accounts.add(new CurrentAccount("CA202", "Amit", 80000));

        // Polymorphism demonstration
        for (BankAccount acc : accounts) {

            double interest = acc.calculateInterest();

            System.out.println("Account Holder: " + acc.getHolderName());
            System.out.println("Balance       : " + acc.getBalance());
            System.out.println("Interest      : " + interest);

            if (acc instanceof Loanable) {
                Loanable loanAcc = (Loanable) acc;
                System.out.println("Loan Eligibility: " + loanAcc.calculateLoanEligibility());
            }

            System.out.println("----------------------------");
        }
    }
}
