import java.util.*;

public class IteratorDemo {
    public static void main(String[] args) {
        NameRepository repo = new NameRepository(new String[]{"Devraj", "Amit", "Neha"});
        NameIterator it = repo.iterator();

        while (it.hasNext()) {
            System.out.println("Name: " + it.next());
        }
    }
}

interface NameIterator {
    boolean hasNext();
    String next();
}

class NameRepository {
    private final String[] names;
    NameRepository(String[] names) { this.names = names; }

    public NameIterator iterator() {
        return new NameIteratorImpl(names);
    }
}

class NameIteratorImpl implements NameIterator {
    private final String[] data;
    private int index = 0;

    NameIteratorImpl(String[] data) { this.data = data; }

    public boolean hasNext() { return index < data.length; }
    public String next() {
        if (!hasNext()) throw new NoSuchElementException();
        return data[index++];
    }
}