public class SingletonDemo {
    public static void main(String[] args) {
        Logger a = Logger.getInstance();
        Logger b = Logger.getInstance();

        a.log("Logger A hash = " + System.identityHashCode(a));
        b.log("Logger B hash = " + System.identityHashCode(b));
        System.out.println("Same instance? " + (a == b));
    }
}

class Logger {
    private static final Logger INSTANCE = new Logger();

    private Logger() {}

    public static Logger getInstance() {
        return INSTANCE;
    }

    public void log(String message) {
        System.out.println("[LOG] " + message);
    }
}