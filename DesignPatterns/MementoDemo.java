import java.util.*;

public class MementoDemo {
    public static void main(String[] args) {
        Editor editor = new Editor();
        Caretaker caretaker = new Caretaker();

        editor.setText("Version 1");
        caretaker.save(editor);

        editor.setText("Version 2");
        caretaker.save(editor);

        editor.setText("Version 3");
        System.out.println("Current: " + editor.getText());

        caretaker.undo(editor);
        System.out.println("After undo: " + editor.getText());

        caretaker.undo(editor);
        System.out.println("After undo: " + editor.getText());
    }
}

class Editor {
    private String text = "";

    public void setText(String text) { this.text = text; }
    public String getText() { return text; }

    public Memento save() { return new Memento(text); }
    public void restore(Memento m) { this.text = m.state(); }
}

record Memento(String state) {}

class Caretaker {
    private final Deque<Memento> stack = new ArrayDeque<>();

    public void save(Editor e) { stack.push(e.save()); }

    public void undo(Editor e) {
        if (stack.isEmpty()) return;
        stack.pop(); // remove current
        if (stack.isEmpty()) return;
        e.restore(stack.peek());
    }
}