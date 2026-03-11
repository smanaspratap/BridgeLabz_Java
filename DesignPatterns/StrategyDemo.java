public class StrategyDemo {
    public static void main(String[] args) {
        PaymentContext ctx = new PaymentContext();

        ctx.setStrategy(new CashPayment());
        ctx.pay(200);

        ctx.setStrategy(new CardPayment());
        ctx.pay(500);

        ctx.setStrategy(new UPIPayment());
        ctx.pay(150);
    }
}

interface PaymentStrategy {
    void pay(int amount);
}

class CashPayment implements PaymentStrategy {
    public void pay(int amount) { System.out.println("Paid ₹" + amount + " using CASH"); }
}

class CardPayment implements PaymentStrategy {
    public void pay(int amount) { System.out.println("Paid ₹" + amount + " using CARD"); }
}

class UPIPayment implements PaymentStrategy {
    public void pay(int amount) { System.out.println("Paid ₹" + amount + " using UPI"); }
}

class PaymentContext {
    private PaymentStrategy strategy;

    public void setStrategy(PaymentStrategy strategy) { this.strategy = strategy; }

    public void pay(int amount) {
        if (strategy == null) throw new IllegalStateException("Strategy not set");
        strategy.pay(amount);
    }
}