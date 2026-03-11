public class FacadeDemo {
    public static void main(String[] args) {
        BankFacade bank = new BankFacade();
        bank.transfer("A1", "B1", 500);
    }
}

class AccountService {
    public boolean exists(String acc) { return acc != null && !acc.isBlank(); }
}

class BalanceService {
    public boolean hasBalance(String acc, int amount) { return amount <= 1000; } // demo
}

class TransactionService {
    public void debit(String acc, int amount) { System.out.println("Debited " + amount + " from " + acc); }
    public void credit(String acc, int amount) { System.out.println("Credited " + amount + " to " + acc); }
}

class BankFacade {
    private final AccountService accountService = new AccountService();
    private final BalanceService balanceService = new BalanceService();
    private final TransactionService txnService = new TransactionService();

    public void transfer(String from, String to, int amount) {
        if (!accountService.exists(from) || !accountService.exists(to)) {
            System.out.println("Invalid account!");
            return;
        }
        if (!balanceService.hasBalance(from, amount)) {
            System.out.println("Insufficient balance!");
            return;
        }
        txnService.debit(from, amount);
        txnService.credit(to, amount);
        System.out.println("Transfer success!");
    }
}