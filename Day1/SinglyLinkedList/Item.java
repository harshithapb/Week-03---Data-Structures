package SinglyLinkedList;
import java.util.Scanner;

public class Item {
    String itemName;
    int itemId;
    int quantity;
    double price;
    Item next;

    public Item(String itemName, int itemId, int quantity, double price) {
        this.itemName = itemName;
        this.itemId = itemId;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}

class Inventory {
    private Item head = null;

    public void addAtBeginning(Item newItem) {
        newItem.next = head;
        head = newItem;
    }

    public void addAtEnd(Item newItem) {
        if (head == null) {
            head = newItem;
            return;
        }
        Item temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newItem;
    }

    public void addAtPosition(Item newItem, int position) {
        if (position <= 1 || head == null) {
            addAtBeginning(newItem);
            return;
        }

        Item temp = head;
        for (int i = 1; i < position - 1 && temp.next != null; i++) {
            temp = temp.next;
        }

        newItem.next = temp.next;
        temp.next = newItem;
    }

    public void removeById(int id) {
        if (head == null) {
            System.out.println("Inventory is empty.");
            return;
        }

        if (head.itemId == id) {
            head = head.next;
            System.out.println("Item removed.");
            return;
        }

        Item temp = head;
        while (temp.next != null && temp.next.itemId != id) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Item not found.");
        } else {
            temp.next = temp.next.next;
            System.out.println("Item removed.");
        }
    }
    public void updateQuantity(int id, int newQuantity) {
        Item temp = head;
        while (temp != null) {
            if (temp.itemId == id) {
                temp.quantity = newQuantity;
                System.out.println("Quantity updated.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found.");
    }

    public void searchItem(String keyword) {
        Item temp = head;
        boolean found = false;
        while (temp != null) {
            if (String.valueOf(temp.itemId).equals(keyword) || temp.itemName.equalsIgnoreCase(keyword)) {
                displayItem(temp);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) {
            System.out.println("No item found.");
        }
    }
    public void totalInventoryValue() {
        double total = 0;
        Item temp = head;
        while (temp != null) {
            total += temp.price * temp.quantity;
            temp = temp.next;
        }
        System.out.println("Total Inventory Value: $" + total);
    }

    public void displayAll() {
        if (head == null) {
            System.out.println("Inventory is empty.");
            return;
        }
        Item temp = head;
        while (temp != null) {
            displayItem(temp);
            temp = temp.next;
        }
    }

    public void sortInventory(String key, boolean ascending) {
        head = mergeSort(head, key, ascending);
        System.out.println("Inventory sorted by " + key + " (" + (ascending ? "Ascending" : "Descending") + ")");
    }


    private void displayItem(Item item) {
        System.out.println("ID: " + item.itemId);
        System.out.println("Name: " + item.itemName);
        System.out.println("Quantity: " + item.quantity);
        System.out.println("Price: $" + item.price);
    }
    private Item mergeSort(Item head, String key, boolean ascending) {
        if (head == null || head.next == null) return head;

        Item middle = getMiddle(head);
        Item nextOfMiddle = middle.next;
        middle.next = null;

        Item left = mergeSort(head, key, ascending);
        Item right = mergeSort(nextOfMiddle, key, ascending);

        return sortedMerge(left, right, key, ascending);
    }

    private Item getMiddle(Item head) {
        if (head == null) return head;
        Item slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private Item sortedMerge(Item a, Item b, String key, boolean asc) {
        if (a == null) return b;
        if (b == null) return a;

        int comp;
        if (key.equals("name")) {
            comp = a.itemName.compareToIgnoreCase(b.itemName);
        } else {
            comp = Double.compare(a.price, b.price);
        }

        if ((asc && comp <= 0) || (!asc && comp > 0)) {
            a.next = sortedMerge(a.next, b, key, asc);
            return a;
        } else {
            b.next = sortedMerge(a, b.next, key, asc);
            return b;
        }
    }
}

class InventorySystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Inventory inventory = new Inventory();

        while (true) {
            System.out.println("\nInventory Menu:");
            System.out.println("1. Add Item (Beginning)");
            System.out.println("2. Add Item (End)");
            System.out.println("3. Add Item (Position)");
            System.out.println("4. Remove Item by ID");
            System.out.println("5. Update Item Quantity");
            System.out.println("6. Search Item (by ID/Name)");
            System.out.println("7. Display All Items");
            System.out.println("8. Total Inventory Value");
            System.out.println("9. Sort Inventory");
            System.out.println("10. Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                case 2:
                case 3: {
                    System.out.print("Enter Item ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Item Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Quantity: ");
                    int qty = sc.nextInt();
                    System.out.print("Enter Price: ");
                    double price = sc.nextDouble();
                    Item item = new Item(name, id, qty, price);
                    if (choice == 1) inventory.addAtBeginning(item);
                    else if (choice == 2) inventory.addAtEnd(item);
                    else {
                        System.out.print("Enter Position: ");
                        int pos = sc.nextInt();
                        inventory.addAtPosition(item, pos);
                    }
                    break;
                }
                case 4:
                    System.out.print("Enter Item ID to remove: ");
                    int removeId = sc.nextInt();
                    inventory.removeById(removeId);
                    break;
                case 5:
                    System.out.print("Enter Item ID to update quantity: ");
                    int updateId = sc.nextInt();
                    System.out.print("Enter new quantity: ");
                    int newQty = sc.nextInt();
                    inventory.updateQuantity(updateId, newQty);
                    break;
                case 6:
                    System.out.print("Enter Item ID or Name to search: ");
                    String keyword = sc.nextLine();
                    inventory.searchItem(keyword);
                    break;
                case 7:
                    inventory.displayAll();
                    break;
                case 8:
                    inventory.totalInventoryValue();
                    break;
                case 9:
                    System.out.print("Sort by 'name' or 'price': ");
                    String key = sc.nextLine().toLowerCase();
                    System.out.print("Sort ascending (true/false): ");
                    boolean asc = sc.nextBoolean();
                    inventory.sortInventory(key, asc);
                    break;
                case 10:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}

