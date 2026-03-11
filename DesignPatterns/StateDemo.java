public class StateDemo {
    public static void main(String[] args) {
        ATMContext atm = new ATMContext();

        atm.insertCard();
        atm.enterPin();
        atm.withdrawCash();
        atm.ejectCard();
    }
}

interface ATMState {
    void insertCard(ATMContext ctx);
    void enterPin(ATMContext ctx);
    void withdrawCash(ATMContext ctx);
    void ejectCard(ATMContext ctx);
}

class ATMContext {
    private ATMState state = new NoCardState();

    void setState(ATMState state) { this.state = state; }

    public void insertCard() { state.insertCard(this); }
    public void enterPin() { state.enterPin(this); }
    public void withdrawCash() { state.withdrawCash(this); }
    public void ejectCard() { state.ejectCard(this); }
}

class NoCardState implements ATMState {
    public void insertCard(ATMContext ctx) {
        System.out.println("Card inserted.");
        ctx.setState(new HasCardState());
    }
    public void enterPin(ATMContext ctx) { System.out.println("Insert card first."); }
    public void withdrawCash(ATMContext ctx) { System.out.println("Insert card first."); }
    public void ejectCard(ATMContext ctx) { System.out.println("No card to eject."); }
}

class HasCardState implements ATMState {
    public void insertCard(ATMContext ctx) { System.out.println("Card already inserted."); }
    public void enterPin(ATMContext ctx) {
        System.out.println("PIN accepted.");
        ctx.setState(new AuthorizedState());
    }
    public void withdrawCash(ATMContext ctx) { System.out.println("Enter PIN first."); }
    public void ejectCard(ATMContext ctx) {
        System.out.println("Card ejected.");
        ctx.setState(new NoCardState());
    }
}

class AuthorizedState implements ATMState {
    public void insertCard(ATMContext ctx) { System.out.println("Card already inserted."); }
    public void enterPin(ATMContext ctx) { System.out.println("Already authorized."); }
    public void withdrawCash(ATMContext ctx) { System.out.println("Cash withdrawn."); }
    public void ejectCard(ATMContext ctx) {
        System.out.println("Card ejected.");
        ctx.setState(new NoCardState());
    }
}