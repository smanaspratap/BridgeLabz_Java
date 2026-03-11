import java.util.*;

public class MediatorDemo {
    public static void main(String[] args) {
        ChatMediator room = new ChatRoom();

        ChatUser u1 = new ChatUser("Devraj", room);
        ChatUser u2 = new ChatUser("Amit", room);
        ChatUser u3 = new ChatUser("Neha", room);

        room.addUser(u1);
        room.addUser(u2);
        room.addUser(u3);

        u1.send("Hello everyone!");
    }
}

interface ChatMediator {
    void addUser(ChatUser user);
    void sendMessage(String msg, ChatUser from);
}

class ChatRoom implements ChatMediator {
    private final List<ChatUser> users = new ArrayList<>();

    public void addUser(ChatUser user) { users.add(user); }

    public void sendMessage(String msg, ChatUser from) {
        for (ChatUser u : users) {
            if (u != from) u.receive(from.getName() + ": " + msg);
        }
    }
}

class ChatUser {
    private final String name;
    private final ChatMediator mediator;

    public ChatUser(String name, ChatMediator mediator) {
        this.name = name;
        this.mediator = mediator;
    }

    public String getName() { return name; }

    public void send(String msg) {
        mediator.sendMessage(msg, this);
    }

    public void receive(String msg) {
        System.out.println(name + " received -> " + msg);
    }
}