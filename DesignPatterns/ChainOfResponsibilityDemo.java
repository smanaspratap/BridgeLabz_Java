public class ChainOfResponsibilityDemo {
    public static void main(String[] args) {
        Handler teamLead = new TeamLead();
        Handler manager = new Manager();
        Handler hr = new HR();

        teamLead.setNext(manager);
        manager.setNext(hr);

        teamLead.handle(new Request("Leave approval", 2));
        teamLead.handle(new Request("Leave approval", 8));
        teamLead.handle(new Request("Leave approval", 20));
    }
}

class Request {
    final String type;
    final int days;
    Request(String type, int days) { this.type = type; this.days = days; }
}

abstract class Handler {
    private Handler next;
    public void setNext(Handler next) { this.next = next; }
    protected void forward(Request r) {
        if (next != null) next.handle(r);
        else System.out.println("No handler found.");
    }
    public abstract void handle(Request r);
}

class TeamLead extends Handler {
    public void handle(Request r) {
        if (r.days <= 3) System.out.println("TeamLead approved " + r.days + " days.");
        else forward(r);
    }
}

class Manager extends Handler {
    public void handle(Request r) {
        if (r.days <= 10) System.out.println("Manager approved " + r.days + " days.");
        else forward(r);
    }
}

class HR extends Handler {
    public void handle(Request r) {
        System.out.println("HR approved " + r.days + " days (final).");
    }
}