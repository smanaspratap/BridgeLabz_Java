/*Doubly Linked List: Undo/Redo Functionality for Text Editor
Problem Statement: Design an undo/redo functionality for a text editor using a doubly linked list. Each node represents a state of the text content (e.g., after typing a word or performing a command). Implement the following:
Add a new text state at the end of the list every time the user types or performs an action.
Implement the undo functionality (revert to the previous state).
Implement the redo functionality (revert back to the next state after undo).
Display the current state of the text.
Limit the undo/redo history to a fixed size (e.g., last 10 states).
Hint:
Use a doubly linked list where each node represents a state of the text.
The next pointer will represent the forward history (redo), and the prev pointer will represent the backward history (undo).
Keep track of the current state and adjust the next and prev pointers for undo/redo operations.
*/

// Node representing a text state
class TextState {
    String content;
    TextState prev;
    TextState next;

    TextState(String content) {
        this.content = content;
        this.prev = null;
        this.next = null;
    }
}
class TextEditor {
    private TextState current; // Current text state
    private int size = 0;
    private final int LIMIT = 10; // Maximum undo/redo states

    // Add a new text state
    void type(String text) {
        TextState newState = new TextState(text);

        // If current exists, link new state after it
        if (current != null) {
            current.next = newState;
            newState.prev = current;
        }

        current = newState;
        size++;

        // Limit the history size
        if (size > LIMIT)
            removeOldestState();
    }

    // Undo operation
    void undo() {
        if (current != null && current.prev != null)
            current = current.prev;
    }

    // Redo operation
    void redo() {
        if (current != null && current.next != null)
            current = current.next;
    }

    // Display current text
    void display() {
        if (current != null)
            System.out.println("Current Text: " + current.content);
    }

    // Remove the oldest text state
    private void removeOldestState() {
        TextState temp = current;

        // Move to first state
        while (temp.prev != null)
            temp = temp.prev;

        // Remove the first state
        temp.next.prev = null;
        size--;
    }
}
