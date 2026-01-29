/* 
Sample Program 1: Bank Account System
Create a BankAccount class with static, this, final, and instanceof usage.
*/

class BankAccount {

    // Static variable shared by all accounts
    static String bankName = "State Bank of India";
    static int totalAccounts = 0;

    // Final variable cannot be changed once assigned
    final int accountNumber;

    // Instance variable
    String accountHolderName;

    // Constructor using this keyword
    BankAccount(int accountNumber, String accountHolderName) {
        this.accountNumber = accountNumber;       // resolves ambiguity
        this.accountHolderName = accountHolderName;
        totalAccounts++;                          // count total accounts
    }

    // Static method
    static void getTotalAccounts() {
        System.out.println("Total Accounts: " + totalAccounts);
    }

    // Instance method
    void displayDetails() {
        System.out.println("Bank: " + bankName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolderName);
    }

    public static void main(String[] args) {
        BankAccount acc = new BankAccount(101, "Manas");

        // instanceof check
        if (acc instanceof BankAccount) {
            acc.displayDetails();
        }

        BankAccount.getTotalAccounts();
    }
}
