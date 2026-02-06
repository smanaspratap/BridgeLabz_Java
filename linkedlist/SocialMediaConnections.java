/*7. Singly Linked List: Social Media Friend Connections
Problem Statement: Create a system to manage social media friend connections using a singly linked list. Each node represents a user with User ID, Name, Age, and List of Friend IDs. Implement the following operations:
Add a friend connection between two users.
Remove a friend connection.
Find mutual friends between two users.
Display all friends of a specific user.
Search for a user by Name or User ID.
Count the number of friends for each user.
Hint:
Use a singly linked list where each node contains a list of friends (which can be another linked list or array of Friend IDs).
For mutual friends, traverse both lists and compare the Friend IDs.
The List of Friend IDs for each user can be implemented as a nested linked list or array.*/


// Node representing a friend connection
class FriendNode {
    int friendId;
    FriendNode next;

    FriendNode(int friendId) {
        this.friendId = friendId;
        this.next = null;
    }
}

// Node representing a user in the social network
class User {
    int userId;
    String name;
    int age;
    FriendNode friends;   // Head of friend list
    User next;            // Next user in the list

    User(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friends = null;
        this.next = null;
    }
}
// Node representing a user in the social network
class SocialNetwork {
    private User head; // Head of user list

    // Add a new user to the network
    void addUser(int userId, String name, int age) {
        User user = new User(userId, name, age);
        user.next = head;
        head = user;
    }

    // Search user by User ID
    User findUser(int userId) {
        User temp = head;
        while (temp != null) {
            if (temp.userId == userId)
                return temp;
            temp = temp.next;
        }
        return null;
    }

    // Add friend connection between two users
    void addFriend(int userId1, int userId2) {
        User u1 = findUser(userId1);
        User u2 = findUser(userId2);

        if (u1 == null || u2 == null) {
            System.out.println("User not found!");
            return;
        }

        // Add each other as friends
        u1.friends = addFriendNode(u1.friends, userId2);
        u2.friends = addFriendNode(u2.friends, userId1);
    }

    // Helper method to add a friend ID to friend list
    private FriendNode addFriendNode(FriendNode head, int friendId) {
        FriendNode node = new FriendNode(friendId);
        node.next = head;
        return node;
    }

    // Display all friends of a user
    void displayFriends(int userId) {
        User user = findUser(userId);
        if (user == null) return;

        System.out.print("Friends of " + user.name + ": ");
        FriendNode temp = user.friends;
        while (temp != null) {
            System.out.print(temp.friendId + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Find mutual friends between two users
    void findMutualFriends(int userId1, int userId2) {
        User u1 = findUser(userId1);
        User u2 = findUser(userId2);

        if (u1 == null || u2 == null) return;

        System.out.print("Mutual Friends: ");
        for (FriendNode f1 = u1.friends; f1 != null; f1 = f1.next) {
            for (FriendNode f2 = u2.friends; f2 != null; f2 = f2.next) {
                if (f1.friendId == f2.friendId)
                    System.out.print(f1.friendId + " ");
            }
        }
        System.out.println();
    }
}

