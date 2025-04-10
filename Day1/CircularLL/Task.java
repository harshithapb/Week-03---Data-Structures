package CircularLL;

import java.util.Scanner;

public class Task {
    int taskid;
    String taskname;
    int priority;
    String dueDate;
    Task next;
    public Task(int taskId, String taskName, int priority, String dueDate) {
        this.taskid = taskId;
        this.taskname = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}
class TaskScheduler {
    private Task head = null;
    private Task current = null;

    public void addAtBeginning(Task newTask) {
        if (head == null) {
            head = newTask;
            head.next = head;
            current = head;
        } else {
            Task temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            newTask.next = head;
            temp.next = newTask;
            head = newTask;
        }
    }

    public void addAtEnd(Task newTask) {
        if (head == null) {
            addAtBeginning(newTask);
            return;
        }
        Task temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }
        temp.next = newTask;
        newTask.next = head;
    }

    public void addAtPosition(Task newTask, int position) {
        if (position <= 1 || head == null) {
            addAtBeginning(newTask);
            return;
        }

        Task temp = head;
        for (int i = 1; i < position - 1 && temp.next != head; i++) {
            temp = temp.next;
        }

        newTask.next = temp.next;
        temp.next = newTask;
    }
    public void removeById(int taskId) {
        if (head == null) {
            System.out.println("Task list is empty.");
            return;
        }

        Task temp = head, prev = null;


        if (head.taskid == taskId) {
            if (head.next == head) {
                head = null;
                current = null;
                System.out.println("Task removed.");
                return;
            }

            Task last = head;
            while (last.next != head) {
                last = last.next;
            }
            head = head.next;
            last.next = head;
            System.out.println("Task removed.");
            return;
        }

        do {
            prev = temp;
            temp = temp.next;
            if (temp.taskid == taskId) {
                prev.next = temp.next;
                System.out.println("Task removed.");
                return;
            }
        } while (temp != head);

        System.out.println("Task not found.");
    }


    public void viewCurrentTask() {
        if (current == null) {
            System.out.println("No tasks scheduled.");
            return;
        }
        System.out.println("Current Task:");
        displayTask(current);
        current = current.next;
    }


    public void displayAllTasks() {
        if (head == null) {
            System.out.println("No tasks to display.");
            return;
        }

        Task temp = head;
        do {
            displayTask(temp);
            temp = temp.next;
        } while (temp != head);
    }

    public void searchByPriority(int priority) {
        if (head == null) {
            System.out.println("No tasks to search.");
            return;
        }

        boolean found = false;
        Task temp = head;
        do {
            if (temp.priority == priority) {
                displayTask(temp);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found) {
            System.out.println("No tasks with the given priority found.");
        }
    }

    private void displayTask(Task task) {
        System.out.println("Task ID: " + task.taskid);
        System.out.println("Task Name: " + task.taskname);
        System.out.println("Priority: " + task.priority);
        System.out.println("Due Date: " + task.dueDate);
    }
}
class CircularLinkedListTaskScheduler {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TaskScheduler scheduler = new TaskScheduler();

        while (true) {
            System.out.println("\nTask Scheduler Menu:");
            System.out.println("1. Add Task at Beginning");
            System.out.println("2. Add Task at End");
            System.out.println("3. Add Task at Position");
            System.out.println("4. Remove Task by ID");
            System.out.println("5. View Current Task and Move to Next");
            System.out.println("6. Display All Tasks");
            System.out.println("7. Search Task by Priority");
            System.out.println("8. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                case 2:
                case 3: {
                    System.out.print("Enter Task ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Task Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Priority: ");
                    int priority = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Due Date: ");
                    String date = sc.nextLine();
                    Task task = new Task(id, name, priority, date);

                    if (choice == 1) scheduler.addAtBeginning(task);
                    else if (choice == 2) scheduler.addAtEnd(task);
                    else {
                        System.out.print("Enter Position: ");
                        int pos = sc.nextInt();
                        scheduler.addAtPosition(task, pos);
                    }
                    break;
                }

                case 4:
                    System.out.print("Enter Task ID to Remove: ");
                    int removeId = sc.nextInt();
                    scheduler.removeById(removeId);
                    break;

                case 5:
                    scheduler.viewCurrentTask();
                    break;

                case 6:
                    scheduler.displayAllTasks();
                    break;

                case 7:
                    System.out.print("Enter Priority to Search: ");
                    int searchPriority = sc.nextInt();
                    scheduler.searchByPriority(searchPriority);
                    break;

                case 8:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}

