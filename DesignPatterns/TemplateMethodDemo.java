public class TemplateMethodDemo {
    public static void main(String[] args) {
        OrderProcess online = new OnlineOrder();
        online.processOrder();

        System.out.println("---");

        OrderProcess store = new StoreOrder();
        store.processOrder();
    }
}

abstract class OrderProcess {
    // template method
    public final void processOrder() {
        selectItem();
        makePayment();
        deliver();
    }

    protected abstract void selectItem();
    protected abstract void makePayment();
    protected abstract void deliver();
}

class OnlineOrder extends OrderProcess {
    protected void selectItem() { System.out.println("Online: item selected"); }
    protected void makePayment() { System.out.println("Online: payment done"); }
    protected void deliver() { System.out.println("Online: delivered to home"); }
}

class StoreOrder extends OrderProcess {
    protected void selectItem() { System.out.println("Store: item selected"); }
    protected void makePayment() { System.out.println("Store: payment done"); }
    protected void deliver() { System.out.println("Store: handover at counter"); }
}