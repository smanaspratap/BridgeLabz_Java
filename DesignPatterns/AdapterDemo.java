public class AdapterDemo {
    public static void main(String[] args) {
        NewPrinter printer = new PrinterAdapter(new OldPrinter());
        printer.print("Hello via Adapter");
    }
}

class OldPrinter {
    public void oldPrint(String msg) {
        System.out.println("OldPrinter prints: " + msg);
    }
}

interface NewPrinter {
    void print(String msg);
}

class PrinterAdapter implements NewPrinter {
    private final OldPrinter oldPrinter;

    public PrinterAdapter(OldPrinter oldPrinter) {
        this.oldPrinter = oldPrinter;
    }

    @Override
    public void print(String msg) {
        oldPrinter.oldPrint(msg);
    }
}