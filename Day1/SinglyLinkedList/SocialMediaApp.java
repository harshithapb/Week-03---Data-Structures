package SinglyLinkedList;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class FriendNode {
    int friendId;
    FriendNode next;

    FriendNode(int friendId) {
        this.friendId = friendId;
        this.next = null;
    }
}

class User {
    int userId;
    String name;
    int age;
    FriendNode friendListHead;
    User next;

    User(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friendListHead = null;
        this.next = null;
    }

    void addFriend(int friendId) {
        if (!isAlreadyFriend(friendId)) {
            FriendNode newFriend = new FriendNode(friendId);
            newFriend.next = friendListHead;
            friendListHead = newFriend;
        }
    }

    void removeFriend(int friendId) {
        FriendNode current = friendListHead, prev = null;
        while (current != null && current.friendId != friendId) {
            prev = current;
            current = current.next;
        }
        if (current != null) {
            if (prev == null) {
                friendListHead = current.next;
            } else {
                prev.next = current.next;
            }
        }
    }

    boolean isAlreadyFriend(int friendId) {
        FriendNode temp = friendListHead;
        while (temp != null) {
            if (temp.friendId == friendId) return true;
            temp = temp.next;
        }
        return false;
    }

    List<Integer> getFriendList() {
        List<Integer> friends = new ArrayList<>();
        FriendNode temp = friendListHead;
        while (temp != null) {
            friends.add(temp.friendId);
            temp = temp.next;
        }
        return friends;
    }
}

class SocialNetwork {
    private User head = null;

    void addUser(int userId, String name, int age) {
        User newUser = new User(userId, name, age);
        newUser.next = head;
        head = newUser;
    }

    User getUserById(int userId) {
        User temp = head;
        while (temp != null) {
            if (temp.userId == userId) return temp;
            temp = temp.next;
        }
        return null;
    }

    void addFriendConnection(int id1, int id2) {
        User u1 = getUserById(id1);
        User u2 = getUserById(id2);
        if (u1 != null && u2 != null && id1 != id2) {
            u1.addFriend(id2);
            u2.addFriend(id1);
        }
    }

    void removeFriendConnection(int id1, int id2) {
        User u1 = getUserById(id1);
        User u2 = getUserById(id2);
        if (u1 != null && u2 != null) {
            u1.removeFriend(id2);
            u2.removeFriend(id1);
        }
    }

    void findMutualFriends(int id1, int id2) {
        User u1 = getUserById(id1);
        User u2 = getUserById(id2);
        if (u1 != null && u2 != null) {
            List<Integer> f1 = u1.getFriendList();
            List<Integer> f2 = u2.getFriendList();
            System.out.print("Mutual Friends: ");
            for (int id : f1) {
                if (f2.contains(id)) {
                    System.out.print(id + " ");
                }
            }
            System.out.println();
        }
    }

    void displayFriends(int userId) {
        User user = getUserById(userId);
        if (user != null) {
            System.out.print("Friends of " + user.name + ": ");
            for (int friendId : user.getFriendList()) {
                System.out.print(friendId + " ");
            }
            System.out.println();
        }
    }

    void searchUser(String query) {
        User temp = head;
        while (temp != null) {
            if (temp.name.equalsIgnoreCase(query) || String.valueOf(temp.userId).equals(query)) {
                System.out.println("User found: ID=" + temp.userId + ", Name=" + temp.name + ", Age=" + temp.age);
                return;
            }
            temp = temp.next;
        }
        System.out.println("User not found.");
    }

    void countFriendsForAllUsers() {
        User temp = head;
        while (temp != null) {
            int count = temp.getFriendList().size();
            System.out.println("User " + temp.name + " has " + count + " friend(s).");
            temp = temp.next;
        }
    }
}

public class SocialMediaApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SocialNetwork network = new SocialNetwork();

        while (true) {
            System.out.println("\n--- Social Media Menu ---");
            System.out.println("1. Add User");
            System.out.println("2. Add Friend Connection");
            System.out.println("3. Remove Friend Connection");
            System.out.println("4. Display Friends of User");
            System.out.println("5. Search User by Name or ID");
            System.out.println("6. Find Mutual Friends");
            System.out.println("7. Count Friends for All Users");
            System.out.println("0. Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("User ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Age: ");
                    int age = sc.nextInt();
                    network.addUser(id, name, age);
                    break;

                case 2:
                    System.out.print("Enter User ID 1: ");
                    int uid1 = sc.nextInt();
                    System.out.print("Enter User ID 2: ");
                    int uid2 = sc.nextInt();
                    network.addFriendConnection(uid1, uid2);
                    break;

                case 3:
                    System.out.print("Enter User ID 1: ");
                    uid1 = sc.nextInt();
                    System.out.print("Enter User ID 2: ");
                    uid2 = sc.nextInt();
                    network.removeFriendConnection(uid1, uid2);
                    break;

                case 4:
                    System.out.print("Enter User ID: ");
                    int userId = sc.nextInt();
                    network.displayFriends(userId);
                    break;

                case 5:
                    System.out.print("Enter Name or ID to Search: ");
                    String query = sc.nextLine();
                    network.searchUser(query);
                    break;

                case 6:
                    System.out.print("Enter User ID 1: ");
                    uid1 = sc.nextInt();
                    System.out.print("Enter User ID 2: ");
                    uid2 = sc.nextInt();
                    network.findMutualFriends(uid1, uid2);
                    break;

                case 7:
                    network.countFriendsForAllUsers();
                    break;

                case 0:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}



